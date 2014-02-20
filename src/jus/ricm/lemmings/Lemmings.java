package jus.ricm.lemmings;

import java.util.ArrayList;

import jus.ricm.automate.*;
import jus.ricm.contexte.Contexte;
import jus.ricm.sound.Sound;


/**
 * @author Rodolphe
 * Class Lemmings
 */
public class Lemmings {


	// Definition des attribut
	protected Automate automate_default = null;
	protected Automate automate_current = null;
	protected boolean luciolle = false;		// precise si le lemming peut grimer aux murs	
	protected int cpt_bombe = 0;			// compteur pour explosion
	protected boolean bombe = false;		// precise si le lemming est une bombe ou non
	protected int coord_x;					// coordonne du bloc en int en x
	protected int coord_y;					// coordonne du bloc en int en y
	protected int sens = 1;					// le sens de deplacement (gauche ou droite)
	protected int profondeur = 0; 			// ce champ servira pour les calculs de chute
	protected String vie = "vivant";		// le lemming est-il vivant?
	protected int etatcourant = 0;			// etat courant du lemming dans son automate
	protected int cptC = 1;					// Compteur pour les cycles pour creuser
	protected int cptE = 1;					// Compteur pour les cycles pour les escaliers
	protected String actionL;
	protected int nbrActionE = 0;
	protected int idLem;

	public int getIdLem() {
		return idLem;
	}

	public void setIdLem(int idLem) {
		this.idLem = idLem;
	}

	/**
	 * Constructeur vide pour le parser
	 */
	public Lemmings(){
	}

	/**
	 * Constructeur pour initialiser un lemmings
	 * avec ses coordonnees en pixels
	 * @param x un int
	 * @param y un int
	 */
	public Lemmings(int x, int y){
		this.coord_x = x;
		this.coord_y = y;
		this.automate_current = Contexte.automate_base;
		this.automate_default = Contexte.automate_base;

	}
	/**
	 * Methode pour recuperer l'automate par defaut
	 * @return un Automate
	 */
	public Automate getAutomate_default() {
		return automate_default;
	}
	/**
	 * Methode pour definir l'automate par defaut
	 * @param automate_default un Automate
	 */
	public void setAutomate_default(Automate automate_default) {
		this.automate_default = automate_default;
	}
	/**
	 * Methode pour recuperer l'automate courant
	 * @return un Automate
	 */
	public Automate getAutomate_current() {
		return automate_current;
	}
	/**
	 * Methode pour definir l'automate courant
	 * @param automate_current un Automate
	 */
	public void setAutomate_current(Automate automate_current) {
		this.automate_current = automate_current;
	}
	/**
	 * Methode pour savoir si un lemmings brille dans la nuit
	 * @return un boolean
	 */
	public boolean isLuciolle() {
		return luciolle;
	}
	/**
	 * Methode pour rendre un Lemmings fluorescent
	 * @param luciolle un boolean
	 */
	public void setLuciolle(boolean luciolle) {
		this.luciolle = luciolle;
	}
	/**
	 * Getter boolean bomb
	 * @return boolean bombe
	 */
	public boolean get_bombe(){
		return this.bombe;
	}
	/**
	 * Methode pour recuperer le compteur avant explosion
	 * @return un int
	 */
	public int getCpt_bombe() {
		return cpt_bombe;
	}
	/**
	 * Methode pour definir la valeur du compteur avant explosion
	 * @param cpt_bombe un int
	 */
	public void setCpt_bombe(int cpt_bombe) {
		this.cpt_bombe = cpt_bombe;
	}
	/**
	 * Methode pour savoir si un lemmings va exploser
	 * @return un boolean
	 */
	public boolean isBombe() {
		return bombe;
	}
	/**
	 * Methode pour demander l'explosion d'un lemmings
	 * @param bombe un boolean
	 */
	public void setBombe(boolean bombe) {
		this.bombe = bombe;
	}
	/**
	 * Methode pour recuperer la coordonnee X en pixel du Lemmings
	 * @return un int
	 */
	public int getCoord_x() {
		return coord_x;
	}
	/**
	 * Methode pour definir la coordonne X en pixel du Lemmings
	 * @param coord_x un int
	 */
	public void setCoord_x(int coord_x) {
		this.coord_x = coord_x;
	}
	/**
	 * Methode pour recuperer la coordonnee Y en pixel du Lemmings
	 * @return un int
	 */
	public int getCoord_y() {
		return coord_y;
	}
	/**
	 * Methode pour definir la coordonne Y en pixel du Lemmings
	 * @param coord_y un int
	 */
	public void setCoord_y(int coord_y) {
		this.coord_y = coord_y;
	}

