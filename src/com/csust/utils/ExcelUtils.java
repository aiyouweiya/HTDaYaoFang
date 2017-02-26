package com.csust.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.csust.model.Employee;
import com.csust.model.Yao;

public class ExcelUtils {
	public static boolean exportSellExcel(List<Yao> list,String num[],String path) {
		 // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("批发药物信息");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("编号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("名称");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("类型");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("售价");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("数量");  
        cell.setCellStyle(style); 
		for(int i=0;i<list.size();i++){
			 row = sheet.createRow((int) i + 1);  
	            Yao yao = (Yao) list.get(i);  
	            //创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue(yao.getBianhao());  
	            row.createCell((short) 1).setCellValue(yao.getName());  
	            row.createCell((short) 2).setCellValue(yao.getType());  
	            row.createCell((short) 3).setCellValue(yao.getSellPrice());  
	            row.createCell((short) 4).setCellValue(num[i]);
		}
		   // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            return false;
        }  
		return true;
	}

	public static boolean exportYaoTypeExcel(List<Yao> list,String path) {
		 // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("批发药物信息");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("编号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("名称");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("类型");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("售价");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("批发价");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 5);  
        cell.setCellValue("库存");  
        cell.setCellStyle(style); 
		for(int i=0;i<list.size();i++){
			 row = sheet.createRow((int) i + 1);  
	            Yao yao = (Yao) list.get(i);  
	            //创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue(yao.getBianhao());  
	            row.createCell((short) 1).setCellValue(yao.getName());  
	            row.createCell((short) 2).setCellValue(yao.getType());  
	            row.createCell((short) 3).setCellValue(yao.getSellPrice());  
	            row.createCell((short) 4).setCellValue(yao.getPifaPrice());  
	            row.createCell((short) 5).setCellValue(yao.getRemainCount());
		}
		   // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            return false;
        }  
		return true;
	}

	public static boolean exportGarageExcel() {

		return false;
	}

	public static boolean exportPifaExcel(List<Yao> list,String[] pifaNum,String price[],String path) {
		 // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("批发药物信息");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("编号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("名称");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("类型");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("售价");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("批发价");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 5);  
        cell.setCellValue("批发数量");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 6);  
        cell.setCellValue("总价");  
        cell.setCellStyle(style); 
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
  
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Yao yao = (Yao) list.get(i);  
            //创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(yao.getBianhao());  
            row.createCell((short) 1).setCellValue(yao.getName());  
            row.createCell((short) 2).setCellValue(yao.getType());  
            row.createCell((short) 3).setCellValue(yao.getSellPrice());  
            row.createCell((short) 4).setCellValue(yao.getPifaPrice());  
            row.createCell((short) 5).setCellValue(pifaNum[i]);
            row.createCell((short) 6).setCellValue(price[i]);
            
//            cell = row.createCell((short) 3);  
//            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu  
//                    .getBirth()));  
        }  
        // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            return false;
        }  
		return true;
	}

	public static boolean exportStaffExcel(List<Employee> list,String path) {
		 // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("职工信息");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("职工号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("职位");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("密码");  
        cell.setCellStyle(style);  
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
  
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Employee emp = (Employee) list.get(i);  
            //创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(emp.getName());  
            row.createCell((short) 1).setCellValue(emp.getJobID());  
            row.createCell((short) 2).setCellValue(emp.getPosition());  
            row.createCell((short) 3).setCellValue(emp.getPassword());  
//            cell = row.createCell((short) 3);  
//            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu  
//                    .getBirth()));  
        }  
        
        // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(path);  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            return false;
        }  
		return true;
	}
}
