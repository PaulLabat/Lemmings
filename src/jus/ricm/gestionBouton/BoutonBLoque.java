/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.*;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;



public class BoutonBLoque implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Contexte.nbBloque!=0){
			Actions.action_bloque();

		}
	}


}
