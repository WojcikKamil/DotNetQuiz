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
        var grade = (correctAnswer *100)/ totalQuestion

        tv_score.text = "Correct answers $correctAnswer"

        tv_wrong.text = "Wrong answers: $wrongAnswer"

        tv_grade.text = "Your score is: $grade %"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}