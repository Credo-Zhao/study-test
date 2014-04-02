package org.credo.spring.a1;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testByXmlBeanFactory() {
	BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
		"beanFactoryTest.xml"));
	MyBean myBean = (MyBean) beanFactory.getBean("myBean");
	System.out.println(myBean.getTestStr());
	Assert.assertEquals("Hello Spring", myBean.getTestStr());
    }

}
