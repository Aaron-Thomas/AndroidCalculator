package com.example.aaronthomas.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // button outlets
        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        Button calcBtn = (Button)findViewById(R.id.calcBtn);
        Button divideBtn = (Button)findViewById(R.id.divideBtn);
        Button multiplyBtn = (Button)findViewById(R.id.multiplyBtn);
        Button subtractBtn = (Button)findViewById(R.id.subtractBtn);
        Button addBtn = (Button)findViewById(R.id.addBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);

        resultView = (TextView)findViewById(R.id.resultsText);

        resultView.setText("");

        // button actions
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                numberPressed(0);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultView.setText("");
            }
        });


    }

    // maths logic
    void processOperation(Operation operation) {
        if (currentOperation != null) {

            if (runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                resultView.setText(leftValueStr);
            }

        } else {
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }

    // combine numbers function
    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);
    }
}
