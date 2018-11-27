package pl.advansoft.rpn;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RpnCalculator {

	private Stack<Value> valueStack = new Stack<>();

	private void clear() {
		valueStack.clear();
	}

	public void putList(List<Value> values) {
		clear();

		try {
			putListByIterator(values.iterator());
		} catch (Exception e) {
			throw new RpnException(e);
		}
	}

	void putListByIterator(Iterator<Value> iterator) {
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

	public int getResult() {
		try {
			return valueStack.pop().getInt();
		} catch (Exception e) {
			throw new RpnException(e);
		}
	}
}
