package com.seamlineinnovations;

public class FunctionAsData {
    protected static class Person{
        private String name;
        private Integer age;

        public Person(String name, Integer age){
            this.age = age;
            this.name = name;
        }

    }

    protected static class DataLoader{
        public final NoArgFunction<Person> loadPerson;
        public DataLoader(Boolean isDevelopment){
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }
        private Person loadPersonReal(){
            System.out.println("Loading person ..");
            return new Person("Real Person",30);

        }
        private  Person loadPersonFake(){
            System.out.println("Returning fake person object..");
            return new Person("Fake Person",100);

        }
    }
    public static void main(String[] args){
       final Boolean IS_DEVELOPMENT = false;
       DataLoader dataLoader =  new DataLoader(IS_DEVELOPMENT);
       System.out.println(dataLoader.loadPerson.apply());
    }
}
