package org.howard.edu.lsp.assignment2;


import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;





public class Etl_Pipleline {
	private static List<String[]> productData = new ArrayList<>();
	
	

	public static void transformData() {
		for (int i=0; i<productData.size();i++) {
			String[] product = productData.get(i);
			
			
			//Applying a 10% discount to products in Electronic Category
			double price = Double.parseDouble(product[2]);
		
			
			if (product[3].equals("Electronics")) {
				price *= 0.9;
			
				
				//Discount is applied, rounding the price down
				// Code help from stack overflow https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java 
				price = (double) Math.round(price * 100) / 100;
				product[2] = String.valueOf(price); 
			
			}
				
			// Converting  all product names to Uppercase
			product[1]= toUpperCase(product[1]);
		
			
			//Category Adjustments 
			if (price > 500) {
                product[3] = "Premium " + product[3];
            }
			
			
		
			//Name Standardization
			product[1]= toTitleCase(product[1]);
			System.out.println("11111");
			System.out.println(product[1]);
			
			
			
			//Price Ranges 
			String priceRange =  calculatePriceRange(price);
			System.out.println(priceRange);
			String[] newProduct = new String[product.length +1];
			System.arraycopy(product,0,newProduct,0, product.length);
			newProduct[product.length] = priceRange;
			productData.set(i,newProduct);
			
			

		}
		
	}
	
	private static String calculatePriceRange(double price) {
		if (price>=0 && price <=10) return "Low";
		if (price>10 && price <=100) return "Medium";
		if (price>100 && price<=500) return "High";
		return "Premium";

		}
	
	private static String toUpperCase(String input) {
		if (input == null || input.isEmpty()) return input;
		
		String uppercase  = input.toUpperCase();
		return uppercase;
		
	}
	
	
	// Inspiration for using String Builder https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
//	private static String toTitleCase(String input) {
//		if (input == null || input.isEmpty()) return input;
//		
//		String[] words = input.split(" ");
//		StringBuilder capitalized = new StringBuilder();
//		
//		for (String word : words) {
//			capitalized.append(word.substring(0,1).toUpperCase());
//			capitalized.append(word.substring(1).toLowerCase());
//			capitalized.append(" ");
//		}
//		
//		return capitalized.toString().trim();
//		
//	}
//	
	
	

	
	public static void processFile() {
        try {
            File myObj = new File("data/products.csv");
            Scanner myReader = new Scanner(myObj);

            // Skipping the titles
            if (myReader.hasNextLine()) {
                myReader.nextLine();
            }

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                productData.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
	
	
	

	public static void outputFile() {
		
		  try (FileWriter writer = new FileWriter("data/transformed_products.csv")) {
	           
	            writer.write("ProductID,Name,Price,Category,PriceRange\n");
	            
	          
	            for (String[] product : productData) {
	                StringBuilder sb = new StringBuilder();
	                for (String field : product) {
	                    sb.append(field).append(",");
	                }
	              
	                sb.deleteCharAt(sb.length() - 1);
	                sb.append("\n");
	                writer.write(sb.toString());
	            }
	        } catch (IOException e) {
	            System.err.println("Error: Could not write to the output file.");
	            e.printStackTrace();
		
		}
	}
	
	
	
	
	
	public static void main(String[] args){
		processFile();
		transformData();
		outputFile();
		
	}

}
