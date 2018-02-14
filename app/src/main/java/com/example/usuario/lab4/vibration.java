package com.example.usuario.lab4;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vibration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        Button vibButton =(Button)findViewById(R.id.button_vibrate);
        vibButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Set the pattern for vibration
                long pattern[]={0,200,100,300,400}; // or you can just set a duration also in ms
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                //vibrator.vibrate(pattern, -1);
                if (Build.VERSION.SDK_INT >= 26) {
                    ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(1500,10));
                } else {
                    ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
                }

            }
        });
    }
}
