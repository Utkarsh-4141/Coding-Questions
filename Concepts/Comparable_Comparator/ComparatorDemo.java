package Concepts.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// No need to change main Dog class for comparison, we can sort in custom way using Comparator
public class ComparatorDemo {
    public static void main(String[] args) {
        Dog a1 = new Dog(5, "Chetak", 20);
        Dog a2 = new Dog(2, "Tommy", 10);
        Dog a3 = new Dog(7, "Bruno", 6);
        Dog a4 = new Dog(4, "Max", 15);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(a1);
        dogs.add(a2);
        dogs.add(a3);
        dogs.add(a4);

        System.out.println(dogs);
        // using lambda expr
        Collections.sort(dogs, (d1, d2) -> d1.age-d2.age);
        System.out.println(dogs);

        // using normal comparator
        Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return Integer.compare(o1.weight, o2.weight); // safe for bigger values
            }
            
        });
        System.out.println(dogs);

        // using comparing()
        Collections.sort(dogs, Comparator.comparing(Dog::getAge)); // .thenComparing(Dog::getName) if dogs having same age
        System.out.println(dogs);
    }
}

class Dog {
    int age;
    String name;
    int weight;

    public Dog(int age, String name, int weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog [age=" + age + ", name=" + name + ", weight=" + weight + "]" + "\n";
    }

    public int getAge() {
        return age;
    }    
}
