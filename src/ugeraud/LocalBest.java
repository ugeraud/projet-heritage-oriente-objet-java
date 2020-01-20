/**
 * 
 */
package ugeraud;

/**
 * @author gerau
 *
 */
public class LocalBest implements Behavior{

	public LocalBest() {}
	
	@Override
	public void deplacer(Robot robot) {
		Point nouvellePosition = robot.getP().deplacer(robot.getBestPosition(), 0.02);
		robot.setP(nouvellePosition);
	}

}
