package com.example.qwikserve.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddMain extends Activity implements View.OnClickListener {
    private Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmain);

        Button combo = (Button) findViewById(R.id.button4);
        Button burger = (Button) findViewById(R.id.button5);
        Button side = (Button) findViewById(R.id.button6);
        Button drink = (Button) findViewById(R.id.button7);
        Button review = (Button) findViewById(R.id.button8);

        combo.setOnClickListener(this);
        burger.setOnClickListener(this);
        side.setOnClickListener(this);
        drink.setOnClickListener(this);
        review.setOnClickListener(this);

        Intent intent1 = getIntent();
        order = (Order) intent1.getSerializableExtra("com.example.qwikserve.gui.Order.class");

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.button4)
        {//if add combo is clicked
            order.setCombo(true); //set combo to true
            order.addDrink();// add a drink
            order.addCost(11.0);// add the cost of a combo
            Intent intent2 = new Intent(AddMain.this,AddBurger.class);
            intent2.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent2);
            finish();
        }
        else if(v.getId()==R.id.button5)
        {//if add burger button is clicked
            order.setCombo(false); //set combo to false
            Intent intent3 = new Intent(AddMain.this,AddBurger.class);
            intent3.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent3);
            finish();
        }
        else if(v.getId()==R.id.button6)
        {// if add side is clicked
            order.setCombo(false);
            Intent intent4 = new Intent(AddMain.this,AddSides.class);
            intent4.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent4);
            finish();
        }
        else if(v.getId()==R.id.button7)
        {
            order.addDrink();// add a drink
            order.addCost(1.50); // add the cost
            //show a message
            Toast.makeText(getApplicationContext(), "1 Drink Added to Order", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.button8)
        {
            Intent intent5 = new Intent(AddMain.this,ReviewOrder.class);
            intent5.putExtra("com.example.qwikserve.gui.Order.class",order);
            startActivity(intent5);
            finish();
        }

    }
}
