package com.example.dotnetquiz

object QuestionList {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val WRONG_ANSWERS: String = "wrong_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(1,"What is .NET Core SDK?",
        "is an open-source platform for the developer",
            "is a virtual machine",
            "is a set of tools and libraries",
            "is a design pattern" ,
            3
        )
        questionList.add(q1)

        val q2 = Question(2,"int keyword refers to which .NET type?",
            "System.Int32",
            "System.Int8",
            "System.Int16",
            "System.Int64" ,
            1
        )
        questionList.add(q2)

        val q3 = Question(3,"\n" +
                "If a variable is declared inside a method, then it is called as...?",
            "Static",
            "Serial",
            "Local",
            "Private" ,
            3
        )
        questionList.add(q3)

        val q4 = Question(4,"Runtime environment provided by .NET is called as...?",
            "RMT",
            "CLR",
            "RC",
            "RCT" ,
            2
        )
        questionList.add(q4)

        val q5 = Question(5,"In which file .Net assembly’s metadata is stored?",
            "manifest",
            ".dll",
            ".exe",
            "core" ,
            1
        )
        questionList.add(q5)

        val q6 = Question(6,"Specify root namespace used for fundamental types in .Net framework.",
            "System.Web",
            "System.IO",
            "System.Object",
            "System.File" ,
            3
        )
        questionList.add(q6)

        val q7 = Question(7,"Which method is used to force garbage collection to run?",
            "GC.Run() method",
            "GC.Collection() method",
            "GC.Finalize() method",
            "GC.Collect() method" ,
            4
        )
        questionList.add(q7)

        val q8 = Question(8,"Which of following constructors is used to create an empty String object?",
            "String(void)",
            "String()",
            "String(0)",
            "All of the above" ,
            2
        )
        questionList.add(q8)

        val q9 = Question(9,"C# class is inherit the multiple...?",
            "Static classes",
            "Interfaces",
            "Classes",
            "Abstract classes" ,
            2
        )
        questionList.add(q9)

        val q10 = Question(10,"What is the file extension of C#?",
            ".cs",
            ".csx",
            ".csp",
            "both .cs & .csx" ,
            4
        )
        questionList.add(q10)

        return questionList
    }
}