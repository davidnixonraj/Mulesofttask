in cmd open the folder location using cd command and follow the steps below

1. To Connect Database Sqlite 
compile "DBConnect.java" first,
then to run use the command " java -classpath ".;sqlite-jdbc-3.7.2.jar" DBConnect "

2. To Create the table 
compile "CreateTable.java",
then run using the command "java -classpath ".;sqlite-jdbc-3.7.2.jar" CreateTable"
this will create the table according to the query entered which is 

CREATE TABLE Movies (Movid INTEGER PRIMARY KEY AUTOINCREMENT,
			MovName TEXT NOT NULL,
			Actor VARCHAR(15),
			Actress VARCHAR(15),
			Yearofrelease INTEGER,
			Director VARCHAR(15)
			)

3. now compile the Query.java and run it using the command "java -classpath ".;sqlite-jdbc-3.7.2.jar" Query"
