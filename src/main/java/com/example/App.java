package com.example;

import java.io.IOException;

public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException {

        String url = "https://9anime.to/newest?page="; //Link to site you want to fetch data from

        int pages = 1; //Select amount of pages it crawls through
        int posts = 2; //Select amount of posts it fetches from page(2 pages is double the posts)

        Crawler.main(url, pages, posts); //Algorithm which takes in the url, pages and posts given above
    }

}
