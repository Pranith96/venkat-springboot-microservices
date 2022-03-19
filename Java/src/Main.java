import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int a[] = {1,5,8};
		Double avg = Arrays.stream(a).average().getAsDouble();
		System.out.println(avg);
	}
}
