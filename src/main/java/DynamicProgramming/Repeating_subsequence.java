package DynamicProgramming;

public class Repeating_subsequence {

	public int anytwo(String a) {
		
		int num;
		int n=a.length();
		int [][]A=new int[n][52];
		num=(a.charAt(n-1)<'a') ? a.charAt(n-1)-'A' : a.charAt(n-1)-'a'+26;
		
		A[n-1][num]=n-1;
		for(int i=n-2;i>=0;i--)
		{
			
		 for(int j=0;j<52;j++)
		 {
			 A[i][j]=A[i+1][j];
		 }
		 
		 
		 num=(a.charAt(i)<'a') ? a.charAt(i)-'A' : a.charAt(i)-'a'+26;
		
				A[i][num]=i;
			}
		
		int num2;
		for(int i=0;i<n-2;i++)
		{
			for(int j=i+1;j<=n-2;j++)
			{
				 num=(a.charAt(i)<'a') ? a.charAt(i)-'A' : a.charAt(i)-'a'+26;
				 num2=(a.charAt(j)<'a') ? a.charAt(j)-'A' : a.charAt(j)-'a'+26;
				if(A[i+1][num]==0)
					break;
			int k=i+1;
			int loci=A[k][num];
			if(loci==n-1)
			continue;
			if(A[k][num]!=0&&A[k][num2]!=0)
					{
						if(A[loci+1][num2]==j)
							loci=j;
						if(loci>n-1)
							continue;
						if(A[loci+1][num2]!=0)
						{
							return 1;
						
						}
							
					}
						
					 
				
				
			}
		}
		
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repeating_subsequence ob1=new Repeating_subsequence();
		System.out.println(ob1.anytwo("aaa"));

	}

}
