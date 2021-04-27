package group.functional.fileWriteRead;

import group.person.Person;

import java.io.*;
import java.util.List;

public class WriterGroup implements WorkFile {

    @Override
    public void metod(List<Person> group, String nameFile) {
        write(group, new File(nameFile));
    }

    private void write(List<Person> group, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeInt(group.size());
            for (Person person : group) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void metod(List<Person> group, File file) {
        write(group, file);
    }
}
