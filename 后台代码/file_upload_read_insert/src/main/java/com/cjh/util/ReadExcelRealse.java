package com.cjh.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.cjh.entity.User;

/**
 * 读取Excel文件，xls和xlsx,兼容2003/2007/2010
 */
public class ReadExcelRealse {

    public static Set<User> readExcel(InputStream inputStream) throws Exception{
    		Set<User> users = new LinkedHashSet<User>();
            //输入流
            InputStream is = inputStream;
            /*使用import org.apache.poi.ss.usermodel.*包，同 时支持两种格式的读取*/
             //使用Workbook可以读取2003/2007/2010的excel文件
            Workbook workbook = WorkbookFactory.create(is); 
            Iterator<Sheet> sheets = workbook.sheetIterator();
            //迭代遍历sheet
            while (sheets.hasNext()) {
                Sheet sheet = sheets.next();
                Iterator<Row> rows = sheet.rowIterator();
                //迭代遍历每行
                while (rows.hasNext()) {
                    Row row = rows.next();
                    users.add(new User(row.getCell(0).getStringCellValue(),
                    		row.getCell(1).getStringCellValue()));
                }
            }
            is.close();
            return users;
    }
}