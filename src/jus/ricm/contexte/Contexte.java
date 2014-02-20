package jus.ricm.contexte;


import java.awt.Color;
import java.util.ArrayList;

import jus.ricm.automate.*;
import jus.ricm.graphique.*;
import jus.ricm.lemmings.Lemmings;
import jus.ricm.ordonnanceur.Ordonnanceur;
import jus.ricm.sound.Sound;
import jus.ricm.sound.WavPlayer;

import javax.swing.ImageIcon;

/**
 * Classe qui contien l'ensemble des variables necessaires aux fonctions
 * principales du programme.
 *
 */
public class Contexte {
	
	public static String nomFich;
	
	public static ArrayList<Integer>  listeLemmings = new ArrayList<Integer>();
	public static int indexLemmings = 0;
	
	public static int indexBouton = 1;
	//temps de rafraicgissement de l'ordonnanceur
	public static int UPDATE_PERIOD = 40;
	public static int UPDATE_AFFICHAGE = UPDATE_PERIOD - 40;
	
	//Nombre de bouton, par defaut 10
	public static int nbBouton = 12;
	
	// Valeur initial du temps
	static public long init;
	
	// valeur courante
	static public long time;
	
	//varaible de pause
	public static boolean pause;
	// jframe de jeu
	static public FenetreJeu jeu;
	
	//JFrame du menu principale
	public static Menu start_menu;
	public static Menu option_menu;
	
	//matrice de bloc
	static public Map map;

	// nombre max de lemmings gen


	static public int n_max;
	
	//5minute avant defaite
	static public int tempsMax;

	
	//active ou desactive le thread de jeu

	public static boolean runnable = true;
	
	//coupe le son
	public static boolean mute = true;
	
	// nombre lemmings actif ( dead or alive )
	static public int nbLemmings;
	
	// objectifs lvl.
	static public int obj;
	
	static public boolean initContexte = false;
	
	static public int ratio_home;
	
	// nb lem dead
	static public int dead;
	
	// nb lem alive
	static public int alive;
	
	//tableau de lemmings nb max = 50
	static public Lemmings [] tabLemmings;
	
	//nombre de lemmings arrive a l'arrivee
	public static int nbSave ;
	
	//Coordonees du spawn
	static public int spawnX1;
	static public int spawnY1;
	static public int spawnX2;
	static public int spawnY2;
	
	static public int sortieX;
	static public int sortieY;

	// dim canvas
	static public int widthCanvas;
	static public int heightCanvas;
	
	//Nom du fichier xml a parser
	public static String fichierxml = null;
	
	//Definition des differents automates
	static public Automate automate_base;
	static public Automate automate_parapluie;
	static public Automate automate_grimpeur;
	static public Automate automate_bloqueur;
	static public Automate automate_creuseurH;
	static public Automate automate_creuserV;
	static public Automate automate_creuserD;
	static public Automate automate_escalier;
	static public Automate automate_supp;
	
	//le canvas de dessin
	static public map_canvas canvas;
	
	//Ordonnanceur de jeu
	public static Ordonnanceur ordo;
	
	public static int pos_night = 1280;
	
	/*
	 * Variables a changer quand on effectue un clique sur un lemmings.
	 * Compteur des boutons
	 */
	public static int nbBombe;
	public static int nbGrimpe;
	public static int nbParapluie;
	public static int nbHorizon;
	public static int nbVerti;
	public static int nbLuciole;
	public static int nbPioche;
	public static int nbBloque;
	public static int nbConstructeur;
	public static int nbControl;
	public static int nbSupp;
	
	
	//Permet de savoir quel bouton est arme
	public static boolean valGrimpe;
	public static boolean valPioche;
	public static boolean valHorizon;
	public static boolean valVerti;
	public static boolean valLuciole;
	public static boolean valBloque;
	public static boolean valBombe;
	public static boolean valParapluie;
	public static boolean valConstructeur;
	public static boolean valControl;
	public static boolean valsuicide;
	public static boolean valSupp;
	
	// bouton supp existant ?
	public static boolean btn_sup;// = false;
	
	public static int indice_lem_selected;
	public static int indice_lem_selected_pred=n_max+1;
	public static boolean last =false;
	
	
	//image de jeu
	public static final ImageIcon imageGrimpeD = new ImageIcon("./img/grimpe_d.png");
	public static final ImageIcon imageGrimpeG = new ImageIcon("./img/grimpe_g.png");
	public static final ImageIcon imagePiocheD = new ImageIcon("./img/pioche_d.png");
	public static final ImageIcon imagePiocheG = new ImageIcon("./img/pioche_g.png");
	public static final ImageIcon imageHorizonD = new ImageIcon("./img/horizon_d.png");
	public static final ImageIcon imageHorizonG = new ImageIcon("./img/horizon_g.png");
	public static final ImageIcon imageVerti = new ImageIcon("./img/verti.png");
	public static final ImageIcon imageBombe = new ImageIcon("./img/bombe.png");
	public static final ImageIcon imageParapluie = new ImageIcon("./img/parapluie.png");
	public static final ImageIcon imageBloque= new ImageIcon("./img/bloque.png");
	public static final ImageIcon imageConstructeurG = new ImageIcon("./img/constructeur_g.png");
	public static final ImageIcon imageConstructeurD = new ImageIcon("./img/constructeur_d.png");
	public static final ImageIcon imageLuciole = new ImageIcon("./img/luciole.png");
	public static final ImageIcon imagenormal = new ImageIcon("./img/normal.png");
	public static final ImageIcon imageFast = new ImageIcon("./img/avanceRapide.png");
	public static final ImageIcon imageSlow = new ImageIcon("./img/avanceArriere.png");
	public static final ImageIcon night = new ImageIcon("./img/night.png");
	
