package codesquad.question;

import codesquad.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Geon Hee Sung.
 * Date: 2019-04-05
 * Time: 오후 1:23
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("")
    public String questionForm(HttpSession httpSession) {
        User loginUser = (User) httpSession.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:users/login";
        }
        return "qna/form";
    }

    @PostMapping("")
    public String createQuestion(Question question, HttpSession httpSession) {
        User loginUser = (User) httpSession.getAttribute("loginUser");
        question.setWriter(loginUser.getName());
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        return "qna/show";
    }
}