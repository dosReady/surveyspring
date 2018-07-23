package egovframework.survey.main.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.survey.comn.util.ISurveyCommonDAO;

@Mapper("egovframework.survey.main.dao.MainDao")
public interface MainDAO extends ISurveyCommonDAO {
	
	public String now();

}
