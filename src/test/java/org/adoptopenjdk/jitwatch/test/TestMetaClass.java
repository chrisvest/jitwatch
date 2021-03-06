/*
 * Copyright (c) 2013, 2014 Chris Newland.
 * Licensed under https://github.com/AdoptOpenJDK/jitwatch/blob/master/LICENSE-BSD
 * Instructions: https://github.com/AdoptOpenJDK/jitwatch/wiki
 */
package org.adoptopenjdk.jitwatch.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.adoptopenjdk.jitwatch.model.IMetaMember;
import org.adoptopenjdk.jitwatch.model.MemberSignatureParts;
import org.adoptopenjdk.jitwatch.model.MetaClass;
import org.adoptopenjdk.jitwatch.model.MetaConstructor;
import org.adoptopenjdk.jitwatch.model.MetaMethod;
import org.adoptopenjdk.jitwatch.model.MetaPackage;
import org.adoptopenjdk.jitwatch.util.StringUtil;
import org.junit.Test;

public class TestMetaClass
{
	//==========================
	// methods used by this test
	//==========================

	public int primitiveReturnPrimitiveParam(int foo)
	{
		return 1337;
	}

	public void voidReturnPrimitiveParam(int foo)
	{
	}

	public void voidReturnNoParams()
	{
	}

	public String objectReturnObjectParam(String foo)
	{
		return "When the daylight weighs a ton";
	}

	public String[] arrayReturnArrayParam(int[] foo)
	{
		return new String[]{"and all my friends are gone"};
	}

	// test constructor
	public TestMetaClass()
	{

	}

    @Test
    public void testGetMemberFromSignature1() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "primitiveReturnPrimitiveParam";

    	Method method = getClass().getDeclaredMethod(testMethodName, new Class[]{int.class});

    	MetaMethod testMethod = new MetaMethod(method, metaClass);

    	metaClass.addMetaMethod(testMethod);

    	String testRetType = "int";

		List<String> paramList = new ArrayList<>();
		paramList.add("int");

    	IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(), testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testMethod.toString(), result.toString());
    }

    @Test
    public void testGetMemberFromSignature2() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "voidReturnPrimitiveParam";

    	Method method = getClass().getDeclaredMethod(testMethodName, new Class[]{int.class});

    	MetaMethod testMethod = new MetaMethod(method, metaClass);

    	metaClass.addMetaMethod(testMethod);

    	String testRetType = "void";

    	List<String> paramList = new ArrayList<>();
		paramList.add("int");

    	IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(),testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testMethod.toString(), result.toString());
    }

    @Test
    public void testGetMemberFromSignature3() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "voidReturnNoParams";

    	Method method = getClass().getDeclaredMethod(testMethodName, new Class[0]);

    	MetaMethod testMethod = new MetaMethod(method, metaClass);

    	metaClass.addMetaMethod(testMethod);

    	String testRetType = "void";
		List<String> paramList = new ArrayList<>();

    	IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(),testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testMethod.toString(), result.toString());
    }

    @Test
    public void testGetMemberFromSignature4() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "objectReturnObjectParam";

    	Method method = getClass().getDeclaredMethod(testMethodName, new Class[]{java.lang.String.class});

    	MetaMethod testMethod = new MetaMethod(method, metaClass);

    	metaClass.addMetaMethod(testMethod);

    	String testRetType = "java.lang.String";

		List<String> paramList = new ArrayList<>();
		paramList.add("java.lang.String");

    	IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(),testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testMethod.toString(), result.toString());
    }

    @Test
    public void testGetMemberFromSignature5() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "arrayReturnArrayParam";

    	Method method = getClass().getDeclaredMethod(testMethodName, new Class[]{int[].class});

    	MetaMethod testMethod = new MetaMethod(method, metaClass);

    	metaClass.addMetaMethod(testMethod);

    	String testRetType = "[Ljava.lang.String;";

		List<String> paramList = new ArrayList<>();
		paramList.add("[I");

    	IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(),testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testMethod.toString(), result.toString());
    }

    @Test
    public void testGetMemberFromSignature6() throws NoSuchMethodException, SecurityException
    {
    	String thisClassName = getClass().getName();

    	MetaPackage metaPackage = new MetaPackage(StringUtil.getPackageName(thisClassName));

    	MetaClass metaClass = new MetaClass(metaPackage, StringUtil.getUnqualifiedClassName(thisClassName));

    	String testMethodName = "<init>";

    	Constructor<?> constructor = getClass().getDeclaredConstructor(new Class[0]);

    	MetaConstructor testConstructor = new MetaConstructor(constructor, metaClass);

    	metaClass.addMetaConstructor(testConstructor);

    	String testRetType = getClass().getName();
		List<String> paramList = new ArrayList<>();

		IMetaMember result = metaClass.getMemberForSignature(MemberSignatureParts.fromParts(metaClass.getFullyQualifiedName(),testMethodName, testRetType, paramList));

    	assertNotNull(result);
    	assertEquals(testConstructor.toString(), result.toString());
    }
}