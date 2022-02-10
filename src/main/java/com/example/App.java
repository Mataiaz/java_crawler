package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {

        //False = no error handling. This for when working on code and testing for results
        Boolean HandleError = true;

        try {

            String url = args[0]; //Link to site you want to fetch data from
            int pages = Integer.parseInt(args[1]); //Select amount of pages it crawls through
            int posts = Integer.parseInt(args[2]); //Select amount of posts it fetches from page(2 pages is double the posts)
            
            Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above

        } catch (Exception e) {
            if (HandleError == true)
            {
                Error_handling.main(e);            
            }
            else {
                System.out.println(e);
            }
        }
    }
}
