package cn.blmdz.game.console.enums;

public enum Color {
	C_40_31(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 40, 31)),
	C_40_37(String.format(Instruction.CMD__S_BACKGROUND_FONT.value, 40, 37)),
	;
	public String value;
	
	Color (String value) {
		this.value = value;
	}

}
