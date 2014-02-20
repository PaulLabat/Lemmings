package jus.ricm.automate;

import java.util.ArrayList;

/**
 * @author Rodolphe
 * Definition de la classe EtatSuivantCondition. Elle permet de lier un etat final à une action
 * ainsi qu'une liste de condition qui permettent de l'atteindre.
 */
public class EtatSuivantCondition {
	
	protected String etat;
	protected ArrayList<String> condition;
	protected String action;
	
	// Definition du constructeur de la classe.
	
	public EtatSuivantCondition(String etat, ArrayList<String> condition, String action) {
		this.etat = etat;
		this.condition = condition;
		this.action = action;
	}
	
	// Definition des getters et des setters
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public ArrayList<String> getCondition() {
		return condition;
	}

	public void setCondition(ArrayList<String> condition) {
		this.condition = condition;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	

}
