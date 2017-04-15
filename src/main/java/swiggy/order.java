package swiggy;

import java.util.Date;
import java.time.*;

/**
 * Created by svarshne on 3/26/2017.
 */
public class order {
    int cost;
    LocalDateTime orderTime;
    int id;
    String name;

    public order(String name , int cost, LocalDateTime time, int id)
    {
        this.name=name;
        this.cost=cost;
        this.orderTime=time;
        this.id=id;
    }

}
