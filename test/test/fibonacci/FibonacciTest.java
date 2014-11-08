package test.fibonacci;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import pt.pedrorijo91.utils.exception.NegativeNumberException;
import pt.pedrorijo91.utils.fibonacci.FibonacciCalculator;

public class FibonacciTest {

    @Test
    public void testFib() throws NegativeNumberException {
        FibonacciCalculator fib = new FibonacciCalculator();
        assertEquals("Testing multiple Fibonacci number: fib(3)", 2, fib.fib(3));
        assertEquals("Testing multiple Fibonacci number: fib(5)", 5, fib.fib(5));
        assertEquals("Testing multiple Fibonacci number: fib(10)", 55, fib.fib(10));
        assertEquals("Testing multiple Fibonacci number: fib(10)", 6765, fib.fib(20));
    }

    @Test
    public void testFibIt() throws NegativeNumberException {
        assertEquals("Testing multiple static Fibonacci number: fib(3)", 2, FibonacciCalculator.fibIt(3));
        assertEquals("Testing multiple static Fibonacci number: fib(5)", 5, FibonacciCalculator.fibIt(5));
        assertEquals("Testing multiple static Fibonacci number: fib(10)", 55, FibonacciCalculator.fibIt(10));
        assertEquals("Testing multiple static Fibonacci number: fib(10)", 6765, FibonacciCalculator.fibIt(20));
    }

    @Test
    public void testFibSequenceDefaultFrom() {
        FibonacciCalculator fib = new FibonacciCalculator();
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        res.add(1);
        res.add(2);
        assertEquals("Testing Fibonacci sequence default: seq(3)", res, fib.fibSequence(3));

        res.add(3);
        res.add(5);
        res.add(8);
        assertEquals("Testing Fibonacci sequence default: seq(6)", res, fib.fibSequence(6));
    }

    @Test
    public void testFibSequenceDefaultFromIt() {
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        res.add(1);
        res.add(2);
        assertEquals("Testing Fibonacci sequence default static : seq(3)", res, FibonacciCalculator.fibSequenceIt(3));

        res.add(3);
        res.add(5);
        res.add(8);
        assertEquals("Testing Fibonacci sequence default static : seq(6)", res, FibonacciCalculator.fibSequenceIt(6));
    }

    @Test
    public void testFibSequence() throws NegativeNumberException {
        FibonacciCalculator fib = new FibonacciCalculator();
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        res.add(2);
        assertEquals("Testing Fibonacci sequence default: seq(2,3)", res, fib.fibSequence(2, 3));

        res = new ArrayList<Integer>();
        res.add(3);
        res.add(5);
        res.add(8);
        assertEquals("Testing Fibonacci sequence default: seq(3,6)", res, fib.fibSequence(4, 6));

        assertEquals("Testing Fibonacci sequence default: seq(1,3)", fib.fibSequence(3), fib.fibSequence(1, 3));
        assertEquals("Testing Fibonacci sequence default: seq(1,6)", fib.fibSequence(6), fib.fibSequence(1, 6));
    }

    @Test
    public void testFibSequenceIt() throws NegativeNumberException {
        ArrayList<Integer> res = new ArrayList<Integer>();

        res.add(1);
        res.add(2);
        assertEquals("Testing Fibonacci sequence default static: seq(2,3)", res, FibonacciCalculator.fibSequenceIt(2, 3));

        res = new ArrayList<Integer>();
        res.add(3);
        res.add(5);
        res.add(8);
        assertEquals("Testing Fibonacci sequence default static: seq(3,6)", res, FibonacciCalculator.fibSequenceIt(4, 6));

        assertEquals("Testing Fibonacci sequence default static : seq(1,3)", FibonacciCalculator.fibSequenceIt(3),
                FibonacciCalculator.fibSequenceIt(1, 3));
        assertEquals("Testing Fibonacci sequence default static : seq(1,6)", FibonacciCalculator.fibSequenceIt(6),
                FibonacciCalculator.fibSequenceIt(1, 6));
    }

    @Test(expected = NegativeNumberException.class)
    public void testFibNegative() throws NegativeNumberException {
        FibonacciCalculator fib = new FibonacciCalculator();
        fib.fib(-2);
    }

    @Test(expected = NegativeNumberException.class)
    public void testFibNegativeIt() throws NegativeNumberException {
        FibonacciCalculator.fibIt(-3);
    }

    @Test(expected = NegativeNumberException.class)
    public void testFibNegativeSeq() throws NegativeNumberException {
        FibonacciCalculator fib = new FibonacciCalculator();
        fib.fibSequence(-3, 4);
    }

    @Test(expected = NegativeNumberException.class)
    public void testFibNegativeSeqIt() throws NegativeNumberException {
        FibonacciCalculator.fibSequenceIt(-4, 5);
    }

}
