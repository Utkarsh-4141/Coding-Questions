package Concepts.Comparable_Comparator;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        Animal a1 = new Animal(5, "Chetak", 20);
        Animal a2 = new Animal(2, "Tommy", 10);
        Animal a3 = new Animal(2, "Bruno", 6);
        Animal a4 = new Animal(4, "Max", 15);

        List<Animal> dogs = new ArrayList<>();
        dogs.add(a1);
        dogs.add(a2);
        dogs.add(a3);
        dogs.add(a4);

        System.out.println(dogs + "\n");
        Collections.sort(dogs);
        System.out.println(dogs);
    }
}

class Animal implements Comparable<Animal> {
    int age;
    String name;
    int weight;

    public Animal(int age, String name, int weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal [age=" + age + ", name=" + name + ", weight=" + weight + "]" + "\n";
    }

    @Override
    public int compareTo(Animal o) {
        if(this.age-o.age == 0) {
            return this.name.compareTo(o.name);
        }
        return this.age - o.age;
    }
}
