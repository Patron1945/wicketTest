package com.kucharz.patryk.wicketTest;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class HomePage extends BasePage
{
	public HomePage()
	{
		add(new Label("label1", "Jakis tam content"));
	}
}
