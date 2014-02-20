open String;;

let sortie = open_out "FichierXML.xml";;


(*  Contexte *)

let ecrirejeu jeu =

let (objectif, nbLemmings, tempsMax) = jeu
in
output sortie "<Fenetre objectif =\"" 0 20;
output sortie (string_of_int objectif) 0 (length (string_of_int objectif));
output sortie "\" nbLemmings =\"" 0 15;
output sortie (string_of_int nbLemmings) 0 (length (string_of_int nbLemmings));
output sortie "\" tempsMax =\"" 0 13;
output sortie (string_of_int tempsMax) 0 (length (string_of_int tempsMax));
output sortie "\"/>"0 3;
output sortie "\n>"0 1;;


(* Condition *)

let ecrireCondition cond =

  let (valeur) = cond 
  in 
output sortie "<Condition valeur =\"" 0 20;
output sortie (valeur) 0 (length (valeur));
output sortie "\"/>"0 3;
output sortie "\n>"0 1;;


let rec ecrirelisteCondition cc = match cc with 
  |[] -> ()
  |[t] -> ecrireCondition t
  |t::q -> ecrireCondition t; ecrirelisteCondition q;;



(* transition *)

let ecrireTransition trans =

  let (init, suiv, action, cond) = trans 
  in 
output sortie "<Transition etat_init =\"" 0 24;
output sortie (init) 0 (length (init));
output sortie "\" etat_suiv =\"" 0 14;
output sortie (suiv) 0 (length (suiv));
output sortie "\" action =\"" 0 11;
output sortie (action) 0 (length (action));
output sortie "\">"0 2;
ecrirelisteCondition cond ;
output sortie "</Transition>"0 13;
output sortie "\n>"0 1;;


let rec ecrirelisteTransition tt = match tt with 
  |[] -> ()
  |[t] -> ecrireTransition t
  |t::q -> ecrireTransition t; ecrirelisteTransition q;;


(* automate *)

let ecrireAutomate aut =

  let (typ,trans) = aut
  in 
output sortie "<Automate type =\"" 0 17;
output sortie (typ) 0 (length (typ));
output sortie "\">"0 2;
ecrirelisteTransition trans;
output sortie "</Automate>"0 11;
output sortie "\n>"0 1;;


let rec ecrirelisteAutomate aa = match aa with 
  |[] -> ()
  |[t] -> ecrireAutomate t
  |t::q -> ecrireAutomate t; ecrirelisteAutomate q;;


(* comportement *)

let ecrireComportement comportement =

  let (nature,aut) = comportement
  in 
output sortie "<Comportement nature =\"" 0 23;
output sortie (nature) 0 (length (nature));
output sortie "\">"0 2;
ecrirelisteAutomate aut;
output sortie "</Comportement>" 0 15;;

let rec ecrirelisteComportement cpt = match cpt with 
  |[] -> ()
  |[t] -> ecrireComportement t
  |t::q -> ecrireComportement t; ecrirelisteComportement q;;


let ecriretoutComportement liste = 
output sortie "<ListeComportements>"0 20;
ecrirelisteComportement liste;
output sortie "</ListeComportements>"0 21;;


(* BLOC*)

let ecrireBloc bloc = 
let (typ, coordx, coordy, sens, taille ) = bloc in
output sortie "<Bloc type =\"" 0 13;
output sortie (string_of_int (typ)) 0 (length (string_of_int (typ)));
output sortie "\" coordx =\"" 0 11;
output sortie (string_of_int (coordx)) 0 (length (string_of_int (coordx)));
output sortie "\" coordy =\"" 0 11;
output sortie (string_of_int (coordy)) 0 (length (string_of_int (coordy)));
output sortie "\" sens =\"" 0 9;
output sortie (sens) 0 (length (sens));
output sortie "\" taille =\""0 11;
output sortie (string_of_int (taille)) 0 (length (string_of_int (taille)));
output sortie "\"/>"0 3;
output sortie "\n>"0 1;;


let rec ecrirelisteBloc bb = match bb with
|[] -> ()
|[t] -> ecrireBloc t
|t::q -> ecrireBloc t; ecrirelisteBloc q;;


(* map *)

