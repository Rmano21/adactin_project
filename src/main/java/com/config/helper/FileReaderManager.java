package com.config.helper;

import java.io.IOException;
//singleton pattern

public class FileReaderManager {
	private FileReaderManager() {
	
	}
		
	public static FileReaderManager getInstanceFrm(){
		FileReaderManager frm = new FileReaderManager();
		return frm;
		
	}
	public Configuration_Reader getInstancecr() throws IOException{
		Configuration_Reader cr = new Configuration_Reader();
		return cr;
		
	}

}
