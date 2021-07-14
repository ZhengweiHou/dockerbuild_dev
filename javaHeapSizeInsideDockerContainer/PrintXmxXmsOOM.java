import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.ArrayList;

public class PrintXmxXmsOOM{
    public static void main(String[] args) throws InterruptedException{
        int mb = 1024 * 1024;
        MemoryMXBean mmb = ManagementFactory.getMemoryMXBean();
        long xmx = mmb.getHeapMemoryUsage().getMax()   / mb;
        long xms = mmb.getHeapMemoryUsage().getInit()  / mb;
        long used = mmb.getHeapMemoryUsage().getUsed() / mb;

        System.out.println("PrintXmxXmsOOM");
        System.out.println("xms:" + xms + "mb");
        System.out.println("xmx:" + xmx + "mb");
        System.out.println("used:" + used + "mb");

        ArrayList al =  new ArrayList<Byte[]>();
        for(int i =0 ; i < 1000 ; i++){
            Thread.sleep(500);
            al.add(new Byte[1024 * 1024]); 
            //Byte[] a = new Byte[1024 * 1024]; 

            xmx = mmb.getHeapMemoryUsage().getMax()   / mb;
            xms = mmb.getHeapMemoryUsage().getInit()  / mb;
            used = mmb.getHeapMemoryUsage().getUsed() / mb;
            System.out.println(
                    "xms:" + xms + "mb," +
                    "xmx:" + xmx + "mb," +
                    "used:" + used + "mb");
        }


    }
}
