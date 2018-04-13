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
	 * @param messageType
	 *            消息类型
	 * @param senderId
	 *            发送方编号
	 * @param receiverId
	 *            接收方编号
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	int addMessage(int messageType, int senderId, int receiverId, int teamId);

	/**
	 * 删除消息
	 * 
	 * @param messageId
	 *            消息编号
	 * @return
	 */
	int deleteMessage(int messageId);

	/**
	 * 通过编号查找消息
	 * 
	 * @param messageId
	 *            消息编号
	 * @return
	 */
	MessageVO queryMessageById(int messageId);

	/**
	 * 通过详情查找消息
	 * 
	 * @param messageType
	 *            消息类型
	 * @param senderId
	 *            发送方编号
	 * @param receiverId
	 *            接收方编号
	 * @param teamId
	 *            团队编号
	 * @return
	 */
	MessageVO queryMessageByDetail(int messageType, int senderId, int receiverId, int teamId);

	/**
	 * 查询个人消息
	 * 
	 * @param userId
	 *            用户编号
	 * @return
	 */
	List<MessageVO> queryMessages(int userId);
}
