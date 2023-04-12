package com.example.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculatorremix.databinding.DistanceFragmentBinding;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DistanceFragment extends Fragment {

    public static final String ARG_ID = "id";

    private DistanceFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceFragmentBinding.inflate(getLayoutInflater(), container, false);
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

                    if(!(binding.milesEditText.getText().toString().equals(""))){

                        String milesText = binding.milesEditText.getText().toString();
                        double milesValue = Double.valueOf(milesText);
                        double result = mToK(milesValue);

                        String finalResult = df.format(result);

                        binding.kilometersEditText.setText(finalResult);

                    }
                    else if(!(binding.kilometersEditText.getText().toString().equals(""))){

                        String kilometersText = binding.kilometersEditText.getText().toString();
                        double kilometersValue = Double.valueOf(kilometersText);
                        double result = kToM(kilometersValue);

                        String finalResult = df.format(result);

                        binding.milesEditText.setText(finalResult);

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

    private double mToK(double mValue){

        BigDecimal mValueDecimal = new BigDecimal(String.valueOf(mValue));

        // multiply miles value by the miles-to-kilometers constant
        BigDecimal result = mValueDecimal.multiply(new BigDecimal("1.609344"));
        result.setScale(2, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

    private double kToM(double kValue){

        BigDecimal kValueDecimal = new BigDecimal(String.valueOf(kValue));

        // multiply kilometers value by the kilometers-to-miles constant
        BigDecimal result = kValueDecimal.multiply(new BigDecimal("0.621371"));
        result.setScale(2, RoundingMode.HALF_UP);

        return result.doubleValue();

    }

}
