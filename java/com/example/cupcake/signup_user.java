package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup_user extends AppCompatActivity {

    private DBHelper dbHelper;
    Button btnsignup, btnreset;
    EditText etname, etpassword, etcompasssword, etemail, etmobileno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();


        etname = findViewById(R.id.Uusername);
        etpassword = findViewById(R.id.Upassword);
        etcompasssword = findViewById(R.id.Ucompassword);
        etemail = findViewById(R.id.Uemail);
        etmobileno = findViewById(R.id.Umobileno);
        btnsignup = findViewById(R.id.Usignup);
        btnreset = findViewById(R.id.Ureset);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etname.getText().toString();
                String password = etpassword.getText().toString();
                String compasword = etcompasssword.getText().toString();
                String email = etemail.getText().toString();
                String mobileNo = etmobileno.getText().toString();
                String usertype = "User";

                if(username.isEmpty() || password.isEmpty() || compasword.isEmpty() || email.isEmpty() || mobileNo.isEmpty() )
                {
                    Toast.makeText(getApplicationContext(),"Text box is Empty", Toast.LENGTH_LONG).show();
                }
                else if(username.length()>4 || password.length()>4 || compasword.length()>4)
                {
                    if(mobileNo.length()==10)
                    {
                        if(password.equals(compasword))
                        {
                            User user = new User(username, email, mobileNo, password, usertype);
                            if(dbHelper.CreateUser(user));
                            {
                                Toast.makeText(getApplicationContext(),"User Signup Successful", Toast.LENGTH_LONG).show();
                                Intent Admin = new Intent(signup_user.this, Login.class);
                                startActivity(Admin);
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Passwords are not matched", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Mobile.No is not completed", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Minimum 4 characters input", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etname.setText("");
                etpassword.setText("");
                etcompasssword.setText("");
                etemail.setText("");
                etmobileno.setText("");

            }
        });


    }
}