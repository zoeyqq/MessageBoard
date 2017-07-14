package po;

import java.util.Map;

public class Message {

	private String username;
	private String message;
	private String indate;
	
	public Message(Map<String, Object> map) {
		
		this.username=(String) map.get("username");
		this.message=(String) map.get("message");
		this.indate=(String) map.get("indate");
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [username=" + username + ", message=" + message + ", indate=" + indate + "]";
	}
	
	
}
