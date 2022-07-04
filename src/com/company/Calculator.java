package com.company;

import java.util.Locale;
import java.util.regex.Pattern;

class Calculator {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static String calc(String input) throws CalculatorException {

        String[] elements;

        String operand1, operand2;

        int a, b;

        input = input.replaceAll("[\\s|\\u00A0]+", "").toUpperCase(Locale.ROOT);

        String operator;

        boolean isRoman=false;

        try {
            elements = input.split("[-+*/]");

            operand1 = elements[0];
            operand2 = elements[1];

            operator = input.replaceAll("[a-zA-Z]", "").replaceAll("[0-9]", "");

        } catch (Exception e) {
            throw new CalculatorException("Ошибка.");
        }

        if (elements.length >= 3) {
            throw new CalculatorException("Ошибка.");
        }
        try {

            if(isNumeric(operand1) && isNumeric(operand2)){

                a = Integer.parseInt(operand1);
                b = Integer.parseInt(operand2);

            }else if(!isNumeric(operand1) && !isNumeric(operand2)){

                a = Romans.valueOf(operand1).value;
                b = Romans.valueOf(operand2).value;

                isRoman=true;
            }else{
                throw new CalculatorException("Ошибка.");
            }

            if (a <= 0 | b <= 0 || a > 10 | b > 10) {
                throw new CalculatorException("Калькулятор должен принимать на вход числа от 1 до 10.");
            }
        } catch (Exception e) {
            throw new CalculatorException("Ошибка.");
        }

        int result = 0;

        switch (operator) {
            case ("+") -> result = a + b;
            case ("-") -> result = a - b;
            case ("*") -> result = a * b;
            case ("/") -> result = a / b;
            default -> System.out.println("Ошибка.");
        }
        if(isRoman){
            return getValue(result).toString();// для римских
        }
        return String.valueOf(result);// для арабских
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static Romans getValue(int value) {
        for (Romans e : Romans.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

}



