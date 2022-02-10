package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {
        
        try {

            String url = args[0]; //Link to site you want to fetch data from
            int pages = Integer.parseInt(args[1]); //Select amount of pages it crawls through
            int posts = Integer.parseInt(args[2]); //Select amount of posts it fetches from page(2 pages is double the posts)
            
            Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above

        } catch (Exception e) {
            Error_handling.main(e);            
        }
    }
}
