package pt.utils.collections;

import java.util.HashMap;

import pt.utils.exception.NegativeNumberException;

public class CountableMap<K> extends HashMap<K, Integer> {

    private static final long serialVersionUID = 8428498959791768623L;

    public Integer inc(K key) {
        int count = 1;

        if (this.containsKey(key)) {
            count = this.get(key) + 1;
        }

        return super.put(key, count);
    }

    public Integer inc(K key, int inc) throws NegativeNumberException {
        verifyNegativeNumber(inc);
        int count = inc;

        if (this.containsKey(key)) {
            count = this.get(key) + inc;
        }

        return super.put(key, count);
    }

    public Integer dec(K key) {
        int count = -1;

        if (this.containsKey(key)) {
            count = this.get(key) - 1;
        }

        return super.put(key, count);
    }

    public Integer dec(K key, int dec) throws NegativeNumberException {
        verifyNegativeNumber(dec);

        int count = -dec;

        if (this.containsKey(key)) {
            count = this.get(key) - dec;
        }

        return super.put(key, count);
    }

    @Override
    public Integer get(Object key) {
        Integer count = super.get(key);
        if (null == count) {
            count = 0;
        }

        return count;
    }

    private void verifyNegativeNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException(number);
        }
    }

}
