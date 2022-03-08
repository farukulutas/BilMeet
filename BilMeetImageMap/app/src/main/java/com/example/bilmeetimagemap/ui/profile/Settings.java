package com.example.bilmeetimagemap.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bilmeetimagemap.Profile2;
import com.example.bilmeetimagemap.R;

public class Settings extends AppCompatActivity {
    private EditText editBiography;
    private EditText editAdress;
    private EditText editFacebook;
    private ImageButton imageButton;

    private String adress;
    private String biography;
    private String facebook;

    private static final String SHARED_PREF_ADRESS = "adress";
    private static final String KEY_ADRESS = "key_adress";

    private static final String SHARED_PREF_BIOGRAPHY = "biography";
    private static final String KEY_BIOGRAPHY = "key_biography";

    private static final String SHARED_PREF_FACEBOOK = "facebook";
    private static final String KEY_FACEBOOK = "key_facebook";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editBiography = findViewById(R.id.biography);
        editAdress = findViewById(R.id.tv_address);
        editFacebook = findViewById(R.id.facebook);
        imageButton = findViewById(R.id.imageButton);

        displayAdress();
        displayBiography();
        displayFacebook();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAdress();
                saveBiography();
                saveFacebook();

                openMain2();
            }
        });



    }

    public void openMain2(){
        Intent intent = new Intent(this, Profile2.class);

        adress = editAdress.getText().toString();
        intent.putExtra("Adress",adress);

        biography = editBiography.getText().toString();
        intent.putExtra("Biography",biography);

        facebook = editFacebook.getText().toString();
        intent.putExtra("Facebook",facebook);

        startActivity(intent);
    }

    private void displayAdress(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_ADRESS, MODE_PRIVATE);
        String name = sp.getString(KEY_ADRESS,null);

        editAdress.setText(name);
    }

    private void saveAdress(){
        String name = editAdress.getText().toString().trim();
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_ADRESS, MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        e.putString(KEY_ADRESS, name);
        e.apply();
        editAdress.setText("");

        displayAdress();
    }

    private void displayBiography(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_BIOGRAPHY, MODE_PRIVATE);
        String biography = sp.getString(KEY_BIOGRAPHY,null);

        editBiography.setText(biography);

    }

    private void saveBiography(){
        String biography = editBiography.getText().toString().trim();
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_BIOGRAPHY, MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        e.putString(KEY_BIOGRAPHY, biography);
        e.apply();
        editBiography.setText("");

        displayBiography();
    }

    private void displayFacebook(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_FACEBOOK, MODE_PRIVATE);
        String facebook = sp.getString(KEY_FACEBOOK,null);

        editFacebook.setText(facebook);

    }

    private void saveFacebook(){
        String facebook = editFacebook.getText().toString().trim();
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_FACEBOOK, MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        e.putString(KEY_FACEBOOK, facebook);
        e.apply();
        editFacebook.setText("");

        displayFacebook();
    }

}



