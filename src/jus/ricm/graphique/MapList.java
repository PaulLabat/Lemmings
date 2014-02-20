package jus.ricm.graphique;

import java.util.ArrayList;

import jus.ricm.graphique.Map;;

public class MapList {
	
	protected ArrayList<Map> listemap = null;
	
	 public ArrayList<Map> getMapList() {
		return listemap;
	}

	public void setMapList(ArrayList<Map> listemap) {
		this.listemap = listemap;
	}
	
	public MapList (){
		listemap = new ArrayList<Map>();
	}
	
	@SuppressWarnings("unused")
	public void display(){
		
		for(Map t : listemap)
		{
			//t.afficherMonMap();
		}
	}
	
	public void ajouter(Map a){
		listemap.add(a);
	}


}
