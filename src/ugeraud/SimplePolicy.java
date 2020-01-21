/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class SimplePolicy extends AbstractPolicy{

	private Behavior [] tabBehavior;
	private int [] tabTemps;
	private int sizeBehavior;
	private int sizeTime;

	/**
	 * 
	 * @param nbP
	 */
	public SimplePolicy(int nbP) {
		super(nbP);
		tabBehavior = new Behavior[nbP];
		tabTemps = new int[nbP];
		sizeBehavior = 0;
		sizeTime = 0;
	}
	
	/**
	 * 
	 * @param behavior
	 * @param time
	 */
	public void add(Behavior behavior, int time) {
		tabBehavior[sizeBehavior++] = behavior;
		tabTemps[sizeTime++] = time;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getSizeBehavior() {
		return sizeBehavior;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getSizePhase() {
		return sizeTime;
	}
	
	@Override
	public Behavior phase(int index) {
		return tabBehavior[index];
	}
	
	@Override
	public int dureePhase(int index) {
		return tabTemps[index];
	}
}
