package com.superSaller.beans.outsideSupportSys.Impl.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.superSaller.beans.outsideSupportSys.Impl.GoodsSupportImpl;
import com.superSaller.beans.outsideSupportSys.entities.Good;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:dispatcherServlet-servlet.xml" })
public class GoodsSupportImplTest extends AbstractJUnit4SpringContextTests {
	@Resource(name = "goodsSupport")
	private GoodsSupportImpl goodsSupport;

	@Test
	public void testGetGoodMethod() {
		Good good = goodsSupport.getGood("2119008");
		assertEquals("2119008", good.getGoodID());
		assertEquals("味全活性乳酸菌饮品（芦荟味）", good.getGoodName());
	}
}
