INSERT INTO TN_SRV_USER(USER_ID, USER_PWD, USER_ROLE, USER_TEAM, USER_PSTN) VALUES('admin', 'admin', 'ROEL_USER', NULL, NULL );
INSERT INTO ACTION_MAPPING (ACTION_ID,CLASS_NM,CLASS_METHOD,PAGE_NM,ACTION_TYPE,INST_DT) VALUES 
('/action/management/test.do','egovframework.srv.management.controller.ManagementController','test','null','RB','2018-07-26 17:10:20.000')
,('/survey/management/goRegForm.do','egovframework.srv.management.controller.ManagementController','regForm','/srv/management/regForm','N','2018-07-26 17:10:20.000')
,('/survey/management/goWorkspace.do','egovframework.srv.management.controller.ManagementController','goWorkspace','/srv/management/workspace','N','2018-07-26 16:02:28.000')
,('/survey/management/list.do','egovframework.srv.management.controller.ManagementController','list','/srv/management/list','N','2018-07-26 17:10:20.000')
,('/survey/view.do','egovframework.srv.index.controller.IndexController','view','/srv/main/view','N','2018-07-26 16:02:28.000');

