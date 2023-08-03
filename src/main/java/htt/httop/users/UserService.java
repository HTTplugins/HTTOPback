
package htt.httop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public boolean checkAdmin(String mail) {
        User user = userRepository.findByMail(mail);
        return user.getAdmin();
    }
    public User insertarUsuario(String username, String mail, String password) {
        User user = new User();
        user.setUsername(username);
        user.setMail(mail);

        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    public boolean isUsernameInUse(String username) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser != null;
    }

    public boolean isEmailInUse(String email) {
        User existingUser = userRepository.findByMail(email);
        return existingUser != null;
    }

    public boolean isPasswordCorrect(User user){
        User checkingUser = userRepository.findByMail(user.getMail());
        return BCrypt.checkpw(user.getPassword(), checkingUser.getPassword());


    }

    public User getUserByEmail(String email) {
        return userRepository.findByMail(email);
    }
}
