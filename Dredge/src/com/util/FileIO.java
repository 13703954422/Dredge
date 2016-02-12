package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FileIO
{
	public static File getFile(String name) {
		return new File(name);
	}
	public static String readFile(File file,String encode) {
		StringBuffer buffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		try
		{
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName(encode)));
			char c[] = new char[1024];
			int n;
			while ((n = bufferedReader.read(c)) != -1)
			{
				buffer.append(c,0,n);
			}
			bufferedReader.close();
			return buffer.toString();
		}catch(Exception e)
		{
			return null;
		}finally
		{
			if(bufferedReader != null)
			{
				try
				{
					bufferedReader.close();
				} catch (IOException e)
				{
					return null;
				}
			}
		}
	}
	
	public static String readFileByLine(File file,String encode) {
		StringBuffer buffer = new StringBuffer();
		Scanner sc = null;
		try {
			sc = new Scanner(new InputStreamReader(new FileInputStream(file),Charset.forName(encode)));
			while(sc.hasNextLine()) {
				buffer.append(sc.nextLine());
				buffer.append("\n");
			}
			sc.close();
			return buffer.toString();
		} catch (FileNotFoundException e) {
			return null;
		}finally {
			if(sc != null) {
				try {
					sc.close();
				} catch (Exception e) {
					return null;
				}
			} 
		}
	}
	
	
	
	public static boolean writeFile(File file,char[] chars,int off,int n) {
		FileWriter fw = null;
		try
		{
			fw = new FileWriter(file);
			fw.write(chars, off, n);			
		}catch(Exception e)
		{
			return false;
		}finally
		{
			//�ر�������
			if(fw != null)
			{
				try
				{
					fw.close();
				} catch (IOException e)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static boolean writeFile(File file,byte[] bytes,int off,int n) {
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			fos.write(bytes, off, n);	
		}catch(Exception e)
		{
			return false;
		}finally
		{
			//�ر�������
			if(fos != null)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static boolean writeFile(File file,char[] chars) {
		return writeFile(file, chars, 0, chars.length);
	}
	public static boolean writeFile(File file,byte[] bytes) {
		return writeFile(file, bytes,0,bytes.length);
	}
	public static boolean writeFile(File file,String str,String encode) {
		try
		{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName(encode)));
			bw.write(str);
			bw.close();
			return true;
		}catch(Exception e)
		{
			
		}
		return false;
	}
	/**
	 * @param oldFile ԭ�ļ�
	 * @param newFile ���ļ�
	 * @return �Ƿ��Ƴɹ�
	 */
	public static boolean copyFile(File oldFile,File newFile) {
		if(oldFile.exists() == false)
		{
			return false;
		}
		
		
		try
		{
			FileInputStream fis = new FileInputStream(oldFile);
			int n;
			byte buf[] = new byte[1024];
			FileOutputStream fos = new FileOutputStream(newFile);
			while((n = fis.read(buf)) != -1)
			{
				fos.write(buf, 0, n);
			}
			fos.close();
			fis.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("�ļ�����ʧ��!");
			return false;
		}
	}
	/**
	 * 
	 */
	public static boolean appendFile(File file,String str) {
		return appendFile(file, str,"UTF-8");
	}
	/**
	 * @param file Ҫд����ļ�
	 * @param str  Ҫд�������
	 * @param encode ����
	 */
	@Deprecated
	public static boolean appendFile(File file,String str,String encode) {
		BufferedWriter bufferedWriter = null;
		try
		{
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), Charset.forName(encode)));
			bufferedWriter.append(str);
			return true;
		}catch (Exception e)
		{
			
		}
		finally
		{
			if(bufferedWriter != null)
			{
				try
				{
					bufferedWriter.close();
				} catch (Exception e){}
			}
		}
		return false;
	}
	
	public static void deleteFile(File file) {
		if(file.isFile())
		{
			file.delete();
		}else
		{
			if(file.exists())
			{
				File files[] = file.listFiles();
				for(File one : files)
				{
					deleteFile(one);
				}
			}
		}
	}
}
