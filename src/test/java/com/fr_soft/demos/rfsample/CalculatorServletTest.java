package com.fr_soft.demos.rfsample;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CalculatorServletTest {

    private CalculatorServlet servlet = new CalculatorServlet();
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();

    @Test
    public void test_doGetShouldReturnsNoArgsAndResult() throws IOException, ServletException {
        this.servlet.doGet(this.request, this.response);

        assertNull(this.request.getAttribute("arg1"));
        assertNull(this.request.getAttribute("arg2"));
        assertNull(this.request.getAttribute("result"));
    }

    @Test
    public void test_doPostReturnsErrorMessageIfArg1IsNotNumber() throws IOException, ServletException {
        this.request.addParameter("arg1", "XYZ");
        this.request.addParameter("arg2", "100");

        this.servlet.doPost(this.request, this.response);

        assertEquals("XYZ", this.request.getAttribute("arg1"));
        assertEquals("100", this.request.getAttribute("arg2"));
        assertEquals("N/A", this.request.getAttribute("result"));
    }

    @Test
    public void test_doPostReturnsErrorMessageIfArg2IsNotNumber() throws IOException, ServletException {
        this.request.addParameter("arg1", "ABC");
        this.request.addParameter("arg2", "200");

        this.servlet.doPost(this.request, this.response);

        assertEquals("ABC", this.request.getAttribute("arg1"));
        assertEquals("200", this.request.getAttribute("arg2"));
        assertEquals("N/A", this.request.getAttribute("result"));
    }

    @Test
    public void test_doPostReturnsAnswerIfBothArgsAreNumber() throws IOException, ServletException {
        this.request.addParameter("arg1", "100");
        this.request.addParameter("arg2", "200");

        this.servlet.doPost(this.request, this.response);

        assertEquals("100", this.request.getAttribute("arg1"));
        assertEquals("200", this.request.getAttribute("arg2"));
        assertEquals("300", this.request.getAttribute("result"));
    }
}
