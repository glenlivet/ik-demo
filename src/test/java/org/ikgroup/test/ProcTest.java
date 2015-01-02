package org.ikgroup.test;

import java.util.ArrayList;
import java.util.List;

import org.ikgroup.db.proc.SequenceProc;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProcTest {
	
//	
//	private static GenericXmlApplicationContext ctx;
//	
//	@BeforeClass
//	public static void beforeClass(){
//		ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:spring-ds.xml");
//		ctx.refresh();
//	}
//	
//	@Test
//	public void sequenceTest(){
//		SequenceProc sp = ctx.getBean("sequenceProc", SequenceProc.class);
//		List<SequenceTestRunner> rs = new ArrayList<SequenceTestRunner>();
//		for(int i=0;i<10;i++){
//			rs.add(new SequenceTestRunner(sp));
//		}
//		for(SequenceTestRunner r : rs){
//			new Thread(r).start();
//		}
//	}
	
	private static class SequenceTestRunner implements Runnable {
		
		private SequenceProc proc;
		
		public SequenceTestRunner(SequenceProc proc){
			this.proc = proc;
		}

		@Override
		public void run() {
			DateTime startTime = DateTime.now();
			Long num = proc.execute("fff");
			DateTime endTime = DateTime.now();
			Period period = new Period(startTime, endTime);
			int millis = period.getMillis();
			System.out.println("[thread:" + Thread.currentThread().getId() + "] millis: " + millis + ": " + num);
			
		}
		
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx;
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-ds.xml");
		ctx.refresh();
		SequenceProc sp = ctx.getBean("sequenceProc", SequenceProc.class);
		List<SequenceTestRunner> rs = new ArrayList<SequenceTestRunner>();
		for(int i=0;i<10;i++){
			rs.add(new SequenceTestRunner(sp));
		}
		for(SequenceTestRunner r : rs){
			new Thread(r).start();
		}
	}

}
