/**
 * 
 */
package ugeraud;

import java.util.Random;
/**
 * @author gerau
 *
 */
public class Point {
	/**
	 * génération de nombre flotant aléatoire entre 0 et 1
	 */
	private static Random random=new Random();
	
	/**
	 * Abscisse du robot
	 */
	private double x;
	
	/**
	 * Ordonnée du robot
	 */
	private double y;
	
	/**
	 * constructeur pour initialiser x et y
	 */
	public Point() {
		this.setX(random.nextDouble());
		this.setY(random.nextDouble());
	}
	
	/**
	 * constructeur pour initialiser x et y
	 * @param xx abscisse du robot
	 * @param yy ordonnée du robot
	 */
	public Point(double xx, double yy) {
		this.setX(xx);
		this.setY(yy);
	}
	
	/**
	 * 
	 * @param cible 
	 * @return la distance entre la position courante du robot et la position cible
	 */
	public double distance(Point cible) {
		double Xp = cible.getX() - this.getX();
		double Yp = cible.getY() - this.getY();
		return Math.sqrt(Math.pow(Xp, 2) + Math.pow(Yp, 2));
	}
	
	/**
	 * 
	 * @param cible
	 * @param d correspond à la distance de déplacement autorisée par
				unité de temps en tenant compte de la puissance du mobile
	 * @return un la nouvelle position du robot après un déplacement
	 */
	public Point deplacer(Point cible, double d) {
		if((this.getX()==cible.getX() && this.getY()==cible.getY()) || this.distance(cible) < d ) {
			return cible;
		}
		double distance = this.distance(cible);
		double X = (cible.getX() - this.getX())*d/distance + this.getX();
		double Y = (cible.getY() - this.getY())*d/distance  + this.getY();
		
		// condition sur X pour rester entre 0 et 1
		if(X > 1.0){
			X = 1.0;
		}
		if(X < 0.0) {
			X = 0.0;
		}
		
		// condition sur Y pour rester entre 0 et 1
		if (Y > 1.0) {
			Y = 1.0;
		}
		if(Y < 0.0) {
			 Y = 0.0;
		}
		
		// crée et renvoie le point P
		return (new Point(X,Y));
	}

	/**
	 * 
	 * @return l'abscisse du robot
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @return l'ordonnée du robot
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 * @param x abscisse du robot
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * 
	 * @param y ordonnée du robot
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**===================================================================================
	 * 									Méthode de test
	 * ===================================================================================
	 */
	public static void main(String [] args) {
		Point p = new Point();
		System.out.println("Position courante : (" +p.getX() + " : " + p.getY()+")");
		Point cible = new Point(0.5,0.5);		
		System.out.println("Position cible : ("+cible.getX() + " : " + cible.getY()+")");
		double d = p.distance(cible);
		System.out.println("Distance calculée : "+d);
		Point P = p.deplacer(cible, 0.02);
		System.out.println("Nouvelle position : ("+P.getX() + " : " + P.getY()+")");
	}

}
