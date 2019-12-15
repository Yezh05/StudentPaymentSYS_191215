package edu.stupaysys.service;

import java.util.List;

import edu.stupaysys.po.Bundle;
import edu.stupaysys.po.BundleExample;

public interface BundleService {
	public List<Bundle> findAllBundle(BundleExample bundleExample);
	public int delOneBundle(Integer key) ;
	public int updateOneBundle(Bundle bundle);
	public int addOneBundle(Bundle bundle);
	public Bundle findBundleById(Integer key);
}
