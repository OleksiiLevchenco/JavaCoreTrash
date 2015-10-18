package task2.calculator;

import java.util.Scanner;

/**
 * @author Alexey Levchhenko
 */
public class ConsoleCalculator {


    private String moneyPattern = "(((\\d{1,3}\\.)?(\\d{3}\\.)*(\\d{3}\\,))|(\\d{0,3}\\,))\\d{1,2}";
    private String numberPattern ="\\d*\\.?\\d*";

    private Scanner scanner = new Scanner(System.in);

    private String readFirstOperand(){
        System.out.println("Enter a number or money string xxx.xxx,dd ");
        while (!(scanner.hasNext(moneyPattern)||(scanner.hasNext(numberPattern)))) {
            System.out.println(" incorrect input ");
            scanner.next();
        }
        return scanner.next();
    }

    private String readNextOperand() {
        System.out.println("Enter a next number or money string xxx.xxx,dd ");
        while (!(scanner.hasNext(moneyPattern)||(scanner.hasNext(numberPattern)))) {
            System.out.println(" incorrect input ");
            scanner.next();
        }
        return scanner.next();
    }

    private char readSign() {
        System.out.println("Enter the sign of operation.  +  -  *  / ");

        while (!scanner.hasNext("[\\+\\-\\*\\/]")) {
            System.out.println(" incorrect input ");
            scanner.next();
        }
        return scanner.next().charAt(0);
    }

    public void run(){
        CalculatorForMoney calculatorForMoney = new CalculatorForMoney();
        String operand1 = readFirstOperand();
        calculatorForMoney.setValue(operand1);
        char sign = readSign();
        String operand2 = readNextOperand() ;

        switch (sign) {
            case ('+'):calculatorForMoney.add(operand2);
                break;
            case ('-'):calculatorForMoney.subtract(operand2);
                break;
            case ('*'):calculatorForMoney.multiply(operand2);
                break;
            case ('/'):calculatorForMoney.divided(operand2);
                break;
        }

        System.out.println("Result = "+calculatorForMoney.getResultString());

    }


}
