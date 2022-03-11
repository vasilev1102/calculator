package com.company;

public class Converter {
    public static Value processing(String expressionWS){                                                                //обрабатыевает полученную строку, проверяет на исключения, отправляет два числа и оператор дальше
        String number1 = null;
        String number2= null;
        char operator = 0;
        int count = 0;
        for (int i = 0; i < expressionWS.length(); i++) {                                                               //проверяет количество операторов
            if(expressionWS.charAt(i)=='-' || expressionWS.charAt(i)== '+' || expressionWS.charAt(i)== '*' || expressionWS.charAt(i)== '/'){
                count++;
                if(count>1){
                    throw new RuntimeException("Количество операторов больше 1");
                }
            }
        }
        if (count==0) throw new RuntimeException("Введеная строка не является математической операцией");

        for (int i = 0; i < expressionWS.length(); i++) {                                                               //Разделяет строку на две части- до оператора и после,и отдельно запоминает оператор
            if(expressionWS.charAt(i)=='-' || expressionWS.charAt(i)== '+' || expressionWS.charAt(i)== '*' || expressionWS.charAt(i)== '/'){
                operator = expressionWS.charAt(i);
                number1 = expressionWS.substring(0,i);
                number2 = expressionWS.substring(i+1);
                if(i==0 || i == expressionWS.length()-1) throw new RuntimeException("Строка не является математической операцией");
                break;
            }

        }


        if(isNumeric(number1) != isNumeric(number2)){                                                                   //проверяет совпадают ли типы значений,если нет то выбрасывается исключение
            throw new RuntimeException("Типы значений не совпадают");
        } else if(isNumeric(number1) && isNumeric(number2) ){                                                           //проверяет являются ли оба числа арабскими,если да, то проверяет диапазон чисел
            if(isOneTen(Integer.parseInt(number1)) && isOneTen(Integer.parseInt(number2))){                             //если диапазон чисел не верный - выбрасывается исключение,если верный- возвращает значения чисел и оператор c mark =0
                return new Value(Integer.parseInt(number1),Integer.parseInt(number2),operator,0);                  //mark используется в качестве метки(если 0 то от пользователя пришли арабские числа,если 1 то римские
            }
            else  throw new RuntimeException("Введен неверный диапазон чисел");
        } else if(isOneTenRome(number1) && isOneTenRome(number2)){                                                      //проверяет диапазон римских чисел,если диапазон верный,то числа в арабские
            Roman num1 = Roman.valueOf(number1);                                                                        //и возвращает значения чисел и оператор с пометкой mark = 1
            int numberRome1= num1.getNum();                                                                             //если диапазон чисел не верный, то выбрасывает исключение
            Roman num2 = Roman.valueOf(number2);
            int numberRome2 = num2.getNum();
            return new Value(numberRome1,numberRome2,operator,1);
        }
        else throw new RuntimeException("Введен неверный диапазон чисел");

    }
    public static boolean isNumeric(String str){                                                                        //проверяет,является ли полученная строка числом
        for (char c: str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    public static boolean isOneTen(int Num){                                                                            //проверяет диапазон чисел
        if(Num >= 0 && Num <= 10) return true;
        else  return  false;
    }
    public static boolean isOneTenRome(String Num){                                                                     //проверяет диапазон римских чисел
        boolean exists = true;
        try{
            Roman.valueOf(Num);
        }
        catch (IllegalArgumentException e){
            exists = false;
        }
        return  exists;
    }

}
