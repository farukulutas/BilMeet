package com.example.bilmeetimagemap;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bilmeetimagemap.R;
import com.example.bilmeetimagemap.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    EditText name, id, email,password,re_password;
    Button register;
    FirebaseAuth fAuth;
    String email2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_register, container, false);
        fAuth = FirebaseAuth.getInstance();
        email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);
        register = view.findViewById(R.id.btn_register);
        id = view.findViewById(R.id.et_id);
        name = view.findViewById(R.id.et_name);
        re_password = view.findViewById(R.id.et_repassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String password1 = password.getText().toString().trim();
                String re_password1 = re_password.getText().toString().trim();
                String id1 = id.getText().toString().trim();
                String name1 = name.getText().toString().trim();
                email2 = email.getText().toString().trim();

                if(TextUtils.isEmpty(email1))
                {
                    email.setError("Email is Required!");
                    return;
                }

                if(!contains())
                {
                    email.setError("Please Enter Bilkent Email");
                    return;
                }

                if(TextUtils.isEmpty(password1))
                {
                    password.setError("Password is Required!");
                    return;
                }


                if(!password1.equals(re_password1))
                {
                    if (TextUtils.isEmpty(password1)) {
                        re_password.setError("Password is Required!");
                        return;
                    } else {
                        re_password.setError("Passwords do not match!");
                        return;
                    }
                }

                if( id1.length() != 8 ) {
                    if (TextUtils.isEmpty(password1)) {
                        id.setError("Password is Required!");
                        return;
                    } else {
                        id.setError("Please enter proper id number!");
                        return;
                    }
                }

                if(TextUtils.isEmpty(name1))
                {
                    name.setError("Password is Required!");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity(), "Verification Email Has Been Sent", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("Verification Fail", "onFailure: Email not sent " + e.getMessage());
                                }
                            });
                            Intent in = new Intent(getActivity(), VerificationMain.class);
                            startActivity(in);
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public boolean contains()
    {
        String s = "";
        String example = "ug.bilkent.edu.tr";
        String shortOne;
        for( int i = email2.length() - 1; i >= 0; i--)
        {
            if(email2.charAt(i) == '@')
            {
                i = -1;
            }
            else
            {
                s = email2.charAt(i) + s;
            }
        }

        if(s.length() != example.length())
        {
            return false;
        }
        else
        {
            for(int j = 0;  j < example.length(); j++) {

                if (s.charAt(j) != example.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

    }
}

