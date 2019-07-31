package com.example.check_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCheck;
    TextView tvCheck, tvList;

    String mas [] = {"{","}","}","{","}","{"};
   //String s="{,},{,{,},}";

    int d1=0,d2=0;
    boolean boll=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCheck = findViewById(R.id.tvCheck);
        tvList = findViewById(R.id.tvList);

        for(int i = 0; i<mas.length;i++){

            String s = String.valueOf(tvList.getText());
            tvList.setText(s+ mas[i]);

        }
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        //ArrayList<String> masCheck = new ArrayList<String>(Arrays.asList(s.split(",")));

        String s = String.valueOf(tvCheck.getText());

        for (int i=0; i<mas.length;i++){

            if(mas[i].equals("{")) d1++;
            if(mas[i].equals("}")) d2++;

            if(d1<d2){
                tvCheck.setText(s + " false");
                boll=false;
            }
        }
        if(boll==true){
            if(d1==d2) tvCheck.setText(s + " true");
            else tvCheck.setText(s + " false");
        }
    }

}
