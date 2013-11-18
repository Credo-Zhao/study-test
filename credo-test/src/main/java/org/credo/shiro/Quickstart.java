package org.credo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

;

/**
 * 最简单的方法来创建和配置Shiro SecurityManager,realms、users、role和permissions是使用简单的INI配置。
 * 
 * @author Credo
 * 
 */
public class Quickstart {

	public static void main(String[] args) {
		// 初始化shiro SecurityManager 工厂.
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

		// 从SecurityManager中取出Shiro的SecurityManager对象
		SecurityManager securityManager = factory.getInstance();

		// 快速启动这个简单的例子，使安全管理器可作为JVM单身。
		// 大多数应用程序不会这样做，而是依靠其容器配置或为web应用程序的web.xml。
		SecurityUtils.setSecurityManager(securityManager);

		// ---------------上述就等于搭建好了一个简单的shiro环境-----------------

		// 获取当前执行操作的用户
		Subject currentSubject = SecurityUtils.getSubject();

		// 在一个shiro session中做一些事情,不需要web或ejb容器
		Session session = currentSubject.getSession();
		System.out.println("cuuerntUser:" + currentSubject.toString());
		session.setAttribute("someKey", "aValue");
		String value = (String) session.getAttribute("someKey");
		if (value.equals("aValue")) {
			System.out.println("容器中添加的值获取出来为:" + value);
		}

		// 登录当前用户,所以我们可以核对角色和权限
		// 判断是否进行了登录认证,未认证就进行认证处理
		if (!currentSubject.isAuthenticated()) {
			// 用户的用户名密码的输入,一般我们是要web登录页面获取到这些
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			// 其实就是确认要登录的意思
			token.setRememberMe(true);
			currentSubject.login(token);
		}
		
		//shiro中当前subject的唯一标识符.如现在就是用户名
		System.out.println("User " + currentSubject.getPrincipal() + " Login Successful!");
		
		 //验证用户是否拥有某个角色
        if (currentSubject.hasRole("schwartz")) {
            System.out.println("May the Schwartz be with you!");
        } else {
            System.out.println("Hello, mere mortal.");
        }

        //验证用户是否拥有某个权限 (not instance-level)
        if (currentSubject.isPermitted("lightsaber:weild")) {
            System.out.println("You may use a lightsaber ring.  Use it wisely.");
        } else {
            System.out.println("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentSubject.isPermitted("winnebago:drive:eagle5")) {
            System.out.println("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            System.out.println("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        currentSubject.logout();

        System.exit(0);
	}

}
