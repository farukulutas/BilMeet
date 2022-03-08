package com.example.bilmeetimagemap.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.bilmeetimagemap.EventProperties;
import com.example.bilmeetimagemap.MainActivity;
import com.example.bilmeetimagemap.PinView;
import com.example.bilmeetimagemap.Profile2;
import com.example.bilmeetimagemap.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    View root;
    int count = 0;
    Context context = Profile2.getAppContext();
    ArrayList<Float> xList = new ArrayList<>();
    ArrayList<Float> yList = new ArrayList<>();
    ArrayList<EventProperties> aBuilding = new ArrayList<>();
    ArrayList<EventProperties> bBuilding = new ArrayList<>();
    ArrayList<EventProperties> fBuilding = new ArrayList<>();


    float x1 = 250f;
    float x2 = 1900f;
    float x3 = 1200f;
    float y1 = 1600f;
    float y2 = 1000f;
    float y3 = 1500f;

    TextView data;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });



        //SubsamplingScaleImageView imageView2 = (SubsamplingScaleImageView)root.findViewById(R.id.imageView2);
        //imageView2.setImage(ImageSource.resource(R.drawable.main));
        final PinView imageView = root.findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.main));
        imageView.addPin(new PointF(x1, y1));
        imageView.addPin(new PointF(x2, y2));
        imageView.addPin(new PointF(x3,y3));
        xList.add(x1);
        xList.add(x2);
        xList.add(x3);
        yList.add(y1);
        yList.add(y2);
        yList.add(y3);

        /*data = root.findViewById(R.id.nameOfTheText);
        Bundle arrived = getIntent().getExtras();
        String taken = arrived.getString("text");
        arrived.setText(taken);*/

        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                PointF f = imageView.viewToSourceCoord(event.getX(), event.getY());
                //for(int i = 0; i < xList.size(); i++) {
                LayoutInflater li = inflater;
                LayoutInflater li2 = inflater;
                LayoutInflater li3 = inflater;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(getContext());
                AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(getContext());

                if (f.x < 400f && f.x > 100f && f.y < 1650f && f.y > 1300f) {
                    //imageView.addPin(new PointF(f.x, f.y));

                    View reportDialogView = li.inflate(R.layout.fragment_clicked_dialog2, null);

                    alertDialog.setView(reportDialogView);
                    if (count == 0) {

                        alertDialog.setMessage("Events in the region you clicked")
                                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        dialog.dismiss();
                                        count = 0;
                                    }
                                }).show();
                        count++;
                    }
                }
                else if (f.x < 2050f && f.x > 1750f && f.y < 1050f && f.y > 700f) {
                    //imageView.addPin(new PointF(f.x, f.y));

                    View reportDialogView2 = li2.inflate(R.layout.fragment_clicked_dialog, null);
                    alertDialog2.setView(reportDialogView2);
                    if (count == 0) {

                        alertDialog2.setMessage("Events in the region you clicked")
                                .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog2, int which) {

                                        dialog2.dismiss();
                                        count = 0;
                                    }
                                }).show();
                        count++;
                    }
                }
                else if (f.x < 1350f && f.x > 1050f && f.y < 1550f && f.y > 1200f) {
                    //imageView.addPin(new PointF(f.x, f.y));

                    View reportDialogView3 = li3.inflate(R.layout.fragment_clicked_dialog3, null);

                    alertDialog3.setView(reportDialogView3);
                    if (count == 0) {

                        alertDialog3.setMessage("Events in the region you clicked")
                                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog1, int which) {

                                        dialog1.dismiss();
                                        count = 0;
                                    }
                                }).show();
                        count++;
                    }
                }
                return true;
            }
    });


        return root;
    }


}
