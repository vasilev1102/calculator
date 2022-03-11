package com.company;

import java.util.Scanner;

public class Parser {
    public static String input(){                                                   //Принимает значение на входе,возвращает полученную строку без пробелов
        System.out.println("Введите математическую операцию");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String expressionWS = expression.replaceAll(" ","");
        return expressionWS;
    }
}
