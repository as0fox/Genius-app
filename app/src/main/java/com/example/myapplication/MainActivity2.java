package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdot, bequal, bpower, bplus, badtion, bsqrt, blog, bmul, bdiv, bln, bac, bmode,
            bangl, bangr, bfact, bsin, bcos, btan, bc, bsnc, bnor, bans, be, bpi, binv;
    TextView tvmain, tvsec;
    String pi = "3.14";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bpower = findViewById(R.id.power);
        badtion = findViewById(R.id.bmines);
        bmode = findViewById(R.id.bmode);
        bangl = findViewById(R.id.bangl);
        bangr = findViewById(R.id.bangr);
        bfact = findViewById(R.id.bfact);
        bc = findViewById(R.id.bc);
        bsnc = findViewById(R.id.bdeg);
        bnor = findViewById(R.id.brad);
        bans = findViewById(R.id.bans);
        be = findViewById(R.id.be);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bequal = findViewById(R.id.equal);
        bdot = findViewById(R.id.dot);
        bpi = findViewById(R.id.bpi);
        bplus = findViewById(R.id.badetion);
        bmul = findViewById(R.id.bmulte);
        bdiv = findViewById(R.id.bdvid);
        binv = findViewById(R.id.binv);
        bsqrt = findViewById(R.id.bsqret);
        bln = findViewById(R.id.bln);
        blog = findViewById(R.id.blog);
        btan = findViewById(R.id.btan);
        bcos = findViewById(R.id.bcos);
        bsin = findViewById(R.id.bsin);
        bac = findViewById(R.id.bac);
        tvmain = findViewById(R.id.tv2);
        tvsec = findViewById(R.id.textView);


        //Visibility>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        bsin.setVisibility(View.INVISIBLE);
        bcos.setVisibility(View.INVISIBLE);
        btan.setVisibility(View.INVISIBLE);
        bpi.setVisibility(View.INVISIBLE);
        bfact.setVisibility(View.INVISIBLE);
        blog.setVisibility(View.INVISIBLE);
        bsqrt.setVisibility(View.INVISIBLE);
        bpower.setVisibility(View.INVISIBLE);
        be.setVisibility(View.INVISIBLE);
        bans.setVisibility(View.INVISIBLE);


        bnor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                bsin.setVisibility(View.INVISIBLE);
                bcos.setVisibility(View.INVISIBLE);
                btan.setVisibility(View.INVISIBLE);
                bpi.setVisibility(View.INVISIBLE);
                bfact.setVisibility(View.INVISIBLE);
                blog.setVisibility(View.INVISIBLE);
                bsqrt.setVisibility(View.INVISIBLE);
                bpower.setVisibility(View.INVISIBLE);
                be.setVisibility(View.INVISIBLE);
                bans.setVisibility(View.INVISIBLE);


            }
        });
        bsnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                bsin.setVisibility(View.VISIBLE);
                bcos.setVisibility(View.VISIBLE);
                btan.setVisibility(View.VISIBLE);
                bpi.setVisibility(View.VISIBLE);
                bfact.setVisibility(View.VISIBLE);
                blog.setVisibility(View.VISIBLE);
                bsqrt.setVisibility(View.VISIBLE);
                bpower.setVisibility(View.VISIBLE);
                be.setVisibility(View.VISIBLE);
                bans.setVisibility(View.VISIBLE);


            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "*2");
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "^3");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "0");
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val = tvmain.getText().toString();
                if(val==""){

                }
                else{
                val = val.substring(0,val.length() - 1);
                tvmain.setText(val);}
            }
        });

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText("");
                tvsec.setText("");
            }
        });


        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "+");
            }
        });

        badtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "-");
            }
        });


        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText()+"*");
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "/");
            }
        });
        bmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText()+"%");
            }
        });


        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                double r = Math.sqrt(Double.parseDouble(val));
                tvmain.setText(String.valueOf(r));
            }
        });

        bangr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "(");
            }
        });

        bangl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + ")");
            }
        });


        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvsec.setText(bpi.getText());
                tvmain.setText(tvmain.getText() + pi);

            }
        });

        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText()+".");
            }
        });

////////////////////////////////////////////////////////////////////////////////////////


        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "sin(");

            }
        });


        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvmain.setText(tvmain.getText() + "cos(");

            }
        });

        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "ln(");
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "log(");
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvmain.setText(tvmain.getText() + "tan(");

            }
        });

        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "^" + "(-1)");

            }
        });
        bpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvmain.setText(tvmain.getText() + "^");

            }
        });


        bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(tvmain.getText().toString());
                int fact = factorial(val);
                tvmain.setText(String.valueOf(fact));
                tvsec.setText(val + "!");


            }
        });




        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                double result = eval(val);
                tvmain.setText(String.valueOf(result));
                tvsec.setText(val);
            }
        });

    }

    int factorial(int n){
        return (n==1 || n==0)? 1: n*factorial(n-1);

    }

    //evual function

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else if (eat('%')) x %=parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    public void home(View view) {
        Intent intent=new Intent(MainActivity2.this,play.class);
        startActivity(intent);

    }

}