import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

//www.java2s.c om

public class PredicateJava8 {

  public static void main(String... args) {

    // http://www.java2s.com/Tutorials/Java/java.util.function/Predicate/index.htm
    // ++++++++++++++ EXAMPLE 2 ++++++++++++++

    List<Box> inventory = Arrays.asList(new Box(80, "green"), new Box(
        155, "green"), new Box(120, "red"));

    List<Box> greenApples = filter(inventory,PredicateJava8::isGreenApple);
    System.out.println(greenApples);

    List<Box> heavyApples = filter(inventory,PredicateJava8::isHeavyApple);
    System.out.println(heavyApples);

    List<Box> greenApples2 = filter(inventory,(Box a) -> "green".equals(a.getColor()));
    System.out.println(greenApples2);

    List<Box> heavyApples2 = filter(inventory,(Box a) -> a.getWeight() > 150);
    System.out.println(heavyApples2);

    List<Box> weirdApples = filter(inventory,(Box a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
    System.out.println(weirdApples);

    // ++++++++++++++ EXAMPLE 2 ++++++++++++++

    List<Student> employees = Arrays.asList(
          new Student(1, 3, "John"),
          new Student(2, 3, "Jane"),
          new Student(3, 4, "Jack")
    );

    // with predicate
    System.out.println(findStudents(employees, createCustomPredicateWith(10_000)));

    // with function definition, both are same
    Function<Double, Predicate<Student>> customFunction = threshold -> (e -> e.gpa > threshold);
    System.out.println(findStudents(employees, customFunction.apply(10_000D)));


    // +++++++++++++++++++++++ FilterMe example ++++++++++++++++++++++++++
    // http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html

    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    System.out.println("Languages which starts with J :");
    filterMe(languages, (str)->str.startsWith("J"));

    System.out.println("Languages which ends with a ");
    filterMe(languages, (str)->str.endsWith("a"));

    System.out.println("Print all languages :");
    filterMe(languages, (str)->true);

     System.out.println("Print no language : ");
     filterMe(languages, (str)->false);

     System.out.println("Print language whose length greater than 4:");
     filterMe(languages, (str)->str.length() > 4);
  }


  public static boolean isGreenApple(Box apple) {
    return "green".equals(apple.getColor());
  }

  public static boolean isHeavyApple(Box apple) {
    return apple.getWeight() > 100;
  }

  private static Predicate<Student> createCustomPredicateWith(double threshold) {
    return e -> e.gpa > threshold;
  }

  private static List<Student> findStudents(List<Student> employees, Predicate<Student> condition) {
    List<Student> result = new ArrayList<>();

    for (Student e : employees) {
       if (condition.test(e)) {
          result.add(e);
       }
    }

      return result;
  }

  public static List<Box> filter(List<Box> inventory, Predicate<Box> p) {
    List<Box> result = new ArrayList<>();
    for (Box apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public static void filterMe(List<String> names, Predicate<String> condition) {
    for(String name: names)  {
       if(condition.test(name)) {
          System.out.println(name + " ");
       }
    }
  }

}

class Box {
  private int weight = 0;
  private String color = "";

  public Box(int weight, String color) {
    this.weight = weight;
    this.color = color;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toString() {
    return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
  }
}

class Student {
  public int id;
  public long gpa;
  public String name;

  Student(int id, long g, String name) {
     this.id = id;
     this.gpa = g;
     this.name = name;
  }

  @Override
  public String toString() {
     return id + ">" + name + ": " + gpa;
  }
}