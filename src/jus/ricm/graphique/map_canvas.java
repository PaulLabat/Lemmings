/**
 * @author EUDES Robin, LABAT Paul
 */
package jus.ricm.graphique;

import java.awt.*;
import javax.swing.JPanel;

import jus.ricm.contexte.Contexte;
import jus.ricm.lemmings.*;

import java.awt.Graphics2D;


@SuppressWarnings("serial")
public class map_canvas extends JPanel {

	// variable largeur / hauteur.
	private int width, height;

	// toolkit pour l'image de fond.
	java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
	Image wallpaper = toolkit.getImage("./img/wallpaper.png");


	/**
	 * Constructeurs du Canvas ( Ds lequel les lemmings evoluent )
	 * @param width largeur
	 * @param height hauteur
	 */
	public map_canvas(int width, int height)
	{
		super(true);
		//this.setDoubleBuffered(true);
		this.width = width;
		this.height = height;
	}
	public map_canvas()
	{
		super(true);
		//this.setDoubleBuffered(true);
		this.width = 1280;
		this.height = 700;
	}

	/**
	 * Overide de paincomponent, appele implicitement par le constructeur , appele par repaint... ( voir ordonanceur )
	 */
	@Override
	public void paintComponent(Graphics g) {
		int i, j;
		super.paintComponent(g);  // paint parent's background
		Graphics2D graphics2D = (Graphics2D) g;
		//Set  anti-alias!
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON); 

		// Set anti-alias for text
		graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 

		// ADD WALLPAPER
		g.drawImage(wallpaper, 0, 0, null);

		// DECORS
		for(i=0;i<(height-120-30)/10;i++)
		{
			for(j=0;j<width/10;j++)
			{
				if(!(Contexte.map.map[i][j].getVide())){
					g.drawImage(Contexte.map.map[i][j].getImage(), j*10, i*10, null);
				}else{
					g.drawImage(null, j*10, i*10, null); 
				}
			}

		}

		//LEMINGS
		draw_lemmings(g);

