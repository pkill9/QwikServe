package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewOrder extends Activity implements View.OnClickListener {
    Order order;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revieworder);

        text = (TextView) findViewById(R.id.textview1);
        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");
        text.append(order.toString());

        text.append("\nTotal Cost: "+order.getCost()+"");

        Button cont = (Button) findViewById(R.id.button12);
        Button fin = (Button) findViewById(R.id.button13);
        cont.setOnClickListener(this);
        fin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.button12)
        {// if continue ordering is chosen
            Intent intent2 = new Intent(ReviewOrder.this,AddMain.class);
            intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent2);
            finish();
        }
        else if(v.getId()==R.id.button13);
        {// start the final ordering activity
            Intent intent3 = new Intent(ReviewOrder.this,FinalOrder.class);
            intent3.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent3);
            finish();
        }
    }
}
