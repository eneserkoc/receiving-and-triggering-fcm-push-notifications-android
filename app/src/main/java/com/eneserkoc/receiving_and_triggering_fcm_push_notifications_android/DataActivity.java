package com.eneserkoc.receiving_and_triggering_fcm_push_notifications_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eneserkoc.receiving_and_triggering_fcm_push_notifications_android.models.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private static final String TAG = "DataActivity";
    private TextView titleField, priceField, viewCountField, viewCountLimitField;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        titleField = findViewById(R.id.titleField);

        priceField = findViewById(R.id.priceField);

        viewCountField = findViewById(R.id.viewCountField);

        viewCountLimitField = findViewById(R.id.viewCountLimitField);

        button = findViewById(R.id.button);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("data");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Log.d("datasnap",dataSnapshot.toString());
                Data data = dataSnapshot.getValue(Data.class);
                Log.d("deneme", data.getTitle());
                titleField.setText(data.title);
                priceField.setText(Integer.toString(data.price));
                viewCountField.setText(Integer.toString(data.view_count));
                viewCountLimitField.setText(Integer.toString(data.view_count_limit));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(postListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this, LimitActivity.class);
                /*startActivityForResult(intent, 1);*/
                startActivity(intent);
            }
        });


    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }*/


}
