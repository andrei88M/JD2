import java.util.ArrayList;
import java.util.List;

public class Generate {
    public  int getGenerateAge(int from, int to) {
        return (int) (Math.random() * (to - from + 1) + from);
    }

    public  String getGenerateName() {
        return "name" + (int) (Math.random() * 5 + 1);
    }

    public  String getGenerateSurname() {
        return "surname" + (int) (Math.random() * 5 + 1);
    }

    public  List<Person> getRandomGroup(int quantityPerson, int fromAge, int toAge) {
        List<Person> group = new ArrayList<>(quantityPerson);
        for (int i = 0; i < quantityPerson; i++) {
            Person person = new PersonBulder()
                    .setName(getGenerateName())
                    .setSurname(getGenerateSurname())
                    .setAge(getGenerateAge(fromAge,toAge)).buld();
            group.add(person);
        }
        return group;
    }
}
