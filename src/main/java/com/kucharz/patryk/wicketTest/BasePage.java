package com.kucharz.patryk.wicketTest;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;

public class BasePage extends WebPage
{
	
	public BasePage()
	{
		add(new BookmarkablePageLink("HomePage", HomePage.class));
		add(new BookmarkablePageLink("TablePage", TablePage.class));
		add(new Label("footer","Author@ Patryk Kucharz"));
	}
}
