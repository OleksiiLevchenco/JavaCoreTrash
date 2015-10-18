package task2.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexey Levchenko
 */
public class CalculatorForMoney {
    private BigDecimal bdValue = new BigDecimal(0);


    public void setValue(double value) {
        this.bdValue = new BigDecimal(value);
    }

    public void setValue(String stringValue) throws IllegalMoneyFormatException {
        this.bdValue = new BigDecimal(parseMoneyString(stringValue));
    }


    public Double getResultNumber() {
        return bdValue.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    public String getResultString() {
        return moneyStringFormatter(bdValue.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }



    public void add(String stringValue) throws IllegalMoneyFormatException {
        double tmp =parseMoneyString(stringValue);
        bdValue = bdValue.add(new BigDecimal(tmp));
    }

    public void add(double value) {
        bdValue = bdValue.add(new BigDecimal(value));
    }


    public void subtract(String stringValue) throws IllegalMoneyFormatException {
        double tmp =parseMoneyString(stringValue);
        bdValue = bdValue.subtract(new BigDecimal(tmp));
    }

    public void subtract(double value) {
        bdValue = bdValue.subtract(new BigDecimal(value));
    }


    public void multiply(String stringValue) throws IllegalMoneyFormatException {
            double tmp =parseMoneyString(stringValue);
            bdValue = bdValue.multiply(new BigDecimal(tmp));
    }

    public void multiply(double value) {
        bdValue = bdValue.multiply(new BigDecimal(value));
    }


    public void divided(String stringValue) throws IllegalMoneyFormatException {
        double tmp =parseMoneyString(stringValue);
        bdValue = bdValue.divide(new BigDecimal(tmp),2, BigDecimal.ROUND_HALF_EVEN);
    }

    public void divided(double value) {
        bdValue = bdValue.divide(new BigDecimal(value),2, BigDecimal.ROUND_HALF_EVEN);
    }



    public boolean moneyStringValidate(String moneyString) {
        Pattern pattern = Pattern.compile("^(((\\d{1,3}\\.)?(\\d{3}\\.)*(\\d{3}\\,))|(\\d{0,3}\\,))\\d{1,2}$");
        Matcher m = pattern.matcher(moneyString);
        return m.matches();
    }

    public boolean numberStringValidate(String moneyString) {
        Pattern pattern = Pattern.compile("^\\d+\\.?\\d*$");
        Matcher m = pattern.matcher(moneyString);
        return m.matches();
    }

    private double parseMoneyString(String stringValue) throws IllegalMoneyFormatException {
        String result = "";
        if (moneyStringValidate(stringValue)) {
            result = stringValue.replaceAll("\\.*", "").replaceAll(",", "."); //todo: ?
            return Double.parseDouble(result);
        }
        if (numberStringValidate(stringValue)) {
            return Double.parseDouble(stringValue);
        } else {
            throw new IllegalMoneyFormatException("not available money format");
        }

    }

    private String moneyStringFormatter(BigDecimal bd) {
        DecimalFormat formatter = new DecimalFormat("###,##0.00");
        DecimalFormatSymbols customSymbols = new DecimalFormatSymbols();
        customSymbols.setDecimalSeparator(',');
        customSymbols.setGroupingSeparator('.');
//        customSymbols.getGroupingSeparator();
        formatter.setDecimalFormatSymbols(customSymbols);
        return formatter.format(bd);
    }

}
