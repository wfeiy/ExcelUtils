/*
 *  Copyright 2022-2122 the original author or authors.
 */

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadExcel {

    private static final int MAX_ROW_CUT = 9;

    public static void main(String[] args) {
        String excelName = "";
        readExcel(excelName);
    }

    private static void readExcel(String excelName) {
        try {
            File file = new File(excelName);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            int sheetNum = 0;

            // get now sheet work
            XSSFSheet sheet = workbook.getSheetAt(sheetNum);

            // get colums key
            List<LinkedHashMap<String, String>> storeList = new ArrayList<LinkedHashMap<String, String>>();
            LinkedHashMap<String, LinkedHashMap<String, String>> storeMap =
                    new LinkedHashMap<String, LinkedHashMap<String, String>>();
            ArrayList<String> keyList = new ArrayList<String>();
            XSSFRow row = null;
            for (int i = 0; i < MAX_ROW_CUT; i++) {
                row = sheet.getRow(i);
                keyList.add(row.getCell(0).toString());
            }
            for (String s : keyList) {
                System.out.print("s");
            }

            // read value
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
