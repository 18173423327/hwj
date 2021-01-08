package com.hwj.test;

import org.junit.Test;

import com.hwj.job.Jobinformation;
import com.hwj.job.Jobseeker;
import com.hwj.job.Login;
import com.hwj.job.Register;

public class HwjTest {
	@Test
   public void init() {
		new Login();
   }
	@Test
   public void init2() {
	    new Register();
   }
	@Test
   public void init3() {
	   new Jobseeker();
   }
	@Test
   public void init4() {
	   new Jobinformation();
   }
	public void init5() {
		//new 
	}
	
}
