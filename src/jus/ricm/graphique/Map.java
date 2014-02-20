/**
 * @author Labat Paul, Eudes Robin
 */
package jus.ricm.graphique;

import jus.ricm.contexte.Contexte;


public class Map {

	/*
	 * VARIABLES
	 */
	Bloc[][] map;
	private int width;
	private int height;
	

	/**
	 * Constructeur, prend en parametre la taille du canvas
	 * @param widthmap
	 * @param heightmap
	 */
	public Map(int widthmap, int heightmap){
		width = widthmap;
		height = heightmap;
		map = new Bloc[widthmap][heightmap];
		//Envoie de la taille du canvas, en pixel, dans le contexte
		Contexte.widthCanvas = width*10;
		Contexte.heightCanvas = height*10;
		
	}
	
	
	
	/**
	 * Constructeur vide pour le parser
	 */
	public Map(){
		
	}
	
	/**
	 * Init de la matrice de bloc contenant les propriete ( rappel bloc = 10x10 px )
	 */
	public void init_map(){
		int i,j;
		
		for(i=0;i<width;i++){
			for(j=0;j<height;j++){
					map[i][j] = new Bloc();
			}
		}
		
		
	}
	
	/**
	 * Getter pour acceder au bloc, et tt ce qui en decoule.
	 * @return Bloc
	 */
	public Bloc getBloc(int i, int j)
	{
		return map[i/10][j/10];
	}
	
	public void gen_full_map(){
		//Bord non destructible
		Contexte.map.genPlateform(6, 0,0 , "horizontal", 128);
		Contexte.map.genPlateform(6, 54, 0, "horizontal", 128);
		Contexte.map.genPlateform(6, 0, 0, "vertical", 55);
		Contexte.map.genPlateform(6, 0, 127, "vertical", 55);
		
		//plateforme de spawn
		Contexte.map.genPlateform(2, 6, 1, "horizontal", 20);
		Contexte.map.genPlateform(2, 7, 1, "horizontal", 20);
		Contexte.map.genPlateform(2, 8, 1, "horizontal", 20);
		//escalier
		Contexte.map.genPlateform(4, 5, 9, "horizontal", 1);
		Contexte.map.genPlateform(4, 4, 10, "vertical", 1);
		Contexte.map.genPlateform(4, 5, 10, "horizontal", 1);
		Contexte.map.genPlateform(4, 5, 11, "horizontal", 1);
		
		//gen de la sortie et des deux spawns
		Contexte.map.genPlateform(9, (Contexte.sortieX/10)-3, Contexte.sortieY/10, "vertical", 4);
		Contexte.map.genPlateform(8, (Contexte.spawnX1/10)-3, Contexte.spawnY1/10, "vertical", 5);
		Contexte.map.genPlateform(8, (Contexte.spawnX2/10)-3, Contexte.spawnY2/10, "vertical", 5);
		
		//seconde plateforme
		Contexte.map.genPlateform(6, 9, 19, "vertical", 4);//indestructible
		Contexte.map.genPlateform(2, 12, 19, "horizontal", 32);
		Contexte.map.genPlateform(2, 13, 19, "horizontal", 32);
		Contexte.map.genPlateform(2, 7, 46, "vertical", 6);
		Contexte.map.genPlateform(2, 7, 47, "vertical", 6);
		Contexte.map.genPlateform(2, 7, 48, "vertical", 6);
		Contexte.map.genPlateform(2, 7, 49, "vertical", 6);
		Contexte.map.genPlateform(2, 7, 50, "vertical", 10);
		Contexte.map.genPlateform(2, 7, 51, "vertical", 10);
		Contexte.map.genPlateform(2, 7, 52, "vertical", 10);
		Contexte.map.genPlateform(2, 7, 53, "vertical", 10);
		Contexte.map.genPlateform(2, 7, 54, "vertical", 10);
		
		//desous map
		Contexte.map.genPlateform(2, 14, 21, "horizontal", 29);
		Contexte.map.genPlateform(2, 15, 23, "horizontal", 27);
		Contexte.map.genPlateform(2, 16, 25, "horizontal", 25);
		//Tube de descente
		Contexte.map.genPlateform(2, 7, 60, "vertical", 19);
		Contexte.map.genPlateform(2, 7, 61, "vertical", 19);
		Contexte.map.genPlateform(2, 7, 62, "vertical", 19);
		Contexte.map.genPlateform(6, 7, 63, "vertical", 19);
		
		//troisième plateformer
		Contexte.map.genPlateform(2, 23, 47, "horizontal", 13);
		Contexte.map.genPlateform(3, 23, 43, "horizontal", 4);
		Contexte.map.genPlateform(2, 23, 12, "horizontal", 31);
		Contexte.map.genPlateform(2, 24, 47, "horizontal", 13);
		Contexte.map.genPlateform(3, 24, 43, "horizontal", 4);
		Contexte.map.genPlateform(2, 24, 12, "horizontal", 31);
		Contexte.map.genPlateform(2, 25, 12, "horizontal", 49);
		Contexte.map.genPlateform(6, 21, 12, "vertical", 2);
		Contexte.map.genPlateform(6, 21, 13, "vertical", 2);
		Contexte.map.genPlateform(6, 26, 26, "horizontal", 38);
		
		//4eme plateforme
		Contexte.map.genPlateform(2, 30, 1, "horizontal", 25);
		Contexte.map.genPlateform(2, 31, 1, "horizontal", 24);
		Contexte.map.genPlateform(2, 32, 1, "horizontal", 23);
		Contexte.map.genPlateform(2, 33, 1, "horizontal", 22);
		Contexte.map.genPlateform(2, 34, 1, "horizontal", 21);
		Contexte.map.genPlateform(2, 35, 1, "horizontal", 20);
		Contexte.map.genPlateform(6, 28, 24, "vertical", 2);
		Contexte.map.genPlateform(6, 28, 25, "vertical", 2);
		
		
		//Bas de la map		
		Contexte.map.genPlateform(2, 53, 40, "horizontal", 87);
		Contexte.map.genPlateform(2, 52, 41, "horizontal", 86);
		Contexte.map.genPlateform(2, 51, 42, "horizontal", 85);
		Contexte.map.genPlateform(2, 50, 43, "horizontal", 84);
		Contexte.map.genPlateform(2, 49, 44, "horizontal", 83);
		Contexte.map.genPlateform(3, 51, 51, "horizontal", 69);
		Contexte.map.genPlateform(3, 50, 52, "horizontal", 67);
		Contexte.map.genPlateform(3, 52, 52, "horizontal", 67);
		
		//A partir du deuxieme spawn
		Contexte.map.genPlateform(2, 10, 110, "horizontal", 17);
		Contexte.map.genPlateform(2, 11, 110, "horizontal", 17);
		Contexte.map.genPlateform(2, 12, 110, "horizontal", 17);
		Contexte.map.genPlateform(2, 3, 100, "vertical", 17);
		Contexte.map.genPlateform(2, 3, 101, "vertical", 17);
		Contexte.map.genPlateform(6, 2, 99, "vertical", 19);
		Contexte.map.genPlateform(2, 2, 102, "vertical", 19);
		Contexte.map.genPlateform(2, 2, 100, "horizontal", 2);
		Contexte.map.genPlateform(6, 20, 100, "horizontal", 2);
		//deuxieme platefome
		Contexte.map.genPlateform(2, 17, 102, "horizontal", 15);
		Contexte.map.genPlateform(2, 18, 102, "horizontal", 16);
		Contexte.map.genPlateform(2, 19, 102, "horizontal", 17);
		Contexte.map.genPlateform(6, 20, 102, "horizontal", 17);
	
		//troisieme plateforme
		Contexte.map.genPlateform(2, 28, 117, "horizontal", 10);
		Contexte.map.genPlateform(2, 29, 115, "horizontal", 12);
		Contexte.map.genPlateform(2, 30, 113, "horizontal", 14);
		Contexte.map.genPlateform(2, 31, 111, "horizontal", 16);
		Contexte.map.genPlateform(2, 32, 109, "horizontal", 18);
		Contexte.map.genPlateform(2, 33, 107, "horizontal", 20);
		Contexte.map.genPlateform(2, 34, 105, "horizontal", 22);
		
	}
	
