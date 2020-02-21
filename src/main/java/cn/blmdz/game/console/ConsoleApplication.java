package cn.blmdz.game.console;

import cn.blmdz.game.console.control.KeyboardControl;
import cn.blmdz.game.console.hook.CanvasHook;
import cn.blmdz.game.console.hook.KeyboardHook;
import cn.blmdz.game.console.scenes.TetrisScenes;
import cn.blmdz.game.console.template.CubeTemplate;

public class ConsoleApplication {

	public static void main(String[] args) throws InterruptedException {
		if (args != null && args.length != 0) {
			CanvasHook.cmd = false;
		}

//		CanvasHook.contents.add("＿＿＿＿＿＿＿＿＿＿＿");
//		CanvasHook.contents.add("|　　　　　　　　　　|");
//		CanvasHook.contents.add("|　　　　　　　　　　|　Max");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　①②③④⑤⑥");
//		CanvasHook.contents.add("|　　　　　　　　　　|");
//		CanvasHook.contents.add("|　　　　　　　　　　|");
//		CanvasHook.contents.add("|　　　　　　　　　　|　StartLine");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　①②③④⑤⑥");
//		CanvasHook.contents.add("|　　〇〇　　　　　　|");
//		CanvasHook.contents.add("|　　〇　　　　　　　|");
//		CanvasHook.contents.add("|　　〇　　　　　　　|　Level");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　①②③④⑤⑥");
//		CanvasHook.contents.add("|　　　〇〇　　　　　|");
//		CanvasHook.contents.add("|　　　　〇〇　　　　|");
//		CanvasHook.contents.add("|　　　　　　　　　　|　Next");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　〇〇〇〇");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　〇〇〇〇");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　〇〇〇〇");
//		CanvasHook.contents.add("|　　　　　　　　　　|　　〇〇〇〇");
//		CanvasHook.contents.add("|　　　　　　　　　　|");
//		CanvasHook.contents.add("|　　　　　　　　　　|　暂停　02:23");
//		CanvasHook.contents.add("￣￣￣￣￣￣￣￣￣￣￣");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 40, 31) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 40, 31) + "你好啊" + String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 41, 32) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 42, 33) + "你　啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 43, 34) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 44, 35) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 45, 36) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 46, 37) + "你好啊");
//		CanvasHook.contents.add(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 47, 38) + "你好啊");
		TetrisScenes tetrisScenes = new TetrisScenes(new CubeTemplate());
		CanvasHook.contents.addAll(tetrisScenes.toDisplayShow());

		CanvasHook.refreshCanvas();
		
		keyboardInit();
	}

	
	/**
	 * 键盘初始化
	 */
	public static void keyboardInit () {
		KeyboardHook keyboardHook = new KeyboardHook() {
			@Override
			public void keyBoardCallback(int keyCode, int eventType) {
//				System.out.println(keyCode + ", " + eventType);
				if ((eventType == 1 && keyCode >=37 && keyCode <= 40) // 方向键
						||
						(eventType == 0 && (keyCode == 32 || keyCode == 13)) // 空格和回车
						||
						(eventType == 0 && (keyCode == 83 || keyCode == 80 || keyCode == 82)) // 开始/暂停/重置
						) {
					KeyboardControl.chooseOrientation(keyCode);
				}
			}
		};
		keyboardHook.run();
	}

}
