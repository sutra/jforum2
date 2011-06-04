package net.jforum.sso;

import net.jforum.context.RequestContext;
import net.jforum.context.SessionContext;
import net.jforum.sso.RemoteUserSSO;

/**
 * Keep the remote user in the session.
 * 
 * @author Sutra Zhou
 */
public class SessionRemoteUserSSO extends RemoteUserSSO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String authenticateUser(RequestContext request) {
		String remoteUser = super.authenticateUser(request);
		SessionContext session = request.getSessionContext();
		String attributeName = this.getClass().getName();
		if (remoteUser == null) {
			remoteUser = (String) session.getAttribute(attributeName);
		} else {
			session.setAttribute(attributeName, remoteUser);
		}
		return remoteUser;
	}

}
