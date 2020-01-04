package ex;
import gridsim.*;
import gridsim.net.*;
import java.util.*;
public class NetEx01
{
    /**
     * Creates main() to run this example
     */
    public static void main(String[] args)
    {
        System.out.println("Starting network example ...");
        try
        {
            //////////////////////////////////////////
            // First step: Initialize the GridSim package. It should be called
            // before creating any entities. We can't run this example without
            // initializing GridSim first. We will get run-time exception
            // error.
            int num_user = 4;   // number of grid users
            Calendar calendar = Calendar.getInstance();
            boolean trace_flag = false;  // mean trace GridSim events
            double min;
            // Initialize the GridSim package without any statistical
            // functionalities. Hence, no GridSim_stat.txt file is created.
            System.out.println("Initializing GridSim package");
            GridSim.init(num_user, calendar, trace_flag);
            //////////////////////////////////////////
            // Second step: Creates a physical link
            double baud_rate = 100; // bits/sec
            double propDelay = 10;   // propagation delay in millisecond
            int mtu = 50;          // max. transmission unit in byte
            Link link1 = new SimpleLink("link", baud_rate, propDelay, mtu);
            Link link2 = new SimpleLink("link", baud_rate, propDelay, mtu);
            Link link3= new SimpleLink("link", baud_rate, propDelay, mtu);
            // OR ...
            // use a default value
            // Link link = new SimpleLink("link");
            //////////////////////////////////////////
            // Third step: Creates one or more entities.
            // This can be users or resources. In this example,
            // we create user's entities only.
            String sender1 = "user1";
            String sender2 = "user2";
            String sender3 = "user3";
            String receipient = "test";
            // this entity is the sender
            cramersrule d = new cramersrule();
            d.input();
            NetUser user1 = new NetUser(sender1, receipient, link1,d.determinantone(d.A),d.cramers(d.A,d.B));
            NetUser2 user2 = new NetUser2(sender2, receipient, link2,d.determinanttwo(d.A),d.cramers(d.A,d.B));
            NetUser3 user3 = new NetUser3(sender3, receipient, link3,d.determinanttrois(d.A),d.cramers(d.A,d.B));
             //user1.determinant(d.A,d.N);
            min=d.determinant(d.A,d.N);
            // this entity is the receipient
            Test test = new Test(receipient, sender1, link1,min);
            test = new Test(receipient, sender2, link2,min);
            test = new Test(receipient, sender3, link3,min);
            //////////////////////////////////////////
            // Fourth step: Builds the network topology among entities.
            // In this example, the topology is:
            // NetUser -- link -- Test
            link1.attach(user1, test);
            link2.attach(user2, test);
            link3.attach(user3, test);
            //////////////////////////////////////////
            // Final step: Starts the simulation
            GridSim.startGridSimulation();
            System.out.println("\nFinish network example ...");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Unwanted errors happen");
        }
    }
} // end class

