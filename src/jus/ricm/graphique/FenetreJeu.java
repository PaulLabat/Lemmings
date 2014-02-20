package jus.ricm.graphique;

import jus.ricm.contexte.Actions;
import jus.ricm.contexte.Contexte;
import jus.ricm.gestionBouton.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;




@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements MouseListener{
	/**
	 * VARIABLES...
	 */
	JPanel fenetreJeu;
	JPanel conteneurJeu;
	JPanel conteneurMenu;
	JPanel info;
	JPanel menu;
	JPanel bouton;
	JPanel fenetrePrincipale;
	JPanel conteneurOut;
	JPanel conteneurDead;

	JPanel conteneurHome;
	JPanel conteneurTime;
	JPanel conteneurObjectifs;

	JPanel panelBombe;
	JLabel labelBombe;
	JButton boutonBombe;

	JPanel panelParapluie;
	JLabel labelParapluie;
	JButton boutonParapluie;

	JPanel panelBloque;
	JLabel labelBloque;
	JButton boutonBloque;

	JPanel panelGrimpe;
	JLabel labelGrimpe;
	JButton boutonGrimpe;

	JPanel panelPioche;
	JLabel labelPioche;
	JButton boutonPioche;

	JPanel panelLuciole;
	JLabel labelLuciole;
	JButton boutonLuciole;

	JPanel panelHorizon;
	JLabel labelHorizon;
	JButton boutonHorizon;

	JPanel panelVerti;
	JLabel labelVerti;
	JButton boutonVerti;

	JPanel panelConstructeur;
	JLabel labelConstructeur;
	JButton boutonConstructeur;

	JLabel labelVitesseJeu;

	JPanel panelFastSlow;
	JButton boutonFast;
	JButton boutonSlow;

	JLabel labelControl;
	JButton boutonControl;
	JPanel panelControl;

	JLabel labelSupp;
	JButton boutonSupp;
	public JPanel panelSupp;
	
	JButton boutonsuicide;
	JPanel panelsuicide;
	JLabel labelsuicide;


	JScrollPane scrollpane = new JScrollPane();


	JLabel labelOut = new JLabel("Vivants : ");
	JLabel valeur_out = new JLabel();
	JLabel labeldead = new JLabel("Morts : ");
	JLabel valeur_dead = new JLabel();


	JLabel labelHome = new JLabel("@Home : ");
	JLabel valeur_home = new JLabel();
	JLabel ratio_home = new JLabel();
	JLabel labelObjectif = new JLabel("Objectifs : ");
	JLabel valeur_obj = new JLabel();
	JLabel labelTime = new JLabel("Temps : ");


	JLabel sep_time = new JLabel(":");
	JLabel minutes = new JLabel();
	JLabel secondes = new JLabel();
	JButton boutonMenu;
	JButton boutonReset;
	JButton boutonQuitter;
	JButton boutonPause;
	JButton boutonReprendre;
	BoutonListenerQuit actionQuit;
	BoutonReset actionReset;
	BoutonListenerMenu actionMenu;
	BoutonListenerPauseResume actionPR;

	/**
	 * Constructeur Fenetre jeu
	 * @param hight hauteur fenetre
	 * @param width largeur fenetre
	 * @param title titre fenetre
	 */
	public FenetreJeu(int hight, int width, String title)
	{
		Contexte.canvas = new map_canvas(width, hight);
		Contexte.canvas.addMouseListener(this);

		Toolkit.getDefaultToolkit().addAWTEventListener(
				new AWTEventListener(){
					public void eventDispatched(AWTEvent event){
						KeyEvent ke = (KeyEvent)event;

						if(Contexte.last || Contexte.valControl){
							if(ke.getID() == KeyEvent.KEY_PRESSED){
								if(ke.getKeyCode()==KeyEvent.VK_RIGHT || ke.getKeyCode()==KeyEvent.VK_KP_RIGHT){
									if(Contexte.tabLemmings[Contexte.indice_lem_selected].getSens()==0 ){
										Contexte.tabLemmings[Contexte.indice_lem_selected].setSens(1);

										if(Contexte.indice_lem_selected_pred!=Contexte.indice_lem_selected){
											if(Contexte.nbControl!=0){
												Contexte.nbControl--;
											}
											Contexte.indice_lem_selected_pred=Contexte.indice_lem_selected;
										}
										if(Contexte.nbControl==0){
											Contexte.jeu.get_control().setBackground(new Color(158,211,255));
											Contexte.jeu.get_control().setText("CTRL OFF");
											Contexte.jeu.get_control().setEnabled(false);
											Contexte.valControl=false;
											Contexte.last=true;									
										}
									}
								}
								if(ke.getKeyCode()==KeyEvent.VK_LEFT || ke.getKeyCode()==KeyEvent.VK_KP_LEFT){
									if(Contexte.tabLemmings[Contexte.indice_lem_selected].getSens()==1 ){
										Contexte.tabLemmings[Contexte.indice_lem_selected].setSens(0);
										if(Contexte.indice_lem_selected_pred!=Contexte.indice_lem_selected){
											if(Contexte.nbControl!=0){
												Contexte.nbControl--;
											}
											Contexte.indice_lem_selected_pred=Contexte.indice_lem_selected;
										}


										if(Contexte.nbControl==0){
											Contexte.jeu.get_control().setBackground(new Color(158,211,255));
											Contexte.jeu.get_control().setText("CTRL OFF");
											Contexte.jeu.get_control().setEnabled(false);
											Contexte.valControl=false;
											Contexte.last=true;
										}
									}
								}

							}

						}
						if(ke.getID() == KeyEvent.KEY_PRESSED && (ke.getKeyCode()!=KeyEvent.VK_LEFT || ke.getKeyCode()!=KeyEvent.VK_KP_LEFT)
								&& (ke.getKeyCode()!=KeyEvent.VK_RIGHT || ke.getKeyCode()!=KeyEvent.VK_KP_RIGHT)){
							if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_A){
								//System.out.println("Bloqueur");
								Actions.action_bloque();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_Z){
								//System.out.println("Bombe");
								Actions.action_bombe();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_E){
								//System.out.println("Grimpeur");
								Actions.action_grimpe();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_R){
								//System.out.println("Creuseur Horizontal");
								Actions.action_horizontal();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_T){
								//System.out.println("Lulz");
								Actions.action_luciole();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_Y){
								//System.out.println("Mary Poppins");
								Actions.action_parapluie();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_U){
								//System.out.println("Le 7eme nain");
								Actions.action_pioche();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_I){
								//System.out.println("Verticalus");
								Actions.action_vertical();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_O){
								//System.out.println("Escalator");
								Actions.action_contructeur();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_P){
								//System.out.println("Big Brother");
								Actions.action_control();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_S){
								//System.out.println("Surprise Motherfucker !");
								Actions.action_suicide();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_M && Contexte.btn_sup){
								//System.out.println("Action supp");
								Actions.action_supp();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_BACK_SPACE){
								Contexte.init_contexte();
							}else if(ke.getID() == KeyEvent.KEY_PRESSED && ke.getKeyCode()==KeyEvent.VK_ESCAPE){
								Contexte.initContexte = false;
								Contexte.jeu.dispose();
							}
						}
					}
				}, AWTEvent.KEY_EVENT_MASK);

		build(hight,width,title);
	}



	/**
	 * Initilialisation de l'ensemble des champs de la fenetre.
	 * @param height largeur fenetre
	 * @param width hauteur fenetre
	 * @param title titre fenetre
	 */
	private void build(int height, int width, String title)
	{
		setSize(width,height);
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// positionement centre sur l'ecran au lancement
		setLocationRelativeTo(null);
		// soecif icon
		java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("./img/lem_ico.png");
		setIconImage(image);

		// dimensions fenetre de jeu
		int widthmenu = 120;
		int hauteurmenu = 120;
		int hauteurinfo=30;
		int heightwin = height-hauteurmenu-hauteurinfo;


		// dimension grille map ( bloc  = 10x10 px)
		int heightMap = heightwin/10;
		int widthMap = width/10;
		Contexte.map = new Map(heightMap,widthMap);

		// init main window
		fenetrePrincipale = new JPanel();
		fenetrePrincipale.setLayout(new BorderLayout());

		//def de la fenetre de jeu
		Contexte.canvas.setSize(width,heightwin);
		Contexte.canvas.setIgnoreRepaint(true);
		Contexte.canvas.setPreferredSize(new Dimension(width,heightwin));

		// instanciation des panels
		fenetreJeu =  new JPanel();
		conteneurJeu = new JPanel();
		conteneurMenu = new JPanel();
		info = new JPanel();
		menu = new JPanel();
		bouton = new JPanel();

		// instanciation des boutons du menu
		boutonMenu = new JButton("Menu");
		boutonReset = new JButton("Reset");
		boutonQuitter = new JButton("Quitter");
		boutonPause = new JButton("Pause");
		boutonReprendre = new JButton("Reprendre");
		//config container gauche
		conteneurJeu.setLayout(new BoxLayout(conteneurJeu,BoxLayout.PAGE_AXIS));
		conteneurJeu.setSize(width,height);

		//config panel "game" ( haut, gauche )
		fenetreJeu.setLayout(new BoxLayout(fenetreJeu,BoxLayout.LINE_AXIS));
		fenetreJeu.add(Contexte.canvas);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(0, 0, width, heightwin);
		fenetreJeu.add(scrollpane);
		scrollpane.setViewportView(Contexte.canvas);




		// config panel btn ( bas, gauche )
		bouton.setLayout(new BoxLayout(bouton,BoxLayout.LINE_AXIS));
		bouton.setSize(Contexte.canvas.getWidth()-widthmenu, hauteurmenu);
		bouton.setPreferredSize(new Dimension(Contexte.canvas.getWidth()-widthmenu, hauteurmenu));


		/*
		 * Def des bouton au panel bouton
		 */
		labelBombe = new JLabel(""+Contexte.nbBombe);		
		boutonBombe = new JButton(Contexte.imageBombe);
		panelBombe = new JPanel();
		panelBombe.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelBombe.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonBombe.setSize(panelBombe.getWidth(), panelBombe.getHeight()-30);
		boutonBombe.setPreferredSize(new Dimension(panelBombe.getWidth(),panelBombe.getHeight()-30));
		boutonBombe.setBackground(new Color(158,211,255));
		boutonBombe.addActionListener(new BoutonBombe());
		panelBombe.add(labelBombe);
		panelBombe.add(boutonBombe);

		labelPioche = new JLabel(""+Contexte.nbPioche);		
		boutonPioche = new JButton(Contexte.imagePiocheD);
		panelPioche = new JPanel();
		panelPioche.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelPioche.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonPioche.setSize(panelPioche.getWidth(), panelPioche.getHeight()-30);
		boutonPioche.setPreferredSize(new Dimension(panelPioche.getWidth(),panelPioche.getHeight()-30));
		boutonPioche.addActionListener(new BoutonPioche());
		boutonPioche.setBackground(new Color(158,211,255));;
		panelPioche.add(labelPioche);
		panelPioche.add(boutonPioche);

		labelGrimpe = new JLabel(""+Contexte.nbGrimpe);		
		boutonGrimpe = new JButton(Contexte.imageGrimpeD);
		panelGrimpe = new JPanel();
		panelGrimpe.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelGrimpe.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonGrimpe.setSize(panelGrimpe.getWidth(), panelGrimpe.getHeight()-30);
		boutonGrimpe.setPreferredSize(new Dimension(panelGrimpe.getWidth(),panelGrimpe.getHeight()-30));
		boutonGrimpe.addActionListener(new BoutonGrimpe());
		boutonGrimpe.setBackground(new Color(158,211,255));
		panelGrimpe.add(labelGrimpe);
		panelGrimpe.add(boutonGrimpe);

		labelHorizon = new JLabel(""+Contexte.nbHorizon);		
		boutonHorizon = new JButton(Contexte.imageHorizonD);
		panelHorizon = new JPanel();
		panelHorizon.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelHorizon.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonHorizon.setSize(panelHorizon.getWidth(), panelHorizon.getHeight()-30);
		boutonHorizon.setPreferredSize(new Dimension(panelHorizon.getWidth(),panelHorizon.getHeight()-30));
		boutonHorizon.addActionListener(new BoutonHorizon());
		boutonHorizon.setBackground(new Color(158,211,255));
		panelHorizon.add(labelHorizon);
		panelHorizon.add(boutonHorizon);

		labelVerti = new JLabel(""+Contexte.nbVerti);		
		boutonVerti = new JButton(Contexte.imageVerti);
		panelVerti = new JPanel();
		panelVerti.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelVerti.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonVerti.setSize(panelVerti.getWidth(), panelVerti.getHeight()-30);
		boutonVerti.setPreferredSize(new Dimension(panelVerti.getWidth(),panelVerti.getHeight()-30));
		boutonVerti.addActionListener(new BoutonVerti());
		boutonVerti.setBackground(new Color(158,211,255));
		panelVerti.add(labelVerti);
		panelVerti.add(boutonVerti);

		labelParapluie = new JLabel(""+Contexte.nbParapluie);		
		boutonParapluie = new JButton(Contexte.imageParapluie);
		panelParapluie = new JPanel();
		panelParapluie.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelParapluie.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonParapluie.setSize(panelParapluie.getWidth(), panelParapluie.getHeight()-30);
		boutonParapluie.setPreferredSize(new Dimension(panelParapluie.getWidth(),panelParapluie.getHeight()-30));
		boutonParapluie.addActionListener(new BoutonParapluie());
		boutonParapluie.setBackground(new Color(158,211,255));
		panelParapluie.add(labelParapluie);
		panelParapluie.add(boutonParapluie);

		labelLuciole = new JLabel(""+Contexte.nbLuciole);		
		boutonLuciole = new JButton(Contexte.imageLuciole);
		panelLuciole = new JPanel();
		panelLuciole.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelLuciole.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonLuciole.setSize(panelLuciole.getWidth(), panelLuciole.getHeight()-30);
		boutonLuciole.setPreferredSize(new Dimension(panelLuciole.getWidth(),panelLuciole.getHeight()-30));
		boutonLuciole.addActionListener(new BoutonLuciole());
		boutonLuciole.setBackground(new Color(158,211,255));
		panelLuciole.add(labelLuciole);
		panelLuciole.add(boutonLuciole);
		
		// SUICIDE
		panelsuicide = new JPanel();
		labelsuicide = new JLabel(" ");
		panelsuicide.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelsuicide.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonsuicide = new JButton(Contexte.mort);
		boutonsuicide.setSize(panelsuicide.getWidth(), panelsuicide.getHeight()-30);
		boutonsuicide.setPreferredSize(new Dimension(panelsuicide.getWidth(),panelsuicide.getHeight()-30));
		boutonsuicide.addActionListener(new BoutonSuicide());
		boutonsuicide.setBackground(new Color(158,211,255));
		panelsuicide.add(labelsuicide);
		panelsuicide.add(boutonsuicide);
		

		labelBloque = new JLabel(""+Contexte.nbBloque);		
		boutonBloque = new JButton(Contexte.imageBloque);
		panelBloque = new JPanel();
		panelBloque.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelBloque.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonBloque.setSize(panelBloque.getWidth(), panelBloque.getHeight()-30);
		boutonBloque.setPreferredSize(new Dimension(panelBloque.getWidth(),panelBloque.getHeight()-30));
		boutonBloque.addActionListener(new BoutonBLoque());
		boutonBloque.setBackground(new Color(158,211,255));
		panelBloque.add(labelBloque);
		panelBloque.add(boutonBloque);

		labelConstructeur = new JLabel(""+Contexte.nbConstructeur);		
		boutonConstructeur = new JButton(Contexte.imageConstructeurD);
		panelConstructeur = new JPanel();
		panelConstructeur.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelConstructeur.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonConstructeur.setSize(panelConstructeur.getWidth(), panelConstructeur.getHeight()-30);
		boutonConstructeur.setPreferredSize(new Dimension(panelConstructeur.getWidth(),panelConstructeur.getHeight()-30));
		boutonConstructeur.addActionListener(new BoutonConstructeur());
		boutonConstructeur.setBackground(new Color(158,211,255));
		panelConstructeur.add(labelConstructeur);
		panelConstructeur.add(boutonConstructeur);

		labelControl = new JLabel(""+Contexte.nbControl);		
		boutonControl = new JButton("<html>CTRL<br>OFF</html>");

		panelControl = new JPanel();

		panelControl.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelControl.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonControl.setSize(panelConstructeur.getWidth(), panelConstructeur.getHeight()-30);
		boutonControl.setPreferredSize(new Dimension(panelConstructeur.getWidth(),panelConstructeur.getHeight()-30));
		boutonControl.addActionListener(new BoutonControl());
		boutonControl.setBackground(new Color(158,211,255));
		panelControl.add(labelControl);
		panelControl.add(boutonControl);

		//Bouton supplementaire, reserver pour le joueur, non visible par default
		labelSupp = new JLabel(""+Contexte.nbSupp);		
		boutonSupp = new JButton("@Def");
		panelSupp = new JPanel();
		panelSupp.setPreferredSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		panelSupp.setSize(new Dimension(bouton.getWidth()/Contexte.nbBouton, bouton.getHeight()));
		boutonSupp.setSize(panelSupp.getWidth(), panelSupp.getHeight()-30);
		boutonSupp.setPreferredSize(new Dimension(panelSupp.getWidth(),panelSupp.getHeight()-30));
		boutonSupp.addActionListener(new BoutonSupp());
		boutonSupp.setBackground(new Color(158,211,255));
		boutonSupp.setEnabled(false);
		panelSupp.add(labelSupp);
		panelSupp.add(boutonSupp);

		panelSupp.setVisible(Contexte.btn_sup);


		//ajout des panels au panel bouton
		bouton.add(panelBloque);
		bouton.add(panelBombe);
		bouton.add(panelGrimpe);
		bouton.add(panelHorizon);
		bouton.add(panelLuciole);
		bouton.add(panelParapluie);
		bouton.add(panelPioche);
		bouton.add(panelVerti);
		bouton.add(panelConstructeur);
		bouton.add(panelControl);
		bouton.add(panelsuicide);
		bouton.add(panelSupp);
		



		//config container droit
		conteneurMenu.setLayout(new BoxLayout(conteneurMenu, BoxLayout.LINE_AXIS));
		conteneurMenu.setSize(new Dimension(width,hauteurmenu));

		// config panel menu ( bas, droite )
		menu.setLayout(new GridLayout(5,1));
		menu.setSize(width-bouton.getWidth(),bouton.getHeight());
		menu.setPreferredSize(new Dimension(width-bouton.getWidth(),bouton.getHeight()));


		// config panel info ( haut, droite )
		info.setSize(new Dimension(width,hauteurinfo));
		info.setPreferredSize(new Dimension(width,hauteurinfo));
		info.setLayout(new BoxLayout(info, BoxLayout.LINE_AXIS));




		//Ajout des listener de bouton du menu
		actionQuit = new BoutonListenerQuit();
		actionReset = new BoutonReset();
		actionMenu = new BoutonListenerMenu();
		actionPR = new BoutonListenerPauseResume(boutonPause, boutonReprendre);
		boutonQuitter.addActionListener(actionQuit);
		boutonMenu.addActionListener(actionMenu);
		boutonReset.addActionListener(actionReset);
		boutonPause.addActionListener(actionPR);
		boutonReprendre.addActionListener(actionPR);

		
		//bouton reprendre disabled
		boutonReprendre.setEnabled(false);

		//ajout des boutons au panel de menu
		menu.add(boutonMenu);
		menu.add(boutonReset);
		menu.add(boutonPause);
		menu.add(boutonReprendre);
		menu.add(boutonQuitter);

		//ajout aux jpanel conteneurs
		conteneurJeu.add(info);
		conteneurJeu.add(fenetreJeu);	
		conteneurMenu.add(bouton);
		conteneurMenu.add(menu);		

		//Ajout des labels et panel au panel info
		conteneurTime = new JPanel();
		conteneurOut = new JPanel();
		conteneurHome = new JPanel();
		conteneurObjectifs = new JPanel();
		conteneurDead = new JPanel();

		// Init Timer.
		info.add(conteneurTime);
		conteneurTime.add(labelTime);
		minutes.setText(String.format("%02d",Contexte.canvas.get_min()));
		conteneurTime.add(minutes);
		conteneurTime.add(sep_time);
		secondes.setText(String.format("%02d",Contexte.canvas.get_sec()));
		conteneurTime.add(secondes);

		// Init compteur lemmings vivants
		info.add(conteneurOut);
		conteneurOut.add(labelOut);
		valeur_out.setText(String.format("%02d",Contexte.alive));
		conteneurOut.add(valeur_out);

		// init compteur lemmings dead
		info.add(conteneurDead);
		conteneurDead.add(labeldead);
		valeur_dead.setText(String.format("%02d",Contexte.dead));
		conteneurDead.add(valeur_dead);

		//init compteur lemmings ayant atteinds la sortie

		info.add(conteneurHome);
		conteneurHome.add(labelHome);
		valeur_home.setText(String.format("%02d",Contexte.nbSave));
		conteneurHome.add(valeur_home);
		ratio_home.setText( " ~~ " + String.format("%03d",Contexte.ratio_home) + "%");
		conteneurHome.add(ratio_home);


		// init des objectifs du lvl
		info.add(conteneurObjectifs);
		conteneurObjectifs.add(labelObjectif);  
		//valeur_obj.setText(String.format("%03d",Contexte.obj) + " %");
		conteneurObjectifs.add(valeur_obj);


		//ajout des bouton pour moduler le temps
		panelFastSlow = new JPanel();
		panelFastSlow.setLayout(new GridLayout());
		panelFastSlow.setSize(30, hauteurmenu);
		panelFastSlow.setPreferredSize(new Dimension(30, hauteurmenu));
		boutonFast = new JButton(Contexte.imageFast);
		boutonFast.setSize(10, hauteurmenu/2);
		boutonFast.setPreferredSize(new Dimension(10,hauteurmenu/2));
		boutonFast.setBorder(BorderFactory.createEmptyBorder());
		boutonFast.setBackground(Color.decode("#eeeeee"));
		boutonFast.addActionListener(new BoutonFast());

		labelVitesseJeu = new JLabel();
		labelVitesseJeu.setText(""+Contexte.UPDATE_AFFICHAGE);

		boutonSlow = new JButton(Contexte.imageSlow);
		boutonSlow.setSize(10, hauteurmenu/2);
		boutonSlow.setBorder(BorderFactory.createEmptyBorder());
		boutonSlow.setPreferredSize(new Dimension(10,hauteurmenu/2));
		boutonSlow.setBackground(Color.decode("#eeeeee"));
		boutonSlow.addActionListener(new BoutonSlow());
		info.add(panelFastSlow);
		panelFastSlow.add(boutonSlow);
		panelFastSlow.add(labelVitesseJeu);
		panelFastSlow.add(boutonFast);

		//Add au panel principal
		fenetrePrincipale.add(conteneurJeu, BorderLayout.CENTER);
		fenetrePrincipale.add(conteneurMenu, BorderLayout.SOUTH);

		//indique qu'il y a un panel a afficher
		setContentPane(fenetrePrincipale);

		pack();

	}

	/**
	 * Mise a jour timer minute & sec.
	 */
	public void update_time(){
		Contexte.jeu.secondes.setText(String.format("%02d",Contexte.canvas.get_sec()));
		Contexte.jeu.minutes.setText(String.format("%02d", Contexte.canvas.get_min()));
		
		
		
	}

	/**
	 * Update des diffents compteurs de competances.
	 */
	public void update_compteurs_type()
	{
		Contexte.UPDATE_AFFICHAGE = -(Contexte.UPDATE_PERIOD/5) + 8;


		labelGrimpe.setText(""+Contexte.nbGrimpe);
		labelBloque.setText(""+Contexte.nbBloque);
		labelBombe.setText(""+Contexte.nbBombe);
		labelConstructeur.setText(""+Contexte.nbConstructeur);
		labelHorizon.setText(""+Contexte.nbHorizon);
		labelLuciole.setText(""+Contexte.nbLuciole);
		labelParapluie.setText(""+Contexte.nbParapluie);
		labelPioche.setText(""+Contexte.nbPioche);
		labelVerti.setText(""+Contexte.nbVerti);
		labelVitesseJeu.setText("     "+Contexte.UPDATE_AFFICHAGE);
		labelControl.setText(""+Contexte.nbControl);
		labelSupp.setText(""+Contexte.nbSupp);

		//Gestion evenementiel des bouton de vitesse du jeu
		if(Contexte.UPDATE_PERIOD <= 0 )
		{
			boutonFast.setEnabled(false);
		}
		else{
			boutonFast.setEnabled(true);
		}
		if(Contexte.UPDATE_PERIOD >= 60)
		{
			boutonSlow.setEnabled(false);
		}
		else
		{
			boutonSlow.setEnabled(true);
		}
	}


	/**
	 * Selection d'un lemmings dans l'espace de jeu, avec association d'un automate en fonction de l'etat
	 * des boutons
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// bool pour marquer qu'on a croise un lemming corespondant au coord dans le tableau.
		boolean vulem = false;
		int i = 0;

		// recup pos clic ( attention inversion des axes... )
		double y_clic = arg0.getX();
		double x_clic = arg0.getY();
		double x_lem;
		double y_lem;

		for(i=0;i<Contexte.nbLemmings;i++){
			// on traite que les vivants, si on en a pas d�j� crois� un corepondant
			if(Contexte.tabLemmings[i].isVivant() && vulem==false){

				// recup coords du lemmings courant. rmq : -30 sur x, pour choper sa base. lem = 20 x 30 ...
				x_lem = Contexte.tabLemmings[i].getCoord_x()-30;
				y_lem = Contexte.tabLemmings[i].getCoord_y();

				// on verifie si le clic n'est aps dans la surface du lemming.
				if(y_clic>=y_lem && y_clic <= y_lem+20 && x_clic>=x_lem & x_clic <= x_lem+30){

					// Si parapluie enclenche
					if(Contexte.valParapluie && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateH(Contexte.automate_parapluie);
						Contexte.nbParapluie--;
						if(Contexte.nbParapluie==0){
							Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
							Contexte.jeu.get_parapluie().setEnabled(false);
							Contexte.valParapluie=false;
						}
						// Si creuseur horizontal enclenche
					}else if(Contexte.valHorizon && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_creuseurH);
						Contexte.nbHorizon--;
						if(Contexte.nbHorizon==0){
							Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
							Contexte.jeu.get_horizon().setEnabled(false);
							Contexte.valHorizon=false;
						}
						// si grimpeur enclenche
					}else if(Contexte.valGrimpe && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateH(Contexte.automate_grimpeur);
						Contexte.nbGrimpe--;
						if(Contexte.nbGrimpe==0){
							Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
							Contexte.jeu.get_grimp().setEnabled(false);
							Contexte.valGrimpe=false;
						}
						// si creuseur vertical enclenche
						// rmq : automate non hereditaire
					} if(Contexte.valVerti && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_creuserV);
						Contexte.nbVerti--;
						if(Contexte.nbVerti==0){
							Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
							Contexte.jeu.get_verti().setEnabled(false);
							Contexte.valVerti=false;
						}
						// si luciole enclenche.
						// rmq : pas d'automate, juste un boolean qui est set.
					}else if(Contexte.valLuciole ){
						Contexte.tabLemmings[i].setLuciolle(true);
						Contexte.nbLuciole--;
						if(Contexte.nbLuciole==0){
							Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
							Contexte.jeu.get_luciole().setEnabled(false);
							Contexte.valLuciole=false;
						}
						// si bombe enclenche
						// rmq : pas d'automate, juste un boolean qui est set.
					}else if(Contexte.valBombe && !Contexte.valsuicide){
						Contexte.tabLemmings[i].setBombe(true);
						Contexte.nbBombe--;
						if(Contexte.nbBombe==0){
							Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
							Contexte.jeu.get_bombe().setEnabled(false);
							Contexte.valBombe=false;
						}
						// si bloqueur enclenche
					}else if(Contexte.valBloque){
						// s'enclenche que si l'action courante est marcher..
						if(Contexte.tabLemmings[i].getActionL().compareTo("marcher") == 0){
							Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_bloqueur);			
							Contexte.nbBloque--;
							if(Contexte.nbBloque==0){
								Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
								Contexte.jeu.get_bloque().setEnabled(false);
								Contexte.valBloque=false;
							}
						}
						// si piocheur enclenche
					}else if(Contexte.valPioche && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_creuserD);			
						Contexte.nbPioche--;
						if(Contexte.nbPioche==0){
							Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
							Contexte.jeu.get_pioche().setEnabled(false);
							Contexte.valPioche=false;
						}
						// si bonton controleur
					}else if(Contexte.valControl){	
						Contexte.indice_lem_selected=i;

					}else if(Contexte.valConstructeur && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur){
						Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_escalier);			
						Contexte.nbConstructeur--;
						Contexte.tabLemmings[i].getSens();
						if(Contexte.nbConstructeur==0){
							Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
							Contexte.jeu.get_constructeur().setEnabled(false);
							Contexte.valConstructeur=false;
						}
					}else if(Contexte.valSupp && Contexte.tabLemmings[i].getAutomate_current()!=Contexte.automate_bloqueur)
					{
						Contexte.tabLemmings[i].setAutomateNonH(Contexte.automate_supp);
						Contexte.nbSupp--;
						if(Contexte.nbSupp == 0)
						{
							Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
							Contexte.jeu.get_supp().setEnabled(false);
							Contexte.valSupp = false;
						}
					}


					vulem=true;
				}
			}
		}
	}

	/**
	 * Overrides MouseEvent...
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	/**
	 * getter btn bloque
	 * @return jpanel bloque
	 */
	public JButton get_bloque(){
		return this.boutonBloque;
	}

	/**
	 * getter btn bombe
	 * @return jpanel bombe
	 */
	public JButton get_bombe(){
		return this.boutonBombe;
	}

	/**
	 * getter btn constructeur
	 * @return jpanel constru
	 */
	public JButton get_constructeur(){
		return this.boutonConstructeur;
	}

	/**
	 * getter gbtn grimpeur
	 * @return jpanel grimp
	 */
	public JButton get_grimp(){
		return this.boutonGrimpe;
	}

	/**
	 * getter btn creus horizontal
	 * @return jpanel horiz
	 */
	public JButton get_horizon(){
		return this.boutonHorizon;
	}

	/**
	 * getter btn luciole
	 * @return jpanel luciole
	 */
	public JButton get_luciole(){
		return this.boutonLuciole;
	}

	/**
	 * getter btn parapluie
	 * @return JPanel parap
	 */
	public JButton get_parapluie(){
		return this.boutonParapluie;
	}

	/**
	 * getter btn pioche
	 * @return JLabel pioche
	 */
	public JButton get_pioche(){
		return this.boutonPioche;
	}

	/**
	 * getter btn creus vertical
	 * @return JPanel verti
	 */
	public JButton get_verti(){
		return this.boutonVerti;
	}

	/**
	 * getter objectif level
	 * @return JLabel obj
	 */
	public JLabel get_obj(){
		return this.valeur_obj;
	}

	public JButton get_control(){
		return this.boutonControl;
	}

	/**
	 * getter ratio lemmings saved / lemmings tot.
	 * @return JLabel ratio
	 */
	public JLabel get_ratio(){
		return this.ratio_home;
	}

	public JButton get_supp()
	{
		return this.boutonSupp;
	}


	public JButton get_reprendre()
	{
		return this.boutonReprendre;
	}
	public JButton get_pause()
	{
		return this.boutonPause;
	}
	
	public JButton get_suicide(){
		return this.boutonsuicide;
	}
	

}
