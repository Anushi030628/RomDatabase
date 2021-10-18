package com.example.romdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.romdatabase.EntityClass.UserModel;

public class MainActivity extends AppCompatActivity {

    EditText name,number;
    Button save,getdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.edit_name);
        number=(EditText)findViewById(R.id.edit_number);
        save=(Button)findViewById(R.id.btn_submit);
        getdata=(Button)findViewById(R.id.btn_getdata);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GetData.class));
            }
        });
    }

    private void saveData(){

        String name_txt=name.getText().toString().trim();
        String number_txt=number.getText().toString().trim();


            UserModel model= new UserModel();

            model.setName(name_txt);
            model.setName(number_txt);

            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);


            name.setText("");
            number.setText("");


            Toast.makeText(this,"Record entered sucessfully",Toast.LENGTH_LONG).show();
        }

    }
