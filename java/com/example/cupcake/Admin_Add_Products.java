package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Vector;

public class Admin_Add_Products extends AppCompatActivity {

    EditText etId, etName, etQuantity, etPrice;
    Button btnAddProduct, btnReset;
    Spinner PSpinner;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_products);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        etId = findViewById(R.id.PId);
        etName = findViewById(R.id.PName);
        etQuantity = findViewById(R.id.PQuantity);
        etPrice = findViewById(R.id.PPrice);
        btnAddProduct = findViewById(R.id.PbtnAdd);
        btnReset =findViewById(R.id.Pbtnreset);
        PSpinner = findViewById(R.id.Pspinner);

        Vector<String> vecCategory = dbHelper.getCategory_Name();    // getCategory_name

        ArrayAdapter ad= new ArrayAdapter(this, android.R.layout.simple_spinner_item,vecCategory);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PSpinner.setAdapter(ad);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Id = etId.getText().toString();
                String Name = etName.getText().toString();
                String Quantity = etQuantity.getText().toString();
                String Price = etPrice.getText().toString();
                String Type = dbHelper.getCategory_Id(PSpinner.getSelectedItem().toString());    //getcategory_Id

                if(Id.isEmpty() || Name.isEmpty() || Quantity.isEmpty() || Price.isEmpty() || Type.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Boxes are Empty", Toast.LENGTH_LONG).show();
                }

                else{

                    Product product = new Product(Id, Name, Type,Integer.parseInt(Quantity), Integer.parseInt(Price));

                    if (dbHelper.InsertProduct(product))
                    {
                        Toast.makeText(getApplicationContext(),Name + " product insert",Toast.LENGTH_LONG).show();
                        Intent Category = new Intent(Admin_Add_Products.this, Admin_Products.class);
                        startActivity(Category);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Cant product insert",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etId.setText("");
                etName.setText("");
                etQuantity.setText("");
                etPrice.setText("");
            }
        });






    }
}