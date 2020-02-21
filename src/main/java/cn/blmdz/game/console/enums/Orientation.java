package cn.blmdz.game.console.enums;

import java.util.Objects;

/**
 * 按键监控指令
 */
public enum Orientation {
	UP(38),
	DOWN(40),
	LEFt(37),
	RIGHT(39),
	SPACE(32),
	ENTER(13),
	START(83),
	PAUSE(80),
	RESET(82),
	;
	public int value;
	
	Orientation (int value) {
		this.value = value;
	}
	
	public static Orientation conversion (int value) {
		for (Orientation item : Orientation.values()) {
			if (Objects.equals(value, item.value)) {
				return item;
			}
		}
		return null;
	}
}
