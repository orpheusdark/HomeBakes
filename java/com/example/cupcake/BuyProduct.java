package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyProduct extends AppCompatActivity {

    Button BTNBuyNow, BTNCancel;
    EditText ETQuantity, ETName;
    TextView Proid, ProName ,Pcategpry, ProQuantity, ProPrice;
    Context context;
    private DBHelper Dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);


        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        Proid = findViewById(R.id.txtPID);
        ProName = findViewById(R.id.txtPname);
        Pcategpry = findViewById(R.id.txtPCid);
        ProQuantity = findViewById(R.id.txtPQuantity);
        ProPrice = findViewById(R.id.txtPPrice);

        BTNBuyNow = findViewById(R.id.btnBuynow);
        BTNCancel = findViewById(R.id.btncancel);
        ETQuantity = findViewById(R.id.ETQuantity);
        ETName = findViewById(R.id.customername);


        final String PID = getIntent().getStringExtra("id");
        final String Name = getIntent().getStringExtra("Name");
        final String Category = getIntent().getStringExtra("Category Name");
        final String Quantity = getIntent().getStringExtra("Quantity");
        final String Price = getIntent().getStringExtra("Price");

        Proid.setText(PID);
        ProName.setText(Name);
        Pcategpry.setText(Category);
        ProQuantity.setText(Quantity);
        ProPrice.setText(Price);


        int Qu = Integer.parseInt(Quantity);
        int price = Integer.parseInt(Price);


        BTNBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CustomerName = ETName.getText().toString();
                int buyQuantity = Integer.parseInt(String.valueOf(ETQuantity.getText()));


                int total = buyQuantity * price;

                Toast.makeText(getApplicationContext(), "Total is " + total, Toast.LENGTH_LONG).show();

                Order order = new Order(CustomerName,PID,buyQuantity,total);
                Dbhelper.InsertOrder(order);

                // Redirect to PaymentActivity
                Intent paymentIntent = new Intent(BuyProduct.this, PaymentActivity.class);
                startActivity(paymentIntent);


            }
        });


        BTNCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cencel = new Intent(BuyProduct.this, User_Home.class);
                startActivity(cencel);
            }
        });








    }
}