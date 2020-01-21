/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class Sphere implements AbstractProblem{

	private final int max = 1;
	
	private final int min = 0;
	
	public Sphere() {}
	
	@Override
	public double collecteDonnee(Robot robot) {
		double teneur = (1 - (Math.pow(robot.getP().getX(), 2) + Math.pow(robot.getP().getY(), 2))/2);
		
		// normalisation de la valeur de teneur en minerai calculé à la position (x,y)
		if(teneur < min) teneur = min;
				
		if(teneur > max) teneur = max;
				
		return 255*teneur;
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