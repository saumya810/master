package swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by svarshne on 3/26/2017.
 */
public class orderMax
{
    deque_winow dq=new deque_winow();
    List <order> orders=new ArrayList<order>();

    void maintainCostDeque(order o,long k)
    {
        if(dq.start==null)
        {
            dq.insertStart(o.id);
            return;
        }
        deque_winow.Node temp;
        temp=dq.start;
        long minutesdifference=ChronoUnit.MINUTES.between(orders.get(temp.data).orderTime,o.orderTime);
        while(minutesdifference>k)
        {
            dq.removestart();
            temp=dq.start;
            minutesdifference=ChronoUnit.MINUTES.between(orders.get(temp.data).orderTime,o.orderTime);
        }

        temp=dq.end;
        while(temp!=null && o.cost>=orders.get(temp.data).cost)
        {
            dq.removeEnd();
            temp=temp.pre;
        }
        dq.insertEnd(o.id);

    }
    order getOrderWithMaxCostinWindow(LocalDateTime current_time,long k)
    {

        deque_winow.Node temp;
        temp=dq.start;
        long minutesdifference=ChronoUnit.MINUTES.between(orders.get(temp.data).orderTime,current_time);
      //  System.out.println(ChronoUnit.MINUTES.between(orders.get(temp.data).orderTime,current_time));
        //System.out.println(" time difference " + minutesdifference);
        //System.out.println(" queue order time : "+orders.get(temp.data).orderTime);
        System.out.println(" current time : "+current_time);

        while(temp!=null && minutesdifference>=k)
        {

            temp=temp.next;
             if(temp!=null)
            minutesdifference=ChronoUnit.MINUTES.between(orders.get(temp.data).orderTime,current_time);

        }
        if(temp==null)
            return null;
        return orders.get(temp.data);
    }

   public void createOrder (long k) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Enter order name ");
        String orderName=br.readLine();
        System.out.println(" Enter order cost ");
        int orderCost = Integer.parseInt(br.readLine());
        LocalDateTime currentTime = LocalDateTime.now();
        order temporder=new order(orderName,orderCost,currentTime,orders.size());
        orders.add(temporder);
        maintainCostDeque(temporder,k);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Enter the minutes for the maximum cost ");
        long k=Long.parseLong(br.readLine());
        int choice;
        orderMax order1=new orderMax();

      //  LocalDateTime currentTime12 = LocalDateTime.now();
        //int j=0;
        //while(j<1000000)
          //  j++;
       // br.readLine();
      //  LocalDateTime currentTime13 = LocalDateTime.now();
      //  System.out.println(ChronoUnit.MILLIS.between(currentTime12,currentTime13));
        //System.out.println(ChronoUnit.MINUTES.between(currentTime12,currentTime13));
       // System.exit(0);
        while(true)
        {
            System.out.println(" Enter Choice");
            System.out.println("1. Create Order");
            System.out.println("2. Get Order with highest cost");
            System.out.println("3. Exit");
            choice = Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 1: order1.createOrder(k);
                        break;
                case 2: LocalDateTime currentTime = LocalDateTime.now();
                    System.out.println(currentTime);
                    order maxCostOrder=order1.getOrderWithMaxCostinWindow( currentTime ,k);
                    if(maxCostOrder==null)
                    {
                        System.out.println("No order placed");
                        break;
                    }
                    System.out.println(" Maximum cost in window k order details");
                    System.out.println("Order name : "+ maxCostOrder.name);
                    System.out.println("Order cost : "+ maxCostOrder.cost);
                    System.out.println("Order id : "+ maxCostOrder.id);
                    System.out.println("Order time : "+ maxCostOrder.orderTime);
                    break;
                case 3 : System.exit(0);
            }

        }
    }
}
