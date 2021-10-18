package com.example.romdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdataData extends AppCompatActivity {

    EditText name,number;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_data);

        name=(EditText)findViewById(R.id.edit_name);
        number=(EditText)findViewById(R.id.edit_number);
        update=(Button)findViewById(R.id.btn_update);

        name.setText(getIntent().getExtras().getString("name"));
        number.setText(getIntent().getExtras().getString("number"));
        String id= getIntent().getExtras().getString("id");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_txt = name.getText().toString().trim();
                String number_txt=number.getText().toString().trim();

                if(name_txt.equals("") || number_txt.equals(""))
                {
                    Toast.makeText(UpdataData.this,"All Fields Required",Toast.LENGTH_LONG).show();

            }else
                {
                    DatabaseClass.getDatabase(getApplicationContext()).getDao().updateData(name_txt,number_txt,Integer.parseInt(id));
                    finish();
                }

        }


        });
    }
}

