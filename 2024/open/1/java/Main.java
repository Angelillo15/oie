
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static final void main(String[] args) {
    System.out.print("Ingrese el numero maximo: ");
    int max = scanner.nextInt();
    System.out.println(Arrays.toString(fibbonnaci(max)));
    System.out.println(Arrays.toString(fibbonnaciOriginal(max)));
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

  public static final Integer[] fibbonnaciOriginal(final int n) {
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

    return fibbonnaci.toArray(Integer[]::new);
  }
}