import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 2, 8, 9, 2, 1, 4, 7, 10);
		List<Integer> result = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(result);
		System.out.println("------------------------------------");

		List<Integer> result1 = list.stream().map(x -> x * 5).collect(Collectors.toList());
		System.out.println(result1);
		System.out.println("------------------------------------");
		list.stream().filter(x -> x % 2 == 0).map(y -> y * 5).forEach(x -> System.out.println(x));
		System.out.println("------------------------------------");

		Long data = list.stream().count();
		System.out.println(data);
		System.out.println("--------------------");
		list.stream().distinct().forEach(x -> System.out.println(x));
		System.out.println("-------------------------");
		list.stream().sorted().forEach(x -> System.out.print(x + " "));
	}
}
