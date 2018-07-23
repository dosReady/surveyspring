package egovframework.survey.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.survey.main.dao.MainDAO;

@Service("mainService")
public class MainService implements IMainService {
	
	
	@Autowired
	public MainDAO mainMapper;
	
	@Override
	public String selectNow() {
		String now = mainMapper.now();
		return now;
	}

}
