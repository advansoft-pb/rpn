package pl.advansoft.rpn;

public class Value {

	private String str;

	public Value(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public int getInt() throws RpnException {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new RpnException(e);
		}
	}

	public boolean isNumber() {
		return str.matches("[0-9]+");
	}

	public boolean isOperator() {
		for (Operator op : Operator.values()) {
			if (op.mark(str)) {
				return true;
			}
		}

		return false;
	}

	public Operator operator() {
		for (Operator op : Operator.values()) {
			if (op.mark(str)) {
				return op;
			}
		}

		return null;
	}
}
