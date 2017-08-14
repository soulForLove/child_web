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

import com.lzt.asyn.sysmgr.model.Adver;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AdverServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	public AdverService adverService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveOrUpdate() {
		Adver a=new Adver();
		a.setBookId(21l);
		a.setLink("www.baidu.com");
		a.setTitle("test");
		adverService.saveOrUpdate(a);
		int queryForInt = jdbcTemplate.queryForObject(
				"select count(adver_id) from cw_adver where title='test'",
				Integer.class);
		Assert.assertTrue(queryForInt == 1);
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		adverService.delete(2);
		int queryForInt = jdbcTemplate.queryForObject(
				"select count(adver_id) from cw_adver where title='test'",
				Integer.class);
		Assert.assertTrue(queryForInt == 0);
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
