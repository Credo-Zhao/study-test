package org.credo.jdk.io.ObjectStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ObjectStreamTest
{

	public static void main(String[] args)
	{
		try
		{
			testWrite();
			testRead();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private static final String TMP_FILE = "computer.tmp";
	

	public static void testWrite() throws FileNotFoundException, IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
		out.writeBoolean(true);
		out.writeByte((byte) 65);
		out.writeChar('a');
		out.writeInt(20131015);
		out.writeFloat(3.14F);
		out.writeDouble(1.414D);
		// 写入HashMap对象  
        HashMap<String,String> map = new HashMap<>();  
        map.put("one", "red");  
        map.put("two", "green");  
        map.put("three", "blue");  
        out.writeObject(map);  
        // 写入自定义的Computer对象，Computer实现了Serializable接口  
        Computer computer=new Computer(1, 5666.66, "Y480");
        out.writeObject(computer);
        out.close();
	}
	
	@SuppressWarnings("rawtypes")
	public static void testRead() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(TMP_FILE));
		System.out.printf("boolean:%b\n" , in.readBoolean());  
        System.out.printf("byte:%d\n" , (in.readByte()&0xff));  
        System.out.printf("char:%c\n" , in.readChar());  
        System.out.printf("int:%d\n" , in.readInt());  
        System.out.printf("float:%f\n" , in.readFloat());  
        System.out.printf("double:%f\n" , in.readDouble());
        
        // 读取HashMap对象  
        HashMap map = (HashMap) in.readObject();
        Iterator iterator=map.entrySet().iterator();
        while (iterator.hasNext())
		{
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.printf("%-6s -- %s\n" , mapEntry.getKey(), mapEntry.getValue());
		}
        
        //读取Computer
        Computer computer=(Computer)in.readObject();
        System.out.println("computer: " + computer);
        in.close();
	}

}

class Computer implements Serializable
{

	private static final long serialVersionUID = -6347513352513264586L;

	private int id;
	private double price;
	private String name;
	
	public Computer(int id,double price,String name) {
		this.id=id;
		this.price=price;
		this.name=name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj)
	{
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}

}