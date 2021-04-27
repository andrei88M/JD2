package group.functional.datebase;

import group.person.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WriterDB extends DB implements ConnectorMysql {

    public void metodMysql(List<Person> group) {
        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("create table if not exists people(" +
                    "id int auto_increment," +
                    "surname varchar (200)," +
                    "name varchar (200)," +
                    "age int," +
                    "salary double," +
                    "passport char (10)," +
                    "addres varchar (200)," +
                    "dateOfBirthday date," +
                    "dateTimeCreate datetime," +
                    "timeToLunch time," +
                    "letter text," +
                    "primary key (id))");
            for (Person person : group) {
                int age = person.getAge();
                String name = person.getName();
                String surname = person.getSurname();
                statement.executeUpdate(
                        "INSERT INTO people(surname,name,age)" +
                                " VALUES ('" + surname + "','" + name + "'," + age + ")");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
