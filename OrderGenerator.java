/**
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class generates random Orders with parameters that are based on the statistics given
 * It is defined by a Random type object,the count of an order and an ArrayList of orders
 */
import java.util.*;


public class OrderGenerator {

	private static Random rand = new Random();
    private int orderCount;
    private ArrayList <Order> ordersList;
    
    /**
     * 
     * @param x
     */
    public void setOrderCount(int x) {
        orderCount = 0;
    }
    /**
     * 
     * @return The number of an order
     */
    public int getOrderCount() {
        return orderCount;
    }
    /**
     * 
     * @return the ArrayList of orders
     */
    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }
    /**
     * 
     * @param ordersList
     */
    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }
    /**
     * 
     * @param pittesCount
     * @return How many potatoes an order contains
     */
    private static int getPotatoCount(int pittesCount){
               
        int patates[] = new int[100];
        for (int i=0; i<100 ;i++ ) {
            if (i<60)
                patates[i] = pittesCount;
            else if (i<95)
                patates[i] = 0;
            else  
                patates[i] = 2;
        } 
        
        int index = rand.nextInt(100);
        return patates[index];
        }
    
    /**
     * Constructor
     * @param ordersToGenerate
     * Creates random orders and places them in arrays based on the statistics given
     */
    public OrderGenerator(int ordersToGenerate){
        
        final int SIZE = ordersToGenerate;
        final int ORDER = 0;
        final int PITTES = 1;
        final int CHIPS = 2;
        final int ORDERTIME = 3;
        final int REQUIRED = 4;
        ordersList = new ArrayList<Order>();
        
       
        int orders[][] = new int [5][SIZE];
        
        int pittes[] = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i<20)
               pittes[i] = 1;
            else if (i<55)
                pittes[i] = 2;
            else if (i<65) 
                pittes[i] = 3;
            else if (i<85)
                pittes[i] = 4;
            else {
                pittes[i] = rand.nextInt(25);
            } 
                
        } 
       
        for (int i = 0;i < SIZE; i++) {
             orders[ORDERTIME][i] = (int) ((Math.sqrt(60) * rand.nextGaussian()) + 180);
        } 
       
        for (int i = 0; i <SIZE ;i++ ) {
             int value = 30 + rand.nextInt(151);
            orders[REQUIRED][i] = orders[ORDERTIME][i] + value;
        
       }
        //For testing purposes only!!
       // System.out.println("Order Pittes Chips Minutes Required");
        
        for (int i = 0; i < SIZE; i++) {
            int index = rand.nextInt(SIZE);
            orders[ORDER][i] = i+1;
            orders[PITTES][i] = pittes[index];
            orders[CHIPS][i] = getPotatoCount(pittes[index]);
            
            //For testing purposes only!!
          
            /*
                  System.out.println(orders[ORDER][i] + "      " + orders[PITTES][i] 
 
                                                      + "      " + orders[CHIPS][i]
                                                      + "      " + orders[ORDERTIME][i]
                                                      + "      " + orders[REQUIRED][i]);           
           */    
        }  
        //going through the array and creating the ArrayList of Orders
        
        //equally distributing the meat orders
        int meats[] = new int[100];
        
        for (int i=0; i<100; i++) {
            if (i<25) meats[i] = Smila.PORK;
            else if(i<50) meats[i] = Smila.CHICKEN;
            else if(i<75) meats[i] = Smila.SEFTALIA;
            else {
                meats[i] = Smila.MIX;
            } 
        } 
        
        
        for (int i=0;i<SIZE ;i++ ) {
            int porks = 0;
            int chicks = 0;
            int sefts = 0;
            int mixed = 0;
            for (int k=0; k<orders[PITTES][i]; k++ ) {
                //taking the pittes count and for each pitta getting a random number from the meats
                int index = rand.nextInt(100);
                int type = meats[index];
                switch (type) {
                    case  Smila.PORK: 
                        porks++;
                        break;
                    case  Smila.CHICKEN: 
                        chicks++;
                        break;
                    case  Smila.SEFTALIA: 
                        sefts++;
                        break;
                    case  Smila.MIX: 
                        mixed++;
                        break;
                } 
            } 
            
            Order toAdd = new Order(orders[ORDERTIME][i], orders[REQUIRED][i],porks, chicks, sefts, mixed, orders[CHIPS][i]);
            ordersList.add(toAdd);
        }
    }

}
