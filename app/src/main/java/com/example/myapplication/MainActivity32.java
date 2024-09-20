package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity32 extends AppCompatActivity {
    Button btnCalc;
    EditText etAge,etAge2,etAge3;
    TextView tvResult,tvResult2,tvResult3,tvResult4,tvResult5;
    int ageResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main32);

        etAge=(EditText) findViewById(R.id.etAge);
        etAge2=(EditText) findViewById(R.id.etAge2);
        etAge3=(EditText) findViewById(R.id.etAge3);
        tvResult=(TextView) findViewById(R.id.tvResult);
        tvResult2=(TextView) findViewById(R.id.tvResult2);
        tvResult3=(TextView) findViewById(R.id.tvResult3);
        tvResult4=(TextView) findViewById(R.id.tvResult4);
        tvResult5=(TextView) findViewById(R.id.tvResult5);
        btnCalc=(Button) findViewById(R.id.btnCalc);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Result1,Result2,year,month,day;
                double total=1.0,allDay,allMonth;
                Result1=(int)( Calendar.getInstance().get(Calendar.YEAR))*365 +(int) (Calendar.getInstance().get(Calendar.MONTH))*30+(int) (Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                Result2=(Integer.parseInt(etAge.getText().toString())*365)+( Integer.parseInt(etAge2.getText().toString())*30)+Integer.parseInt(etAge3.getText().toString());
                total=Result1-Result2;
                allDay=total;
                allMonth=total/30;
                year= (int) (total / 365);
                total=total%365;
                month=(int)(total/30);
                day=(int)(total%30);


                tvResult.setText(Integer.toString(year));
                tvResult2.setText(Integer.toString(month));
                tvResult3.setText(Integer.toString(day));
                tvResult4.setText(Integer.toString((int)allDay));
                tvResult5.setText(Integer.toString((int)allMonth));

            }



        });

    }

    public void goBack(View view) {
        Intent intent=new Intent(MainActivity32.this,play2.class);
        startActivity(intent);



}
}