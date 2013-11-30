package pl.rea.utils;

public class SessionIdUtils {

	public static String getSessionId(String login)
	{
		String sessionId=null;
		long time=System.currentTimeMillis();
		
		long loginHash = (long)login.hashCode();
		time=(long) (time*(loginHash*0.37));
		time=time-loginHash*(17-loginHash%10);
		sessionId=String.valueOf(time);
		return sessionId;
	}
	
}
