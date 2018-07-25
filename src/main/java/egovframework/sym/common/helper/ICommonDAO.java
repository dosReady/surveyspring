package egovframework.sym.common.helper;

import java.util.Map;

public interface ICommonDAO {
	public void insert (Map<String,Object> map) throws Exception;
	public void update (Map<String,Object> map) throws Exception;
	public void delete (Map<String,Object> map) throws Exception;
	public Map<String,Object> select (Map<String,Object> map) throws Exception;
}