let ecriremap bloc =
output sortie "<map>"0 5;
ecrirelisteBloc bloc;
output sortie "</map>"0 6;;


(*  boutons *)

let ecrireBouton bout =

  let (nom, nombre) = bout
  in 
output sortie "<Bouton nom =\"" 0 14;
output sortie (nom) 0 (length (nom));
output sortie "\" nombre =\"" 0 11;
output sortie (string_of_int nombre) 0 (length (string_of_int nombre));
output sortie "\"/>"0 3;
output sortie "\n>"0 1;;


let rec ecrirelisteBouton ll = match ll with 
  |[] -> ()
  |[t] -> ecrireBouton t
  |t::q -> ecrireBouton t; ecrirelisteBouton q;;

let ecriretoutBouton liste = 
output sortie "<ListeBoutons>"0 14;
ecrirelisteBouton liste;
output sortie "</ListeBoutons>"0 15;;






let version ="1.0";;


let ecriretout jeu = let (contexte,comportement,bloc, bouton) =jeu in 
output sortie "<?xml version =\""0 16;
output sortie (version) 0 (length (version));
output sortie "\""0 1;
output sortie "?>"0 2;
output sortie "<Jeu>" 0 5;
ecrirejeu contexte;
ecriretoutComportement comportement; 
ecriremap bloc;
ecriretoutBouton bouton;
output sortie "</Jeu>" 0 6;;




(* Contexte *)

let contexte = (50, 10, 5);;

(**************************** conditions ****************************)
let cond1 = "isEau";;
let cond2 = "isVide";;
let cond3 = "isMortel";;
let cond4 = "isSol";;
let cond5 = "isObstacle";;
let cond6 = "isBloqueur";;
let cond7 = "hautMap";;
let cond8 = "isCorniche";;
let cond9 = "isEscalier";;
let cond10 = "isCreusableH";;
let cond11 = "finH";;
let cond12 = "finV";;
let cond13 = "isCreusableV";;
let cond14 = "finD";;
let cond15 = "isCreusableD";;
let cond16 = "finE";;
let cond17 = "isEsca";;

(*********************** transition automate base ********************)
let trans1 =("MARCHE", "MARCHE", "marcher",[cond4]);;
let trans2 =("MARCHE", "ROTATION", "tourner",[cond5]);;
let trans3 =("MARCHE", "TOMBE", "tomber",[cond2]);;
let trans35 = ("MARCHE", "MONTE", "monter",[cond9]);;
let trans4 =("MARCHE", "MORT", "mourir",[cond1]);;
let trans5 =("TOMBE", "MARCHE", "atterir",[cond4]);;
let trans6 =("TOMBE", "TOMBE", "tomber",[cond2]);;
let trans7 =("TOMBE", "MORT", "mourir",[cond3; cond4]);;
let trans8 =("ROTATION", "MARCHE", "marcher",[cond4]);;
let trans36 =("MONTE", "MARCHE", "marcher",[cond4]);;
let trans37 =("MONTE", "MONTE", "monter",[cond9]);;



let aut1=("1",[trans1; trans2; trans3; trans35; trans4; trans5; trans6; trans7; trans8; trans36; trans37]);;
let comp1 =("base",[aut1]);;



(********************** transition automate parapluie ********************)
let trans9 =("MARCHE", "MARCHE", "marcher",[cond4]);;
let trans10 =("MARCHE", "ROTATION", "tourner",[cond5]);;
let trans11 =("MARCHE", "TOMBE", "tomber",[cond2]);;
let trans38 = ("MARCHE", "MONTE", "monter",[cond9]);;
let trans12 =("MARCHE", "MORT", "mourir",[cond1]);;
let trans13 =("TOMBE", "MARCHE", "atterir",[cond4]);;
let trans14 =("TOMBE", "TOMBE", "tomber",[cond2]);;
let trans15 =("ROTATION", "MARCHE", "marcher",[cond4]);;
let trans39 =("MONTE", "MARCHE", "marcher",[cond4]);;
let trans40 =("MONTE", "MONTE", "monter",[cond9]);;


let aut2=("2",[trans9; trans10; trans11; trans38; trans12; trans13; trans14; trans15; trans39; trans40]);;
let comp2 =("parapluie",[aut2]);;



