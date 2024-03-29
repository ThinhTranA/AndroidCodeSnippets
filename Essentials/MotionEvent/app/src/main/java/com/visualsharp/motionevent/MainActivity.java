package com.visualsharp.motionevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.activity_main);

        myLayout.setOnTouchListener(
                new ConstraintLayout.OnTouchListener(){
                    public boolean onTouch(View v, MotionEvent m){
                        handleTouch(m);
                        return true;
                    }
                }
        );
    }

    void handleTouch(MotionEvent m)
    {
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        int pointerCount = m.getPointerCount();

        for(int i = 0; i< pointerCount; i++){
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;

            switch(action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP: actionString = "UP"; break;
                case MotionEvent.ACTION_POINTER_DOWN: actionString = "Pointer Down"; break;
                case MotionEvent.ACTION_POINTER_UP: actionString = "Pointer up"; break;
                case MotionEvent.ACTION_MOVE: actionString = "Move"; break;
                default:actionString = "";
            }
            String touchStatus = "Action:" + actionString + "Index:"  + actionIndex + "ID:" + id + "X:" + x + "Y:" + y;
            if(id ==0) textView1.setText(touchStatus);
            else textView2.setText(touchStatus);
        }
    }
}
