package DynamicProgramming;

public class Longest_valid_paranthesis {

	public int long_valid_end(int start,String a)
	{
		int s=a.length()-1;
		int num=0;
		int length =0;
		
		for(int i=a.length()-1;i>=start;i--)
		{
			if(a.charAt(i)=='(')
			{
				num--;
				if(num<0)
				{
					num=0;
					s=i;
					s--;
				}
					
				else if(num==0)
				{
					length=Math.max(length, s-i+1);
				}
			}
			else
			{
				num++;
			}
		}
		return length;
		
	}
	public int longestValidParentheses(String a) {
		
		int start=0;
		int num=0;
		int length=0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==')')
			{
				
				num--;
				//
				if(num<0)
				{
					//System.out.println(num +" length "+length);
					num=0;
					start=i;
					start++;
				}
					
				else if(num==0)
				{
					
					length=Math.max(length, i-start+1);
					//System.out.println(num +" length "+length);
				}
			}
			else
			{
				num++;
				//System.out.println(num+" "+length);
			}
		}
		if(num>0)
		{
			length=Math.max(length,this.long_valid_end(start,a));
		}
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Longest_valid_paranthesis ob1=new Longest_valid_paranthesis();
		String a="()()";
		System.out.println(ob1.longestValidParentheses(a));

	}

}
