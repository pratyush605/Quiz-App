package Pratyush.Conceptile.Controller;

import Pratyush.Conceptile.Model.QuestionDTO;
import Pratyush.Conceptile.Model.UserAnswer;
import Pratyush.Conceptile.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
            @RequestParam("Topic") String topic,
            @RequestParam("NumberOfQuestions") int num,
            @RequestParam("Title") String title){
        return quizService.createQuiz(topic, num, title);
    }

    // As we are using auto generate for questionId in Questions Table.
    // We need to use that id which is in database. usually it is 1 and so on.
    @GetMapping("/get/{quizId}")
    // This API is to get list of all the questions which are to be answered.
    public ResponseEntity<List<QuestionDTO>>getQuizQuestions(@PathVariable("quizId") Integer id){
        return quizService.getQuizQuestions(id);
    }
    // the GetMapping questionId and submit quiz questionId should be same.
    // Sequence of questions answered (json) during submission should be equal to sequence of quiz questions (json).
    @PostMapping("/{quizId}/submit")
    public ResponseEntity<List<UserAnswer>> quizSubmit(
            @PathVariable("quizId") Integer quizId,
            @RequestBody List<UserAnswer> userAnswers){
        return quizService.result(quizId, userAnswers);
    }
}