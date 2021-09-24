import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonJdbcImpl implements PersonInterface {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    //language=SQL
    private static final String SQL_INSERT_PERSON = "insert into slavdom (id, name, totem, count_of_siblings) values (nextval('slavdom_seq'), ?, ?, ?)";

    public PersonJdbcImpl(DataSource dataSource) throws FileNotFoundException {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Person person) {
        try (Connection c = dataSource.getConnection(); PreparedStatement statement = c.prepareStatement(SQL_INSERT_PERSON)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getTotem());
            statement.setInt(3, person.getCount_of_siblings());
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void insertFromArrays(List<String> list1, List<String> list2) {
        try (Connection c = dataSource.getConnection(); PreparedStatement statement = c.prepareStatement(SQL_INSERT_PERSON)) {
            statement.setString(1, list1.get((int)Math.floor(Math.random() * list1.size())));
            statement.setString(2, list2.get((int)Math.floor(Math.random() * list2.size())));
            statement.setInt(3, (int)Math.floor(Math.random() * 30));
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }


}