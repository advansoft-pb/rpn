package pl.advansoft.rpn;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RpnCalculatorTest {

	private RpnCalculator calculator = new RpnCalculator();

	@Test
	public void testCalc3() {
		List<Value> param = new ArrayList<>();
		param.add(new Value("1"));
		param.add(new Value("2"));
		param.add(new Value("+"));

		calculator.putList(param);
		int result = calculator.getResult();
		assertEquals(3, result);
	}

	@Test
	public void testCalcM1() {
		List<Value> param = new ArrayList<>();
		param.add(new Value("2"));
		param.add(new Value("2"));
		param.add(new Value("1"));
		param.add(new Value("+"));
		param.add(new Value("-"));

		calculator.putList(param);
		int result = calculator.getResult();
		assertEquals(-1, result);
	}

	@Test
	public void testCalc46240() {
		List<Value> param = new ArrayList<>();
		param.add(new Value("2342"));
		param.add(new Value("43563"));
		param.add(new Value("123"));
		param.add(new Value("+"));
		param.add(new Value("+"));
		param.add(new Value("234"));
		param.add(new Value("22"));
		param.add(new Value("-"));
		param.add(new Value("+"));

		calculator.putList(param);
		int result = calculator.getResult();
		assertEquals(46240, result);
	}

	@Test(expected = RpnException.class)
	public void testCalcEx() {
		List<Value> param = new ArrayList<>();
		param.add(new Value("+"));
		param.add(new Value("43"));
		param.add(new Value("1"));

		calculator.putList(param);
	}

	private Application app = Application.getInstance();

	@Test
	public void testApp298() {
		assertEquals(298, app.calculate("234 87 + 23 -"));
	}

	@Test(expected = RpnException.class)
	public void testAppEx() {
		app.calculate("-");
	}
}
