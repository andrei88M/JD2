import java.io.*;
import java.util.List;
import java.util.Set;

public class GroupWrite {
    File file;
    List<Person> group;

    public GroupWrite() {
    }

    public GroupWrite(File file, List<Person> group) {
        this.file = file;
        this.group = group;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setGroup(List<Person> group) {
        this.group = group;
    }

    public void metod() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            int size = group.size();
            oos.writeInt(size);
            for (Person p : group) {
                oos.writeObject(p);
            }
            group.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
