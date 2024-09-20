package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class play2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
    }

    public void next(View view) {
        Intent intent=new Intent(play2.this,MainActivity22.class);
        startActivity(intent);
    }

    public void age(View view) {
        Intent Age=new Intent(play2.this,MainActivity32.class);
        startActivity(Age);
    }
    public void postx(View view) {
        Intent Age=new Intent(play2.this,MainActivity42.class);
        startActivity(Age);
    }

    public void conv(View view) {
        Intent con=new Intent(play2.this,converter.class);
        startActivity(con);
    }

    public void F_to_C(View view) {
        Intent f2c=new Intent(play2.this,convert_F_to_C.class);
        startActivity(f2c);
    }

    public void Finish(View view) {
        finishAffinity();
    }

    public void theme2(View view) {
        Intent con=new Intent(play2.this,play.class);
        startActivity(con);
    }

    public void coin(View view) {
        Intent con=new Intent(play2.this,MainActivity5.class);
        startActivity(con);
    }

    public void dictionary(View view) {
        Intent con=new Intent(play2.this,MainActivity6.class);
        startActivity(con);

    }
}