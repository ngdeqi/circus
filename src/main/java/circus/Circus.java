package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        System.out.println("number of animals in the circus: " + animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        animalArrayList.add(new Duck("Goose"));
        animalArrayList.add(new Parrot("Dally"));
        animalArrayList.add(new Tiger("Simba"));
        animalArrayList.add(new Elephant("Dumbo"));
        Elephant louise = new Elephant("louise");
        animalArrayList.add(louise);
        System.out.println("number of animals in circus: " + animals.length);

        System.out.println("Before sorting: ");
        printAllAnimals(animalArrayList);

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After sorting: ");
        printAllAnimals(animalArrayList);
        System.out.println("Index of Louise after sort: " + animalArrayList.indexOf(louise));


        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Scrooge");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Popper");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal animal: animalArrayList) {
            System.out.print(animal.name + ", ");
        }
        System.out.println();
    }
}
