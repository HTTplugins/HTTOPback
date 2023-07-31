package htt.httop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.insertarUsuario(user.getUsername(), user.getMail(), user.getPassword());
    }

    @GetMapping("/getUserByEmail")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/checkUsername")
    public boolean checkUserInUse(@RequestBody String username) {
        return userService.isUsernameInUse(username);
    }

    @PostMapping("/checkMail")
    public boolean checkMailInUse(@RequestBody String mail) {
        System.out.println("mailcall");
        return userService.isEmailInUse(mail);
    }

    @PostMapping("/checkAdmin")
    public boolean checkAdmin(@RequestBody String mail) {
        return userService.checkAdmin(mail);
    }

    @PostMapping("/checkPassword")
    public boolean checkPassword(@RequestBody User user) {
        return userService.isPasswordCorrect(user);
    }
}
