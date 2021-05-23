package com.seamlineinnovations;

public class Closure {

    public static void main(String[] args){

        NoArgFunction<NoArgFunction<String> > createGreeter = () -> {
            String name = "Steve";
            return () -> "Hello, " + name;
        };

        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());


    }
}
