package com.kucharz.patryk.wicketTest;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SignInPage extends BasePage
{
	public SignInPage()
	{
		this(null);
	}

	public SignInPage(final PageParameters parameters)
	{
		add(new SignInPanel("signInPanel"));
	}
}
