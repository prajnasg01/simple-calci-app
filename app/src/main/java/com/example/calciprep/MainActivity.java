package com.example.calciprep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button one,two,three,four,five,six,seven,eight,nine,zero,add,sub,mul,div,dot,equals,clear;
    EditText res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res=(EditText)findViewById(R.id.resid);
        res.setText("");

        one=(Button)findViewById(R.id.bone);
        one.setOnClickListener(this);

        two=(Button)findViewById(R.id.btwo);
        two.setOnClickListener(this);

        three=(Button)findViewById(R.id.bthree);
        three.setOnClickListener(this);

        four=(Button)findViewById(R.id.bfour);
        four.setOnClickListener(this);

        five=(Button)findViewById(R.id.bfive);
        five.setOnClickListener(this);

        six=(Button)findViewById(R.id.bsix);
        six.setOnClickListener(this);

        seven=(Button)findViewById(R.id.bseven);
        seven.setOnClickListener(this);

        eight=(Button)findViewById(R.id.beight);
        eight.setOnClickListener(this);

        nine=(Button)findViewById(R.id.bnine);
        nine.setOnClickListener(this);

        zero=(Button)findViewById(R.id.bzero);
        zero.setOnClickListener(this);

        add=(Button)findViewById(R.id.bplus);
        add.setOnClickListener(this);

        sub=(Button)findViewById(R.id.bminus);
        sub.setOnClickListener(this);

        mul=(Button)findViewById(R.id.bstar);
        mul.setOnClickListener(this);

        div=(Button)findViewById(R.id.bdiv);
        div.setOnClickListener(this);

        dot=(Button)findViewById(R.id.bdot);
        dot.setOnClickListener(this);

        equals=(Button)findViewById(R.id.bequals);
        equals.setOnClickListener(this);

        clear=(Button)findViewById(R.id.bclear);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(one))
            res.append("1");
        if(v.equals(two))
            res.append("2");
        if(v.equals(three))
            res.append("3");
        if(v.equals(four))
            res.append("4");
        if(v.equals(five))
            res.append("5");
        if(v.equals(six))
            res.append("6");
        if(v.equals(seven))
            res.append("7");
        if(v.equals(eight))
            res.append("8");
        if(v.equals(nine))
            res.append("9");
        if(v.equals(zero))
            res.append("0");
        if(v.equals(dot))
            res.append(".");
        if(v.equals(add))
            res.append("+");
        if(v.equals(sub))
            res.append("-");
        if(v.equals(mul))
            res.append("*");
        if(v.equals(div))
            res.append("/");
        if(v.equals(clear))
            res.setText("");
        if(v.equals(equals)) {
            try {
                String data = res.getText().toString();
                if (data.contains("/")) {
                    String[] operands = data.split("/");
                    if (operands.length == 2) {
                        double op1 = Double.parseDouble(operands[0]);
                        double op2 = Double.parseDouble(operands[1]);
                        double r = op1 / op2;
                        res.setText(String.valueOf(r));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("*"))
                {
                    String[] operands = data.split(Pattern.quote("*"));
                    if (operands.length == 2) {
                        double op1 = Double.parseDouble(operands[0]);
                        double op2 = Double.parseDouble(operands[1]);
                        double r = op1 * op2;
                        res.setText(String.valueOf(r));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("-")) {
                    String[] operands = data.split("-");
                    if (operands.length == 2) {
                        double op1 = Double.parseDouble(operands[0]);
                        double op2 = Double.parseDouble(operands[1]);
                        double r = op1 - op2;
                        res.setText(String.valueOf(r));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
                if (data.contains("+")) {
                    String[] operands = data.split(Pattern.quote("+"));
                    if (operands.length == 2) {
                        double op1 = Double.parseDouble(operands[0]);
                        double op2 = Double.parseDouble(operands[1]);
                        double r = op1 + op2;
                        res.setText(String.valueOf(r));
                    } else {
                        Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Invalid Input", Toast.LENGTH_LONG).show();
            }
        }
    }
}