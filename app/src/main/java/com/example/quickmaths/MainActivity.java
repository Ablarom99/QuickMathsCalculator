package com.example.quickmaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    String oldNumero="";
    String op = "+";
    boolean esNuevaOp = true;
    EditText pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.editText);
        pantalla.setEnabled(false);
    }

    public void pulsaTecla(View view){
        if (esNuevaOp)
            pantalla.setText("");
        esNuevaOp= false;
        String numero = pantalla.getText().toString();
        switch (view.getId()){
            case R.id.btn0:
                numero += "0";
                break;
            case R.id.btn1:
                numero += "1";
                break;
            case R.id.btn2:
                numero += "2";
                break;
            case R.id.btn3:
                numero += "3";
                break;
            case R.id.btn4:
                numero += "4";
                break;
            case R.id.btn5:
                numero += "5";
                break;
            case R.id.btn6:
                numero += "6";
                break;
            case R.id.btn7:
                numero += "7";
                break;
            case R.id.btn8:
                numero += "8";
                break;
            case R.id.btn9:
                numero += "9";
                break;

            case R.id.btncoma:
                numero += ",";
                break;
            case R.id.btnSigno:
                numero = "-" + numero;
                break;

        }
        pantalla.setText(numero);
    }

    public void pulsaOperacion(View view) {
        esNuevaOp = true;
        oldNumero = pantalla.getText().toString();

        switch (view.getId()) {
            case R.id.btnSumar:
                op = "+";
                break;
            case R.id.btnMenos:
                op = "-";
                break;
            case R.id.btnMultiplicar:
                op = "x";
                break;
            case R.id.btnDividir:
                op = "/";
                break;
        }
    }
    public void pulsaIgual(View view) {
    String res = pantalla.getText().toString();
    double resultado = 0.0;
    switch (op){
        case("+"):
            resultado = Double.parseDouble(oldNumero) + Double.parseDouble(res);
            break;
        case("-"):
            resultado = Double.parseDouble(oldNumero) - Double.parseDouble(res);
            break;
        case("x"):
            resultado = Double.parseDouble(oldNumero) * Double.parseDouble(res);
            break;
        case("/"):
            resultado = Double.parseDouble(oldNumero) / Double.parseDouble(res);
            break;
    }
    pantalla.setText(resultado+"");
    }
    public void pulsaBorrar(View view) {
    pantalla.setText("0");
    esNuevaOp = true;
    }
    public void pulsaPorciento(View view) {
    double no = Double.parseDouble(pantalla.getText().toString())/100;
    pantalla.setText(no + "");
    esNuevaOp = true;
    }
}