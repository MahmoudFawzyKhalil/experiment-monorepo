package concurrency;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // Partial application -> creating a function with a parameter pre-filled in
        Function<Integer, Integer> add2_partial_application = (b) -> add.apply(2, b);

        // Currying -> a function that takes the parameter you want to prefill, and gives you a function with that parameter pre-filed in
        Function<Integer, Function<Integer, Integer>> curryAdd_or_AdderFactory = b -> (a -> add.apply(a, b));
        Function<Integer, Integer> add2_currying = curryAdd_or_AdderFactory.apply(2);
        Function<Integer, Integer> add3_currying = curryAdd_or_AdderFactory.apply(3);
        System.out.println(add2_currying.apply(3)); // returns 5
    }
}
