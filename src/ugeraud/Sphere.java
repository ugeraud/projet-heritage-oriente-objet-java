/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class Sphere implements AbstractProblem{

	public Sphere() {}
	
	@Override
	public double collecteDonnee(Robot robot) {
		return (1 - (Math.pow(robot.getP().getX(), 2) + Math.pow(robot.getP().getY(), 2))/2);
	}

	/**
	 * Méthode de test
	 * @param args
	 */
	public static void main(String[] args) {
		Sphere sphere = new Sphere();
		Point p = new Point(0,0);
		Robot robot = new Robot(p);
		double teneur = sphere.collecteDonnee(robot);
		System.out.println("Teneur en minerai à la position : ("+robot.getP().getX()+" : "+robot.getP().getY()+") = "+teneur);
		
		Point p1 = new Point(0.5,0.5);
		Robot robot1 = new Robot(p1);
		double teneur1 = sphere.collecteDonnee(robot1);
		System.out.println("Teneur en minerai à la position : ("+robot1.getP().getX()+" : "+robot1.getP().getY()+") = "+teneur1);

	}
}