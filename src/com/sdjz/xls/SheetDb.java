package com.sdjz.xls;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sdjz.exception.DatabaseException;

public class SheetDb implements SheetDbInterface {
	private Sheet sheet;//工作表
	private Integer currentRow=0;
	private Workbook workbook;//工作簿
	private FileInputStream fileInputStream;
	
	public SheetDb(File file) throws Exception{
		fileInputStream =new FileInputStream(file);
		workbook=WorkbookFactory.create(fileInputStream);//通过fileInputStream获取工作簿
		
		this.sheet=workbook.getSheetAt(0);//工作簿中工作表的下标是从0开始的
	}
	/*
	 * @return 是否有下一行
	 * */
	public boolean next(){
		if(this.currentRow+1<=this.getRows()){
			this.currentRow++;
			return true;
		}
		return false;
	}
	
	/**
	 * @return 是否有上一行
	 */
	public boolean previous(){
		//必须>1
		if(this.currentRow>1){
			this.currentRow--;
			return true;
		}
		return false;
	}
	//以String[]的方式获得表头，相当于“元数据”
	//获取Map<>集合中的值：使用entrySet：  
    //  将map中的key-value关系存入到set集合中，再使用Map.Entry.getKey()和getValue()获取对应的值
	@Override
	public String[] getHeader() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//获得表头值与其序号的对应Map
		Map<String,Integer> headerMap = this.getHeaderMap(this.sheet);
		//由Map得到对应的"键-值"对的set,使用的是entrySet
		Set<Entry<String,Integer>> entrySet=headerMap.entrySet();
		
		//创建set对应的List（因为要排序）
		List<Map.Entry<String, Integer>> entryList=new ArrayList<Map.Entry<String,Integer>>(entrySet);
		//根据set的实际元素个数，创建数组
		String[] headers = new String[entrySet.size()];
		// 将List排序，序号小的在前面
		Collections.sort(entryList,
						new Comparator<Map.Entry<String,Integer>>(){
							@Override
							public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
								// TODO Auto-generated method stub
								// 以值排序，即序号
								return (o1.getValue() - o2.getValue());
							}
			
		});
		//数组下标初值
		int index=0;
		//遍历List，将列名作为数组值（列序号为数组下标）
		for(Entry<String,Integer> entry:entryList){
			headers[index++]=entry.getKey();
		}
		return headers;
	}

	@Override
	public List<Map<String, String>> getRow() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> getRow(Integer row) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRows(){
		// TODO Auto-generated method stub	
		return this.sheet.getLastRowNum();//获取最后一行的行标，比行数小1；
	}

	@Override
	//列数,以表头列为准，无表头的列会被忽略
	public Integer getColumns() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return this.getHeader().length;
	}
	
	// 以String的方式返回单元格的值
	public String getCell(String header) throws DatabaseException{
		return getCell(this.currentRow,header);
	}
	// 通过行号和列名，获对应单元格的值
	public String getCell(Integer rowNum,String header ) throws DatabaseException{
		//获得表头值与其序号的对应Map
		Map<String,Integer> headerMap =getHeaderMap(this.sheet);		
		//如果给出的列名在Map中不存在，则抛出异常
		if(!headerMap.containsKey(header)){
			throw new DatabaseException(header+" 列无效");
		}
		//根据列名获得列序号
		int cellNum=headerMap.get(header);
		/*获取指定的行
		 * getRow(int)从0开始
		 * */
		Row row=this.sheet.getRow(rowNum);
		String cellValue=null;
		//如果行不为空
		if(row!=null){
			/*获得指定行、指定列名的单元格的值
			 getCell(int)从0开始，故cellnum-1。*/
			Cell cell=row.getCell(cellNum-1);
			cellValue=cell==null?"":cell.toString();
			//使用split分割字符串,通过.分割
			String regexStr="\\.";
			//获取第一个值，split返回一个字符串数组
			cellValue=cellValue.split(regexStr)[0];
		}
		return cellValue;
		
	}
	
	public Object getCellWithType(String header) throws FileNotFoundException, IOException{
		return getCellWithType(this.currentRow,header);		
	}
	//以Object的类型返回当前行指定单元格的值，如果单元格为数值，則可以转换为Double
	@Override
	public Object getCellWithType(int rowNum, String header) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Map<String,Integer> headerMap =getHeaderMap(this.sheet);
		int cellNum=headerMap.get(header);
		/*获取指定的行
		 * getRow(int)从0开始
		 * */
		Row row=this.sheet.getRow(rowNum);
		if(row!=null){
			/*获得指定行、指定列名的单元格的值
			 getCell(int)从0开始，故cellnum-1。*/
			Cell cell=row.getCell(cellNum-1);
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:{
				//使用split分割字符串,通过.分割
				String regexStr="\\.";
				//获取第一个值，split返回一个字符串数组
				return  cell.getStringCellValue().split(regexStr)[0];
			}
			case Cell.CELL_TYPE_NUMERIC:{
				return cell.getNumericCellValue();
			}
			case Cell.CELL_TYPE_BLANK:{
				return null;
			}
			default:{
				return cell.getRichStringCellValue();
			}
			}
		}
		return null;
	}
	//以Double返回指定行、指定单元格的值
	public Double getDouble(int rowNum,String header){
		Map<String,Integer> headerMap =getHeaderMap(this.sheet);
		int cellNum=headerMap.get(header);
		/*获取指定的行
		 * getRow(int)从0开始
		 * */
		Row row=this.sheet.getRow(rowNum);
		if(row!=null){
			/*获得指定行、指定列名的单元格的值
			 getCell(int)从0开始，故cellnum-1。*/
			Cell cell=row.getCell(cellNum-1);
			return cell.getNumericCellValue();
		}
		return null;
	}
	// 以Integer返回指定行、指定单元格的值
	public Integer getInt(int row, String header) throws FileNotFoundException,
			IOException {
			return (int)this.getDouble(row, header).doubleValue();
	}
	//得到Map<单元格值,单元格序号>
	private Map<String,Integer> getHeaderMap(Sheet sheet){
		//获得首行，即标题行
		Row row = this.sheet.getRow(0);
		//创建Map<值,序号>
		Map<String,Integer> headerMap=new HashMap<String,Integer>();
		//单元格序号初值为0
		int cellNum=0;
		Cell cell=row.getCell(cellNum);
		//单元格值为空
		RichTextString richStringCellValue=null;
		while(cell!=null){
			//获得当前单元格的值
			richStringCellValue=cell.getRichStringCellValue();
			//置入Map中，单元格值<->单元格序号
			headerMap.put(richStringCellValue.toString(),cellNum);
			//获得下一个单元格
			cell=row.getCell(cellNum++);
			
		}
		return headerMap;
		
	}
	public void print() throws FileNotFoundException, IOException{
		System.out.println("cols**********"+this.getColumns());	
		System.out.println("������============"+this.getRows());
		String[] arr = this.getHeader();
		for(int i=0;i<this.getHeader().length;i++){
			System.out.println(arr[i]);
		}
	}

}
