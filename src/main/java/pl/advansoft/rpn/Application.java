package pl.advansoft.rpn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

	public static void main(String[] args) {
		new Application().run(args);
	}

	private TextProvider textProvider;

	public void run(String[] args) {
		if (args.length == 0) {
			System.out.println("This application requires one parameter\nNone has been provided");
			return;
		}

		textProvider = new SimpleTextProvider(args[0]);

		String text = textProvider.getText();

		String[] strings = text.split("\\s+");
		List<Value> values = Stream.of(strings).map(Value::new).collect(Collectors.toList());

		try {
			int result = RpnCalculator.calculate(values);
			System.out.println("The result is: " + result);
		} catch (RpnException e) {
			System.out.println("Wrong input information");
		}
	}
}
