package flipkart;

import java.util.HashSet;
import java.util.*;
/**
 * Created by svarshne on 3/20/2017.
 */
public class Group {
    String name;
    int id;
    Set <User> users =new HashSet <User>();
    int [][]record=new int[users.size()][users.size()];
    Set <Bill> bills=new HashSet<Bill>();



}
