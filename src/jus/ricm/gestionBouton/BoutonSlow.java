/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jus.ricm.contexte.Contexte;



/**
 * Gestion du ralentissement du temps de jeu au clique sur le bouton Slow
 *
 */
public class BoutonSlow implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Contexte.UPDATE_PERIOD += 5;
	}


}
