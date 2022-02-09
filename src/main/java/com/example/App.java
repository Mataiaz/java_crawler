package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {
        
        //If theres no arguments from main
        if (args[0] == "")
        {
            String url = "https://9anime.to/newest?page="; //Link to site you want to fetch data from
            int pages = 3; //Select amount of pages it crawls through
            int posts = 10; //Select amount of posts it fetches from page(2 pages is double the posts)
            Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
        }
        else
        {
            String url = args[0]; //Link to site you want to fetch data from
            int pages = Integer.parseInt(args[1]); //Select amount of pages it crawls through
            int posts = Integer.parseInt(args[2]); //Select amount of posts it fetches from page(2 pages is double the posts)
            
            Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
        }
        
    }

}
