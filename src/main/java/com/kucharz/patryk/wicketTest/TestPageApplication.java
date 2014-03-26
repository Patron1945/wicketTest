package com.kucharz.patryk.wicketTest;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.apache.wicket.jmx.Initializer;
import org.apache.wicket.protocol.http.WebApplication;

import com.kucharz.patryk.wicketTest.bean.TableData;

public class TestPageApplication extends WebApplication
{
	private MBeanServer mbs;
	private ObjectName name;
	
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class getHomePage()
	{
		return HomePage.class;
	}
	
	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		
		try
		{
			mbs = ManagementFactory.getPlatformMBeanServer(); 
			name = new ObjectName("com.kucharz.patryk.wicketTest.bean:type=TableData");
	        TableData mbean = new TableData(); 
	        mbs.registerMBean(mbean, name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
