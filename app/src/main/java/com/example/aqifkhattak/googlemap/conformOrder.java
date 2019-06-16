package com.example.aqifkhattak.googlemap;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class conformOrder extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button conform;
    private ProgressDialog mProgress;

    private EditText name, adress, mobile, email, city, quantity, dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User Details");
        setContentView(R.layout.activity_conform_order);
        conform = (Button) findViewById(R.id.confrom);
        name = (EditText) findViewById(R.id.nameid);
        adress = (EditText) findViewById(R.id.adressid);
        mobile = (EditText) findViewById(R.id.mobileid);
        email = (EditText) findViewById(R.id.emailid);
        city = (EditText) findViewById(R.id.city);
        quantity = (EditText) findViewById(R.id.quantity);
        dish = (EditText) findViewById(R.id.dishid);
        mProgress = new ProgressDialog(this);
        String titleId = "Your Data is saveing please wait...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");
        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgress.show();
              //  int mobiletext = Integer.parseInt(mobile.getText().toString());
                String nametext = name.getText().toString().trim();
                String adreestext = adress.getText().toString().trim();
                String emailtext = email.getText().toString().trim();
                String citytext = city.getText().toString().trim();
                String quantitytext = quantity.getText().toString().trim();
                String disttext = dish.getText().toString().trim();
//                if (mobile.length() > 11 || mobile.length() < 0 || mobile.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied Number", Toast.LENGTH_SHORT).show();
//                }
//                if (nametext.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied Name", Toast.LENGTH_SHORT).show();
//
//                }
//                if ((adreestext.equals(""))) {
//                    Toast.makeText(conformOrder.this, "Enter Valied Adress", Toast.LENGTH_SHORT).show();
//
//                }
//                if (emailtext.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied Email", Toast.LENGTH_SHORT).show();
//
//                }
//                if (citytext.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied City", Toast.LENGTH_SHORT).show();
//
//                }
//                if (quantitytext.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied quantity", Toast.LENGTH_SHORT).show();
//
//                }
//                if (disttext.equals("")) {
//                    Toast.makeText(conformOrder.this, "Enter Valied dish", Toast.LENGTH_SHORT).show();
//                } else {

                    mProgress.show();
                    databaseReference.push().setValue(nametext);
                    databaseReference.push().setValue(adreestext);
                    databaseReference.push().setValue(emailtext);
                    databaseReference.push().setValue(citytext);
                    databaseReference.push().setValue(quantitytext);
                    databaseReference.push().setValue(disttext);
                   // databaseReference.push().setValue(mobiletext);
                    mProgress.dismiss();
                    Toast.makeText(conformOrder.this, "Data Saved...", Toast.LENGTH_SHORT).show();
                    Intent last = new Intent(getApplicationContext(), lastActivity.class);
                    startActivity(last);
                }



        });
    }
}