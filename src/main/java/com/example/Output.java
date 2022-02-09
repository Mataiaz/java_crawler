package com.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jxl.Hyperlink;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;


public class Output {
    public static void main(String title, String link, Workbook wb, Sheet sheet, Row column, CreationHelper cellInput, int place) {
        CellStyle cs = wb.createCellStyle();
        if(place < 1)
        {
            place = 1;
        }
        Row row = sheet.createRow(place);
        Cell cellPostTitle  = row.createCell(0);
        Cell cellPostLink   = row.createCell(1);
        cellPostTitle.setCellValue(cellInput.createRichTextString(title));
        cellPostLink.setCellValue(cellInput.createRichTextString(link));
        cs.setWrapText(true);
        cellPostLink.setCellStyle(cs);
        cellPostTitle.setCellStyle(cs);
        cellPostLink.getSheet().setDefaultRowHeightInPoints(1);
        cellPostTitle.getSheet().setDefaultRowHeightInPoints(15);
    }
}
