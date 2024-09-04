package MultiThreading;
//create a java console program to demonstrate the use of multi-threading using github copilot's suggestions. The application should showcase the creation a seperate workers thread that executes tasks concurrently with the main thread.
public class App {
    public static void main(String[] args) {
        // Create and start worker threads
        WorkerThread worker1 = new WorkerThread("Worker 1");
        worker1.start();

        // Perform tasks in the main thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread executing task " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for worker threads to finish
        try {
            worker1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}

class WorkerThread extends Thread {
    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " executing task " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " finished");
    }
}
