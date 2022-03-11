package com.company;

import java.util.ArrayList;

public class ConverterToRoman {
    public static ArrayList<String> conversion(int result){                                                                  //конвертирует арабские числа в римские и возвращает массив строк
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

        return arrayList;
    }
}
