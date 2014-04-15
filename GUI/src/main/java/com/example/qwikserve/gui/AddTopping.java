package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class AddTopping extends Activity implements View.OnClickListener {

    private Order order;
    CheckBox a;
    CheckBox b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    CheckBox f;
    CheckBox g;
    CheckBox h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtopping);

        a= (CheckBox) findViewById(R.id.checkBox1);
        b= (CheckBox) findViewById(R.id.checkBox2);
        c= (CheckBox) findViewById(R.id.checkBox3);
        d= (CheckBox) findViewById(R.id.checkBox4);
        e= (CheckBox) findViewById(R.id.checkBox5);
        f= (CheckBox) findViewById(R.id.checkBox6);
        g= (CheckBox) findViewById(R.id.checkBox7);
        h= (CheckBox) findViewById(R.id.checkBox8);

        Button cont = (Button) findViewById(R.id.button11);

        cont.setOnClickListener(this);

        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.button11)
        {

            if(a.isChecked())
                order.addTopping("onions");
            if(b.isChecked())
                order.addTopping("tomatoes");
            if(c.isChecked())
                order.addTopping("mushrooms");
            if(d.isChecked())
                order.addTopping("lettuce");
            if(e.isChecked())
                order.addTopping("cheese");
            if(f.isChecked())
                order.addTopping("bacon");
            if(g.isChecked())
                order.addTopping("red pepper");
            if(h.isChecked())
                order.addTopping("spinach");

            order.addTopping("enditem");

            if(order.isCombo())
            {
                Intent intent2 = new Intent(AddTopping.this, AddSides.class);
                intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
                startActivity(intent2);
                finish();
            }
            else
            {
                Intent intent3 = new Intent(AddTopping.this, AddMain.class);
                intent3.putExtra("com.example.qwikserve.gui.Order.class",order);
                startActivity(intent3);
                finish();
            }

        }//end v.getId if

    }//end onClick
}
