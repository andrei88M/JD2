package group.functional.fileWriteRead;

import group.person.Person;

import java.io.File;
import java.util.List;

public interface WorkFile {
    void metod(List<Person> group,String addressFile);
    void metod(List<Person> group, File file);
}
