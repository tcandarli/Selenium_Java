package com.cybertek;

public class WorkWithExcel {

	public static void main(String[] args) {

		String path = "C:\\Users\\PC\\Documents\\github\\Selenium\\testing-maven\\WorkingWithExcel\\testData.xlsx";
		Xls_Reader data = new Xls_Reader(path);

		int rcount = data.getRowCount("data");
		System.out.println(rcount);

		String cdata = data.getCellData("data", "Name", 2);
		System.out.println(cdata);

		int ccount = data.getColumnCount("data");
		System.out.println(ccount);

		data.setCellData("data", "Name", 8, "Mary");

	}

}
