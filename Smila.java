/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class is a smila type object. It is defined the meat type the time it need to be prepared and the width 
 * it takes on the foukou. 
 * 
 *
 */


public class Smila {

	private int meatType;
	private int prepTime;
	private int width;
	public static final int PORK = 0;
	public static final int CHICKEN = 1;
	public static final int SEFTALIA = 2;
	public static final int MIX = 3;
	public static final int PORKTIME = 25;
	public static final int CHICKENTIME = 20;
	public static final int SEFTALIATIME = 25;
	
	/**
	 * 
	 * @param meatType
	 * @param prepTime
	 * @param width
	 */
	public Smila(int meatType, int prepTime, int width) {
		this.meatType = meatType;
		this.prepTime = prepTime;
		this.width = width;
	}
	/**
	 * 
	 * @return meatType
	 */
	
	public int getMeatType() {
		return meatType;
	}
	/**
	 * 
	 * @param meatType
	 */
	public void setMeatType(int meatType) {
		this.meatType = meatType;
	}
	/**
	 * 
	 * @return prepTime
	 */
	public int getPrepTime() {
		return prepTime;
	}
	/**
	 * 
	 * @param prepTime
	 */
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	/**
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	/**
	 * @returns a Smila object in String form
	 */
	public String toString() {
		return "Smila [meatType=" + meatType + ", prepTime=" + prepTime + ", width=" + width + "]";
	}
	
	
	
}
