
DROP TABLE IF EXISTS  tn_pgusr;
drop table if exists  tn_res_survey;
DROP TABLE IF EXISTS  tn_question_obj;
DROP TABLE IF EXISTS  tn_question_mt;
DROP TABLE IF EXISTS  tn_survey_mt;

-- 사용자 테이블 --

CREATE or REPLACE TABLE  tn_pgusr (
	usr_id varchar(100) NOT NULL,
	usr_pwd varchar(255) NOT NULL,
	usr_role varchar(100) NULL,
	usr_team varchar(100) null,
	usr_postion varchar(100) null,
	reg_dt timestamp NOT NULL DEFAULT current_timestamp,
	mod_dt timestamp NOT NULL DEFAULT current_timestamp,
	recent_dt timestamp null,
	CONSTRAINT tn_pgusr_pk PRIMARY KEY (usr_id)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_pgusr IS '사용자테이블' ;
comment on column  tn_pgusr.usr_id is '사용자아이디';
comment on column  tn_pgusr.usr_pwd is '비밀번호';
comment on column  tn_pgusr.usr_role is '권한';
comment on column  tn_pgusr.reg_dt is '등록날짜';
comment on column  tn_pgusr.mod_dt is '수정날짜';
comment on column  tn_pgusr.recent_dt is '최근접속날짜';


commit;

-- 설문지 관리테이블

CREATE TABLE  tn_survey_mt (
	survey_mt_id bigint NOT NULL,
	survey_categryid bigint NULL,
	survey_tmplt_id bigint NULL,
	survey_mt_nm varchar(100) NULL,
	reg_dt timestamp NOT NULL,
	mod_dt timestamp NOT NULL,
	published_dt timestamp NOT NULL,
	expired_dt timestamp NOT NULL,
	CONSTRAINT tn_survey_mt_pk PRIMARY KEY (survey_mt_id)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_survey_mt IS '설문지 관리테이블' ;
comment on column  tn_survey_mt.survey_mt_id is '설문지관리아이디';
comment on column  tn_survey_mt.survey_categryid is '설문지카테고리아이디';
comment on column  tn_survey_mt.survey_mt_nm is '설문지이름';
comment on column  tn_survey_mt.survey_tmplt_id is '설문지팀플릿아이디';
comment on column  tn_survey_mt.reg_dt is '등록날짜';
comment on column  tn_survey_mt.mod_dt is '수정날짜';
comment on column  tn_survey_mt.published_dt is '게시날짜';
comment on column  tn_survey_mt.expired_dt is '만료날짜';

commit;


-- 설문지문항관리테이블
CREATE TABLE  tn_question_mt (
	question_id bigint NOT NULL,
	question_title varchar(255) NOT NULL,
	survey_mt_id bigint NOT NULL,
	question_order numeric NOT NULL,
	next_step bigint NULL,
	is_obj varchar(1) not null,
	CONSTRAINT tn_question_mt_pk PRIMARY KEY (question_id)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_question_mt IS '설문지문항관리테이블' ;
comment on column  tn_question_mt.question_id is '설문지문항관리아이디';
comment on column  tn_question_mt.question_title is '문항제목';
comment on column  tn_question_mt.survey_mt_id is '설문지관리아이디';
comment on column  tn_question_mt.question_order is '설문지문항순서';
comment on column  tn_question_mt.next_step is '다음문항';

commit;

-- 설문지문항객관식테이블
CREATE TABLE  tn_question_obj (
	obj_num numeric NOT NULL,
	obj_content varchar(255) NOT NULL,
	question_id bigint NOT NULL,
	CONSTRAINT tn_question_obj_pk PRIMARY KEY (obj_num)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_question_obj IS '설문지문항객관식테이블' ;
comment on column  tn_question_obj.obj_num is '객관식번호';
comment on column  tn_question_obj.obj_content is '객관식내용';

commit;


-- 설문지응답테이블

CREATE TABLE  tn_res_survey (
	res_id bigint NOT NULL,
	usr_id varchar NULL,
	survey_mt_id bigint NOT NULL,
	question_id bigint NOT NULL,
	obj_num bigint NULL,
	subject_res varchar NULL,
	subject_emotion numeric NULL,
	reg_dt timestamp NOT NULL,
	CONSTRAINT tn_res_survey_pk PRIMARY KEY (res_id)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_res_survey IS '설문지응답테이블' ;
comment on column  tn_res_survey.res_id is '설문응답아이디';
comment on column  tn_res_survey.usr_id is '응답사용자아이디';
comment on column  tn_res_survey.survey_mt_id is '응답설문지아이디';
comment on column  tn_res_survey.question_id is '응답문항아이디';
comment on column  tn_res_survey.obj_num is '응답객관식아이디';
comment on column  tn_res_survey.subject_res is '응답주관식값';
comment on column  tn_res_survey.subject_emotion is '응답주관식이모션';

commit;