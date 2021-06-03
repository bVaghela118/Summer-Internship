//Suspeding and Resuming a Thread 
class SuspendResume implements Runnable
{
    String n;
    Thread th;
    boolean suspend;
    SuspendResume()
    {
        th = new Thread(this,"Suspend-Resume Thread");
        suspend = false;
        th.start();
    }
    public void run()
    {
        try{
            for(int i=1;i<=10;i++)
            {
                System.out.println("Thread : "+i);
                Thread.sleep(200);
                synchronized(this){
                    while(suspend)
                    {
                        wait();
                    }
                }
            }
        }catch(InterruptedException e)
        {
            System.out.println("Thread Interrupted");
        }
        System.out.println("Exited from Thread");
    }
    void susThread()
    {
        suspend = true;
    }
    synchronized void resumeThread()
    {
        suspend = false;
        notify();
    }
}
class SusResThread
{
    public static void main(String args[])
    {
        SuspendResume sr = new SuspendResume();
        try{
            Thread.sleep(1000);
            sr.susThread();
            System.out.println("Thread is suspended");
            Thread.sleep(1000);
            sr.resumeThread();
            System.out.println("Thread is Resume");
        }catch(InterruptedException e)
        {
            System.out.println("Something went wrong : Error");
        }
        try{
            sr.th.join();
        }catch(InterruptedException e)
        {
            System.out.println("Main thread Interrupted");
        }
    }
}

//Output
/*
Thread : 1
Thread : 2
Thread : 3
Thread : 4
Thread : 5
Thread : 6
Thread : 7
Thread is suspended
Thread is Resume
Thread : 8
Thread : 9
Thread : 10
Exited from Thread
 */