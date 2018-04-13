package com.zengyu.demo.others;

/**
 * 数据库字段常量
 * 
 * @author zengyu
 *
 */
public final class Const {
	public static class User {
		public final static String TABLE_NAME = "user";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_NUM = "num";
		public final static String COLUMN_TEL = "tel";
		public final static String COLUMN_NAME = "name";
		public final static String COLUMN_EMAIL = "email";
		public final static String COLUMN_PASSWORD = "password";
		public final static String COLUMN_MESSAGES = "messages";
		public final static String COLUMN_TEAMS = "teams";
	}

	public static class Message {
		public final static String TABLE_NAME = "message";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_TYPE = "type";
		public final static String COLUMN_SENDER_ID = "sender_id";
		public final static String COLUMN_RECEIVER_ID = "receiver_id";
		public final static String COLUMN_TEAM_ID = "team_id";
	}

	public static class Project {
		public final static String TABLE_NAME = "project";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_USER_ID = "user_id";
		public final static String COLUMN_TYPE = "type";
		public final static String COLUMN_DATE = "date";
		public final static String COLUMN_TITLE = "title";
		public final static String COLUMN_CONTENT = "content";
		public final static String COLUMN_PLANS = "plans";
	}

	public static class Summary {
		public final static String TABLE_NAME = "summary";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_USER_ID = "user_id";
		public final static String COLUMN_TYPE = "type";
		public final static String COLUMN_DATE = "date";
		public final static String COLUMN_TITLE = "title";
		public final static String COLUMN_CONTENT = "content";
	}

	public static class Team {
		public final static String TABLE_NAME = "team";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_NAME = "name";
		public final static String COLUMN_USER_ID = "user_id";
		public final static String COLUMN_MEMBERS = "members";
	}
}
