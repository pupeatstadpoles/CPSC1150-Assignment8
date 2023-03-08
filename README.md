# CPSC1150-Assignment8
Practise with using Files and Scanners to read them - Completed Nov 2022

This program accesses a list of class records stored in a .txt file, with each new student's record on a new line. Using a switch statement, the user is prompted with a few commands for possible actions to be taken with each case having their own methods to carry out, namely:

1. To display a specific record (the user then enters in a student's name, and if found in the list, the student's name, ID and final exam score aree returned)

2. To calculate the average of all final exam scores

3. To find the student with the highest score on the final exam 

4. To copy all the students' records to another file (user is prompted for the full file name of the file to be created which will then be copied to)

5. To terminate the program




One challenge I encountered was not being able to reuse the same Scanner. In the past assignments, I had only needed the Scanner to obtain user input through the keyboard. In this case, since a Scanner attached to the text file could not move back up to the top after advancing through each line using nextLine(), I just created a new local Scanner each time I needed to look through the records. Being a local variable, this would not take up too much space in the memory. 

Another challenge was having to obtain certain portions of each line. Since a student's records would all be on one line in the format student ID, name and final score, eg. `12345612:Spongebob Squidward:34`, and there was a possibility of lines in the text file that did not contain a record such as blank lines or the first line `ID:Name:Final`, I needed to make sure my methods took those into account and would be able to obtain only the portions of the record necessary. If I was looking for the student with the highest score, I needed to separate the portion with the score for checking against the current maximum recorded score, but also take the portion with the student's name. To this end, I used the .substring() method. 

I also had to remember to close the scanners and files when I was done working with them.
