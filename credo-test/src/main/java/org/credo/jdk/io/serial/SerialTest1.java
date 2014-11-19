package org.credo.jdk.io.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialTest1
{

	public static void main(String[] args)
	{
		testWrite();
		testRead();
	}
	
	private static final String TMP_FILE = "serialtest1.txt"; 
	
	public static void testWrite() {
		try
		{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(TMP_FILE));
			Box box=new Box("AAA", 180, 180);
			oos.writeObject(box);
			System.out.println("testWrite box: " + box); 
			oos.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void testRead() {
		try
		{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(TMP_FILE));
			Box box=(Box) ois.readObject();
			System.out.println("read box:"+box);
			ois.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
/**  
 * Box类“支持序列化”。因为Box实现了Serializable接口。  
 *  
 * 实际上，一个类只需要实现Serializable即可实现序列化，而不需要实现任何函数。  
 */ 
class Box implements Serializable {  
	
	private static final long serialVersionUID = -6722457644709778968L;
	
	private int width;     
    private int height;   
    private String name;     
 
    public Box(String name, int width, int height) {  
        this.name = name;  
        this.width = width;  
        this.height = height;  
    }  
 
    @Override 
    public String toString() {  
        return "["+name+": ("+width+", "+height+") ]";  
    }  
} 