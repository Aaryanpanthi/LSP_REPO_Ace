package org.howard.edu.lsp.assignment5;

public class Driver {

	public static void main(String[] args) {
		
		
		
		IntegerSet set1 = new IntegerSet();
		//System.out.println("Largest value in Set1 is:"+ set1.largest());
		set1.add(1);
		set1.add(2);
		set1.add(3);
			
			
		System.out.println("value of Set1 is:" + set1.toString());
		System.out.println("Smallest value in Set1 is:" + set1.smallest());
		System.out.println("Largest value in Set1 is:"+ set1.largest());
		
		
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println("Value of Set2 is" + set2.toString());
		//set1.toString();
		set1.complement(set2);
		System.out.println("Value of Set1 after complement is:" + set1.toString());
		System.out.println("Value of Set2 after complement is:" + set2.toString());
		
		
		
		
		set1.add(10);
		set1.add(11);
		set1.add(12);
			
		
		set1.union(set2); 
		
		System.out.println("Value of Set1 after union is:" + set1.toString());
		
		System.out.println(set1.isEmpty());
	
		
		
		set1.diff(set2);
		System.out.println("Value of Set1 after diff is:" + set1.toString());
		set1.add(4);
		
		set1.intersect(set2);
		
		System.out.println("Value of Set1 after intersect is:" + set1.toString());
		System.out.println("Value of Set after intersect is:" + set2.toString());
		
		set1.diff(set2);
		
		System.out.println(set1.isEmpty());

	}

}
