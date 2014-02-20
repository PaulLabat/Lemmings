/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.*;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;




/**
 * Gestion des evenements du bouton Constructeurl
 *
 */
public class BoutonConstructeur implements ActionListener{

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(Contexte.nbConstructeur!=0){
			Actions.action_contructeur();
		}

	}


}
