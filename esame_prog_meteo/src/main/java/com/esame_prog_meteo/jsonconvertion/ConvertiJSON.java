package com.esame_prog_meteo.jsonconvertion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class ConvertiJSON {
	private String str;
	/**
	 * Costruttore della classe che prende come parametro la stringa da convertire in un oggetto JSONArray
	 * @param str
	 */
	public ConvertiJSON(String str) {
		this.str = str;
	}
	/**
	 * Costruttore di default della classe
	 */
	public ConvertiJSON() {}
	/**
	 * Converte la stringa passata come parametro str in un oggetto JSONArray
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static JSONArray converti(String str) throws ParseException {
		JSONObject obj =(JSONObject) JSONValue.parseWithException(str);
		String macro_object= "";
		macro_object= "{\"visibility\":" +(obj.get("visibility").toString());
		macro_object = macro_object.concat(",\"base\":\"" +(obj.get("base").toString())+"\"");
		macro_object = macro_object.concat(",\"dt\":" +(obj.get("dt").toString()));
		macro_object = macro_object.concat(",\"timezone\":" +(obj.get("timezone").toString()));
		macro_object = macro_object.concat(",\"id\":" +(obj.get("id").toString()));
		macro_object = macro_object.concat(",\"name\":\"" +(obj.get("name").toString())+"\"");
		macro_object = macro_object.concat(",\"cod:\"" +(obj.get("cod").toString())+"}");
		JSONObject macro_obj =(JSONObject) JSONValue.parseWithException(macro_object);
		
		JSONArray a= new JSONArray();
		a.add(macro_obj);
		a.add(obj.get("coord"));
		a.add(obj.get("main"));
		a.add(obj.get("wind"));
		a.add(obj.get("clouds"));
		a.add(obj.get("sys"));
		return a;
	}
	/**
	 * Restituisce l'oggetto JSONArray relativo alla striga attributo dell'oggetto stesso
	 * @return
	 * @throws ParseException
	 */
	public JSONArray getJSONArray() throws ParseException {
		return converti(str);
	}
	
	/**
	 * Imposta la variabile str con il valore passato come parametro. Questa stringa potrà essere convertita in oggetto JSON
	 * @param str
	 */
	public void setSringa(String str) {
		this.str=str;
	}
	
	/**
	 * Restuisce la variabile stringa che deve essere convertita in oggetto JSON
	 * @return
	 */
	public String getStringa() {
		return str;
	}
}
