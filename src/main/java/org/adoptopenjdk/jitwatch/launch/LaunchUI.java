/*
 * Copyright (c) 2013, 2014 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.launch;

import org.adoptopenjdk.jitwatch.ui.JITWatchUI;

public final class LaunchUI
{
	private LaunchUI()
	{
	}

	public static void main(String[] args)
	{
		new JITWatchUI(args);
	}
}