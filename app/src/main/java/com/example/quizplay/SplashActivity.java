package com.example.quizplay;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class SplashActivity extends AppCompatActivity {

    public static ArrayList<Modelclass> listofQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        listofQ = new ArrayList<>();
        listofQ.add(new Modelclass(" Who invented Java Programming?", "Guido van Rossum", "James Gosling", "Dennis Ritchie", " Bjarne Stroustrup", "James Gosling"));
        listofQ.add(new Modelclass("Syntax Error is ?", "An error you will never find", "An error you find at the end when the program gives out a wrong value due to logic error.", "An error caused by language rules being broken.", "An error due to user error", "An error caused by language rules being broken."));
        listofQ.add(new Modelclass("A short sections of code written to complete a task.", "Buffer", "Array", "Function", "Loop", "Function"));
        listofQ.add(new Modelclass("What dose this equation mean ? a != t", "A is assinged t", "A and t are equal", "A is not equal to t", "T is add to a", "A is not equal to t"));
        listofQ.add(new Modelclass(" Which statement is true about Java?", "Java is a sequence-dependent programming language", " Java is a code dependent programming language", " Java is a platform-dependent programming language", " Java is a platform-independent programming language", " Java is a platform-independent programming language"));
        listofQ.add(new Modelclass("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK"));
        listofQ.add(new Modelclass("Which one of the following is not a Java feature?", " Object-oriented", " Use of pointers", "Portable", "Dynamic and Extensible", " Use of pointers"));
        listofQ.add(new Modelclass("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "keyword", " none of the mentioned", "keyword"));
        listofQ.add(new Modelclass("What is the extension of java code files?", ".js", ".txt", ".class", " .java", ".txt"));
        listofQ.add(new Modelclass("Which environment variable is used to set the java path?", "MAVEN_Path", "JavaPATH", "JAVA", "JAVA_HOME", "JAVA_HOME"));
        listofQ.add(new Modelclass(" Which of the following is not an OOPS concept in Java?", "Polymorphism", "Inheritance", "Compilation", " Encapsulation", "Compilation"));
        listofQ.add(new Modelclass(" Which of the following is a type of polymorphism in Java Programming?", "Multiple polymorphism", "Compile time polymorphism", " Multilevel polymorphism", "Execution time polymorphism", "Compile time polymorphism"));

        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(SplashActivity.this, dashboardActivity.class);
//            startActivity(intent);
        }, 1500);
    }
}