	/**
	 * Methode pour recuperer la direction d'un Lemmings
	 * @return un int, 1 signifie gauche, 0 droite
	 */
	public int getSens() {
		return sens;
	}
	/**
	 * Methode pour donner une direction a un Lemmings
	 * @param sens un int, 1 vers la gauche, 0 vers la droite.
	 */
	public void setSens(int sens) {
		this.sens = sens;
	}
	/**
	 * Methode pour connaitre la profondeur de chute d'un lemmings
	 * @return un int
	 */
	public int getProfondeur() {
		return profondeur;
	}
	/**
	 * Methode pour donner la profondeur de chute d'un lemmings
	 * @param profondeur un int
	 */
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	/**
	 * Methode pour connaitre l'etat d'un lemmings (vivant, mort, ou arrive)
	 * @return un String
	 */
	public String getVie() {
		return vie;
	}
	/**
	 * Methode pour donner l'etat d'un lemmings (vivant, mort, ou arrive)
	 * @param vie un String
	 */
	public void setVie(String vie) {
		this.vie = vie;
	}
	/**
	 * Methode pour recuperer l'action courante qu'effectue un lemmings
	 * @return un String
	 */
	public String getActionL() {
		return actionL;
	}
	/**
	 * Methode pour donner la valeur de l'action courante d'un lemmings
	 * @param actionL un String
	 */
	public void setActionL(String actionL) {
		this.actionL = actionL;
	}
	/**
	 * Methode pour recuperer l'indice de l'etat courant dans l'automate que le lemmings utilise
	 * @return un int
	 */
	public int getEtatcourant() {
		return etatcourant;
	}
	/**
	 * Methode pour configurer l'indice de l'etat courant dans l'automate que le lemmings utilise
	 * @param etatcourant un int
	 */
	public void setEtatcourant(int etatcourant) {
		this.etatcourant = etatcourant;
	}


