package jus.ricm.gestionBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jus.ricm.contexte.Contexte;
import jus.ricm.interpreteur.ParserXML;



public class BoutonReset implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Contexte.init_contexte();
		Contexte.init = System.currentTimeMillis();
		ParserXML parser = new ParserXML(Contexte.nomFich);
		
	}

}
