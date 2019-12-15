package edu.stupaysys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stupaysys.dao.BundleMapper;
import edu.stupaysys.po.Bundle;
import edu.stupaysys.po.BundleExample;
@Service("bundleService")
@Transactional
public class BundleServiceImpl implements BundleService {
	@Autowired
	private BundleMapper bundleMapper;
	@Override
	public List<Bundle> findAllBundle(BundleExample bundleExample) {
		// TODO 自动生成的方法存根
		List<Bundle> list = this.bundleMapper.selectByExample(bundleExample);
		return list;
	}
	@Override
	public int delOneBundle(Integer key) {
		int influnce_row = this.bundleMapper.deleteByPrimaryKey(key);
		return influnce_row;
	}
	@Override
	public int updateOneBundle(Bundle bundle) {
		int influnce_row = this.bundleMapper.updateByPrimaryKey(bundle);
		return influnce_row;
	}
	@Override
	public int addOneBundle(Bundle bundle) {
		int influnce_row = this.bundleMapper.insert(bundle);
		return influnce_row;
	}
	@Override
	public Bundle findBundleById(Integer key) {
		Bundle bundle = this.bundleMapper.selectByPrimaryKey(key);
		return bundle;
	}
	
	
}
