
CREATE database  quiz_db 
USE quiz_db 

CREATE TABLE users(
  iduser INT NOT NULL identity(1,1),
  firstname VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(255) NULL,
  is_admin TINYINT NULL,
  PRIMARY KEY (iduser)
)


CREATE TABLE categories (
  idcategories INT NOT NULL identity(1,1),
  categorie_name VARCHAR(45) NULL,
  PRIMARY KEY (idcategories))



CREATE TABLE answer (
  idanswer INT NOT NULL identity(1,1),
  answer VARCHAR(45) NULL,
  PRIMARY KEY (idanswer))

CREATE TABLE questions (
  idquestions INT NOT NULL identity(1,1),
  content VARCHAR(45) NULL,
  idcategories INT NOT NULL,
  idanswer INT NOT NULL,
  PRIMARY KEY (idquestions),
  CONSTRAINT fk_questions_categories
    FOREIGN KEY (idcategories)
    REFERENCES categories (idcategories)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_questions_answer1
    FOREIGN KEY (idanswer)
    REFERENCES answer (idanswer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


CREATE TABLE quiz (
  idquiz INT NOT NULL identity(1,1),
  quiz_name VARCHAR(45) NULL,
  created_at DATE NULL,
  categories_idcategories INT NOT NULL,
  PRIMARY KEY (idquiz),
  CONSTRAINT fk_quiz_categories1
    FOREIGN KEY (categories_idcategories)
    REFERENCES categories (idcategories)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)




CREATE TABLE results (
  idresults INT NOT NULL identity(1,1),
  quiz_idquiz INT NOT NULL,
  time TIME NULL,
  correct_answer INT NULL,
  user_iduser INT NOT NULL,
  PRIMARY KEY (idresults),
  CONSTRAINT fk_results_quiz1
    FOREIGN KEY (quiz_idquiz)
    REFERENCES quiz (idquiz)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_results_user1
    FOREIGN KEY (user_iduser)
    REFERENCES users (iduser)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

CREATE TABLE question_choice (
  choiceId INT NOT NULL identity(1,1),
  optionA VARCHAR(45) NULL,
  optionB VARCHAR(45) NULL,
  optionC VARCHAR(45) NULL,
  optionD VARCHAR(45) NULL,
  idquestions INT NOT NULL,
  PRIMARY KEY(choiceId),
  CONSTRAINT fk_question_choice_questions1
    FOREIGN KEY (idquestions)
    REFERENCES questions (idquestions)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

	select * from question_choice
	select*from users
	
	select * from question_choice
	
	select * from questions
	select * from answer
	select * from categories
	Select * from Questions q where q.idcategories = 1