package pt.pedrorijo91.utils.fibonacci;

import java.util.ArrayList;
import java.util.HashMap;

import pt.pedrorijo91.utils.exception.NegativeNumberException;

/**
 * Class for computing Fibonacci sequence
 *
 * @author pedrorijo
 *
 */
public class FibonacciCalculator {

    /**
     * Hashmap containing previously calculated results
     */
    private HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();

    /**
     * Default constructor which inserts base cases on Fibonacci base cases
     */
    public FibonacciCalculator() {
        results.put(1, 1);
        results.put(2, 1);
    }

    /**
     * Calculates the nth Fibonacci sequence number
     *
     * @param n the nth sequence number to calculate
     * @return the nth Fibonacci sequence number
     * @throws NegativeNumberException if n is negative
     */
    public int fib(int n) throws NegativeNumberException {

        if (n < 0) {
            throw new NegativeNumberException(n);
        }

        if ((n == 1) || (n == 2)) {
            return 1;
        }

        int x = results.containsKey(n - 2) ? results.get(n - 2) : fib(n - 2);
        int y = results.containsKey(n - 1) ? results.get(n - 1) : fib(n - 1);

        results.put(n - 2, x);
        results.put(n - 1, y);

        int res = x + y;

        results.put(n, res);

        return res;
    }

    /**
     * Calculates the nth Fibonacci sequence number
     * Recommended using the non-static method, which saves previously results and becomes faster that the other method. Method to
     * be used if systems contains memory restrictions that can be fulfilled with previous saved results
     *
     * @param n the nth sequence number to calculate
     * @return the nth Fibonacci sequence number
     * @throws NegativeNumberException if n is negative
     */
    public static int fibIt(int n) throws NegativeNumberException {

        if (n < 0) {
            throw new NegativeNumberException(n);
        }

        if (n == 0) {
            return 0;
        }

        if ((n == 1) || (n == 2)) {
            return 1;
        }

        int x = 1;
        int y = 1;

        for (int i = 3; i <= n; i++) {
            int fib = x + y;
            x = y;
            y = fib;
        }

        return y;
    }

    /**
     * Calculates the Fibonacci sequence between {@code from} and {@code to} arguments
     *
     * @param from first Fibonacci term of the sequence
     * @param to last Fibonacci term of the sequence
     * @return the Fibonacci sequence between {@code from} and {@code to}
     * @throws NegativeNumberException if any argument is less than 0
     */
    public ArrayList<Integer> fibSequence(int from, int to) throws NegativeNumberException {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = from; i <= to; i++) {
            result.add(fib(i));
        }

        return result;
    }

    /**
     * Calculates the Fibonacci sequence between 1 and {@code to} arguments
     *
     * @param to last Fibonacci term of the sequence
     * @return the Fibonacci sequence between 1 and {@code to}
     */
    public ArrayList<Integer> fibSequence(int to) {
        try {
            return fibSequence(1, to);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Calculates the Fibonacci sequence between {@code from} and {@code to} arguments without saving previous results
     *
     * @param from first Fibonacci term of the sequence
     * @param to last Fibonacci term of the sequence
     * @return the Fibonacci sequence between {@code from} and {@code to}
     * @throws NegativeNumberException if any argument is less than 0
     */
    public static ArrayList<Integer> fibSequenceIt(int from, int to) throws NegativeNumberException {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = from; i <= to; i++) {
            result.add(fibIt(i));
        }

        return result;
    }

    /**
     * Calculates the Fibonacci sequence between 1 and {@code to} arguments without saving previous results
     *
     * @param to last Fibonacci term of the sequence
     * @return the Fibonacci sequence between 1 and {@code to}
     */
    public static ArrayList<Integer> fibSequenceIt(int to) {
        try {
            return fibSequenceIt(1, to);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
            return null;
        }
    }
}
