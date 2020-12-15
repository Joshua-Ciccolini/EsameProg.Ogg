package com.esame_prog_meteo.apicall;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class APICall {
	/**
	 * Rappresenta la classe che effettua la chiamata alla API e tramite l'apposito
	 * metodo restituisce la lettura sottoforma di stringa
	 * @author Joshua Ciccolini
	 * @author Michele D' Ercoli
	 */
	private static String APIKey = "19424eeea64914627b18e861c3ae0688";
	
	
	/**
	 * Effettua un chiamata all'API aprendo una connessione impostando come città su cui lavorare il valore passato come parametro
	 * @param city
	 * @return
	 */
	public static String chiama(String city) {
		String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=" + APIKey;
		String lettura = "";
		String line = "";
		try {
			URLConnection connection = new URL(url).openConnection();
			connection.setDoOutput(true);
			InputStream in = connection.getInputStream();
	
				try {
					BufferedReader reader = new BufferedReader( new InputStreamReader(in));
					while((line=reader.readLine()) != null) {
					lettura +=line ;
					}
				}finally{
					in.close();
					}
			}catch(IOException e) {
				e.printStackTrace();
				}
		return lettura;
		}
	
		
		/**
		 * Imposta l'attributo APIKey con il valore passato come parmetro
		 * @param APIKey
		 */
		public void setAPIKey(String APIKey) {
			APICall.APIKey=APIKey;
		}
	}