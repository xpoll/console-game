package cn.blmdz.game.console.control;

import cn.blmdz.game.console.enums.Orientation;
import cn.blmdz.game.console.hook.CanvasHook;

public class KeyboardControl {
	static boolean pause = false;
	static int i = 2;

	public static void chooseOrientation (int keyCode) {
		if (pause && keyCode != Orientation.START.value) {
			return ;
		}
			
		Orientation orientation = Orientation.conversion(keyCode);
		switch (orientation) {
		case START: {
			pause = false;
			break;
		}
		case PAUSE: {
			pause = true;
			break;
		}
		case RESET: {
			break;
		}
		case UP: {
			if (i > 0) {
				String str = CanvasHook.contents.remove(i);
				i--;
				CanvasHook.contents.add(i, str);
			}
			break;
		}
		case DOWN: {
			if (i < (CanvasHook.contents.size() - 1)) {
				String str = CanvasHook.contents.remove(i);
				i++;
				CanvasHook.contents.add(i, str);
			}
			break;
		}
		default:
			break;
		}
		CanvasHook.refreshCanvas();
	}
}
