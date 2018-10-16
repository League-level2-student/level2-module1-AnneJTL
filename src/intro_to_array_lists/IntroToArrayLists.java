package intro_to_array_lists;

import java.util.ArrayList;
import java.util.List;

public class IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		List<String> stringArray = new ArrayList<>();

		//2. Add five Strings to your list
		stringArray.add("Monday");
		stringArray.add("Tuesday");
		stringArray.add("Wednesday");
		stringArray.add("Friday");
		stringArray.add("Thursday");

		//3. Print all the Strings using a standard for-loop
		System.out.println("Standard for-loop");
		for (int i = 0; i < stringArray.size(); i++) {
			System.out.println(stringArray.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		System.out.println("Standard for-each loop");
		for (String day : stringArray) {
			System.out.println(day);
		}

		//5. Print only the even numbered elements in the list.
		System.out.println("Print only the even numbered elements in the list.");
		for (int i = 0; i < stringArray.size(); i++) {
			if (i % 2 == 0) {
				System.out.println(stringArray.get(i));
			}
		}
		
		//6. Print all the Strings in reverse order.
		System.out.println("Print all the Strings in reverse order.");
		for (int i = stringArray.size(); i > 0; i--) {
				System.out.println(stringArray.get(i-1));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		System.out.println("Print only the Strings that have the letter 'e' in them.");
		for (String day : stringArray) {
			if (day.contains("e")) {
				System.out.println(day);
			}
		}
	}
}
