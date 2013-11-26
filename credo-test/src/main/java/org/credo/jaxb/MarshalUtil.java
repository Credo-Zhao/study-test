package org.credo.jaxb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.credo.jaxb.model.Overinfo;
import org.credo.jaxb.model.Userinfo;

public class MarshalUtil {

	public static byte[] marshal(Object obj) throws JAXBException {

		JAXBContext context = JAXBCache.instance().getJAXBContext(obj.getClass());
		Marshaller m = context.createMarshaller();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(obj, outputStream);
		byte[] result = outputStream.toByteArray();
		return result;
	}

	public static Object unmarshal(byte[] data, Class<?> classe) throws JAXBException {

		JAXBContext context = JAXBCache.instance().getJAXBContext(classe);
		Unmarshaller m = context.createUnmarshaller();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		Object obj = m.unmarshal(inputStream);
		return obj;
	}

	public static Object unmarshal(InputStream in, Class<?> classe) throws JAXBException, IOException {

		JAXBContext context = JAXBCache.instance().getJAXBContext(classe);
		byte[] data = IOUtils.toByteArray(in);
		Unmarshaller m = context.createUnmarshaller();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		Object obj = m.unmarshal(inputStream);
		return obj;
	}

	public static void main(String[] args) throws JAXBException {

		Userinfo userinfo = new Userinfo();
		userinfo.setId(Long.valueOf(11));
		List<Overinfo> list = new ArrayList<Overinfo>();
		Overinfo e = new Overinfo();
		e.setHobby("陪女友");
		list.add(e);
		Overinfo e1 = new Overinfo();
		e1.setHobby("写代码");
		list.add(e1);
		userinfo.setOverinfos(list);

		byte[] b = MarshalUtil.marshal(userinfo);
		System.out.println(new String(b));
		userinfo = (Userinfo) MarshalUtil.unmarshal(b, Userinfo.class);

		System.out.println(userinfo.getOverinfos().get(0).getHobby());

	}
}
