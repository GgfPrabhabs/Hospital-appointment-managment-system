package threads;

public class LoadingThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Loading system...");
            Thread.sleep(2000);
            System.out.println("Ready!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
