package egovframework.srv.index.dao;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.sym.common.helper.ICommonDAO;

@Mapper("egovframework.srv.index.dao.MainDAO")
public interface IndexDAO extends ICommonDAO {
	
	public String now();

}
