package jus.ricm.interpreteur;
import jus.ricm.lemmings.*;

import java.util.*;

import javax.swing.JOptionPane;

import jus.ricm.graphique.*;
import jus.ricm.graphique.Map;

import jus.ricm.automate.*;
import jus.ricm.contexte.Contexte;

//import java.io.File;
//import java.awt.Color;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;



/**
 * @author Adji
 *
 */
public class ParserXML{

	protected ArrayList<Automate> autoList = null;
	protected ArrayList<Lemmings> lemmingList=null;
	protected ArrayList<Bloc> blocList=null;
	protected  ArrayList<String> listcond = null;
	protected  String etatInit = null;
	protected  String etatSuiv = null;
	protected  String action = null;

	protected  String typeB=null;
	protected  String coordX=null;
	protected  String coordY=null;
	protected  String sens =null;
	protected  String taille =null;

	protected String nomB = null;
	protected String nombreB = null;


	public void setListautolist(ArrayList<Automate> autolist){
		this.autoList=autolist;
	}

	public ArrayList<Automate> getListautolist(){
		return autoList;
	}

	public void setListLemming(ArrayList<Lemmings> lemmingList){
		this.lemmingList=lemmingList;
	}

	public ArrayList<Lemmings> getListLemming(){
		return lemmingList;
	}


	public void setListBloc(ArrayList<Bloc> blocList){
		this.blocList=blocList;
	}

	public ArrayList<Bloc> getListBloc(){
		return blocList;
	}

	public void setListcondT(ArrayList<String> condT){
		this.listcond=condT;
	}

	public ArrayList<String> getListcondT(){
		return listcond;
	}


	public void setListetI(String et){
		this.etatInit=et;
	}

	public String getListetI(){
		return etatInit;
	}

	public void setListeetS(String es){
		this.etatSuiv=es;
	}

	public String getListetS(){
		return etatSuiv;
	}

	public void setListeacT(String ac){
		this.action=ac;
	}

	public String getListeacT(){
		return action;
	}

	public void setListetypeB(String ac){
		this.typeB=ac;
	}

	public String getListetypeB(){
		return typeB;
	}

	public void setListecoordX(String ac){
		this.coordX=ac;
	}

	public String getListecoordX(){
		return coordX;
	}

	public void setListecoordY(String ac){
		this.coordY=ac;
	}

	public String getListecoordY(){
		return coordY;
	}

	public void setListeSens(String ac){
		this.sens=ac;
	}

	public String getListeSens(){
		return sens;
	}

	public void setListeTaille(String ac){
		this.taille=ac;
	}

	public String getListeTaille(){
		return taille;
	}





	public ParserXML(String donneesInitiales){

		try{
			parserXML(donneesInitiales);

		}catch(Exception err){
			System.out.println("Erreur");
		}
	}


