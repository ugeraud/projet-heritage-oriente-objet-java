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
		simplePolicy.add(new Explore(), 80);
		simplePolicy.add(new Follow(), 60);
		simplePolicy.add(new LocalBest(), 40);
	}
	
	
	/**
	 * ordre de mission Explore() - Follow() - LocalBest() 
	 */
	public void run() {
		for (int p = 0; p < policy.getNombreDePhase(); p++) {
			for (int i = 0; i < getSize() ; i++) {
				Robot robot = get(i);
				robot.setBehavior(simplePolicy.phase(p));
			}
			for (int i1 = 0; i1 < simplePolicy.dureePhase(p); i1++) {
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
		SmartMission smartMission = new SmartMission(eggholder, 50,3);
		smartMission.run();
		MissionViewer.display();
	}

}
