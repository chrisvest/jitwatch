/*
 * Copyright (c) 2013, 2014 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.core;

import org.adoptopenjdk.jitwatch.model.JITEvent;

public interface IJITListener extends IMainLogListener
{
	void handleJITEvent(JITEvent event);
	void handleReadStart();
	void handleReadComplete();
}