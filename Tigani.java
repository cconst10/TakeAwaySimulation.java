/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class is a tigani type object.It is defined by the number of potato servings it can cook
 * and the time the potatoes need to be cooked
 * 
 *
 */
public class Tigani {

	public int C;
	private int prepTime;
	public static final int POTATOTIME = 20;
	
	/**
	 * Constructor
	 * @param C
	 * @param prepTime
	 */
	public Tigani(int C, int prepTime) {
		this.C = C;
		this.prepTime = prepTime;
	}
	/**
	 * 
	 * @return C
	 */

	public int getC() {
		return C;
	}
	/**
	 * 
	 * @param c
	 */

	public void setC(int c) {
		C = c;
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
	 * Returns a string representation of a Tigani object
	 */
	@Override
	public String toString() {
		return "Tigani [C=" + C + ", prepTime=" + prepTime + "]";
	}
	
	
	
	
}
