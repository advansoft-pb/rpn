package pl.advansoft.rpn;

import java.util.List;

public class Application {

	private Application() {
	}

	private static Application INSTANCE = new Application();

	public static Application getInstance() {
		return INSTANCE;
	}

	private RpnCalculator calculator = new RpnCalculator();

	public void run(String[] args) {
		if (args.length == 0) {
			System.out.println("This application requires one parameter\nNone was provided");
			return;
		}

		calculator.clear();
		String[] strings = Utils.split(args[0]);
		List<Value> values = Utils.asValues(strings);

		try {
			calculator.putList(values);
			int result = calculator.getResult();
			System.out.println("The result is: " + result);
		} catch (RpnException e) {
			System.out.println("Wrong input information");
		}
	}

	public static void main(String[] args) {
		getInstance().run(args);
	}
}
