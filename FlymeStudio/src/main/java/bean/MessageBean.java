package bean;

public class MessageBean{
	/**
	 * 消息编号，最大11位
	 */
	private int id;

	/**
	 * 消息类型，1位
	 */
	private int type;

	/**
	 * 发送人电话，11位
	 */
	private int sender;

	/**
	 * 接收人电话，11位
	 */
	private int reciever;

	/**
	 * 团队编号，最大11位
	 */
	private int teamid;

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}
	
	public int getSender() {
		return sender;
	}

	public void setReciever(int reciever) {
		this.reciever = reciever;
	}
	
	public int getReciever() {
		return reciever;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	
	public int getTeamid() {
		return teamid;
	}
}
