package mavenjava;

import org.testng.annotations.Test;

public class Login {
	 @Test
     public void shouldAnswerWithTrue2()
     {
        System.out.println("test seven executed");
        int flag=0;
        for(int n=2;n<100;n++) {
        	for(int j=2;j<Math.sqrt(n);j++) {
        		if(n%j==0) {
        			flag=1; break;
        			}
   
        	}
        	if(flag==0) {
            	System.out.println(" "+n);
            }
        }     
     }

     
     @Test
     public void shouldAnswerWithTrue3()
     {
        System.out.println("test eight executed");
     }
}
