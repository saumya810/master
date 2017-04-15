//package swiggy;
//
//import java.util.Comparator;
//import java.util.Date;
//import java.util.List;

///**
// * Created by svarshne on 3/26/2017.
// */
//public class orderUtil implements Comparator<order>
//{
//    @Override
//    public int compare(order o1, order o2) {
//       return(o1.orderTime.compareTo(o2.orderTime));
//    }
//
//    int binarySearch(List <order> l1,int start,int end,Date time)
//    {
//        int mid;
//        if(start>end)
//            return -1;
//        mid=start+(end-start)/2;
//        //int num=l1.get(mid).orderTime.compareTo(time);
//        int num=l1.get(mid).orderTime.compareTo(time);
//        if(start==end)
//        {
//            if(num==0)
//        {
//            return start;
//        }
//        else
//        {
//            if(num>0)
//            return start;
//            else
//                return start+1;
//        }
//
//    }
//
//        else if(num>0)
//        {
//           return binarySearch(l1,start,mid,time);
//        }
//        else
//           return  binarySearch(l1,mid+1,end,time);
//
//    }
//
//    int getNearestOrderAfterTime(List<order> l,Date time)
//    {
//        int index=binarySearch(l,0,l.size()-1,time);
//        if(index>=l.size()||index==-1)
//            return -1;
//        else
//            return index;
//    }
//
//    int getNearestOrderBeforeTime(List<order> l,Date time)
//    {
//        int index=binarySearch(l,0,l.size()-1,time);
//        if(index>=l.size())
//            return index-1;
//        else
//        {
//          if(l.get(index).orderTime==time)
//          {
//              return index;
//          }
//          else
//              return index-1;
//        }
//    }
//
//    int createSegmentTreeWithMaxCost(int []B, List<order> l,int start,int end,int current)
//    {
//        if(start==end)
//            B[current]=l.get(start).cost;
//        int mid = start+(end-start)/2;
//        int left=createSegmentTreeWithMaxCost(B,l,start,mid,2*current+1);
//        int right=createSegmentTreeWithMaxCost(B,l,mid+1,end,2*current+2);
//        B[current]=Math.max(left,right);
//        return B[current];
//    }
//
//
//
//    int rangeMaxggCost(int []B,int start,int end, int start1, int end1,int current)
//    {
//        int num;
//        int mid=start+(end-start)/2;
//        if(start<=start1&&end>=end1)
//            return B[current];
//        else if(start)
//    }
//    public static void main(String[] args) {
//
//    }
//}
