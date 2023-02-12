/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class represents a Pitta type object.It is defined by 2 smila objects ,width and the time it needs to 
 * be prepared
 *
 */
public class Pitta {

	private Smila smilaA;
	private Smila smilaB;
	private static int pittaWidth = 0;
	public static final int PITTATIME = 5;
	
	/**
	 * 
	 * @param smilaA
	 * @param smilaB
	 */
	public Pitta(Smila smilaA, Smila smilaB) {
		this.smilaA = smilaA;
		this.smilaB = smilaB;
	}

	/**
	 * 
	 * @param a
	 */
	public static void  setPittaWidth(int a) {
		pittaWidth = a;
	}
	
	/**
	 * 
	 * @return smilaA
	 */
	public Smila getSmilaA() {
		return smilaA;
	}
	
    /**
     * 
     * @param smilaA
     */
	public void setSmilaA(Smila smilaA) {
		this.smilaA = smilaA;
	}

	/**
	 * 
	 * @return smilaB
	 */
	public Smila getSmilaB() {
		return smilaB;
	}

	/**
	 * 
	 * @param smilaB
	 */
	public void setSmilaB(Smila smilaB) {
		this.smilaB = smilaB;
	}
	
	/**
	 * 
	 * @return result--->The whole width a Pitta takes on the foukou
	 */
	public int calcPittaWidth() {
		int result = smilaA.getWidth() + smilaB.getWidth() + pittaWidth;
		return result;
	}
	/**
	 * 
	 * @return result--->The whole time a pitta takes to be prepared
	 */
	
	public int calcPittaTime() {
		int firstMax = Math.max(smilaA.getPrepTime(), smilaB.getPrepTime());
		int result = Math.max(firstMax, Pitta.PITTATIME);
		return result;
	}

	/**
	 * Returns a string representation of a pitta object
	 */
	@Override
	public String toString() {
		return "Pitta [smilaA=" + smilaA + ", smilaB=" + smilaB + "]";
	}
	
	
	
	
}
