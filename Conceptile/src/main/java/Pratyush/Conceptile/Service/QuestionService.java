package Pratyush.Conceptile.Service;

import Pratyush.Conceptile.Model.Questions;
import Pratyush.Conceptile.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<List<Questions>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getAllQuestionsByTopic(String topic){
        try {
            return new ResponseEntity<>(questionRepo.findAllByTopic(topic), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
