//Using Interupt() and getState() Method of Thread class
class ThreadInterrupt extends Thread
{
    boolean interrupt = false;
    String name;
    ThreadInterrupt(String n)
    {
        super(n); 
        name= n;
    }
    public void run()
    {
        while(!interrupt){
            System.out.println("Thread running "+name+" state: "+getState());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
                System.out.println("Thread Interrupted: "+name+" state: "+getState());
            }
        }
        System.out.println("Thread exited under request of "+name+" state: "+getState());   
    }

    public static void main(String args[]) throws Exception
    {
        ThreadInterrupt th = new ThreadInterrupt("Thread Interrupt example");
        System.out.println("Starting THread: "+th.name+" state: "+th.getState());
        th.start();
        Thread.sleep(1500);
        System.out.println("Stop Thread: "+th.name+" state: "+th.getState());
        th.interrupt = true;
        th.interrupt();
        System.out.println(th.name+" state: "+th.getState());
        Thread.sleep(1500);
        System.out.println("Exiting Application state: "+th.getState());
        System.exit(0);
    }
}
