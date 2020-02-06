package com.hojennifer.quizapp;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText responseText1;
    EditText responseText2;
    TextView displayView;
    Button changeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.clickButton);
        responseText1 = findViewById(R.id.responseEditText);
        responseText2 = findViewById(R.id.responseEditText2);
        displayView = findViewById(R.id.textBox);
        changeButton = findViewById(R.id.changeButton);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (submitButton.getText().toString().equals("CLEAR")) {
                    responseText1.setText("");
                    responseText2.setText("");
                    submitButton.setText("SUBMIT");

                } else { //says SUBMIT
                    Log.i("userInfo", "" + responseText1.getText().toString() + ", https://github.com/" + responseText2.getText().toString());
                    displayView.setText("https://github.com/" + responseText2.getText().toString());
                    String gitLink = "https://github.com/" + responseText2.getText().toString();
                    String clickLink = " <a href=" + gitLink + ">Your GitHub link!</a>";
                    displayView.setMovementMethod(LinkMovementMethod.getInstance());
                    displayView.setText(Html.fromHtml(clickLink));
                    submitButton.setText("CLEAR");
                }
            }
        });
        /*responseText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!hasFocus) {
                    if (responseText.getText().toString().equals("TJ")) {
                        displayView.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name.");
                    }
                }
            }
        });*/
    }

    public void changeColor(View view) {
        int color = ((ColorDrawable)changeButton.getBackground()).getColor();
        Log.i("startColor", ""+color);
        Log.i("origColor", ""+R.color.changeColorButton);
        if(color == getResources().getColor(R.color.changeColorButton)){ //if orig, change to new
            changeButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        else{ //if new, change to orig
            changeButton.setBackgroundColor(getResources().getColor(R.color.changeColorButton));
        }
    }
}
