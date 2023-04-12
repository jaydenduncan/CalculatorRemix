package com.example.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculatorremix.databinding.TemperatureFragmentBinding;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TemperatureFragment extends Fragment {

    public static final String ARG_ID = "id";

    private TemperatureFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TemperatureFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DecimalFormat df = new DecimalFormat("0.0");

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(!(binding.fahrenheitEditText.getText().toString().equals(""))){

                        String fahrenheitText = binding.fahrenheitEditText.getText().toString();
                        double fahrenheitTemp = Double.valueOf(fahrenheitText);
                        double result = fToC(fahrenheitTemp);

                        String finalResult = df.format(result);

                        binding.celsiusEditText.setText(finalResult);

                    }
                    else if(!(binding.celsiusEditText.getText().toString().equals(""))){

                        String celsiusText = binding.celsiusEditText.getText().toString();
                        double celsiusTemp = Double.valueOf(celsiusText);
                        double result = cToF(celsiusTemp);

                        String finalResult = df.format(result);

                        binding.fahrenheitEditText.setText(finalResult);

                    }
                    else{
                        throw new NumberFormatException();
                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                    Toast toast = Toast.makeText(binding.getRoot().getContext(),
                            "ERROR: Please fill in at least one field with a valid number.",
                            Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    private double fToC(double fTemp){

        BigDecimal fTempDecimal = new BigDecimal(String.valueOf(fTemp));

        BigDecimal result1 = fTempDecimal.subtract(new BigDecimal("32"));
        result1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal finalResult = result1.multiply(new BigDecimal(String.valueOf(5/9.0)));
        finalResult.setScale(2, RoundingMode.HALF_UP);

        return finalResult.doubleValue();
    }

    private double cToF(double cTemp){

        BigDecimal cTempDecimal = new BigDecimal(String.valueOf(cTemp));

        BigDecimal result1 = cTempDecimal.multiply(new BigDecimal(String.valueOf(9/5.0)));
        result1.setScale(2, RoundingMode.HALF_UP);

        BigDecimal finalResult = result1.add(new BigDecimal("32"));
        finalResult.setScale(2, RoundingMode.HALF_UP);

        return finalResult.doubleValue();
    }

}
