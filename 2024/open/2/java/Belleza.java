import java.io.InputStream;
import java.util.Scanner;

public class Belleza {
  private final Scanner scanner;

  public static void main(String[] args) {
    new Belleza(System.in).run();
  }

  public Belleza(final InputStream stream) {
    this.scanner = new Scanner(stream);
  }

  public void run() {
    final int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      task();
    }
  }

  public void task() {
    final int n = this.scanner.nextInt();
    final int k = this.scanner.nextInt();
    int[] list = new int[n];

    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(this.scanner.next());
    }

    for (int i = 0; i < k; i++) {
      if (!tweak(list)) break;
    }

    System.out.println(beauty(list));
  }

  public static boolean tweak(int[] list) {
    NumberAndPosition maxEven = null;
    NumberAndPosition maxOdd = null;

    for (int i = 0; i < list.length; i++) {
      var x = list[i];

      if ((i + 1) % 2 == 0) {
        if (maxEven == null || x > maxEven.value()) maxEven = new NumberAndPosition(i, x);
      } else {
        if (maxOdd == null || x < maxOdd.value()) maxOdd = new NumberAndPosition(i, x);
      }
    }

    if (maxEven == null || maxOdd == null) {
      throw new IllegalStateException("maxEvent or maxOdd is null");
    }

    if (maxEven.value < maxOdd.value) return false;

    list[maxEven.index()] = maxOdd.value();
    list[maxOdd.index()] = maxEven.value();

    return true;
  }

  public static int beauty(int[] list) {
    int even = 0;
    int odd = 0;

    for (int i = 0; i < list.length; i++) {
      if ((i + 1) % 2 == 0) {
        even += list[i];
      } else {
        odd += list[i];
      }
    }

    return odd - even;
  }

  public record NumberAndPosition(
      int index,
      int value
  ) {}
}