package egovframework.sym.common.helper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface ICommonService {
	public void insert (Map<String,Object> map) throws Exception;
	public void update (Map<String,Object> map) throws Exception;
	public void delete (Map<String,Object> map) throws Exception;
	public EgovMap select(Map<String,Object> map) throws Exception;
	public List<EgovMap> list(Map<String,Object> map) throws Exception;
}
