package com.example.quizplay;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.ArrayList;
import java.util.Collections;


public class dashboardActivity extends AppCompatActivity {


    CountDownTimer countDownTimer;
    int timevalue = 20;
    RoundedHorizontalProgressBar progressBar;

    int index=0;
    Modelclass modelclass;

  ArrayList<Modelclass>  listofQ;
    TextView card_Question, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout Nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Hooks();

        listofQ = new ArrayList<>();
        listofQ.add(new Modelclass("Who invented Java Programming?", "Guido van Rossum", "James Gosling", "Dennis Ritchie", " Bjarne Stroustrup", "James Gosling"));
        listofQ.add(new Modelclass("Syntax Error is ?", "An error you will never find", "An error you find at the end when the program gives out a wrong value due to logic error.", "An error caused by language rules being broken.", "An error due to user error", "An error caused by language rules being broken."));
        listofQ.add(new Modelclass("A short sections of code written to complete a task.", "Buffer", "Array", "Function", "Loop", "Function"));
        listofQ.add(new Modelclass("What dose this equation mean ? a != t", "A is assinged t", "A and t are equal", "A is not equal to t", "T is add to a", "A is not equal to t"));
        listofQ.add(new Modelclass("Which statement is true about Java?", "Java is a sequence-dependent programming language", " Java is a code dependent programming language", " Java is a platform-dependent programming language", " Java is a platform-independent programming language", " Java is a platform-independent programming language"));
        listofQ.add(new Modelclass("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK"));
        listofQ.add(new Modelclass("Which one of the following is not a Java feature?", " Object-oriented", " Use of pointers", "Portable", "Dynamic and Extensible", " Use of pointers"));
        listofQ.add(new Modelclass("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "keyword", " none of the mentioned", "keyword"));
        listofQ.add(new Modelclass("What is the extension of java code files?", ".js", ".txt", ".class", " .java", ".txt"));
        listofQ.add(new Modelclass("Which environment variable is used to set the java path?", "MAVEN_Path", "JavaPATH", "JAVA", "JAVA_HOME", "JAVA_HOME"));
        listofQ.add(new Modelclass("Which of the following is not an OOPS concept in Java?", "Polymorphism", "Inheritance", "Compilation", " Encapsulation", "Compilation"));
        listofQ.add(new Modelclass("Which of the following is a type of polymorphism in Java Programming?", "Multiple polymorphism", "Compile time polymorphism", " Multilevel polymorphism", "Execution time polymorphism", "Compile time polymorphism"));
        listofQ.add(new Modelclass(" _____ is used to find and fix bugs in the Java programs.", "JVM", "JRE", "JDK", "JDB", "JDB"));
        listofQ.add(new Modelclass("What is the return type of the hashCode() method in the Object class?", "Object", "int", "long", "void", "int"));
        listofQ.add(new Modelclass("Which of the following is a reserved keyword in Java?", "object", "strictfp", "main", "system", "strictfp"));
        listofQ.add(new Modelclass(" In java, jar stands for_____.", "Java Archive Runner", "Java Application Resource", "Java Application Runner", "None of the above", "None of the above"));
        listofQ.add(new Modelclass("Which of the following is a superclass of every class in Java?", " ArrayList", "Abstract class", "Object class", " String", "Object class"));
        listofQ.add(new Modelclass("Which of these packages contains the exception Stack Overflow in Java?", "java.io", "java.system", " java.lang", " java.util", " java.lang"));
        listofQ.add(new Modelclass("Which of these keywords are used for the block to be examined for exceptions?", "check", "throw", "catch", "try", "try"));
        listofQ.add(new Modelclass("Which one of the following is not an access modifier?", "Protected", "void", "Public", "Private", "void"));



        Collections.shuffle(listofQ);

        modelclass=listofQ.get(index);
        Nextbtn.setClickable(false);
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));



        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUnitlFinished) {
                timevalue = timevalue - 1;
                progressBar.setProgress(timevalue);
            }


            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(dashboardActivity.this, R.style.dialog_style);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);
                dialog.findViewById(R.id.btn_try).setOnClickListener(v -> {
                    Intent intent = new Intent(dashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                });

                dialog.show();
            }
        }.start();
        setAlldata();
    }

    private void setAlldata () {
          modelclass =listofQ.get(index);
        card_Question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getoA());
        optionb.setText(modelclass.getoB());
        optionc.setText(modelclass.getoC());
        optiond.setText(modelclass.getoD());
        timevalue=20;
        countDownTimer.cancel();
        countDownTimer.start();
    }

    private void Hooks() {

        progressBar = findViewById(R.id.quiz_timer);
        card_Question = findViewById(R.id.card_ques);
        optiona = findViewById(R.id.card_optionA);
        optionb = findViewById(R.id.card_optionB);
        optionc = findViewById(R.id.card_optionC);
        optiond = findViewById(R.id.card_optionD);

        cardOA = findViewById(R.id.cardO1);
        cardOB = findViewById(R.id.cardO2);
        cardOC = findViewById(R.id.cardO3);
        cardOD = findViewById(R.id.cardO4);

        Nextbtn = findViewById(R.id.Nextbtn);

    }

    public void correct(CardView cardView) {
        disablebtn();
        cardView.setBackgroundColor(getResources().getColor(R.color.green_500));
        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unablebtn();
                correctCount++;
                index++;
                modelclass = listofQ.get(index);
                resetColor();
                setAlldata();
            }
        });
    }
    public void wrong(CardView cardOA){
        disablebtn();
        cardOA.setBackgroundColor(getResources().getColor(R.color.red_500));
        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unablebtn();
                wrongCount++;
                if(index<listofQ.size()-1){
                    index++;
                    modelclass=listofQ.get(index);
                    resetColor();
                    setAlldata();
                }
                else {
                    GameWon();
                }
            }
        });

    }
    private void GameWon(){
        Intent intent=new Intent(dashboardActivity.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);

        startActivity(intent);
    }

    public void unablebtn(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    } public void disablebtn(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void optionAclick(View view){
//        disablebtn();
        Nextbtn.setClickable(true);
        unablebtn();
        if ((modelclass.getoA().equals(modelclass.getAns()))){
            cardOA.setBackgroundColor(getResources().getColor(R.color.green_500));
            if(index<listofQ.size()-1){
                correct(cardOA);
            }
            else {
                GameWon();
            }
        }
        else {
            wrong(cardOA);
        }
    }

    public void optionBclick(View view){
//        disablebtn();
        Nextbtn.setClickable(true);
        unablebtn();
        if ((modelclass.getoB().equals(modelclass.getAns()))){
            cardOB.setBackgroundColor(getResources().getColor(R.color.green_500));
            if(index<listofQ.size()-1){
                correct(cardOB);
            }
            else {
                GameWon();
            }
        }
        else {
            wrong(cardOB);
        }
    }


    public void optionCclick(View view){
//        disablebtn();
        Nextbtn.setClickable(true);
        unablebtn();
        if ((modelclass.getoC().equals(modelclass.getAns()))){
            cardOC.setBackgroundColor(getResources().getColor(R.color.green_500));
            if(index<listofQ.size()-1){

                correct(cardOC);
            }
            else {
                GameWon();
            }
        }
        else {
            wrong(cardOC);
        }
    }

    public void optionDclick(View view){
//        disablebtn();
        Nextbtn.setClickable(true);
        unablebtn();
        if ((modelclass.getoD().equals(modelclass.getAns()))){
            cardOD.setBackgroundColor(getResources().getColor(R.color.green_500));
            if(index<listofQ.size()-1){
                correct(cardOD);
            }
            else {
                GameWon();
            }
        }
        else {
            wrong(cardOD);
        }
    }
}


