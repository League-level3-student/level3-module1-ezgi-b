package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> arrlst = new ArrayList<String>();
		//   Don't forget to import the ArrayList class
		
		//2. Add five Strings to your list
		arrlst.add("Ariell");
		arrlst.add("Baylor");
		arrlst.add("Cathy");
		arrlst.add("Donald");
		arrlst.add("Ezra");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < arrlst.size(); i++) {
			System.out.println(arrlst.get(i));
		}
		System.out.println("\n");
		//4. Print all the Strings using a for-each loop
		for(String j: arrlst) {
			System.out.println(j);
		}
		System.out.println("\n");
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i < arrlst.size(); i++) {
			if(i%2==0) {
				System.out.println(arrlst.get(i));
			}
		}
		System.out.println("\n");
		//6. Print all the Strings in reverse order.
		for(int i = arrlst.size()-1; i >=0 ; i--) {
			System.out.println(arrlst.get(i));
		}
		
		//7. Print only the Strings that have the letter 'e' in them.
		System.out.println("\n");
		for(int i = 0; i < arrlst.size(); i++) {
			if(arrlst.get(i).toLowerCase().contains("e")) {
				System.out.println(arrlst.get(i));
			}
		}
	}
}
