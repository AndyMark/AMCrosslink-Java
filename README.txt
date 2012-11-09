AMCrosslink-Java
================
This library can be used with desktop Java applications
or Android applications. 



Eclipse:

-ANDROID-

For Android development, we assume you already have the SDK
pre-configured before trying to use this library.



-BOTH-

Regardless of desktop or android application, the following steps are the same:

	+ Download the "AMCrosslink-Java.jar" file
		- This contains all the files to talk to the Crosslink
	
	+ In Eclipse:
		+ Create a new android project
		+ Drage and drop the "AMCrosslink-Java.jar" file onto your project
		+ Select Copy files
		+ Right click on your project folder
			- Select "Properties"
			- Select "Java Build Path"
				- Select "Libraries"
				- Select "Add JARs..."
				- Navigate to the "AMCrosslink-Java.jar" file
				- Click "OK"
			- Click "OK"
	
	
	Now you should be able to add "import com.andymark.crosslink.SimpleCrosslinkRobot;"
	to your MainActivity.java file and start talking to the Crosslink system.
	



