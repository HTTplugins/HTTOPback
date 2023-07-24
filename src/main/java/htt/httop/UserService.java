
package htt.httop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        // Realiza la consulta en la base de datos para verificar si el nombre de usuario ya está en uso
        User existingUser = userRepository.findByUsername(username);
        return existingUser != null;
    }

    public boolean isEmailInUse(String email) {
        // Realiza la consulta en la base de datos para verificar si el correo electrónico ya está en uso
        User existingUser = userRepository.findByMail(email);
        return existingUser != null;
    }

    public boolean isPasswordCorrect(User user){
        User checkingUser = userRepository.findByMail(user.getMail());

        return BCrypt.checkpw(user.getPassword(), checkingUser.getPassword());


    }

    public User getUserByEmail(String email) {
        // Realiza la consulta en la base de datos para obtener los datos del usuario por su email
        return userRepository.findByMail(email);
    }
}
