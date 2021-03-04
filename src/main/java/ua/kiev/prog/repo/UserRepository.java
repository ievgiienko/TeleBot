package ua.kiev.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.kiev.prog.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.notified = false " +
            "AND u.phone IS NOT NULL AND u.email IS NOT NULL")
    List<User> findNewUsers();

    User findByChatId(long id);
}
