/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.*;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;


/**
 * Gestion des evenements du bouton pioche
 *
 */
public class BoutonPioche implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		if(Contexte.nbPioche!=0){
			Actions.action_pioche();
		}

	}


}
