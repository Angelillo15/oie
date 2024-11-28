
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static final void main(String[] args) {
    System.out.print("Ingrese el numero maximo: ");
    final int max = scanner.nextInt();
    final int[] fib = fibbonnaci(max);
    final int[] fibTao = (int[]) fibbonnaciTao(max);

    if (fib.length == fibTao.length) {
      System.out.println("OK");
      return;
    }

    for (int i = 0; i < fib.length; i ++) {
      if (Arrays.binarySearch(fibTao, fib[i]) < 0) {
        System.out.println(fib[i]);
      }
    }
  }

  public static final int[] fibbonnaci(final int max) {
    final int[] fibbonnaci = new int[max];
    fibbonnaci[0] = 1;
    fibbonnaci[1] = 1;

    for (int i = 2; i < max; i++) {
      if (fibbonnaci[i - 1] >= max) break;
      fibbonnaci[i] = fibbonnaci[i - 1] + fibbonnaci[i - 2];
    }

    return Arrays.copyOf(fibbonnaci, Arrays.stream(fibbonnaci).filter(i -> i != 0).toArray().length);
  }

  public static final int[] fibbonnaciTao(final int n) {
    int s = 1;
    int t = 1;
    final List<Integer> fibbonnaci = new ArrayList<>();

    while (true) {
      fibbonnaci.add(s);
      fibbonnaci.add(t);
      
      s = s + t;
      t = t + s;

      if (s >= n) {
        fibbonnaci.add(s);
        System.out.print(" ");
        break;
      }
      if (t >= n) {
        fibbonnaci.add(t);
        break;
      }
    }

    return fibbonnaci.stream().mapToInt(Integer::intValue).toArray();
  }
}