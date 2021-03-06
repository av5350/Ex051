package com.example.ex051;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
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

    int correctAnswers = 0, level3Limit = 1;

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
        if (num4.getText().toString().equals("num4")) {
            String sum = input1.getText().toString();
            if (sum.isEmpty()) {
                Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
            } else {
                if (Integer.parseInt(sum) == Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())) {
                    successIV1.setImageResource(R.drawable.button_true);
                    correctAnswers++;
                } else {
                    successIV1.setImageResource(R.drawable.button_false);
                }
                num3.setText(Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()) + "");
                if (num4.getText().toString().equals("num4")) {
                    num4.setText(rnd.nextInt(90) + 10 + "");
                }
            }
        }
        else {
            Toast.makeText(this, "You've already answered this level!", Toast.LENGTH_SHORT).show();
        }
    }

    public void level2Check(View view) {
        if (num6.getText().toString().equals("num6")) {
            if (num3.getText().toString().equals("num3") && num4.getText().toString().equals("num4")) {
                Toast.makeText(this, "Invalid level - try again", Toast.LENGTH_SHORT).show();
            } else {
                String sum = input2.getText().toString();
                if (sum.isEmpty()) {
                    Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(sum) == Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString())) {
                        successIV2.setImageResource(R.drawable.button_true);
                        correctAnswers++;
                    }
                    else {
                        successIV2.setImageResource(R.drawable.button_false);
                    }
                    num5.setText(Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString()) + "");
                    if (num6.getText().toString().equals("num6")) {
                        num6.setText(rnd.nextInt(90) + 10 + "");
                    }
                }
            }
        }
        else {
            Toast.makeText(this, "You've already answered this level!", Toast.LENGTH_SHORT).show();
        }
    }

    public void level3Check(View view) {
        if (level3Limit == 1) {
            if (num5.getText().toString().equals("num5") && num6.getText().toString().equals("num6")) {
                Toast.makeText(this, "Invalid level - try again", Toast.LENGTH_SHORT).show();
            } else {
                String sum = input3.getText().toString();
                if (sum.isEmpty()) {
                    Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(sum) == Integer.parseInt(num5.getText().toString()) + Integer.parseInt(num6.getText().toString())) {
                        successIV3.setImageResource(R.drawable.button_true);
                        correctAnswers++;
                    } else {
                        successIV3.setImageResource(R.drawable.button_false);
                    }
                    Toast.makeText(this, correctAnswers + "/3", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "You can start a new game!", Toast.LENGTH_SHORT).show();
                }
                if (!sum.isEmpty()) {
                    level3Limit = 0;
                }
            }
        }
        else {
            Toast.makeText(this, "You've already answered this level!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearGame(View view) {
        correctAnswers = 0;
        num1.setText(rnd.nextInt(90) + 10 + "");
        num2.setText(rnd.nextInt(90) + 10 + "");
        num3.setText("num3");
        num4.setText("num4");
        num5.setText("num5");
        num6.setText("num6");

        input1.setText("");
        input2.setText("");
        input3.setText("");

        level3Limit = 1;

        successIV1.setImageResource(R.drawable.button_unknown);
        successIV2.setImageResource(R.drawable.button_unknown);
        successIV3.setImageResource(R.drawable.button_unknown);
    }
}
