package com.example.dotnetquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var CurrentPosition: Int = 1
    private var QuestionsList: ArrayList<Question>? = null
    private var SelectedOptionPosition: Int = 0
    private var CorrectAnswers: Int = 0
    private var WrongAnswers: Int = 0
    private var UserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        UserName = intent.getStringExtra(QuestionList.USER_NAME)

        QuestionsList = QuestionList.getQuestions()


        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = QuestionsList!![CurrentPosition - 1]

        defaultOptionsView()

        if(CurrentPosition == QuestionsList!!.size){
            btn_submit.text = "Finish"
        } else {
            btn_submit.text = "Submit"
        }

        progressBar.progress = CurrentPosition
        tv_progress.text = "$CurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one,1)
            }

            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two,2)
            }

            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three,3)
            }

            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four,4)
            }

            R.id.btn_submit ->{
                if(SelectedOptionPosition == 0){
                    CurrentPosition ++

                    when{
                        CurrentPosition <= QuestionsList!!.size ->{
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity:: class.java)
                            intent.putExtra(QuestionList.USER_NAME, UserName)
                            intent.putExtra(QuestionList.CORRECT_ANSWERS, CorrectAnswers)
                            intent.putExtra(QuestionList.WRONG_ANSWERS, WrongAnswers)
                            intent.putExtra(QuestionList.TOTAL_QUESTIONS, QuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {

                    val question = QuestionsList?.get(CurrentPosition -1)
                    if(question!!.correctAnswer != SelectedOptionPosition){
                        answerView(SelectedOptionPosition, R.drawable.wrong_default_border_bg)
                        WrongAnswers ++
                    } else {
                        CorrectAnswers ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_default_border_bg)

                    if(CurrentPosition == QuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "Go to next question"
                    }
                    SelectedOptionPosition = 0
                }
            }
        }

    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        SelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_default_border_bg
        )
    }
}