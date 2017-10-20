package com.alpharooms.Concepts;

import java.util.ArrayList;
import java.util.List;

public class Concept_Collections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> ls = new ArrayList<String>();
		ls.add("Apple");
		ls.add("Grapes");
		ls.add("Orange");
		
		for(String item :ls){
			System.out.println(item);
		}
		
	//ls.forEach(item -> System.out.println(item));
	}

}
