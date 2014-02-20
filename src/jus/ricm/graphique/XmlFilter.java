package jus.ricm.graphique;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XmlFilter extends FileFilter {

	@Override
	public boolean accept(File arg0) {
		if(arg0.isDirectory())
		{
			return true;
		}
		 String extension = ExtensionFilter.getExtension(arg0);
	        if (extension != null) {
	            if (extension.equals(ExtensionFilter.xml)) {
	                    return true;
	            } else {
	                return false;
	            }
	        }

	        return false;
	    }


	@Override
	public String getDescription() {
		return "Fichier XML";
	}

	
}
