package springboot.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springboot.demo.model.User;
import springboot.demo.model.dto.UserDto;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT new springboot.demo.model.dto.UserDto(u.userId, u.profileName,"
            + " COUNT(r.user)) FROM User u JOIN Review r ON u.userId = r.user.userId GROUP BY "
            + "r.user.userId, r.user.profileName ORDER BY COUNT(r.user) DESC")
    Page<UserDto> findMostActiveUsers(Pageable pageable);
}
