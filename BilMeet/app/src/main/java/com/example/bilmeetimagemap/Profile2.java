package com.example.bilmeetimagemap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilmeetimagemap.ui.profile.Settings;

public class Profile2 extends AppCompatActivity {
    private ImageButton button;
    ImageView reportButtonView;
    private ImageButton button2;

    TextView textAdress;
    TextView textBiography;
    TextView textFacebook;

    String adress;
    String biography;
    String facebook;
    static Context context;
    public static Context getAppContext() {
        return Profile2.context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        Profile2.context = getApplicationContext();
        textAdress = findViewById(R.id.tv_address);
        adress = getIntent().getExtras().getString("Adress");
        textAdress.setText(adress);

        textBiography = findViewById(R.id.biography);
        biography = getIntent().getExtras().getString("Biography");
        textBiography.setText(biography);

        textFacebook = findViewById(R.id.facebook);
        facebook = getIntent().getExtras().getString("Facebook");
        textFacebook.setText(facebook);

        button2 = (ImageButton) findViewById(R.id.ppButton1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        reportButtonView = (ImageView) findViewById(R.id.reportButton);

        reportButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from( context);
                View reportDialogView = li.inflate( R.layout.report_button_dialog, null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder( context);
                alertDialog.setView( reportDialogView);
                alertDialog.setMessage( "Report the problem about the user.")
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // send written text to the database
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });

        button = (ImageButton) findViewById(R.id.ppButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }
    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
