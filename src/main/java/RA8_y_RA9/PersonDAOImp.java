package RA8_y_RA9;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImp implements PersonDAO{
   Connection connection = Conexion.getInstance().getConnection();
    @Override
    public Person getPersonByDNI(String dni) {
        Person person = null;
        // select *  from person where dni = "38356379d";
        String sql = "select *  from person where dni = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name  = resultSet.getString("name");
                String sDate = resultSet.getString("birthday");
                String sNChildren = resultSet.getString("nChildren");
                int nChildren = Integer.parseInt(sNChildren);  // "3" (String) -> 3 (int)
                LocalDate date = generateDate(sDate);
                person = new Person(name, dni, date, nChildren);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }



    @Override
    public List<Person> getPeople() {
        //select *  from person;
        List<Person> people = new ArrayList<>();
        String sql = "select *  from person;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name  = resultSet.getString("name");
                String dni  = resultSet.getString("dni");
                String sDate = resultSet.getString("birthday");
                String sNChildren = resultSet.getString("nChildren");
                int nChildren = Integer.parseInt(sNChildren);  // "3" (String) -> 3 (int)
                LocalDate date = generateDate(sDate);
                Person person = new Person(name, dni, date, nChildren);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public boolean deletePersonByDNI(String dni) {
        return false;
    }

    @Override
    public boolean insertPerson(Person person) {
        int rows = 0;
        String sql = "insert into person values (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getDni());
            String date = generateDateForDB(person.getBirthDay());
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, person.getNumberChilder() + "");
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows != 0;
    }

    @Override
    public boolean updateNameByDNI(String dni, String newName) {
        return false;
    }
    private LocalDate generateDate(String sDate) {
        //sDate viene "11/18/2023'"
        String[] tokens = sDate.split("/");
        int day   = Integer.parseInt(tokens[1]);
        int month = Integer.parseInt(tokens[0]);
        int year  = Integer.parseInt(tokens[2]);
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
    private String generateDateForDB(LocalDate date) {
        //2000-12-21    ->  "12-21-2000
        return String.format("%d/%d/%d", date.getMonthValue(), date.getDayOfMonth(),
                date.getYear());
    }
}
