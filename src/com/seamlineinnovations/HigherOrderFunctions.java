package com.seamlineinnovations;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {

    public static void main(String[] args){
        BiFunction<Float,Float,Float> divide = (x,y) -> x/y;

        Function<BiFunction<Float,Float,Float>,BiFunction<Float,Float,Float>> secondArgInstZeroCheck =
                (func) -> (x,y) -> {
                    if (y == 0f){
                        System.out.println("Error: second arg isnt zero");
                        return 0f;
                    }
                    return func.apply(x,y);
                };

        BiFunction<Float,Float,Float> divideSafe = secondArgInstZeroCheck.apply(divide);
        System.out.println(divideSafe.apply(10f,2f));
    }
}
