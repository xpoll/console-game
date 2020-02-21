package cn.blmdz.game.console.template;

import java.util.ArrayList;
import java.util.List;

import cn.blmdz.game.console.model.Cube;
import cn.blmdz.game.console.model.CubeModel;
import lombok.Getter;

/**
 * 方块样式模板
 */
public class CubeTemplate {

	@Getter
	private List<CubeModel> cubeModels = new ArrayList<>();
	
	public CubeTemplate () {
		/* 0
		 * 
		 * 口〇〇〇
		 * 〇〇〇〇
		 * 〇〇〇〇
		 * 〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1)));
		/* 1
		 * 
		 * 口口〇〇
		 * 口口〇〇
		 * 〇〇〇〇
		 * 〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(2, 1), Cube.buildCube(2, 2)));
		/* 2, 3
		 * 
		 * 口口口口  口〇〇〇
		 * 〇〇〇〇  口〇〇〇
		 * 〇〇〇〇  口〇〇〇
		 * 〇〇〇〇  口〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(1, 3), Cube.buildCube(1, 4)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(2, 1), Cube.buildCube(3, 1), Cube.buildCube(4, 1)));
		/* 4, 5
		 * 
		 * 〇口〇〇  口口〇〇
		 * 口口〇〇  〇口口〇
		 * 口〇〇〇  〇〇〇〇
		 * 〇〇〇〇  〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 2), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(3, 1)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(2, 2), Cube.buildCube(2, 3)));
		/* 6, 7, 8, 9
		 * 
		 * 口〇〇〇  〇口〇〇  口口口〇  〇口〇〇
		 * 口口〇〇  口口口〇  〇口〇〇  口口〇〇
		 * 口〇〇〇  〇〇〇〇  〇〇〇〇  〇口〇〇
		 * 〇〇〇〇  〇〇〇〇  〇〇〇〇  〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(3, 1)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 2), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(2, 3)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(1, 3), Cube.buildCube(2, 2)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 2), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(3, 2)));
		/* 10, 11, 12, 13
		 * 
		 * 口〇〇〇  口口〇〇  口口口〇  〇口〇〇
		 * 口口口〇  口〇〇〇  〇〇口〇  〇口〇〇
		 * 〇〇〇〇  口〇〇〇  〇〇〇〇  口口〇〇
		 * 〇〇〇〇  〇〇〇〇  〇〇〇〇  〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(2, 3)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(2, 1), Cube.buildCube(3, 1)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(1, 3), Cube.buildCube(2, 3)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 2), Cube.buildCube(2, 2), Cube.buildCube(3, 1), Cube.buildCube(3, 2)));
		/* 14, 15, 16, 17
		 * 〇〇口〇  口〇〇〇  口口口〇  口口〇〇
		 * 口口口〇  口〇〇〇  口〇〇〇  〇口〇〇
		 * 〇〇〇〇  口口〇〇  〇〇〇〇  〇口〇〇
		 * 〇〇〇〇  〇〇〇〇  〇〇〇〇  〇〇〇〇
		 */
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 3), Cube.buildCube(2, 1), Cube.buildCube(2, 2), Cube.buildCube(2, 3)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(2, 1), Cube.buildCube(3, 1), Cube.buildCube(3, 2)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(1, 3), Cube.buildCube(2, 1)));
		cubeModels.add(CubeModel.buildCubeModel(Cube.buildCube(1, 1), Cube.buildCube(1, 2), Cube.buildCube(2, 2), Cube.buildCube(3, 2)));
	}
	
}
