package com.example.delli.lsurvey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Step12Activity extends AppCompatActivity {

    String text;

    int cb_a=0;
    int cb_b=0;
    int cb_c=0;
    int cb_d=0;
    int cb_e=0;
    int cb_f=0;
    int checkflog=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step12);

        final CheckBox checkBox_s12a=(CheckBox)findViewById(R.id.cb_s12a);
        final CheckBox checkBox_s12b=(CheckBox)findViewById(R.id.cb_s12b);
        final CheckBox checkBox_s12c=(CheckBox)findViewById(R.id.cb_s12c);
        final CheckBox checkBox_s12d=(CheckBox)findViewById(R.id.cb_s12d);
        final CheckBox checkBox_s12e=(CheckBox)findViewById(R.id.cb_s12e);
        final CheckBox checkBox_s12f=(CheckBox)findViewById(R.id.cb_s12f);

        checkBox_s12a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_a==0)
                    cb_a=1;
                else cb_a=0;
                //checkflog=1;
            }
        });

        checkBox_s12b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_b==0)
                    cb_b=1;
                else cb_b=0;
                checkflog=1;
            }
        });

        checkBox_s12c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_c==0)
                    cb_c=1;
                else cb_c=0;
                checkflog=1;
            }
        });

        checkBox_s12d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_d==0)
                    cb_d=1;
                else cb_d=0;
                checkflog=1;
            }
        });

        checkBox_s12e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_e==0)
                    cb_e=1;
                else cb_e=0;
                checkflog=1;
            }
        });

        checkBox_s12f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_f==0)
                    cb_f=1;
                else cb_f=0;
                checkflog=1;
            }
        });

        final Button btn = (Button) findViewById(R.id.btn_s12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text="search:";
                if(cb_a==1)
                    text=text+checkBox_s12a.getText().toString()+" ";
                if(cb_b==1)
                    text=text+checkBox_s12b.getText().toString()+" ";
                if(cb_c==1)
                    text=text+checkBox_s12c.getText().toString()+" ";
                if(cb_d==1)
                    text=text+checkBox_s12d.getText().toString()+" ";
                if(cb_e==1)
                    text=text+checkBox_s12e.getText().toString()+" ";
                if(cb_f==1)
                    text=text+checkBox_s12f.getText().toString()+" ";
                if(checkflog==0)
                    Toast.makeText(getBaseContext(), "Please choose one!",
                            Toast.LENGTH_SHORT).show();
                else{
                    text=text+"\r\n";
                    save(text);
                    Intent intent = new Intent(getBaseContext(),EmailActivity.class);
                    startActivity(intent);
                }
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
