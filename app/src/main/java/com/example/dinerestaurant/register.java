package com.example.dinerestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class register extends AppCompatActivity{
    public FirebaseAuth firebaseAut;
    public EditText fulllname, email,phone,password1;
    public ProgressDialog progressDialog;
    public TextView login;
    public Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAut = FirebaseAuth.getInstance();
        fulllname = findViewById(R.id.fullname);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        progressDialog = new ProgressDialog(this);
        register = findViewById(R.id.button);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();


            }
        });
    }
        public void Register(){
            String fullname=fulllname.getText().toString();
            String phon=phone.getText().toString();
            String emaill=email.getText().toString();
            String pass=password1.getText().toString();

            if (TextUtils.isEmpty(fullname)){
                fulllname.setError("Full Name is Required.");
                return;
            }
            else if (TextUtils.isEmpty(phon)){
                phone.setError("Phone Number is Required.");
                return;
            }

            else if (TextUtils.isEmpty(emaill)){
                email.setError("Email is Required.");
                return;
            }

            else if (TextUtils.isEmpty(pass)){
                password1.setError("Please Create a Password.");
                return;
            }

            else if (password1.length()<4){
                password1.setError("Password should be atleast 4 characters.");
                return;
            }

            else if (!isInvalidEmail(emaill)){
                email.setError("invalid Email.");
                return;
            }
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
            firebaseAut.createUserWithEmailAndPassword(emaill,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(register.this, home.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(register.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            });


        }
    public Boolean isInvalidEmail(CharSequence target) {
    return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    }


