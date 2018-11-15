package com.example.cristian.chatappfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Log_in extends AppCompatActivity
{

    private Toolbar mToolbar;

    private TextView email;
    private TextView password;

    private Button mLogInBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mToolbar = (Toolbar) findViewById(R.id.log_in_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (TextView) findViewById(R.id.log_in_email);
        password = (TextView) findViewById(R.id.log_in_password);
        mLogInBtn = (Button) findViewById(R.id.log_in_button);

        mLogInBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email_text = email.getText().toString();
                String password_text = password.getText().toString();

                if(TextUtils.isEmpty(email_text) || TextUtils.isEmpty(password_text))
                {
                    loginUser(email_text, password_text);
                }
            }
        });

    }

    private void loginUser(String email_text, String password_text)
    {



    }
}
