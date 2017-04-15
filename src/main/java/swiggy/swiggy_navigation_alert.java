package swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.LocalDateTime;
import java.io.FileReader;
/**
 * Created by svarshne on 3/27/2017.
 */


public class swiggy_navigation_alert {

    float getDistance(Location l1, Location l2)
    {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(l2.lati-l1.lati);
        double dLng = Math.toRadians(l2.longi-l1.longi);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(l1.lati)) * Math.cos(Math.toRadians(l2.lati)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

    int direction(Location l1, Location l2, Location l3)
    {
        if(l1==null)
        {
          return 1;
        }
       else if(l3==null)
        {
            return 5;
        }
        double angle = this.getangle(l1,l2,l3);
      //  System.out.println("angle == "+angle);
        if (angle<0)
        {
            angle=Math.abs(angle);
            angle=360-angle;
        }

        if(angle>190)
            return 0;
        if(angle>175&&angle <185)
            return 1;
        else return 2;

    }

    String getTimeAftersomeMinutes(LocalDateTime currentTime,long minutes)
    {
        LocalDateTime time=currentTime.plusMinutes(minutes);
     //   System.out.println(" added time "+time);
        return time.toString();
    }

    void printDirection(int i)
    {
        switch (i)
        {
            case 0 :
                System.out.print(" Turn left and move for ");
                break;
            case 1:
                System.out.print(" Go forward nad move for ");
                break;
            case 2:
                System.out.print(" Turn right and move for ");
                break;
            case 3:
                System.out.print(" Take U turn and move for ");
        }
    }

    double getangle(Location l1,Location l2,Location l3)
    {


        return Math.toDegrees(Math.atan2(l3.lati - l2.lati,l3.longi - l2.longi)-
                Math.atan2(l1.lati- l2.lati,l1.longi- l2.longi));
    }

    void navigation_alert(List <Location> l,LocalDateTime currentTime, int speed)
    {

        LocalDateTime currentTime1=currentTime;
       // LocalDateTime time1=currentTime1;
        Location loc1=null;
        Location loc2;
        Location loc3;
        int distance;
        loc2=l.get(0);
        loc3=l.get(1);
        String temp1=currentTime.toString();
        for(int i=1;i<=l.size()-1;i++)
        {

            loc2=l.get(i-1);
            loc3=l.get(i);
            System.out.print(temp1+ " : ");
            this.printDirection(this.direction(loc1,loc2,loc3));
            System.out.print(this.getDistance(loc2,loc3)+ " meters ");
            System.out.println();
            float minutes=(this.getDistance(loc2,loc3)/speed);
            temp1= (this.getTimeAftersomeMinutes(LocalDateTime.parse(temp1),(int)minutes));
             loc1=loc2;
        }
        System.out.println(temp1 +" :  Reached to destination");


    }

    List<Location> readCSV(String file_location) throws IOException
    {
        BufferedReader br=null;
        String line="";
        String cvsSplitBy = ",";
        List <Location> l=new ArrayList <Location>();
        try {

            br = new BufferedReader(new FileReader(file_location));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] location = line.split(cvsSplitBy);
                l.add(new Location(Long.parseLong(location[0]),Long.parseLong(location[1])));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return l;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       // String csvFile = "/Users/mkyong/csv/country.csv";
        LocalDateTime currentTime=LocalDateTime.now();
        swiggy_navigation_alert ob=new swiggy_navigation_alert();
        System.out.println(" Enter speed");
        String str=br.readLine();
        int speed = Integer.parseInt(str);
        List <Location> list;
        list = ob.readCSV("C:/Users/svarshne/Desktop/swiggy.csv");
        ob.navigation_alert(list,currentTime,speed);
        //System.out.println( ob.getangle(list.get(0),list.get(1),list.get(2)));



    }
}
