import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class eat_or_not {
    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s+");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=getBufferedReader();
        String line=br.readLine();
        String a[]=getSplitSpace(line);
        int b[]=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i]=getIntegerFromString(a[i]);
        }
        line=br.readLine();
        int n=getIntegerFromString(line);
        int[][] c=new int[n][4];
        for (int i = 0; i < n; i++) {
            line=br.readLine();
            String s[]=getSplitSpace(line);
            for (int j = 0; j < 4; j++) {
                c[i][j]=getIntegerFromString(s[j]);
            }
        }
        System.out.println(printResult(n, b,c));
    }

    private static String printResult(int n, int [] diet, int[][] fruits) {
    	
    	int[][] a0=new int[n][diet[0]];
    	int[][] a1=new int[n][diet[1]];
    	int[][] a2=new int[n][diet[2]];
    	int[][] a3=new int[n][diet[3]];
    	
    	
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<diet[0];j++)
    		{
    			if(i==0&& fruits[i][0]==j)
    				a0[i][j]=1;
    			else
    			{
    			//	if()
    			}
    		}
    	}
    }
}