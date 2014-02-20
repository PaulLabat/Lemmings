/**
 * @author Labat Paul, Eudes Robin
 */
package jus.ricm.ordonnanceur;

import javax.swing.JOptionPane;
import jus.ricm.contexte.Contexte;

public class Ordonnanceur {
	private int i=0;



	/**
	 * Definition du Thread principal. Permet de faire tourner le jeu.
	 */
	Thread updateThread = new Thread() {
		@Override
		public void run() {
			//while avec condition qui permet d'arrete le thread
			while (Contexte.runnable) {
				Contexte.canvas.repaint();  // refresh le cnavas, rappel paintComponent()

				if(!Contexte.pause && Contexte.initContexte) // si le jeu n'est pas en pause et que le contexte est initialiser
				{
					Contexte.jeu.update_time(); //maj du temps
					Contexte.jeu.update_compteurs_type(); // maj des informations

					//ajout d'un nouveau lemmings au jeu tous les 100 cycle (environ 4sec)
					i++;
					if(i%100==0){
						Contexte.canvas.born(Contexte.n_max,Contexte.spawnX1,Contexte.spawnY1, Contexte.spawnX2, Contexte.spawnY2);
					}
					//mise a jour des lemmings
					traiteLemmings();

					Contexte.time = System.currentTimeMillis(); 
					//verifie si on gagne
					isVictoire();
				}

				try {
					// Delay and give other thread a chance to run
					Thread.sleep(Contexte.UPDATE_PERIOD);  // milliseconds
				} catch (InterruptedException ignore) {}
			}
		}
	};

	/**
	 * Constructeur de l'ordo
	 * @param width largeur
	 * @param height hauteur
	 */
	public Ordonnanceur(int width, int height)
	{
		Thread t = new Thread(Contexte.musicMenu);
		Contexte.jeu.setVisible(true);
		Contexte.jeu.panelSupp.setVisible(Contexte.btn_sup);
		if(Contexte.mute)
		{
			t.start();
		}
	}

	/**
	 * Boucle principale de jeu
	 */
	public void gameLoop()
	{
		updateThread.start(); // called back run()

	}

	/**
	 * Traitement du lemming...
	 */
	private void traiteLemmings()
	{
		int j;
		if(Contexte.initContexte) // si contexte initialise
		{
			for(j=0;j<Contexte.nbLemmings ;j++)
			{
				if(Contexte.tabLemmings[j].isVivant()) // si lemmings vivant, on le traite
				{
					Contexte.tabLemmings[j].transition();

				}
			}
		}
	}

	//a modifier, fermer thread du son
	private void isVictoire()
	{
		if(Contexte.n_max == (Contexte.dead + Contexte.nbSave))
		{
			if(Contexte.ratio_home >= Contexte.obj)
			{
				Contexte.runnable = false; // arret du thread
				Contexte.victoire.run();
				JOptionPane.showMessageDialog(null, "Victoire", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				Contexte.runnable = false; // arret du thread
				JOptionPane.showMessageDialog(null, "Defaite", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(Contexte.canvas.get_min() == Contexte.tempsMax)
		{
			Contexte.runnable = false; // arret du thread
			JOptionPane.showMessageDialog(null, "Temps ecoule", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
		}
	}



}
