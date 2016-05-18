package com.Mathew.root.price_checker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PriceScanner extends AppCompatActivity {

    private static final int ACTIVITY_START_CAMERA_APP = 0;
    private ImageView mPhotoCapturedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_scanner);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainMenu.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        mPhotoCapturedImageView = (ImageView) findViewById(R.id.capturePhotoImage);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);

    }

    public void takePhoto(View view) {
        Intent callCameraAppIntent = new Intent();
        callCameraAppIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(callCameraAppIntent, ACTIVITY_START_CAMERA_APP);

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK){
            //Toast.makeText(this, "Picture Taken Successfully", Toast.LENGTH_SHORT).show();
            Bundle extras = data.getExtras();
            Bitmap photoCapturedBitmap = (Bitmap) extras.get("data");
            mPhotoCapturedImageView.setImageBitmap(photoCapturedBitmap);
            Intent intent = getIntent();
            String message = intent.getStringExtra(MainMenu.EXTRA_MESSAGE);
            compare(message);
        }

    }

    public void compare(String message){

        if(message.compareToIgnoreCase("5.99") >= 0){
            Toast.makeText(this, "You can get this item", Toast.LENGTH_LONG).show();
        };
        if(message.compareToIgnoreCase(("5.99")) < 0){
            Toast.makeText(this, "Sorry, you cannot get this item", Toast.LENGTH_LONG).show();
        }
    }


}


