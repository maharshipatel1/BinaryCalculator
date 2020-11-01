package com.application.programmerCalculator.ui.all_conversion;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.application.programmerCalculator.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class allConversionFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private TextView input_decimal;
    private TextView input_base;
    private TextView input_result;
    private EditText result;
    private EditText input;
    private Spinner spinner;
    private AdView mAdView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all_conversion, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdView = getView().findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input_decimal = (TextView) view.findViewById(R.id.textView4);
        input_base = (TextView) view.findViewById(R.id.textView5);
        input_result = (TextView) view.findViewById(R.id.textView11);
        result = (EditText) view.findViewById(R.id.editText7);
        input = (EditText) view.findViewById(R.id.editText11);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(input.hasFocus()){
                    if(input.getText().toString().equals("")){
                        result.setText("");
                    }
                    else {
                        int base = Integer.parseInt(spinner.getSelectedItem().toString());
                        try {
                            result.setText(SourceCode.result(input.getText().toString(), base));
                        }
                        catch (NumberFormatException e) {
                            result.setText("Invalid Number");
                        }
                        catch (Exception e) {
                            result.setText("Invalid Number");
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int base = Integer.parseInt((String)parent.getItemAtPosition(position));
        if(input.getText().toString().equals("")){
            result.setText("");
        }
        else {
            try {
                result.setText(SourceCode.result(input.getText().toString(), base));
            }
            catch (NumberFormatException e) {
                result.setText("Invalid Number");
            }
            catch (Exception e) {
                result.setText("Invalid Number");
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
