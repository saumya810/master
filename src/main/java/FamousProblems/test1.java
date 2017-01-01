package FamousProblems;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
//bank bazaar first question
public class test1 {


	
public static void main(String [] arg)
{
	
	int n=9999;
	int []A=new int[n+1];
	A[0]=0;
    A[1]=1;
	A[2]=2;
    BigInteger fact= BigInteger.ONE;
	int facnum=0;
	 
	for(int i=3;i<=n;i++)
	{
		facnum++;
		
		fact = fact.multiply(new BigInteger(String.valueOf(facnum)));
		
		//fact=fact*facnum;
		//System.out.println(fact);
		//fact=fact.subtract(BigInteger.ONE);
		//if(fact.divide(new BigInteger(Integer.toString(i))).equals(BigInteger.ZERO)){
		if(fact.mod(new BigInteger(Integer.toString(i))).equals(BigInteger.ONE)){
			A[i]=A[i-1]+1;
		//	System.out.println("num ----"+i+" factorial "+facnum);
		}
			
		else
         A[i]=A[i-1];
		
	}
	
	System.out.println(A[n]);
}
}