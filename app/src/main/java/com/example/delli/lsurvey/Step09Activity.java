package com.example.delli.lsurvey;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Step09Activity extends AppCompatActivity {
    String text;

    int choose=0;

    RadioGroup radiogroup_s09;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step09);

        radiogroup_s09 = (RadioGroup) findViewById(R.id.rgp_s09);
        final Button btn = (Button) findViewById(R.id.btn_s09);


        radiogroup_s09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                choose=1;
                switch (checkedId) {
                    case R.id.rbtn_s09a:
                        btn.setText("NEXT");

                        break;
                    case R.id.rbtn_s09b:
                        btn.setText("NEXT");

                        break;
                    case R.id.rbtn_s09c:
                        btn.setText("NEXT");

                        break;
                    default:
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(choose==1){
                    int radioSelected = radiogroup_s09.getCheckedRadioButtonId();

                    final RadioButton selected = (RadioButton) findViewById(radioSelected);

                    text=selected.getText().toString()+"\r\n";
                    save(text);

                    Intent intent = new Intent(getBaseContext(),Step10Activity.class);
                    startActivity(intent);
                }

                else Toast.makeText(getBaseContext(), "Please choose one!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void save(String inputText){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("data", Context.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
