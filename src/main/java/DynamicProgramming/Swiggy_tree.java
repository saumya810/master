package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by svarshne on 3/15/2017.
 */
public class Swiggy_tree {
int length=0;
    class Node
    {
        char data;
        Node next;

        public Node(char data)
        {
            this.data=data;
            this.next=null;
        }
    }


    char getRoot(HashMap<Character,Integer> hdup,HashMap<Character,Integer> h)
    {
        char root='*';
        for(char c :h.keySet())
        {
           if(hdup.get(c)==null&&root!='*')
           {
               return '^';
           }
           else if(hdup.get(c)==null&&root=='*')
           {
               root=c;
           }

        }
      //  System.out.println(root);
        return root;
    }
    void print( List <Node> List1, HashMap<Character,Integer> h,char c)
    {
        System.out.print(c);
        if(h.get(c)==null)
            return;
        else
        {
          Node temp =List1.get(h.get(c)) ;
          print( List1, h,temp.data);
          if(temp.next!=null)
              print( List1, h,temp.next.data);

        }
    }

    int creatTree(char A,char B, List <Node> List1, HashMap<Character,Integer> h,HashMap<Character,Integer> hdup)
    {
        int num=0;
        if(hdup.get(B)!=null)
        {
            num=3;
        }
        else
            hdup.put(B,0);
        if(h.get(A)!=null)
        {
            Node temp=List1.get(h.get(A));
            if(temp.next!=null)
            {
                num=1;
                return num;
            }

            else
           {
            if(temp.data==B)
            {
                num=2;
                return num;
            }

            else if(num==0)
            {
               temp.next =new Node(B);
            }
           }
        }
        else if(num==0)
        {
            List1.add(length,new Node(B));
            h.put(A,length);
            length++;
        }
        else
            return num;
        return 5;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        List <Node> List1=new ArrayList<Node>();
        HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
        HashMap<Character,Integer> hdup=new HashMap<Character,Integer>();
        Swiggy_tree ob=new Swiggy_tree();
        int num=0;
        for(int i =0;i<str.length;i++)
        {
             num=ob.creatTree(str[i].charAt(1),str[i].charAt(3),List1,hmap,hdup);
            if(num!=5) {
                System.out.print(num);
                break;
            }

        }
        if(num==5)
        {
            char root=ob.getRoot(hdup,hmap);
            //System.out.println(root);
            if(root=='^'||root=='*')
                System.out.print('4');
            else
            {
                ob.print(List1,hmap,root);
            }
            //System.out.println(num);
        }
        {

        }

    }
}
