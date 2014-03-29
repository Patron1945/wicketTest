package com.kucharz.patryk.wicketTest;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SignOutPage extends BasePage
{
	  public SignOutPage(final PageParameters parameters)
	  {
	        getSession().invalidate();
	  }
}
