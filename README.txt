AMCrosslink
AndyMark, Inc.
http://www.andymark.com



This is a Java library for use with the Crosslink Robot Control System.

Currently, the source code is licensed under a BSD-style open source
license, see LICENSE.txt for details.

To purchase a Crosslink control system, visit
http://www.andymark.com/product-p/am-0994.htm
                        
The current releases are early development and are not recommended for
production level use yet.


==================================================================================
==================================================================================

Source Folder Tree:
	src
		-> com
			-> andymark
				-> crosslink
					- Source files for the .jar file

Desktop Folder Tree:
	CrossLink Java
		- This folder needs to be imported into Eclipse as a Java Project folder
		


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
	to your MainActivity.java file and start talking to the Crosslink system. The ip in 
	this library is set to 10.10.0.121.
	