	//Image du decors, temporaire
	public static final ImageIcon escalier = new ImageIcon("./img/escalier.png");
	public static final ImageIcon earth = new ImageIcon("./img/earth.png");
	public static final ImageIcon water = new ImageIcon("./img/water.png");
	public static final ImageIcon obs_non_destru = new ImageIcon("./img/bloc_indestructible.png");
	public static final ImageIcon obstacle_creus = new ImageIcon("./img/obstacle_creus.png");
	public static final ImageIcon spawn_img = new ImageIcon("./img/spawn.png");
	public static final ImageIcon sortie_img = new ImageIcon("./img/out.png");
	public static final ImageIcon transp = new ImageIcon("./img/transp.png");
	
	
	// img decompte bomb.
	public static final ImageIcon d_5 = new ImageIcon("./img/5.png");
	public static final ImageIcon d_4 = new ImageIcon("./img/4.png");
	public static final ImageIcon d_3 = new ImageIcon("./img/3.png");
	public static final ImageIcon d_2 = new ImageIcon("./img/2.png");
	public static final ImageIcon d_1 = new ImageIcon("./img/1.png");
	public static final ImageIcon mort = new ImageIcon("./img/mort.png");
	
	//Images du menu
	public static final ImageIcon play0 = new ImageIcon("./img/play0.png");
	public static final ImageIcon credit0 = new ImageIcon("./img/credits0.png");
	public static final ImageIcon option0 = new ImageIcon("./img/options0.png");
	public static final ImageIcon quit0 = new ImageIcon("./img/qui0.png");
	
	//L'ensemble des players pour jouer les sons du jeux
	public static WavPlayer musicMenu = new WavPlayer("./music/Game-of-Thrones-8-b.wav");
	
	//Thread pour chaque player
	public static 	Thread t = new Thread(Contexte.musicMenu);
	
	//Recuperation du flux audio et déclaration du clip
	public static Sound son = new Sound("./music/mort.wav");
	public static Sound arrivee = new Sound("./music/arrivee.wav");
	public static Sound victoire = new Sound("./music/victoire.wav");
	public static Sound eau = new Sound("./music/eau.wav");
	public static Sound drill = new Sound("./music/creuser.wav");
	public static Sound bombe = new Sound("./music/bombe.wav");
	public static Sound bloqueur = new Sound("./music/bloqueurvf.wav");
	/**
	 * Permet de faire l'initialisation du contexte, prend en parametre les coordonees du spawn,
	 * le nombre maximal de lemmings et le nombre de bouton
	 */
	public static void init_contexte()
	{
		
		UPDATE_PERIOD = 40;
		UPDATE_AFFICHAGE = UPDATE_PERIOD - 40;
		
		valGrimpe = false;
		valPioche = false;
		valHorizon = false;
		valVerti = false;
		valLuciole = false;
		valBloque = false;
		valBombe = false;
		valParapluie = false;
		valConstructeur = false;
		valControl = false;
		valSupp = false;
		valsuicide = false;
		jeu.get_pause().setEnabled(true);
		jeu.get_reprendre().setEnabled(false);
		
		
		pos_night = 1280;
		init = System.currentTimeMillis(); 
		initContexte = true;
		nbSave = 0;
		alive =0;
		dead = 0;
		ratio_home =0;
		nbLemmings =0;
		pause = false;
		//tabLemmings = new Lemmings[n_max];
		/*
		// INIT CPTR COMPETENCES
		Contexte.nbBombe = Contexte.n_max;
		Contexte.nbGrimpe = Contexte.n_max;
		Contexte.nbParapluie = Contexte.n_max;
		Contexte.nbHorizon = Contexte.n_max;
		Contexte.nbVerti = Contexte.n_max;
		Contexte.nbLuciole =Contexte.n_max/4;
		Contexte.nbPioche = Contexte.n_max;
		Contexte.nbBloque = Contexte.n_max;
		Contexte.nbConstructeur = Contexte.n_max;
		Contexte.nbControl = Contexte.n_max/4;
		Contexte.nbSupp = Contexte.n_max;
		*/
		
		
		//Re-init des boutons
		jeu.get_bloque().setEnabled(true);
		jeu.get_bombe().setEnabled(true);
		jeu.get_constructeur().setEnabled(true);
		jeu.get_control().setEnabled(true);
		jeu.get_grimp().setEnabled(true);
		jeu.get_horizon().setEnabled(true);
		jeu.get_luciole().setEnabled(true);
		jeu.get_parapluie().setEnabled(true);
		jeu.get_pioche().setEnabled(true);
		jeu.get_supp().setEnabled(false);
		jeu.get_verti().setEnabled(true);
		
		Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
		Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
		Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
		Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
		Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
		Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
		Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
		Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
		Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
		Contexte.jeu.get_control().setBackground(new Color(158,211,255));
		Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
		Contexte.jeu.get_supp().setBackground(new Color(158,211,255));

		Contexte.map.init_map();
		//Contexte.map.gen_full_map();
		
		Contexte.jeu.panelSupp.setVisible(Contexte.btn_sup);
		
		runnable = true;
	}
	
}
