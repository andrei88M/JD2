package group;

import group.functional.datebase.ConnectorMysql;
import group.functional.fileWriteRead.WorkFile;
import group.functional.printer.Printer;
import group.functional.printer.Selection;
import group.functional.strList.Reformer;
import group.person.Person;
import group.person.Sorter;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Group {
    List<Person> group = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    WorkFile workFile;
    ConnectorMysql connectorMysql;

    public void setConnectorMysql(ConnectorMysql connectorMysql) {
        this.connectorMysql = connectorMysql;
    }
    public void setWorkFile(WorkFile workFile) {
        this.workFile = workFile;
    }
    public void writeOrRead(String addressFile){
        workFile.metod(group,addressFile);
    }
    public void writeOrRead(File file){
        workFile.metod(group,file);
    }
    public void transformInStr(){
    Reformer.transform(group,stringList);
    }
    public void print() {
        Printer.printPeople(group);
    }
    public void writeDBorReadDB(){
        connectorMysql.metodMysql(group);
    }
    public void printSelection(Selection selection, int age) {
        Printer.printSelection(selection, age, group);
    }
    public void printSurnameName(){
        Printer.printNameSurname(stringList);
    }
    public void printStrListAndResources(){
        Printer.printStrListAndResources(stringList);
    }
    public void sorting(Comparator<Person> comparator){
        Sorter.sorting(group,comparator);
    }
    public void add(Person person) {
        group.add(person);
    }
}
