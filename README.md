# oop.Ex2
@author Yehonatan Dilmoni, Hallel Ithaki
MyCallable
represents a Callable task that counts the number of lines in a file.
The current version is 1.0,
last updated: on January 13, 2023.

Usage
To use this class, you will need to instantiate it with the file name that you would like to count the lines of.
Then, you can call the call() method to execute the counting task.
 The call() method will return an int that represents the number of lines in the file.
 
 Method
The class has one method call() which is an overridden method from the Callable interface
and it's used to count the number of lines in the file.






MyThread

Overview
represents a Thread that counts the number of lines in a file.
Usage
To use this class, you will need to extend it and pass the file name that you would like to count the lines of as a parameter to the constructor.
Then, you can call the start() method to execute the counting task in a separate thread.
The getLineCounter() method will return an int that represents the number of lines in the file.

Method
The class has one method run()
which is an overridden method from the Thread class and it's used to count the number of lines in the file.
The class also has a method getLineCounter() which returns the number of lines in the file.

Ex2_1
Overview
This class, Ex2_1, is responsible for creating text files and counting the total number of lines in those files.
and providing methods to accomplish this in different ways



Usage
This class provides several methods to create and count the lines of text files:

createTextFile(int i, int numOfLine): 
This method creates a text file with the given name and number of lines. It returns the name of the file.

createTextFiles(int n, int seed, int bound):
This method creates multiple text files with random numbers of lines.
It accepts the number of files to create, a seed for the random number generator, and a bound for the random number of lines.
It returns an array of file names.

getNumOfLines(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names.
It returns the total number of lines.

getNumOfLinesThreads(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names using threads.
It returns the total number of lines.

getNumOfLinesConcurrent(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names using a concurrent approach.
It returns the total number of lines.

Method
The class provides several methods as described above:

createTextFile(int i, int numOfLine):
This method creates a text file with the given name and number of lines.
It returns the name of the file.

createTextFiles(int n, int seed, int bound):
This method creates multiple text files with random numbers of lines.
It accepts the number of files to create, a seed for the random number generator, and a bound for the random number of lines.
It returns an array of file names.

getNumOfLines(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names.
It returns the total number of lines.

getNumOfLinesThreads(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names using threads.
It returns the total number of lines.

getNumOfLinesConcurrent(String[] fileNames):
This method counts the total number of lines in the files specified in the array of file names using a concurrent approach.
It returns the total number of lines.



