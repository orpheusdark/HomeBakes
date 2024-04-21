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

import java.util.ArrayList;

public class Admin_Update_Product extends AppCompatActivity {

    Button BTNUpdate, BTNBack;
    EditText PName, PQuantity, Price;
    TextView Proid, Pcategpry;
    Context context;
    private DBHelper Dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_product);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        BTNUpdate = findViewById(R.id.PUbtnUpdate);
        BTNBack = findViewById(R.id.PUbtnback);
        PName = findViewById(R.id.PUName);
        PQuantity = findViewById(R.id.PUQuantity);
        Price = findViewById(R.id.PUPrice);
        Proid = findViewById(R.id.ProductId);
        Pcategpry = findViewById(R.id.CategoryId);

        final String PID = getIntent().getStringExtra("id");
        ArrayList<Product> productdetails = Dbhelper.updateproductinsert(PID);

        if(productdetails.size()!=0) {
            Product product = productdetails.get(0);
            String Pid = product.getProductID();
            String Pname = product.getProductName();
            String PCid = product.getCategoryID();
            String Pquantity = String.valueOf(product.getQuantity());
            String PPrice = String.valueOf(product.getPrice());


            //set value to Edittext boxes
           PName.setText(Pname);
           PQuantity.setText(Pquantity);
           Price.setText(PPrice);
           Proid.setText(Pid);
           Pcategpry.setText(PCid);

           String ProductID = Pid;
        }


        BTNUpdate.setOnClickListener(new View.OnClickListener() {
            private String ProductID;

            @Override
            public void onClick(View view) {


                String Name = PName.getText().toString();
                String Quantity = PQuantity.getText().toString();
                String PPrice = Price.getText().toString();

                if (Name.isEmpty() || Quantity.isEmpty() || PPrice.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Empty Boxes", Toast.LENGTH_LONG).show();
                }
                else {

                    Product product = new Product(PID,Name,Integer.parseInt(Quantity),Integer.parseInt(PPrice));
                    int states = Dbhelper.UpdateProduct(product);

                    Toast.makeText(getApplicationContext(), "Product Update Successful", Toast.LENGTH_LONG).show();

                    Intent Updateclick = new Intent(Admin_Update_Product.this, Admin_Products.class);
                    startActivity(Updateclick);
                }





            }
        });


    }
}