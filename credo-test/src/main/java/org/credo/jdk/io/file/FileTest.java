package org.credo.jdk.io.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileTest
{
	public static void main(String[] args) throws IOException
	{
		 //以当前路径来创建一个File对象
        File file=new File("credo");
        System.out.println("直接获取文件名:"+file.getName());
        System.out.println("获取文件相对路径的父路径可能出错,输出为NULL:"+file.getParent());
        System.out.println("获取绝对路径:"+file.getAbsolutePath());
        System.out.println("获取绝对路径对应的File对象:"+file.getAbsoluteFile());
        System.out.println("获取上一级路径:"+file.getAbsoluteFile().getParent());
        System.out.println("file:"+file);
        //检查是否存在,先创建目录。然后创建文件.不然报java.io.IOException: 系统找不到指定的路径.
        if(!file.exists()){  
            file.mkdirs();  
        } 
        //在当前路径下创建一个临时文件,名aaa属性为txt的.
        File tmpFile=File.createTempFile("aaa", ".txt",file);
        //JVM退出时删除该文件,另一个delete是直接删除.
        tmpFile.deleteOnExit();
         
        //以系统当前时间作为新文件名来创建新文件.
        File newFile=new File(System.currentTimeMillis()+"");
        System.out.println("判断newFile是否存在:"+newFile.exists());
        //以指定的newFile对象来创建一个文件
        newFile.createNewFile();
        //以newFile对象来创建一个目录,因为newFile已经存在所以下面方法返回false,无法创建该目录
        newFile.mkdir();
         
        //使用list()方法列出当前路径下的所有文件和路径
        String[] fileList=file.list();
        System.out.println("=========当前路径下所有文件和路径如下===========");
        for(String fileName:fileList){
            System.out.println("fileName:"+fileName);
        }
         
        //listRoots()静态方法列出所有的磁盘根路径
        File[] roots=File.listRoots();
        System.out.println("==========系统所有根路径如下=======");
        for(File root:roots){
            System.out.println("root:"+root);
        }
	}
}
