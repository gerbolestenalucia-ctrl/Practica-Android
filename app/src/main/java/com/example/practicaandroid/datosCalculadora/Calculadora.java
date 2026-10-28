package com.example.practicaandroid.datosCalculadora;

import android.util.Log;

public class Calculadora {
    private String num1;

    private String num2;

    private char operacion;

    public Calculadora() {
        num1 = "";
        num2 = "";
    }

    public void meterNumero(int num) {
        this.num2 += num;
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public void operacion(char op) {
        operacion = op;
        num1 = num2;
        num2 = "";
    }


    public String igual() {
        double num1 = Double.parseDouble(this.num1);
        Log.d("CLASE CALC", "num1: " + num1);
        double num2 = Double.parseDouble(this.num2);
        Log.d("CLASE CALC", "num2: " + num2);
        switch (operacion) {
            case '+':
                Log.d("CLASE CALC", String.valueOf(num1 + num2));
                this.num2 = String.valueOf(num1 + num2);
                break;
            case '-':
                this.num2 = String.valueOf(num1 - num2);
                break;
            case '*':
                this.num2 = String.valueOf(num1 * num2);
                break;
            case '/':
                this.num2 = String.valueOf(num1 / num2);
                break;
        }
        return "";
    }

    public void clear() {
        num1 = "";
        num2 = "";
        operacion = 0;
    }

    public void meterComa() {
        if (!this.num2.contains(",")) {
            this.num2 += ",";
        }
    }
}
