import java.util.function.Predicate;
import java.util.*;

public class PredicateAndLambda{
	public static void main(String[] args) {
		
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		   
		List<String> languages = Arrays.asList("Java", "JavaScript", "Scala", "C++", "Haskell", "Lisp");

		// We can even combine Predicate using and(), or() And xor() logical functions
		// for example to find names, which starts with J and four letters long, you
		// can pass combination of two Predicate

		languages.stream()
		      .filter(startsWithJ.or(fourLetterLong))
		      .forEach((n) -> System.out.print("\nName, which starts with 'J' and"
		      	+ " four letter long is : " + n + "\n"));


		// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz4LdtYXSkW

	}
}