//Setting and getting Prioritie of Thread
class firstThread extends Thread{
    public void run() // using run method or function of Thread class
    {
        try {
            for(int i=1;i<=3;i++)
            {
                System.out.println("1 => From first Child Thread : i "+i);
                Thread.sleep(600); // set the sleep time of first child thread
            }
        }
        catch(InterruptedException e){
            System.out.println("First child thread is interrupted");
        }
        System.out.println("Exit from first Child thread");
    }
}
class SecondThread extends Thread
{
    public void run() // using run method or function of Thread class
    {
        try{
            for(int i=1;i<=3;i++)
            {
                System.out.println("2 =>From second child thread : i "+i);
                Thread.sleep(400); // set the sleep time of second child thread
              
            }
        }catch(InterruptedException e){
            System.out.println("Second Child Thread interrupted");
        }
        System.out.println("Exit from Second Child thread");
    }
}

class thirdThread extends Thread{
    public void run() // using run method or function of Thread class
    {
        try{
            for(int i=1;i<=3;i++)
            {
                System.out.println("3 =>From third child thread : i "+i);
                Thread.sleep(700); // set the sleep time of third child thread
            }
        }catch(InterruptedException e)
        {
            System.out.println("Third Child Thread interrupted");
        }
        System.out.println("Exit from Third Child thread");
    }
}
class threadPriority
{
    public static void main(String args[])
    {
        firstThread ft = new firstThread();
        SecondThread st = new SecondThread();
        thirdThread tt = new thirdThread();
        System.out.println("Default Priority for thread 1: "+ft.getPriority());
        System.out.println("Default Priority for thread 2: "+st.getPriority());
        System.out.println("Default Priority for thread 3: "+tt.getPriority());
        ft.setPriority(Thread.MIN_PRIORITY);
        st.setPriority(Thread.MAX_PRIORITY);
        tt.setPriority(Thread.NORM_PRIORITY);
        System.out.println("Set Priority for thread 1: "+ft.getPriority());
        System.out.println("Set Priority for thread 2: "+st.getPriority());
        System.out.println("Set Priority for thread 3: "+tt.getPriority());
        
        System.out.println("All the threads start from here:");
        ft.start(); //Starts thread by calling it's run method
        st.start(); //Starts thread by calling it's run method
        tt.start(); //Starts thread by calling it's run method
    }
}
//Output
/*
Default Priority for thread 1: 5
Default Priority for thread 2: 5
Default Priority for thread 3: 5
Set Priority for thread 1: 1
Set Priority for thread 2: 10
Set Priority for thread 3: 5
All the threads start from here:
1 => From first Child Thread : i 1
2 =>From second child thread : i 1
3 =>From third child thread : i 1
2 =>From second child thread : i 2
1 => From first Child Thread : i 2
3 =>From third child thread : i 2
2 =>From second child thread : i 3
Exit from Second Child thread
1 => From first Child Thread : i 3
3 =>From third child thread : i 3
Exit from first Child thread
Exit from Third Child thread
 */