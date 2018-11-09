package pl.advansoft.rpn;

public enum Operator {

	PLUS("+") {
		@Override
		public int calc(int a, int b) {
			return a + b;
		}
	},

	MINUS("-") {
		@Override
		public int calc(int a, int b) {
			return a - b;
		}
	};

	private Operator(String mark) {
		this.mark = mark;
	}

	private String mark;

	public boolean mark(String m) {
		return mark.equals(m);
	}

	public abstract int calc(int a, int b);
}
