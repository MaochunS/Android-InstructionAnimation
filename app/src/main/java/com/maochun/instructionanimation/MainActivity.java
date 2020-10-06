package com.maochun.instructionanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EnableDevSettingModeInstructionDialog dlg = new EnableDevSettingModeInstructionDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBtn = findViewById(R.id.button);
        showBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                dlg.show(MainActivity.this, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        dlg.show(this, null);
    }


}