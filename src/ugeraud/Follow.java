/**
 * 
 */
package ugeraud;

/**
 * @author geraud
 *
 */
public class Follow implements Behavior{

	public Follow() {}

	@Override
	public void deplacer(Robot robot) {
		Point nouvellePosition = robot.getP().deplacer(Robot.getG(), 0.02);
		robot.setP(nouvellePosition);
	}
}
