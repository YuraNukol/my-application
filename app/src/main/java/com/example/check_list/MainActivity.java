package com.example.check_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCheck;
    TextView tvCheck;
    EditText editList;

    boolean boll=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCheck = findViewById(R.id.tvCheck);
        editList = findViewById(R.id.editList);

        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int d1=0,d2=0;

        String s1 = String.valueOf(editList.getText());
        char [] s2 = s1.toCharArray();


        for (int i=0; i<s2.length;i++){

            if(String.valueOf(s2[i]).equals("{")) d1++;
            if(String.valueOf(s2[i]).equals("}")) d2++;

            if(d1<d2){
                tvCheck.setText("Результат: false");
                boll=false;
            }
            if(d1>d2) boll=true;
        }
        if(boll==true){
            if(d1==d2) tvCheck.setText("Результат: true");
            else tvCheck.setText("Результат: false");
        }
    }

}
