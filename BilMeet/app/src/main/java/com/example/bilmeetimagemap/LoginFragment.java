package com.example.bilmeetimagemap;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bilmeetimagemap.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.app.ProgressDialog.show;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    FirebaseAuth fAuth;
    EditText loginEmail, loginPassword;
    ProgressBar bar;
    TextView forgot, notVerified;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        fAuth = FirebaseAuth.getInstance();
        loginEmail = view.findViewById(R.id.et_email);
        loginPassword = view.findViewById(R.id.et_password);
        bar = view.findViewById(R.id.progressBar);
        forgot = view.findViewById(R.id.forgot_password);
        Button button = view.findViewById(R.id.btn_login);

        if(fAuth.getCurrentUser() != null )
        {
            if(!fAuth.getCurrentUser().isEmailVerified())
            {
                Intent ver = new Intent(getActivity(), VerificationMain.class);
                startActivity(ver);
            }
            else
            {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    loginEmail.setError("Email is Required!");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    loginPassword.setError("Password is Required!");
                    return;
                }

                bar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            Toast.makeText(getActivity(), "Logged in successfully!",Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(getActivity(), VerificationMain.class);
                            startActivity(in);
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            bar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Do you want to reset your password?");
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = loginEmail.getText().toString().trim();
                        fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getActivity(), "Reset Link Sent To Your Bilkent Email!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Error! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                passwordResetDialog.create().show();
            }
        });


        return view;
    }

}