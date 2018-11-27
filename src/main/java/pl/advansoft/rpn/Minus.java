package pl.advansoft.rpn;

public class Minus extends Operator {

	private Minus() {
		super();
	}

	private static final Minus instance = new Minus();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(String m) {
		return "-".equals(m);
	}

	@Override
	public int calc(int a, int b) {
		return a - b;
	}
}
