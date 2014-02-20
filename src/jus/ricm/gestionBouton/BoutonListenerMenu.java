/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jus.ricm.contexte.Contexte;



/**
 * Gestion des evenements du bouton Menu 
 *
 */
public class BoutonListenerMenu implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Contexte.initContexte = false;
		Contexte.runnable = false;
		Contexte.jeu.dispose();
		
	}



}
