package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by svarshne on 3/15/2017.
 */
public class all_subset
{
    Stack <Character> s=new Stack<Character>();

    void print_stack()
    {
        for(char s1:s)
        {
            System.out.print(s1);
        }
        System.out.println();
    }
    void print(String str,int i)
    {
        if(i==str.length())
        {
            this.print_stack();
            return;
        }
        this.s.push(str.charAt(i));
        print(str,i+1);
        s.pop();
        print(str,i+1);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        all_subset ob=new all_subset();
        ob.print(str,0);


    }
}
