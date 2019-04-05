package codesquad;

import codesquad.question.QuestionController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Geon Hee Sung.
 * Date: 2019-04-05
 * Time: 오후 1:14
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("questions", QuestionController.questions);
        return "index";
    }
}