		// NIGHT 1 LEMINGS REDRAX IF LUCIOLE.
		draw_night(g);
		g.dispose();
		toolkit.sync();
	}

	/**
	 * Dessin de la nuit, appel � la fct pour redissiner par dessus au besoin les lems...
	 * @param g objet graphics ( canvas ... )
	 */
	public void draw_night(Graphics g){
		int i;

		g.drawImage(Contexte.night.getImage(), Contexte.pos_night,10, null);

		// pour que la nuit n'avance pas quand on se met en pause ! )
		if(!Contexte.pause){
			Contexte.pos_night--;
		}

		// Defilement de la nuit...
		if(Contexte.pos_night==-3000){
			Contexte.pos_night=1280;
		}

		// appel a redraw
		for(i=0;i<Contexte.nbLemmings;i++){
			if(Contexte.tabLemmings[i].isLuciolle()){// && Contexte.tabLemmings[i].getActionL()=="marcher"){
				//AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.CLEAR, 1.0f);
				//((Graphics2D)g).setComposite(composite);
				//g.fillOval(pos_moy_x - portee, pos_moy_y - portee, 2 * portee, 2 * portee);
				redraw_lemmings(i,g);
			}
		}
	}

	/**
	 * Dessins des lemmings
	 * @param g graphics canvas
	 */
	public void draw_lemmings(Graphics g){
		int i;

		Contexte.dead =0;
		Contexte.alive=0;
		Contexte.nbSave =0;
		boolean save;

		for(i=0;i<Contexte.nbLemmings;i++)
		{
			save=false;
			if(Contexte.tabLemmings[i].isVivant())
			{
				// choix de l'img associe au type de lemming
				choice_img(Contexte.tabLemmings[i],i,g);
				Contexte.alive++;
			}
			if(Contexte.tabLemmings[i].isArrive()){
				Contexte.nbSave++;
				save=true;
				// rmq : is arrive = !isvivant. Donc compte 2 fois. d'ou la soustraction pour reajuster.
				//Contexte.dead--;
			}

			if(!(Contexte.tabLemmings[i].isVivant())){
				Contexte.dead++;
				Contexte.tabLemmings[i].setLuciolle(false);
				if(save){
					Contexte.dead--;

				}
			}




		}

		/**
		 * Calcul du pourcentage de succes, en temps reel.
		 */
		try{
			Contexte.ratio_home = Contexte.nbSave*100/Contexte.nbLemmings;
		}catch (ArithmeticException e){
			Contexte.ratio_home =0;
		}

		/**
		 * MAJ de divers compteurs : dead : alive , @home , et le pourcentage de lem sauves.
		 */
		Contexte.jeu.valeur_home.setText(String.format("%02d",Contexte.nbSave));
		Contexte.jeu.get_ratio().setText(" ~~ " + String.format("%02d",Contexte.ratio_home) + "%");
		Contexte.jeu.valeur_dead.setText(String.format("%02d",Contexte.dead));
		Contexte.jeu.valeur_out.setText(String.format("%02d",Contexte.alive));

	}

	/**
	 *  REDRAW des lem cach�s dans la nuit ( appel si existance d'une luciole )
	 * @param i ID LEMMINGS LUCIOLE
	 * @param g graphics canvas
	 */
	public void redraw_lemmings(int i, Graphics g){
		int n;
		int m;
		int portee = 100;
		int pos_moy_x = Contexte.tabLemmings[i].getCoord_x()-15;
		int pos_moy_y = Contexte.tabLemmings[i].getCoord_y()-10;

		// On parcours tout les lemmings....
		for(n=0;n<Contexte.nbLemmings;n++){
			// ... qui sont vivants...
			if(Contexte.tabLemmings[n].isVivant()){
				// ... qui sont occult�es par la nuit...
				if((Contexte.tabLemmings[n].getCoord_y()-10) >=Contexte.pos_night || (Contexte.tabLemmings[n].getCoord_y()-10) <= Contexte.pos_night+3000 ){
					// ... et qui sont a portee du lemmings luciole ( rayon 50 px )
					if((Contexte.tabLemmings[n].getCoord_y()-10)>= (pos_moy_y-portee) && (Contexte.tabLemmings[n].getCoord_y()-10) <= (pos_moy_y+portee) ){
						if((Contexte.tabLemmings[n].getCoord_x()-15) >= (pos_moy_x-portee) && (Contexte.tabLemmings[n].getCoord_x()-15) <= (pos_moy_x+portee)){
							choice_img(Contexte.tabLemmings[n], n, g);
							//AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.CLEAR, 1.0f);
							//((Graphics2D)g).setComposite(composite);
							//g.fillOval(pos_moy_x - portee, pos_moy_y - portee, 2 * portee, 2 * portee);

						}
					}
				}
			}
		}

		// redraw du recors, sur le mm principe.
		for(m=(pos_moy_x-portee)/10;m<=(pos_moy_x+portee+15)/10;m++){
			for(n=(pos_moy_y-portee)/10;n<=(pos_moy_y+portee+10)/10;n++){
				if(m>0 && n>0 && m<((height-120-30)/10)-1 && n<(width/10)-1){
					g.drawImage(Contexte.map.map[m][n].getImage(), n*10, m*10, null);
				}
			}

		}
	}

	/*	pos_moy_x = Contexte.tabLemmings[i].getCoord_x()-15;
	pos_moy_y = Contexte.tabLemmings[i].getCoord_y()-10;

	if(pos_moy_x!=0 && pos_moy_y!=0){
		pres = true;
		rect = new Rectangle2D.Double();
		ellipse2 = new Ellipse2D.Double(portee,portee,pos_moy_x,pos_moy_y);	
		surface = new Area(rect);
		surface.subtract(new Area(ellipse2));
		//g.setClip(surface);
		g.drawImage(Contexte.night.getImage(), Contexte.pos_night,10, null);
		//g.setClip(null);
		((Graphics2D)g).draw(surface);
		pos_moy_x=0;
		pos_moy_y=0;
	}

//	Area surface = new Area((Graphics2D)g);
//	AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.CLEAR, 1.0f);
//	((Graphics2D)g).setComposite(composite);
//	g.fillOval(pos_moy_x - portee, pos_moy_y - portee, 2 * portee, 2 * portee);
	//redraw_lemmings(i,g);

if(!pres){
g.drawImage(Contexte.night.getImage(), Contexte.pos_night,10, null);
}*/


	/**
	 * Naissance des lemmings, ajout dans le tableau.
	 * @param max n_max lemmings cr�s
	 * @param x position x init.
	 * @param y position y init.
	 */
	public void born (int max,int x1,int y1, int x2, int y2){

		if(Contexte.nbLemmings < max)
		{
			if(Contexte.nbLemmings % 2 == 0)
			{
				Contexte.tabLemmings[Contexte.nbLemmings] = new Lemmings(x2,y2);
				Contexte.tabLemmings[Contexte.nbLemmings].setSens(0);
				Contexte.tabLemmings[Contexte.nbLemmings].setIdLem(Contexte.nbLemmings);
				Contexte.listeLemmings.add(Contexte.nbLemmings);
				Contexte.nbLemmings++;
			}
			else
			{
				Contexte.tabLemmings[Contexte.nbLemmings] = new Lemmings(x1,y1);
				Contexte.tabLemmings[Contexte.nbLemmings].setIdLem(Contexte.nbLemmings);
				Contexte.listeLemmings.add(Contexte.nbLemmings);
				Contexte.nbLemmings++;

			}

		}

	}

	/**
	 * Choix de l'img associe au type de lemmings.
	 * @param lem lemmings
	 * @param i ID du lemmings
	 * @param g graphics canvas.
	 */
	public void choice_img(Lemmings lem,int i, Graphics g){
		if(Contexte.listeLemmings.get(Contexte.indexLemmings) != lem.getIdLem()){
			if(Contexte.tabLemmings[i].getCpt_bombe()<=200 && !Contexte.tabLemmings[i].isLuciolle()){

				if(lem.getActionL().compareTo("bloquer") == 0){

					g.drawImage(Contexte.imageBloque.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}else if(lem.getActionL().compareTo("grimper") == 0){

					if(lem.getSens()==1){
						g.drawImage(Contexte.imageGrimpeD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imageGrimpeG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("creuserH") == 0){
					if(lem.getSens()==1){
						g.drawImage(Contexte.imageHorizonD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imageHorizonG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("creuserV") == 0){
					g.drawImage(Contexte.imageVerti.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x() - 15, null);
				}else if(lem.getActionL().compareTo("creuserD") == 0){
					if(lem.getSens()==1){
						g.drawImage(Contexte.imagePiocheD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imagePiocheG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("tomber") == 0 && lem.getAutomate_current() == Contexte.automate_parapluie){
					g.drawImage(Contexte.imageParapluie.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}else if(lem.getActionL()=="construire"){
					if( lem.getSens() == 1)
					{
						g.drawImage(Contexte.imageConstructeurD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}
					else{
						g.drawImage(Contexte.imageConstructeurG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}

				}else{
					g.drawImage(Contexte.imagenormal.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}
			}
			if(Contexte.tabLemmings[i].getCpt_bombe()<=200 && Contexte.tabLemmings[i].isLuciolle()){
				g.drawImage(Contexte.imageLuciole.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
			}
			if(Contexte.tabLemmings[i].get_bombe()){
				if(Contexte.tabLemmings[i].getCpt_bombe()<=40){
					g.drawImage(Contexte.d_5.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if (Contexte.tabLemmings[i].getCpt_bombe()<=80){
					g.drawImage(Contexte.d_4.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=120){
					g.drawImage(Contexte.d_3.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=160){
					g.drawImage(Contexte.d_2.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=200){
					g.drawImage(Contexte.d_1.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=240){
					g.drawImage(Contexte.mort.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}
			}
		// Lemming selectionner
		}else{
			
			if(Contexte.tabLemmings[i].getCpt_bombe()<=200 && !Contexte.tabLemmings[i].isLuciolle()){

				if(lem.getActionL().compareTo("bloquer") == 0){

					g.drawImage(Contexte.imageBloque.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}else if(lem.getActionL().compareTo("grimper") == 0){

					if(lem.getSens()==1){
						g.drawImage(Contexte.imageGrimpeD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imageGrimpeG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("creuserH") == 0){
					if(lem.getSens()==1){
						g.drawImage(Contexte.imageHorizonD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imageHorizonG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("creuserV") == 0){
					g.drawImage(Contexte.imageVerti.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x() - 15, null);
				}else if(lem.getActionL().compareTo("creuserD") == 0){
					if(lem.getSens()==1){
						g.drawImage(Contexte.imagePiocheD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}else{
						g.drawImage(Contexte.imagePiocheG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);	
					}
				}else if(lem.getActionL().compareTo("tomber") == 0 && lem.getAutomate_current() == Contexte.automate_parapluie){
					g.drawImage(Contexte.imageParapluie.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}else if(lem.getActionL()=="construire"){
					if( lem.getSens() == 1)
					{
						g.drawImage(Contexte.imageConstructeurD.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}
					else{
						g.drawImage(Contexte.imageConstructeurG.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
					}

				}else{
					g.drawImage(Contexte.imageLuciole.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}
			}
			if(Contexte.tabLemmings[i].getCpt_bombe()<=200 && Contexte.tabLemmings[i].isLuciolle()){
				g.drawImage(Contexte.imageLuciole.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
			}
			if(Contexte.tabLemmings[i].get_bombe()){
				if(Contexte.tabLemmings[i].getCpt_bombe()<=40){
					g.drawImage(Contexte.d_5.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if (Contexte.tabLemmings[i].getCpt_bombe()<=80){
					g.drawImage(Contexte.d_4.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=120){
					g.drawImage(Contexte.d_3.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=160){
					g.drawImage(Contexte.d_2.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=200){
					g.drawImage(Contexte.d_1.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-40, null);
				}else if(Contexte.tabLemmings[i].getCpt_bombe()<=240){
					g.drawImage(Contexte.mort.getImage(), Contexte.tabLemmings[i].getCoord_y(), Contexte.tabLemmings[i].getCoord_x()-30, null);
				}
			}
		}

	}

	/**
	 * get time
	 * @return temps ecoule, depuis init, en sec.
	 */
	public long get_time(){
		Contexte.time = System.currentTimeMillis()-Contexte.init;
		return Contexte.time/1000;
	}

	/**
	 * Extraction des secondes ( moins les min dc )
	 * @return sec ( 0 - 59 )
	 */
	public long get_sec(){
		return (get_time()%60 );
	}

	/**
	 * Extraction des minutes
	 * @return minutes
	 */
	public long get_min(){
		return (get_time()/60);
	}



}
