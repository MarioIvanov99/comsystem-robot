# Робот на Марс

В тази задача по програмиране се интересуваме от имплементацията на робот, който събира камъни на Марс. Роботът има само
2 функции на разположение:

* За един ден да събере един камък
* За един ден да се клонира

Тъй като и двете операции отнемат цял ден, роботът не може да се клонира и да събира камъни в един и същи ден.

Довършете имплементацията на двата класа [RobotOperations](/src/main/java/com/comsystem/homework/robot/RobotOperations.java)
и [RobotRestController](/src/main/java/com/comsystem/homework/rest/RobotRestController.java). Там ще намерите и 
допълнителни ориентировъчни коментари.
Моля, имплементирайте и два unit теста, които да доказват коректността на двата метода в
[RobotOperations](/src/main/java/com/comsystem/homework/robot/RobotOperations.java).

Позволено е да използвате всякакви външни библиотеки, които могат да се намерят в
[Maven Central Repository](https://mvnrepository.com). Не е позволено да се променят сигнатурите (method signature) на 
вече дефинираните методи.

Приятно кодене!



# Assumptions

* CLONE operation doubles all existing robots
* The minization algorithm is looking for an exact number
* n is the number of days
* m is the number of rocks

# Maximization

The best way to maximize rocks is to CLONE n-1 times and then DIG on the last day.
This is equivalent to CLONE n-2 times and then DIG on the last 2 days.
All other variations produce fewer rocks.

# Minimization

It is required to split m into powers of 2 that sum up to m in order to get the exact number during minization.
For each of those numbers, an appropriate number of CLONE commands and a DIG command is issued.
If there is no need to reach m exactly, then simply CLONE until the number of robots is larger than m, then DIG.

# Testing

Unit tests were used to check if the methods for creating the plans work correctly.
Postman was used to check if the PostMappings correctly exposed the methods to http.
