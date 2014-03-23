package com.kucharz.patryk.wicketTest;

import org.apache.wicket.protocol.http.WebApplication;

public class TestPageApplication extends WebApplication
{

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

		// add your configuration here
	}
}
