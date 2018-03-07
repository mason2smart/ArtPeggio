package com.example.tony_laptop.phototomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    public void addListenerOnCamButton() {
        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final int REQUEST_IMAGE_CAPTURE = 1;
                Intent camIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (camIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(camIntent, REQUEST_IMAGE_CAPTURE);

                }
            }

            void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    mImageView.setImageBitmap(imageBitmap);
                }
            }

        });


    }*/

    public void addListenerBtnRandom() {
        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent processImage = new Intent();
            }

        });
    }
}
