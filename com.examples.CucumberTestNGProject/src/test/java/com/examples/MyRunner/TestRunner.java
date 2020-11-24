package com.examples.MyRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions
(
		features= "src/test/java/com/examples/Features",
		glue= {"LoginStepDefiniton"}		
 )

public class TestRunner extends AbstractTestNGCucumberTests
{
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	 @BeforeClass(alwaysRun = true)
	 public void Setup()
	 {
		 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		 
	 }
	 @Test()
	 public void feature(PickleWrapper cucumberFeature) {
	        testNGCucumberRunner.runScenario(cucumberFeature.getPickle());
	    }
	 @AfterClass(alwaysRun = true)
	 public void tearDownClass() 
	 {
		    testNGCucumberRunner.finish();
	}
 
}
