package egovframework.survey.comn.util;

import java.util.Map;

public interface ISurveyCommonService {
	public void insert (Map<String,Object> map) throws Exception;
	public void update (Map<String,Object> map) throws Exception;
	public void delete (Map<String,Object> map) throws Exception;
	public Map<String,Object> select (Map<String,Object> map) throws Exception;
}
