package com.visualsharp.eventexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.myButton);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView  statusText = (TextView) findViewById(R.id.statusText);
                        statusText.setText("button Clicked");
                    }
                }
        );

        button.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView myTextView = (TextView) findViewById(R.id.myTextView);
                        myTextView.setText("Long button clicked");
                        //return  false;
                        return true;
                    }
                }
        );
    }
}
