package com.company;

import java.util.Scanner;
public class Main {


    public static void main(String[] args) throws CalculatorException {

        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        System.out.println("Введите выражение:");

        String operation = scanner.nextLine();

        System.out.println(Calculator.calc(operation));








    }
}

