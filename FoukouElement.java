
/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class represents a FoukouElement type object. It is defined by the number of the order,the time the order was given
 * the time that the customer requests to pick up his order,the time the order goes on foukou, The time the pitta
 * is of the foukou,the time the meat is removed from the foukou,the width that is taken,the width that is 
 * available after, the width that is available after the removal of the pitta, the width available after the 
 * removal of the meat, if the customer is satisfied or not, the difference between the delivery time and the order time
 * 
 *
 */
public class FoukouElement {

	private int orderID;
	private int timeOfOrder;
	private int timeReq;
	private int onTime;
	private int pittaOffTime;
	private int meatOffTime;
	private int widthTaken;
	private int widthAvailableAfter;
	private int widthAvailableAfterPitta;
	private int widthAvailableAfterMeat;
	private boolean satisfied;
	private int timeDiff;// If positive--->satisfied = true(required - meatOffTime)
	
	/**
	 * Constructor
	 * @param orderID
	 * @param timeOfOrder
	 * @param timeReq
	 * @param onTime
	 * @param pittaOffTime
	 * @param meatOffTime
	 * @param widthTaken
	 * @param widthAvailableAfter
	 * @param widthAvailableAfterPitta
	 * @param widthAvailableAfterMeat
	 * @param satisfied
	 * @param timeDiff
	 */
	public FoukouElement(int orderID, int timeOfOrder, int timeReq, int onTime, int pittaOffTime, int meatOffTime,
			int widthTaken, int widthAvailableAfter, int widthAvailableAfterPitta, int widthAvailableAfterMeat,
			boolean satisfied, int timeDiff) {
		
		this.orderID = orderID;
		this.timeOfOrder = timeOfOrder;
		this.timeReq = timeReq;
		this.onTime = onTime;
		this.pittaOffTime = pittaOffTime;
		this.meatOffTime = meatOffTime;
		this.widthTaken = widthTaken;
		this.widthAvailableAfter = widthAvailableAfter;
		this.widthAvailableAfterPitta = widthAvailableAfterPitta;
		this.widthAvailableAfterMeat = widthAvailableAfterMeat;
		this.satisfied = satisfied;
		this.timeDiff = timeDiff;
	}
    /**
     * 
     * @return orderID
     */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * 
	 * @return timeOfOrder
	 */
	public int getTimeOfOrder() {
		return timeOfOrder;
	}

	/**
	 * 
	 * @param timeOfOrder
	 */
	public void setTimeOfOrder(int timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	/**
	 * 
	 * @return timeReq
	 */
	public int getTimeReq() {
		return timeReq;
	}

	/**
	 * 
	 * @param timeReq
	 */
	public void setTimeReq(int timeReq) {
		this.timeReq = timeReq;
	}

	/**
	 * 
	 * @return onTime
	 */
	public int getOnTime() {
		return onTime;
	}

	/**
	 * 
	 * @param onTime
	 */
	public void setOnTime(int onTime) {
		this.onTime = onTime;
	}

	/**
	 * 
	 * @return pittaOffTime
	 */
	public int getPittaOffTime() {
		return pittaOffTime;
	}

	/**
	 * 
	 * @param pittaOffTime
	 */
	public void setPittaOffTime(int pittaOffTime) {
		this.pittaOffTime = pittaOffTime;
	}

	/**
	 * 
	 * @return meatOffTime
	 */
	public int getMeatOffTime() {
		return meatOffTime;
	}

	/**
	 * 
	 * @param meatOffTime
	 */
	public void setMeatOffTime(int meatOffTime) {
		this.meatOffTime = meatOffTime;
	}

	/**
	 * 
	 * @return widthTaken
	 */
	public int getWidthTaken() {
		return widthTaken;
	}

	/**
	 * 
	 * @param widthTaken
	 */
	public void setWidthTaken(int widthTaken) {
		this.widthTaken = widthTaken;
	}

	/**
	 * 
	 * @return widthAvailableAfter
	 */
	public int getWidthAvailableAfter() {
		return widthAvailableAfter;
	}

	/**
	 * 
	 * @param widthAvailableAfter
	 */
	public void setWidthAvailableAfter(int widthAvailableAfter) {
		this.widthAvailableAfter = widthAvailableAfter;
	}

	/**
	 * 
	 * @return widthAvailableAfterPitta
	 */
	public int getWidthAvailableAfterPitta() {
		return widthAvailableAfterPitta;
	}

	/**
	 * 
	 * @param widthAvailableAfterPitta
	 */
	public void setWidthAvailableAfterPitta(int widthAvailableAfterPitta) {
		this.widthAvailableAfterPitta = widthAvailableAfterPitta;
	}

	/**
	 * 
	 * @return widthAvailableAfterMeat
	 */
	public int getWidthAvailableAfterMeat() {
		return widthAvailableAfterMeat;
	}

	/**
	 * 
	 * @param widthAvailableAfterMeat
	 */
	public void setWidthAvailableAfterMeat(int widthAvailableAfterMeat) {
		this.widthAvailableAfterMeat = widthAvailableAfterMeat;
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
	 * This method returns a string representation of a FoukouElemnt object
	 */
	@Override
	public String toString() {
		return "FoukouElement [orderID=" + orderID + ", timeOfOrder=" + timeOfOrder + ", timeReq=" + timeReq
				+ ", onTime=" + onTime + ", pittaOffTime=" + pittaOffTime + ", meatOffTime=" + meatOffTime
				+ ", widthTaken=" + widthTaken + ", widthAvailableAfter=" + widthAvailableAfter
				+ ", widthAvailableAfterPitta=" + widthAvailableAfterPitta + ", widthAvailableAfterMeat="
				+ widthAvailableAfterMeat + ", satisfied=" + satisfied + ", timeDiff=" + timeDiff + "]";
	}
	
	
	
	
}
