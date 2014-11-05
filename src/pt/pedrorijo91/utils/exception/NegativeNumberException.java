package pt.pedrorijo91.utils.exception;

/**
 * Thrown when a number is negative
 *
 * @author pedrorijo
 *
 */
public class NegativeNumberException extends Exception {

    /**
     * The checked number
     */
    private final int number;

    /**
     * @param number the checked number
     */
    public NegativeNumberException(int number) {
        this.number = number;
    }

    /**
     * @return returns the number that was checked as negative
     */
    public int getNumber() {
        return number;
    }

}
