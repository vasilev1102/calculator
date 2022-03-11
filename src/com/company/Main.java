package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code her
        String expression = Parser.input();
        Value value = Converter.processing(expression);
        int result = Calculator.calculation(value.getNumber1(),value.getNumber2(), value.getOperator());
        if(value.getMark()==0){                                                                                         //если метка mark = 0, то числа изначально арабские,печатаем сразу результат
            System.out.println(result);                                                                                 //если mark =1 , то числа изначально римские,необходимо сначала перевести обратно в римские,а потом вывести результат
        } else {
            if(result<=0) throw new RuntimeException("Результатом работы с римскими числами могут быть только положительные числа");
            ArrayList<String> arrayList = ConverterToRoman.conversion(result);
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i));
            }
        }


    }




}
