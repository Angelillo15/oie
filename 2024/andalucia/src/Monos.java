import javax.management.QueryEval;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Monos {
  private final Scanner scanner;

  private static final InputStream defaultInput = new ByteArrayInputStream("""
      4
      1 4
      2 3
      4 1
      3 2
      """.getBytes(StandardCharsets.UTF_8));

  private static final InputStream defaultInput2 = new ByteArrayInputStream("""
      5
      1 2
      2 3
      3 1
      4 5
      5 4
      """.getBytes(StandardCharsets.UTF_8));

  public static void main(String[] args) {
    if (Objects.equals(System.getProperty("testRun"), "true")) {
      new Monos(defaultInput).run();
      new Monos(defaultInput2).run();
    } else {
      new Monos(System.in);
    }
  }

  public Monos(final InputStream input) {
    this.scanner = new Scanner(input);
  }

  public void run() {
    final int n = scanner.nextInt();
    final List<Queue<Integer>> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      final int from = scanner.nextInt();
      final int to = scanner.nextInt();

      final var q = findOrCreate(list, from, to);
      if (!q.contains(from)) q.add(from);
      if (!q.contains(to)) q.add(to);

      if (!list.contains(q)) list.add(q);
    }

    System.out.println(lcmOfArray(list.stream().map(Collection::size).iterator()));
  }

  private Queue<Integer> findOrNull(List<Queue<Integer>> list, int n) {
    for (Queue<Integer> integers : list) {
      for (Integer integer : integers) {
        if (n == integer) return integers;
      }
    }

    return null;
  }

  private Queue<Integer> findOrCreate(List<Queue<Integer>> list, int from, int to) {
    final var fromq = findOrNull(list, from);
    if (fromq != null) return fromq;

    final var toq = findOrNull(list, to);
    if (toq != null) return toq;

    return new LinkedList<>();
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  public static int lcmOfArray(Iterator<Integer> numbers) {
    int result = numbers.next();

    while (numbers.hasNext()) {
      result = lcm(result, numbers.next());
    }

    return result;
  }
}
