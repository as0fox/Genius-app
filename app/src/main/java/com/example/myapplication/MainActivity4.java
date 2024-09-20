package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import java.lang.*;



public class MainActivity4 extends AppCompatActivity {
    EditText dt;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        dt=(EditText) findViewById(R.id.et1);
        tv=(TextView) findViewById(R.id.textView1);
        tv2=(TextView) findViewById(R.id.tv);
    }


    public void post(View view) {
        String infix=dt.getText().toString();
        String str_postfiksni =InfixToPostfix(infix);
        tv.setText(str_postfiksni);
        String str=infix,nstr="";

        char ch;
        for (int i=str.length()-1; i>=0; i--)
        {
            ch= str.charAt(i); //extracts each character
            nstr+= ch; //adds each character in front of the existing string
        }

        String pre=prefixToPostfix(nstr);
        nstr="";
        for (int i=pre.length()-1; i>=0; i--)
        {
            ch= pre.charAt(i); //extracts each character
            nstr+= ch; //adds each character in front of the existing string
        }
        tv2.setText(nstr);

    }



        public int precedence(char x){

            if(x=='^'){   // highest precedence
                return 2;
            }
            else if(x=='*' || x=='/'){
                return 1;                        // second highest precedence
            }
            else if(x=='+' || x=='-'){
                // lowest precedence

                return 0;
            }
            return -1; // not an operator
        }

        public String InfixToPostfix(String str){

            Stack<Character>stk= new Stack<>();             // used for converting infix to postfix

            String ans="";                // string containing our final answer

            int n= str.length();

            for (int i = 0; i <n ; i++) {
                char x= str.charAt(i);

                if(x>='0' && x<='9'){
                    ans+=x;
                }
                else if(x>='a' && x<='z'){
                    ans+=x;
                }
                else if(x>='A' && x<='Z'){
                    ans+=x;
                }

                else if(x=='('){     // push directly in the stack
                    stk.push('(');
                }
                else if(x==')'){

                    while(!stk.isEmpty() && stk.peek()!='('){          // keep popping till opening bracket is found
                        ans+=stk.pop();
                    }
                    if(!stk.isEmpty()){
                        stk.pop();
                    }

                }
                else{

                    while(!stk.isEmpty() && precedence(stk.peek())>=precedence(x)){    // remove all higher precedence values
                        ans+=stk.pop();
                    }
                    stk.push(x);

                }
            }
            while(!stk.isEmpty()){
                ans+=stk.pop();
            }
            return ans;
        }




    public String prefixToPostfix(String str){

        Stack<Character>stk= new Stack<>();             // used for converting infix to postfix

        String ans="";                // string containing our final answer

        int n= str.length();

        for (int i = 0; i <n ; i++) {
            char x= str.charAt(i);

            if(x>='0' && x<='9'){
                ans+=x;
            }
            else if(x>='a' && x<='z'){
                ans+=x;
            }
            else if(x>='A' && x<='Z'){
                ans+=x;
            }

            else if(x==')'){     // push directly in the stack
                stk.push(')');
            }
            else if(x=='('){

                while(!stk.isEmpty() && stk.peek()!=')'){          // keep popping till opening bracket is found
                    ans+=stk.pop();
                }
                if(!stk.isEmpty()){
                    stk.pop();
                }

            }
            else{

                while(!stk.isEmpty() && precedence(stk.peek())>=precedence(x)){    // remove all higher precedence values
                    ans+=stk.pop();
                }
                stk.push(x);

            }
        }
        while(!stk.isEmpty()){
            ans+=stk.pop();
        }
        return ans;
    }

    }

