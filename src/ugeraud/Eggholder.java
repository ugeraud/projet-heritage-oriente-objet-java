/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class Eggholder implements AbstractProblem{

	private final int k = 1024;
	
	private final double constante = 0.5;
	
	private final int max = 1050;
	
	private final int min = - 960;
	
	public Eggholder() {}
	
	
	@Override
	public double collecteDonnee(Robot robot) {
		double x = k * (robot.getP().getX() - constante);
		double y = k * (robot.getP().getY() - constante);
		double r1 = Math.abs((x/2) + (y + 47));
		double r2 = Math.abs(x - (y + 47));
		double teneur = -(y + 47) * Math.sin(Math.sqrt(r1)) - x * Math.sin(Math.sqrt(r2));
		
		// normalisation de la valeur de teneur en minerai calculé à la position (x,y)
		if(teneur < min) teneur = min;
		
		if(teneur > max) teneur = max;
		
		return (17*teneur)/134 + 8160/67;
			
	}
	
	public static void main(String[] args) {
		Eggholder eggholder = new Eggholder();
		Point p = new Point(0.0,1.0);
		Robot robot = new Robot(p);
		double teneur = eggholder.collecteDonnee(robot);
		System.out.println("Teneur en minerai à la position : ("+robot.getP().getX()+" : "+robot.getP().getY()+") = "+teneur);
		
		Point p1 = new Point(0.5,1.0);
		Robot robot1 = new Robot(p1);
		double teneur1 = eggholder.collecteDonnee(robot1);
		System.out.println("Teneur en minerai à la position : ("+robot1.getP().getX()+" : "+robot1.getP().getY()+") = "+teneur1);
	}

}
