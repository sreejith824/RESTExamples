package co.za.metropolitan.student.threadlocal;

public class ApplicationSecurityContext {
	
	 private static final ThreadLocal<String> context = new ThreadLocal<String>();
	 
	    public static void setSecurityToken(String token) {
	        context.set(token);
	    }
	 
	    public static String getSecurityToken() {
	        return context.get();
	    }
	 
	    public static void removeSecurityToken() {
	        context.remove();
	    }

}
