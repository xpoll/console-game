package cn.blmdz.game.console.enums;

/**
 * 场景元素
 */
public enum DisplayContent {
	WALL_DOWN_SIDE("＿"),
	WALL_UP_SIDE("￣"),
	WALL_LEFT_SIDE("|"),
	WALL_RIGHT_SIDE("|"),
	SPACE("　"),
	ENTITY("口"),
	SHOW_MAX("　Max"),
	SHOW_STARTLINE("　StartLine"),
	SHOW_LEVEL("　Level"),
	SHOW_NEXT("　Next"),
	SHOW_TIME_1("　暂停　%s:%s"),
	SHOW_TIME_2("　　　　%s:%s"),
	SHOW_NUM("　　%s"),
	SHOW_SPACE_TWO("　　"),
	TEST("洛"),
	;
	public String value;
	
	DisplayContent (String value) {
		this.value = value;
	}
}
