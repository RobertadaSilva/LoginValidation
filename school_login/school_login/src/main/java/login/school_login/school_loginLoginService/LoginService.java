package login.school_login.school_loginLoginService;

import login.school_login.school_loginLoginDomain.Login;
import login.school_login.school_loginLoginRepository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private LoginRepository repo;

    public Login login(String username, String password) {
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }


}