package com.example.quiz_app

object QuestionConstants {

    fun getQuestions(): ArrayList<Question> {

        val allQuestions: ArrayList<Question> = ArrayList()

        val question1 = Question(
            1,
            R.drawable.kangaroo,
            "What is the origin country of Kangaroos?",
            createListOf("Austria", "Philippines", "South Africa", "None of the Above"),
            4
        )

        val question2 = Question(
            2,
            R.drawable.congo_flag,
            "Where does the Democratic Republic of Congo lay?",
            createListOf("Asia", "North America", "Africa", "Europe"),
            3
        )

        val question3 = Question(
            3,
            R.drawable.austria_flag,
            "how many countries ar on the boarderline of Austria?",
            createListOf("7", "5", "9", "6"),
            1
        )

        val question4 = Question(
            4,
            R.drawable.australia_flag,
            "To which country does this flag belong?",
            createListOf("Great Breton", "United Arab Emirates", "Australia", "None of the Above"),
            3
        )

        val question5 = Question(
            5,
            R.drawable.pi_photo,
            "What is the approximately equivalent value of the mathematical constant Pi",
            createListOf("13.41569", "3.14159", "Australia", "2.21211"),
            2
        )

        val question6 = Question(
            6,
            R.drawable.galileo_galilei,
            "Who is the first person to publish the theory of the earth moving around the sun?",
            createListOf("Marco Polo", "Ferdinand Magellan", "Socrates", "Galileo Galilei"),
            2
        )

        val question7 = Question(
            7,
            R.drawable.chess_board,
            "How many squares does the chess board contain?",
            createListOf("36", "64", "35", "81"),
            2
        )

        val question8 = Question(
            8,
            R.drawable.atletico_madrid_flag,
            "To which spanish Football club does this Symbol belong?",
            createListOf("Real Madrid", "Barcelona", "Atletico Madrid", "Espanyol"),
            3
        )

        val question9 = Question(
            9,
            R.drawable.leonardo_dicaprio,
            "In which movie die Leonardo DiCaprio win the Oscar?",
            createListOf("36", "64", "35", "81"),
            2
        )

        val question10 = Question(
            10,
            R.drawable.albert_einstein,
            "Who is the scientist shown in this photo?",
            createListOf("Albert Einstein", "Steve Hawkins", "Isaak Newton", "Thales of Miletus"),
            1
        )

        allQuestions.add(question1)
        allQuestions.add(question2)
        allQuestions.add(question3)
        allQuestions.add(question4)
        allQuestions.add(question5)
        allQuestions.add(question6)
        allQuestions.add(question7)
        allQuestions.add(question8)
        allQuestions.add(question9)
        allQuestions.add(question10)

        return allQuestions

    }

    private fun createListOf(
        firstOption: String,
        secondOption: String,
        thirdOption: String,
        fourthOption: String
    ): java.util.ArrayList<String> {
        val optionsList = ArrayList<String>()
        optionsList.add(firstOption)
        optionsList.add(secondOption)
        optionsList.add(thirdOption)
        optionsList.add(fourthOption)
        return optionsList
    }

}