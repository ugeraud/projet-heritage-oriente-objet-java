/**
 * 
 */
package ugeraud;

import robots.MissionViewer;

/**
 * @author geraud
 *
 */
public class SmartMission extends BasicMission {

	private AbstractPolicy policy;
	
	private SimplePolicy simplePolicy;
	
	/**
	 * 
	 * @param gisementConsidere
	 * @param nombreRobot
	 * @param nombrePhase
	 */
	public SmartMission(AbstractProblem gisementConsidere, int nombreRobot, int nombrePhase) {
		super(gisementConsidere, nombreRobot);
		policy = new SimplePolicy(nombrePhase);
		simplePolicy = new SimplePolicy(nombrePhase);
		simplePolicy.add(new LocalBest(), 60);
		simplePolicy.add(new Explore(), 50);
		simplePolicy.add(new Follow(), 20);
	}
	
	
	/**
	 * ordre de mission Explore() - Follow() - LocalBest() pour un temps de 60 - 50 - 20 
	 */
	public void run() {
		for (int p = 0; p < policy.getNombreDePhase(); p++) {
			for (int i = 0; i < getSize() ; i++) {
				Robot robot = get(i);
				robot.setBehavior(simplePolicy.phase(p));
			}
			for (int j = 0; j < simplePolicy.dureePhase(p); j++) {
				collecte();
				enregistre();
				marche();
				double BestTeneurGlobale = Robot.getBestTeneurGlobale();
				System.out.println(BestTeneurGlobale);
			}
		}
		getPrinter().close();
	}
	
	
	/**
	 * Méthode de test
	 * @param args
	 */
	public static void main(String[] args) {
		Eggholder eggholder = new Eggholder();
		SmartMission smartMission = new SmartMission(eggholder, 20,3);
		smartMission.run();
		MissionViewer.display(true);
	}

}
