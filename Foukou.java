/**
 * 
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class represents a foukou object.It is defined by the time the karvouna need to be ready 
 * and the size of the foukou
 * 
 *
 */
public class Foukou {

	private int T;
	private int M;
	
	/**
	 * 
	 * @param t
	 * @param m
	 */
	public Foukou(int t, int m) {
		T = t;
		M = m;
	}

	/**
	 * 
	 * @return T--->The time the karvouna need to be ready
	 */
	public int getT() {
		return T;
	}

	/**
	 * 
	 * @param t
	 */
	public void setT(int t) {
		T = t;
	}

	/**
	 * 
	 * @return M--->The size of the foukou
	 */
	public int getM() {
		return M;
	}

	/**
	 * 
	 * @param m
	 */
	public void setM(int m) {
		M = m;
	}

	/**
	 * This method returns a string representation of a foukou object
	 */
	@Override
	public String toString() {
		return "Foukou [T=" + T + ", M=" + M + "]";
	}
	
	
	
}
