package utils.tree;

/**
 * Created by svarshne on 3/29/2017.
 */
public class heap
{

    int leftchild(int i,int n)
    {
        if(2*i+1<n)
            return 2*i+1;
        else
        {
            return -1;
        }
    }
    int rightchild(int i,int n)
    {
        if(2*i+2<n)
            return 2*i+2;
        else
            return -1;
    }

    int parent(int i)
    {
        if((i-1)/2>=0)
        {
            return (i-1)/2;
        }
        else
        {
            return -1;
        }


    }
    void heapify(int []A,int i,int n)
    {
        int max=i;
        if(i>=n)
            return;
        int left_child = leftchild(i,n);
        int right_child = rightchild(i,n);
        if(left_child!=-1&&A[i]<A[left_child])
            max=left_child;
        if (right_child!=-1&&A[max]<A[right_child])
            max=right_child;
        int temp=A[i];
        A[i]=A[max];
        A[max]=temp;
        if(max!=i)
        {
            heapify(A,max,n);
        }


    }

    void createHeap(int []A,int n,int i)
    {
        if(i>=n)
            return;
        int left_child=leftchild(i,n);
        int right_child=rightchild(i,n);
       if(left_child==-1&&right_child==-1)
            return;
        if(left_child!=-1)
            createHeap(A,n,left_child);
        if(right_child!=-1)
            createHeap(A,n,right_child);
         heapify(A,i,n);
    }

    void heapsort(int []A,int n)
    {
        createHeap(A,n,0);
        int temp;
        for(int i=0;i<n;i++)
        {
            temp=A[n-1-i];
            A[n-1-i]=A[0];
            A[0]=temp;
            heapify(A,0,n-i-1);
        }
    }
    void print(int []A)
    {
        for(int i=0;i<A.length;i++)
        {
            System.out.print(" "+A[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int A[]={5,3,1,2,4,0,9};
        heap h=new heap();
        h.heapsort(A,A.length);
        h.print(A);
    }
}