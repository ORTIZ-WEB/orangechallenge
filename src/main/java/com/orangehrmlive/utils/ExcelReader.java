package com.orangehrmlive.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelReader {

    public static ArrayList<Map<String, String>> readDataFromExcelSheet(String excelPath, String excelSheet) throws IOException {
        ArrayList<Map<String, String>> dataListProject = new ArrayList<>();

        File file = new File(excelPath);
        if (!file.exists()) {
            throw new IOException("The file does not exist: " + excelPath);
        }

        try (FileInputStream inputStream = new FileInputStream(file);
             XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet newSheet = newWorkbook.getSheet(excelSheet);
            if (newSheet == null) {
                throw new IOException("The sheet does not exist: " + excelSheet);
            }

            Iterator<Row> rowIterator = newSheet.iterator();
            if (rowIterator.hasNext()) {
                Row titles = rowIterator.next();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Map<String, String> projectInfo = new HashMap<>(); // Inicializa el mapa aquí

                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();

                        if (titles.getCell(columnIndex) == null) {
                            continue; // Si el título es nulo, omite esta celda
                        }

                        switch (cell.getCellTypeEnum()) {
                            case STRING:
                                projectInfo.put(titles.getCell(columnIndex).toString(), cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                projectInfo.put(titles.getCell(columnIndex).toString(), String.valueOf((long) cell.getNumericCellValue()));
                                break;
                            case BLANK:
                                projectInfo.put(titles.getCell(columnIndex).toString(), "");
                                break;
                            default:
                                // Maneja otros tipos de celdas si es necesario
                        }
                    }

                    if (!projectInfo.isEmpty()) { // Solo agrega si hay datos
                        dataListProject.add(projectInfo);
                    }
                }
            } else {
                throw new IOException("The sheet is empty: " + excelSheet);
            }
        } catch (IOException e) {
            throw new IOException("Error reading the Excel file: " + e.getMessage(), e);
        }

        return dataListProject;
    }
}
