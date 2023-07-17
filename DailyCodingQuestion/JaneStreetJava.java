/*
This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.

 */

interface PairFunction {
  int apply(int a, int b);
}

public class Pair {
  private final int first;
  private final int second;

  public Pair(int first, int second) {
      this.first = first;
      this.second = second;
  }

  public int getFirst() {
      return first;
  }

  public int getSecond() {
      return second;
  }

  public static Pair cons(int a, int b) {
      PairFunction pairFunction = (x, y) -> x;
      int first = pairFunction.apply(a, b);

      pairFunction = (x, y) -> y;
      int second = pairFunction.apply(a, b);

      return new Pair(first, second);
  }

  public static int car(Pair pair) {
      return pair.getFirst();
  }

  public static int cdr(Pair pair) {
      return pair.getSecond();
  }

  public static void main(String[] args) {
      Pair pair = Pair.cons(3, 4);
      System.out.println(Pair.car(pair)); // Output: 3
      System.out.println(Pair.cdr(pair)); // Output: 4
  }
}
