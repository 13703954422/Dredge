package com.util;

import java.io.File;

public class FileUtil {
	
	/**
	 * ��֤�ļ��Ƿ����
	 * @param file �ļ�·��
	 * @return �Ƿ����
	 */
	public static boolean checkIsExist(File file) {
		
		if(file.exists()) {
			return true;
		}
		return false;
	}

}
