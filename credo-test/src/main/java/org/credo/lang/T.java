package org.credo.lang;


public class T {
	public static void main(String[] args) {

		int batchSize = 100;
        
		int i = 0;
		
		  while(true){
			  System.out.println(i);
			  if( i % batchSize  == 0 ){
				  i++;
				  System.out.println(i);
                 System.out.println("1111");
            } 
		  }
	}
}
