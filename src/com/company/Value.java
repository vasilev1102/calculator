package com.company;

public class Value {                                                                                                    //класс обертка
    int number1;
    int number2;
    char operator;
    int mark;

    public Value(int number1, int number2, char operator, int mark) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
        this.mark = mark;
    }



    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
