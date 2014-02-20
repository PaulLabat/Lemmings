package jus.ricm.graphique;

import jus.ricm.contexte.Contexte;



public class FenetrePrincipale {
		
	public static void main(String[] args) {
		Contexte.option_menu = new Menu();
		//On ajoute les menus d'options
		Contexte.option_menu.addButton("./img/sound0.png","./img/sound1.png");
		Contexte.option_menu.addButton("./img/back0.png","./img/back1.png",Contexte.option_menu);
		
		//Creation du menu credits
		Menu credits_menu = new Menu();
		 /* frame.setSize(250,200);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		//labelcredits.setIcon(Contexte.imageBloque);
		//labelcredits.setVisible(true);
		credits_menu.addButton("./img/imgcredits.png","./img/imgcredits.png",credits_menu);
		credits_menu.addButton("./img/back0.png","./img/back1.png",credits_menu);
		
		Contexte.start_menu = new Menu();
		//On ajoute les boutons au menu
		Contexte.start_menu.addButton("./img/play0.png","./img/play1.png");
		Contexte.start_menu.addButton("./img/credits0.png","./img/credits1.png",credits_menu);
		Contexte.start_menu.addButton("./img/options0.png","./img/options1.png",Contexte.option_menu);
		Contexte.start_menu.addButton("./img/quit0.png","./img/quit1.png");
		//Affichage
		Contexte.start_menu.Display();
		Contexte.start_menu.setVisible(true);
		

	}
}
