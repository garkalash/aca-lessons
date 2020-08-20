package com.aca.collections;


import java.util.*;

abstract class Animal {
    public abstract void makeNoise();
}

class Dog extends Animal{

    @Override
    public void makeNoise() {
        System.out.println("Haf haf");
    }
}

class Cat extends Animal {

    @Override
    public void makeNoise() {
        System.out.println("Meu meu");
    }
}


class Farm<T extends Animal> {
    private List<T> animals = new ArrayList<>();

    public void addOneAnimal(T animal){
        animals.add(animal);
    }

    public void addAnimals(List<? extends T> newAnimals) {
        animals.addAll(newAnimals);
    }

    public static void main(String[] args) {
        Farm<Animal> farm = new Farm<>();
        Cat oneCat = new Cat();
        farm.addOneAnimal(oneCat);
        Dog oneDog = new Dog();
        farm.addOneAnimal(oneDog);

        List<Animal> dogs = Arrays.asList(new Dog(), new Dog());
        farm.addAnimals(dogs);
        List<Cat> cats = Arrays.asList(new Cat(), new Cat(), new Cat());
        farm.addAnimals(cats);
    }
}

class A {
    private Integer data;
    public A(){
        data = new Random().nextInt();
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}




class Generic<T extends Number>{
    T[] data;

    public Generic(T... objs) {
        this.data = objs;
    }





    public static void main(String[] args) {
        Generic<Integer> generic = new Generic<>(5, 2, 3);
        System.out.println("All is ok");
    }
}


public class Main {
    public static void main(String[] args) {
    }


    static final Object object = new Object();
    static Map<Object, Object> map = new HashMap<>();


    private static <T>  void add(T obj){
        map.put(obj, object);
    }

    /*
    * ordered items
    */
    private static void lists(){
        List<String> stringsArray = new ArrayList<>();
        stringsArray.add("A");
        stringsArray.add("B");
        stringsArray.add("C");
        stringsArray.add("D");
        Node node3 = new Node();
        node3.a = 25;

        Node node2 = new Node();
        node2.a = 22;
        node2.next = node3;


        Node node1 = new Node();
        node1.a = 20;
        node1.next = node2;

        System.out.println(node1.next.next.a); //1



                //fail-fast examples
                Iterator<String> itr = stringsArray.iterator();

        while (itr.hasNext()) {
            String a = itr.next();
            stringsArray.remove(0);
        }

        for(String s: stringsArray) {

        }

        stringsArray.forEach(s -> {
            stringsArray.remove(1);
        });

        //list iterator
        Iterator<String> a = stringsArray.listIterator();

        //list types
        List<String> stringsNode = new LinkedList<>();
        List<String> stringsVector = new Vector<>();

        Stack<String> stack = new Stack<>();

    }

    /*
     * unordered
     */
    private static void sets(){


    }



    private static void queues(){
        Queue<String>   queue = new PriorityQueue<>();
        queue.add("a");
    }

    private static void maps(){
        Map<String, Integer> nameAges = new HashMap<>();
        nameAges.put("John", 55);
        nameAges.put("Johnson", 65);
        nameAges.put("Klein", 21);

        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        System.out.println(a1.getData());
        System.out.println(a2.getData());
        System.out.println(a3.getData());


        Comparator<A> aComparator = new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.getData() - o2.getData();
            }
        };
        Map<A, Integer> as = new TreeMap<>(aComparator);

        as.put(a1, 5);
        as.put(a2, 6);
        as.put(a3, 7);
        //try without comparator
        //then add comparator
        //then implement it
        System.out.println(as.keySet());
        System.out.println(as.get(a1));
        System.out.println(as.get(a2));
        System.out.println(as.get(a3));
    }

    //

    private static void utilities() {
        List<String> fruits = new ArrayList<>();
        List<String> otherFruits = new ArrayList<>();
        Collections.addAll(fruits, "Apples", "Oranges", "Banana");

        Collections.sort(fruits);

        int index = Collections.binarySearch(fruits, "aa");

        Collections.copy(fruits, otherFruits);

        Collections.fill(fruits, null);

        String maxFruit = Collections.max(fruits);

        Arrays.asList("Hello", "world");
    }

    private static Map<String, Integer> wordCounts(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        Map<String, Integer> counts = new HashMap<>();
        for(String word : words){
            counts.putIfAbsent(word, 0);
            counts.put(word, counts.get(word) +1);
        }
        return counts;
    }

    private static Set<String> distinctWords(String joinedWords) {
        Set<String> set = new TreeSet<>();
        set.addAll(Arrays.asList(joinedWords.split(" ")));
        return set;
    }




}

final class Lesson {
    private final String name;

    public Lesson(String name) {
        if(name == null) throw new RuntimeException("Don't write null name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return name.equals(lesson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student {
    private final String name;
    private final List<Lesson> lessons;

    public Student(String name, List<Lesson> lessons) {
        this.name = name;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}


class Node{
    Integer a;
    Node next;
}
