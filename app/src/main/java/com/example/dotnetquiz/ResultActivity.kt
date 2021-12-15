package com.example.dotnetquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(QuestionList.USER_NAME)
        tv_name.text = username

        val totalQuestion = intent.getIntExtra(QuestionList.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(QuestionList.CORRECT_ANSWERS,0)
        val wrongAnswer = intent.getIntExtra(QuestionList.WRONG_ANSWERS,0)

        var gradeDiff = (correctAnswer - wrongAnswer)
        var grade = (gradeDiff * 100)/ totalQuestion

        if(grade < 0){
            tv_grade.text = "Failed, more negative than possitive answers :("
        } else if(grade == 0){
            tv_grade.text = "So so, ZERO my friend. Failed"
        } else if(grade in 52..70){
            tv_grade.text = "Passed, the grade is 3"
        } else if (grade in 71..90){
            tv_grade.text = "Passed, the grade is 4. Good job!"
        } else if (grade in 91..100){
            tv_grade.text = "Passed! Congratulation! The grade is 5! You re amazing ;>"
        }


        tv_score.text = "Correct answers $correctAnswer"

        tv_wrong.text = "Wrong answers: $wrongAnswer"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}