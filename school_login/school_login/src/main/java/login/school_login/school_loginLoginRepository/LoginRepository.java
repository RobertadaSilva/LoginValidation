package login.school_login.school_loginLoginRepository;

import login.school_login.school_loginLoginDomain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
    Login findByUsernameAndPassword(String username, String password);

}
