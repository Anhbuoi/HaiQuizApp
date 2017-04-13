package net.androidbootcamp.haiquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class multipleChoice extends AppCompatActivity {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;

    private String mAnswer;
    private int mScore =0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1= (Button)findViewById(R.id.choice1);
        mButtonChoice2= (Button)findViewById(R.id.choice2);
        mButtonChoice3= (Button)findViewById(R.id.choice3);
        mButtonQuit = (Button)findViewById(R.id.btnQuit);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    //This Line of code is just a toast
                    Toast.makeText(multipleChoice.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(multipleChoice.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listner for Button1

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    //This Line of code is just a toast
                    Toast.makeText(multipleChoice.this, "Correct!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(multipleChoice.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listner for Button2

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    //updateQuestion();

                    //This Line of code is just a toast
                    Toast.makeText(multipleChoice.this, "Correct!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(multipleChoice.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(multipleChoice.this, MenuActivity.class));
            }
        });

    }

    private void updateQuestion(){

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            if(mQuestionNumber < 3)
                mQuestionNumber++;


    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }
}
