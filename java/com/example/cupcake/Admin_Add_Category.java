package com.example.cupcake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Add_Category extends AppCompatActivity {

    EditText CId, CName;
    Button AddCategory, Creset;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_category);

        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        CId = findViewById(R.id.Cid);
        CName = findViewById(R.id.Cname);
        AddCategory = findViewById(R.id.BtnCAdd);
        Creset = findViewById(R.id.btnCreset);

        AddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Id = CId.getText().toString();
                String Name = CName.getText().toString();

                if(Id.isEmpty() || Name.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Boxes are Empty", Toast.LENGTH_LONG).show();
                }
                else{

                    Category category = new Category(Id,Name);
                    if(dbHelper.InsertCategory(category))
                    {
                        Toast.makeText(getApplicationContext(),Name + " category insert",Toast.LENGTH_LONG).show();
                        Intent Category = new Intent(Admin_Add_Category.this, Admin_Category.class);
                        startActivity(Category);

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Cant category insert",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Creset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CId.setText("");
                CName.setText("");

            }
        });


    }
}