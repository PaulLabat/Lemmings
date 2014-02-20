/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jus.ricm.contexte.Contexte;



/**
 * Gestion de l'acceleration de la vitesse de jeu au clique sur le bouton Fast
 *
 */
public class BoutonFast implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Contexte.UPDATE_PERIOD -= 5; 

	}

}
