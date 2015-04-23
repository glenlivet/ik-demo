package org.ikgroup.test.service;

import org.ikgroup.test.listener.ServiceTestExecutionListener;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
@TestExecutionListeners({ServiceTestExecutionListener.class})
public abstract class AbstractServiceImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {

}
