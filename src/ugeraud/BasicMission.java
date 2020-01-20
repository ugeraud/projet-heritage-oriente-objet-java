/**
 * 
 */
package ugeraud;

import robots.MissionViewer;
import utilitaires.Printer;

/**
 * @author geraud
 *
 */
public class BasicMission {

	// teneur à la position courante du robot
	private AbstractProblem gisement;
		
	// tableau pour mémoriser les robots
	private Robot [] tableauDeRobots;
		
	// taille du tableau de robot
	private int size;
	
	private Printer printer;
	
	private final String filename = "data/BasicMission.txt";
	
	/**
	 * 
	 * @param gisementConsidere
	 * @param nombreRobot
	 */
	public BasicMission(AbstractProblem gisementConsidere, int nombreRobot) {
		gisement = gisementConsidere;
		tableauDeRobots = new Robot[nombreRobot];
		size = 0;
		printer = new Printer(filename);
		init();
	}

	/**
	 * 
	 * @param robot
	 */
	public void set(Robot robot) {
		tableauDeRobots[size++] = robot;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Robot get(int index) {
		return tableauDeRobots[index];
	}
	
	/**
	 * crée tous les robots et leur attribue le comportement explore
	 */
	private void init() {
		for (int i = 0; i < tableauDeRobots.length; i++) {
			Point centre = new Point(0.5,0.5);
			Robot robot = new Robot(centre);
			Explore explore = new Explore();
			robot.setBehavior(explore);
			set(robot);
		}
	}
		
	public void collecte() {
		for (int i = 0; i < tableauDeRobots.length; i++) {
			Robot robot = get(i);
			robot.setTeneurCourante(getGisement().collecteDonnee(robot));
			if(robot.getTeneurCourante() > robot.getBestTeneurObtenueParLeRobot()) {
				robot.setBestTeneurObtenueParLeRobot(robot.getTeneurCourante());
				robot.setBestPosition(robot.getP());
			}
			if(robot.getBestTeneurObtenueParLeRobot() > Robot.getBestTeneurGlobale()) {
				Robot.setBestTeneurGlobale(robot.getBestTeneurObtenueParLeRobot());
				Robot.setG(robot.getP());
			}
		}
	}
	
	/**
	 * déplace les robots
	 */
	public void marche() {
		for (int i = 0; i < tableauDeRobots.length; i++) {
			Robot robot = get(i);
			robot.marche();
		}
	}
	
	/**
	 * enregistre les positions courantes des robots dans un fichier.txt
	 */
	public void enregistre() {
		printer.println("-1");
		for (int i = 0; i < tableauDeRobots.length; i++) {
			Robot robot = get(i);
			printer.println(i+"\t"+robot.getP().getX()+"\t"+robot.getP().getY());
		}
	}
	
	/**
	 * 100 cycles pour une mission 
	 */
	public void run() {
		for (int iter=0;iter<100;iter++){
			collecte();
			enregistre();
			System.out.println("iter="+iter+" "+Robot.getBestTeneurGlobale());
			marche();
		}
		printer.close();
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getSize() {
		return size;
	}
		
	/**
	 * 	
	 * @return Printer
	 */
	public Printer getPrinter() {
		return printer;
	}

	/**
	 * 
	 * @return AbstractProblem
	 */
	public AbstractProblem getGisement() {
		return gisement;
	}

	/**
	 * Méthode de test
	 * @param args
	 */
	public static void main(String[] args) {
		Eggholder eggholder = new Eggholder();
		BasicMission basicMission = new BasicMission(eggholder, 20);
		basicMission.run();
		MissionViewer.display();
	}
		
}
