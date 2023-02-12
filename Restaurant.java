/**
 * @author Christodoulos Constantinou
 * @version 1.0
 *  This class represents a Restaurant type object. It is defined by a Fokou type object,the number of tigania it has
 *  and the capacity of each Tigani
 */
import java.util.*;

public class Restaurant {

	private Foukou FoukouA;
	private int TiganiCapacity;
	private int Tigania;
	private ArrayList <Order> Orders;
	private ArrayList <CompletedOrder> OrderComplete;
	
	/**
	 * 
	 * @param foukouA
	 * @param tigania
	 * @param capacity
	 */
	public Restaurant(Foukou foukouA, int tigania ,int capacity) {
		FoukouA = foukouA;
		Tigania = tigania;
		TiganiCapacity = capacity;
		Orders = new ArrayList<Order>();
		OrderComplete = new ArrayList <CompletedOrder>();
	}
	/**
	 * 
	 * @return Order---> An ArrayList of Order objects
	 */
	public ArrayList <Order> getOrders() {
		return Orders;
	}
	/**
	 * 
	 * @return CompletedOrder----> An ArrayList of the completed orders
	 */
	public ArrayList <CompletedOrder> getOrderComplete(){
		return OrderComplete;
	}

	/**
	 * 
	 * @return FoukouA---->The restaurants Foukou
	 */
	public Foukou getFoukouA() {
		return FoukouA;
	}

	/**
	 * 
	 * @param foukouA
	 */
	public void setFoukouA(Foukou foukouA) {
		FoukouA = foukouA;
	}

	/**
	 * 
	 * @return Tigania----> The number of tigania the restaurant has
	 */
	public int getTigania() {
		return Tigania;
	}

	/**
	 * 
	 * @param tigania
	 */
	public void setTigania(int tigania) {
		Tigania = tigania;
	}
	
	/**
	 * 
	 * @param toAdd
	 */
	public void addOrder(Order toAdd) {
		Orders.add(toAdd);
		
	}
	
	/**
	 * 
	 * @return The capacity of all the tigania combined
	 */
	public int potatoesCapacity() {
		return Tigania * TiganiCapacity;
	}
	
	/**
	 * This method sorts orders and doesn't return anything
	 */
	public void sortOrders() {
		for(int i = 0; i < Orders.size() - 1; i++) {
			int min = ((Order) Orders.get(i + 1)).getTorder();
			int minIndex = (i + 1);
			for(int j = i + 1; j < Orders.size(); j++) {
				int current = ((Order) Orders.get(j)).getTorder();
				if(current < min) {
					min = current;
					minIndex = j;
				}
			}
			int first = ((Order) Orders.get(i)).getTorder();
			if(first < min) {
				//minimum already in first place, do nothing
			}else {
				Order temp = ((Order) Orders.get(i));
				Orders.set(i, ((Order) Orders.get(minIndex)));
				Orders.set(minIndex, temp);
			}
		}
	}

	/**
	 * This method returns a string representation of a Restaurant type object
	 */
	@Override
	public String toString() {
		return "Restaurant [FoukouA=" + FoukouA + ", Tigania=" + Tigania + "]";
	}
	
	/**
	 * This method creates a list with orders
	 */
	public void listOrders() {
		for(int i = 0; i < Orders.size(); i++) {
			System.out.println((Order) Orders.get(i));
		}
	}
	
}
