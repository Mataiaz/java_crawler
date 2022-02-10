# About this project #
This is a simple java web crawler made with maven.
This projects features some basic code with basic reusability.
In this project i use jsoup to parse the html code.

Picture at bottom.

FYI: A web crawler is a program that searches through the web or on a specific webpage and fetches the html code (the code that structures the webpage).

## Test project ##
To test the program just download the jar file by pressing download(right side on screen when you have followed the link).

https://github.com/Mataiaz/projects/blob/main/demo.jar

Then open a terminal as an administrator, locate the file.

and right click the file and press open and the program should start.

When the program is finished, it will create an excel file in the same location as the webcrawler and store the information inside the excel file.

### Test program with different input ###

run "java -jar basic_webcrawler.jar + LINK + PAGE_NUMBER + POST_NUMBER"

"https://9anime.to/newest?page= 1 1" = (LINK, PAGES, POSTS)

The end part where it is written "https://9anime.to/newest?page= 1 1" is where you input your desired link, amount of pages, and posts per page.

The app should collect the titles and links from 1 post on each page and it should go through 1 page.

When the program is finished, it will create an excel file in the same location as the webcrawler and store the information inside the excel file.

Link to webpage the app goes trough:

https://gogoanime.nl/genre/action?page=1

## Features ##
* You can input your own desired website with specified number of pages and posts with terminal as you run jar file (very basic with reusability).

* An algorithm which will retrive html code with arguments from the user input in mind.

* An algorithm which will create and store the result of the program in a excel file.

* Basic error handling, mainly for userinput(which will print in terminal) if it is anything else it will create a text file where is says what the error is.

## Contact ##
mathias344@live.no

Made by Mathias L. Bjarnason

![How it looks like](https://github.com/Mataiaz/java_crawler/blob/main/javaPics/java1.PNG)
![Excel result](https://github.com/Mataiaz/java_crawler/blob/main/javaPics/resultscrawler2.png) ![Excel result](https://github.com/Mataiaz/java_crawler/blob/main/javaPics/resultscrawler1.png)
