package codesquad.question;

import codesquad.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        question.setWriter(loginUser.getUserId());
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).orElseThrow(IllegalArgumentException::new));
        return "qna/show";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model, HttpSession httpSession) {
        User loginUser = (User) httpSession.getAttribute("loginUser");
        Question question = questionRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (question.isSameWriter(loginUser)) {
            model.addAttribute("updateQuestion", question);
            return "qna/updateForm";
        }
        model.addAttribute("question", question);
        return "qna/work_failed";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, Question updateQuestion, HttpSession httpSession) {
        Question question = questionRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        questionRepository.save(question.update(updateQuestion));
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpSession httpSession, Model model) {
        User loginUser = (User) httpSession.getAttribute("loginUser");
        Question question = questionRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (question.isSameWriter(loginUser)) {
            questionRepository.delete(question);
            return "redirect:/";
        }
        model.addAttribute("question", question);
        return "qna/work_failed";
    }
}