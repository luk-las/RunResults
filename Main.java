package RR;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		String choice;
		int runners = 0;		
		String name = "";
		int seconds = 0;
		boolean flag = false;
		LinkedHashMap<String, Integer> dateMap = new LinkedHashMap<>();
		ArrayList<String> resultsList = new ArrayList<>();
		Stack<String, Integer, String> resultsStack;		
		String s0 = "Podaj iloœæ biegaczy: ";
		String s1 = "Dodaj biegacza";
		String s2 = "Wyswietl listê rezultatów";
		String s3 = "Koniec";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Function<String, Integer> transform = (n, s) -> {
			int min = s/60;
			int sec = s - min*60;
			String text;
			if(sec > 9)
				text = dateMap.size()+"."+n+" "+min+":"+sec;
			else
				text = dateMap.size()+"."+n+" "+min+":0"+sec;
			resultsList.add(text);
		};
		
		
		while(!flag) {
			try {
				System.out.print(s0);
				runners = Integer.parseInt(br.readLine());
				flag = true;
			} catch(NumberFormatException nfe) {
			System.out.println("WprowadŸ poprawne dane.");
			}
		}
		
		resultsStack = new Stack<>(dateMap, runners, resultsList);
		
		do {			
			System.out.println("1."+s1+"\n2."+s2+"\n3."+s3);
			System.out.print("Wybierz jedn¹ z powy¿szych czynnoœci: ");
						
			choice = br.readLine();
			if(!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
				System.out.print("\nWprowadz liczbê z zakresu 1..3");
		
			switch(choice) {
				case "1":
					System.out.print("Podaj unikaln¹ nazwê biegacza: ");
					name = br.readLine();
					
					flag = false;
					while(!flag) {
						try {
							System.out.print("Podaj czas w sekundach: ");
							seconds = Integer.parseInt(br.readLine());
							flag = true;
						} catch(NumberFormatException nfe) {
						System.out.println("WprowadŸ poprawne dane.");
						}
					}
					try {
						resultsStack.push(name, seconds);
					} catch(StackFullException sfe) {
						System.out.println(sfe);
					}
					transform.fun(name, seconds);
					break;
				case "2":
					for(int i=0; i<resultsList.size(); i++) {
						try {
							System.out.println(resultsStack.pop());
						} catch (StackEmptyException see) {
							System.out.println(see);
						}
					}
					break;
				case "3":
					System.out.println("Wyszed³eœ z programu.");
					break;
				default:
					break;					
			}
			
			System.out.println();
			
		} while(!choice.equals("3"));		

	}

}
