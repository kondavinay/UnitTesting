package com.rabo.statementprocessor1.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.rabo.statementprocessor.validation.EndBalanceValidation;

public class TestValidator{
String records[] ={"100,richard,docker,1.0,1.0,2.0","200,john,deacvf,1.7,2.5,9.0"};
ArrayList<String> validFailList = new ArrayList<String>();

@Before
public void setUp(){
	
	validFailList.add("\nRecord\nTransaction Reference : "+200+"\nAccount Number : "+"john"+"\nDescription : "+"deacvf"+"\nStart Balance : "+1.7+"\nMutation : "+2.5+"\nEnd Balance : "+9.0);
}

@Test
public void testValidator() throws IOException 
{
	assertEquals(validFailList,EndBalanceValidation.details(records));
}

}