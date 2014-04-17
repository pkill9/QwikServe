package com.example.qwikserve.gui;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.firebase.client.Query;


/**
 * This class is based of an example of how to use FirebaseListAdapter. It uses the <code>Order</code> class to encapsulate the
 * data for each individual orders posts
 */
public class OrderListAdapter extends FirebaseListAdapter<Order> {

    public OrderListAdapter(Query ref, Activity activity, int layout) {
        super(ref, Order.class, layout, activity);
    }

    /**
     * Bind an instance of the <code>Order</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
     * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
     * to the constructor, as well as a single <code>Order</code> instance that represents the current data to bind.
     * @param view A view instance corresponding to the layout we passed to the constructor.
     * @param order An instance representing the current state of a chat message
     */
    @Override
    protected void populateView(View view, Order order) {
        // Map a Order object to an entry in our GridView
        String burgers = order.getBurgersText();
        String sides = order.getSidesText();
        String id = order.getID();

        TextView burgerText = (TextView) view.findViewById(R.id.burgersTEXT);
        TextView sideText = (TextView) view.findViewById(R.id.sidesTEXT);
        TextView orderId = (TextView) view.findViewById(R.id.orderid);
        orderId.setText(id);
        burgerText.setText(burgers);
        sideText.setText(sides);
    }
}
