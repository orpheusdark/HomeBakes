package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin_Update_Category extends AppCompatActivity {

    EditText ETCId, ETCName;
    Button BTNUpdate, BTNReset;
    Context context;
    private DBHelper Dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_category);
        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        ETCId = findViewById(R.id.Cuid);
        ETCName = findViewById(R.id.CUname);
        BTNUpdate = findViewById(R.id.btnCUpdate);
        BTNReset = findViewById(R.id.btnCreset);

        //passing Value from Category list
        final  String CID = getIntent().getStringExtra("id");
        ArrayList<Category> categoryDetails = Dbhelper.updatecategoryinsert(CID);

        //getting value from database
        if(categoryDetails.size()!=0) {
            Category category = categoryDetails.get(0);
            String Cid = category.getCategoryId();
            String Cname = category.getCategoryName();

            //set value to Edittext boxes
            ETCId.setText(Cid);
            ETCName.setText(Cname);
        }


        BTNUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UPId = ETCId.getText().toString();
                String UPName = ETCName.getText().toString();

                if (UPId.isEmpty() || UPName.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Empty Boxes", Toast.LENGTH_LONG).show();
                }
                else {

                    Category category = new Category(UPId,UPName);
                    int states = Dbhelper.UpdateCategory(category);
                    Toast.makeText(getApplicationContext(), "Category Update Successful", Toast.LENGTH_LONG).show();
                    Intent Updateclick = new Intent(Admin_Update_Category.this, Admin_Category.class);
                    startActivity(Updateclick);




                }





            }
        });




    }
}