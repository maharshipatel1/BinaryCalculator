package com.application.programmerCalculator.ui.binary_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.application.programmerCalculator.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class calcFragment extends Fragment {
    private TextView num1;
    private TextView num2;
    private EditText num_1;
    private EditText num_2;
    private EditText answer;
    private TextView result;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private AdView mAdView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_binary_calc, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mAdView = getView().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        num1 = (TextView) view.findViewById(R.id.textView2);
        num2 = (TextView) view.findViewById(R.id.textView8);
        result = (TextView) view.findViewById(R.id.textView9);
        num_1 = (EditText) view.findViewById(R.id.editText2);
        num_2 = (EditText) view.findViewById(R.id.editText5);
        answer = (EditText) view.findViewById(R.id.editText6);
        button1 = (Button) view.findViewById(R.id.button10);
        button2 = (Button) view.findViewById(R.id.button11);
        button3 = (Button) view.findViewById(R.id.button12);
        button4 = (Button) view.findViewById(R.id.button7);
        button5 = (Button) view.findViewById(R.id.button8);
        button6 = (Button) view.findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.not(num_1.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.nor(num_1.getText().toString(), num_2.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.and(num_1.getText().toString(), num_2.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.or(num_1.getText().toString(), num_2.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.xor(num_1.getText().toString(), num_2.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    answer.setText(SourceCode.nand(num_1.getText().toString(), num_2.getText().toString()));
                }
                catch(NumberFormatException e){
                    answer.setText("Invalid numbers entered");
                }
            }
        });
    }
}