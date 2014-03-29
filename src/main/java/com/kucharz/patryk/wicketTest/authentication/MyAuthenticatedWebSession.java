package com.kucharz.patryk.wicketTest.authentication;

import java.util.HashMap;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class MyAuthenticatedWebSession extends AuthenticatedWebSession
{

	private Boolean isAdmin = false;
	
	HashMap<String,String> adminUsers = new HashMap<String, String>();
	
	public MyAuthenticatedWebSession(Request request)
	{
		super(request);
		adminUsers.put("admin", "admin");
		adminUsers.put("user", "user");
	}

	@Override
	public boolean authenticate(final String username, final String password)
	{
		if(adminUsers.get(username).equals(password))
		{
			return true;
		}

		return false;
	}

	@Override
	public Roles getRoles()
	{

		if (isSignedIn())
        {
            return new Roles(Roles.ADMIN);
        }
		
        return null;
	}

}
