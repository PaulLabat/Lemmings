/**
 * @author bazk EUDES Robin, LABAT Paul
 */
package jus.ricm.graphique;


import java.awt.Image;

import jus.ricm.contexte.Contexte;




public class Bloc {

	private boolean destructible;
	private boolean mortel;
	private boolean vide;
	private boolean sol;
	private boolean eau;
	private boolean bloqueur;

	private boolean obstacle;
	private boolean spawn;
	private boolean sortie;
	private Image image;
	private boolean escalier;

	/**
	 * Constructeur par defaut
	 */
	public Bloc(){
		toVide();
	}
	
	/**
	 * creation image vide & proprietees associees.
	 */
	public void toVide()
	{
		setImage(Contexte.transp.getImage());
		setVide(true);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(false);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * creation image escalier & proprietees associees.
	 */
	public void toEscalier()
	{
		setImage(Contexte.escalier.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(false);
		setSpawn(false);
		setSortie(false);
		setEscalier(true);
	}

	/**
	 * creation image sol & proprietees associees.
	 */
	public void toEarth()
	{
		setImage(Contexte.earth.getImage());
		setVide(false);
		setDestructible(true);
		setMortel(false);
		setSol(true);
		setEau(false);
		setBloqueur(false);
		setObstacle(true);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * creation image eau & proprietees associees.
	 */
	public void toWater()
	{
		setImage(Contexte.water.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(true);
		setSol(false);
		setEau(true);
		setBloqueur(false);
		setObstacle(true);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * creation image bloc indestructible & proprietees associees.
	 */
	public void toNonDestructible()
	{
		setImage(Contexte.obs_non_destru.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(true);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * creation image bloc creusable & proprietees associees.
	 */
	public void toCreusable()
	{
		setImage(Contexte.obstacle_creus.getImage());
		setVide(false);
		setDestructible(true);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(true);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * creation image bloc spawn & proprietees associees.
	 */
	public void toSpawn()
	{
		setImage(Contexte.spawn_img.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(false);
		setSpawn(true);
		setSortie(false);
		setEscalier(false);
	}
	
	/**
	 * creation image bloc sortie & proprietees associees.
	 */
	public void toSortie()
	{
		setImage(Contexte.sortie_img.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(false);
		setObstacle(false);
		setSpawn(false);
		setSortie(true);
		setEscalier(false);
	}

	/**
	 * creation image bloc bloqueur & proprietees associees.
	 */
	public void toLemBloqueur()
	{
		setImage(Contexte.transp.getImage());
		setVide(false);
		setDestructible(false);
		setMortel(false);
		setSol(false);
		setEau(false);
		setBloqueur(true);
		setObstacle(true);
		setSpawn(false);
		setSortie(false);
		setEscalier(false);
	}

	/**
	 * getter destructible
	 * @return boolean
	 */
	public boolean getDestructible() {
		return destructible;
	}

	/**
	 * Setter destructible
	 * @param destructible boolean
	 */
	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
	}

	/**
	 * getter mortel
	 * @return boolean
	 */
	public boolean getMortel() {
		return mortel;
	}

	/**
	 * setter mortel
	 * @param mortel boolean
	 */
	public void setMortel(boolean mortel) {
		this.mortel = mortel;		
	}

	/**
	 * getter vide
	 * @return boolean
	 */
	public boolean getVide() {
		return vide;
	}

	/**
	 * Setter vide
	 * @param vide boolean 
	 */
	public void setVide(boolean vide) {
		this.vide = vide;
	}

	/**
	 * getter sol
	 * @return boolean
	 */
	public boolean getSol() {
		return sol;
	}

	/**
	 * setter sol
	 * @param sol boolean
	 */
	public void setSol(boolean sol) {
		this.sol = sol;
	}

	/**
	 * getter eau
	 * @return boolean
	 */
	public boolean getEau() {
		return eau;
	}

	/**
	 * setter eau
	 * @param eau boolean
	 */
	public void setEau(boolean eau) {
		this.eau = eau;
	}

	/**
	 * getter bloqueur
	 * @return boolean
	 */
	public boolean getBloqueur() {
		return bloqueur;
	}

	/**
	 * setter bloqueur
	 * @param bloqueur boolean
	 */
	public void setBloqueur(boolean bloqueur) {
		this.bloqueur = bloqueur;
	}

	/**
	 * setter obstable
	 * @param obstacle boolean
	 */
	public void setObstacle(boolean obstacle)
	{
		this.obstacle = obstacle;
	}

	/**
	 * getter obstacle
	 * @return boolean
	 */
	public boolean getObstacle()
	{
		return this.obstacle;
	}

	public boolean getIncassable()
	{
		if(vide == true)
		{
			return false;
		}
		else if( destructible == false || eau == true)
			{return true;}
		
		else
			{return false;}
				
	}
	
	/**
	 * setter spawn
	 * @param spawn boolean
	 */
	public void setSpawn(boolean spawn)
	{
		this.spawn = spawn;
	}

	/**
	 * getter spawn
	 * @return boolean
	 */
	public boolean getSpwan()
	{
		return this.spawn;
	}

	/**
	 * getter sortie
	 * @return boolean
	 */
	public boolean getSortie() {
		return sortie;
	}

	/**
	 * setter sortie
	 * @param sortie boolean
	 */
	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

/**
 * getter object image.
 * @return
 */
	public Image getImage() {
		return image;
	}

/**
 * Setter object image
 * @param image img
 */
	public void setImage(Image image) {
		this.image = image;
	}

/**
 * getter escalier
 * @return boolean
 */
	public boolean isEscalier() {
		return escalier;
	}

/**
 * setter escalier
 * @param escalier boolean
 */
	public void setEscalier(boolean escalier) {
		this.escalier = escalier;
	}

	
	

}
