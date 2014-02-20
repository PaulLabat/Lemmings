package jus.ricm.graphique;

import jus.ricm.gestionBouton.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


@SuppressWarnings("serial")
public class Menu extends JFrame {
	
	//On déclare la fenetre du menu
	private JPanel fenetreMenu;	
	private  ArrayList<MenuButton> liste_buttons = new ArrayList<MenuButton>(); 
	
    
    public Menu() {
    	//On lance l'affichage
        //Display();
     }
    
    /**
     * Fonction Pour ajouter dynamiquement un bouton au Menu
     * @param name1
     * @param name2
     */
    public void addButton(String name1, String name2){
    	liste_buttons.add(new MenuButton(name1,name2));
    }
    /**
     * Fonction Pour ajouter dynamiquement un bouton au Menu + menu pour gérer l'enchainement
     * @param name1
     * @param name2
     * @param m
     */
    public void addButton(String name1, String name2, Menu m){
    	MenuButton mb = new MenuButton(name1,name2);
    	mb.setMenuTransition(m);
    	liste_buttons.add(mb);
    }
    /**
     * Affiche le menu
     */
    public void Display()
	{
    	
    	//Paramètre initialisés par défault, pouvant etre modifiés par la suite
    	setSize(400,500);
    	setTitle("Menu Lemmings");
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//affichage au milieu
    	setLocationRelativeTo(null);    	
    	fenetreMenu = new JPanel();
    	fenetreMenu.setSize(400, 500);
    	fenetreMenu.setPreferredSize(new Dimension(400,500));
    	fenetreMenu.setBackground(Color.black);
    	fenetreMenu.setVisible(true);
    
    	
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("./img/lem_ico.png");
		setIconImage(image);
    	
    	//Mise à jour des boutons
    	this.majButtons();
    	     
    	setContentPane(fenetreMenu);
		
		pack();
           

	}
    /**
     * Met a jour l'etat des boutons
     */
    public void majButtons() {
    	//On ajoute tout les boutons
    	for (int i=0; i<this.liste_buttons.size();i++ ) {
    		fenetreMenu.add(liste_buttons.get(i), BorderLayout.CENTER);
    	}
    }
    
    public JPanel getPanel()
    {
    	return fenetreMenu;
    }
}