(********************** transition automate grimpeur ********************)
let trans16 =("MARCHE", "MARCHE", "marcher",[cond4]);;
let trans17 =("MARCHE", "GRIMPE", "grimper",[cond5]);;
let trans18 =("MARCHE", "ROTATION", "tourner",[cond6; cond4]);;
let trans19 =("MARCHE", "TOMBE", "tomber",[cond2]);;
let trans41 = ("MARCHE", "MONTE", "monter",[cond9]);;
let trans20 =("MARCHE", "MORT", "mourir",[cond1]);;
let trans21 =("TOMBE", "MARCHE", "atterir",[cond4]);;
let trans22 =("TOMBE", "TOMBE", "tomber",[cond2]);;
let trans23 =("TOMBE", "MORT", "mourir",[cond3; cond4]);;
let trans24 =("ROTATION", "MARCHE", "marcher",[cond4]);;
let trans25 =("ROTATION", "TOMBE", "tomber",[cond2]);;
let trans42 =("MONTE", "MARCHE", "marcher",[cond4]);;
let trans43 =("MONTE", "MONTE", "monter",[cond9]);;
let trans26 =("GRIMPE", "GRIMPE", "grimper",[cond5]);;
let trans27 =("GRIMPE", "ROTATION", "tourner",[cond7;cond5]);;
let trans28 =("GRIMPE", "MARCHE", "marcher",[cond8]);;

let aut3=("3",[trans16; trans17; trans18; trans19; trans41; trans20; trans21; trans22; trans23; trans24; trans25; trans42; trans43; trans26; trans27; trans28]);;
let comp3 =("grimpeur",[aut3]);;



(*********************** transition automate bloqueur ********************)
let trans29 =("BLOQUE", "BLOQUE", "bloquer",[cond4]);;
let trans30 =("BLOQUE", "RETOUR", "retourner",[cond2]);;

let aut4=("4",[trans29; trans30]);;
let comp4 =("bloqueur",[aut4]);;



(*********************** transition automate creuseur horizontal ********************)
let trans44 = ("MARCHE", "MARCHE", "marcher",[cond4]);;
let trans45 = ("MARCHE", "ROTATION", "tourner",[cond5]);;
let trans47 = ("MARCHE", "TOMBE", "tomber",[cond2]);;
let trans50 = ("MARCHE", "RETOUR", "retourner",[cond11]);;
let trans46 = ("MARCHE", "CREUSEH", "creuserH",[cond5; cond4; cond10]);;
let trans48 = ("MARCHE", "MONTE", "monter",[cond9]);;
let trans49 = ("MARCHE", "MORT", "mourir",[cond1]);;
let trans51 = ("TOMBE", "MARCHE", "atterir", [cond4]);;
let trans52 = ("TOMBE", "TOMBE", "tomber", [cond2]);;
let trans53 =("TOMBE", "MORT","mourir", [cond3; cond4]);;
let trans31 =("CREUSEH", "MARCHE", "creuserH",[cond4]);;
let trans54 =("CREUSEH", "RETOUR", "retourner",[cond11]);;
let trans32 =("CREUSEH", "CREUSEH", "creuserH",[cond5]);;
let trans55 =("ROTATION", "MARCHE", "marcher", [cond4]);;
let trans33 =("MONTE", "MARCHE", "marcher",[cond4]);;
let trans34 =("MONTE", "MONTE", "monter",[cond9]);;

let aut5=("5",[trans44; trans45; trans47; trans50; trans46; trans48; trans49; trans51; trans52; trans53; trans31; trans54; trans32; trans55; trans33; trans34]);;
let comp5 =("creuserH",[aut5]);;



(*********************** transition automate creuseur vertical ********************)
let trans56 = ("MARCHE", "MARCHE", "marcher",[cond4]);;
let trans57 = ("MARCHE", "ROTATION", "tourner", [cond5]);;
let trans59 = ("MARCHE", "TOMBE", "tomber", [cond2]);;

let trans62 = ("MARCHE", "RETOUR", "retourner", [cond12]);;

