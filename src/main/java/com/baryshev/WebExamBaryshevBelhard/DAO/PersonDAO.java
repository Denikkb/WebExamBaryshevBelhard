package com.baryshev.WebExamBaryshevBelhard.DAO;

import com.baryshev.WebExamBaryshevBelhard.Model.Person;
import com.baryshev.WebExamBaryshevBelhard.rowMapper.PeopleWithProductRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonDAO {
    //общение с БД

   /* private List<Person> people;

    {
        people= new ArrayList<>();
        people.add(new Person(1, "Denis1", "Baryshev1"));
        people.add(new Person(2, "Denis2", "Baryshev2"));
        people.add(new Person(3, "Denis3", "Baryshev3"));


    }

    */

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:testdb";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    private static Connection connection;

static {
    try {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //STEP 2: Open a connection
        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DB_URL,USER,PASS);


    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PersonDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Person> showAllPersons () throws SQLException {
    List<Person> people= new ArrayList<>();
    Statement statement = connection.createStatement();
    String SQL = "SELECT * FROM Persons";
    ResultSet resultSet= statement.executeQuery(SQL);
    while(resultSet.next()){
        Person person = new Person();
        person.setPersonId(resultSet.getInt("PersonId"));
        person.setFirstName(resultSet.getString("Firstname"));
        person.setLastName(resultSet.getNString("Lastname"));

        people.add(person);
    }
    return people;
    };


   public Person showPerson(int id) throws SQLException {
        //return people.stream().filter(person -> person.getPersonId()==id).findAny().orElse(null);
       Person person = null;

       PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM Persons WHERE PersonId=?");
       preparedStatement.setInt(1, id);
       ResultSet resultSet= preparedStatement.executeQuery();

       resultSet.next();

       person = new Person();


       person.setPersonId(resultSet.getInt("PersonId"));
       person.setFirstName(resultSet.getString("FirstName"));
       person.setLastName(resultSet.getString("LastName"));

      return person;
    }


   public void save( Person person) throws SQLException {

       PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO Persons(FirstName, LastName) VALUES (?, ?)");
       preparedStatement.setString(1,person.getFirstName());
       preparedStatement.setString(2,person.getLastName());

       preparedStatement.executeUpdate();

       /*Statement statement = connection.createStatement();
       String SQL = "INSERT INTO Persons(FirstName, LastName ) VALUES ('"+person.getFirstName()+"','"+person.getLastName()+"')";
       statement.executeUpdate(SQL);*/

        //people.add(person);
    }

    public void update (int id, Person updatedPerson) throws SQLException {
        /*Person personToUpdate = showPerson(id);

        personToUpdate.setFirstName(updatedPerson.getFirstName());
        personToUpdate.setLastName(updatedPerson.getLastName());
        personToUpdate.setPersonId(updatedPerson.getPersonId());*/
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Persons SET FirstName=?, LastName=? WHERE PersonId=?");
        preparedStatement.setString(1,updatedPerson.getFirstName());
        preparedStatement.setString(2,updatedPerson.getLastName());
        preparedStatement.setInt(3, id);

        preparedStatement.executeUpdate();


    }

    public void delete (int id) throws SQLException {
        //people.removeIf(p ->p.getPersonId()==id );
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("DELETE FROM Persons WHERE PersonId=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    public Object peopleWithProduct (int id) {
        Map<String , Object> param = new HashMap<>();
        param.put("PersonId", id);
        String GET_PEOPLE_WITH_PRODUCT = "SELECT PERSONS.PERSONID as Person_id , PERSONS.FIRSTNAME, PERSONS.LASTNAME, " +
                "PRODUCTS.NAMEPRODUCT, PRODUCTS.PRICE, PRODUCTS.QUANTITY from PERSONS INNER JOIN PRODUCTS ON PERSONS.PERSONID = PRODUCTS.ID_PERSON " +
                "WHERE PERSONS.PERSONID  = :PersonId";

         return namedParameterJdbcTemplate.query(GET_PEOPLE_WITH_PRODUCT, param, new PeopleWithProductRowMapper());


    };
}