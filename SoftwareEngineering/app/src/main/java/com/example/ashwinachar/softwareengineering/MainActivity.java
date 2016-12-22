package com.example.ashwinachar.softwareengineering;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare(){
            double squareroot = Math.sqrt(number);
            if (squareroot == Math.floor(squareroot)){
                return true;
            }
            else
                return false;
        }

        public boolean isTriangular(){
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number)
                return true;
            else
                return false;
        }

    }

    public void check(View view){
        EditText n = (EditText)findViewById(R.id.num);
        String message = "";

        if(n.getText().toString().isEmpty()) {

            message = "PLEASE ENTER A NUMBER";

        }
        else {

            Number numObj = new Number();
            int num = Integer.parseInt(n.getText().toString());
            numObj.number = num;

            if (numObj.isSquare()) {

                if (numObj.isTriangular()) {

                    message = num + "is both a square number and a triangular number";

                } else {

                    message = num + "is only a square number";

                }
            } else {

                if (numObj.isTriangular()) {

                    message = num + "is only a triangular number";

                } else {

                    message = num + "is neither a square number nor a triangular number";

                }
            }
        }
        Toast.makeText(getApplicationContext(), message ,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
