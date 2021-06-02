import java.lang.Runnable;
class ThreadChild implements Runnable // implementing Runnable interface
{
    ThreadChild() //constructor
    {
        Thread t = new Thread(this, "Runnable Thread example"); // it is shows the current class has implement the Runnable interface
        System.out.println("Detail of child Thread: "+t);
        t.start(); // start method  starts the execution of the thread by invoking the run() method
    }
    public void run() // It is called whenever the this thread is scheduled by the thread scheduler
    {
        try{
            for(int i=1;i<=5;i++)
            {
                System.out.println("From child thread 1 : i "+i);
                Thread.sleep(500); // set the sleep by 5ms
            }
        }catch(InterruptedException e)
        {
            System.out.println("Child thread 1 is Interrupted");
        }
        System.out.println("Exit from Child thread 1");
    }
}

class runnableInterface {
    public static void main(String args[])
    {
        new ThreadChild(); // the Constructor is instantiated() and it is invoked the line number4 constructor
        try{
            for(int i=1;i<=5;i++)
            {
                System.out.println("From Main Thread "+i);
                Thread.sleep(800);// sleep set by 8ms
            }
        }catch(InterruptedException e){
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Exit from Main thread");
    }
}

// Output
/*
Detail of child Thread: Thread[Runnable Thread example,5,main]
From Main Thread 1
From child thread 1 : i 1
From child thread 1 : i 2
From Main Thread 2
From child thread 1 : i 3
From child thread 1 : i 4
From Main Thread 3
From child thread 1 : i 5
From Main Thread 4
Exit from Child thread 1
From Main Thread 5
Exit from Main thread
 */