let trans58 = ("MARCHE", "CREUSEV", "creuserV", [cond4; cond13]);;
let trans60 = ("MARCHE", "MONTE", "monter", [cond9]);;
let trans61 = ("MARCHE", "MORT", "mourir", [cond1]);;
let trans63 = ("TOMBE", "MARCHE", "atterir", [cond4]);;
let trans64 = ("TOMBE" , "TOMBE", "tomber", [cond2]);;
let trans65 = ("TOMBE", "MORT", "mourir", [cond3; cond4]);;
let trans66 = ("CREUSEV", "TOMBE", "creuserV", [cond2]);;
let trans68 = ("CREUSEV", "RETOUR", "retourner", [cond12]);;
let trans67 = ("CREUSEV", "CREUSEV", "creuserV", [cond4; cond13]);;
let trans69 = ("ROTATION", "MARCHE", "marcher", [cond4]);;
let trans70 = ("MONTE", "MARCHE", "marcher", [cond4]);;
let trans71 = ("MONTE","MONTE", "monter", [cond9]);;

let aut6 = ("6" ,[trans56; trans57; trans59; trans62; trans58; trans60; trans61; trans63; trans64; trans65; trans66; trans68;
trans68; trans67; trans69; trans70; trans71]);;
let comp6 =("creuserV",[aut6]);;


(*********************** transition automate creuseur Diagonal ********************)
let trans72 = ("MARCHE", "MARCHE", "marcher", [cond4]);;
let trans73 = ("MARCHE", "ROTATION", "tourner", [cond5]);;
let trans75 = ("MARCHE", "TOMBE", "tomber",[cond2]);;
let trans78 = ("MARCHE", "RETOUR", "retourner", [cond14]);;
let trans74 = ("MARCHE", "CREUSED", "creuserD", [cond4 ; cond15]);;
let trans76 = ("MARCHE", "MONTE", "mourir", [cond9]);;
let trans77 = ("MARCHE", "MORT", "mourir", [cond1]);;
let trans79 = ("TOMBE", "MARCHE", "atterir", [cond4]);;
let trans80 = ("TOMBE", "TOMBE", "tomber", [cond2]);;
let trans81 = ("TOMBE", "MORT", "mourir", [cond3; cond4]);;
let trans82 = ("CREUSED", "MARCHE", "creuserD", [cond4]);;
let trans84 = ("CREUSED", "RETOUR", "retourner", [cond14]);;
let trans83 = ("CREUSED", "CREUSED", "creuserD", [cond4; cond15]);;
let trans85 = ("ROTATION" , "MARCHE", "marcher", [cond4]);;
let trans86 = ("MONTE", "MARCHE", "marcher", [cond4]);;
let trans87 = ("MONTE", "MONTE", "monter", [cond9]);;

let aut7 = ("7", [trans72; trans73; trans75; trans78; trans74; trans76; trans77; trans79; trans80; trans81; trans82; trans84; trans83; trans85; trans86; trans87]);;
let comp7 = ("creuserD", [aut7]);;


(*********************** transition automate escalier ********************)
let trans88 = ("MARCHE", "MARCHE", "marcher", [cond4]);;
let trans89 = ("MARCHE", "ROTATION", "tourner", [cond5]);;
let trans90 = ("MARCHE", "CONSTRUIT", "construire", [cond4; cond17]);;
let trans91 = ("MARCHE", "TOMBE", "tomber", [cond2]);;
let trans92 = ("MARCHE", "MONTE", "monter", [cond9]);;
let trans93 = ("MARCHE", "MORT","mourir", [cond1]);;
let trans94 = ("TOMBE", "MARCHE", "marcher", [cond4]);;
let trans95 = ("TOMBE", "TOMBE", "tomber", [cond2]);;
let trans96 = ("TOMBE", "MORT", "mourir", [cond3; cond4]);;
let trans97 = ("CONSTRUIT", "CONSTRUIT", "construire", [cond4; cond17]);;
let trans98 = ("CONSTRUIT", "CONSTRUIT", "monter", [cond9]);;
let trans99 = ("CONSTRUIT", "RETOUR","retourner", [cond16]);;
let trans100 = ("MONTE", "MONTE", "monter", [cond9]);;
let trans101 = ("MONTE", "CONSTRUIT", "construire", [cond4 ; cond17]);;
let trans102 = ("MONTE", "RETOUR", "retourner", [cond16]);;

