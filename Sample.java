import java.util.*;
class Sample
{
    public static void ListInterface()
    {
        //Use of ArrayList
        ArrayList<Integer> lst = new ArrayList<Integer>(); //create ana arryalist 
        lst.add(10);  //adding elements
        lst.add(20);
        lst.add(5);
        Iterator itr = lst.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next()+" ");
        }
        Collections.sort(lst);  //sorting list elements
        for(Object obj:lst)
        {
            System.out.print(obj+" ");
        }
        int pos = lst.lastIndexOf(11); //Return the index in this list of the last occurence of the specified element or -1 if the list does'nt contain this element
        System.out.println(pos);// it display 0 if value is in the list otherwise -1.
        lst.clear(); // Removes all the element from the list

        //Use Of LinkedList
        LinkedList<String> ll = new LinkedList<String>(); 
        ll.push("Apple");
        ll.push("Orange");
        ll.push("Mango");
        ll.remove();
        for (Object str : ll) {
            System.out.print(str+" ");
        }
        //Use of HashSet
        Set  s = new HashSet();
        s.add("HashSet 1");
        s.add("HashSet 2");
        s.add("HashSet 3");
        System.out.println("Hashset Elements:");
        System.out.println("\t"+s);

        //HashMap
        Map m = new HashMap();
        m.put("HashSet 1","1001");
        m.put("HashSet 2","1005");
        m.put("HashSet 3","1010");
        System.out.println("HashMap Elements:");
        System.out.println("\t"+m);
    }
    public static void setInterface()
    {
        System.out.println("Use of SetInterface");
        //Set Interface Example
        //HashSet
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(25);
        set.add(30);
        set.add(54);
        set.add(88);
        System.out.println("Set elements:"+set);
        
        //TreeSet 
        TreeSet sortedSet = new TreeSet<Integer>(set); // passing Hashset value to treeSet directly
        System.out.println("TreeSet Sorted list is:");
        System.out.println(sortedSet);
        System.out.println("First element of the List is: "+sortedSet.first());
        System.out.println("Last element of the List is: "+sortedSet.last());
    
    }
    public static void main(String args[])
    {
        System.out.println("List Intefaces:");
        ListInterface();
        System.out.println("Set Intefaces:");
        setInterface();
    }
}