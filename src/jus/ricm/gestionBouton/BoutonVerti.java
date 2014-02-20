/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.*;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;



/**
 * Gestion des evenements pour le bouton Verti (creuser verticalement)
 *
 */
public class BoutonVerti implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(Contexte.nbVerti!=0){
			Actions.action_vertical();
		}

	}


}
