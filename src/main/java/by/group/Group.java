package by.group;

import java.io.*;
import java.util.*;

public class Group {
    public static void main(String[] args) {
        List<Person> group = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String name = "name" + (int) (Math.random() * 7 + 1);
            String surname = "surname" + (int) (Math.random() * 7 + 1);
            int age = (int) (Math.random() * 16 + 15);
            group.add(new Person(name, surname, age));
        }
        Comparator<Person> sortSurname = Comparator.comparing(Person::getSurname);
        Comparator<Person> sortName = Comparator.comparing(Person::getName);
        Set<Person> sortGroup = new TreeSet<>(sortSurname.thenComparing(sortName));
        group.stream().filter(person -> person.getAge() < 21).forEach(sortGroup::add);

        File file = new File("1.txt");
        writePeople(sortGroup, file);
        Runnable runnable = () -> createListFromReadFile(file);
        Thread thread = new Thread(runnable);
        thread.start();

        //ResourceBundle resourceBundle = ResourceBundle.getBundle("res_en");
       /* Exception in thread "main" java.util.MissingResourceException: Can't find bundle for base name res_en, locale ru_RU
        at java.base/java.util.ResourceBundle.throwMissingResourceException(ResourceBundle.java:2048)
        at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1682)
        at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1586)
        at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1549)
        at java.base/java.util.ResourceBundle.getBundle(ResourceBundle.java:856)
        at by.group.Group.main(Group.java:26)*/




    }

    private static void createListFromReadFile(File file) {
        List<String> stringList = new ArrayList<>();
        readPersonFromFile(file, stringList);
        stringList.forEach(System.out::println);
    }

    private static void writePeople(Set<Person> sortGroup, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            int size = sortGroup.size();
            oos.writeInt(size);
            for (Person p : sortGroup) {
                oos.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPersonFromFile(File file, List<String> stringList) {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Person person = (Person) ois.readObject();
                stringList.add(person.getSurname() + person.getName());
            }

            System.out.println(stringList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
