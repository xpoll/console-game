package cn.blmdz.game.console.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

/**
 * 方块模型
 */
@Getter
public class CubeModel {

	private Integer up = 0;
	private Integer down = 0;
	private Integer left = 0;
	private Integer right = 0;
	private Integer num = 0;
	
	private List<Cube> cubes;
	
	CubeModel () {}
	
	/**
	 * 构建
	 */
	public static CubeModel buildCubeModel (Cube ... cube) {
		if (cube == null || cube.length == 0) {
			throw new RuntimeException("at least one cube.");
		}
		CubeModel model = new CubeModel();
		List<Cube> list = Arrays.asList(cube);
		// 去重 
		Set<String> exist = new HashSet<>();
		model.cubes = new ArrayList<Cube>();
		list.forEach(item -> {
			if (exist.add(String.valueOf(item.getX()) + item.getY())) {
				model.cubes.add(item);
				
				if (item.getX() < model.left) {
					model.left = item.getX();
				}
				if (item.getX() > model.right) {
					model.right = item.getX();
				}
	
				if (item.getY() < model.up) {
					model.up = item.getY();
				}
				if (item.getY() > model.down) {
					model.down = item.getY();
				}
			}
		});
		model.num = exist.size();
		exist.clear();
		return model;
	}
}
