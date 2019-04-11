package codesquad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String userForm() {
        return "user/form";
    }

    @PostMapping("")
    public String createUser(User user) {
        userRepository.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/{id}")
    public ModelAndView userProfile(@PathVariable Long id, Model model) {
        ModelAndView mav = new ModelAndView("user/profile");
        mav.addObject("user", userRepository.findById(id).get());
        return mav;
    }

    @GetMapping("{id}/checkForm")
    public String userCheckForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        return "user/checkUser";
    }

    @PostMapping("/{id}/checkUser")
    public String checkPassword(@PathVariable Long id, String password, Model model) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user.checkPassword(password)) {
            return "redirect:/users/" + id + "/form";
        }
        model.addAttribute("user", user);
        return "user/checkUser";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        return "user/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User updateUser) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        user.update(updateUser);
        userRepository.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession httpSession) {
        User maybeUser = userRepository.findByUserId(userId);
        if (maybeUser != null) {
            if (maybeUser.checkPassword(password)) {
                httpSession.setAttribute("loginUser", maybeUser);
                return "redirect:/";
            }
        }
        return "user/login_failed";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("loginUser");
        return "redirect:/";
    }
}
