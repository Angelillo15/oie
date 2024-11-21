
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static final void main(String[] args) {
    System.out.print("Ingrese el numero maximo: ");
    int max = scanner.nextInt();
    System.out.println(Arrays.toString(fibbonnaci(max)));
  }

  public static final int[] fibbonnaci(final int max) {
    final int[] fibbonnaci = new int[max];
    fibbonnaci[0] = 0;
    fibbonnaci[1] = 1;

    for (int i = 2; i < max; i++) {
      fibbonnaci[i] = fibbonnaci[i - 1] + fibbonnaci[i - 2];
    }

    return fibbonnaci;
  }
}