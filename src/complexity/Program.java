
package complexity;

public class Program {

  public static void main(String[] args) {
    // Problem 1 Testing
    /*
     * double[] arr = new double[] {1, 3, 4, 2, 2.1,5.7, 10.9}; System.out.println(contains(arr,
     * 0.2, 2.4));
     */

    // Problem 2 Testing
    // System.out.println(fastModExp(4, 13, 13));

    // Problem 3 Testing
    /*
     * int[] arr = new int[] {3, 5, 9}; IntPair[] pairs = allPairs(arr); for(IntPair pair: pairs) {
     * System.out.print(pair.toString()); }
     */

    // Problem 4 Testing
    /*
     * String[] concat = new String[] {"hello", "world", "!"};
     * System.out.println(concatAndReplicateAll(concat, 3));
     */

    // Problem 5 Testing
    /*
     * int[] arr1 = new int[] {0, 1, 2, 3, 4, 5, 6}; 
     * int[] arr2 = new int[] {3, 4, 5}; 
     * int[] inter = interleave(arr1, arr2); for (int val : inter) { System.out.print(val + " "); }
     */

  }

  // Problem 1
  /**
   * Checks if a double is contained in a given array 
   * within specified error bound eps
   *
   * @param dubs   an array of doubles
   *        eps    an error bound of the values in the array
   *        d      the value to look for
   *         
   * @pre   none
   * @post  return true if the value is in the array, and false if not
   */
  public static boolean contains(double[] dubs, double eps, double d) {
    for (double val : dubs) {
      if (Math.abs(val - d) < eps) {
        return true;
      }
    }
    return false;
  }


  // Problem 2
  /**
   * Takes three integers x, y, and m and returns x^y mod m
   *
   * @param x   an integer that represents the base
   *        y   an integer that represents the exponent
   *        m   an integer that represents the modulo
   *         
   * @pre   m > 0 and y >= 0
   *        x^y does not exceed Integer.MAXVALUE
   *        
   * @post  return the mod of x^y mod m
   */
  public static int fastModExp(int x, int y, int m) {
    if (y == 0) {
      return 1;
    } else if (y % 2 == 0) {
      return fastModExp((x * x) % m, y / 2, m);
    } else {
      return (x * fastModExp(x, y - 1, m)) % m;
    }
  }


  // Problem 3
  /**
   * Takes an integer array and returns all possible pairs of elements
   * from the input array in a new array of type IntPair array
   *
   * @param arr an array
   * @throws IllegalArgumentException if arr is null
   * @pre   arr is not null
   *        arr has no repeats
   * @post  - returns an array of type IntPair[]
   *        - returned array has arr.length^2 number of values
   *        - returned array returns set of all possible pairs, including
   *          pairing each element with itself
   */
  public static IntPair[] allPairs(int[] arr) throws IllegalArgumentException {
    if (arr == null) {
      throw new IllegalArgumentException("Array is null");
    }
    IntPair[] result = new IntPair[arr.length * arr.length];
    int count = 0;
    for (int first = 0; first < arr.length; first++) {
      for (int second = 0; second < arr.length; second++) {
        result[count] = new IntPair(arr[first], arr[second]);
        count++;
      }
    }
    return result;
  }


  // Problem 4
  /**
   * Takes an array of strings and an integer n and returns a single string
   * that is the result of replicating them all n times and then concatenating
   * them together
   *
   * @param arr an array of strings
   *        n   the number of reps each string is repeated
   * @throws IllegalArgumentException if arr is null
   * @pre   arr is not null
   * @post  - returns a String of a concatenation of each
   *          string in arr repeated n times
   */
  public static String concatAndReplicateAll(String[] arr, int n) throws IllegalArgumentException {
    if (arr == null) {
      throw new IllegalArgumentException("Array is null");
    }
    String result = "";
    for (int val = 0; val < arr.length; val++) {
      for (int reps = 0; reps < n; reps++) {
        result += arr[val];
      }
    }
    return result;
  }


  // Problem 5
  /**
   * Takes two arrays of integers and returns a third array
   * that is the result of interleaving the first array
   * with the second
   *
   * @param arr1 an array of ints
   *        arr2 an array of ints
   * @pre   arr1 and arr2 are not null
   * @post  - returns a array finalArr that has length
   *          arr1.length + arr2.length
   *        - if one array is longer than the other, the remains
   *          of the longer array are placed at the end
   *          of the output array after interleaving  
   */
  public static int[] interleave(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int length;

    if (arr1.length >= arr2.length) {
      length = arr1.length;
    } else {
      length = arr2.length;
    }

    int index = 0;

    for (int i = 0; i < length; i++) {
      //If arr1 ran out of elements, append arr2 to the end
      if (i >= arr1.length) {
        result[index++] = arr2[i];
        //If arr2 ran out of elements, append arr1 to the end
      } else if (i >= arr2.length) {
        result[index++] = arr1[i];
        //Else interleave them
      } else {
        result[index++] = arr1[i];
        result[index++] = arr2[i];
      }
    } // for
    return result;
  }


}
