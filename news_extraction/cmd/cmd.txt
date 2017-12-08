Usage instructions:
   Step 1: Open terminal/command prompt
   Step 2: cd to the workspace where you have downloaded news_extraction.
   Step 2: Compile the NewsExtraction.java file using javac command and including the path 	   	   of the json-simple-1.1.1.jar 
	   Example:
	   javac -cp /Users/Work/json-simple-1.1.1.jar NewsExtraction.java
   Step 3: Run the GetGitRepository file using java command and again by including the path of the   	   json jar
	   Example:
	   java -cp /Users/Work/json-simple-1.1.1.jar: NewsExtraction arg1 arg2
	   
	   There are 2 command line arguments: 
	   arg1 - keyword to be searched
	          Example - President
	   arg2 - path of the folder where you wish to save the text files that contain the articles
	   	  Example - /Work/News/

