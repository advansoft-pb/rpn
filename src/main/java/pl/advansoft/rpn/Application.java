package pl.advansoft.rpn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		String[] strings = args[0].split("\\s+");
		List<Value> values = Stream.of(strings).map(Value::new).collect(Collectors.toList());

		try {
			int result = calculator.calculate(values);
			System.out.println("The result is: " + result);
		} catch (RpnException e) {
			System.out.println("Wrong input information");
		}
	}

	public static void main(String[] args) {
		getInstance().run(args);
	}
}
