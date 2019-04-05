package codesquad.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping("")
    public String userForm() {
        return "user/form";
    }

    @PostMapping("")
    public String createUser(User user) {
        users.add(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{userId}")
    public String userProfile(@PathVariable String userId, Model model) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.isSameUserId(userId)) {
                model.addAttribute("user", user);
                break;
            }
        }
        return "user/profile";
    }
}
