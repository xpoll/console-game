package cn.blmdz.game.console.scenes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import cn.blmdz.game.console.enums.Color;
import cn.blmdz.game.console.enums.DisplayContent;
import cn.blmdz.game.console.model.Cube;
import cn.blmdz.game.console.model.CubeModel;
import cn.blmdz.game.console.model.Scenes;
import cn.blmdz.game.console.template.CubeTemplate;
import lombok.Getter;
import lombok.Setter;

public class TetrisScenes {

	private CubeTemplate cubeTemplate;
	
	@Getter
	private List<List<Scenes>> scenes = new ArrayList<>();
	@Setter
	private int max = 0;
	@Setter
	private int startLine = 0;
	@Setter
	private int level = 1;
	@Setter
	private int time = 0;
	@Setter
	private boolean pause = false;
	@Setter
	private int next = 0;
	
	public void init () {
		List<Scenes> line = null;
		
		// 基本框架
		// 第1行
		line = new ArrayList<>();
		for (int i = 1; i <= 11; i++) {
			line.add(Scenes.buildScenes(1, i, DisplayContent.WALL_DOWN_SIDE));
		}
		scenes.add(line);

		// 第2 - 21行
		for (int j = 2; j <= 21; j++) {
			line = new ArrayList<>();
			line.add(Scenes.buildScenes(j, 1, DisplayContent.WALL_LEFT_SIDE));
			for (int i = 2; i <= 11; i++) {
				line.add(Scenes.buildScenes(j, i, DisplayContent.SPACE, true));
			}
			line.add(Scenes.buildScenes(j, 12, DisplayContent.WALL_RIGHT_SIDE));
			scenes.add(line);
		}
		
		// 第22行
		line = new ArrayList<>();
		for (int i = 1; i <= 11; i++) {
			line.add(Scenes.buildScenes(22, i, DisplayContent.WALL_UP_SIDE));
		}
		scenes.add(line);
		
		// 增加分数等元素
		// 03 max
		scenes.get(2).add(Scenes.buildScenes(2, 13, DisplayContent.SHOW_MAX));
		// 04 max value
		scenes.get(3).add(Scenes.buildScenes(3, 13, DisplayContent.SHOW_NUM, String.format(DisplayContent.SHOW_NUM.value, max)));
		// 07 startline
		scenes.get(6).add(Scenes.buildScenes(6, 13, DisplayContent.SHOW_STARTLINE));
		// 08 startline value
		scenes.get(7).add(Scenes.buildScenes(7, 13, DisplayContent.SHOW_NUM, String.format(DisplayContent.SHOW_NUM.value, startLine)));
		// 11 level
		scenes.get(10).add(Scenes.buildScenes(10, 13, DisplayContent.SHOW_LEVEL));
		// 12 level value
		scenes.get(11).add(Scenes.buildScenes(11, 13, DisplayContent.SHOW_NUM, String.format(DisplayContent.SHOW_NUM.value, level)));
		// 15 next
		scenes.get(14).add(Scenes.buildScenes(14, 13, DisplayContent.SHOW_NEXT));
		// 21 time
		DisplayContent displayContent = pause ? DisplayContent.SHOW_TIME_1 : DisplayContent.SHOW_TIME_2;
		scenes.get(20).add(Scenes.buildScenes(20, 13, displayContent, String.format(displayContent.value, time % 60, time / 60)));
		
		/*
		 * 增加 Next方块
		 * 16 1
		 * 17 2
		 * 18 3
		 * 19 4
		 */
		next = ThreadLocalRandom.current().nextInt(cubeTemplate.getCubeModels().size());
		System.out.println("next: " + next);
		CubeModel cubeModel = cubeTemplate.getCubeModels().get(next);
		cubeModel.getCubes().sort((a, b) -> (a.getX() > b.getX() && a.getY() > b.getY()) ? -1 : 1);
		cubeModel.getCubes().forEach(item -> {
			// 增加方块前间隔
			if (scenes.get(14 + item.getX()).size() == 12) scenes.get(14 + item.getX()).add(Scenes.buildScenes(14 + item.getX(), 13, DisplayContent.SHOW_SPACE_TWO));
			// 增加 Next 里面方块的点像素
			addPoint(14 + item.getX(), scenes.get(14 + item.getX()), item);
		});
		
	}
	/**
	 * 增加 Next 里面方块的点像素
	 */
	private void addPoint (Integer line, List<Scenes> scenes, Cube cube) {
		int i = cube.getY() - (scenes.size() - 13) - 1;
		switch (i) {
		case 0:
			scenes.add(Scenes.buildScenes(line, scenes.size() + 0, DisplayContent.ENTITY, Color.C_40_31));
			break;
		case 1:
			scenes.add(Scenes.buildScenes(line, scenes.size() + 0, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 1, DisplayContent.ENTITY, Color.C_40_31));
			break;
		case 2:
			scenes.add(Scenes.buildScenes(line, scenes.size() + 0, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 1, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 2, DisplayContent.ENTITY, Color.C_40_31));
			break;
		case 3:
			scenes.add(Scenes.buildScenes(line, scenes.size() + 0, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 1, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 2, DisplayContent.SPACE, true));
			scenes.add(Scenes.buildScenes(line, scenes.size() + 3, DisplayContent.ENTITY, Color.C_40_31));
			break;
		}
	}
	
	/**
	 * 像素转 String 行字符
	 */
	public List<String> toDisplayShow () {
		List<String> strs = new ArrayList<>();
		
		StringBuffer sb = new StringBuffer();
		scenes.forEach(item -> {
			sb.setLength(0);
			item.forEach(pixel -> {
				switch (pixel.getDisplay()) {
				case SHOW_NUM:
				case SHOW_TIME_1:
				case SHOW_TIME_2:
					sb.append(pixel.getColor().value + pixel.getContent());
					break;
				default:
					sb.append(pixel.getColor().value + pixel.getDisplay().value);
					break;
				}
			});
			strs.add(sb.toString());
		});
		sb.setLength(0);
		return strs;
	}
	
	public TetrisScenes (CubeTemplate cubeTemplate) {
		this.cubeTemplate = cubeTemplate;
		/*
		 * 01＿＿＿＿＿＿＿＿＿＿＿
		 * 02|　　　　　　　　　　|
		 * 03|　　　　　　　　　　|　Max
		 * 04|　　　　　　　　　　|　　①②③④⑤⑥
		 * 05|　　　　　　　　　　|
		 * 06|　　　　　　　　　　|
		 * 07|　　　　　　　　　　|　StartLine
		 * 08|　　　　　　　　　　|　　①②③④⑤⑥
		 * 09|　　〇〇　　　　　　|
		 * 10|　　〇　　　　　　　|
		 * 11|　　〇　　　　　　　|　Level
		 * 12|　　　　　　　　　　|　　①②③④⑤⑥
		 * 13|　　　〇〇　　　　　|
		 * 14|　　　　〇〇　　　　|
		 * 15|　　　　　　　　　　|　Next
		 * 16|　　　　　　　　　　|　　〇〇〇〇
		 * 17|　　　　　　　　　　|　　〇〇〇〇
		 * 18|　　　　　　　　　　|　　〇〇〇〇
		 * 19|　　　　　　　　　　|　　〇〇〇〇
		 * 20|　　　　　　　　　　|
		 * 21|　　　　　　　　　　|　暂停　02:23
		 * 22￣￣￣￣￣￣￣￣￣￣￣
		 */
		this.init ();
	}
	
	
}
