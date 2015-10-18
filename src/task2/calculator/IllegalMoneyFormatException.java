package task2.calculator;

/**
 * @author Alexey Levchenko
 */

public class IllegalMoneyFormatException extends NumberFormatException{
    public IllegalMoneyFormatException(String message) {
        super(message);
    }
}
