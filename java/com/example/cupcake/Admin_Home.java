package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Home extends AppCompatActivity {

    Button BTNCategory, BTNProducts, BTNOrder, BTNLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        BTNCategory = findViewById(R.id.btncategoryA);
        BTNProducts = findViewById(R.id.btnProduct);
        BTNOrder = findViewById(R.id.btnOrders);
        BTNLogOut = findViewById(R.id.btnLogout);


        BTNCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Category = new Intent(Admin_Home.this, Admin_Category.class);
                startActivity(Category);

            }
        });

        BTNProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Products = new Intent(Admin_Home.this, Admin_Products.class);
                startActivity(Products);
            }
        });

        BTNOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Products = new Intent(Admin_Home.this, Admin_Order.class);
                startActivity(Products);
            }
        });

        BTNLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Logout successful", Toast.LENGTH_LONG).show();
                Intent Products = new Intent(Admin_Home.this, MainActivity.class);
                startActivity(Products);
            }
        });


    }
}