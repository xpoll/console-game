package cn.blmdz.game.console.model;

import lombok.Getter;

/**
 * 方块坐标
 */
@Getter
public class Cube {
	private Integer x;
	private Integer y;

	Cube () {}

	/**
	 * 构建
	 */
	public static Cube buildCube (int x, int y) {
		Cube cube = new Cube();
		cube.x = x;
		cube.y = y;
		return cube;
	}
}
