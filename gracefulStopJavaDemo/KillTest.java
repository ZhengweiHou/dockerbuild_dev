import java.util.Map;

public class KillTest {
    private static Thread main;

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("TERM");
            main.interrupt();
            
            for (int i=0; i<3; i++){
                System.out.println("busy");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){}
            }

            System.out.println("exit");
        }));

        System.getenv().forEach((a,b) -> {
            System.out.println("key:" + a + "         value:" + b);
        });

        main = Thread.currentThread();
        while (true){
            Thread.sleep(1000);
            System.out.println("running...");
        }

    }

}
