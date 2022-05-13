package com.nh2.auto.automationms;

import com.nh2.auto.automationms.service.AutomationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AutomationMsApplicationTests {

	@Test
	public void whenEmptyString_thenAccept() {
		AutomationService palindromeTester = new AutomationService();
		assertTrue(palindromeTester.isPalindrome(""));
	}
}
