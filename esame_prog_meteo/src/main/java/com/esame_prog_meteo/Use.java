package com.esame_prog_meteo;

import com.esame_prog_meteo.jsontimer.JSONTimer;
import com.esame_prog_meteo.exception.InvalidNameException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


public class Use {

	public static void main(String[] args) {
		
		JSONTimer timer = new JSONTimer(30000);
		Scanner in = new Scanner(System.in);
		boolean ok=false;
		JSONArray a = null;
		while(!ok) {
		try {
			ok=true;
			System.out.print("Inserire la città su cui fare la ricerca: ");
			String city= in.nextLine();
		a = timer.schedulaArray(city);
		}catch(InvalidNameException e) {
			in.nextLine();
			ok = false;
			System.out.println(e);
		}}
		while(true) {
			System.out.print("Vuoi stampare?[y/n]");
			if(in.next().charAt(0) == 'y') {
				for(Object b: a) System.out.println(b);
			}
		}
	}

}
