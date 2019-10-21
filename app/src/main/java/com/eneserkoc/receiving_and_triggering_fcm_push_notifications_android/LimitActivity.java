package com.eneserkoc.receiving_and_triggering_fcm_push_notifications_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LimitActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private EditText limitField;
    private Button setButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        limitField = findViewById(R.id.limitField);
        setButton = findViewById(R.id.setButton);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(limitField.getText().toString())){

                    if(Integer.valueOf(limitField.getText().toString()) != 0){
                        setNewLimit(Integer.valueOf(limitField.getText().toString()));
                        Toast.makeText(getApplicationContext(), "New View Count Limit Set!", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getApplicationContext(), "Zero is not a valid limit value!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    private void setNewLimit(int limit) {

        mDatabase.child("data").child("view_count_limit").setValue(limit);
    }
}
