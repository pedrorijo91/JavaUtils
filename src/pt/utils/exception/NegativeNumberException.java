package pt.utils.exception;

public class NegativeNumberException extends Exception {

    private static final long serialVersionUID = -44022671040500312L;

    private final int number;

    public NegativeNumberException(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
