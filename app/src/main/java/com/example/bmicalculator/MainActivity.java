package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult,txtContent;
        EditText edtweight, edtft,edtinch;
        Button btnCalculate;

        edtft = findViewById(R.id.edtft);
        edtinch = findViewById(R.id.edtinch);
        edtweight = findViewById(R.id.edtWeight);
        btnCalculate = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
        txtContent = findViewById(R.id.txtcontent);

        //here to create a new object of OnclickListner
        //but we cannot clall clicklistner directly because btn belongs to view class so on clicklistner
        //is sub class of the onclicklistner so view.listner


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               int wt = Integer.parseInt( edtweight.getText().toString());
               int ft = Integer.parseInt((edtft.getText().toString()));
               int inch = Integer.parseInt((edtinch.getText().toString()));
               if(wt != 0 && (ft != 0 || inch !=0)){
                   float ht = ft* 12 *2.53f;
                   float totalHt = ht +(float)(inch*2.53);
                   float ans = (wt*100*100)/(totalHt*totalHt);

                   txtResult.setText(String.valueOf(ans));

                   if(ans > 25){
                       txtContent.setText("You are OverWeight 😒");
                   }else if(ans <18){
                       txtContent.setText("you are underweight 😢");
                   }else{
                       txtContent.setText("You are normal , maintain the same 😊😊 ");
                   }

               }else{
                  Toast.makeText(MainActivity.this,"Enter the values",Toast.LENGTH_SHORT);
               }


            }
        });
    }
}