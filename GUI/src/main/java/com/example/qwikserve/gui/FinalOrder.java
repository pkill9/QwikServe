package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class FinalOrder extends Activity implements View.OnClickListener {

    public Order order;
    public EditText name;

    private Firebase ref;
    private static final String FIREBASE_URL = "https://qwickserve.firebaseio.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalorder);

        name = (EditText) findViewById(R.id.editText1);
        Button submit = (Button) findViewById(R.id.button14);
        submit.setOnClickListener(this);
        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");
        ref = new Firebase(FIREBASE_URL).child("cook");

    }

    @Override
    public void onClick(View v)
    {   // this is the last submit button
        if(v.getId()==R.id.button14)
        {
            order.setName(name.getText().toString()); // get name from user input add to order object
            // NOTE: the toString method of order does not include customer name or price just the order strings, can be easily added if needed
            Toast.makeText(getApplicationContext(), "Thank you for your order, a waiter will be with you shortly.", Toast.LENGTH_SHORT).show();


            ref.child(order.getID()).setValue(order);

            /*
                Here is where you have to throw the object to wherever you need to throw it to via an intent
                Intent intent = new Intent(ReviewOrder.this,<yourclass>.class);
                intent.putExtra("<your-package>.Order.class",order);
                startActivity(intent);

                Currently this activity clears the Order object, and starts the main activity again
                so that new orders can be placed, just comment out the next few lines  out if it causes
                problems when to trying to pass the Order object to your activity.

             */

            order = new Order();
            Intent intent2 = new Intent(FinalOrder.this,AddMain.class);
            intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent2);
            finish();

        }
    }
}
