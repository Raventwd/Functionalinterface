import com.sun.jdi.LongValue;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;



public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(-1);
        Number number2 = new Number(2);
        List<Number> number = new ArrayList<>();
        number.add(number1);
        number.add(number2);

        Person person1 = new Person("Alex", 10);
        Person person2 = new Person("Nick", 20);


        System.out.println("//task1");
        Predicate<Number> predicateA = new Predicate<Number>() {
            public boolean test(Number Number) {
                return Number.getNumber() >= 0;
            }
        };
        predicateA.test(number1);
        System.out.println("Число 1 положительное - " + predicateA.test(number1));

        Predicate<Number> predicateL = (Number Number) -> {
            return Number.getNumber() >= 0;
        };
        predicateL.test(number2);
        System.out.println("Число 2 положительное - " + predicateL.test(number2));

        System.out.println("//Task 2");
        Consumer<Person> consumerA = new Consumer<Person>() {
            public void accept(Person person) {
                System.out.println("Привет! " + person.getName());
            }

        };

        consumerA.accept(person1);

        Consumer<Person> consumerL = (Person Person) -> consumerA.accept(person2);
        consumerL.accept(person2);


        System.out.println("//task3");

           Function<Double, Long> functionA = new Function<Double, Long>() {

               public Long apply(Double aDouble) {
                 return Math.round(aDouble);
               }

           };
        System.out.println(functionA.apply(3.6));

            Function<Double, Long> functionL = d -> Math.round(d);
            System.out.println(functionL.apply(3.2));

        System.out.println("//task4");

        Random random = new Random();
            Supplier<Integer> supplierA = new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return random.nextInt(100);
                }
            };
        System.out.println(supplierA.get());

        Supplier<Integer> supplierL = () ->  random.nextInt(100);
        System.out.println(supplierL.get());



    }

    interface test {
        void test();
    }
}





