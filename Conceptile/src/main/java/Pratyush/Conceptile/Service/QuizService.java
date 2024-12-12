package Pratyush.Conceptile.Service;

import Pratyush.Conceptile.Model.*;
import Pratyush.Conceptile.Repo.QuestionRepo;
import Pratyush.Conceptile.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String topic, int num, String title) {
        List<Questions> questions = questionRepo.findRandomQuestionsByTopic(topic, num);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Questions> questionsFromDB = quiz.get().getQuestions();
        List<QuestionDTO> questionsForUsers = new ArrayList<>();
        for(Questions q: questionsFromDB){
            QuestionDTO question = new QuestionDTO(
                    q.getQuestionId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );
            questionsForUsers.add(question);
        }
        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }


    public ResponseEntity<List<UserAnswer>> result(Integer quizId, List<UserAnswer> userAnswers) {
        Optional<Quiz> quiz = quizRepo.findById(quizId);
        List<Questions> questions = quiz.get().getQuestions();
        List<UserAnswer> userAnswersStatus = new ArrayList<>();
        int i=0;
        for(UserAnswer userAnswer: userAnswers){
            if(userAnswer.getAnswer().equals(questions.get(i).getCorrectAnswer())){
                userAnswersStatus.add(new UserAnswer(userAnswer.getQuestionId(), "Correct"));
            }
            else{
                userAnswersStatus.add(new UserAnswer(userAnswer.getQuestionId(), "Incorrect"));
            }
            i++;
        }
        return new ResponseEntity<>(userAnswersStatus, HttpStatus.OK);
    }
}
