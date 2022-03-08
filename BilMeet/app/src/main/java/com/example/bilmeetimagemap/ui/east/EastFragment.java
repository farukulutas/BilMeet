package com.example.bilmeetimagemap.ui.east;

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


public class EastFragment extends Fragment {

    private EastViewModel eastViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eastViewModel =
                ViewModelProviders.of(this).get(EastViewModel.class);
        View root = inflater.inflate(R.layout.fragment_east, container, false);
        //final TextView textView = root.findViewById(R.id.text_east);
        eastViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // textView.setText(s);
            }
        });
        final PinView imageView = root.findViewById(R.id.imageView2);
        imageView.setImage(ImageSource.resource(R.drawable.east));
        imageView.addPin(new PointF(700f, 2800f));
        imageView.addPin(new PointF(1750f, 1200f));
        return root;
    }
}
