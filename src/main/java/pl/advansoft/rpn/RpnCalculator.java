package pl.advansoft.rpn;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RpnCalculator {
	public static int calculate(List<Value> values) throws RpnException {
		Stack<Value> valueStack = new Stack<>();

		Iterator<Value> iterator = values.iterator();
		while (iterator.hasNext()) {
			Value val = iterator.next();

			if (val.isNumber()) {
				valueStack.push(val);
			} else if (val.isOperator()) {
				int b = valueStack.pop().getInt();
				int a = valueStack.pop().getInt();
				int x = val.operator().calc(a, b);
				valueStack.push(new Value(String.valueOf(x)));
			}
		}

		return valueStack.pop().getInt();
	}
}
