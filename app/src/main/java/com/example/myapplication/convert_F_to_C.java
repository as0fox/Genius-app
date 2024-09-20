package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class convert_F_to_C extends AppCompatActivity {
    Spinner spn;
    EditText et1;
    Button btnCalc;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_fto_c);


        spn=(Spinner) findViewById(R.id.span);
        et1=(EditText)findViewById(R.id.editText1);
        btnCalc=(Button) findViewById(R.id.buttonConv);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get value from edit text box and convert into double
                double a=Double.parseDouble(String.valueOf(et1.getText()));
                switch (spn.getSelectedItemPosition()) {
                    case 0:
                        et1.setText(String.valueOf(c2f(a)));
                        break;
                    case 1:
                        et1.setText(String.valueOf(f2c(a)));
                        break;
                    case 2:
                        et1.setText(String.valueOf(c2k(a)));
                        break;
                    case 3:
                        et1.setText(String.valueOf(f2k(a)));
                        break;
                    case 4:
                        et1.setText(String.valueOf(k2f(a)));
                        break;
                    case 5:
                        et1.setText(String.valueOf(k2c(a)));
                        break;

                }}});
    }

        private double k2c(double a) {
        return a-273.15;
    }

    private double k2f(double a) {
        return 1.8*(a-273) + 32;
    }

    private double f2k(double a) {
        return ((5/9)*(a+459.67));
    }

    private   double c2k(double c) {
       return  (c + 273.15);
    }

    //Celcius to Fahrenhiet method
        private double c2f(double c)
        {
            return (c*9)/5+32;
        }
        //Fahrenhiet to Celcius method
        private double f2c(double f)
        {
            return (f-32)*5/9;
        }


}
