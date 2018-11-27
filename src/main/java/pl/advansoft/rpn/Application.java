package pl.advansoft.rpn;

import java.util.List;

public class Application {

	private Application() {
	}

	private static final Application INSTANCE = new Application();

	public static Application getInstance() {
		return INSTANCE;
	}

	private RpnCalculator calculator = new RpnCalculator();

	public void run(String[] args) {
		if (args.length == 0) {
			System.out.println("This application requires one parameter\nNone has been provided");
			return;
		}

		try {
			int result = calculate(args[0]);
			System.out.println("The result is: " + result);
		} catch (RpnException e) {
			System.out.println("Wrong input information");
		}
	}

	int calculate(String text) {
		String[] strings = Utils.split(text);
		List<Value> values = Utils.asValues(strings);
		calculator.putList(values);
		return calculator.getResult();
	}

	public static void main(String[] args) {
		getInstance().run(args);
	}
}
