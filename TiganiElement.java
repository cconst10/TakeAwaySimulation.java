/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class represents a TiganiElement type object. It is defined by the number of the order,the time the order was given
 * the time that the customer requests to pick up his order,the time the order goes on Tigani, the width that is taken,the width that is 
 * available after, the width that is available after the removal of the potatoes, 
 *  if the customer is satisfied or not, the difference between the delivery time and the order time
 *
 */
public class TiganiElement {

	
	private int orderId;
	private int timeOfOrder;
	private int timeReq;
	private int onTimePot;
	private int potatoesOffTime;
	private int spaceTaken;
	private int spaceAvailableAfter;
	private int spaceAfterOff;
	private boolean satisfied;
	private int timeDiff;
	
	/**
	 * Constructor
	 * @param orderId
	 * @param timeOfOrder
	 * @param timeReq
	 * @param onTimePot
	 * @param potatoesOffTime
	 * @param spaceTaken
	 * @param spaceAvailableAfter
	 * @param spaceAfterOff
	 * @param satisfied
	 * @param timeDiff
	 */
	public TiganiElement(int orderId, int timeOfOrder, int timeReq, int onTimePot,
			int potatoesOffTime, int spaceTaken, int spaceAvailableAfter, int spaceAfterOff , boolean satisfied,
			int timeDiff) {
		
		this.orderId = orderId;
		this.timeOfOrder = timeOfOrder;
		this.timeReq = timeReq;
		this.onTimePot = onTimePot;
		this.potatoesOffTime = potatoesOffTime;
		this.spaceTaken = spaceTaken;
		this.spaceAvailableAfter = spaceAvailableAfter;
		this.spaceAfterOff = spaceAfterOff;
		this.satisfied = satisfied;
		this.timeDiff = timeDiff;
	}
	
	/**
	 * 
	 * @return orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * 
	 * @param orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return onTimePot
	 */
	public int getOnTimePot() {
		return onTimePot;
	}
	/**
	 * 
	 * @param onTimePot
	 */
	public void setOnTimePot(int onTimePot) {
		this.onTimePot = onTimePot;
	}
	/**
	 * 
	 * @return potatoesOffTime
	 */
	public int getPotatoesOffTime() {
		return potatoesOffTime;
	}
	/**
	 * 
	 * @param potatoesOffTime
	 */
	public void setPotatoesOffTime(int potatoesOffTime) {
		this.potatoesOffTime = potatoesOffTime;
	}
	/**
	 * 
	 * @return spaceTaken
	 */
	public int getSpaceTaken() {
		return spaceTaken;
	}
	/**
	 * 
	 * @param spaceTaken
	 */
	public void setSpaceTaken(int spaceTaken) {
		this.spaceTaken = spaceTaken;
	}
	/**
	 * 
	 * @return spaceAvailableAfter
	 */
	public int getSpaceAvailableAfter() {
		return spaceAvailableAfter;
	}
	/**
	 * 
	 * @param spaceAvailableAfter
	 */
	public void setSpaceAvailableAfter(int spaceAvailableAfter) {
		this.spaceAvailableAfter = spaceAvailableAfter;
	}
	/**
	 * 
	 * @return spaceAfterOff
	 */
	public int getSpaceAfterOff() {
		return spaceAfterOff;
	}
	/**
	 * 
	 * @param spaceAfterOff
	 */
	public void setSpaceAfterOff(int spaceAfterOff) {
		this.spaceAfterOff = spaceAfterOff;
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
	 * This method returns a string representation of a TiganiElemnt object
	 */
	@Override
	public String toString() {
		return "TiganiElement [orderId=" + orderId + ", timeOfOrder=" + timeOfOrder + ", timeReq=" + timeReq
				+ ", onTimePot=" + onTimePot + ", potatoesOffTime=" + potatoesOffTime + ", spaceTaken=" + spaceTaken
				+ ", spaceAvailableAfter=" + spaceAvailableAfter + ", spaceAfterOff=" + spaceAfterOff + ", satisfied="
				+ satisfied + ", timeDiff=" + timeDiff + "]";
	}
	
	
	
	
	
}
