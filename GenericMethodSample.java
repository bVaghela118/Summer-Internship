//Use Of Generics Method
import java.util.*;
public class GenericMethodSample
{
    public static <E> void printArray(E[] inputArray)
    {
        for(E element: inputArray)  //Display Elements
        {
           System.out.printf("%s ",element);
        }
        System.out.println();
    }

    //Bounded Types Parameters
    // Find the largest among three numbers
    public static <T extends Comparable<T>> T maximum(T a,T b,T c)
    {
        T max = a;
        if(b.compareTo(max) >0){ max = b;}
        if(c.compareTo(max)>0){ max= c;}
        return max;
    }
    public static void main(String args[])
    {
        //Creating Array using Class datatype 
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10};
        Character[] charArr = {'A','E','I','O','U'};
        Double[] doubleArr = {1.1,1.2,1.3,1.4,1.5,2.0,2.2};
        
        System.out.println("Array Of IntegerArray have:");
        printArray(intArr);
        System.out.println("Array Of CharacterArray have:");
        printArray(charArr);
        System.out.println("Array Of DoubleArray have:");
        printArray(doubleArr);

        System.out.println("Maximum function calling;");
        System.out.printf("Max is %d",maximum(5, 4, 10));
    }
}