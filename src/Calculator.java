
import java.io.*;

public class Calculator {

    float twoDigit(String str) {
        char opr = '1';
        float fist = 0, second = 0, result = 0;
        for (int k = 1; k < str.length(); k++) { //ищем оператор, k=1 пропустить минус перед числом
            if (!Character.isDigit(str.charAt(k)) && str.charAt(k) != '.') {
                opr = str.charAt(k);
                fist = Float.parseFloat(str.substring(0, k));
                second = Float.parseFloat(str.substring(k + 1));
                break;
            }
        }
        if ((opr != '+') && (opr != '-') && (opr != '*') && (opr != '/')) {
            System.out.println("Не обрабатываемый оператор  " + str);
        }
        switch (opr) {
            case '+':
                result = fist + second;
                break;
            case '-':
                result = fist - second;
                break;
            case '*':
                result = fist * second;
                break;
            case '/':
                result = fist / second;
                break;
            default:
                System.out.println("Не обрабатываемый оператор " + str);
        }
//        System.out.println(fist+""+(char)opr+""+second+"="+result);
        return result;
    }

    String plsAndMns(String str) {
        int endIndex = str.length();
        for (int k = 1; k < str.length(); k++) {//k=1 для пропуска знака '-' перед числом
            if (str.charAt(k) == '+' || str.charAt(k) == '-') {
                for (int i = k + 2; i < str.length(); i++) {//k=2 для пропуска знака '-' перед числом
                    if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                        endIndex = i;
                        break;
                    }
                }
                String result=twoDigit(str.substring(0,endIndex))+str.substring(endIndex);
                return plsAndMns(result);

            }
        }
        return str;
    }

    String dewAndPow(String str) {
        boolean dw = false;
        int startIndex = -1, endIndex = str.length();
        for (int k = 1; k < str.length(); k++) {
            if (str.charAt(k) == '+' || str.charAt(k) == '-') startIndex = k;
            if (str.charAt(k) == '/' || str.charAt(k) == '*') {
                for (int i = k + 2; i < str.length(); i++) {//k+2 Для того чтоб пропустить знак '-' перед числом
                    if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                        endIndex = i;
                        break;
                    }
                }
                String first = str.substring(0, startIndex + 1);
                String result = twoDigit(str.substring(startIndex + 1, endIndex)) + "";
                String last = str.substring(endIndex);
                return dewAndPow(first + result + last);
            }
        }
        return str;
    }

    String expBrackets(String str){
        int startIndex=0;
        int endIndex=str.length();
        for(int k=0;k<str.length();k++){
            if(str.charAt(k)=='(')startIndex=k;
            if(str.charAt(k)==')'){
                endIndex=k;
                String first=str.substring(0,startIndex);
                String result=str.substring(startIndex+1,endIndex);
                String last=str.substring(endIndex+1);
                return expBrackets (first+calc(result)+last);
            }
        }
        return  str;
    }

    public  String calc(String str){
        try {
            return plsAndMns(dewAndPow(expBrackets(str)));
        } catch (Exception e){return "Syntax error !"; }

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calc("3*(2+5.5)"));
    }


}