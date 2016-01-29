package com.danco.anotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PrintableAnalizer {

	public void analizeEntityAndPrint(Object obj) {
		Class <?> c= obj.getClass();
					if(!c.isAnnotationPresent(PrintableObject.class)){
					       System.err.println("no annotation");
					       } else {
					          System.out.println("class annotated ; name  -  " + c.getAnnotation(PrintableObject.class));
					       }        
					
					boolean Printable=false;
					boolean PrintableRef=false;        
				
					for(Field fd: obj.getClass().getDeclaredFields()){
					       if(fd.isAnnotationPresent(Printable.class)){
					    	   Printable=true;
					    	   Annotation an= fd.getAnnotation(Printable.class);
					    	   System.out.println(an);
					    	   }
					       if(fd.isAnnotationPresent(PrintableRef.class)) {
					    	   PrintableRef=true;
					    	   Annotation an= fd.getAnnotation(PrintableRef.class);
					    	   System.out.println(an);
					    	   }
					       if(Printable && PrintableRef){break;}
					}
					System.out.println("Printable annotaton  - " + Printable + ";  Printable ref annotation  - " + PrintableRef );
}	
	
	void printDetaildeView(){
		
	}
	void printshortView(){
		
	}
	
}
		
		
		
		
		
		
/*	

//write all annotation
Annotation annosClass[]= obj.getClass().getAnnotations();
System.out.println("All annotatin for class"+c.getName());
for(Annotation i:annosClass){
	System.out.println(i);
	}
	
	Method[] annosMent=c.getMethods();
	System.out.println("All annotatin for methods:");
	for(Method e:annosMent){
		e.getName();
		System.out.println(e.getAnnotations());
		}
	
		
		Annotation annos[]	=c.getDeclaredAnnotations();
		System.out.println("All annotatin:"+c.getName());
		for(Annotation f:annos){
			System.out.println(f);

			*/
		
		
		/*
		try {
			Method m = c.getMethod("name");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		c.getAnnotations();
		Printable printableA = c.getAnnotation(Printable.class);
		c.getAnnotationsByType(Printable.class);
		
		
		
		
		
		System.out.println(printableA.name()+" "+printableA.isDetailedOnly()+" "+printableA.order());
		System.out.println(" ");
		System.out.println(printableA.toString());
		
		
	*/	
		
		
		
		
		
		
		
	

	/*
	if(!cl.isAnnotationPresent(ControlledObject.class)){
	       System.err.println("no annotation");
	       } else {
	          System.out.println("class annotated ; name  -  " + cl.getAnnotation(ControlledObject.class));
	       }        
	boolean hasStart=false;
	boolean hasStop=false;        
	Method[] method = cl.getMethods();
	for(Method md: method){
	       if(md.isAnnotationPresent(StartObject.class)) {hasStart=true;}
	       if(md.isAnnotationPresent(StopObject.class)) {hasStop=true;}
	       if(hasStart && hasStop){break;}
	}
	System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );
	
	*/
	
	
	/*
	public class TestAnnotationAnalyzer {
	    public void parse(Class<?> clazz) throws Exception {
	        Method[] methods = clazz.getMethods();
	        int pass = 0;
	        int fail = 0;
	 
	        for (Method method : methods) {
	            if (method.isAnnotationPresent(Test.class)) {
	                try {
	                    method.invoke(null);
	                    pass++;
	                } catch (Exception e) {
	                    fail++;
	                }
	            }
	        }
	    }
	}
	*/
	
	/*
	public class TestAnnotationAnalyzer {
	    public void analyz(Class<?> clazz) throws Exception {
	        Method[] methods = clazz.getMethods();
	        int pass = 0;
	        int fail = 0;
	 
	        for (Method method : methods) {
	            if (method.isAnnotationPresent(Test.class)) {
	                // Получаем доступ к атрибутам
	                Test test = method.getAnnotation(Test.class);
	                Class expected = test.expected();
	                try {
	                    method.invoke(null);
	                    pass++;
	                } catch (Exception e) {
	                    if (Exception.class != expected) {
	                        fail++;
	                    } else {
	                        pass++;
	                    }
	                }
	            }
	        }
	    }
	}
	*/
	
	/*
	 *public class Demo {
    public static void main(String [] args) {
        TestAnnotationAnalyzer analyzer = new TestAnnotationAnalyzer();
        analyzer.analyz(MyTest.class);
    }
}
	 */
	 

