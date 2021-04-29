import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author John Mobarry
 * This class maintains a queue of random directions that the car should go
 */
public class CarQueue
{
    Random numGen = new Random();
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    Queue<Integer> theQueue;

    public CarQueue()
    {
        theQueue = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            theQueue.add(numGen.nextInt(4));
        }
    }

    public void addToQueue()
    {
        class HelperClass implements Runnable
        {
            @Override
            public void run()
            {
                while(true) {
                    try {
                        theQueue.add(numGen.nextInt(4));
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.print("The car demo has been interrupted");
                        e.printStackTrace();
                    }
                }
            }
        }

        Thread execute = new Thread(new HelperClass());
        execute.start();
    }

    public int deleteQueue()
    {
        return theQueue.remove();
    }
}
