package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {
        
        //If theres no arguments from main
        try {
            String url = args[0]; //Link to site you want to fetch data from
            int pages = Integer.parseInt(args[1]); //Select amount of pages it crawls through
            int posts = Integer.parseInt(args[2]); //Select amount of posts it fetches from page(2 pages is double the posts)
            
            Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
        } catch (Exception e) {
            //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
            String eString = e.toString();
            if (eString.equals("java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0"))
                {
                    System.out.println("RUNNING WITH PREMADE INPUT");
                    String url = "https://9anime.to/newest?page="; //Link to site you want to fetch data from
                    int pages = 3; //Select amount of pages it crawls throughw
                    int posts = 10; //Select amount of posts it fetches from page(2 pages is double the posts)
                    Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
                }
                else
                {
                    System.out.println("Program Faild to run " + e);
                }
        }
    }
}
