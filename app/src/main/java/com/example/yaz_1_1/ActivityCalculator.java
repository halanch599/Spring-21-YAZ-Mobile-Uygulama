package com.example.yaz_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCalculator extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnce, btnC,btnback,btndivide, btnmul, btnplus, btnminus, btndot, btnplusminus,btnequal;
    TextView tbhistory, tvresult;

    String text = null;
    private double num1=0, num2=0;
    String history, currentResult;
    String status =null;
    boolean operator=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btn0 =  findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);

        btnce = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnback = findViewById(R.id.btnBack);
        btndivide = findViewById(R.id.btnDivide);
        btnmul = findViewById(R.id.btnMultiply);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnMinus);
        btndot = findViewById(R.id.btndot);
        btnplusminus = findViewById(R.id.btnplusminus);
        btnequal = findViewById(R.id.btnequal);

        tbhistory  = findViewById(R.id.tvHistory);
        tvresult  = findViewById(R.id.tvResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateText("9");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = tbhistory.getText().toString();
                currentResult = tvresult.getText().toString();
                tbhistory.setText(history + currentResult+ "+");
                if(operator)
                {

                }
            }
        });

    }

    public void plus()
    {

    }
    private void UpdateText(String txt)
    {
        if(text==null)
        {
            text = txt;
        }
        else
        {
            text+=txt;
        }
        tvresult.setText(text);
    }
}