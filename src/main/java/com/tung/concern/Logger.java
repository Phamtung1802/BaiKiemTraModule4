package com.tung.concern;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[Tung] ERROR!");
    }
}
