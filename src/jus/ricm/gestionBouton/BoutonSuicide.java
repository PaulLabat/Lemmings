/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;


import java.awt.event.*;

import jus.ricm.contexte.Actions;



/**
 * Gestion des evenements pour le bouton Verti (creuser verticalement)
 *
 */
public class BoutonSuicide implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
			Actions.action_suicide();
	}


}