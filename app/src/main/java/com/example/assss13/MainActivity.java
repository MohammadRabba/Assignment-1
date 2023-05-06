package com.example.assss13;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    // setting up things
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private Button prevButton;
    private Button exit;

    private TextView questionTextView;
    private TextView questionNum;
    private int correct = 0;
    // to keep current question track
    private int currentQuestionIndex = 0;

    private Question[] cat = new Question[] {
            new Question(R.string.q1, true),
            new Question(R.string.q2, false),
            new Question(R.string.q3, true),
            new Question(R.string.q4, true),
            new Question(R.string.q5, false),
            new Question(R.string.q6, false),

    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up the buttons
        // associated with id
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        questionNum = findViewById(R.id.questionNum);
        exit=findViewById(R.id.exit);
        questionTextView = findViewById(R.id.answer_text_view);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        exit.setOnClickListener(this);

        for(int i=0;i<=6;i++) {
            Collections.shuffle(Arrays.asList(cat));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.false_button) {
                checkAnswer(false);
                falseButton.setEnabled(false);
                trueButton.setEnabled(false);
                } else if (v.getId()==R.id.true_button) {
            checkAnswer(true);
            falseButton.setEnabled(false);
            trueButton.setEnabled(false);

        } else if (v.getId()==R.id.next_button) {
            falseButton.setEnabled(true);
            trueButton.setEnabled(true);
            if (currentQuestionIndex < 7) {
                currentQuestionIndex
                        = currentQuestionIndex + 1;
questionNum.setText("Question Number : "+currentQuestionIndex);

                if (currentQuestionIndex == 6) {
                    questionTextView.setText(getString(
                            R.string.correct, correct));
                    nextButton.setVisibility(
                            View.INVISIBLE);
                    prevButton.setVisibility(
                            View.INVISIBLE);
                    trueButton.setVisibility(
                            View.INVISIBLE);
                    falseButton.setVisibility(
                            View.INVISIBLE);
                        questionTextView.setText(
                                "You Get " + correct
                                        + " Points "
                                        + "From 6 Points");
                }
                else {
                    updateQuestion();
                }
            }
        } else if (v.getId()==R.id.prev_button) {
            falseButton.setEnabled(true);
            trueButton.setEnabled(true);
            if (currentQuestionIndex > 0) {
                currentQuestionIndex
                        = (currentQuestionIndex - 1)
                        % cat.length;
                updateQuestion();
            }

        } else if (v.getId()==R.id.exit) {
            System.exit(0);

        }
    }


    private void updateQuestion()
    {

        questionTextView.setText(
                cat[currentQuestionIndex]
                        .getqId());
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = cat[currentQuestionIndex]
                .isqCorrect();
        int toastMessageId;



        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {

            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
