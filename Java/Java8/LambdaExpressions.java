import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressions{

	public static void main(String[] args) {
		
		// Runnable r = () -> System.out.println("hello world");
		new Thread(
			() -> System.out.println("hello world")
		).start();

		// Old way:
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		System.out.println("\n \tOld way:\n");
		for(Integer n: list) {
			System.out.println("\t" + n);
		}

		// New way:
		System.out.println("\n \tNew simple way:\n");
		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println("\t" + n));


		// or we can use :: double colon operator in Java 8
		System.out.println("\n \tNew way with double colon:\n");
		list.forEach(System.out::println);

		// Some other stuff like : PREDICATE
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		System.out.println("Print all numbers:");
		evaluate(list2, (n)->true);

		System.out.println("Print no numbers:");
		evaluate(list2, (n)->false);

		System.out.println("Print even numbers:");
		evaluate(list2, (n)-> n%2 == 0 );

		System.out.println("Print odd numbers:");
		evaluate(list2, (n)-> n%2 == 1 );

		System.out.println("Print numbers greater than 5:");
		evaluate(list2, (n)-> n > 5 );

	}

	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for(Integer n: list)  {
			if(predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
		System.out.println("\n");
	}
}