package jus.ricm.gestionBouton;

import jus.ricm.contexte.Contexte;
import jus.ricm.graphique.*;
import jus.ricm.interpreteur.ParserXML;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jus.ricm.ordonnanceur.Ordonnanceur;

@SuppressWarnings("serial")
public class MenuButton extends JButton implements ActionListener {
	
	private String nameNS;
	private String nameS;
	private Image notSelected;
    private Image selected;
    private Menu MenuTransition = new Menu();
    
	public MenuButton (String name1, String name2) {
		
		this.nameNS = name1;
		this.nameS = name2;
		this.notSelected = getToolkit().createImage(nameNS);
    	this.selected = getToolkit().createImage(nameS);
    	//On ajoute l'evenement en cas de clic
    	this.setEvent();
    	//Non selectionné par défault
    	this.setNotSelectMode();
    	//On ajoute les action selectionné/non selectionné au passage de la souris
    	this.setSouris();
    	//On enleve les bords
    	this.setFocusPainted(false);
    	this.setBorderPainted(false);
    	this.setContentAreaFilled(false);
    	
	}
	
	public void setEvent(){
		this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	effectuerAction();
            }
        });
	}
	
	//Gestion du passage de la souris
	public void setSouris() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				setSelectMode();
			}
		 
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				setNotSelectMode();
			}
		});
	}
		
	public void effectuerAction() {
		//On enleve le X.png et on récupere l'action
		String action = this.nameNS.substring(0,this.nameNS.length()-5);
		//Necessite JRE 1.7
		/*switch (action) {
			
		}*/
		if (action.compareTo("./img/quit")== 0) {
			System.exit(0); 
		}
		else if (action.compareTo("./img/play")==0) {
			
			this.init_game();
		}
		else if (action.compareTo("./img/credits")==0) {
			this.MenuTransition.Display();
			this.MenuTransition.setVisible(true);
		}
		else if (action.compareTo("./img/options")==0) {
			//On affiche le menu suivant
			this.MenuTransition.Display();
			this.MenuTransition.setVisible(true);
		}
		else if (action.compareTo("./img/back")==0) {
			//On affiche le menu suivant
			this.MenuTransition.setVisible(false);
		}
		else if (action.compareTo("./img/options")==0) {
			//On affiche le menu suivant
			this.MenuTransition.Display();
			this.MenuTransition.setVisible(true);
		}
		else if (action.compareTo("./img/sound") == 0)
		{
			Contexte.mute = ! Contexte.mute;
			if(!Contexte.mute)
			{
				JOptionPane.showMessageDialog(null, "Son desactive", "Option", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Son active ", "Option", JOptionPane.INFORMATION_MESSAGE);	
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Menu introuvable", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	//Passage dans le mode selectionné
	public void setSelectMode () {
		ImageIcon selected = new ImageIcon(this.selected);
        this.setIcon(selected);
	}
	//Passage dans le mode non selectionné 
	public void setNotSelectMode () {
		ImageIcon notSelected = new ImageIcon(this.notSelected);
        this.setIcon(notSelected);
	}
	public void setMenuTransition(Menu m){
		this.MenuTransition = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@SuppressWarnings("unused")
	public void init_game() {
		int width = 1280;
		int height = 700;
		
		Contexte.jeu = new FenetreJeu(height,width, "Jeu Lemmings");
		Contexte.jeu.setVisible(false);
		Contexte.init_contexte();
	
		ParserXML test;
		final JFileChooser fc = new JFileChooser();
		
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new XmlFilter());
		int returnVal = fc.showOpenDialog(null);
		//Selecteur de fichiers
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			Contexte.nomFich = file.toString();
			test = new ParserXML(file.toString());
		}
		else
		{
			Contexte.nomFich = "./FichierXML.xml";
			test = new ParserXML("./FichierXML.xml");
		}

		//init et lancement du jeu
		Contexte.ordo = new Ordonnanceur(width,height);
		Contexte.ordo.gameLoop();
		Contexte.init = System.currentTimeMillis();
		
		
	}

}