	/*
	 * Generation des blocs de decors.
	 */
	public void genPlateform(int type, int x, int y, String sens, int taille)
	{
		int i,j,k;
		if( sens == "horizontal" && (y+(taille-1))<=height && y>=0 && x>=0 && x<width)
		{
			for(j=y;j<y+taille;j++)
			{
				choixType(type, x, j);
			}
		}
		else if (sens == "vertical" && (x+(taille-1))<=width && x>=0 && y>=0 && y<height)
		{
			for(i=x;i<x+taille;i++)
			{
				choixType(type, i,y);
			}
		}
		else if ( sens == "diagonale_droite" && x>=0 && y>=0 && (x+(taille-1))<=width && (y+(taille-1))<=height )
		{
			k = 0;
			i=x;
			j=y;
			while(k<taille){
					choixType(type, i,j);
					i++;
					j++;
					k++;
			}
		
		}else if (sens == "diagonale_gauche" && x>=0 && y>=0 && (x+(taille-1))<=width && (y-(taille-1))>=0 ){ // diagonale gauche

			k = 0;
			i=x;
			j=y;
			while(k<taille){
					choixType(type, i,j);
					i++;
					j--;
					k++;
			}
		}
		

	}
	
	
	/*
	 *  Type de bloc a appliquer, et appel de ma methode associe.
	 *  chaque bloc est set "logiquement " ( to... ) , puis graphiquement. 
	 *  On retrouve les coords du coin sup gauche en faisant x10 ;)
	 */
	public void choixType(int c, int i, int j){
		switch(c){
		case 1:
			map[i][j].toVide();		
			break;
		case 2:
			map[i][j].toEarth();
			break;
		case 3:
			map[i][j].toWater();
			break;
		case 4:
			map[i][j].toEscalier();
			break;
		case 6:
			map[i][j].toNonDestructible();
			break;
		case 7:
			map[i][j].toCreusable();
			break;
		case 8:
			map[i][j].toSpawn();
			break;
		case 9:
			map[i][j].toSortie();
			break;
		default:
			map[i][j].toVide();
			
		}
	}
	


}
