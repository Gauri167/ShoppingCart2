package com.shop.utility;


import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/*private static final Logger logger = LoggerFactory
			.getLogger(FileUtil.class);*/
	
	
	
	private static String rootPath = "C:\\Users\\Gauri Gaur\\Documents\\GitHub\\ShoppingCart2\\ShoppingCartFrontEnd\\src\\main\\webapp\\assests\\images";//catalina home gives the location of tomcat directory
	
	//private static final String imageDirectory="ShoppingCartImages";
	
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
	
	/*public static boolean copyFile(String fileName,MultipartFile file)
	{
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				File dir = new File(rootPath + File.separator + fileName);//sepator for diff os is diff so we use file.separator
				if (!dir.exists())
					dir.mkdirs();//mkdirs=make directory

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
                 //in case of boolean simply return true or false
				return  true;//"You successfully uploaded file=" + fileName;
			} catch (Exception e) {
				return false;//"You failed to upload " + fileName + " => " + e.getMessage();
			}
		} else {
			return false;// "You failed to upload " + fileName
					//+ " because the file was empty.";
		}
	}*/
	
	

	

