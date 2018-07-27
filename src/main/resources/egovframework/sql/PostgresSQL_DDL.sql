
DROP TABLE IF EXISTS  tn_pgusr;
drop table if exists  tn_res_survey;
DROP TABLE IF EXISTS  tn_question_obj;
DROP TABLE IF EXISTS  tn_question_mt;
DROP TABLE IF EXISTS  tn_survey_mt;

-- ����� ���̺� --

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
comment ON TABLE  tn_pgusr IS '��������̺�' ;
comment on column  tn_pgusr.usr_id is '����ھ��̵�';
comment on column  tn_pgusr.usr_pwd is '��й�ȣ';
comment on column  tn_pgusr.usr_role is '����';
comment on column  tn_pgusr.reg_dt is '��ϳ�¥';
comment on column  tn_pgusr.mod_dt is '������¥';
comment on column  tn_pgusr.recent_dt is '�ֱ����ӳ�¥';


commit;

-- ������ �������̺�

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
comment ON TABLE  tn_survey_mt IS '������ �������̺�' ;
comment on column  tn_survey_mt.survey_mt_id is '�������������̵�';
comment on column  tn_survey_mt.survey_categryid is '������ī�װ����̵�';
comment on column  tn_survey_mt.survey_mt_nm is '�������̸�';
comment on column  tn_survey_mt.survey_tmplt_id is '���������ø����̵�';
comment on column  tn_survey_mt.reg_dt is '��ϳ�¥';
comment on column  tn_survey_mt.mod_dt is '������¥';
comment on column  tn_survey_mt.published_dt is '�Խó�¥';
comment on column  tn_survey_mt.expired_dt is '���ᳯ¥';

commit;


-- ���������װ������̺�
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
comment ON TABLE  tn_question_mt IS '���������װ������̺�' ;
comment on column  tn_question_mt.question_id is '���������װ������̵�';
comment on column  tn_question_mt.question_title is '��������';
comment on column  tn_question_mt.survey_mt_id is '�������������̵�';
comment on column  tn_question_mt.question_order is '���������׼���';
comment on column  tn_question_mt.next_step is '��������';

commit;

-- ���������װ��������̺�
CREATE TABLE  tn_question_obj (
	obj_num numeric NOT NULL,
	obj_content varchar(255) NOT NULL,
	question_id bigint NOT NULL,
	CONSTRAINT tn_question_obj_pk PRIMARY KEY (obj_num)
)
WITH (
	OIDS=FALSE
) ;
comment ON TABLE  tn_question_obj IS '���������װ��������̺�' ;
comment on column  tn_question_obj.obj_num is '�����Ĺ�ȣ';
comment on column  tn_question_obj.obj_content is '�����ĳ���';

commit;


-- �������������̺�

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
comment ON TABLE  tn_res_survey IS '�������������̺�' ;
comment on column  tn_res_survey.res_id is '����������̵�';
comment on column  tn_res_survey.usr_id is '�������ھ��̵�';
comment on column  tn_res_survey.survey_mt_id is '���伳�������̵�';
comment on column  tn_res_survey.question_id is '���乮�׾��̵�';
comment on column  tn_res_survey.obj_num is '���䰴���ľ��̵�';
comment on column  tn_res_survey.subject_res is '�����ְ��İ�';
comment on column  tn_res_survey.subject_emotion is '�����ְ����̸��';

commit;