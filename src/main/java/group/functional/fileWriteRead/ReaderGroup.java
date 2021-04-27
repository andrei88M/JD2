package group.functional.fileWriteRead;

import group.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderGroup implements WorkFile {
    @Override
    public void metod(List<Person> group, String addressFile) {
        File file = new File(addressFile);
        read(group, file);
    }

    @Override
    public void metod(List<Person> group, File file) {
        read(group, file);
    }

    private void read(List<Person> group, File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            List<Person> list = new ArrayList<>();
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Person person = (Person) ois.readObject();
                list.add(person);
            }
            /*group.clear();
            group.addAll(list);*/
            group = list;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
