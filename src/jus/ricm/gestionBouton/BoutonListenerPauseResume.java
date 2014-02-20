/**
 * @author Labat Paul, Eudes Robin
 */

package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jus.ricm.contexte.Contexte;



/**
 * Gestion des evenements des bouton Pause et Reprendre
 *
 */
public class BoutonListenerPauseResume implements ActionListener {
	
	long backup_time;
	public BoutonListenerPauseResume(JButton pause, JButton reprendre)
	{
		this.pause = pause;
		this.reprendre = reprendre;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nom = arg0.getActionCommand();
		//action a effectuer si jeu en pause
		if(nom == "Pause")
		{
			backup_time = System.currentTimeMillis();
			Contexte.pause = true;
			pause.setEnabled(false);
			reprendre.setEnabled(true);
		}
		//action a effectuer si retour en jeu
		else if(nom == "Reprendre")
		{
			
			Contexte.init = System.currentTimeMillis() - backup_time + Contexte.init;
			Contexte.pause = false;
			reprendre.setEnabled(false);
			pause.setEnabled(true);
			
		}

	}

	JButton pause;
	JButton reprendre;
}
