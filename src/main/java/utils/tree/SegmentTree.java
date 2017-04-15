package utils.tree;

/**
 * Created by svarshne on 3/29/2017.
 */
public class SegmentTree {
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

    int createSegmentTree(int start,int end,int i,int []A,int []B)
    {
        int mid = start+(end-start)/2;
        if(start==end)
            B[i]=A[start];
        else
        {
            int left = createSegmentTree(start,mid,leftchild(i,B.length),A,B);
            int right = createSegmentTree(mid+1,end,rightchild(i,B.length),A,B);
            B[i]=left+right;
        }
        return B[i];
    }

    int rangeQuery(int start,int end,int i,int querystart,int queryend,int []A,int [] B)
    {
        int mid=start+(end-start)/2;
        if(querystart<=start&&queryend>=end)
            return B[i];
        else if(querystart>end||queryend<start)
            return 0;
        else if(queryend<=mid)
        {
            return rangeQuery(start,mid,leftchild(i,B.length),querystart,queryend,A,B);
        }
        else if(querystart>mid)
        {
            return rangeQuery(mid+1,end,rightchild(i,B.length),querystart,queryend,A,B);
        }

        else
        {
            return rangeQuery(start,mid,leftchild(i,B.length),querystart,mid,A,B)+rangeQuery(mid+1,end,rightchild(i,B.length),mid+1,queryend,A,B);
        }
    }

    public static void main(String[] args) {
        int []A={1,2,3,4,5,6,7};
        SegmentTree ob=new SegmentTree();
        int []B=new int [2*A.length-1];
        ob.createSegmentTree(0,A.length-1,0,A,B);
        System.out.println(ob.rangeQuery(0,A.length-1,0,1,5,A,B));
    }

}
