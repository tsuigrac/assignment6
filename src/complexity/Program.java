
package complexity;

public class Program {

  public static void main(String[] args) {

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
    
    //Problem 5 Testing
    int[] arr1 = new int[] {0, 1, 2, 3, 4, 5, 6};
    int[] arr2 = new int[] {3, 4, 5};
    int[] inter = interleave(arr1, arr2);
    for(int val: inter) {
      System.out.print(val+ " ");
    }

  }

  // Problem 1
  public static boolean contains(double[] arr, double eps, double d1) {
    for (double val : arr) {
      if (val < (d1 + eps) && val > (d1 - eps)) {
        return true;
      }
    }
    return false;
  }


  // Problem 2 (bugs)
  public static int fastModExp(int x, int y, int m) {
    if (y % 2 == 0) {
      return exp(((x * x) % m), y / 2);
    } else {
      return x * fastModExp(x, y - 1, m);
    }
  }

  public static int exp(int x, int y) {
    if (y == 1) {
      return x;
    } else {
      return x * exp(x, y - 1);
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
    }//for
    return result;
  }


}
