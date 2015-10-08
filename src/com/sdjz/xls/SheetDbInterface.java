package com.sdjz.xls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SheetDbInterface {
	//获得表头
	String[] getHeader() throws FileNotFoundException,IOException;
	//获取当前行
	List<Map<String,String>> getRow() throws FileNotFoundException,IOException;
	//获取指定行
	List<Map<String,String>> getRow(Integer row) throws FileNotFoundException,IOException;
	//获取总行数
	Integer getRows() throws FileNotFoundException,IOException;
	//获取总列数
	Integer getColumns()throws FileNotFoundException,IOException;
	//如果单元格为数值，则转为double
	public Object getCellWithType(int row,String header) throws FileNotFoundException,IOException;

}
