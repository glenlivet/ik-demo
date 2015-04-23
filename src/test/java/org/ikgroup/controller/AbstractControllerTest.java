package org.ikgroup.controller;

import org.ikgroup.test.config.ControllerTestConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ControllerTestConfig.class})
@ActiveProfiles("test")
public class AbstractControllerTest {
	
}
