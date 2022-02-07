package com.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.io.IOException;

import org.jsoup.Jsoup;

public class Crawler {
    public static void main(String url, int pages, int posts) throws IOException {
        //Variables for printing time in terminal for easy tracking in case of multiple runs
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        //Variables for connecting to webpage and cycling through html code
        Document doc = Jsoup.connect(url).get();
        int pagesWanted = 1;
        int totPosts = 0;
        int postsWanted = 0;

        try {
            //Page loop
            while (pagesWanted < pages || pagesWanted == pages) {
                System.out.println("\n[ PAGE " + pagesWanted + " ]");
                doc = Jsoup.connect(url + pagesWanted).get();
                //Post loop
                while (postsWanted < posts) {
                    Elements ebody = doc.select("ul.anime-list");
                    //Element loop
                    for (Element e : ebody.select("li")) {
                        String linkend = e.select("a.name").attr("href");
                        String title = e.select("a.name").attr("data-jtitle");
                        System.out.println("______________________" + "\n\nTITLE = "
                                + title + "\nLINK  = " + "https://9anime.to" + linkend);
                        postsWanted++;
                        //
                        if (posts > 0) {
                            if (postsWanted == posts)
                                break;
                        }
                    }
                }
                //Here we move to next page and also store the amount of posts to be printed
                totPosts = totPosts + postsWanted;
                postsWanted = 0;
                pagesWanted++;
            }
            //Gets current local time and prints out time + relevant html data
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("______________________\n" + "\nPROGRAM FINISHED AT\n" +
                    dtf.format(now) + "\nPages looked through " + (pagesWanted - 1) +
                    "\n" + "Posts looked through " + totPosts + "\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
