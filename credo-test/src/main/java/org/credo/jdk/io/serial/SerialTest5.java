package org.credo.jdk.io.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialTest5
{
	private static final String TMP_FILE = ".serialtest5.txt";

	public static void main(String[] args)
	{
		testWrite();
		testRead();
	}

	/**
	 * 将Box对象通过序列化，保存到文件中
	 */
	private static void testWrite()
	{
		try
		{
			// 获取文件TMP_FILE对应的对象输出流。
			// ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
			// 创建Box对象，Box实现了Serializable序列化接口
			Box5 box = new Box5("desk", 80, 48);
			// 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
			out.writeObject(box);
			// 打印“Box对象”
			System.out.println("testWrite box: " + box);
			// 修改box的值
			box = new Box5("room", 100, 50);

			out.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * 从文件中读取出“序列化的Box对象”
	 */
	private static void testRead()
	{
		try
		{
			// 获取文件TMP_FILE对应的对象输入流。
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
			// 从对象输入流中，读取先前保存的box对象。
			Box5 box = (Box5) in.readObject();
			// 打印“Box对象”
			System.out.println("testRead  box5: " + box);
			in.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

/**
 * Box类“支持序列化”。因为Box实现了Serializable接口。
 * 实际上，一个类只需要实现Serializable即可实现序列化，而不需要实现任何函数。
 */
class Box5 implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static int width;
	private transient int height;
	private String name;
	
	private Thread thread = new Thread() {  
        @Override 
        public void run() {  
            System.out.println("Serializable thread");  
        }  
    }; 

	public Box5(String name, int width, int height)
	{
		this.name = name;
		this.width = width;
		this.height = height;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException
	{
		// 使定制的writeObject()方法可以利用自动序列化中内置的逻辑。
		oos.defaultWriteObject();
		oos.writeInt(width);
		oos.writeInt(height);
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
	{
		// defaultReadObject()补充自动序列化
		ois.defaultReadObject();
		width = ois.readInt();
		height = ois.readInt();
	}

	@Override
	public String toString()
	{
		return "[" + name + ": (" + width + ", " + height + ") ]";
	}
}
