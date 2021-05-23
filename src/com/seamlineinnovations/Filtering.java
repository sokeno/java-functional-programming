package com.seamlineinnovations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String [] args){
        Integer[] intArray = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = listOfIntegers
                .stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evens);

        String[] wordsArr = {"hello","functional","programming","is","cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        //Predicate<String> isLongerThan5 = (str) -> str.length() > 5;
        Function<Integer,Predicate<String>> createLenghtTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan3 = createLenghtTest.apply(3);
        Predicate<String> isLongerThan10 = createLenghtTest.apply(10);
        List<String> longWords = words
                .stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());

        System.out.println(longWords);

    }
}
