package com.parisventes.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DB {
	public static final String ARTICLES_FILENAME = "C:\\Users\\Administrateur\\Desktop\\Formation_POEI\\13_ParisVentes\\ParisVentes\\WebContent\\articles.txt";
	public static final String PERSON_FILENAME = "C:\\Users\\Administrateur\\Desktop\\Formation_POEI\\13_ParisVentes\\ParisVentes\\WebContent\\personnes.txt";

	// private static final String fileName = "/Users/billrouseeau/dev/java_projects/ParisVentes/ParisVentes/WebContent/articles.txt";
	// Sur le Mac
	
	public static Integer getLinesNb(String filePath) {
		Integer nbLines = 0;
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(DB.PERSON_FILENAME));
			
			while (br.ready()) {
				br.readLine();
				nbLines++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nbLines;
	}
}
