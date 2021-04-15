import java.io.File;
import java.util.*;

public class Group {
    GroupWrite groupWrite;
    GroupRead groupRead;
    Generate generate;
    GroupRes groupRes;
    private List<Person> list;

    private File file;

    public Group() {
        this.groupWrite = new GroupWrite();
        this.groupRead = new GroupRead();
        this.generate = new Generate();
        this.groupRes = new GroupRes();
    }

    public void write(File file) {
        this.file = file;
        groupWrite.setFile(file);
        groupWrite.setGroup(list);
        groupWrite.metod();
    }

    public void read() {
        groupRead.setFile(file);
        groupRead.setList(list);
        groupRead.metod();
    }

    public void generateRandomGroup(int quantityPerson, int fromAge, int toAge) {
        list = generate.getRandomGroup(quantityPerson, fromAge, toAge);
    }

    public void printBundleAndSurnameName() {
        groupRes.setList(list);
        groupRes.printListStr();
    }

    public void printLessThanAge(int age) {
        list.stream()
                .filter((person) -> person.getAge() < age)
                .forEach(System.out::println);
    }

    public void sort(Sort sort1, Sort sort2) {
        Set<Person> set = new TreeSet<>(sort1.thenComparing(sort2));
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }

    public static void main(String[] args) {
        Group group = new Group();
        group.generateRandomGroup(100, 15, 30);
        group.printLessThanAge(21);
        group.sort(new SortSurname(), new SortName());
        group.write(new File("group.txt"));
        group.read();
        group.printBundleAndSurnameName();
    }
}
