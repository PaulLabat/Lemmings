package jus.ricm.contexte;

import java.awt.Color;



public class Actions {

	public static void action_bloque()
	{
		
		if(Contexte.valBloque) // si deja arme il passe a false
		{
			Contexte.valBloque = false;
			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			
			Contexte.valSupp = false;
			Contexte.valBloque = true;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			
			Contexte.jeu.get_bloque().setBackground(new Color(77,103,124));
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
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_bombe(){
		if(Contexte.valBombe) // si deja arme il passe a false
		{
			Contexte.valBombe = false;
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{
			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe = true;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			

			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(77,103,124));
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
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_contructeur(){
		if(Contexte.valConstructeur) // si deja arme il passe a false
		{
			Contexte.valConstructeur = false;
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =true;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			
			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(77,103,124));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_control(){
		if(Contexte.valControl) // si deja arme il passe a false
		{
			Contexte.valControl = false;
			//Contexte.jeu.get_control().setBackground(new Color(77,103,124));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche= false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl =true;
			Contexte.valsuicide =false;
			
			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(77,103,124));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>ON</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_grimpe(){
		if(Contexte.valGrimpe) // si deja arme il passe a false
		{
			Contexte.valGrimpe = false;
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = true;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;


			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(77,103,124));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_horizontal(){
		if(Contexte.valHorizon) // si deja arme il passe a false
		{
			Contexte.valHorizon = false;
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =true;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			

			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(77,103,124));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_luciole(){
		if(Contexte.valLuciole) // si deja arme il passe a false
		{
			Contexte.valLuciole = false;
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = true;
			Contexte.valControl = false;
			Contexte.valsuicide =false;

			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(77,103,124));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_parapluie(){
		if(Contexte.valParapluie) // si deja arme il passe a false
		{
			Contexte.valParapluie = false;
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{
			
			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=true;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			

			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(77,103,124));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_pioche(){
		if(Contexte.valPioche) // si deja arme il passe a false
		{
			Contexte.valPioche = false;
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche= true;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;
			

			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(77,103,124));
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
			
		}
	}
	
	public static void action_vertical(){
		if(Contexte.valVerti) // si deja arme il passe a false
		{
			Contexte.valVerti = false;
			Contexte.jeu.get_verti().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{

			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti = true;
			Contexte.valLuciole = false;
			Contexte.valControl = false;
			Contexte.valsuicide =false;


			Contexte.jeu.get_bloque().setBackground(new Color(158,211,255));
			Contexte.jeu.get_bombe().setBackground(new Color(158,211,255));
			Contexte.jeu.get_constructeur().setBackground(new Color(158,211,255));
			Contexte.jeu.get_grimp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_horizon().setBackground(new Color(158,211,255));
			Contexte.jeu.get_parapluie().setBackground(new Color(158,211,255));
			Contexte.jeu.get_pioche().setBackground(new Color(158,211,255));
			Contexte.jeu.get_verti().setBackground(new Color(77,103,124));
			Contexte.jeu.get_luciole().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setBackground(new Color(158,211,255));
			Contexte.jeu.get_control().setText("<html><center>CONTROL<br>OFF</center></html>");
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
	}
	
	public static void action_supp(){
		if(Contexte.valSupp) // si deja arme il passe a false
		{
			Contexte.valSupp = false;
			Contexte.jeu.get_supp().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{
			Contexte.valSupp = true;
			Contexte.valBloque =false;
			Contexte.valBombe =false;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valsuicide =false;
			
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
			Contexte.jeu.get_supp().setBackground(new Color(77,103,124));
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
			
		}
	}
	
	
	public static void action_suicide(){
		if(Contexte.valsuicide) // si deja arme il passe a false
		{
			Contexte.valsuicide = false;
			Contexte.jeu.get_suicide().setBackground(new Color(158,211,255));
		}
		else // si pas arme, on le fait et on passe tous les autres a false
		{
			Contexte.valSupp = false;
			Contexte.valBloque =false;
			Contexte.valBombe =true;
			Contexte.valConstructeur =false;
			Contexte.valGrimpe = false;
			Contexte.valHorizon =false;
			Contexte.valParapluie=false;
			Contexte.valPioche=false;
			Contexte.valVerti =false;
			Contexte.valLuciole = false;
			Contexte.valsuicide =true;
			
			
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
			Contexte.jeu.get_suicide().setBackground(new Color(77,103,124));
			
			/**
				for(int i=0;i<Contexte.nbLemmings;i++){
					if(Contexte.tabLemmings[i].isVivant()){
						Contexte.tabLemmings[i].setBombe(true);
					}
				}
			*/
		}
	}
	
}
