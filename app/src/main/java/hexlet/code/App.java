package hexlet.code;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet")) {
            var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }
            var dao = new UserDAO(conn);
            var user1 = new User("Maria", "888888888");
            var user2 = new User("Victor", "1111111111");
            var user3 = new User("Igor", "77777777777");
            System.out.println(user1.getId());  // null
            dao.save(user1);
            dao.save(user2);
            dao.save(user3);
            System.out.print(user1.getId() + " " + user1.getName() + " " + user1.getPhone()); // Здесь уже выводится какой-то id
            System.out.print(user2.getId() + " " + user2.getName() + " " + user3.getPhone());
            System.out.println(user3.getId() + " " + user3.getName() + " " + user3.getPhone());

// Возвращается Optional<User>
            var user4 = dao.find(user1.getId()).get();
            System.out.println(Objects.equals(user4.getId(), user1.getId())); // true
            dao.delete(1L);
            System.out.println("delete first element");
            //dao.delete(2L);
            System.out.println("delete second element");
            dao.delete(3L);
            System.out.println("delete threes element");
            System.out.println(dao.find(1L));
            System.out.println(dao.find(2L));
        }
    }
}