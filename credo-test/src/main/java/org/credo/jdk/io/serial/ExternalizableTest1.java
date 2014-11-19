package org.credo.jdk.io.serial;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest1
{
	private static final String TMP_FILE = ".externalizabletest1.txt";

	public static void main(String[] args)
	{
		// 将“对象”通过序列化保存
		testWrite();
		// 将序列化的“对象”读出来
		testRead();
	}

	public static void testWrite()
	{
		try
		{
			// 获取文件TMP_FILE对应的对象输出流。
			// ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
			// 创建Box对象
			BoxA box = new BoxA("desk", 80, 48);
			// 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
			out.writeObject(box);
			// 打印“Box对象”
			System.out.println("testWrite box: " + box);

			out.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void testRead()
	{
		try
		{
			// 获取文件TMP_FILE对应的对象输入流。
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
			// 从对象输入流中，读取先前保存的box对象。
			BoxA box = (BoxA) in.readObject();
			// 打印“Box对象”
			System.out.println("testRead  box: " + box);
			in.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class BoxA implements Externalizable
{
	private int width;
	private int height;
	private String name;

	public BoxA()
	{
	}

	public BoxA(String name, int width, int height)
	{
		this.name = name;
		this.width = width;
		this.height = height;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeObject(name);
		out.writeInt(width);
		out.writeInt(height);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		name=(String) in.readObject();
		width=in.readInt();
		height=in.readInt();
	}

	@Override
	public String toString()
	{
		return "[" + name + ": (" + width + ", " + height + ") ]";
	}

}
