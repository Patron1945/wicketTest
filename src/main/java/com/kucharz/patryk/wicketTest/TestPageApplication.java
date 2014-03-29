package com.kucharz.patryk.wicketTest;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.jmx.Initializer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.kucharz.patryk.wicketTest.authentication.MyAuthenticatedWebSession;
import com.kucharz.patryk.wicketTest.bean.TableData;

public class TestPageApplication extends AuthenticatedWebApplication
{
	private MBeanServer mbs;
	private ObjectName name;
	
	
	/*
	 * TO DO
	 * Dopisac autentykacje do aplikacji
	 * wicket - securedwebapplication 
	 * (auth-roles)
	 * w miedzyczasie pobrac i zbudowac projekty karaf-...
	 * zbudowac https://github.com/apache/karaf-webconsole
	 * i zaimportowac do eclipse
	 * */
	
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
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);
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

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return SignInPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return MyAuthenticatedWebSession.class;
	}
}
