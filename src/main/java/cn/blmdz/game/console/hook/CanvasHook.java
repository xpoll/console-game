package cn.blmdz.game.console.hook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import cn.blmdz.game.console.enums.Instruction;

/**
 * 画布
 */
public class CanvasHook {
	public final static List<String> contents = new ArrayList<String>();
	
	public static boolean cmd = true;

	public static void refreshCanvas () {
		if (cmd) cmdClean();
		else eclipseClean ();
        
		for (String str : contents) {
			System.out.println(str + Instruction.CMD_0.value);
		}
		System.out.println(Instruction.CMD_0.value);
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public static void eclipseClean () {
		try {
			Robot r = new Robot();
			r.mousePress(InputEvent.BUTTON3_MASK);       // 按下鼠标右键
			r.mouseRelease(InputEvent.BUTTON3_MASK);    // 释放鼠标右键
			r.keyPress(KeyEvent.VK_CONTROL);             // 按下Ctrl键
			r.keyPress(KeyEvent.VK_R);                    // 按下R键
			r.keyRelease(KeyEvent.VK_R);                  // 释放R键
			r.keyRelease(KeyEvent.VK_CONTROL);            // 释放Ctrl键
			r.delay(10);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void cmdClean () {
		System.out.print(Instruction.CMD_J.value);
		System.out.print(Instruction.CMD_l.value);
	}
}
