//Use of Join() and isAlive() method
class ThreadJoin implements Runnable{
    String nm;
    Thread th;

    ThreadJoin(String name)
    {
        nm = name;
        th = new Thread(this,nm);
        th.start();
    }

    public void run()
    {
        try{
            Thread.sleep(1000);
            for(int i=1;i<=4;i++)
            {
                System.out.println("From child thread "+nm+" is "+i);
            }
        }catch(InterruptedException e)
        {
            System.out.println("From child thread "+nm+" is interrupted");
        }
        System.out.println("Terminating thread is "+nm);
    }
}
class join_isAlive {
    public static void main(String args[])
    {
        ThreadJoin tA = new ThreadJoin("Thread A");
        ThreadJoin tB = new ThreadJoin("Thread B");
        ThreadJoin tC = new ThreadJoin("Thread C");

        System.out.println("Status of Thread : Alive");
        System.out.println("Thread A "+tA.th.isAlive());
        System.out.println("Thread A "+tB.th.isAlive());
        System.out.println("Thread A "+tC.th.isAlive());

        try{
            System.out.println("Threads Joining...");
            tA.th.join();
            tB.th.join();
            tC.th.join();
        }catch(InterruptedException e)
        {
            System.out.println("Exception: Main thread Interrupted");
        }
        System.out.println("Status of Thread : Alive");
        System.out.println("Thread A "+tA.th.isAlive());
        System.out.println("Thread A "+tB.th.isAlive());
        System.out.println("Thread A "+tC.th.isAlive());
        System.out.println("Terminating Main thread ");
    }
}

//Output
/*
Status of Thread : Alive
Thread A true
Thread A true
Thread A true
Threads Joining...
From child thread Thread B is 1
From child thread Thread C is 1
From child thread Thread A is 1
From child thread Thread B is 2
From child thread Thread A is 2
From child thread Thread B is 3
From child thread Thread A is 3
From child thread Thread B is 4
From child thread Thread A is 4
Terminating thread is Thread B
Terminating thread is Thread A
From child thread Thread C is 2
From child thread Thread C is 3
From child thread Thread C is 4
Terminating thread is Thread C
Status of Thread : Alive
Thread A false
Thread A false
Thread A false
Terminating Main thread
 */