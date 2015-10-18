package com.tranings.aleksey.calculator.impl;

import com.tranings.aleksey.calculator.Calculator;

/**
 * @author Alexey Levchhenko
 */
public class RecursionCalculator implements Calculator {

    @Override
    public String calculate(String expression) {
        return calc(expression);
    }

    private boolean validate(String str){

        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) {
                switch (str.charAt(i)) {
                    case '+': continue;
                    case '-': continue;
                    case '*': continue;
                    case '/': continue;
                    case '(': continue;
                    case ')': continue;
                    case '.': continue;
                    default: return false;
                }
            }
        }
        return true;
    }

    private String twoDigit(String str) {
        char sign=1;
        float fistPart = 0, secondPart = 0, result = 0;
        for (int k = 1; k < str.length(); k++) { //k=1 for ignore the sign of a negative value
            if (!Character.isDigit(str.charAt(k)) && str.charAt(k) != '.') {
                sign = str.charAt(k);
                fistPart = Float.parseFloat(str.substring(0, k));
                secondPart = Float.parseFloat(str.substring(k + 1));
                break;
            }
        }
        switch (sign) {
            case '+':
                result = fistPart + secondPart;
                break;
            case '-':
                result = fistPart - secondPart;
                break;
            case '*':
                result = fistPart * secondPart;
                break;
            case '/':
                result = fistPart / secondPart;
                break;
            default:
                return "Syntax error!";
        }
        return result+"";
    }

    private String plsAndMns(String str) {
        int nextSignIndex = str.length();
        for (int k = 1; k < str.length(); k++) {
            if (str.charAt(k) == '+' || str.charAt(k) == '-') {
                for (int i = k + 2; i < str.length(); i++) {
                    if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                        nextSignIndex = i;
                        break;
                    }
                }
                String result=twoDigit(str.substring(0, nextSignIndex))+str.substring(nextSignIndex);
                return plsAndMns(result);

            }
        }
        return str;
    }

    private String dewAndMult(String str) {
        boolean dw = false;
        int startIndex = -1, endIndex = str.length();
        for (int k = 1; k < str.length(); k++) {
            if (str.charAt(k) == '+' || str.charAt(k) == '-') startIndex = k;
            if (str.charAt(k) == '/' || str.charAt(k) == '*') {
                for (int i = k + 2; i < str.length(); i++) {
                    if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                        endIndex = i;
                        break;
                    }
                }
                String firstPart = str.substring(0, startIndex + 1);
                String result = twoDigit(str.substring(startIndex + 1, endIndex));
                String lastPart = str.substring(endIndex);
                return dewAndMult(firstPart + result + lastPart);
            }
        }
        return str;
    }

    private String openBrackets(String str){
        int startIndex=0;
        int endIndex=str.length();
        for(int k=0;k<str.length();k++){
            if(str.charAt(k)=='(')startIndex=k;
            if(str.charAt(k)==')'){
                endIndex=k;
                String firstPart=str.substring(0,startIndex);
                String result=str.substring(startIndex+1,endIndex);
                String lastPart=str.substring(endIndex+1);
                return openBrackets(firstPart + calc(result) + lastPart);
            }
        }
        return  str;
    }

    private String calc(String str){
        if(validate(str)){
        try {
            return plsAndMns(dewAndMult(openBrackets(str)));
        } catch (Exception e){return "Syntax error !"; }

    }
        else return "Syntax error !";
    }
}
