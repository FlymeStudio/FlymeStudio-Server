package bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBean {
	/**
	 * 消息编号，最大11位
	 */
	@Autowired
	private int id;

	/**
	 * 消息类型，1位
	 */
	@Autowired
	private int type;

	/**
	 * 发送人电话，11位
	 */
	@Autowired
	private int sender;

	/**
	 * 接收人电话，11位
	 */
	@Autowired
	private int reciever;

	/**
	 * 团队编号，最大11位
	 */
	@Autowired
	private int teamid;

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public int getSender() {
		return sender;
	}

	public int getReciever() {
		return reciever;
	}

	public int getTeamid() {
		return teamid;
	}
}
