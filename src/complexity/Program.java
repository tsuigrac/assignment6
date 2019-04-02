
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
  public static boolean contains(double[] dubs, double eps, double d) {
    for (double val : dubs) {
      if (Math.abs(val - d) < eps) {
        return true;
      }
    }
    return false;
  }


  // Problem 2
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
  public static int[] interleave(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int length;

    if (arr1.length >= arr2.length) {
      length = arr1.length;
    } else {
      length = arr2.length;
    }

    int count = 0;

    for (int i = 0; i < length; i++) {
      if (i >= arr1.length) {
        result[count++] = arr2[i];
      } else if (i >= arr2.length) {
        result[count++] = arr1[i];
      } else {
        result[count++] = arr1[i];
        result[count++] = arr2[i];
      }
    } // for
    return result;
  }


}
