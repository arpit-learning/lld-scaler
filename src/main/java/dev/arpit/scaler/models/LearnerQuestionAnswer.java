package dev.arpit.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scaler_learner_question_response")
public class LearnerQuestionAnswer extends BaseModel {
    @ManyToOne(optional = false)
    @JoinColumn(name = "learner_id", referencedColumnName = "id")
    private Learner learner;
    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @ManyToOne(optional = false)
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private Option option;
}
