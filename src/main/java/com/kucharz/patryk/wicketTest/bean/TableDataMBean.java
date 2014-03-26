package com.kucharz.patryk.wicketTest.bean;

public interface TableDataMBean
{
	public int getCellValue(int row, int col);
	
	public void setCellValue(int row, int col, int value);
}
