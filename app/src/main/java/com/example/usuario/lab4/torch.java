package com.example.usuario.lab4;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

@SuppressWarnings("deprecation")
public class torch extends AppCompatActivity {

    private CameraManager mCameraManager;
    private String mCameraId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);


        Button onButton =(Button)findViewById(R.id.button_on);
        onButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

                try {
                    mCameraId = mCameraManager.getCameraIdList()[0];
                } catch (CameraAccessException e){
                    e.printStackTrace();
                }
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        mCameraManager.setTorchMode(mCameraId, true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button offButton =(Button)findViewById(R.id.button_off);
        offButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        mCameraManager.setTorchMode(mCameraId, false);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }

}
