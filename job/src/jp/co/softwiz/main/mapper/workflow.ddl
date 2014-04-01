DROP TABLE IF EXISTS T_SAMPLE_INFO;
DROP TABLE IF EXISTS T_REQ_ADM_FLOW_INFO;
DROP TABLE IF EXISTS T_FILE_INFO;
DROP TABLE IF EXISTS T_TEMPLATE_INFO;
DROP TABLE IF EXISTS T_CATE_SUB;
DROP TABLE IF EXISTS T_CATE_MAIN;
DROP TABLE IF EXISTS T_ADM_HIST_INFO;
DROP TABLE IF EXISTS T_USER_DEPT_INFO;
DROP TABLE IF EXISTS T_DEPT_INFO;
DROP TABLE IF EXISTS T_ADM_FLOW_INFO;
DROP TABLE IF EXISTS T_ADM_FLOW_MASTER_INFO;
DROP TABLE IF EXISTS T_ADM_SET_INFO;
DROP TABLE IF EXISTS T_LOGIN_HIST;
DROP TABLE IF EXISTS T_LOGIN_INFO;
DROP TABLE IF EXISTS T_USER_INFO;

/**********************************/
/* テーブル名: ユーザ情報 */
/**********************************/
CREATE TABLE T_USER_INFO(
		userCode VARCHAR(50) NOT NULL,
		userName VARCHAR(100),
		userNameKana VARCHAR(200),
		birthday VARCHAR(8),
		gender CHARACTER(1),
		zipCode VARCHAR(8),
		address VARCHAR(500),
		nearStation VARCHAR(100),
		telnum VARCHAR(14),
		celPhone VARCHAR(14),
		mailAddress VARCHAR(200),
		etcDesc VARCHAR(300),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30),
		apprImageUrl VARCHAR(200)
);

