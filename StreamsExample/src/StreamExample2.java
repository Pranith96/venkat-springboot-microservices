import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExample2 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student(1,"Abc",120.0f), new Student(2,"xyz",980.5f),
				new Student(3,"ghj",565.0f));
		students.stream().sorted(Comparator.comparing(Student::getName)).forEach(x -> System.out.println(x));
	}
}
