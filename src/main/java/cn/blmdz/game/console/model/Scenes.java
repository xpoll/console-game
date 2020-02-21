package cn.blmdz.game.console.model;

import cn.blmdz.game.console.enums.Color;
import cn.blmdz.game.console.enums.DisplayContent;
import lombok.Getter;

/**
 * 地图像素
 */
@Getter
public class Scenes {
	private Integer x;
	private Integer y;
	/** 渲染 */
	private DisplayContent display;
	/** 可碰撞 */
	private Boolean collision;
	/** 替换后的内容 */
	private String content;
	/** 颜色 */
	private Color color;

	Scenes () {}

	public static Scenes buildScenes (int x, int y, DisplayContent display) {
		return buildScenes(x, y, display, false, Color.C_40_37, null);
	}
	public static Scenes buildScenes (int x, int y, DisplayContent display, Color color) {
		return buildScenes(x, y, display, false, color, null);
	}
	public static Scenes buildScenes (int x, int y, DisplayContent display, String content) {
		return buildScenes(x, y, display, false, Color.C_40_37, content);
	}
	public static Scenes buildScenes (int x, int y, DisplayContent display, Boolean collision) {
		return buildScenes(x, y, display, collision, Color.C_40_37, null);
	}
	public static Scenes buildScenes (int x, int y, DisplayContent display, Boolean collision, Color color) {
		return buildScenes(x, y, display, collision, color, null);
	}
	public static Scenes buildScenes (int x, int y, DisplayContent display, Boolean collision, String content) {
		return buildScenes(x, y, display, collision, Color.C_40_37, content);
	}

	/**
	 * 构建
	 */
	public static Scenes buildScenes (int x, int y, DisplayContent display, Boolean collision, Color color, String content) {
		Scenes scenes = new Scenes();
		scenes.x = x;
		scenes.y = y;
		scenes.display = display;
		scenes.collision = collision;
		scenes.content = content;
		if (color == null) {
			scenes.color = Color.C_40_37;
		} else {
			scenes.color = color;
		}
		return scenes;
	}
}
