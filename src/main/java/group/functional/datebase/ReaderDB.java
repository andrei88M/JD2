package group.functional.datebase;

import group.person.Person;

import java.sql.*;
import java.util.List;

public class ReaderDB extends DB implements ConnectorMysql {

    @Override
    public void metodMysql(List<Person> strList) {
        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM people");
            strList.clear();
            while (result.next()) {
                Person person = Person.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .surname(result.getString("surname"))
                        .age(result.getInt("age"))
                        .address(result.getString("addres"))
                        .build();
                strList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
