import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRead {
    List<Person> list;
    File file;

    public GroupRead() {
    }

    public GroupRead(List<Person> list, File file) {
        this.list = list;
        this.file = file;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public void setFile(File file) {
        this.file = file;
    }
    public void metod() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                Person person = (Person) ois.readObject();
                list.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