let aut8 = ("8", [trans88; trans89; trans90; trans91; trans92; trans93; trans94; trans95; trans96; trans97; trans98; trans99; trans100; trans101; trans102]);;
let comp8 = ("escalier", [aut8]);;




(************************** liste des comportements *************************)
let listcomport = [comp1; comp2; comp3; comp4; comp5; comp6; comp7; comp8];;




(*********************** définiton blocs *********************)
       (* Bord non destructible *)
let bloc1 = (6, 0, 0 , "horizontal", 128);;
let bloc2 = (6, 54,0, "horizontal", 128);;
let bloc3 = (6, 0, 0, "vertical", 55);;
let bloc4 = (6, 0, 127, "vertical", 55);;
		
      (* plateforme de spawn *)
let bloc5 = (2, 6, 1, "horizontal", 20);;
let bloc6 = (2, 7, 1, "horizontal", 20);;
let bloc7 = (2, 8, 1, "horizontal", 20);;

            (* escalier *)
let bloc8 = (4, 5, 9, "horizontal", 1);;
let bloc9 = (4, 4, 10, "vertical", 1);;
let bloc10 = (4, 5, 10, "horizontal", 1);;
let bloc11 = (4, 5, 11, "horizontal", 1);;
		
	      (* gen de la sortie et des deux spawns *)
let bloc12 = (9, 45, 126, "vertical", 4);;
let bloc13 = (8, 1 , 2, "vertical", 5);;
let bloc14 = (8, 5, 125, "vertical", 5);;
		
		(* seconde plateforme *)