	@SuppressWarnings({ "rawtypes", "unused" })
	public void parserXML(String donneesInitiales) throws Exception {
		
		
		
		List lemming;
		List comportement;
		List automate;
		List transition;
		List condition;
		List bloc;
		List bouton;

		//lemmings
		String nombre=null;
		String typeL = null;
		String width=null;
		String high =null;

		//condition
		String valeur=null;
		//String bool=null;

		//Transition
		//String etatInit=null;
		//String etatSuiv=null;
		//String action=null;

		// automate
		String typeA =null;

		//comportement
		String nature =null;

		//bloc
		//String typeB=null;
		//String coordX=null;
		//String coordY=null;
		//String sens =null;
		//String taille =null;

		ArrayList<Automate> automateList = new ArrayList<Automate>();
		ArrayList<String> etatlist = null;
		ArrayList<ArrayList<EtatSuivantCondition>> etsuivlist = null;
		//ArrayList<String> listcond=null;

		// set des automates
		Contexte.automate_base = new Automate ();
		Contexte.automate_parapluie = new Automate ();
		Contexte.automate_grimpeur = new Automate ();
		Contexte.automate_creuseurH = new Automate ();
		Contexte.automate_creuserV = new Automate ();
		Contexte.automate_creuserD = new Automate ();
		Contexte.automate_bloqueur = new Automate ();
		Contexte.automate_escalier = new Automate ();
		Contexte.automate_supp = new Automate ();
		autoList = new ArrayList<Automate>();
		autoList.add(Contexte.automate_base);
		autoList.add(Contexte.automate_parapluie);
		autoList.add(Contexte.automate_grimpeur);
		autoList.add(Contexte.automate_bloqueur);
		autoList.add(Contexte.automate_creuseurH);
		autoList.add(Contexte.automate_creuserV);
		autoList.add(Contexte.automate_creuserD);
		autoList.add(Contexte.automate_escalier);
		autoList.add(Contexte.automate_supp);


		Map map = new Map();
		MapList maplist = new MapList();


		SAXBuilder sb=new SAXBuilder();
		Document doc=sb.build(donneesInitiales);

		Element root=doc.getRootElement();

		Element contexte = root.getChild("Fenetre");
		Contexte.obj = Integer.parseInt(contexte.getAttributeValue("objectif"));
		Contexte.n_max = Integer.parseInt(contexte.getAttributeValue("nbLemmings"));
		Contexte.tempsMax = Integer.parseInt(contexte.getAttributeValue("tempsMax"));

		//System.out.println(Contexte.tempsMax);
		Element listeComp = root.getChild("ListeComportements");
		comportement = listeComp.getChildren("Comportement");
		automateList = new ArrayList<Automate>(); 

		if(comportement.size() == 8){
			Contexte.btn_sup = false;
		}else if(comportement.size() == 9){
			Contexte.btn_sup = true;
			//System.out.println(Contexte.btn_sup);
			 Contexte.jeu.get_supp().setEnabled(true);
		}else{
			JOptionPane.showMessageDialog(null, "Fichier XML errone, vous avez " + comportement.size() + " automate(s) " +
					"au lieu de 8 ou 9", 
					"Error Parser XML", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
		for (int k=0; k<comportement.size(); k++)
		{
			Element e=(Element)comportement.get(k);
			automate = e.getChildren("Automate");
			typeA=e.getChild("Automate").getAttributeValue("type");


			for (int l = 0; l<automate.size(); l++)
			{

				Element et=(Element)automate.get(l);
				transition = et.getChildren("Transition");
				if(transition.size() == 0 ){
					JOptionPane.showMessageDialog(null, "Fichier XML errone, automate sans transitions", 
							"Error Parser XML", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
					}
				for(int m=0; m<transition.size();m++)
				{

					Element em=(Element)transition.get(m);
					condition=em.getChildren("Condition");

					Element en1=(Element)transition.get(m);
					etatInit=en1.getAttributeValue("etat_init");

					Element en2=(Element)transition.get(m);
					etatSuiv=en2.getAttributeValue("etat_suiv");

					Element en3=(Element)transition.get(m);
					action=en3.getAttributeValue("action");
					if(action.equals("marcher") || action.equals("tourner")
							|| action.equals("grimper") || action.equals("mourir")
							|| action.equals("atterir") || action.equals("bloquer")
							|| action.equals("retourner") || action.equals("creuserH")
							|| action.equals("creuserV") || action.equals("creuserD")
							|| action.equals("monter")|| action.equals("construire")
							|| action.equals("tomber")){
						listcond = new ArrayList<String>() ;
						//    System.out.println(condition.size());
						for(int n=0; n<condition.size(); n++){

							Element en=(Element)condition.get(n);
							valeur=en.getAttributeValue("valeur");
							if(valeur.equals("isSol") || valeur.equals("isObstacle")
									|| valeur.equals("isVide") || valeur.equals("isEau")
									|| valeur.equals("isEscalier") || valeur.equals("isMortel")
									|| valeur.equals("isBloqueur") || valeur.equals("hautMap")
									|| valeur.equals("isCorniche") || valeur.equals("finH")
									|| valeur.equals("finD") || valeur.equals("finE")
									|| valeur.equals("isCreusableH") || valeur.equals("isCreusableV")
									|| valeur.equals("isCreusableD") || valeur.equals("finV")
									|| valeur.equals("isEsca")){
								listcond.add(valeur);
							}else{
								JOptionPane.showMessageDialog(null, "Fichier XML errone, valeur de test en cause : " + valeur, 
										"Error Parser XML", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}

						}
						autoList.get(k).creeAutomate( listcond,etatInit , etatSuiv, action);
					}else{
						JOptionPane.showMessageDialog(null, "Fichier XML errone, ligne en cause : " + etatInit + 
								" " + etatSuiv + " " + action, "Error Parser XML", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
			}    
		}


		Element listeBloc = root.getChild("map");
		bloc = listeBloc.getChildren("Bloc");

		int nbent = 0;
		int nbsor = 0;
		for(int i=0;i<bloc.size();i++){

			Element element=(Element)bloc.get(i);
			typeB=element.getAttributeValue("type");

			coordX=element.getAttributeValue("coordx");
			coordY=element.getAttributeValue("coordy");
			
			if(Integer.parseInt(typeB) == 9){
				Contexte.sortieX = (Integer.parseInt(coordX) * 10 + 30);
				Contexte.sortieY = (Integer.parseInt(coordY) * 10);
				nbsor++;
				//System.out.println(Contexte.sortieX);
			}

			if(Integer.parseInt(typeB) == 8 && nbent == 1){
				Contexte.spawnX2 = (Integer.parseInt(coordX) * 10 + 30);
				Contexte.spawnY2 = (Integer.parseInt(coordY) * 10);
				//System.out.println(Contexte.spawnX2 + " " + Contexte.spawnY2);
				nbent++;
			}
			if((Integer.parseInt(typeB) == 8) && (nbent == 0)){
				Contexte.spawnX1 = (Integer.parseInt(coordX) * 10 + 30);
				Contexte.spawnY1 = (Integer.parseInt(coordY) * 10);
				//System.out.println(Contexte.spawnX1 + " " + Contexte.spawnY1 + "test");
				nbent = nbent + 1;
			}
			sens=element.getAttributeValue("sens");
			taille=element.getAttributeValue("taille");
			//System.out.println(Integer.parseInt(typeB) + " " + Integer.parseInt(coordX) + " " + Integer.parseInt(coordY) + " " + sens + " " + Integer.parseInt(taille));
			if(sens.compareTo("vertical") == 0){
			Contexte.map.genPlateform(Integer.parseInt(typeB), Integer.parseInt(coordX), Integer.parseInt(coordY), "vertical", Integer.parseInt(taille));
			}else if(sens.compareTo("horizontal") == 0){
				Contexte.map.genPlateform(Integer.parseInt(typeB), Integer.parseInt(coordX), Integer.parseInt(coordY), "horizontal", Integer.parseInt(taille));	
			}
		}
		
		//maplist.ajouter(map);
		//Contexte.map = map;
		Element listeBouton = root.getChild("ListeBoutons");
		bouton = listeBouton.getChildren("Bouton");
		for(int z=0;z<bouton.size();z++){

			Element element=(Element)bouton.get(z);
			nomB=element.getAttributeValue("nom");
			nombreB=element.getAttributeValue("nombre");
		}
		
		Contexte.tabLemmings = new Lemmings[Contexte.n_max];
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

		Contexte.jeu.get_obj().setText(Integer.toString(Contexte.obj) + " %"  + " Tmax : "+ Integer.toString(Contexte.tempsMax) +"'");



	}

	public static void main(String[] args){
		//Contexte.map.init_map();
		ParserXML test = new ParserXML("FichierXML.xml");
	}
	
}
