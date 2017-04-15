package swiggy;

/**
 * Created by svarshne on 3/24/2017.
 */
public class deque_winow
{
    class Node
    {
        Node pre;
        Node next;
        int data;

        public Node(int num)
        {
            this.data=num;
            this.pre = null;
            this.next=null;
        }
    }
    Node start;
    Node end;

    public void insertStart(int i)
    {
        Node temp;
        if(start==null)
        {
            start=new Node(i);
            end = start;
        }
        else
        {
            temp=start;
            start=new Node(i);
            start.next=temp;
            temp.pre=start;
        }
    }

    public void insertEnd(int i)
    {
        Node temp;
        if(start==null)
        {
            start=new Node(i);
            end = start;
        }
        else
        {
            temp=end;
            end=new Node(i);
            temp.next=end;
            end.pre=temp;
        }

    }

    int getStart()
    {
        return start.data;
    }
    int getEnd()
    {
        return end.data;
    }

    void removestart()
    {
        if(start==end)
        {
            start=null;
            end = null;
        }
        else
        {
            start=start.next;
            start.pre=null;
        }

    }

    void removeEnd()
    {
        if(start==end)
        {
            start=null;
            end = null;
        }
        else
        {
            end=end.pre;
            end.next=null;
        }

    }

}
