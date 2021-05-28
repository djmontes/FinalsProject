package com.example.finalsproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class PlayCodename extends AppCompatActivity {
    Button btnA, btnB, btnC, btnD, btnStart;
    TextView lblQuiz, lblScore, lblQuestions;

    int score = 0;
    int items = 1;
    String mode, answer, question;
    List<String> arrayQuiz;
    int currentQuizIndex;

    public PlayCodename() {
        arrayQuiz = new ArrayList<String>();
        arrayQuiz.add("Quiz1");
        arrayQuiz.add("Quiz2");
        arrayQuiz.add("Quiz3");
        arrayQuiz.add("Quiz4");
        arrayQuiz.add("Quiz5");
        arrayQuiz.add("Quiz6");
        arrayQuiz.add("Quiz7");
        arrayQuiz.add("Quiz8");
        arrayQuiz.add("Quiz9");
        arrayQuiz.add("Quiz10");

        currentQuizIndex = 0;
        Collections.shuffle(arrayQuiz);
        Log.e("ARRAY LIST", " " + arrayQuiz);
    }

    public String getNextQuiz() {
        if (currentQuizIndex >= arrayQuiz.size()) {
            return "null";
        }
        String nextQuiz = arrayQuiz.get(currentQuizIndex);
        currentQuizIndex++;
        return nextQuiz;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_codename);
        setup();

        Intent intent = getIntent();
        mode = intent.getStringExtra("difficulty");
        Log.e("VALUES", "MODE: " + mode);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblQuiz.setVisibility(View.VISIBLE);
                lblScore.setVisibility(View.VISIBLE);
                lblQuestions.setVisibility(View.VISIBLE);
                btnA.setVisibility(View.VISIBLE);
                btnB.setVisibility(View.VISIBLE);
                btnC.setVisibility(View.VISIBLE);
                btnD.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
                question = getNextQuiz();
                gameMode();
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "A";
                items++;
                checker();
                Log.e("VALUES", "BUTTON A");
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "B";
                items++;
                checker();
                Log.e("VALUES", "BUTTON B");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "C";
                items++;
                checker();
                Log.e("VALUES", "BUTTON C");
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "D";
                items++;
                checker();
                Log.e("VALUES", "BUTTON D");
            }
        });
    }

    public void gameMode() {
        question = getNextQuiz();
        if (score < 0) {
            score = 0;
        }
        switch (mode) {
            case "EASY":
                easyMode();
                lblQuiz.setText("SET A Q: " + items);
                lblScore.setText("SCORE:\n" + score);
                break;
            case "MEDIUM":
                mediumMode();
                lblQuiz.setText("SET B Q: " + items);
                lblScore.setText("SCORE:\n" + score);
                break;
            case "HARD":
                hardMode();
                lblQuiz.setText("SET C Q: " + items);
                lblScore.setText("SCORE:\n" + score);
                break;
        }
    }

    public void easyMode() {
        lblQuestions = findViewById(R.id.lblQuestions);
        Log.e("QUIZ", " " + question);
        switch (question) {
            case "Quiz1":
                lblQuestions.setText(getResources().getString(R.string.set_a_q1));
                btnA.setText("A. YES");
                btnB.setText("B. NO");
                btnC.setText("C. MACHINE DEPENDENT");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "A");
                //A
                break;

            case "Quiz2":
                lblQuestions.setText(getResources().getString(R.string.set_a_q2));
                btnA.setText("A. 31 CHARACTERS");
                btnB.setText("B. 63 CHARACTERS");
                btnC.setText("C. 79 CHARACTERS");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "D");
                //D
                break;

            case "Quiz3":
                lblQuestions.setText(getResources().getString(R.string.set_a_q3));
                btnA.setText("A. my_string_1");
                btnB.setText("B. 1st_string");
                btnC.setText("C. foo");
                btnD.setText("D. _");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz4":
                lblQuestions.setText(getResources().getString(R.string.set_a_q4));
                btnA.setText("A. UNLIMITED LENGTH");
                btnB.setText("B. STARTS WITH A NUMBER");
                btnC.setText("C. HAS SPECIAL CHARACTERS");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "A");
                //A
                break;

            case "Quiz5":
                lblQuestions.setText(getResources().getString(R.string.set_a_q5));
                btnA.setText("A. __init__");
                btnB.setText("B. in");
                btnC.setText("C. it");
                btnD.setText("D. on");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz6":
                lblQuestions.setText(getResources().getString(R.string.set_a_q6));
                btnA.setText("A. 'any'");
                btnB.setText("B. 'yan'");
                btnC.setText("C. b'any'");
                btnD.setText("D. x'any'");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz7":
                lblQuestions.setText(getResources().getString(R.string.set_a_q7));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. ERROR");
                btnD.setText("D. NO OUTPUT");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz8":
                lblQuestions.setText(getResources().getString(R.string.set_a_q8));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. ERROR");
                btnD.setText("D. NO OUTPUT");
                Log.e("ANSWER", "C");
                //C
                break;

            case "Quiz9":
                lblQuestions.setText(getResources().getString(R.string.set_a_q9));
                btnA.setText("A. 8");
                btnB.setText("B. 1");
                btnC.setText("C. 2");
                btnD.setText("D. 4");
                Log.e("ANSWER", "D");
                //D
                break;

            case "Quiz10":
                lblQuestions.setText(getResources().getString(R.string.set_a_q10));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. ERROR");
                btnD.setText("D. NO OUTPUT");
                Log.e("ANSWER", "A");
                //A
                break;
            default:
                easyAlertDialog();
                break;
        }
    }

    public void mediumMode() {
        lblQuestions = findViewById(R.id.lblQuestions);
        Log.e("ELEMENT", " " + question);
        switch (question) {
            case "Quiz1":
                lblQuestions.setText(getResources().getString(R.string.set_b_q1));
                btnA.setText("A. INDEX ERROR");
                btnB.setText("B. ''");
                btnC.setText("C. 'Crocodile access'");
                btnD.setText("D. SYNTAX ERROR");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz2":
                lblQuestions.setText(getResources().getString(R.string.set_b_q2));
                btnA.setText("A. LIST");
                btnB.setText("B. DICTIONARY");
                btnC.setText("C. TUPLE");
                btnD.setText("D. ARRAY");
                Log.e("ANSWER", "A");
                //A
                break;

            case "Quiz3":
                lblQuestions.setText(getResources().getString(R.string.set_b_q3));
                btnA.setText("A. [2,6,4]");
                btnB.setText("B. [1,3,2,1,3]");
                btnC.setText("C. [1,3,2,1,3,2]");
                btnD.setText("D. [1,3,2,3,2,1]");
                Log.e("ANSWER", "C");
                //C
                break;

            case "Quiz4":
                lblQuestions.setText(getResources().getString(R.string.set_b_q4));
                btnA.setText("A. DICTIONARY COMPREHENSION DOESN'T EXIST");
                btnB.setText("B. {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6:36}");
                btnC.setText("C. {0: 0, 1: 1, 4: 4, 9: 9, 16: 16, 25: 25}");
                btnD.setText("D. {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25}");
                Log.e("ANSWER", "D");
                //D
                break;

            case "Quiz5":
                lblQuestions.setText(getResources().getString(R.string.set_b_q5));
                btnA.setText("A. ERROR");
                btnB.setText("B. u");
                btnC.setText("C. t");
                btnD.setText("D. y");
                Log.e("ANSWER", "D");
                break;

            case "Quiz6":
                lblQuestions.setText(getResources().getString(R.string.set_b_q6));
                btnA.setText("A. lis1.add(5)");
                btnB.setText("B. list1.append(5)");
                btnC.setText("C. list1.addLast(5)");
                btnD.setText("D. list1.addEnd(5)");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz7":
                lblQuestions.setText(getResources().getString(R.string.set_b_q7));
                btnA.setText("A. 1");
                btnB.setText("B. 1 2");
                btnC.setText("C. 1 2 3 4 5 6 ...");
                btnD.setText("D. 1 3 5 7 9 11 ...");
                Log.e("ANSWER", "D");
                //D
                break;

            case "Quiz8":
                lblQuestions.setText(getResources().getString(R.string.set_b_q8));
                btnA.setText("A. -1");
                btnB.setText("B. 4");
                btnC.setText("C. 3");
                btnD.setText("D. 1");
                Log.e("ANSWER", "B");
                //B
                break;

            case "Quiz9":
                lblQuestions.setText(getResources().getString(R.string.set_b_q9));
                btnA.setText("A. 0");
                btnB.setText("B. 1");
                btnC.setText("C. 4");
                btnD.setText("D. 2");
                Log.e("ANSWER", "D");
                //D
                break;

            case "Quiz10":
                lblQuestions.setText(getResources().getString(R.string.set_b_q10));
                btnA.setText("A. 0");
                btnB.setText("B. 1");
                btnC.setText("C. 4");
                btnD.setText("D. 2");
                Log.e("ANSWER", "D");
                //D
                break;
            default:
                mediumAlertDialog();
                break;
        }
    }

    public void hardMode() {
        lblQuestions = findViewById(R.id.lblQuestions);
        Log.e("ELEMENT", " " + question);
        switch (question) {
            case "Quiz1":
                lblQuestions.setText(getResources().getString(R.string.set_c_q1));
                btnA.setText("A. ERROR");
                btnB.setText("B. 12");
                btnC.setText("C. 15");
                btnD.setText("D. 1512");
                Log.e("ANSWER", "C");
                //C
                break;
            case "Quiz2":
                lblQuestions.setText(getResources().getString(R.string.set_c_q2));
                btnA.setText("A. __add__()");
                btnB.setText("B. __plus__()");
                btnC.setText("C. __sum__()");
                btnD.setText("D. NONE OF THE MENTIONED");
                Log.e("ANSWER", "A");
                //A
                break;
            case "Quiz3":
                lblQuestions.setText(getResources().getString(R.string.set_c_q3));
                btnA.setText("A. AB!@");
                btnB.setText("B. Ab12");
                btnC.setText("C. aB!2");
                btnD.setText("D. aB1@");
                Log.e("ANSWER", "C");
                //C
                break;
            case "Quiz4":
                lblQuestions.setText(getResources().getString(R.string.set_c_q4));
                btnA.setText("A. [‘ab’, ‘ef’, ‘ghcd’]");
                btnB.setText("B. [‘ab’, ‘efcdghcd’]");
                btnC.setText("C. [‘abcdef’, ‘ghcd’]");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "A");
                //A
                break;
            case "Quiz5":
                lblQuestions.setText(getResources().getString(R.string.set_c_q5));
                btnA.setText("A. ERROR");
                btnB.setText("B. hello");
                btnC.setText("C. 16");
                btnD.setText("D. 16 hello");
                Log.e("ANSWER", "A");
                //A
                break;
            case "Quiz6":
                lblQuestions.setText(getResources().getString(R.string.set_c_q6));
                btnA.setText("A. <");
                btnB.setText("B. >");
                btnC.setText("C. !=");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "D");
                //D
                break;
            case "Quiz7":
                lblQuestions.setText(getResources().getString(R.string.set_c_q7));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. I DON'T KNOW");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "B");
                //B
                break;
            case "Quiz8":
                lblQuestions.setText(getResources().getString(R.string.set_c_q8));
                btnA.setText("A. 3 4 5 6 7 8 9 10 11 12");
                btnB.setText("B. 3 4 5 6 7 8 9");
                btnC.setText("C. 3 4 5 6 7 8 9 10 11");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "B");
                //B
                break;
            case "Quiz9":
                lblQuestions.setText(getResources().getString(R.string.set_c_q9));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. I DON'T KNOW");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "B");
                //B
                break;
            case "Quiz10":
                lblQuestions.setText(getResources().getString(R.string.set_c_q10));
                btnA.setText("A. TRUE");
                btnB.setText("B. FALSE");
                btnC.setText("C. I DON'T KNOW");
                btnD.setText("D. NONE OF THE ABOVE");
                Log.e("ANSWER", "B");
                //B
                break;
            default:
                hardAlertDialog();
                break;
        }
    }

    public void easyAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CONGRATULATIONS");
        builder.setMessage("YOU HAVE FINISHED THE EASY MODE OF YOUR QUIZ\nWOULD YOU LIKE TO TRY EASY MODE AGAIN OR TRY MEDIUM MODE?");

        builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = "EASY";
                Intent intent = getIntent();
                intent.putExtra("difficulty", mode);
                finish();
                startActivity(intent);
            }
        });
        builder.setNeutralButton("MEDIUM MODE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = "MEDIUM";
                Intent intent = getIntent();
                intent.putExtra("difficulty", mode);
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("MAIN MENU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(PlayCodename.this, MainMenu.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog =  builder.create(); dialog.show();
    }

    public void mediumAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CONGRATULATIONS");
        builder.setMessage("YOU HAVE FINISHED THE MEDIUM MODE OF YOUR QUIZ\nWOULD YOU LIKE TO TRY MEDIUM MODE AGAIN OR TRY HARD MODE?");

        builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = "MEDIUM";
                Intent intent = getIntent();
                intent.putExtra("difficulty", mode);
                finish();
                startActivity(intent);
            }
        });
        builder.setNeutralButton("HARD MODE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = "HARD";
                Intent intent = getIntent();
                intent.putExtra("difficulty", mode);
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("MAIN MENU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(PlayCodename.this, MainMenu.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog =  builder.create(); dialog.show();
    }

    public void hardAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CONGRATULATIONS");
        builder.setMessage("YOU HAVE FINISHED THE HARD MODE OF YOUR QUIZ\nWOULD YOU LIKE TO TRY HARD MODE AGAIN OR RETURN TO MAIN MENU?");

        builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = "HARD";
                Intent intent = getIntent();
                intent.putExtra("difficulty", mode);
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("MAIN MENU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(PlayCodename.this, MainMenu.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog =  builder.create(); dialog.show();
    }

    public void checker() {
        if (mode.equals("EASY")) {
            if (question.equals("Quiz1") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz2") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz3") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz4") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz5") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz6") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz7") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz8") && answer.equals("C")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz9") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            if (question.equals("Quiz10") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 50;
                gameMode();
            }
            else{Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
                score -= 25;
                gameMode();
                return;
            }
        }
        if (mode.equals("MEDIUM")) {

            if (question.equals("Quiz1") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz2") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz3") && answer.equals("C")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz4") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz5") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz6") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz7") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz8") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz9") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            if (question.equals("Quiz10") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 100;
                gameMode();
            }
            else{Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
                score -= 50;
                gameMode();
                return;
            }
        }
        if (mode.equals("HARD")) {

            if (question.equals("Quiz1") && answer.equals("C")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz2") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz3") && answer.equals("C")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz4") && answer.equals("C")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz5") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz6") && answer.equals("D")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz7") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz8") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz9") && answer.equals("B")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            if (question.equals("Quiz10") && answer.equals("A")) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
                score += 500;
                gameMode();
            }
            else{Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
                score -= 250;
                gameMode();
                return;
            }
        }
    }

    public void setup() {
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnStart = findViewById(R.id.btnStart);
        lblQuiz = findViewById(R.id.lblQuiz);
        lblQuestions = findViewById(R.id.lblQuestions);
        lblScore = findViewById(R.id.lblScore);
    }
}