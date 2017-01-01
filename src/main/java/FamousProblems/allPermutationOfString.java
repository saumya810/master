package FamousProblems;

import java.util.*;

public class allPermutationOfString {
	Stack <Integer> s=new Stack <Integer>();
	char [] charArray=new char [5];
	

	public boolean ifPresentInStack(int i,int length){
		int j=s.search(i);
		if(j==-1){
			return false;}
		else{
			 return true;}
		
	}
	//test
	public void printStack()
	{
		for(int i=0;i<s.size();i++)
		{
			System.out.print(charArray[s.get(i)]);
		}
	}
	public void printPermutation(int i,int length)
	{
		if(i==length){
			this.printStack();
			System.out.print(" ");
			
			return;
		}
			
		for(int j=0;j<length;j++)
		{
			if(!this.ifPresentInStack(j, length))
			{
				//System.out.print(charArray[j]);
				s.push(j);
				this.printPermutation(i+1, length);
				//if(i==length-1)
					//this.printStack();
				s.pop();
				if(j<length-1&&charArray[j]==charArray[j+1])
					j++;
			}
			
		}
		
			
	}
	
	public static void main(String [] str)
	{
		allPermutationOfString ob1=new allPermutationOfString();	
		ob1.charArray[0]='A';
		ob1.charArray[1]='B';
		ob1.charArray[2]='B';
		ob1.charArray[3]='C';
		ob1.printPermutation(0, 4);
		
	}
	
}
