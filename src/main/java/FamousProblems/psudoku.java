package FamousProblems;

/**
 * Created by svarshne on 3/2/2017.
 */
public class psudoku {
    //int [][]A={{0, 6, 0, 3, 1, 5,2,7,0}, {3, 5, 0, 8, 0, 7,9,0,6},{0, 0, 0, 0, 0, 9,0,5,1},{6, 4, 0, 0, 8,3,1,2,7},{2, 0, 0, 4, 0, 1,0,0,9},{9, 1, 8, 2, 7, 0,0,3,4},{1, 8, 0, 7, 0, 0,0,0,0},{5, 0, 3, 1, 0, 4,0,8,2},{0, 2, 4, 5, 9, 8,0,1,0}};
    int [][]A={{6, 0, 0, 5, 0, 0,3,0,0}, {0, 0, 0, 0, 0, 7,0,1,0},{0, 2, 0, 0, 0, 0,0,0,9},{3, 0, 0, 0, 0,4,0,5,0},{0, 1, 0, 0, 9, 0,7,0,0},{0, 0, 0, 2, 0, 0,0,0,8},{0, 8, 0, 0, 3, 0,0,4,0},{5, 0, 0, 6, 0, 0,0,0,0},{0, 0, 7, 0, 0, 0,0,0,2}};

    void print(int [][]A)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(" "+A[i][j]);
            }
            System.out.println();
        }
    }

    boolean valid(int i,int j,int num)
    {
       return ((horizontal(i,j,num)&&vertical(i, j, num))&&box(i, j, num));
    }
    boolean horizontal(int i,int j,int num)
    {
       // System.out.println(" in hori i "+i+"j "+j+" num : "+num);

        for(int j1=0;j1<9;j1++)
        {

            if(A[i][j1]==num)
                return false;
        }
        return true;
    }

    boolean vertical(int i , int j,int num)
    {
        //System.out.println(" in vert i "+i+"j "+j);

        for(int j1=0;j1<9;j1++)
        {

            if(A[j1][j]==num)
                return false;
        }
        return true;
    }

    boolean box(int i, int j,int num)
    {
        //System.out.println(" in box i "+i+"j "+j);

        int i1=i/3;
       int j1=j/3;
       for(int i2=i1*3;i2<3*(i1+1);i2++)
       {
           for(int j2=j1*3;j2<3*(j1+1);j2++)
           {
               if(A[i2][j2]==num)
                   return false;
           }
       }
       return true;

    }
    int nexti(int i,int j)
    {
        //System.out.println(" in next i "+i+"j "+j);
         if(j==8)
             return i+1;
         else
             return i;
    }
    int nextj(int i,int j)
    {
         if(j==8)
             return 0;
         else
             return j+1;
    }

    boolean bt(int i,int j)
    {
        //System.out.println(" in bt i = "+i+"  j = "+j);
        if(i>8||j>8)
            return true;
        boolean temp;

        if(A[i][j]!=0)
        {
          Boolean temp1=bt(nexti(i,j),nextj(i,j));
          if(i==0&&j==0)
              print(A);
            return(temp1);
        }
        else
        {
            for(int num=1;num<=9;num++)
            {

                if(valid(i,j,num))
                {
                    A[i][j]=num;
                 //  System.out.println("A[i][j] : i "+i+ " j    : "+j+"   A[i][j] = "+A[i][j]);
                    temp=bt(nexti(i,j), nextj(j,j));
                    if(temp==true)
                    {
                        if(i==0&&j==0)
                            print(A);
                        return true;
                    }


                }


            }
            A[i][j]=0;
            return false;
        }



    }


    public static void main(String[] args) {
        psudoku o=new psudoku();
        o.bt(0,0);
    }
}