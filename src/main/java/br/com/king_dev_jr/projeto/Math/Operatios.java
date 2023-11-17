package br.com.king_dev_jr.projeto.Math;

import br.com.king_dev_jr.projeto.converters.NumberConverter;

public class Operatios {
    
    public static Double soma(String numberOne, String numberTwo){
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    public static Double subtraction(String numberOne, String NumberTwo){
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(NumberTwo);
    }

    public static Double division(String numberOne, String numberTwo){
        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo); 
    }

    public static Double average(String numberOne, String NumberTwo){
        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(NumberTwo))/2;
    }

    public static Double squareRoot(String number){
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }
}
