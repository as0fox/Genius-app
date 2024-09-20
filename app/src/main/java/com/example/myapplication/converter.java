package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class converter extends AppCompatActivity {
    TextView et1;
    Button btnConData;
    EditText etconvert;
    Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        et1=(TextView) findViewById(R.id.tvShowData);
        etconvert=(EditText) findViewById(R.id.etconvert);
        spn=(Spinner) findViewById(R.id.span);
        btnConData=(Button) findViewById(R.id.btnConData);



        btnConData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ValueEnterd = etconvert.getText().toString();
                double a=Double.parseDouble(ValueEnterd);

                switch (spn.getSelectedItemPosition()) {
                    case 0:
                        et1.setText(String.valueOf(k2p(a))+" P");
                        break;
                    case 1:
                        et1.setText(String.valueOf(p2k(a))+" KG");
                        break;
                    case 2:
                        et1.setText(String.valueOf(k2mi(a))+" Mi");
                        break;
                    case 3:
                        et1.setText(String.valueOf(mi2k(a))+" KM");
                        break;
                    case 4:
                        et1.setText(String.valueOf(k2me(a))+" Me");
                        break;
                    case 5:
                        et1.setText(String.valueOf(me2k(a))+" KM");
                        break;

                }

            }
        });
    }

    public void home(View view) {
        Intent intent=new Intent(converter.this,play.class);
        startActivity(intent);
    }
    //Celcius to Fahrenhiet method
    private double k2p(double c) {return  c * 2.205;}
    //Fahrenhiet to Celcius method
    private double p2k(double f) {return f/2.205;}

    private double k2mi(double a) {
        return a/1.609344;
    }

    private double mi2k(double a) {
        return a*1.609344;
    }

    private double k2me(double a) {
        return a*1000;
    }

    private   double me2k(double c) {
        return  c/1000;
    }



}