package com.example;

import java.io.IOException;

public class Error_handling {

    public static void main(Exception e) throws IOException {

        String eString = e.toString();
            String eArgs[] = eString.split(":");
            //If the user did not give the program input it will run the standard internal input
            if (eArgs[1].equals("Index 0 out of bounds for length 0"))
                {
                    System.out.println("RUNNING WITH PREMADE INPUT");
                    String url = "https://9anime.to/newest?page="; //Link to site you want to fetch data from
                    int pages = 3; //Select amount of pages it crawls throughw
                    int posts = 10; //Select amount of posts it fetches from page(2 pages is double the posts)
                    Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
                }
                //if the user has input 1 or more arguments but its not the exact number of arguments we need (3) then print error
                else if (eArgs[0].equals("java.lang.ArrayIndexOutOfBoundsException"))
                {
                    System.out.println("Program Faild to run because you have less or more than three arguments..");
                }
                //if its not a error from user input then just print error
                else
                {
                    System.out.println("An Error occurred " + e);
                }
    }
}
