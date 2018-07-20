package egovframework.survey.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.survey.main.dao.MainDao;

@Service("mainService")
public class MainServiceimpl implements MainService {
	
	
	@Autowired
	public MainDao mainMapper;
	
	@Override
	public String selectNow() {
		String now = mainMapper.now();
		return now;
	}

}
