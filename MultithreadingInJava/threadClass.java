//Here we use Thread class to use their functions and Members by inheriting the Thread class
class firstThread extends Thread{
    public void run() // using run method or function of Thread class
    {
        try {
            for(int i=1;i<=5;i++)
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
            for(int i=1;i<=5;i++)
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
            for(int i=1;i<=5;i++)
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
class threadClass
{
    public static void main(String args[])
    {
        firstThread ft = new firstThread();
        ft.start(); //Starts thread by calling it's run method
        SecondThread st = new SecondThread();
        st.start(); //Starts thread by calling it's run method
        thirdThread tt = new thirdThread();
        tt.start(); //Starts thread by calling it's run method
        try{
            for(int i=1;i<=5;i++)
            {
                System.out.println("0 => From Main thread : i "+i);
                Thread.sleep(1000); // set the sleep time of Main thread
            }
        }catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Exit from Main thread");
    }
}

//Output
/*
1 => From first Child Thread : i 1
2 =>From second child thread : i 1
0 => From Main thread : i 1
3 =>From third child thread : i 1
2 =>From second child thread : i 2
1 => From first Child Thread : i 2
3 =>From third child thread : i 2
2 =>From second child thread : i 3
0 => From Main thread : i 2
1 => From first Child Thread : i 3
2 =>From second child thread : i 4
3 =>From third child thread : i 3
2 =>From second child thread : i 5
1 => From first Child Thread : i 4
Exit from Second Child thread
0 => From Main thread : i 3
3 =>From third child thread : i 4
1 => From first Child Thread : i 5
3 =>From third child thread : i 5
Exit from first Child thread
0 => From Main thread : i 4
Exit from Third Child thread
0 => From Main thread : i 5
Exit from Main thread
 */