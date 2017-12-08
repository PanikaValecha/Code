GitRepository_Extraction
   Input: output_file (pass as command line arguments)
   Output: text file containing the JSON description of the repositories
           Such repository should contain the given keyword.
           However, it is not clear which parts of the repository (e.g., name, or 		   metadata, or readme, or other files) are searched.
   
The output file will contain the JSON description of the repositories.

Usage instructions:
   Step 1: Open terminal/command prompt
   Step 2: cd to the workspace where you have downloaded GitRepository_Extraction.
   Step 2: Compile the GetGitRepositoy.java file using javac command  
	   Example:
	   javac GetGitRepository.java
   Step 3: Run the GetGitRepository file using java command
	   java GetGitRepository arg1
	   
	   arg1 - path of the folder where you wish to save text file.	
	   The path should be of the form ../Git.txt. Example: /work/Git.txt

