// what happens under the hood in java
// your code(*.java) is compiled thru the java compiler
// which then turns it into runnable bytecode (*.class)

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Date;

// java bytecode is platform independent, meaning after your code compiles it can run on any platform
// any OS with a JRE (Java Runtime Env.) can run the bytecode through the JVM(Java Virtual Machine)
public class Main { //capital M for main bcz it's case sensitive
    // remember that the main methode in your class should always be static --> no return type
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Primitive Types
        byte age = 30;
        long viewCount = 3_126_542_258L; // underscores like comas make the code more readible
        double price = 10.99F;
        char letter = 'A';
        boolean isEligible = false;

        // Reference Types
        // when dealing reference types we need to allocate memory for them --> "new"
        Date now = new Date();
        System.out.println(now); // sout then tab to get the snippet shortcut

        // Strings
//        String dummmy = new String("Hello World");
        String message = "Hello World"+"!!"; //same implementation as above, only looks like primitive type
        System.out.println(message);

        //Escape sequences
        // what if i want to store path in string
        // c:\windows\...
        String path = "c:\\Windows\\...";
        System.out.println(path);

        // Arrays
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers));

        // better way to initialize an array if you know its content beforehand
        int[] nums = {2,1,9,5,4};
        //System.out.println(nums.length);// Arrays have fixed lengths
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        // Multi-dimensional array
        int[][] matrix = new int[2][3]; // 2rows 3 columns
        matrix[0][1] = 1;
        // if we know content we can use int[][] matrix = {{1,2,3},{4,5,6}};
        System.out.println("\n MultiDimensional Arrays");
        System.out.println(Arrays.toString(matrix));// toString doesn't work with multidimensional arryas
        System.out.println(Arrays.deepToString(matrix));

        //constants
        final float pie = 3.14F;

        // to find the length of a string in java
        String s = "jad";
        int stringLength = s.length();

        //to find the length of an array in java
        // same as string but without paranthesis 


        //HashMap Syntax
        




        System.out.println(stringLength, pie  );
    }
}

// primitive types: byte, short, int, long, float, double, char, boolean
// Reference Types: Date,