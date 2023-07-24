package com.example.ils;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.textfield.TextInputEditText;

public class RegPage extends AppCompatActivity {
    //TODO:- Validate there is no empty fields
    //     - Connect to backend
    //     - Check if username and email exists
    //     - Redirect user to main activity after successful registration

    private TextInputEditText username, email, password, confirmPass;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);

        username = findViewById(R.id.regUsername);
        email = findViewById(R.id.emailEdttxt);
        confirmPass = findViewById(R.id.confirmpassword);
        password = findViewById(R.id.password);
        regBtn = (Button) findViewById(R.id.btnReg);

        regBtn.setOnClickListener(view -> Register());

    }

    private void Register(){
        String usernameTemp = username.getText().toString();
        String emailTemp = email.getText().toString();
        String passwordTemp = password.getText().toString();
        String confirmPassT = confirmPass.getText().toString();

        if(usernameTemp.equals("")||emailTemp.equals("")||passwordTemp.equals("")||confirmPassT.equals("")){
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }else if(!passwordTemp.equals(confirmPassT)){
//            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();

//            Drawable customErrorDrawable = getResources().getDrawable(R.drawable.ic_error);
//            customErrorDrawable.setBounds(-1, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            confirmPass.setError("Does not match", null);
        }else{
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            Intent AppView = new Intent(getApplicationContext(), AppView.class);
            startActivity(AppView);
        }
    }
}