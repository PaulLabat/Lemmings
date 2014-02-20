package jus.ricm.automate;

import java.util.*;


@SuppressWarnings("rawtypes")
public class AutomateList implements Iterable{
	
	protected ArrayList<Automate> listeauto = null;
	
	 public ArrayList<Automate> getAutoList() {
		return listeauto;
	}

	public void setAutoList(ArrayList<Automate> listeauto) {
		this.listeauto = listeauto;
	}
	
	public AutomateList (){
		listeauto = new ArrayList<Automate>();
	}
	
	public void display(){
		
		for(Automate t : listeauto)
		{
			t.afficherMonAutomate();
		}
	}
	
	public void ajouter(Automate a){
		listeauto.add(a);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
