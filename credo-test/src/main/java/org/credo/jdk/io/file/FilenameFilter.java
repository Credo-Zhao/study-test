package org.credo.jdk.io.file;

import java.io.File;

public class FilenameFilter
{
	public static void main(String[] args)
	{
		// 以当前路径来创建一个File对象
		File file = new File(".");
		String[] nameList = file.list(new MyFileNameFilter());
		for (String str : nameList)
		{
			System.out.println(str);
		}
	}
}

class MyFileNameFilter implements java.io.FilenameFilter
{

	@Override
	public boolean accept(File dir, String name)
	{
		// 如果文件名以.java结尾,或者文件对应一个路径,则返回true
		return name.endsWith(".java") || new File(name).isDirectory();
	}

}