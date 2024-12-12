package Pratyush.Conceptile.Repo;

import Pratyush.Conceptile.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer> {
    List<Questions> findAllByTopic(String topic);
    @Query(value = "SELECT * FROM questions q WHERE q.topic= :topic ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<Questions> findRandomQuestionsByTopic(String topic, int num);
}
