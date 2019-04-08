//package codesquad.question;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Geon Hee Sung.
// * Date: 2019-04-05
// * Time: 오후 1:23
// */
//@Controller
//@RequestMapping("/questions")
//public class QuestionController {
//    public static List<Question> questions = new ArrayList<>();
//
//    @GetMapping("")
//    public String questionForm() {
//        return "qna/form";
//    }
//
//    @PostMapping("")
//    public String createQuestion(Question question) {
//        question.setId(questions.size() + 1);
//        questions.add(question);
//        return "redirect:/";
//    }
//
//    @GetMapping("/{id}")
//    public String showQuestion(@PathVariable int id, Model model) {
//        model.addAttribute("question", questions.get(id - 1));
//        return "qna/show";
//    }
//}