	/**
	 * Methode permettant de savoir si la chute d'un lemmings va etre mortelle ou non
	 * @return un boolean
	 */
	public boolean isMortel(){
		if(this.getProfondeur() >= 90 /**&& this.parapluie == false*/){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode permettant de savoir si un lemmings se trouve au dessus du vide
	 * @return un boolean
	 */
	public boolean isVide(){	
		return (Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getVide() 
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).getVide()
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getVide());
	}

	/**
	 * Methode permettant de savoir si un lemmings se trouve au dessus de l'eau
	 * @return un boolean
	 */
	public boolean isEau(){
		// Premier test pour le bruitage, le lemmings est sur l'eau
		if (Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getEau() 
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).getEau()
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getEau()) {
			if(Contexte.mute) //Si le son n'est pas mute, on fait le bruitage
			{
				Sound sonClonedEau = (Sound) Contexte.eau.cloneObj();
				sonClonedEau.SetFile(Contexte.eau.GetFile());
				sonClonedEau.SetInfo(Contexte.eau.GetInfo());
				sonClonedEau.SetAudioFormat(Contexte.eau.GetAudioFormat());
				sonClonedEau.SetAudiobuffer(Contexte.eau.GetAudiobuffer());
				Thread t_sonClonedEau = new Thread(sonClonedEau);
				t_sonClonedEau.start();
			}
		}
		// Veritable test qui renvoie True si le lemmings est sur de l'eau, False sinon
		return (Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getEau() 
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).getEau()
				&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getEau());
	} 

	/**
	 * Methode permettant de savoir si un lemmings est vivant
	 * @return un boolean
	 */
	public boolean isVivant(){
		if(this.vie.compareTo("vivant") == 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode pour savoir si l'action creuser de maniere horizontale a atteint
	 * son quota limite
	 * @return un boolean
	 */
	public boolean isFinH(){
		/**
		if(this.nbrActionH == 6){
			return true;
		}else{
			return false;
		}
		 */
		if(this.coord_y < Contexte.heightCanvas - 40){
			if(this.sens == 1){
				return Contexte.map.getBloc(this.coord_x, this.coord_y + 31).getVide()
						&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 31).getVide()
						&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 31).getVide();
			}else{
				return Contexte.map.getBloc(this.coord_x, this.coord_y - 11).getVide()
						&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 11).getVide()
						&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 11).getVide();
			}
		}else{
			return false;
		}

	}

	/**
	 * Methode pour savoir si l'action poser l'escalier a atteint
	 * son quota limite
	 * @return un boolean
	 */
	public boolean isFinE(){
		if(this.nbrActionE == 8){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode pour savoir si l'action creuser de maniere verticale a atteint
	 * son quota limite
	 * @return un boolean
	 */
	public boolean isFinV(){
		if(this.coord_x < Contexte.widthCanvas - 20){
			return Contexte.map.getBloc(this.coord_x + 11, this.coord_y).getVide()
					&& Contexte.map.getBloc(this.coord_x + 11, this.coord_y + 10).getVide()
					&& Contexte.map.getBloc(this.coord_x + 11, this.coord_y + 20).getVide();
		}
		else{
			return false;
		}
	}

	/**
	 * Methode pour savoir si l'action creuser de maniere diagonale a atteint
	 * son quota limite
	 * @return un boolean
	 */
	public boolean isFinD(){
		if(this.coord_x < Contexte.widthCanvas - 20 && this.coord_y < Contexte.heightCanvas - 40){
			if(this.sens == 1){
				return Contexte.map.getBloc(this.coord_x + 11, this.coord_y + 21).getVide()
						&& Contexte.map.getBloc(this.coord_x + 11, this.coord_y + 31).getVide()
						&& Contexte.map.getBloc(this.coord_x, this.coord_y + 31).getVide()
						&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 31).getVide();
			}else{
				return Contexte.map.getBloc(this.coord_x + 11, this.coord_y - 1).getVide()
						&& Contexte.map.getBloc(this.coord_x + 11, this.coord_y - 11).getVide()
						&& Contexte.map.getBloc(this.coord_x + 1, this.coord_y - 11).getVide()
						&& Contexte.map.getBloc(this.coord_x, this.coord_y - 11).getVide()
						&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 11).getVide();
			}
		}else{
			return false;
		}
	}


	/**
	 * Methode pour savoir si il est possible de poser un escalier
	 * @return un boolean
	 */
	public boolean isEscalier(){
		if(this.sens == 1){
			return Contexte.map.getBloc(this.coord_x, this.coord_y + 21).isEscalier();
		}else{
			return Contexte.map.getBloc(this.coord_x, this.coord_y - 1).isEscalier();
		}
	}

	/**
	 * Methode pour savoir si un lemmings est face a un obstacle
	 * @return un boolean
	 */
	public boolean isObstacle(){
		if(this.sens == 1){
			if(Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getObstacle()
					|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).getObstacle()
					|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).getObstacle()){
				return true;
			}else{
				return false;
			}
		}else{
			if(Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getObstacle()
					|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).getObstacle()
					|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).getObstacle()){
				return true;
			}else{
				return false;
			}
		}
	}	

	/**
	 * Methode pour savoir si il est possible pour un lemmings
	 * de creuser de maniere horizontale
	 * @return un boolean
	 */
	public boolean isCassableH(){
		if(this.sens == 1){
			return Contexte.map.getBloc(this.coord_x - 1, this.coord_y + 21).getDestructible()
					&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).getDestructible()
					&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).getDestructible();
		}else{
			return Contexte.map.getBloc(this.coord_x - 1,  this.coord_y - 1).getDestructible()
					&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).getDestructible()
					&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).getDestructible();
		}
	}

	/**
	 * Methode pour savoir si il est possible pour un lemmings 
	 * de creuser de maniere diagonale
	 * @return un boolean
	 */
	public boolean isCassableD(){
		if(this.sens == 1){
			return (Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getDestructible()
					|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).getDestructible()
					|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 30).getDestructible()
					|| Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getDestructible()
					|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).getDestructible()
					|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).getDestructible())
					&& (!(Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getIncassable()
							|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).getIncassable()
							|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 30).getIncassable()
							|| Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getIncassable()
							|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).getIncassable()
							|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).getIncassable()));
		}else{
			if(this.coord_y - 1 < 10){
				return false;
			}else{
				return (Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getDestructible()
						|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getDestructible()
						|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y - 10).getDestructible()
						|| Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getDestructible()
						|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).getDestructible()
						|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).getDestructible())
						&& (!(Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).getIncassable()
								|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getIncassable()
								|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y - 10).getIncassable()
								|| Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getIncassable()
								|| Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).getIncassable()
								|| Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).getIncassable()));
			}
		}
	}

	/**
	 * Methode pour savoir si il est possible 
	 * pour un lemmings de creuser de maniere verticale
	 * @return un boolean
	 */
	public boolean isCassableV(){
		return (Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getDestructible()
				|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 11).getDestructible()
				|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 21).getDestructible())
				&& (!(Contexte.map.getBloc(this.coord_x + 1, this.coord_y).getIncassable()
						|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 11).getIncassable()
						|| Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 21).getIncassable()));
	}

	/**
	 * Methode pour savoir si notre lemmings se retrouve
	 * face a un bloqueur
	 * @return un boolean
	 */
	public boolean isBloqueur(){
		if(this.sens == 1){
			return Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getBloqueur();
		}else{
			return Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getBloqueur();
		}
	}

	/**
	 * Methode pour savoir si un lemmings
	 * se retrouve a toucher le haut de la carte
	 * @return un boolean
	 */
	public boolean hautMap(){
		if(this.coord_x - 31 == 0 || Contexte.map.getBloc(this.coord_x - 31, this.coord_y).getObstacle()){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode pour savoir si un lemmings a atteint l'arrivee
	 * @return un boolean
	 */
	public boolean isArrive(){
		if(Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getSortie() 
				|| Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getSortie()){
			if(this.vie.compareTo("arrive") != 0){
				if(Contexte.mute)
				{
					Sound sonClonedArriv = (Sound) Contexte.arrivee.cloneObj();
					sonClonedArriv.SetFile(Contexte.arrivee.GetFile());
					sonClonedArriv.SetInfo(Contexte.arrivee.GetInfo());
					sonClonedArriv.SetAudioFormat(Contexte.arrivee.GetAudioFormat());
					sonClonedArriv.SetAudiobuffer(Contexte.arrivee.GetAudiobuffer());
					Thread t_arrivee = new Thread(sonClonedArriv);
					t_arrivee.start();
				}

			}
			this.vie = "arrive";

			return true;
		}else{
			return false;
		}
	}

	/**
	 * Methode pour savoir si un lemmings possede le droit de poser
	 * un escalier
	 * @return un boolean
	 */
	public boolean isEsca(){
		if(this.sens == 1){
			return Contexte.map.getBloc(this.coord_x, this.coord_y + 21).getVide() 
					&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).getVide()
					&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).getVide()
					&& Contexte.map.getBloc(this.coord_x - 31, this.coord_y + 21).getVide();
		}else{
			return Contexte.map.getBloc(this.coord_x, this.coord_y - 1).getVide() 
					&& Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).getVide()
					&& Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).getVide()
					&& Contexte.map.getBloc(this.coord_x - 31, this.coord_y - 1).getVide();
		}
	}

	/**
	 * Methode transition, elle nous permet de passer d'un etat a un autre 
	 * grace a l'automate courant du lemming. Elle va analyser la totalite de
	 * l'environnement du lemmings, afin de trouver la transition voulue par l'automate
	 * @return un int la valeur du nouvel etat courant
	 */

	public int transition(){
		ArrayList<String> listeEnvLem = new ArrayList<String>();
		//Liste de condition du lemmings, elle permet de stocker
		//l'analyse de l'environnement du lemmings

		if(this.isEsca()){ //Verification de la possibilite de construire un escalier
			listeEnvLem.add("isEsca");
		}
		if(this.isVide()){ //Verification de la pr�sence du vide
			listeEnvLem.add("isVide");
		}else{
			listeEnvLem.add("isSol");
		}
		if(this.isMortel()){ //Verification d'une chute mortelle
			listeEnvLem.add("isMortel");
		}
		if(this.isEau()){ //Verification de la presence de l'eau
			listeEnvLem.add("isEau");
		}
		if(this.isObstacle()){ //Verification de la presence d'un obstacle sur le chemin d'un lemmings
			listeEnvLem.add("isObstacle");
		}else{
			listeEnvLem.add("isCorniche");
		}
		if(this.hautMap()){ //Verification de la presence du haut de la carte au dessus du lemmings
			listeEnvLem.add("hautMap");
		}
		if(this.isBloqueur()){	//Verification de la presence d'un bloqueur sur le chemin du lemmings
			listeEnvLem.add("isBloqueur");
		}
		if(this.isCassableH()){ //Verification de la possibilite de creuser horizontalement
			listeEnvLem.add("isCreusableH");
		}
		if(this.isCassableV()){ //Verification de la possibilite de creuser verticalement
			listeEnvLem.add("isCreusableV");
		}
		if(this.isCassableD()){ //Verification de la possibilite de creuser en diagonale
			listeEnvLem.add("isCreusableD");
		}
		if(this.isEscalier()){ //Verification de la presence d'un escalier
			listeEnvLem.add("isEscalier");
		}
		if(isFinH()){ //Verification de la fin d'une action consistant a creuser horizontalement
			listeEnvLem.add("finH");
		}
		if(isFinV()){ //Verification de la fin d'une action consistant a creuser verticalement
			listeEnvLem.add("finV");
		}
		if(isFinE()){ //Verification de la fin d'une action consistant a poser un escalier
			listeEnvLem.add("finE");
		}
		if(isFinD()){ //Verification de la fin d'une action consistant a creuser en diagonale
			listeEnvLem.add("finD");
		}

		String action;
		EtatSuivantCondition listerecup;
		// On va maintenant chercher la bonne transition dans l'automate
		// et ainsi mettre a jour l'etat courant du lemmings et effectuer
		// l'action trouvee
		listerecup = this.automate_current.transition(listeEnvLem, etatcourant); 
		if(listerecup == null){
			action = "retourner";
		}else{
			action = listerecup.getAction();
			this.setEtatcourant(this.automate_current.etatExiste(this.automate_current.getListeEtats(), listerecup.getEtat()));
		}
		this.actionL = action;
		if(this.bombe){ // Si le lemmings est une bombe, on le rapproche de l'explosion
			this.cpt_bombe++;
		}

		if(this.cpt_bombe == 240){ // Verification de la condition d'explosion du lemmings
			if(Contexte.mute)
			{
				Sound sonClonedBombe = (Sound) Contexte.bombe.cloneObj();
				sonClonedBombe.SetFile(Contexte.bombe.GetFile());
				sonClonedBombe.SetInfo(Contexte.bombe.GetInfo());
				sonClonedBombe.SetAudioFormat(Contexte.bombe.GetAudioFormat());
				sonClonedBombe.SetAudiobuffer(Contexte.bombe.GetAudiobuffer());
				Thread t_sonClonedBombe = new Thread(sonClonedBombe);
				t_sonClonedBombe.start();
			}
			this.vie = "mort";
			Contexte.listeLemmings.remove(Contexte.listeLemmings.indexOf(this.idLem));
			if(!Contexte.listeLemmings.isEmpty()){
				Contexte.indexLemmings = Contexte.indexLemmings % Contexte.listeLemmings.size();
			}else{
				Contexte.indexLemmings = 0;
			}
			// Tous les blocs du lemmings sont detruis, utile pour la mort d'un bloqueur
			Contexte.map.getBloc(this.coord_x, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x, this.coord_y + 10).toVide();
			Contexte.map.getBloc(this.coord_x, this.coord_y + 20).toVide();
			Contexte.map.getBloc(this.coord_x - 10, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x - 10, this.coord_y + 10).toVide();
			Contexte.map.getBloc(this.coord_x - 10, this.coord_y + 20).toVide();
			Contexte.map.getBloc(this.coord_x - 20, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x - 20, this.coord_y + 10).toVide();
			Contexte.map.getBloc(this.coord_x - 20, this.coord_y + 20).toVide();
		}
		// On va maintenant en fonction de l'action a traiter, appeler la bonne methode
		switch (action){
		case "marcher" : 
			this.marcher();
			break;
		case "tomber" : 
			this.tomber();
			break;
		case "atterir" : 
			this.atterrir();
			break;
		case "tourner" :
			this.tourner();
			break;
		case "grimper" :
			this.grimper();
			break;
		case "bloquer" :
			break;
		case "retourner" : // Cas special, on revient a l'automate precedent du Lemmings
			// Utile pour les automates temporaires tels que creuser.
			this.retourner();
			break;
		case "creuserH" :
			this.creuserH();
			break;
		case "creuserV" :
			this.creuserV();
			break;
		case "creuserD" :
			this.creuserD();
			break;
		case "mourir" :
			Contexte.listeLemmings.remove(Contexte.listeLemmings.indexOf(this.idLem));
			if(!Contexte.listeLemmings.isEmpty()){
				Contexte.indexLemmings = Contexte.indexLemmings % Contexte.listeLemmings.size();
			}else{
				Contexte.indexLemmings = 0;
			}
			this.mourir();
			break;
		case "monter" : 
			this.monter();
			break;
		case "construire" :
			this.construire();
			break;
		}
		// On renvoie l'etat courant (-1 si etat puit)
		return this.etatcourant;
	}


	/**
	 * Methode pour faire une rotation au lemmings
	 */
	public void tourner(){
		// il faudra differencer tournerDroite et TournerGauche !!!

		try {
			if(sens ==1) {setSens(0);}
			else {
				setSens(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("La direction est : " + getSens());
	}

	/**
	 * Methode pour faire avancer le lemmings
	 */
	public void marcher(){
		if (sens == 1){ //on va vers la droite
			this.coord_y = this.coord_y + 1;
		}
		else { // on va vers la gauche
			this.coord_y = this.coord_y - 1;
		}	 
	}

	/**
	 * Methode pour faire grimper une marche d'un escalier a un lemmings
	 */
	public void monter(){
		if(this.sens == 1){
			this.coord_x--;
			this.coord_y++;
		}else{
			this.coord_x--;
			this.coord_y--;
		}
	}

	/**
	 * Methode pour remettre le compteur de profondeur a zero apres avoir toucher
	 * le sol sans mourir
	 */
	public void atterrir(){
		this.setProfondeur(0);
	}

	/**
	 * Methode pour faire tomber le lemmings
	 */
	public void tomber(){	
		if(this.coord_x + 1 >= Contexte.heightCanvas - 10){
			this.setVie("mort");
		}else{
			this.coord_x = this.coord_x + 1;
			this.profondeur = this.profondeur + 1;
		}
	}

	/**
	 * Methode pour faire grimper un lemmings
	 */
	public void grimper(){
		this.coord_x--;
	}

	/**
	 * Methode pour faire mourir un lemmings
	 */
	public void mourir(){
		//atterrir();
		if(Contexte.mute)
		{
			Sound sonCloned = (Sound) Contexte.son.cloneObj();
			sonCloned.SetFile(Contexte.son.GetFile());
			sonCloned.SetInfo(Contexte.son.GetInfo());
			sonCloned.SetAudioFormat(Contexte.son.GetAudioFormat());
			sonCloned.SetAudiobuffer(Contexte.son.GetAudiobuffer());
			Thread t = new Thread(sonCloned);
			t.start();
		}

		this.setVie("mort");		
	}

	/**
	 * Methode de retour. Elle est utiliser pour revenir d'un automate 
	 * temporaire a l'automate par defaut du lemmings.
	 */
	public void retourner(){
		if(this.automate_current == Contexte.automate_bloqueur){
			Contexte.map.getBloc(this.coord_x, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x - 11, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x - 21, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x, this.coord_y + 21).toVide();
			Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).toVide();
			Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).toVide();
		}
		this.automate_current = this.automate_default;
		this.etatcourant = 0;
		this.cptC = 1;
		this.cptE = 1;
		this.nbrActionE = 0;
	}

	/**
	 * Methode pour creuser horizontalement
	 */
	public void creuserH(){
		if(this.sens == 1){
			if(this.cptC == 20){
				Contexte.map.getBloc(this.coord_x, this.coord_y + 21).toVide();
				Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).toVide();
				Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).toVide();
				this.cptC = 1;
			}else{
				this.cptC++;
			}
		}else{
			if(this.cptC == 20){
				Contexte.map.getBloc(this.coord_x, this.coord_y - 1).toVide();
				Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 1).toVide();
				Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 1).toVide();
				this.cptC = 1;
			}else{
				this.cptC++;
			}
		}
	}

	/**
	 * Methode pour creuser verticalement
	 */
	public void creuserV(){
		if(this.cptC == 20){
			Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).toVide();
			Contexte.map.getBloc(this.coord_x + 1, this.coord_y).toVide();
			Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).toVide();
			this.cptC = 1;
			this.profondeur = 0;
		}else{
			this.cptC++;
		}		
	}

	/**
	 * Methode pour creuser en diagonale
	 */
	public void creuserD(){
		if(this.sens == 1){
			if(this.cptC == 20){
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).toVide();
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 20).toVide();
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 30).toVide();
				Contexte.map.getBloc(this.coord_x, this.coord_y + 30).toVide();
				Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 30).toVide();
				Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 30).toVide();
				this.cptC = 1;
				this.profondeur = 0;
			}else{
				cptC++;
			}
		}else{
			if(this.cptC == 20){
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y + 10).toVide();
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y).toVide();
				Contexte.map.getBloc(this.coord_x + 1, this.coord_y - 10).toVide();
				Contexte.map.getBloc(this.coord_x, this.coord_y - 10).toVide();
				Contexte.map.getBloc(this.coord_x - 11, this.coord_y - 10).toVide();
				Contexte.map.getBloc(this.coord_x - 21, this.coord_y - 10).toVide();	
				this.cptC = 1;
				this.profondeur = 0;
			}else{
				cptC++;
			}
		}
	}

	/**
	 * Methode pour poser un escalier
	 */
	public void construire(){
		if(this.sens == 1){
			if(this.cptE == 20){
				Contexte.map.getBloc(this.coord_x, this.coord_y + 21).toEscalier();
				this.cptE = 1;
				this.nbrActionE++;
			}else{
				this.cptE++;
			}
		}else{
			if(this.cptE == 20){
				Contexte.map.getBloc(this.coord_x, this.coord_y - 1).toEscalier();
				this.cptE = 1;
				this.nbrActionE++;
			}else{
				this.cptE++;
			}
		}
	}

	/**
	 * Methode pour les changements d'automates pour quand il y aura des clics.
	 * Ici, permet de passer un automate temporaire au lemmings
	 * @param un Automate
	 */
	public void setAutomateNonH(Automate automate){
		if(automate == Contexte.automate_bloqueur){
			if(Contexte.mute)
			{
				Sound sonClonedBloque = (Sound) Contexte.bloqueur.cloneObj();
				sonClonedBloque.SetFile(Contexte.bloqueur.GetFile());
				sonClonedBloque.SetInfo(Contexte.bloqueur.GetInfo());
				sonClonedBloque.SetAudioFormat(Contexte.bloqueur.GetAudioFormat());
				sonClonedBloque.SetAudiobuffer(Contexte.bloqueur.GetAudiobuffer());
				Thread t_sonClonedBloque = new Thread(sonClonedBloque);
				t_sonClonedBloque.start();
			}

			Contexte.map.getBloc(this.coord_x, this.coord_y + 21).toLemBloqueur();
			Contexte.map.getBloc(this.coord_x - 11, this.coord_y + 21).toLemBloqueur();
			Contexte.map.getBloc(this.coord_x - 21, this.coord_y + 21).toLemBloqueur();
			Contexte.map.getBloc(this.coord_x, this.coord_y).toLemBloqueur();
			Contexte.map.getBloc(this.coord_x - 11, this.coord_y).toLemBloqueur();
			Contexte.map.getBloc(this.coord_x - 21, this.coord_y).toLemBloqueur();
		}
		this.automate_current = automate;
		this.etatcourant = 0;
		this.nbrActionE = 0;
		this.cptC = 1;
	}


	/**
	 * Methode pour les changements d'automates pour quand il y aura des clics.
	 * Ici, permet de passer un automate permanent au lemmings
	 * @param un Automate
	 */
	public void setAutomateH(Automate automate){
		this.automate_current = automate;
		this.automate_default = automate;
		this.etatcourant = 0;
		this.nbrActionE = 0;
		this.cptC = 1;
	}

}
