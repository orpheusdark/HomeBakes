package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class User_Home extends AppCompatActivity {

    Button BTNProduct, BTNLogout, BTNOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        BTNProduct = findViewById(R.id.btnproducts);
        BTNLogout = findViewById(R.id.btnlogout);
        BTNOrder = findViewById(R.id.btnOrderu);

        BTNProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Userproduct = new Intent(User_Home.this, User_Category.class);
                startActivity(Userproduct);


            }
        });

        BTNLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Logout successful", Toast.LENGTH_LONG).show();
                Intent GoLogin = new Intent(User_Home.this, MainActivity.class);
                startActivity(GoLogin);
            }
        });


        BTNOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Order = new Intent(User_Home.this, User_Order.class);
                startActivity(Order);
            }
        });


    }
}