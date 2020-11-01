package com.application.programmerCalculator.ui.binary_conversion;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.application.programmerCalculator.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class conversionFragment extends Fragment {
    private TextView binary;
    private TextView decimal;
    private TextView hexadecimal;
    private EditText binary_input;
    private EditText decimal_input;
    private EditText hexadecimal_input;
    private AdView mAdView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_conversion, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdView = getView().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        binary = (TextView) view.findViewById(R.id.textView3);
        decimal = (TextView) view.findViewById(R.id.textView6);
        hexadecimal = (TextView) view.findViewById(R.id.textView7);
        binary_input = (EditText) view.findViewById(R.id.editText1);
        decimal_input = (EditText) view.findViewById(R.id.editText2);
        hexadecimal_input = (EditText) view.findViewById(R.id.editText3);

        binary_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binary_input.hasFocus()) {
                    try {
                        hexadecimal_input.setText(String.valueOf(SourceCode.bin2Hex(binary_input.getText().toString())));
                    } catch (NumberFormatException e) {
                        if (binary_input.getText().toString().equals("")) {
                            hexadecimal_input.setText("");
                        }
                        else {
                            hexadecimal_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        hexadecimal_input.setText("");
                    }

                    try {
                        if(SourceCode.bin2Dec(binary_input.getText().toString()) == -1){
                            throw new NumberFormatException();
                        }
                        decimal_input.setText(String.valueOf(SourceCode.bin2Dec(binary_input.getText().toString())));
                    } catch (NumberFormatException e) {
                        if (binary_input.getText().toString().equals("")) {
                            decimal_input.setText("");
                        } else {
                            decimal_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        decimal_input.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        decimal_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (decimal_input.hasFocus()) {
                    try {
                        binary_input.setText(String.valueOf(SourceCode.dec2Bin(Integer.parseInt(decimal_input.getText().toString()))));
                    } catch (NumberFormatException e) {
                        if (decimal_input.getText().toString().equals("")) {
                            binary_input.setText("");
                        } else {
                            binary_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        binary_input.setText("");
                    }

                    try {
                        hexadecimal_input.setText(String.valueOf(SourceCode.dec2Hex(Integer.parseInt(decimal_input.getText().toString()))));
                    } catch (NumberFormatException e) {
                        if (decimal_input.getText().toString().equals("")) {
                            hexadecimal_input.setText("");
                        } else {
                            hexadecimal_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        hexadecimal_input.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        hexadecimal_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(hexadecimal_input.hasFocus()) {
                    try {
                        binary_input.setText(String.valueOf(SourceCode.hex2Bin(hexadecimal_input.getText().toString())));
                    } catch (NumberFormatException e) {
                        if (hexadecimal_input.getText().toString().equals("")) {
                            binary_input.setText("");
                        } else {
                            binary_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        binary_input.setText("");
                    }

                    try {
                        decimal_input.setText(String.valueOf(SourceCode.hex2Dec(SourceCode.reverse(hexadecimal_input.getText().toString()))));
                    } catch (NumberFormatException e) {
                        if (hexadecimal_input.getText().toString().equals("")) {
                            decimal_input.setText("");
                        } else {
                            decimal_input.setText("Invalid Number");
                        }
                    } catch (Exception e) {
                        decimal_input.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
