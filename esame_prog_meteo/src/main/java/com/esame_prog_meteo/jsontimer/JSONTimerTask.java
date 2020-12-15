package com.esame_prog_meteo.jsontimer;

import java.util.TimerTask;
import com.esame_prog_meteo.jsonconvertion.ConvertiJSON;
import com.esame_prog_meteo.apicall.APICall;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


public class JSONTimerTask extends TimerTask{
	private JSONArray a = new JSONArray();
	private String city;
	 /**
	  * Costruttore della classe. Richiede come parametro la città su cui fare la lettura;
	  * @param city
	  */
	public JSONTimerTask(String city) {
		this.city=city;
		run();
	}
	
	/**
	 * Implementazione del metodo astratto di TimerTask. Il corpo viene eseguito quando viene creato un nuovo oggetto TimerTask
	 */
	public void run(){
		try {
			a.add(ConvertiJSON.converti(APICall.chiama(city)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Restituisce l'array contentente la chiamata all'API
	 * @return
	 */
	public JSONArray getJSONArray() {
		return a;
	}
	/**
	 * Imposta l'attributo privato city con il valore passato come parametro 
	 * @param city
	 */
	public void setCity(String city) {
		this.city=city;
	}
	
	/**
	 * Restituisce il contenuto dell'attributo privato
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
}
