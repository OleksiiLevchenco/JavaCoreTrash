package task2.calculator;


import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


/**
 * @author Alexey Levchenko
 */
public class CalculatorTest {

    public static void main(String[] args) {
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();
        consoleCalculator.run();
    }

//    public static void main0(String[] args) throws IllegalMoneyFormatException, ParseException {
//        CalculatorForMoney calculatorForMoney = new CalculatorForMoney();
//        calculatorForMoney.setValue("1.000.000,00");
////        calculatorForMoney.add("2.000,25");
////        calculatorForMoney.add(123);
////        calculatorForMoney.subtract("500,00");
////        calculatorForMoney.subtract(500);
////        calculatorForMoney.multiply("0,1");
////        calculatorForMoney.multiply(0.000000026);
////        calculatorForMoney.divided("3,0");
//
//        System.out.println("getResult");
//        System.out.printf("Money string = " + calculatorForMoney.getResultString() + "\n");
//        System.out.format("Double = " + "%.3f%n\n", calculatorForMoney.getResultNumber());
//
//        calculatorForMoney.divided(3);
//        System.out.println("/3 Number");
//        System.out.printf("Money string = " + calculatorForMoney.getResultString() + "\n");
//        System.out.format("Double = " + "%.3f%n\n", calculatorForMoney.getResultNumber());
//
//        calculatorForMoney.subtract("0.000,33");
//        System.out.println("-0.000,33 String");
//        System.out.printf("Money string = " + calculatorForMoney.getResultString() + "\n");
//        System.out.format("Double = " + "%.3f%n\n", calculatorForMoney.getResultNumber());
//
//        calculatorForMoney.multiply(0.000001);
//        System.out.println("*0.000001 Double");
//        System.out.printf("Money string = " + calculatorForMoney.getResultString() + "\n");
//        System.out.format("Double = " + "%.3f%n\n", calculatorForMoney.getResultNumber());
//
//        calculatorForMoney.add(0.005);
//        System.out.println("+0.005 Double");
//        System.out.printf("Money string = " + calculatorForMoney.getResultString() + "\n");
//        System.out.format("Double = " + "%.3f%n\n", calculatorForMoney.getResultNumber());



}


