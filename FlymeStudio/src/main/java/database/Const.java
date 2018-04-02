package database;

public final class Const {
	public static class User {
		public final static String TABLE_NAME = "user";
		public final static String COLUMN_TEL = "tel";
		public final static String COLUMN_NAME = "name";
		public final static String COLUMN_EMAIL = "email";
		public final static String COLUMN_PASSWORD = "password";
		public final static String COLUMN_MESSAGES = "messages";
	}

	public static class Message {
		public final static String TABLE_NAME = "message";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_TYPE = "type";
		public final static String COLUMN_SENDER = "sender";
		public final static String COLUMN_RECEIVER = "receiver";
		public final static String COLUMN_TEAM_ID = "teamid";
	}

	public static class Project {
		public final static String TABLE_NAME = "project";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_TEL = "tel";
		public final static String COLUMN_TYPE = "type";
		public final static String COLUMN_DATE = "date";
		public final static String COLUMN_TITLE = "title";
		public final static String COLUMN_CONTENT = "content";
		public final static String COLUMN_PLANS = "plans";
	}

	public static class Team {
		public final static String TABLE_NAME = "team";
		public final static String COLUMN_ID = "id";
		public final static String COLUMN_NAME = "name";
		public final static String COLUMN_TEL = "tel";
		public final static String COLUMN_MEMBERS = "members";
	}
}
