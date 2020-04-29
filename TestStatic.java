package com.example.demo.thread;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

interface Test {
	void print();
}
interface Test1 {
	void print();
}
public class TestStatic implements Test {
	
    public static TestStatic test ;
	static {
		System.out.println("Working");
    	test = new TestStatic();
    	List<String> s = new LinkedList<>();
    	Test t1 = new TestStatic();
    	t1.print();
    	Test t2 = new TestStatic();
    	t2.print();
    }
	
	static void ShowDetails(Map<Integer, String> map, String mapName){  
        System.out.println("----------"+mapName+" records-----------");  
        map.forEach((key, val)->System.out.println(key+" "+val));  
    } 
	public static void main(String[] args) {
		Test t = () ->  System.out.println("Hello ");
		t.print();
		test.print();
		
		
	   
	        Map<Integer, String> map = new HashMap<Integer,String>();  
	        map.put(100, "Mohan");  
	        map.put(110, "Sujeet");  
	        map.put(115, "Tom");  
	        map.put(120, "Danish");  
	        // Referring method  
	        BiConsumer<Map<Integer, String>, String> biCon = TestStatic::ShowDetails;  
	        
	        biCon.andThen(biCon);
	        biCon.accept(map, "Student");  
		
	}
    public void print() {
    	System.out.println("Yes "); 
    	
    }
}
