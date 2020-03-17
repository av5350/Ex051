package com.example.ex051;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView num1, num2, num3, num4, num5, num6;

    EditText input1, input2, input3;

    ImageView successIV3, successIV2, successIV1;

    ImageButton successIB3, successIB2, successIB1, clearGameIB;

    Random rnd = new Random();

    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (TextView)findViewById(R.id.num1);
        num2 = (TextView)findViewById(R.id.num2);
        num3 = (TextView)findViewById(R.id.num3);
        num4 = (TextView)findViewById(R.id.num4);
        num5 = (TextView)findViewById(R.id.num5);
        num6 = (TextView)findViewById(R.id.num6);

        input1 = (EditText)findViewById(R.id.input1);
        input2 = (EditText)findViewById(R.id.input2);
        input3 = (EditText)findViewById(R.id.input3);

        successIV1 = (ImageView)findViewById(R.id.successIV1);
        successIV2 = (ImageView)findViewById(R.id.successIV2);
        successIV3 = (ImageView)findViewById(R.id.successIV3);

        successIB1 = (ImageButton)findViewById(R.id.successIB1);
        successIB2 = (ImageButton)findViewById(R.id.successIB2);
        successIB3 = (ImageButton)findViewById(R.id.successIB3);
        clearGameIB = (ImageButton)findViewById(R.id.clearGameIB);

        num1.setText(rnd.nextInt(90) + 10 + "");
        num2.setText(rnd.nextInt(90) + 10 + "");
    }

    public void level1Check(View view) {
        String sum = input1.getText().toString();
        if (sum.isEmpty())
        {
            Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
        }
        else {
            if (Integer.parseInt(sum) == Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()))
            {
                successIV1.setImageResource(R.drawable.button_true);
                correctAnswers = 1;
            }
            else {
                successIV1.setImageResource(R.drawable.button_false);
            }
            num3.setText(Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()) + "");
            num4.setText(rnd.nextInt(90) + 10 + "");
        }
    }

    public void level2Check(View view) {
        String sum = input2.getText().toString();
        if (sum.isEmpty())
        {
            Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
        }
        else {
            if (Integer.parseInt(sum) == Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString()))
            {
                successIV2.setImageResource(R.drawable.button_true);
                correctAnswers = 2;
            }
            else {
                successIV2.setImageResource(R.drawable.button_false);
            }
            num5.setText(Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString()) + "");
            num6.setText(rnd.nextInt(90) + 10 + "");
        }
    }

    public void level3Check(View view) {
        String sum = input3.getText().toString();
        if (sum.isEmpty())
        {
            Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
        }
        else {
            if (Integer.parseInt(sum) == Integer.parseInt(num5.getText().toString()) + Integer.parseInt(num6.getText().toString()))
            {
                successIV3.setImageResource(R.drawable.button_true);
                correctAnswers = 3;
            }
            else {
                successIV3.setImageResource(R.drawable.button_false);
            }
            Toast.makeText(this, correctAnswers + "/3", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearGame(View view) {
        correctAnswers = 0;
        num1.setText("num1");
        num2.setText("num2");
        num3.setText("num3");
        num4.setText("num4");
        num5.setText("num5");
        num6.setText("num6");

        input1.setText("");
        input2.setText("");
        input3.setText("");

        successIV1.setImageResource(R.drawable.button_unknown);
        successIV2.setImageResource(R.drawable.button_unknown);
        successIV3.setImageResource(R.drawable.button_unknown);
    }
}
