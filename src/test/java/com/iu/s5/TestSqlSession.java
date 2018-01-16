package com.iu.s5;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestSqlSession extends AbstractTest {
	
	@Inject
	private SqlSession sqlsession;

	@Test
	public void test() {
		assertNotNull(sqlsession);
	}

}
