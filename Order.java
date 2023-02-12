/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class represents an Order type object.It is defined by the number of the order,
 * the time that the customer calls and orders, the time the customer requests his order, the number of pork
 * the number of chicken, the number of seftalia, the number of mix and the number of potato servings
 * 
 *
 */
public class Order {

	private static int OrderCount = 1;
	private int Num;
	private int Torder;
	private int Treq;
	private int Npp;
	private int Npc;
	private int Nps;
	private int Npm;
	private int Npf;
	
	/**
	 * 
	 * @param tOrder
	 * @param tReq
	 * @param npp
	 * @param npc
	 * @param nps
	 * @param npm
	 * @param npf
	 */
	public Order(int tOrder, int tReq, int npp, int npc, int nps, int npm, int npf) {
		Num = OrderCount++;
		Torder = tOrder;
	    Treq = tReq;
		Npp = npp;
		Npc = npc;
		Nps = nps;
		Npm = npm;
		Npf = npf;
	}
    
	/**
	 * 
	 * @return Num--->The number of each order
	 */
    public int getNum() {
    	return Num;
    }
	
    /**
     * 
     * @return Torder---> The time the customer calls and orders
     */
	public int getTorder() {
		return Torder;
	}

	/**
	 * 
	 * @param tOrder
	 */
	public void setTorder(int tOrder) {
		Torder = tOrder;
	}

	/**
	 * 
	 * @return Treq---> The time the customer requests to pick up his order
	 */
	public int getTreq() {
		return Treq;
	}

	/**
	 * 
	 * @param tReq
	 */
	public void setTreq(int tReq) {
		Treq = tReq;
	}

	/**
	 * 
	 * @return Npp--->The number of pork
	 */
	public int getNpp() {
		return Npp;
	}

	/**
	 * 
	 * @param npp
	 */
	public void setNpp(int npp) {
		Npp = npp;
	}

	/**
	 * 
	 * @return Npc---> The	number of chicken
	 */
	public int getNpc() {
		return Npc;
	}

	/**
	 * 
	 * @param npc
	 */
	public void setNpc(int npc) {
		Npc = npc;
	}

	/**
	 * 
	 * @return Nps---->	The number of seftalies
	 */
	public int getNps() {
		return Nps;
	}

	/**
	 * 
	 * @param nps
	 */
	public void setNps(int nps) {
		Nps = nps;
	}

	/**
	 * 
	 * @return Npm---->The number of mix
	 */
	public int getNpm() {
		return Npm;
	}

	/**
	 * 
	 * @param npm
	 */
	public void setNpm(int npm) {
		Npm = npm;
	}

	/**
	 * 
	 * @return Npf--->The number of potato servings
	 */
	public int getNpf() {
		return Npf;
	}

	/**
	 * 
	 * @param npf
	 */
	public void setNpf(int npf) {
		Npf = npf;
	}

	/**
	 * This methods returns a string representation of an order object
	 */
	@Override
	public String toString() {
		return "Order [Num=" + Num + "\ntOrder=" + Torder + "\ntReq=" + Treq + "\nNpp=" + Npp + "\nNpc=" + Npc
				+ "\nNps=" + Nps + "\nNpm=" + Npm + "\nNpf=" + Npf + "]";
	}
	
	
	
}
