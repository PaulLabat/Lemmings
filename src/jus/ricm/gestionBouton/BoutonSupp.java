/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;



/**
 * Gestion des evenements du bouton personnalisable par le joueur
 *
 */
public class BoutonSupp implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Contexte.nbSupp != 0)
		{
			Actions.action_supp();
		}
		

	}

}
