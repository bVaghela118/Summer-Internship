class StringDemo {

    public static void stringMethodDemo()
    {
        String s1 = "This is a String Method Demo string1";
        String s2 = "This is a String Method Demo string2";
        System.out.println("s1 matches to s2?: "+s1.regionMatches(0, s2, 0, s1.length()-1));
        System.out.println("s1 starts with 'T':"+s1.startsWith("T"));
    }

    public static void stringBufferDemo(){
        StringBuffer sb = new StringBuffer();
        System.out.println("Available capacity: "+sb.capacity());
        System.out.println("Append string to buffer: "+sb.append("Hello StringBuffer"));
        System.out.println("String Replace is: "+sb.replace(6, 18, "DemoString"));
        System.out.println("String reverse: "+sb.reverse());
        System.out.print("String char setting: ");
        sb.setCharAt(3, '0');
        System.out.println("String value: "+sb);
        System.out.println("Current Available capacity: "+sb.capacity());
    }
    public static void main(String args[])
    {
        stringBufferDemo();
        stringMethodDemo();
        String a = "Hello";  // Here a and b both the Object implicit pointing to the same string literal which is Hello in memory pool
        String b = "Hello";  // here a passes the reference of the previously created object to b
        String c = new String("Hello"); // Here c is created new object which is allocated to explicit memory and it is not part of string memory pool
        String d = new String("Hello");// here d is also do same as c but it is different object from c
        String e = new String("Hello");
        if(a==b) //check both references are pointing to same location or not
        // here equality operator is not used for matching the content of string
        {
            System.out.println("Same A and B");
        }
        else{
            System.out.println("A and B are Different");
        }
        
        if(a==c) 
        {
            System.out.println("Same A and C");
        }
        else{
            System.out.println("A and C are Different");
        }

        if(c==d) 
        {
            System.out.println("Same C and D");
        }
        else{
            System.out.println("C and D are Different");
            String f = e.intern(); // intern() method creates a string literal as that of the invoking string object and return reference of the newly created object in the string pool.

            if(f==a) 
            {
                //both value same then this print
                System.out.println("Interned object f refer to the already created object a in the pool");
            }
            else{
                System.out.println("Interned object f does not refer to the already created object as literal was not present in the pool.");
            }
        }
    }
}
