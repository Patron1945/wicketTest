package com.kucharz.patryk.wicketTest.bean;

public interface TableDataMBean
{
	int[][] getTableValues();
	
	int getCellValue(int row, int col);
	
	void setCellValue(int row, int col, int value);
}
