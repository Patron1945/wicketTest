package com.kucharz.patryk.wicketTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

import com.kucharz.patryk.wicketTest.bean.TableData;
import com.kucharz.patryk.wicketTest.bean.TableDataMBean;


@AuthorizeInstantiation("ADMIN")
public class TablePage extends BasePage
{
	public TablePage()
	{
		try
		{
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi");
			JMXConnector connector = JMXConnectorFactory.connect(url, null);
			connector.connect();
			MBeanServerConnection connection = connector.getMBeanServerConnection();
			ObjectName objectName = new ObjectName("com.kucharz.patryk.wicketTest.bean:type=TableData");
			TableDataMBean mbean = JMX.newMBeanProxy(connection, objectName, TableDataMBean.class);
			
			List<int[]> table = Arrays.asList(mbean.getTableValues());
			ListView<int[]> repeatingView = new ListView<int[]>("row", Model.ofList(table)) {

				@Override
				protected void populateItem(ListItem<int[]> arg0)
				{
					int[] row = arg0.getModel().getObject();
					RepeatingView cells = new RepeatingView("cell");
					cells.add(new Label(cells.newChildId(), row[0]));
					cells.add(new Label(cells.newChildId(), row[1]));
					cells.add(new Label(cells.newChildId(), row[2]));
					cells.add(new Label(cells.newChildId(), row[3]));
					arg0.add(cells);
				}
			};
			add(repeatingView);
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedObjectNameException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 1# implementacja tabeli dynamicznej
	 * 2# wrzucenie danych z TableData do tabeli dynamicznej -> jak to zrobic?
	 * 
	 */
}
