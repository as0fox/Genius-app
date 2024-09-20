package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void next(View view) {
        Intent intent=new Intent(play.this,MainActivity2.class);
        startActivity(intent);
    }

    public void age(View view) {
        Intent Age=new Intent(play.this,MainActivity3.class);
        startActivity(Age);
    }
    public void postx(View view) {
        Intent Age=new Intent(play.this,MainActivity4.class);
        startActivity(Age);
    }

    public void conv(View view) {
        Intent con=new Intent(play.this,converter.class);
        startActivity(con);
    }

    public void F_to_C(View view) {
        Intent f2c=new Intent(play.this,convert_F_to_C.class);
        startActivity(f2c);
    }

    public void Finish(View view) {
        finishAffinity();
    }

    public void theme(View view) {
        Intent con=new Intent(play.this,play2.class);
        startActivity(con);
    }
    public void coin(View view) {
        Intent con=new Intent(play.this,MainActivity5.class);
        startActivity(con);
    }

    public void dictionary(View view) {
        Intent con=new Intent(play.this,MainActivity6.class);
        startActivity(con);

    }
}