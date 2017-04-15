package FamousProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by svarshne on 3/15/2017.
 */
public class robotpath {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int x=0,y=0,num=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='G')
            {
                if(num==0)
                {
                    y=y+1;
                }
                else if(num==1)
                {
                    x=x-1;
                }
                else if(num==2)
                {
                    y=y-1;
                }
                else if(num==3)
                {
                    x++;
                }

            }
            else
            {
                num=(num+1)%4;
            }
        }

        if(x==0&&y==0)
        {
            System.out.println("yes");
        }
        else
            System.out.println("No");

    }
}
