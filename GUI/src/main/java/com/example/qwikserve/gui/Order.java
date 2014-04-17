package com.example.qwikserve.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Order implements Serializable {


	private static final long serialVersionUID = 1L;
    private int id;
	private String name;
	private int numDrinks;
    private double cost;
	private ArrayList<String> sides;
	private ArrayList<String> burgers;
	private ArrayList<String> toppings;
	private boolean isCombo;
    private Random randomGenerator = new Random();
	
	public Order() {		
		this.id = randomGenerator.nextInt(999999);
		this.numDrinks =0;
        this.cost =0;
		this.isCombo = false;
		this.sides = new ArrayList<String>();
		this.burgers = new ArrayList<String>();
		this.toppings = new ArrayList<String>();
	}

    public void addCost(double add)
    {
        this.cost+=add;
    }

    public double getCost()
    {
        return this.cost;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumDrinks() {
		return numDrinks;
	}

    public String getID(){
        return Integer.toString(id);
    }

	public void addDrink() {
		this.numDrinks++;
	}

	public ArrayList<String> getSides() {
		return this.sides;
	}

	public void addSide(String side) {
		this.sides.add(side);
	}

	public ArrayList<String> getBurgers() {
		return burgers;
	}

	public void addBurger(String type) {
		burgers.add(type);		
	}
	
	public void addTopping(String topping){
		toppings.add(topping);
		
	}
	
	public ArrayList<String> getToppings()
	{
		return this.toppings;
	}

	public boolean isCombo() {
		return isCombo;
	}

	public void setCombo(boolean isCombo) {
		this.isCombo = isCombo;
	}

    protected String getBurgersText() {
        String text ="";
        int j = 0;
        for(int i=0; i<burgers.size()-1;i+=3)
        {

            text=text.concat(("Burger "+((i/3)+1)+":\n"));

            text=text.concat("Meat: ");
            text=text.concat(burgers.get(i+2));
            text=text.concat(" - "); // space
            text=text.concat(burgers.get(i));

            text=text.concat("\nBun: "); // space
            text=text.concat(burgers.get(i+1));

            text=text.concat("\nToppings:\n");

            for(j=j;j<100000;j++)// go on till break
            {
                if(toppings.get(j).compareTo("enditem")==0)
                {//if it is the end of the toppings for this item
                    j++;
                    break;
                }

                text = text.concat(toppings.get(j));
                text = text.concat(" ");

            }//end inner for

            text = text.concat("\n");

        }// end outter for burger


        return text;

    }

    protected String getSidesText(){
        String text ="";

        for(String s: sides)
        {
            text=text.concat(s);
            text=text.concat(" ");
        }
        return text;

    }
    public String toString()
    {
        String text = "Order ID: ";
        text =text.concat(""+this.getID()+"\n");

        text =text.concat(""+this.getBurgersText());

        text = text.concat("\nSides: "+this.getSidesText());

        text = text.concat(("\nNumber of fountain drinks: "+this.getNumDrinks()+"\n"));
        return text;

    }
}// end Order Class
