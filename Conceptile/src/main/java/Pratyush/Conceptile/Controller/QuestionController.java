package Pratyush.Conceptile.Controller;

import Pratyush.Conceptile.Model.Questions;
import Pratyush.Conceptile.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/Topic/{topic}") //{topic} can be either Java or SQL for default questions.
    public ResponseEntity<List<Questions>> getAllQuestionsByTopic(@PathVariable String topic){
        return questionService.getAllQuestionsByTopic(topic);
    }
}
