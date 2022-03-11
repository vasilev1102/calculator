package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {                                                                                                     //В работе не учавствует,изначально писал тут

    public static void main(String[] args) {
        // write your code her
        input();
    }
    public static void input(){
        System.out.println("input");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String expressionWS = expression.replaceAll(" ","");
        processing(expressionWS);
    }


    public static void processing(String expressionWS){
        String number1 = null;
        String number2= null;
        char operator = 0;
        int count = 0;
        for (int i = 0; i < expressionWS.length(); i++) {
            if(expressionWS.charAt(i)=='-' || expressionWS.charAt(i)== '+' || expressionWS.charAt(i)== '*' || expressionWS.charAt(i)== '/'){
                operator = expressionWS.charAt(i);
                number1 = expressionWS.substring(0,i);
                number2 = expressionWS.substring(i+1);
                count++;
            }
            if(expressionWS.length()-1 == i) throw new RuntimeException("Строка не является математической операцией");
        }
        if(count >1) throw new RuntimeException("Вы ввели неверное количество операторов ");

        if(isNumeric(number1) != isNumeric(number2)){
            throw new RuntimeException("Типы значений не совпадают");
        } else if(isNumeric(number1) && isNumeric(number2) ){
            if(isOneTen(Integer.parseInt(number1)) && isOneTen(Integer.parseInt(number2))){
                calculation(Integer.parseInt(number1),Integer.parseInt(number2),operator,0);
            }
            else  throw new RuntimeException("Введен неверный диапазон чисел");
        } else if(isOneTenRome(number1) && isOneTenRome(number2)){
            Roman num1 = Roman.valueOf(number1);
            int numberRome1= num1.getNum();
            Roman num2 = Roman.valueOf(number2);
            int numberRome2 = num2.getNum();
            calculation(numberRome1,numberRome2,operator,1);
        }
        else throw new RuntimeException("Введен неверный диапазон чисел");

    }
    public static boolean isNumeric(String str){
        for (char c: str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public static boolean isOneTen(int Num){
        if(Num >= 0 && Num <= 10) return true;
        else  return  false;
    }
    public static boolean isOneTenRome(String Num){
        boolean exists = true;
        try{
            Roman.valueOf(Num);
        }
        catch (IllegalArgumentException e){
            exists = false;
        }
        return  exists;
    }





    public static void calculation(int number1,int number2,char operator,int mark){

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
        if(mark == 0) {
            System.out.println("output:" + result);
        }
        else conversion(result);


    }
    public static void conversion(int result){
        ArrayList<String> arrayList = new ArrayList<String>();
        while(result >= 1000){
            arrayList.add("M");
            result = result -1000;
        }
        while(result >= 900){
            arrayList.add("СM");
            result = result -1000;
        }
        while(result >= 500){
            arrayList.add("D");
            result = result -500;
        }
        while(result >= 400){
            arrayList.add("CD");
            result = result -1000;
        }
        while(result >= 100){
            arrayList.add("C");
            result = result -100;
        }
        while(result >= 90){
            arrayList.add("XC");
            result = result -1000;
        }
        while(result >= 50){
            arrayList.add("L");
            result = result -50;
        }
        while(result >= 40){
            arrayList.add("XL");
            result = result -1000;
        }
        while(result >= 10){
            arrayList.add("X");
            result = result -10;
        }
        while(result >= 9){
            arrayList.add("IX");
            result = result -9;
        }
        while(result >= 5){
            arrayList.add("V");
            result = result -5;
        }
        while(result >= 4){
            arrayList.add("IV");
            result = result -4;
        }
        while(result >= 1){
            arrayList.add("I");
            result = result -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
    }




}
