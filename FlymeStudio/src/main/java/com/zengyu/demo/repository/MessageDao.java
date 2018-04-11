package com.zengyu.demo.repository;

import java.util.List;

import com.zengyu.demo.model.MessageVO;

/**
 * 消息访问层接口
 * 
 * @author zengyu
 *
 */
public interface MessageDao {
	/**
	 * 添加消息
	 * 
	 * @param type
	 *            消息类型
	 * @param sender
	 *            发送方
	 * @param receiver
	 *            接收方
	 * @param teamid
	 *            团队编号
	 * @return
	 */
	int addMessage(int type, String sender, String receiver, int teamid);

	/**
	 * 删除消息
	 * 
	 * @param id
	 *            消息编号
	 * @return
	 */
	int deleteMessage(int id);

	/**
	 * 通过编号查找消息
	 * 
	 * @param id
	 *            消息编号
	 * @return
	 */
	MessageVO queryMessageById(int id);

	/**
	 * 通过详情查找消息
	 * 
	 * @param type
	 *            消息类型
	 * @param sender
	 *            发送方
	 * @param receiver
	 *            接收方
	 * @param teamid
	 *            团队编号
	 * @return
	 */
	MessageVO queryMessageByDetail(int type, String sender, String receiver, int teamid);

	/**
	 * 查询个人消息
	 * 
	 * @param tel
	 *            电话
	 * @return
	 */
	List<MessageVO> queryMessages(String tel);
}
