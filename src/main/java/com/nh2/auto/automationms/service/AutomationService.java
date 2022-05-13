package com.nh2.auto.automationms.service;

import org.springframework.stereotype.Service;

@Service
public class AutomationService {
    public boolean isPalindrome(String inputString) {
        System.out.println("Test");
        if (inputString.length() == 0) {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }
}
