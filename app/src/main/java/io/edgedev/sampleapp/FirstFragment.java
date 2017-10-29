package io.edgedev.sampleapp;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import io.edgedev.sampleapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText mEditText;
    private int count = 0;

    public FirstFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       FragmentFirstBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        mEditText = binding.editText;
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTxt();
            }
        });
        return binding.getRoot();
    }

    public void changeTxt() {
        count++;
        mEditText.setText("Text has been changed " + count + " times");
    }
}
