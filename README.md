# Quiz-App
This is a java spring boot based quiz application.
# Configurations
1. Programming Language - Java
2. version - Java 21
3. Spring Boot version - 3.4.0
4. Project - Maven
5. Packaging - Jar

# Steps to run this application
1. Download the Zip file.
2. Extract it.
3. Open the file in IntelliJ Idea or any other building tool.
4. Load pom.xml, at least once, to get all the required external libraries.
5. Run spring boot application.

# Database
I have used H2 database with 10 default questions in Questions table of conceptile database.
These questions are inserted into the table using schema.sql file which is stored in resource folder of this application.
These questions have two categories or topics - 1. Java 2. SQL

username - Pratyush
password - conceptile

# REST APIs
1. /quiz/create - This PostMapping API is to create a quiz with given topic, either Java or SQL (default), Number of questions, title of the Quiz. This method get the questions from database with given topic. These questions are randomly selected and randomly arranged. When we create a quiz, it get stored in the database with a quizId which is auto generated and auto increment.

2. /quiz/get/{quizId} - This GetMapping Api is to get the Quiz questions. Here, {quizId} should be replaced with the quizId in the database. Usually, 1 is the quizId. But, it should be checked using /h2-console.

3. /quiz/{quizId}/submit - This PostMapping Api is to submit the answers by the user. Here, {quizId} should be replaced with the quizId used to get all the quiz questions. The answers should be submited in the sequence of the questions given in the quiz. Otherwize, it will show incorrect answer even for the correct answers.
   Apart from path variable, This PostMapping Api also requires a Body which is an List of UserAnswer. Every Answer has a questionId(Integer) and Answer (String).
   It returns the List of UserAnswer which shows the questionId and the status of the answer, either correct or incorrect.

5. /questions/allQuestions - This GetMapping API is to see all the default questions in the database.

6. /questions/Topic/{topic} - This GetMapping Api is to see all the questions of given topic. Here, {topic} should be replaced with either Java or SQL, these two are default topics.
