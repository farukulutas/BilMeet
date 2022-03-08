package com.example.bilmeetimagemap.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bilmeetimagemap.R;

public class SlideshowFragment extends Fragment {

    private int numOfClicks = 0;
    private Button filterbutton;
    private Switch spor;
    private Switch ders;
    private Switch sohbet;
    private Switch switch4;
    private Switch switch5;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        spor = root.findViewById(R.id.Spor);
        ders = root.findViewById(R.id.Ders);
        sohbet = root.findViewById(R.id.Sohbet);
        switch4 = root.findViewById(R.id.switch4);
        switch5 = root.findViewById(R.id.switch5);
        spor.setVisibility(View.GONE);
        ders.setVisibility(View.GONE);
        sohbet.setVisibility(View.GONE);
        switch4.setVisibility(View.GONE);
        switch5.setVisibility(View.GONE);
        filterbutton = root.findViewById(R.id.filterbutton);
        filterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfClicks++;
                if( numOfClicks % 2 != 0)
                {
                    spor.setVisibility(View.VISIBLE);
                    ders.setVisibility(View.VISIBLE);
                    sohbet.setVisibility(View.VISIBLE);
                    switch4.setVisibility(View.VISIBLE);
                    switch5.setVisibility(View.VISIBLE);
                }
                else {
                    spor.setVisibility(View.GONE);
                    ders.setVisibility(View.GONE);
                    sohbet.setVisibility(View.GONE);
                    switch4.setVisibility(View.GONE);
                    switch5.setVisibility(View.GONE);
                }
            }
        });

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;

    }
}
