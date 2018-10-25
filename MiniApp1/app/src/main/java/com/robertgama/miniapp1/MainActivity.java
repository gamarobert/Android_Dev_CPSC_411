package com.robertgama.miniapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText fileSizeInput;
    private EditText networkSpeedInput;
    private TextView transferTimeLabel;
    private Double total;
    double fileSize;
    double networkSpeed;
    double conversionNum = 8.389;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileSizeInput = findViewById(R.id.fileInput);
        networkSpeedInput = findViewById(R.id.networkInput);
        transferTimeLabel = findViewById(R.id.transferTime);

        networkSpeedInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                transferTimeLabel.setText(calcTime());
            }
        });

        fileSizeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                transferTimeLabel.setText(calcTime());
            }
        });
    }

    private String calcTime()
    {
        String time;

        //checks text field for fileSizeInput
        if(fileSizeInput.getText().length() > 0) {
            //if not empty, converts string to double, assigns to fileSize
            fileSize = Double.parseDouble(fileSizeInput.getText().toString());
        } else {
            //if empty, will assign 0
            fileSize = 0;
        }
        //checks text field for networkSpeedInput
        if(networkSpeedInput.getText().length() > 0) {
            //if not empty, converts string to double, assigns to networkSpeed
            networkSpeed = Double.parseDouble(networkSpeedInput.getText().toString());
        } else {
            //if empty, will assign 0
            networkSpeed = 0;
        }

        //calculates transfer time
        total = fileSize * conversionNum / networkSpeed;

        //formats to one decimal place
        //http://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html
        time = String.format("%.1f", total);

        return time;
    }
}



