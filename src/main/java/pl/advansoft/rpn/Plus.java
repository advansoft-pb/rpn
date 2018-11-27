package pl.advansoft.rpn;

public class Plus extends Operator {

	private Plus() {
		super();
	}

	private static final Plus instance = new Plus();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(String m) {
		return "+".equals(m);
	}

	@Override
	public int calc(int a, int b) {
		return a + b;
	}
}
