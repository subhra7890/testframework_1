package Automation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class mytest1 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> al= new ArrayList<Integer>();
		al.add(1200);
		al.add(36);
		al.add(1);
		al.add(80);
		
		System.out.println("Before sorting");
		for(Integer counter: al) {
			System.out.println(counter);
		}
		
		Collections.sort(al);
		
		System.out.println("After sorting");
		for(Integer counter: al) {
			System.out.println(counter);
		}
		
		ArrayList<Double> al2= new ArrayList<Double>();
		al2.add(1200.96);
		al2.add(85.36);
		al2.add(1.25);
		al2.add(80.00);
		
		System.out.println("Before sorting");
		for(Double counter: al2) {
			System.out.println(counter);
		}
		
		Collections.sort(al2);
		
		System.out.println("After sorting");
		for(Double counter: al2) {
			System.out.println(counter);
		}
	
	
		
		
	}
	

}
