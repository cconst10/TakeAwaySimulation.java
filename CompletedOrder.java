/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This method represents the completed orders.It is defined by the number of completed orders,the time the orders
 * go on the foukou, the time the prder is ready, the time difference between the requested time and the time delivered
 * and if the customer is satisfied or not
 *
 */
public class CompletedOrder {

	private int num;
	private int onFoukouTime;
	private int readyTime;
	private int timeDiff;
	private boolean satisfied;
	
	/**
	 * 
	 * @param num
	 * @param onFoukouTime
	 * @param readyTime
	 * @param timeDiff
	 * @param satisfied
	 */
	public CompletedOrder(int num,int onFoukouTime, int readyTime, int timeDiff, boolean satisfied) {
		this.num = num;
		this.onFoukouTime = onFoukouTime;
		this.readyTime = readyTime;
		this.timeDiff = timeDiff;
		this.satisfied = satisfied;
	
	}
	/**
	 * 
	 * @return onFoukouTime
	 */
	public int getOnFoukouTime() {
		return onFoukouTime;
	}
	
	/**
	 * 
	 * @param onFoukouTime
	 */
	public void setOnFoukouTime(int onFoukouTime) {
		this.onFoukouTime = onFoukouTime;
	}
	/**
	 * 
	 * @return num--->The number of completed orders
	 */
	public int getNum() {
		return num;
	}
	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 
	 * @return readyTime-->The time the order is completed
	 */
	public int getReadyTime() {
		return readyTime;
	}
	/**
	 * 
	 * @param readyTime
	 */
	public void setReadyTime(int readyTime) {
		this.readyTime = readyTime;
	}
	/**
	 * 
	 * @return timeDiff
	 */
	public int getTimeDiff() {
		return timeDiff;
	}
	/**
	 * 
	 * @param timeDiff
	 */
	public void setTimeDiff(int timeDiff) {
		this.timeDiff = timeDiff;
	}
	/**
	 * 
	 * @return satisfied
	 */
	public boolean isSatisfied() {
		return satisfied;
	}
	/**
	 * 
	 * @param satisfied
	 */
	public void setSatisfied(boolean satisfied) {
		this.satisfied = satisfied;
	}
	
	
}
