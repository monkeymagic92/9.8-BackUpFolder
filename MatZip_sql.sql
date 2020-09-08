CREATE TABLE t_user(
	i_user int unsigned PRIMARY KEY AUTO_INCREMENT,	-- unsigned (양수값만 저장하겠다 음수 제외)
	user_id varchar(30) NOT NULL unique,   -- nvarchar 색깔 안바뀜 하지만 적용은 됨
	user_pw varchar(70) NOT NULL,
	salt VARCHAR(30) NOT NULL,		-- salt : 비밀번호 암호화할때 사용 
	nm varchar(5) NOT NULL,			-- mysql 에서 varchar(5) 하면 영어5글자 한글 5글자임 (오라클이랑 다름)
	profile_img VARCHAR(50),
	r_dt DATETIME DEFAULT NOW(),
	m_dt DATETIME DEFAULT NOW()	
);

USE matzip;

COMMIT;
DROP TABLE t_user;

SELECT * FROM t_user;