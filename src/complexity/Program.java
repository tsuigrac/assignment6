
package complexity;

public class Program {

  public static void main(String[] args) {

    // Problem 1 Test
    double[] arr = new double[] {1.0, 2.0, 3.0, 4.0};


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
  

}
