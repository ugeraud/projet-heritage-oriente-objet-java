/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class Explore implements Behavior{

	/**
	 * Position initiale du robot
	 */
	private Point M;
	
	private final double X = 0.5;
	
	private final double Y = 0.5;
	
	/**
	 * constructeur pour initialiser M(0.5,0.5)
	 */
	public Explore() {
		M = new Point(X,Y);
	}
	
	/**
	 * 
	 */
	@Override
	public void deplacer(Robot robot) {
		// point quelconque généré aléatoirement entre 0 et 1
		Point A = new Point();	
		
		// calcul du vecteur MA
		double x = A.getX() - getM().getX();
		double y = A.getY() - getM().getY();
		
		// calcul de la position P'
		double Xp = robot.getP().getX() + x;
		double Yp = robot.getP().getY() + y;
		
		Point p = new Point(Xp,Yp);
		
		// calcul de la nouvelle position après déplacement du robot
		Point nouvellePosition = robot.getP().deplacer(p, 0.05);
		
		// définit la nouvelle position courante du robot
		robot.setP(nouvellePosition);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Point getM() {
		return M;
	}
	
	/**
	 * 
	 * @param m
	 */
	public void setM(Point m) {
		M = m;
	}
	
	/**
	 * Methode de test
	 * @param args
	 */
	public static void main(String[] args) {
		
		// position initiale pour le robot
		Point p = new Point(0.5,0.5); 
		
		Robot robot = new Robot(p);
		
		Explore explore=new Explore();
		
		// le robot possède le comportement explore
		robot.setBehavior(explore); 
		
		for (int i=0;i<20;i++){
			robot.marche();
			System.out.println(i+" Position courante : "+robot.getP().getX()+" "+robot.getP().getY());
		}
	}

}
