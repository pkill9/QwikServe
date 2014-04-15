package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OrderMain extends Activity implements View.OnClickListener {
    private Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordermain);

        Button a = (Button) findViewById(R.id.button3);
        a.setOnClickListener(this);
        //Initialize empty order object here
        order = new Order();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button3)
        {
            Intent intent = new Intent(OrderMain.this,AddMain.class);
            intent.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent);
            finish();
        }

    }
}
