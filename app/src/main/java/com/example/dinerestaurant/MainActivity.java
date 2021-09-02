package com.example.dinerestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView register;
    private TextView reset;
    private Button login;
    private EditText email,password1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        email = findViewById(R.id.email);
        password1 =findViewById(R.id.password);
        register=(TextView) findViewById(R.id.button7);
        reset=(TextView) findViewById(R.id.forgotpass);
        login=(Button) findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });

    reset.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(MainActivity.this,forgot_password.class);
            startActivity(intent);
        }
    });

        login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, home.class);
            startActivity(intent);

        }
    });


    }
//    public void Login(){
//        String emaill=email.getText().toString();
//        String pass=password1.getText().toString();
//
//         if (TextUtils.isEmpty(emaill)){
//            email.setError("Email is Required.");
//            return;
//        }
//
//        else if (TextUtils.isEmpty(pass)){
//            password1.setError("Enter  Password.");
//            return;
//        }
//
//        else if (password1.length()<6){
//            password1.setError("Password should be atleast 6 characters.");
//            return;
//        }
//
//        progressDialog.setMessage("Please Wait...");
//        progressDialog.show();
//        progressDialog.setCanceledOnTouchOutside(false);
//        firebaseAuth.signInWithEmailAndPassword(emaill, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, home.class);
//                    startActivity(intent);
//
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            }
//        });


    }
