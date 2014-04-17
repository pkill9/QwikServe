package com.example.qwikserve.gui;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;



public class CookScreen extends Activity {

    private Firebase refIN;
    private Firebase refOUT;
    private static final String FIREBASE_URL = "https://qwickserve.firebaseio.com/";
    private ValueEventListener connectedListener;
    private OrderListAdapter orderListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_screen);
        refIN = new Firebase (FIREBASE_URL).child("cook");
        refOUT = new Firebase (FIREBASE_URL).child("done");
    }
    @Override
    public void onStart(){
        super.onStart();

        final GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setLongClickable(true);

        gridView.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int position, long arg3) {

                Order a = (Order)orderListAdapter.getItem(position);
                Toast.makeText(CookScreen.this,  a.getID(), Toast.LENGTH_SHORT).show();
                sendMessage(a);
                Firebase refDEL = refIN.child(a.getID());
                removeItem(refDEL);

                return true;
            }
        });

        orderListAdapter = new OrderListAdapter(refIN.limit(50),this, R.layout.order_text);
        gridView.setAdapter(orderListAdapter);
        orderListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                gridView.setSelection(orderListAdapter.getCount()-1);
            }
        });

        connectedListener = refIN.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean connected = (Boolean)dataSnapshot.getValue();
                if (connected) {
                    Toast.makeText(CookScreen.this, "Connected to Firebase Server", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CookScreen.this, "Disconnected from Firebase Server", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(FirebaseError E) {
                // No-op
            }
        });
    }
    public void removeItem(Firebase ref){
        ref.removeValue();
    }

    @Override
    public void onStop() {
        super.onStop();
        refIN.getRoot().child(".info/connected").removeEventListener(connectedListener);
        orderListAdapter.cleanup();
    }

    private void sendMessage(Order finishedOrder) {
            // Create our 'model', a Chat object
            Order orderF = finishedOrder;
            // Create a new, auto-generated child of that chat location, and save our chat data there
            refOUT.child(orderF.getID()).setValue(orderF);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cook_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
