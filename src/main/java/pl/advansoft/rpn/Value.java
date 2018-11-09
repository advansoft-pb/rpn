package pl.advansoft.rpn;

public class Value {

	private String str;

	public Value(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public int getInt() {
		return Integer.parseInt(str);
	}

	public boolean isNumber() {
		return str.matches("[0-9]+");
	}

	public boolean isOperator() {
		return "+".equals(str) || "-".equals(str);
	}

	public Operator operator() {
		if ("+".equals(str)) {
			return Operator.PLUS;
		}

		if ("-".equals(str)) {
			return Operator.MINUS;
		}

		return null;
	}
}
