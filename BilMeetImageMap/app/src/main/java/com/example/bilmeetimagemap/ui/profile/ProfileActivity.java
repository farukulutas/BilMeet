package com.example.bilmeetimagemap.ui.profile;

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

import com.example.bilmeetimagemap.R;

public class ProfileActivity extends AppCompatActivity {


    private ImageButton button;
    ImageView reportButtonView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
