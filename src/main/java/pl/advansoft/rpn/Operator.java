package pl.advansoft.rpn;

public enum Operator {

	PLUS('+') {
		@Override
		public Integer calc(int a, int b) {
			return a + b;
		}
	},

	MINUS('-') {
		@Override
		public Integer calc(int a, int b) {
			return a - b;
		}
	};

	private Operator(char c) {
		this.m = c;
	}

	private char m;

	public boolean mark(char c) {
		return m == c;
	}

	public abstract Integer calc(int a, int b);
}
