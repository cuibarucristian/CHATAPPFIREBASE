package com.example.cristian.chatappfirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity
{
    private TextView displayName;
    private TextView email;
    private TextView password;
    private Button mButtonCreateUser;

    private FirebaseAuth mAuth;

    private Toolbar mToolbar;

    //prrogress dialog
    private ProgressDialog mRegProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //toolbar
        mToolbar = (Toolbar) findViewById(R.id.register_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        mRegProgress = new ProgressDialog(this);

        displayName = (TextView) findViewById(R.id.reg_display_name);
        email = (TextView) findViewById(R.id.reg_email);
        password = (TextView) findViewById(R.id.reg_password);
        mButtonCreateUser = (Button) findViewById(R.id.reg_creage_button);



        mButtonCreateUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String display_name = displayName.getText().toString();
                String email_text = email.getText().toString();
                String password_text = password.getText().toString();

                if(!TextUtils.isEmpty(display_name ) || !TextUtils.isEmpty(email_text) || !TextUtils.isEmpty(password_text))
                {
                    mRegProgress.setTitle("Registering User");
                    mRegProgress.setMessage("Please wait");
                    mRegProgress.setCanceledOnTouchOutside(false);
                    mRegProgress.show();
                    register_user(display_name, email_text, password_text);
                }

            }
        });
    }


    private void register_user(String display_name, String email, String password)
    {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {

                if(task.isSuccessful())
                {
                    mRegProgress.dismiss();

                    Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();

                }else
                {
                    mRegProgress.hide();
                    Toast.makeText(RegisterActivity.this, "User can't be created", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
