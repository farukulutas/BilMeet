package com.example.bilmeetimagemap.ui.middle;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.example.bilmeetimagemap.PinView;
import com.example.bilmeetimagemap.R;


public class MiddleFragment extends Fragment {



    private MiddleViewModel middleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        middleViewModel =
                ViewModelProviders.of(this).get(MiddleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_middle, container, false);
        // final TextView textView = root.findViewById(R.id.text_home);
        middleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        final PinView imageView = root.findViewById(R.id.imageView3);
        imageView.setImage(ImageSource.resource(R.drawable.middle));
        imageView.addPin(new PointF(1000f, 2000f
        ));

        return root;
    }


}
