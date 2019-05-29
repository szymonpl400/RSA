package General;

import java.util.ArrayList;
import java.util.Random;

public class Algorithm 
{
	ArrayList<Integer> primaryNumbers;
	private int p;
	private int q;
	private int fi;
	private int n;
	private int e;
	private int d;
	
	public void generatePrimaryNumbers() 
	{
	    int num = 0;
	    int maxCheck = 1500; // maxCheck limit till which you want to find prime numbers
	    boolean isPrime = true;
	
	    //Empty String
	    primaryNumbers = new ArrayList<Integer>();
	
	    //Start loop 1 to maxCheck
	    for (int i = 1024; i <= maxCheck; i++) 
	    {
	        isPrime = CheckPrime(i);
	        if (isPrime) 
	        {
	        	primaryNumbers.add(i);
	        }
	    }
	}
	
	public Algorithm() {}
	
	public boolean CheckPrime(int numberToCheck) 
	{
		if(numberToCheck<2) 
		{
			return false;
		}
	    int remainder;
	    for (int i = 2; i <= numberToCheck / 2; i++) 
	    {
	        remainder = numberToCheck % i;
	        if (remainder == 0) 
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	public void getTwoRnadomPrimaryNumbers() 
	{
		
		for(int i =0; i<2; i++) 
		{	
			Random r=new Random();
			int randomNumber = r. nextInt(primaryNumbers.size());
			if(i==0) 
			{
				p = primaryNumbers.get(randomNumber); 
			}
			else 
			{
				q = primaryNumbers.get(randomNumber);
			}
			
		}
		System.out.println("p: " + p +"\nq: "+ q);
	}
	
	public void calcFiAndN() 
	{
		fi = (p-1) * (q-1);
		n = p * q; 
		
		System.out.println("fi: "+ fi+"\nn: " + n);
	}
	
	public void calcE() 
	{
		int a, b, p;
		a = 1;
		b = 100;
		p = fi;
		int ax,bx,i,t;
		
		for(i = a; i <= b; i++)
		{
			ax = i;
			bx = p;
			while(bx != 0)
			{
			  t  = bx;
			  bx = ax % bx;
			  ax = t;
			}
			if(ax == 1) 
			{
				if(i>1 && i%2!=0) 
				{
					e = i;
					System.out.println("e: " + e);
					break;
				}
			} 
		}
	}
	
	public void calcD() 
	{
		d=0;
		while(d*e%fi!=1) 
		{
			d++;
		} 
		System.out.println("d: " + d);
	}
	
	public void encryptText(String text) 
	{
		String encryptedText = "";
		for(int i = 0; i<text.length(); i++) 
		{
			char letter = text.charAt(i);
			int t = (int)letter;
			int c = (int) (Math.pow(t, e) % n);
			encryptedText+=c;	
		}
		System.out.println(text);
		System.out.println(encryptedText);
	}
}

