package com.example.arithmeticoperations;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Create object
        Button btnsum = (Button) findViewById(R.id.sum);
        Button btnsub = (Button) findViewById(R.id.sub);
        Button btndiv = (Button) findViewById(R.id.div);
        Button btnmul = (Button) findViewById(R.id.mul);
        final EditText etv = (EditText) findViewById(R.id.et1);
        final EditText etv2 = (EditText) findViewById(R.id.et2);
        final TextView result = (TextView) findViewById(R.id.tv);
        // Create button click event
        btnsum.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int x = new Integer(etv.getText().toString());
                int y = new Integer(etv2.getText().toString());
                int sum = x + y; //Perform Maths operation
                result.setText("The Addition of " + x + " + " + y + " = " + sum);//print answer
            }
        });

        btnsub.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int x = new Integer(etv.getText().toString());
                int y = new Integer(etv2.getText().toString());
                int sub = x - y; //Perform Maths operation
                result.setText("The Substraction of " + x + " - " + y + " = " + sub);//print answer
            }
        });

        btndiv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int x = new Integer(etv.getText().toString());
                int y = new Integer(etv2.getText().toString());
                int div = x / y; //Perform Maths operation
                result.setText("The Division of " + x + " / " + y + " = " + div);//print answer
            }
        });

        btnmul.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int x = new Integer(etv.getText().toString());
                int y = new Integer(etv2.getText().toString());
                int mul = x * y; //Perform Maths operation
                result.setText("The Multiplication of " + x + " * " + y + " = " + mul);//Print answer
            }
        });
    }

}