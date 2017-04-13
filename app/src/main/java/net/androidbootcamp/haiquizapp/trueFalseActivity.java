package net.androidbootcamp.haiquizapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class trueFalseActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mScoreView;
    private int mScore =0;
    private TextView mQuestionTextView;

    //Array of questions and their answer
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, false),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true)
    };

    private int mCurrentIndex=0;
    private int mPreviewIndex= mCurrentIndex+1;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }


    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue= mQuestionBank[mCurrentIndex].isTrueQuestion();

        int messageResId = 0;
        if(userPressedTrue==answerIsTrue){
            messageResId= R.string.correct_toast;
            mScore = mScore + 1;
            updateScore(mScore);
        }
        else{
            messageResId= R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);


        mScoreView = (TextView)findViewById(R.id.score);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //previewQuestion();
                if(mCurrentIndex==8)
                    Toast.makeText(trueFalseActivity.this, mQuestionBank[0].getQuestion(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(trueFalseActivity.this, mQuestionBank[mCurrentIndex+1].getQuestion(), Toast.LENGTH_SHORT).show();

/*
                if(mQuestionBank[mCurrentIndex+1]==mQuestionBank[mQuestionBank.length-1]) {
                    Toast.makeText(QuizActivity.this, mQuestionBank[0].getQuestion(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, mQuestionBank[mCurrentIndex+1].getQuestion(), Toast.LENGTH_SHORT).show();
                }
*/
            }
        });
        //int question = mQuestionBank[mCurrentIndex].getQuestion();
        //mQuestionTextView.setText(question);

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;//page 67
                //int question = mQuestionBank[mCurrentIndex+1].getQuestion();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mCurrentIndex==0)
                    mCurrentIndex = (mQuestionBank.length-1);
                else
                    mCurrentIndex = (mCurrentIndex-1) % mQuestionBank.length;//page 67
                //int question = mQuestionBank[mCurrentIndex+1].getQuestion();
                //mQuestionTextView.setText(question);
                updateQuestion();
            }
        });

        updateQuestion();//Shows the first question
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }



}
