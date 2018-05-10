package com.shop.utility;


import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	
	private static String rootPath = "C:\\Users\\Gauri Gaur\\Documents\\GitHub\\ShoppingCart2\\ShoppingCartFrontEnd\\src\\main\\webapp\\assests\\images";	
	
	public static boolean fileCopyNIO(MultipartFile file,String fileName)
	{
		File dest=new File(rootPath+File.separator+fileName);
		
		try
		{
			file.transferTo(dest);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
	
	

	

