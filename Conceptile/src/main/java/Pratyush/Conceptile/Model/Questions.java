package Pratyush.Conceptile.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String topic;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    public Questions() {
    }

    public Questions(
            String topic,
            String questionTitle,
            String option1,
            String option2,
            String option3,
            String option4,
            String correctAnswer) {
        this.topic = topic;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }
}
