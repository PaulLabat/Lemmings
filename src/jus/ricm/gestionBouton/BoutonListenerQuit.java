/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
/**
 * Gestion des evenements du bouton Quitter
 *
 */
public class BoutonListenerQuit implements ActionListener {

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Permet de quitter le programme
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);

	}

}