let bloc15 = (6, 9, 19, "vertical", 4);;(*//indestructible *)
let bloc16 = (2, 12, 19, "horizontal", 32);;
let bloc17 = (2, 13, 19, "horizontal", 32);;
let bloc18 = (2, 7, 46, "vertical", 6);;
let bloc19 = (2, 7, 47, "vertical", 6);;
let bloc20 = (2, 7, 48, "vertical", 6);;
let bloc21 = (2, 7, 49, "vertical", 6);;
let bloc22 = (2, 7, 50, "vertical", 10);;
let bloc23 = (2, 7, 51, "vertical", 10);;
let bloc24 = (2, 7, 52, "vertical", 10);;
let bloc25 = (2, 7, 53, "vertical", 10);;
let bloc26 = (2, 7, 54, "vertical", 10);;
		
		(* desous map *)
let bloc27 = (2, 14, 21, "horizontal", 29);;
let bloc28 = (2, 15, 23, "horizontal", 27);;
let bloc29 = (2, 16, 25, "horizontal", 25);;

		(* Tube de descente *)
let bloc30 = (2, 7, 60, "vertical", 19);;
let bloc31 = (2, 7, 61, "vertical", 19);;
let bloc32 = (2, 7, 62, "vertical", 19);;
let bloc33 = (6, 7, 63, "vertical", 19);;
		
		(* troisième plateformer *)
let bloc34 = (2, 23, 47, "horizontal", 13);;
let bloc35 = (3, 23, 43, "horizontal", 4);;
let bloc36 = (2, 23, 12, "horizontal", 31);;
let bloc37 = (2, 24, 47, "horizontal", 13);;
let bloc38 = (3, 24, 43, "horizontal", 4);;
let bloc39 = (2, 24, 12, "horizontal", 31);;
let bloc40 = (2, 25, 12, "horizontal", 49);;
let bloc41 = (6, 21, 12, "vertical", 2);;
let bloc42 = (6, 21, 13, "vertical", 2);;
let bloc43 = (6, 26, 26, "horizontal", 38);;
		
		(* 4eme plateforme *)
let bloc44 = (2, 30, 1, "horizontal", 25);;
let bloc45 = (2, 31, 1, "horizontal", 24);;
let bloc46 = (2, 32, 1, "horizontal", 23);;
let bloc47 = (2, 33, 1, "horizontal", 22);;
let bloc48 = (2, 34, 1, "horizontal", 21);;
let bloc49 = (2, 35, 1, "horizontal", 20);;
let bloc50 = (6, 28, 24, "vertical", 2);;
let bloc51 = (6, 28, 25, "vertical", 2);;
		
		
		(* Bas de la map *)		
let bloc52 = (2, 53, 40, "horizontal", 87);;
let bloc53 = (2, 52, 41, "horizontal", 86);;
let bloc54 = (2, 51, 42, "horizontal", 85);;
let bloc55 = (2, 50, 43, "horizontal", 84);;
let bloc56 = (2, 49, 44, "horizontal", 83);;
let bloc57 = (3, 51, 51, "horizontal", 69);;
let bloc58 = (3, 50, 52, "horizontal", 67);;
let bloc59 = (3, 52, 52, "horizontal", 67);;
		
		(* A partir du deuxieme spawn *)
let bloc60 = (2, 10, 110, "horizontal", 17);;
let bloc61 = (2, 11, 110, "horizontal", 17);;
let bloc62 = (2, 12, 110, "horizontal", 17);;
let bloc63 = (2, 3, 100, "vertical", 17);;
let bloc64 = (2, 3, 101, "vertical", 17);;
let bloc65 = (6, 2, 99, "vertical", 19);;
let bloc66 = (2, 2, 102, "vertical", 19);;
let bloc67 = (2, 2, 100, "horizontal", 2);;
let bloc68 = (6, 20, 100, "horizontal", 2);;

		(* deuxieme platefome *)
let bloc69 = (2, 17, 102, "horizontal", 15);;
let bloc70 = (2, 18, 102, "horizontal", 16);;
let bloc71 = (2, 19, 102, "horizontal", 17);;
let bloc72 = (6, 20, 102, "horizontal", 17);;
	
		(* troisieme plateforme *)
let bloc73 = (2, 28, 117, "horizontal", 10);;
let bloc74 = (2, 29, 115, "horizontal", 12);;
let bloc75 = (2, 30, 113, "horizontal", 14);;
let bloc76 = (2, 31, 111, "horizontal", 16);;
let bloc77 = (2, 32, 109, "horizontal", 18);;
let bloc78 = (2, 33, 107, "horizontal", 20);;
let bloc79 = (2, 34, 105, "horizontal", 22);;


(********************** définition boutons  **********************)
let bout1 =( "parapluie", 10);;
let bout2 = ("grimpeur", 10);;
let bout3 = ("bloqueur", 10);;
let bout4 = ("creuseurH", 10);;
let bout5 = ("creuseurV", 10);;
let bout6 = ("creuseurD", 10);;
let bout7 = ("Escalier", 10);;
let bout8 = ("Luciolle", 10);;
let bout9 = ("supp", 10);;



(********************** liste blocs  **********************)
let listbloc=[bloc1;  bloc2;  bloc3;  bloc4;  bloc5;  bloc6;  bloc7;  bloc8;  bloc9;
	      bloc10; bloc11; bloc12; bloc13; bloc14; bloc15; bloc16; bloc17; bloc18; bloc19; 
	      bloc20; bloc21; bloc22; bloc23; bloc24; bloc25; bloc26; bloc27; bloc28; bloc29; 
	      bloc30; bloc31; bloc32; bloc33; bloc34; bloc35; bloc36; bloc37; bloc38; bloc39; 
	      bloc40; bloc41; bloc42; bloc43; bloc44; bloc45; bloc46; bloc47; bloc48; bloc49; 
	      bloc50; bloc51; bloc52; bloc53; bloc54; bloc55; bloc56; bloc57; bloc58; bloc59; 
	      bloc60; bloc61; bloc62; bloc63; bloc64; bloc65; bloc66; bloc67; bloc68; bloc69; 
	      bloc70; bloc71; bloc72; bloc73; bloc74; bloc75; bloc76; bloc77; bloc78; bloc79];;


(********************** liste bouton  **********************)
let listbouton =[bout1; bout2; bout3; bout4; bout5; bout6; bout7; bout8; bout9];;

(******************** ecrire dans le fichier  ****************)
let tout = (contexte,listcomport,listbloc, listbouton);;

ecriretout tout;;

close_out sortie;;






