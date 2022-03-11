package com.company;

public class Calculator {
    public static int calculation(int number1,int number2,char operator){                     //производит вычисления и возвращает результат

        int result = 0;

        switch (operator){
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            case '*':
                result = number1 * number2;
                break;

        }
        return result;


    }

}
