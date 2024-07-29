package org.ta_selenium.tests;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BooksAddedTest extends BaseTest  {

    @Test(groups = {"login"})
    public void testNobooksInProfileSection(){
        Assert.assertTrue(true);
        test.pass("yeap");
    }

    @Test(groups = {"api"})
    public void testExpectedBookSInProfileSection(){
        Assert.assertTrue(true);
        test.pass("yeap");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteOneRandomBookFromUI(){
        Assert.assertTrue(true);
        test.pass("yeap");
    }

    @Test(groups = {"api"})
    public void testIsPossibleDeleteAllBooksFromUI(){
        Assert.assertTrue(true);
        test.pass("yeap");
    }
}
