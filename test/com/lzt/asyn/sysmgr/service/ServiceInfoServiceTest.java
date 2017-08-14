package com.lzt.asyn.sysmgr.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.lzt.asyn.sysmgr.model.ServiceInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ServiceInfoServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	public ServiceInfoService serviceInfoService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveOrUpdate() {
		ServiceInfo s=new ServiceInfo();
		
		s.setTitle("hhh");
		serviceInfoService.insert(s);
		int queryForInt = jdbcTemplate.queryForObject(
				"select count(service_id) from cw_service where title='hhh'",
				Integer.class);
		Assert.assertTrue(queryForInt == 1);
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByArgs() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByArgsCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryPage() {
		fail("Not yet implemented");
	}

}
