package com.oynomak;

import com.oynomak.model.*;

import java.util.*;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test; 
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;//for all methods here: http://junit.org/junit4/javadoc/latest/org/junit/Assert.html

/*
 * https://garygregory.wordpress.com/2011/09/25/understaning-junit-method-order-execution/
 * https://examples.javacodegeeks.com/core-java/junit/junit-setup-teardown-example/
 */
public class TestApp1{

	private List list;

	@Before //setUp()
    public void before() throws Exception{

        list = new ArrayList<User>();

        list.add(new User(1, "Guillaine", 23, 30000));
		list.add(new User(2, "Neza", 23, 40000));
		list.add(new User(3, "Herve", 23, 30000));
		list.add(new User(4, "Richard", 23, 36000));
		list.add(new User(5, "Mugabo", 23, 39000));
		list.add(new User(6, "Kamonyo", 23, 70000));

    }

	@After //tearDown()
    public void after() throws Exception {
        System.out.println("Running: tearDown");
        list = null;
        assertNull(list);
    }

	@Test
	public void testPrintHelloWorld() {

		String myValue = "dfadsf";
		assertFalse(myValue.equals("Hello World"));
		assertNotEquals(0,3);
		assertTrue(myValue.equals("dfadsf"));

	}

	@Test
	public void testUsersListIsNotEmptyAndSize(){
		assertTrue(this.list.size() > 0);
		assertEquals(this.list.size(), 6);
	}

	@Test
	public void testUsersListIsNotNull(){
		assertNotNull(this.list);
	}

}