package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {
        
        //If you want to run program with external input
        String url = args[0];
        int pages = Integer.parseInt(args[1]);
        int posts = Integer.parseInt(args[2]);
        /*
        //If you want to run program with internal input
        String url = "https://9anime.to/newest?page="; //Link to site you want to fetch data from
        int pages = 1; //Select amount of pages it crawls through
        int posts = 2; //Select amount of posts it fetches from page(2 pages is double the posts)
        */
        
        Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
    }

}
