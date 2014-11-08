package pt.pedrorijo91.utils.collections;

import java.util.HashMap;

import pt.pedrorijo91.utils.exception.NegativeNumberException;

/**
 *
 * Simple Hashmap implementation that provides an abstraction level for counting elements.
 *
 * @author pedrorijo
 *
 */
public class CountableMap<K> extends HashMap<K, Integer> {

    /**
     * Increments the provided key by the default value of 1
     *
     * @param key the key to increment
     */
    public void inc(K key) {
        try {
            inc(key, 1);
        } catch (NegativeNumberException e) {
            System.err.println("Negative increment shouldn't be possible by default");
            e.printStackTrace();
        }
    }

    /**
     * Increments the provided key by the amount specified in {@code inc}
     *
     * @param key the key to increment
     * @param inc the amount to increment
     * @throws NegativeNumberException if provided amount is negative
     */
    public void inc(K key, int inc) throws NegativeNumberException {
        verifyNegativeNumber(inc);
        int count = inc;

        if (this.containsKey(key)) {
            count = this.get(key) + inc;
        }

        super.put(key, count);
    }

    /**
     * Decrements the provided key by the default value of 1
     *
     * @param key the key to decrement
     */
    public void dec(K key) {
        try {
            dec(key, 1);
        } catch (NegativeNumberException e) {
            System.err.println("Negative decrement shouldn't be possible by default");
            e.printStackTrace();
        }
    }

    /**
     * Decrements the provided key by the amount specified in {@code dec}
     *
     * @param key the key to decrement
     * @param dec the amount to decrement
     * @throws NegativeNumberException if provided amount is negative
     */
    public void dec(K key, int dec) throws NegativeNumberException {
        verifyNegativeNumber(dec);

        int count = -dec;

        if (this.containsKey(key)) {
            count = this.get(key) - dec;
        }

        super.put(key, count);
    }

    /**
     * Returns the counting for specified key
     *
     * @param key the key to consult
     * @see java.util.HashMap#get(java.lang.Object)
     */
    @Override
    public Integer get(Object key) {
        Integer count = super.get(key);
        if (null == count) {
            count = 0;
        }

        return count;
    }

    /**
     * Checks if the number is negative
     *
     * @param number the number to check if negative
     * @throws NegativeNumberException exception thrown if the number is negative
     */
    private void verifyNegativeNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException(number);
        }
    }

}
