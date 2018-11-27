package pl.advansoft.rpn;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RpnCalculator {

	private Stack<Value> valueStack = new Stack<>();

	private void clear() {
		valueStack.clear();
	}

	private void putList(List<Value> values) throws RpnException {
		clear();

		try {
			putListByIterator(values.iterator());
		} catch (Exception e) {
			throw new RpnException(e);
		}
	}

	private void putListByIterator(Iterator<Value> iterator) {
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
	}

	private int getResult() throws RpnException {
		try {
			return valueStack.pop().getInt();
		} catch (Exception e) {
			throw new RpnException(e);
		}
	}

	public int calculate(List<Value> values) throws RpnException {
		putList(values);
		return getResult();
	}
}
