package com.simba.goodfitmanager.util;

//import org.apache.poi.ss.usermodel.*;

import com.simba.goodfitmanager.pojo.Fit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 操作excel表
 * xlsx表
 * 表格格式应该是
 * 序号  配件码 状态
 * 2019年5月15日
 */
public class ExcelUtil {

    public static List<Fit> importExcel(String fileName) throws Exception {

        try {
            List<Fit> fitList = new ArrayList<>();

            InputStream inputStream = new FileInputStream(fileName);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

            for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                XSSFCell iccid = xssfRow.getCell(1);
                XSSFCell type = xssfRow.getCell(2);

                Fit fit = new Fit();
                fit.setIcid(iccid.getStringCellValue());
                fit.setType((int)type.getNumericCellValue());
                // 整合时间格式
                Date date = new Date();          // 获取当前时间
                Timestamp createTime = new Timestamp(date.getTime());
                fit.setCreateTime(createTime);
//                System.out.println(fit.toString());
                fitList.add(fit);
//                System.out.println(fitList.get(i-1));
            }
            System.out.println("解析成功");
            return fitList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
