
/**
 * @author Christodoulos Constantinou
 * @version 1.0
 * This class is the driver class.It controls the creation of orders manually or randomly.It is defined by
 * the size of the foukou, the preparation time for the karvouna, the number of tigania, the capacity of the tigania
 * and the size that each smila and pitta hold on the foukou
 */
import java.util.*;

public class OrderDelivery {

	private int M;
	private int T;
	private int N;
	private int C;
	private static int X;
	private static int Y;
	private static int Z;

	/**
	 * 
	 * @param m
	 * @param t
	 * @param n
	 * @param c
	 * @param x
	 * @param y
	 * @param z
	 */
	public OrderDelivery(int m, int t, int n, int c, int x, int y, int z) {
		M = m;
		T = t;
		N = n;
		C = c;
		X = x;
		Y = y;
		Z = z;
	}

	/**
	 * 
	 * @return M
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
	 * 
	 * @return T
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
	 * @return N
	 */
	public int getN() {
		return N;
	}

	/**
	 * 
	 * @param n
	 */
	public void setN(int n) {
		N = n;
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
	 * @return X
	 */
	public int getX() {
		return X;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		X = x;
	}

	/**
	 * 
	 * @return Y
	 */
	public int getY() {
		return Y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		Y = y;
	}

	/**
	 * 
	 * @return Z
	 */
	public int getZ() {
		return Z;
	}

	/**
	 * 
	 * @param z
	 */
	public void setZ(int z) {
		Z = z;
	}

	/**
	 * This method returns a string representation of an OrderDelivery object
	 */
	@Override
	public String toString() {
		return "OrderDelivery [M=" + M + ", T=" + T + ", N=" + N + ", C=" + C + ", X=" + X + ", Y=" + Y + ", Z=" + Z
				+ "]";
	}

	/**
	 * 
	 * @param x
	 * @param porkChickWidth
	 * @param sefWidth       This method controls what goes on the foukou and the
	 *                       tigania and changes the parameters of the Order objects
	 *                       accordingly
	 */
	public static void process(Restaurant x, int porkChickWidth, int sefWidth) {
		ArrayList<FoukouElement> elements = new ArrayList<FoukouElement>();
		ArrayList<TiganiElement> potElements = new ArrayList<TiganiElement>();
		int available = x.getFoukouA().getM();

		for (int i = 0; i < x.getOrders().size(); i++) {
			Order next = (Order) x.getOrders().get(i);
			if (next.getNpp() > 0) {
				// Process xoirino
				for (int j = 0; j < next.getNpp(); j++) {
					int orderID = next.getNum();
					int orderTime = next.getTorder();
					int reqTime = next.getTreq();
					int width = (2 * X) + Z;
					int availableAfter = 0;
					int availableAfterPitta = 0;
					int availableAfterMeat = 0;
					int timeOn = 0;
					int pittaOffTime = 0;
					int meatOffTime = 0;
					int timeDiff = 0;
					boolean custSat = false;

					if (elements.size() == 0) {
						// First pitta on foukou
						availableAfter = available - width;
						if (orderTime > 15) {
							timeOn = orderTime;
						} else {
							timeOn = 15;
						}
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter - Z;
						meatOffTime = timeOn + Smila.PORKTIME;
						availableAfterMeat = availableAfterPitta + (2 * X);
						timeDiff = reqTime - meatOffTime;

					} else {
						//Not the first smila
                        FoukouElement previous = (FoukouElement) elements.get(elements.size() - 1);
                        int orderTimeDiff = orderTime - previous.getOnTime();
                        if (orderTimeDiff < Smila.PORKTIME) {
                            if(previous.getWidthAvailableAfter() > width) {
                                //Pitta can be inserted on foukou
                                timeOn= orderTime;
                                availableAfter = previous.getWidthAvailableAfter() - width;
                            }
                            else if(previous.getWidthAvailableAfterPitta() > width) {
                                //Pitta can be inserted on foukou
                                timeOn = previous.getPittaOffTime();
                                availableAfter = previous.getWidthAvailableAfterPitta() - width;
                            }else if(previous.getWidthAvailableAfterMeat() > width) {
                                //Meat can go on foukou
                                timeOn = previous.getMeatOffTime();
                                availableAfter = previous.getWidthAvailableAfterMeat() - width;
                            }
                            pittaOffTime = timeOn + Pitta.PITTATIME;
                            availableAfterPitta = availableAfter + Z;
                            meatOffTime = timeOn + Smila.PORKTIME;
                            availableAfterMeat = availableAfterPitta + (2 * X);
                            timeDiff = reqTime - meatOffTime;
                        } else {
							timeOn = orderTime;
							availableAfter = previous.getWidthAvailableAfterMeat() - width;
							pittaOffTime = timeOn + Pitta.PITTATIME;
							availableAfterPitta = availableAfter + Z;
							meatOffTime = timeOn + Smila.PORKTIME;
							availableAfterMeat = availableAfterPitta + (2 * X);
							timeDiff = reqTime - meatOffTime;
						}

					}
					FoukouElement toAdd = new FoukouElement(orderID, orderTime, reqTime, timeOn, pittaOffTime,
							meatOffTime, width, availableAfter, availableAfterPitta, availableAfterMeat, custSat,
							timeDiff);

					elements.add(toAdd);

				}
			}
			if (next.getNpc() > 0) {
				// Process KOTOPOULO
				int orderID = next.getNum();
				int orderTime = next.getTorder();
				int reqTime = next.getTreq();
				int width = (2 * X) + Z;
				int availableAfter = 0;
				int availableAfterPitta = 0;
				int availableAfterMeat = 0;
				int timeOn = 0;
				int pittaOffTime = 0;
				int meatOffTime = 0;
				int timeDiff = 0;
				boolean custSat = false;

				if (elements.size() == 0) {
					// First pitta on foukou
					availableAfter = available - width;
					if (orderTime > 15) {
						timeOn = orderTime;
					} else {
						timeOn = 15;
					}
					pittaOffTime = timeOn + Pitta.PITTATIME;
					availableAfterPitta = availableAfter + Z;
					meatOffTime = timeOn + Smila.CHICKENTIME;
					availableAfterMeat = availableAfterPitta + (2 * X);
					timeDiff = reqTime - meatOffTime;

				} else {
					//Not the first smila
                    FoukouElement previous = (FoukouElement) elements.get(elements.size() - 1);
                    int orderTimeDiff = orderTime - previous.getOnTime();
                    if (orderTimeDiff < Smila.PORKTIME) {
                        /*if (previous.getWidthAvailableAfter()<=0)
                        {
                            //no space on foukou, time on will be the after meat of previous
                            timeon = previous.getMeatOffTime();
                            //availableAfter = previous.getWidthAvailableAfterMeat() - width;
                            availableAfter = 0;    
                        } else*/ 
                        if(previous.getWidthAvailableAfter() > width) {
                            //Pitta can be inserted on foukou
                            timeOn= orderTime;
                            availableAfter = previous.getWidthAvailableAfter() - width;
                        }
                        else if(previous.getWidthAvailableAfterPitta() > width) {
                            //Pitta can be inserted on foukou
                            timeOn = previous.getPittaOffTime();
                            availableAfter = previous.getWidthAvailableAfterPitta() - width;
                        }else if(previous.getWidthAvailableAfterMeat() > width) {
                            //Meat can go on foukou
                            timeOn = previous.getMeatOffTime();
                            availableAfter = previous.getWidthAvailableAfterMeat() - width;
                        }
                        pittaOffTime = timeOn + Pitta.PITTATIME;
                        availableAfterPitta = availableAfter + Z;
                        meatOffTime = timeOn + Smila.PORKTIME;
                        availableAfterMeat = availableAfterPitta + (2 * X);
                        timeDiff = reqTime - meatOffTime;
                    } else {
						timeOn = orderTime;
						availableAfter = previous.getWidthAvailableAfterMeat() - width;
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter + Z;
						meatOffTime = timeOn + Smila.CHICKENTIME;
						availableAfterMeat = availableAfterPitta + (2 * X);
						timeDiff = reqTime - meatOffTime;
					}

				}
				FoukouElement toAdd = new FoukouElement(orderID, orderTime, reqTime, timeOn, pittaOffTime, meatOffTime,
						width, availableAfter, availableAfterPitta, availableAfterMeat, custSat, timeDiff);

				elements.add(toAdd);

			}
			if (next.getNps() > 0) {
				// Process SEFTALIA
				int orderID = next.getNum();
				int orderTime = next.getTorder();
				int reqTime = next.getTreq();
				int width = (2 * Y) + Z;
				int availableAfter = 0;
				int availableAfterPitta = 0;
				int availableAfterMeat = 0;
				int timeOn = 0;
				int pittaOffTime = 0;
				int meatOffTime = 0;
				int timeDiff = 0;
				boolean custSat = false;

				if (elements.size() == 0) {
					// First pitta on foukou
					availableAfter = available - width;
					if (orderTime > 15) {
						timeOn = orderTime;
					} else {
						timeOn = 15;
					}
					pittaOffTime = timeOn + Pitta.PITTATIME;
					availableAfterPitta = availableAfter + Z;
					meatOffTime = timeOn + Smila.SEFTALIATIME;
					availableAfterMeat = availableAfterPitta + (2 * Y);
					timeDiff = reqTime - meatOffTime;

				} else {
					// Not the first smila
					FoukouElement previous = (FoukouElement) elements.get(elements.size() - 1);
					int orderTimeDiff = orderTime - previous.getOnTime();
					if (orderTimeDiff < Smila.SEFTALIATIME) {
						if (previous.getWidthAvailableAfter() > width) {
							// Pitta can be inserted on foukou
							timeOn = orderTime;
							availableAfter = previous.getWidthAvailableAfter() - width;
						} else if (previous.getWidthAvailableAfterPitta() > width) {
							// Pitta can be inserted on foukou
							timeOn = previous.getPittaOffTime();
							availableAfter = previous.getWidthAvailableAfterPitta() - width;
						} else if (previous.getWidthAvailableAfterMeat() > width) {
							// Meat can go on foukou
							timeOn = previous.getMeatOffTime();
							availableAfter = previous.getWidthAvailableAfterMeat() - width;
						}
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter + Z;
						meatOffTime = timeOn + Smila.SEFTALIATIME;
						availableAfterMeat = availableAfterPitta + (2 * Y);
						timeDiff = reqTime - meatOffTime;
					} else {
						timeOn = orderTime;
						availableAfter = previous.getWidthAvailableAfterMeat() - width;
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter + Z;
						meatOffTime = timeOn + Smila.SEFTALIATIME;
						availableAfterMeat = availableAfterPitta + (2 * Y);
						timeDiff = reqTime - meatOffTime;
					}

				}
				FoukouElement toAdd = new FoukouElement(orderID, orderTime, reqTime, timeOn, pittaOffTime, meatOffTime,
						width, availableAfter, availableAfterPitta, availableAfterMeat, custSat, timeDiff);

				elements.add(toAdd);

			}
			if (next.getNpm() > 0) {
				// Process MIX
				int orderID = next.getNum();
				int orderTime = next.getTorder();
				int reqTime = next.getTreq();
				int width = X + Y + Z;
				int availableAfter = 0;
				int availableAfterPitta = 0;
				int availableAfterMeat = 0;
				int timeOn = 0;
				int pittaOffTime = 0;
				int meatOffTime = 0;
				int timeDiff = 0;
				boolean custSat = false;

				if (elements.size() == 0) {
					// First pitta on foukou
					availableAfter = available - width;
					if (orderTime > 15) {
						timeOn = orderTime;
					} else {
						timeOn = 15;
					}
					pittaOffTime = timeOn + Pitta.PITTATIME;
					availableAfterPitta = availableAfter + Z;
					meatOffTime = timeOn + Math.max(Smila.SEFTALIATIME, Smila.PORKTIME);
					availableAfterMeat = availableAfterPitta + (X + Y);
					timeDiff = reqTime - meatOffTime;

				} else {
					// Not the first smila
					FoukouElement previous = (FoukouElement) elements.get(elements.size() - 1);
					int orderTimeDiff = orderTime - previous.getOnTime();
					if (orderTimeDiff < Math.max(Smila.SEFTALIATIME, Smila.PORKTIME)) {
						if (previous.getWidthAvailableAfter() > width) {
							// Pitta can be inserted on foukou
							timeOn = orderTime;
							availableAfter = previous.getWidthAvailableAfter() - width;
						} else if (previous.getWidthAvailableAfterPitta() > width) {
							// Pitta can be inserted on foukou
							timeOn = previous.getPittaOffTime();
							availableAfter = previous.getWidthAvailableAfterPitta() - width;
						} else if (previous.getWidthAvailableAfterMeat() > width) {
							// Meat can go on foukou
							timeOn = previous.getMeatOffTime();
							availableAfter = previous.getWidthAvailableAfterMeat() - width;
						}
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter + Z;
						meatOffTime = timeOn + Math.max(Smila.SEFTALIATIME, Smila.PORKTIME);
						availableAfterMeat = availableAfterPitta + (X + Y);
						timeDiff = reqTime - meatOffTime;
					} else {
						timeOn = orderTime;
						availableAfter = previous.getWidthAvailableAfterMeat() - width;
						pittaOffTime = timeOn + Pitta.PITTATIME;
						availableAfterPitta = availableAfter + Z;
						meatOffTime = timeOn + Math.max(Smila.SEFTALIATIME, Smila.PORKTIME);
						availableAfterMeat = availableAfterPitta + (X + Y);
						timeDiff = reqTime - meatOffTime;
					}

				}
				FoukouElement toAdd = new FoukouElement(orderID, orderTime, reqTime, timeOn, pittaOffTime, meatOffTime,
						width, availableAfter, availableAfterPitta, availableAfterMeat, custSat, timeDiff);

				elements.add(toAdd);
			}
			if (next.getNpf() > 0) {
				// Process POTATOES
				int orderID = next.getNum();
				int orderTime = next.getTorder();
				int numOfPortions = next.getNpf();
				int timeOn = 0;
				int potatoOffTime = 0;
				int reqTime = next.getTreq();
				int availableAfter = 0;
				int availableAfterOff = 0;
				int timeDiff = 0;
				int spaceTaken = 1;
				boolean custSat = false;

				for (int k = 0; k < next.getNpf(); k++) {
					if (potElements.size() == 0) {
						// First portion of potatoes on tigani
						// INSERT HERE
						availableAfter = x.potatoesCapacity() - spaceTaken;
						timeOn = orderTime;

						potatoOffTime = timeOn + Tigani.POTATOTIME;
						availableAfterOff = availableAfter + spaceTaken;
						timeDiff = reqTime - potatoOffTime;

					} else {
						// Not the first portions of potatoes
						TiganiElement previousPot = potElements.get(potElements.size() - 1);
						int orderTimeDiff = orderTime - previousPot.getOnTimePot();
						if (orderTimeDiff < Tigani.POTATOTIME) {
							if (previousPot.getSpaceAvailableAfter() > 0) {
								// Potatoes can go on tigani
								timeOn = orderTime;
							} else {
								// No space currently/Have to wait
								timeOn = previousPot.getPotatoesOffTime();
							}
							availableAfter = previousPot.getSpaceAvailableAfter() - 1;
							potatoOffTime = timeOn + Tigani.POTATOTIME;
							availableAfterOff = previousPot.getSpaceAvailableAfter() + 1;
							timeDiff = reqTime - potatoOffTime;
						} else {
							timeOn = orderTime;
							availableAfter = previousPot.getSpaceAvailableAfter() - 1;
							potatoOffTime = timeOn + Tigani.POTATOTIME;
							availableAfterOff = previousPot.getSpaceAvailableAfter() + 1;
							timeDiff = reqTime - potatoOffTime;
						}

					}
					TiganiElement toAddPotato = new TiganiElement(orderID, orderTime, reqTime, timeOn, potatoOffTime,
							spaceTaken, availableAfter, availableAfterOff, custSat, timeDiff);

					potElements.add(toAddPotato);

				}

			}
		}
		/* For testing purposes only!!!
		for (int j = 0; j < elements.size(); j++) {
			System.out.println((FoukouElement) elements.get(j));
		}
		for (int k = 0; k < potElements.size(); k++) {
			System.out.println((TiganiElement) potElements.get(k));
		}

*/
		showResults(elements, potElements, x.getOrders());

	}

	/**
	 * 
	 * @param pittes
	 * @param patates 
	 * This method handles the data that OrderGenerator class
	 *                produces randomly according to the statistics given and
	 *                displays them in the form requested
	 */
	public static void showResults(ArrayList<FoukouElement> pittes, ArrayList<TiganiElement> patates,
			ArrayList<Order> orders) {

		int numOfOrders = orders.size();

		int stats[][] = new int[numOfOrders][4];
		int pat_stats[][] = new int[numOfOrders][4];

		final int ORDER_ID = 0;
		final int SATISFIED = 1;
		final int DEVIATION = 2;
		final int DELIVERED = 3;
        //fill the order ids
		for (int i = 0; i < numOfOrders; i++) {
			stats[i][ORDER_ID] = (i + 1);
			pat_stats[i][ORDER_ID] = (i + 1);
		}


		for (int i = 0; i < numOfOrders; i++) {
			boolean happy = true;
			int deviate = 0;
			int meatOffTime = 0;
			for (int j = 0; j < pittes.size(); j++) {
				FoukouElement current = (FoukouElement) pittes.get(j);
				if (current.getOrderID() == stats[i][ORDER_ID]) {

					if (current.getTimeDiff() < 0) {
						happy = false;
						int cd = -current.getTimeDiff();
						if (cd > deviate) {

							deviate = cd;
						}
					}
					if (current.getMeatOffTime() > meatOffTime) {
						meatOffTime = current.getMeatOffTime();
					}

				}
			} 
			stats[i][SATISFIED] = happy ? 1 : 0;
			stats[i][DEVIATION] = deviate;
			stats[i][DELIVERED] = meatOffTime;
		} 

		for (int i = 0; i < numOfOrders; i++) {
			boolean happy = true;
			int deviate = 0;
			int potatoesOffTime = 0;
			for (int j = 0; j < patates.size(); j++) {
				TiganiElement current = (TiganiElement) patates.get(j);
				if (current.getOrderId() == pat_stats[i][ORDER_ID]) {

					if (current.getTimeDiff() < 0) {
						happy = false;
						int cd = -current.getTimeDiff();
						if (cd > deviate) {

							deviate = cd;
						}
					}
					if (current.getPotatoesOffTime() > potatoesOffTime) {
						potatoesOffTime = current.getPotatoesOffTime();
					}

				}
			} 
			pat_stats[i][SATISFIED] = happy ? 1 : 0;
			pat_stats[i][DEVIATION] = deviate;
			pat_stats[i][DELIVERED] = potatoesOffTime;
		} 


		//now we have to go through the two stats and pat_stas arrays and compare statistics
		int overall_stats[][] = new int[numOfOrders][4];
		for (int i = 0; i < numOfOrders; i++) {
			if (stats[i][ORDER_ID] == pat_stats[i][ORDER_ID]) {

				//working on the same order
				overall_stats[i][ORDER_ID] = stats[i][ORDER_ID];
				overall_stats[i][SATISFIED] = ((stats[i][SATISFIED] + pat_stats[i][SATISFIED]) == 2) ? 1 : 0;
				overall_stats[i][DEVIATION] = (stats[i][DEVIATION] > pat_stats[i][DEVIATION] ? stats[i][DEVIATION]
						: pat_stats[i][DEVIATION]);
				overall_stats[i][DELIVERED] = (stats[i][DELIVERED] > pat_stats[i][DELIVERED] ? stats[i][DELIVERED]
						: pat_stats[i][DELIVERED]);


			}
		}

		//calculate the average of the deviations and the sum of satisfied
		double sumofdev = 0;
		int sumofsat = 0;
		for (int i = 0; i < numOfOrders; i++) {
			sumofdev = sumofdev + overall_stats[i][DEVIATION];
			sumofsat = sumofsat + overall_stats[i][SATISFIED];
		} 
		double aveofdev = sumofdev / numOfOrders;

		System.out.println("" + orders.size() + " " + aveofdev + " " + sumofsat);
		for (int i = 0; i < numOfOrders; i++) {
			Order current = (Order) orders.get(i);
			System.out.print(current.getNum() + " " + current.getTorder());
			for (int k = 0; k < numOfOrders; k++) {
				if (current.getNum() == overall_stats[k][ORDER_ID]) {

					//this is the order
					
					System.out.print(" " + overall_stats[k][DELIVERED] + " " + overall_stats[k][DEVIATION]);
					break;
				}
			}

			System.out.println(" " + "(" + (current.getNpp() + current.getNpc() + current.getNps() + current.getNpm())
					+ ") " + current.getNpf());
		} 

	}

	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		if (args.length != 8) {
			System.out.println("Wrong number of parameters entered (Need 8 parameters!!!");
		} else {
			Foukou fuku = new Foukou(Integer.parseInt(args[1]), Integer.parseInt(args[0]));
			Restaurant souvlatzidiko = new Restaurant(fuku, Integer.parseInt(args[2]), Integer.parseInt(args[3]));
			int smilaWidth1 = Integer.parseInt(args[4]);
			int smilaWidth2 = Integer.parseInt(args[5]);
			int smilaWidth3 = Integer.parseInt(args[6]);
			Pitta.setPittaWidth(smilaWidth3);
			OrderDelivery oD = new OrderDelivery(fuku.getM(), fuku.getT(), souvlatzidiko.getTigania(),
					Integer.parseInt(args[3]), smilaWidth1, smilaWidth2, smilaWidth3);

			System.out.print("How many orders to generate?");
			int count = kb.nextInt();
			System.out.print("Press 1 for random generated orders\nPress 2 for manual generated orders");
			int mode = kb.nextInt();
			if (mode == 1) {
				//Start random order generator
                
                OrderGenerator generator = new OrderGenerator(count);
                ArrayList<Order> tmp = generator.getOrdersList();
                //orders are ready so we add them to souvlatzidiko
                
                for (int i=0; i<tmp.size(); i++) {
                    souvlatzidiko.addOrder((Order)tmp.get(i));    
                } 
                //Calling the process method
                souvlatzidiko.sortOrders();
 
                //calling  process method (which will call the showResults)
                process(souvlatzidiko,smilaWidth1,smilaWidth2);
                
			} else {
				// Start manual order generator
				for (int i = 0; i < count; i++) {
					System.out.println("Please enter the 7 parameters for the order");
					int p1 = kb.nextInt();
					int p2 = kb.nextInt();
					int p3 = kb.nextInt();
					int p4 = kb.nextInt();
					int p5 = kb.nextInt();
					int p6 = kb.nextInt();
					int p7 = kb.nextInt();
					Order a = new Order(p1, p2, p3, p4, p5, p6, p7);
					souvlatzidiko.addOrder(a);

				}
				souvlatzidiko.sortOrders();
				souvlatzidiko.listOrders();
				process(souvlatzidiko, smilaWidth1, smilaWidth2);

			}
		}
	}

}
