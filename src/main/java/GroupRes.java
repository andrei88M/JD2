import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GroupRes extends Thread {
    private List<Person> list;

    public void setList(List<Person> list) {
        this.list = list;
    }

    public void printListStr() {
        List<String> strGroup = new ArrayList<>();
        for (Person p : list) {
            String name = p.getName();
            String surname = p.getSurname();
            strGroup.add(surname + name);
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res");
        for (String o : strGroup) {
            System.out.print(resourceBundle.getString("nameSurname"));
            System.out.println("  " +o);
        }
    }

    @Override
    public void run() {

    }
}
