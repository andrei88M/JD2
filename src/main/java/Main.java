import group.Group;
import group.functional.datebase.ReaderDB;
import group.functional.datebase.WriterDB;
import group.functional.fileWriteRead.ReaderGroup;
import group.functional.fileWriteRead.WriterGroup;
import group.functional.printer.Selection;
import group.person.Person;
import group.person.Generate;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        for (int i = 0; i < 100; i++) {
            Person person = Person.builder()
                    .surname(Generate.getRandomSurname())
                    .name(Generate.getRandomName())
                    .age(Generate.getRandomAge(15, 30))
                    .address("Minsk")
                    .id(i)
                    .build();
            group.add(person);
        }
        group.printSelection(Selection.MORE_THAN, 21);
        group.sorting(Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
        group.setWorkFile(new WriterGroup());
        group.writeOrRead("people.txt");
        group.setWorkFile(new ReaderGroup());
        group.writeOrRead("people.txt");
        startingThread(group);
        group.printStrListAndResources();
        group.setConnectorMysql(new WriterDB());
        group.writeDBorReadDB();
        group.setConnectorMysql(new ReaderDB());
        group.writeDBorReadDB();
        group.print();
    }

    private static void startingThread(Group group) {
        Thread thread=new Thread(group::transformInStr);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}