/**********************************/
/* テーブル名: ログイン情報 */
/**********************************/
CREATE TABLE T_LOGIN_INFO(
		userId VARCHAR(20) NOT NULL,
		userCode VARCHAR(50),
		password VARCHAR(20) NOT NULL,
		roles VARCHAR(100),
		userRegDay VARCHAR(8),
		sessionId VARCHAR(50),
		connectIp VARCHAR(30),
		connectDate TIMESTAMP,
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: ログイン履歴情報 */
/**********************************/
CREATE TABLE T_LOGIN_HIST(
		loginNo SERIAL,
		userId VARCHAR(20) NOT NULL,
		roles VARCHAR(100),
		yearMonthDay VARCHAR(8),
		loginDiv CHARACTER(1),
		flagSuccess CHARACTER(1),
		sessionId VARCHAR(50),
		connectIp VARCHAR(30),
		createDate TIMESTAMP
);

/**********************************/
/* テーブル名: 承認設定情報 */
/**********************************/
CREATE TABLE T_ADM_SET_INFO(
		admSetNum SERIAL,
		admWidth VARCHAR(5),
		printDiv CHARACTER(1),
		tableCheck CHARACTER(1),
		userTableName VARCHAR(200),
		idColumnName VARCHAR(200),
		nameColumnName VARCHAR(200),
		userNameViewDiv CHARACTER(1),
		dayViewDiv CHARACTER(1),
		fileDiv CHARACTER(1),
		mailSendDiv CHARACTER(1),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 承認フローマスタ情報 */
/**********************************/
CREATE TABLE T_ADM_FLOW_MASTER_INFO(
		admFlowCode SERIAL,
		admFlowName VARCHAR(100),
		userCode VARCHAR(50),
		comment VARCHAR(200),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 承認フロー情報 */
/**********************************/
CREATE TABLE T_ADM_FLOW_INFO(
		admFlowCode INTEGER NOT NULL,
		userCode VARCHAR(50),
		orderSeq INTEGER NOT NULL,
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 部門情報 */
/**********************************/
CREATE TABLE T_DEPT_INFO(
		deptCode VARCHAR(100) NOT NULL,
		deptStartDay VARCHAR(8),
		deptExpireDay VARCHAR(8),
		deptName VARCHAR(100),
		orgLevel CHARACTER(1),
		superDeptCode VARCHAR(100),
		superDeptStartDay VARCHAR(8),
		topLevelDeptCode VARCHAR(100),
		topLevelDeptStartDay VARCHAR(8),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: ユーザ部門情報 */
/**********************************/
CREATE TABLE T_USER_DEPT_INFO(
		userCode VARCHAR(50),
		deptCode CHARACTER(6) NOT NULL,
		deptStartDay VARCHAR(8),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 承認情報 */
/**********************************/
CREATE TABLE T_ADM_HIST_INFO(
		reqNo VARCHAR(50) NOT NULL,
		orderSeq INTEGER NOT NULL,
		yearMonthDay VARCHAR(8),
		pageId VARCHAR(50),
		userCode VARCHAR(50),
		returnUrl VARCHAR(200),
		keyNo VARCHAR(100),
		admFlowCode INTEGER,
		preGroupCode CHARACTER(6),
		preUserCode VARCHAR(50),
		admProcStatus CHARACTER(1) NOT NULL,
		reqReportNo BIGINT,
		message VARCHAR(200),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 共通項目大分類 */
/**********************************/
CREATE TABLE T_CATE_MAIN(
		mainCode CHARACTER(3) NOT NULL,
		mainName VARCHAR(100),
		useDiv CHARACTER(1) NOT NULL,
		etcDesc VARCHAR(300),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 共通項目中分類 */
/**********************************/
CREATE TABLE T_CATE_SUB(
		mainCode CHARACTER(3) NOT NULL,
		subCode CHARACTER(3) NOT NULL,
		subName VARCHAR(100),
		subValue VARCHAR(100),
		subValue2 VARCHAR(100),
		subValue3 VARCHAR(100),
		viewOrder INTEGER NOT NULL,
		useDiv CHARACTER(1) NOT NULL,
		etcDesc VARCHAR(300),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 案件情報 */
/**********************************/
CREATE TABLE T_TEMPLATE_INFO(
		temNo VARCHAR(50) NOT NULL,
		temname VARCHAR(200),
		yearMonthDay VARCHAR(8),
		userCode VARCHAR(50),
		filePath VARCHAR(200),
		detailContent TEXT,
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 添付ファイル */
/**********************************/
CREATE TABLE T_FILE_INFO(
		fileNo VARCHAR(50) NOT NULL,
		temNo VARCHAR(50),
		yearMonthDay CHARACTER(8),
		filePath VARCHAR(200),
		filename VARCHAR(100),
		preFileName VARCHAR(100),
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: 依頼別承認情報 */
/**********************************/
CREATE TABLE T_REQ_ADM_FLOW_INFO(
		temno VARCHAR(50),
		orderSeq INTEGER NOT NULL,
		reqNo VARCHAR(50),
		userCode VARCHAR(50),
		admFlowCode INTEGER,
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);

/**********************************/
/* テーブル名: サンプル情報 */
/**********************************/
CREATE TABLE T_SAMPLE_INFO(
		sampleNo VARCHAR(50) NOT NULL,
		sampleName VARCHAR(100),
		yearMonthDay VARCHAR(8),
		detailContent TEXT,
		createDate TIMESTAMP,
		createUser VARCHAR(30),
		modifyDate TIMESTAMP,
		modifyUser VARCHAR(30),
		deleteFlag CHARACTER(1),
		deleteDate TIMESTAMP,
		deleteUser VARCHAR(30)
);


ALTER TABLE T_USER_INFO ADD CONSTRAINT IDX_T_USER_INFO_PK PRIMARY KEY (userCode);

ALTER TABLE T_LOGIN_INFO ADD CONSTRAINT IDX_T_LOGIN_INFO_PK PRIMARY KEY (userId);
ALTER TABLE T_LOGIN_INFO ADD CONSTRAINT IDX_T_LOGIN_INFO_FK0 FOREIGN KEY (userCode) REFERENCES T_USER_INFO (userCode);

ALTER TABLE T_LOGIN_HIST ADD CONSTRAINT IDX_T_LOGIN_HIST_PK PRIMARY KEY (loginNo);
ALTER TABLE T_LOGIN_HIST ADD CONSTRAINT IDX_T_LOGIN_HIST_FK0 FOREIGN KEY (userId) REFERENCES T_LOGIN_INFO (userId);

ALTER TABLE T_ADM_SET_INFO ADD CONSTRAINT IDX_T_ADM_SET_INFO_PK PRIMARY KEY (admSetNum);

ALTER TABLE T_ADM_FLOW_MASTER_INFO ADD CONSTRAINT IDX_T_ADM_FLOW_MASTER_INFO_PK PRIMARY KEY (admFlowCode);
ALTER TABLE T_ADM_FLOW_MASTER_INFO ADD CONSTRAINT IDX_T_ADM_FLOW_MASTER_INFO_FK0 FOREIGN KEY (userCode) REFERENCES T_USER_INFO (userCode);

ALTER TABLE T_ADM_FLOW_INFO ADD CONSTRAINT IDX_T_ADM_FLOW_INFO_PK PRIMARY KEY (admFlowCode, userCode, orderSeq);
ALTER TABLE T_ADM_FLOW_INFO ADD CONSTRAINT IDX_T_ADM_FLOW_INFO_FK0 FOREIGN KEY (admFlowCode) REFERENCES T_ADM_FLOW_MASTER_INFO (admFlowCode);
ALTER TABLE T_ADM_FLOW_INFO ADD CONSTRAINT IDX_T_ADM_FLOW_INFO_FK1 FOREIGN KEY (userCode) REFERENCES T_USER_INFO (userCode);

ALTER TABLE T_DEPT_INFO ADD CONSTRAINT IDX_T_DEPT_INFO_PK PRIMARY KEY (deptCode, deptStartDay);

ALTER TABLE T_USER_DEPT_INFO ADD CONSTRAINT IDX_T_USER_DEPT_INFO_PK PRIMARY KEY (userCode, deptCode, deptStartDay);
ALTER TABLE T_USER_DEPT_INFO ADD CONSTRAINT IDX_T_USER_DEPT_INFO_FK0 FOREIGN KEY (deptCode,deptStartDay) REFERENCES T_DEPT_INFO (deptCode,deptStartDay);

ALTER TABLE T_ADM_HIST_INFO ADD CONSTRAINT IDX_T_ADM_HIST_INFO_PK PRIMARY KEY (reqNo, orderSeq);
ALTER TABLE T_ADM_HIST_INFO ADD CONSTRAINT IDX_T_ADM_HIST_INFO_FK0 FOREIGN KEY (admFlowCode,userCode,orderSeq) REFERENCES T_ADM_FLOW_INFO (admFlowCode,userCode,orderSeq);

ALTER TABLE T_CATE_MAIN ADD CONSTRAINT IDX_T_CATE_MAIN_PK PRIMARY KEY (mainCode);

ALTER TABLE T_CATE_SUB ADD CONSTRAINT IDX_T_CATE_SUB_PK PRIMARY KEY (mainCode, subCode);
ALTER TABLE T_CATE_SUB ADD CONSTRAINT IDX_T_CATE_SUB_FK0 FOREIGN KEY (mainCode) REFERENCES T_CATE_MAIN (mainCode);

ALTER TABLE T_TEMPLATE_INFO ADD CONSTRAINT IDX_T_TEMPLATE_INFO_PK PRIMARY KEY (temNo);

ALTER TABLE T_FILE_INFO ADD CONSTRAINT IDX_T_FILE_INFO_PK PRIMARY KEY (fileNo);
ALTER TABLE T_FILE_INFO ADD CONSTRAINT IDX_T_FILE_INFO_FK0 FOREIGN KEY (temNo) REFERENCES T_TEMPLATE_INFO (temNo);

ALTER TABLE T_REQ_ADM_FLOW_INFO ADD CONSTRAINT IDX_T_REQ_ADM_FLOW_INFO_PK PRIMARY KEY (temno, orderSeq);

ALTER TABLE T_SAMPLE_INFO ADD CONSTRAINT IDX_T_SAMPLE_INFO_PK PRIMARY KEY (sampleNo);

