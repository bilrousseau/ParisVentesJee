package com.parisventes.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DB {
//	public static final String ARTICLES_FILENAME = "C:\\Users\\Administrateur\\Desktop\\Formation_POEI\\13_ParisVentes\\struts\\src\\main\\webapp\\articles.txt";
//	public static final String PERSON_FILENAME ="C:\\Users\\Administrateur\\Desktop\\Formation_POEI\\13_ParisVentes\\struts\\src\\main\\webapp\\personnes.txt";
//  Sur le PC
	
	public static final String ARTICLES_FILENAME = "/Users/billrouseeau/ParisVentesJee/struts/src/main/webapp/db/articles.txt";
	public static final String PERSON_FILENAME = "/Users/billrouseeau/ParisVentesJee/struts/src/main/webapp/db/personnes.txt";

	public static final String EMAIL_REGEXP = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	
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
