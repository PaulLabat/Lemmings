/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gestion des evenements du bouton option
 *
 */
public class BoutonListenerOption implements ActionListener {

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Gestion des options
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Bouton option");

	}

}
