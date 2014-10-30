package pt.pedrorijo91.utils.collections;

import java.util.HashMap;

import pt.pedrorijo91.utils.exception.NegativeNumberException;

public class CountableMap<K> extends HashMap<K, Integer> {

	public void inc(K key) throws NegativeNumberException {
		inc(key, 1);
	}

	public void inc(K key, int inc) throws NegativeNumberException {
		verifyNegativeNumber(inc);
		int count = inc;

		if (this.containsKey(key)) {
			count = this.get(key) + inc;
		}

		super.put(key, count);
	}

	public void dec(K key) throws NegativeNumberException {
		dec(key, 1);
	}

	public void dec(K key, int dec) throws NegativeNumberException {
		verifyNegativeNumber(dec);

		int count = -dec;

		if (this.containsKey(key)) {
			count = this.get(key) - dec;
		}

		super.put(key, count);
	}

	@Override
	public Integer get(Object key) {
		Integer count = super.get(key);
		if (null == count) {
			count = 0;
		}

		return count;
	}

	private void verifyNegativeNumber(int number)
			throws NegativeNumberException {
		if (number < 0) {
			throw new NegativeNumberException(number);
		}
	}

}
