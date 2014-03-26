package com.kucharz.patryk.wicketTest.bean;

public class TableData implements TableDataMBean
{
	private int[][] table = { {1,2,3,4},{5,6,7,8}};

	
	@Override
	public int getCellValue(int row, int col)
	{
		return table[row][col];
	}

	@Override
	public void setCellValue(int row, int col, int value)
	{
		this.table[row][col] = value;
		
	}
}
