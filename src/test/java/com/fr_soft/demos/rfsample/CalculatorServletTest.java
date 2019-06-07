package com.fr_soft.demos.rfsample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CalculatorServletTest {

	private CalculatorServlet servlet = new CalculatorServlet();

	@Test
	public void test_doGetShouldReturnsNoArgsAndResult() throws IOException, ServletException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		this.servlet.doGet(request, response);

		assertNull(request.getAttribute("arg1"));
		assertNull(request.getAttribute("arg2"));
		assertNull(request.getAttribute("result"));
	}

	@Test
	public void test_doPostReturnsErrorMessageIfArg1IsNotNumber() throws IOException, ServletException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("arg1", "XYZ");
		request.addParameter("arg2", "100");

		this.servlet.doPost(request, response);

		assertEquals("XYZ", request.getAttribute("arg1"));
		assertEquals("100", request.getAttribute("arg2"));
		assertEquals("N/A", request.getAttribute("result"));
	}

	@Test
	public void test_doPostReturnsErrorMessageIfArg2IsNotNumber() throws IOException, ServletException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("arg1", "ABC");
		request.addParameter("arg2", "200");

		this.servlet.doPost(request, response);

		assertEquals("ABC", request.getAttribute("arg1"));
		assertEquals("200", request.getAttribute("arg2"));
		assertEquals("N/A", request.getAttribute("result"));
	}

	@Test
	public void test_doPostReturnsAnswerIfBothArgsAreNumber() throws IOException, ServletException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.addParameter("arg1", "100");
		request.addParameter("arg2", "200");

		this.servlet.doPost(request, response);

		assertEquals("100", request.getAttribute("arg1"));
		assertEquals("200", request.getAttribute("arg2"));
		assertEquals("300", request.getAttribute("result"));
	}
}
