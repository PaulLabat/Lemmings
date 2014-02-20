/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.*;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;



/**
 * Gestion des evenements du bouton Parapluie
 *
 */
public class BoutonParapluie implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		if(Contexte.nbParapluie!=0){
			Actions.action_parapluie();
		}

	}


}
