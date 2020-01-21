/**
 * 
 */
package ugeraud;

/**
 * @author gerau
 *
 */
public class Robot {

	// position courante P
	private Point P;
		
	// position où le robot a eu sa meilleure teneur en minerai
	private Point bestPosition;
		
	// teneur courante en minerai à la position P
	private double teneurCourante;
		
	// meilleure teneur en minerai obtenue au cours de son déplacement
	private double bestTeneurObtenueParLeRobot;
		
	// meilleure position globale G de toute la colonie où il y a plus de teneur en minerai
	private static Point G;
		
	// meilleure teneur en minerai globale de toute la colonie
	private static double bestTeneurGlobale;
		
	// comportement du robot
	private Behavior behavior;
	
	/**
	 * constructeur d'initialisation
	 * @param p
	 */
	public Robot(Point p) {
		setP(p);
		setBestTeneurGlobale(0.0);
		setTeneurCourante(0.0);
		setBestTeneurObtenueParLeRobot(0.0);
		setG(new Point(0.0,0.0));
		setBehavior(new Explore());
	}
	
	/**
	 * action sur comportement du robot
	 */
	public void marche() {
		behavior.deplacer(this);
	}

	/**
	 * 
	 * @return la position courante du robot
	 */
	public Point getP() {
		return P;
	}

	/**
	 * définit la position courante du robot
	 * @param p
	 */
	public void setP(Point p) {
		P = p;
	}

	/**
	 * retourne la valeur de la teneur en minerai courante
	 * @return double
	 */
	public double getTeneurCourante() {
		return teneurCourante;
	}

	/**
	 * met à jour la teneur en minerai courante du robot
	 * @param teneurCourante
	 */
	public void setTeneurCourante(double teneurCourante) {
		this.teneurCourante = teneurCourante;
	}

	/**
	 * retourne la valeur maximale de teneur en minerai obtenu par le robot au cours de sont déplacement
	 * @return double
	 */
	public double getBestTeneurObtenueParLeRobot() {
		return bestTeneurObtenueParLeRobot;
	}

	/**
	 * 
	 * @param bestTeneurObtenueParLeRobot
	 */
	public void setBestTeneurObtenueParLeRobot(double bestTeneurObtenueParLeRobot) {
		this.bestTeneurObtenueParLeRobot = bestTeneurObtenueParLeRobot;
	}

	/**
	 * 
	 * @return
	 */
	public static Point getG() {
		return G;
	}
	
	/**
	 * 
	 * @param g
	 */
	public static void setG(Point g) {
		G = g;
	}

	/**
	 * 
	 * @return
	 */
	public static double getBestTeneurGlobale() {
		return bestTeneurGlobale;
	}
	
	/**
	 * 
	 * @param bestTeneurGlobale
	 */
	public static void setBestTeneurGlobale(double bestTeneurGlobale) {
		Robot.bestTeneurGlobale = bestTeneurGlobale;
	}

	/**
	 * 
	 * @param behavior
	 */
	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point getBestPosition() {
		return bestPosition;
	}

	/**
	 * 
	 * @param bestPosition
	 */
	public void setBestPosition(Point bestPosition) {
		this.bestPosition = bestPosition;
	}
		
}