package com.example.ils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
public class MainActivity extends AppCompatActivity {
    private RelativeLayout parent;
    private Button loginBtn, regLink, notMember;
    private TextInputEditText username;
    private TextInputEditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.btnLogin);
        parent = findViewById(R.id.parentMain);
        regLink = findViewById(R.id.regLink);

        // onclick listeners
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        regLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent regPage = new Intent(getApplicationContext(), RegPage.class);
                startActivity(regPage);
            }
        });

    }
    private void loginSuccessSnackBar(String responce){
        Snackbar.make(parent, responce, Snackbar.LENGTH_SHORT).show();
    }

    private void Login(){
        String usernameTemp = username.getText().toString();
        String passwordTemp = password.getText().toString();
        if(usernameTemp.equals("") && passwordTemp.equals("")){
            loginSuccessSnackBar("Please enter username and Password");
        }else if(usernameTemp.equals("")){
            loginSuccessSnackBar("Please enter your username");
        }else if(passwordTemp.equals("")){
            loginSuccessSnackBar("Please enter your password");
        }else{
            loginSuccessSnackBar("Login SuccessFull");
            Intent AppView = new Intent(getApplicationContext(), AppView.class);
            startActivity(AppView);
            finish();
        }
    }
}