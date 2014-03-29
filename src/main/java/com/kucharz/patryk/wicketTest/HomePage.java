package com.kucharz.patryk.wicketTest;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;

//@AuthorizeInstantiation("ADMIN")
public class HomePage extends BasePage
{
	public HomePage()
	{
		add(new Label("label1", "Jakis tam content"));
	}
}
