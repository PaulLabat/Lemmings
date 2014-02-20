package jus.ricm.automate;

import java.util.ArrayList;

public class Automate {

	public ArrayList<String> listeEtats; 								// definition de la liste des etats de l'automate									// represente l'indice de l'etat courant de l'automate
	protected ArrayList<ArrayList<EtatSuivantCondition>> listeEtatCond;		// definition de la liste de liste des etats suivants


	// J'aurais besoin de confirmation Adji, mais ton
	// parser doit faire les ajustages automatiquement

	/**
	 * Constructeur par defaut de l'automate pour le parser
	 */
	public Automate(){
		this.listeEtats = new ArrayList<String>();
		this.listeEtatCond = new ArrayList<ArrayList<EtatSuivantCondition>>();
	}

	// D'autres constructeurs qui pourraient être utiles?

	/**
	 * Constructeur abandonne
	 * @param listeEtat
	 * @param listeSuiv
	 */
	public Automate(ArrayList<String> listeEtat, ArrayList<ArrayList<EtatSuivantCondition>> listeSuiv){
		this.listeEtats = listeEtat;
		this.listeEtatCond = listeSuiv;
	}

	/**
	 * Methode pour retrouver le numero d'un etat dont on
	 * ne connait que le nom
	 * @param listEtat une ArrayList<String> liste des etats de l'automate
	 * @param elemRecherche un String l'etat recherche
	 * @return un int le numero de l'etat rechercher
	 */
	public int etatExiste(ArrayList<String> listEtat, String elemRecherche){
		int position = -1; // Valeur ;par defaut
		for(int i = 0; i < listEtat.size(); i++){
			// Parcours de la liste pour retrouver l'etat
			if(listEtat.get(i).compareTo(elemRecherche) == 0){
				// On a retrouve l'element recherche

				position = i;
			}
		}
		return position;
	}




	/**
	 * Methode pour retourner la liste d'etat
	 * @return une ArrayList<String>
	 */
	public ArrayList<String> getListeEtats() {
		return listeEtats;
	}

	/**
	 * Methode pour donner une liste d'etat
	 * @param listeEtats une ArrayList<String>
	 */
	public void setListeEtats(ArrayList<String> listeEtats) {
		this.listeEtats = listeEtats;
	}

	/**
	 * Methode pour recuperer la liste EtatSuivantCondition
	 * @return une ArrayList<ArrayList<EtatSuivantCondition>>
	 */
	public ArrayList<ArrayList<EtatSuivantCondition>> getListeEtatCond() {
		return listeEtatCond;
	}

	/**
	 * Methode pour donner une valeur a EtatSuivantCondition
	 * @param listeEtatCond une ArrayList<ArrayList<EtatSuivantCondition>>
	 */
	public void setListeEtatCond(
			ArrayList<ArrayList<EtatSuivantCondition>> listeEtatCond) {
		this.listeEtatCond = listeEtatCond;
	}

	/**
	 * Methode d'affichage pour verifier l'automate courant
	 */

	public void afficherMonAutomate(){
		System.out.println("Affichage de notre automate");

		for(int i = 0; i < listeEtatCond.size(); i++){
			System.out.println("Etat : " + listeEtats.get(i));
			System.out.println("Etat Suivant puis Conditions puis Action associee");
			//System.out.println("debut affichage liste adj ");
			for(int j = 0; j < listeEtatCond.get(i).size();j++){

				System.out.println(listeEtatCond.get(i).get(j).getEtat() + " " + listeEtatCond.get(i).get(j).getCondition() + " " + listeEtatCond.get(i).get(j).getAction());

			}
			

		}
		System.out.println("------------------------------------------------------");

	}
	/**
	 * Methode permettant de trouver l'etat d'arriver depuis l'etat 
	 * courant, grace a une liste de condition
	 * @param param une ArrayList<String> liste d'etats du lemmings courant
	 * @param etatcourant unt int l'etat courant du lemmings dans l'automate
	 * @return
	 */
	public EtatSuivantCondition transition(ArrayList<String> param, int etatcourant){
		EtatSuivantCondition res = null;
		ArrayList<EtatSuivantCondition> listerecup = this.listeEtatCond.get(etatcourant);
		for(int i = 0; i < listerecup.size(); i++){

			ArrayList<String> listeCond = listerecup.get(i).getCondition();
			int nbr = 0;

			for(int j = 0; j < listeCond.size(); j++){
				for(int k = 0; k < param.size(); k++){
					if(param.get(k).compareTo(listeCond.get(j)) == 0){
						nbr++;
					}
				}
			}
		
			if(nbr == listeCond.size()){
				res = listerecup.get(i);

			}
		}

		return res;

	}
	
	/**
	 * Methode pour creer un automate ligne par ligne
	 * @param transition une ArrayList<String> liste des conditions pour passer vers l'etat suivant
	 * @param etatInit un String l'etat initial
	 * @param etatSuiv un Sring l'etat d'arrive
	 * @param action un String l'action associee a la transition
	 */
	public void creeAutomate(ArrayList<String> transition, String etatInit, String etatSuiv, String action){
		int position;
		position = etatExiste(this.getListeEtats(), etatInit);

		if(position == -1){
			this.getListeEtats().add(etatInit);
			position = this.getListeEtats().indexOf(etatInit);
			this.getListeEtatCond().add(new ArrayList<EtatSuivantCondition>());
		}

		this.getListeEtatCond().get(position).add(new EtatSuivantCondition(etatSuiv,transition,action));
	}

}
