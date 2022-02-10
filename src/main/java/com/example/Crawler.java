package com.example;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;


public class Crawler {
    public static void main(String url, int pages, int posts) throws IOException {
        //Variables for printing time in terminal for easy tracking in case of multiple runs
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

        //Excel file setup

        Workbook wb = new XSSFWorkbook();
        CellStyle cs = wb.createCellStyle();
        CreationHelper cellInput = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("resultExcel");
        Row column = sheet.createRow(0);
        Cell cellPostTitle  = column.createCell(0);
        Cell cellPostLink   = column.createCell(1);
        cellPostTitle.setCellValue(cellInput.createRichTextString("Post titles"));
        cellPostLink.setCellValue(cellInput.createRichTextString("Post links"));
        cs.setWrapText(true);
        cellPostLink.setCellStyle(cs);
        cellPostTitle.setCellStyle(cs);

        //Variables for connecting to webpage and cycling through html code
        Document doc = Jsoup.connect(url).get();
        String[] urlsplit = url.split("/");
        String http = "https://";

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
                        String href = e.select("a.name").attr("href");
                        String title = e.select("a.name").attr("data-jtitle");
                        System.out.println("______________________" + "\n\nTITLE = "
                                + title + "\nLINK  = " + http + urlsplit[2] + href);
                        String link = http + urlsplit[2] + href;
                        Output.main(title, link, wb, sheet, column, cellInput, totPosts);
                        postsWanted++;
                        totPosts++;
                        //
                        if (posts > 0) {
                            if (postsWanted == posts)
                                break;
                        }
                    }
                }
                //Here we move to next page and also store the amount of posts to be printed
                postsWanted = 0;
                pagesWanted++;
            }
            //Gets current local time and prints out time + relevant html data
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("______________________\n" + "\nPROGRAM FINISHED AT\n" +
                    dtf.format(now) + "\nPages looked through " + (pagesWanted - 1) +
                    "\n" + "Posts looked through " + totPosts + "\n");
            FileOutputStream out = new FileOutputStream(
                new File("results.xlsx"));
              
            wb.write(out);
            out.close();
            wb.close();
        } catch (Exception e) {
            Error_handling.main(e);
        }
    }
}
