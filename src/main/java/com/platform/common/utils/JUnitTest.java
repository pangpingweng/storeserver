package com.platform.common.utils;


import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Test;
import org.n52.matlab.control.MatlabConnectionException;
import org.n52.matlab.control.MatlabInvocationException;
import org.n52.matlab.control.MatlabProxy;
import org.n52.matlab.control.MatlabProxyFactory;
import org.n52.matlab.control.extensions.MatlabTypeConverter;

public class JUnitTest extends TestCase {

	@Test
	public void testMatlab() throws MatlabConnectionException, MatlabInvocationException {
		MatlabProxyFactory factory = new MatlabProxyFactory();
		MatlabProxy proxy = factory.getProxy();
		String path1 = "H:/Desktop/rock/Rock Dataset/field_test-igneous.jpg";
		String path2 = "H:/Desktop/rock/field_net.mat";

		proxy.returningFeval("recog",2);

//		MatlabTypeConverter converter = new MatlabTypeConverter(proxy);
//		proxy.eval("[label,prob]=recog()");//第一次参数是你需要用到的函数的名称，第二个参数是返回的结果的数量，第三个、第四个...第N个参数都是你需要输入的参数        具体查看包的文档，不再赘述。
//		System.out.println(JSON.toJSONString(converter.getNumericArray("label")));
//		System.out.println(JSON.toJSONString(converter.getNumericArray("prob")));

		proxy.exit();
	}



}
