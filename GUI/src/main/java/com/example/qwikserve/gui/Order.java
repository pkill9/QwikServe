package com.example.qwikserve.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class Order implements Serializable {

	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int numDrinks;
    private double cost;
	private ArrayList<String> sides;
	private ArrayList<String> burgers;
	private ArrayList<String> toppings;
	private boolean isCombo;

	
	public Order() {		
		
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

    public String toString()
    {
       int j=0;//test
       String text =" ";
       for(int i=0; i<burgers.size()-1;i+=3)
       {

            text=text.concat(("Burger "+((i/3)+1)+": "));
            text=text.concat(burgers.get(i));
            text=text.concat(" "); // space

            text=text.concat(burgers.get(i+1));
            text=text.concat(" "); // space

           text=text.concat(burgers.get(i+2));
           text=text.concat(" "); // space

           text=text.concat("with: ");

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

       }// end outter for

        text = text.concat(("\n"+"Sides: "));
        for(String s: sides)
        {
            text=text.concat(s);
            text=text.concat(" ");
        }
        text = text.concat(("\nNumber of fountain drinks: "+this.getNumDrinks()+"\n"));
        return text;

    }
}// end Order Class
