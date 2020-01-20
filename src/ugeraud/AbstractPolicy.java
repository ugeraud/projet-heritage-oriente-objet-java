/**
 * 
 */
package ugeraud;

/**
 * @author gerau
 *
 */
abstract class AbstractPolicy {
	private int nombreDePhase;
	public AbstractPolicy(int nbP) {
		setNombreDePhase(nbP);
	}
	public int getNombreDePhase() {
		return nombreDePhase;
	}
	public void setNombreDePhase(int nombreDePhase) {
		this.nombreDePhase = nombreDePhase;
	}
	public abstract Behavior phase(int p);
	public abstract int dureePhase(int t);
}
