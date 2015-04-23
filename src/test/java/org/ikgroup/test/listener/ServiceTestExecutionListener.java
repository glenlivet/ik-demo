package org.ikgroup.test.listener;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.ikgroup.test.annotation.DataSets;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class ServiceTestExecutionListener implements TestExecutionListener {

	private IDatabaseTester databaseTester;

	@Override
	public void afterTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTestMethod(TestContext arg0) throws Exception {
		// 清除测试数据 如果存在
		if (databaseTester != null){
			databaseTester.onTearDown();
		}
			
	}

	@Override
	public void beforeTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTestMethod(TestContext testCtx) throws Exception {
		// 看是否有DataSets注解
		DataSets dataSetAnnotation = testCtx.getTestMethod().getAnnotation(
				DataSets.class);
		if (dataSetAnnotation == null) {
			return;
		}
		String dataSetName = dataSetAnnotation.setUpDataSet();
		// 填充数据
		if (!dataSetName.equals("")) {
			databaseTester = (IDatabaseTester) testCtx.getApplicationContext()
					.getBean("databaseTester");
			XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader)
					testCtx.getApplicationContext().getBean("xlsDataFileLoader");
			IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
			databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
			databaseTester.setDataSet(dataSet);
			databaseTester.onSetup();
		}
	}

	@Override
	public void prepareTestInstance(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
