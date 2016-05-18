package com.Mathew.root.price_checker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainMenu extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.Mathew.root.price_checker.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    // Called when the user clicks the Enter button
    public void sendMessage(View view){
        Intent intent = new Intent(this, PriceScanner.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
