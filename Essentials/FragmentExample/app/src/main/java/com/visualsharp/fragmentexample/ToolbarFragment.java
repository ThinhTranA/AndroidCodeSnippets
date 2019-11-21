package com.visualsharp.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private static int seekValue = 10;
    private  static EditText edittext;

    ToolbarListener activityCallback;
    public interface ToolbarListener{
        public void onButtonClick(int fontsize, String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);

        edittext = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
        final Button button = (Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                buttonClicked(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCallback = (ToolbarListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement ToolbarListener");
        }
    }

    public void buttonClicked(View view){
        activityCallback.onButtonClick(seekValue, edittext.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekValue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
