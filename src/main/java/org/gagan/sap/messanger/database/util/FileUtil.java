package org.gagan.sap.messanger.database.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class FileUtil {

	final static Logger logger = Logger.getLogger(FileUtil.class);

	public static void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			throw new RuntimeException("failed to rewrite the file");
		}

	}

	public static String getFileExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public static void saveImage(int id, InputStream uploadedInputStream, FormDataContentDisposition fileDetail,
			String destinationPath) {
		writeToFile(uploadedInputStream, destinationPath);
		String output1 = "File uploaded to : " + destinationPath;
		logger.info(output1);
	}

}
