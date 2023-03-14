package Testing;

import Utility.RegexUtil;
import org.junit.Assert;


import org.junit.Test;

public class RegexUtilTesting {
    @Test
    public void testOneFirstName()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertFalse(obj.isStartWithCapitalLatter("nikita"));

    }
    @Test
    public void testTwoFirstName()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isStartWithCapitalLatter("Nikita"));

    }
    @Test
    public void testOneMobileNumber()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isCheckMobileNumber("7447376717"));

    }
    @Test
    public void testTwoMobileNumber()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isCheckMobileNumber("6600222000"));

    }
    @Test
    public void testOneEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isCheckEmailId("abc@yahoo.com"));

    }
    @Test
    public void testTwoEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isCheckEmailId("abc-100@yahoo.com"));

    }
    @Test
    public void testThreeEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertTrue(obj.isCheckEmailId("abc.100@yahoo.com"));

    }
    @Test
    public void testFourEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertFalse(obj.isCheckEmailId("abc@%*.com"));

    }
    @Test
    public void testFiveEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertFalse(obj.isCheckEmailId("abc"));

    }
    @Test
    public void testSixEmailId()
    {
        RegexUtil obj = new RegexUtil();
        Assert.assertFalse(obj.isCheckEmailId("abc@gmail.com.aa.au"));

    }

}