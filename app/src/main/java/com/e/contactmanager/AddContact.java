package com.e.contactmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    Button anc_btn_save, anc_btn_cancel;
    ToggleButton anc_tb_ContactType;
    EditText anc_et_Name, anc_et_Phone, anc_et_Email, anc_et_Address, anc_et_City, anc_et_State, anc_et_Zipcode, anc_et_Country, anc_et_WorkPhone, anc_et_Hobby, anc_et_BizPhone, anc_et_OpenHour, anc_et_CloseHour, anc_et_Website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_contact);

        anc_btn_cancel = findViewById(R.id.anc_btn_cancel);
        anc_btn_save = findViewById(R.id.anc_btn_save);
        //
        anc_et_Name = findViewById(R.id.anc_et_Name);
        anc_et_Phone = findViewById(R.id.anc_et_WorkPhone);
        anc_et_Email = findViewById(R.id.anc_et_WorkPhone);
        anc_et_Address = findViewById(R.id.anc_et_WorkPhone);
        anc_et_City = findViewById(R.id.anc_et_WorkPhone);
        anc_et_State = findViewById(R.id.anc_et_WorkPhone);
        anc_et_Zipcode = findViewById(R.id.anc_et_WorkPhone);
        anc_et_Country = findViewById(R.id.anc_et_WorkPhone);
        //
        anc_et_WorkPhone = findViewById(R.id.anc_et_WorkPhone);
        anc_et_Hobby = findViewById(R.id.anc_et_Hobby);
        //
        anc_et_BizPhone = findViewById(R.id.anc_et_BizPhone);
        anc_et_OpenHour = findViewById(R.id.anc_et_OpenHour);
        anc_et_CloseHour = findViewById(R.id.anc_et_CloseHour);
        anc_et_Website = findViewById(R.id.anc_et_Website);
        //
        anc_tb_ContactType = findViewById(R.id.anc_tb_ContactType);

        toggleCheck(anc_tb_ContactType);

        anc_tb_ContactType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleCheck(isChecked);
            }
        });


        // Listen for incoming data
        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null){
            int position = incomingIntent.getInt("position");
            int contact_UID = incomingIntent.getInt("uid");
        }

        anc_btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        anc_btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // String newName = et_name.getText().toString();
                //String newAge = et_age.getText().toString();
                //String newPicID = et_picID.getText().toString();

                Intent i = new Intent(view.getContext(), MainActivity.class);

             //   i.putExtra("edit", positionToEdit);
              //  i.putExtra("name", newName);
               // i.putExtra("age", newAge);
               // i.putExtra("picID", newPicID);

                startActivity(i);
            }
        });
    }


    private void toggleCheck(ToggleButton x){
        // Personal Contact
        if (x.isChecked()){
            anc_et_WorkPhone.setVisibility(View.VISIBLE);
            anc_et_Hobby.setVisibility(View.VISIBLE);
            //
            anc_et_BizPhone.setVisibility(View.GONE);
            anc_et_OpenHour.setVisibility(View.GONE);
            anc_et_CloseHour.setVisibility(View.GONE);
            anc_et_Website.setVisibility(View.GONE);
        } // Business Contact
        else if (!x.isChecked()){
            anc_et_WorkPhone.setVisibility(View.GONE);
            anc_et_Hobby.setVisibility(View.GONE);
            //
            anc_et_BizPhone.setVisibility(View.VISIBLE);
            anc_et_OpenHour.setVisibility(View.VISIBLE);
            anc_et_CloseHour.setVisibility(View.VISIBLE);
            anc_et_Website.setVisibility(View.VISIBLE);
        }
    }

    private void toggleCheck(Boolean x){
        // Personal Contact
        if (x){
            anc_et_WorkPhone.setVisibility(View.VISIBLE);
            anc_et_Hobby.setVisibility(View.VISIBLE);
            //
            anc_et_BizPhone.setVisibility(View.GONE);
            anc_et_OpenHour.setVisibility(View.GONE);
            anc_et_CloseHour.setVisibility(View.GONE);
            anc_et_Website.setVisibility(View.GONE);
        } // Business Contact
        else if (!x){
            anc_et_WorkPhone.setVisibility(View.GONE);
            anc_et_Hobby.setVisibility(View.GONE);
            //
            anc_et_BizPhone.setVisibility(View.VISIBLE);
            anc_et_OpenHour.setVisibility(View.VISIBLE);
            anc_et_CloseHour.setVisibility(View.VISIBLE);
            anc_et_Website.setVisibility(View.VISIBLE);
        }
    }
}
