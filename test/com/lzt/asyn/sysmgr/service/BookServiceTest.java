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

import com.lzt.asyn.sysmgr.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BookServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	public BookService bookService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveOrUpdate() {
		Book b=new Book();
		b.setBookName("1234");
		b.setBookPrice(123.00);
		bookService.insert(b);
		int queryForInt = jdbcTemplate.queryForObject(
				"select count(book_id) from cw_book where book_name='1234'and book_price=123.00",
				Integer.class);
		Assert.assertTrue(queryForInt == 1);
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		bookService.delete(2);
		int queryForInt = jdbcTemplate.queryForObject(
				"select count(book_id) from cw_book where book_name='1235'and book_price=123.00",
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
