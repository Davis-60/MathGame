package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    int correctCount;
    String ansInputString;
    mathProblem currentProblem;
    TextView problemDisplay;
    TextView displayCount;
    TextView answerInput;
    int randomBound = 50;
    CheckBox hardMode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View parentLayout = findViewById(android.R.id.content);



        //Finding checkbox
        hardMode = findViewById(R.id.hardModeCheck);
        hardMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    Snackbar message = Snackbar.make(parentLayout, "Hard Mode Activated", Snackbar.LENGTH_LONG);
                    message.show();
                    randomBound = 500;
                }
                else {
                    randomBound = 50;
                }
            }
        });


        //Finding my text views
        TextView problemDisplay = findViewById(R.id.problemView);
        this.problemDisplay = problemDisplay;

        TextView displayCount = findViewById(R.id.countView);
        this.displayCount = displayCount;

        TextView answerInput = findViewById(R.id.solutionInput);
        this.answerInput = answerInput;

        //Creating a problem determining object


        //Creating the initial problem
        mathProblem originalProblem = new mathProblem(randomBound);

        currentProblem = originalProblem;

        problemDisplay.setText(currentProblem.numOne + " " + currentProblem.operator +"  " + currentProblem.numTwo);
        correctCount = 0;
        displayCount.setText(String.valueOf(correctCount));

    }

    public void checkClick(View view) {
        //Checking if the answer in the textbox matches the answer variable of my multProblem object
        ansInputString = answerInput.getText().toString();

        if (ansInputString.equals(currentProblem.answer)) {
            correctCount += 1;

            //Making a snackbar
            String congratsMessage = "Great Job!";
            Snackbar.make(view, congratsMessage, Snackbar.LENGTH_SHORT).show();

        }

        else {
            String sadMessage = "Good try, but the answer was " + currentProblem.answer;
            Snackbar.make(view, sadMessage, Snackbar.LENGTH_LONG).show();
        }
        //Updating displayCount
        displayCount.setText(String.valueOf(correctCount));



        //Setting up a new question
        answerInput.setText("");
        currentProblem = new mathProblem(randomBound);
        String newText = currentProblem.numOne + " " + currentProblem.operator +"  " + currentProblem.numTwo;
        problemDisplay.setText(newText);
    }
}
