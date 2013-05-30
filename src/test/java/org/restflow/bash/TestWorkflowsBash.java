package org.restflow.bash;

import org.restflow.test.WorkflowTestCase;

public class TestWorkflowsBash extends WorkflowTestCase {

	public TestWorkflowsBash() {
		super("org/restflow/bash/test/TestWorkflowsBash");
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		_importSchemeToResourceMap.put("actors", "classpath:/org/restflow/bash/");
	}

	public void test_SubscribeWithLocalPaths_PublishSubscribeDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("SubscribeWithLocalPaths", _publishSubscribeDirector());
		assertEquals(_getExpectedTrace(), _runner.getTraceReport());		
		assertStringsEqualWhenLineEndingsNormalized(_getExpectedStdout("stdout_publish.txt"), _runner.getStdoutRecording());		
		assertFileResourcesMatchExactly("files");
		assertFileResourcesMatchExactly("directories");
		assertFileResourcesMatchExactly("scratch");
	}
	
	public void test_PublishDirectoryFromSubworkflow_DataDrivenDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("PublishDirectoryFromSubworkflow", _dataDrivenDirector());
		assertEquals(_getExpectedTrace(), _runner.getTraceReport());
		assertStringsEqualWhenLineEndingsNormalized(_getExpectedStdout(), _runner.getStdoutRecording());
		assertFileResourcesMatchExactly("files");
		assertFileResourcesMatchExactly("sub");
		assertFileResourcesMatchExactly("top");
		assertFileResourcesMatchExactly("scratch");
	}
	
	public void test_SubscribeWithLocalPaths_DataDrivenDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("SubscribeWithLocalPaths", _dataDrivenDirector());
		assertEquals(_getExpectedTrace(), _runner.getTraceReport());		
		assertStringsEqualWhenLineEndingsNormalized(_getExpectedStdout(), _runner.getStdoutRecording());		
		assertFileResourcesMatchExactly("files");
		assertFileResourcesMatchExactly("directories");
		assertFileResourcesMatchExactly("scratch");
	}
	
	public void test_SubscribeWithLocalPaths_MTDataDrivenDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("SubscribeWithLocalPaths", _MTDataDrivenDirector());
		assertStringsEqualWhenLineEndingsNormalized(_getExpectedTrace(), _runner.getTraceReport());
		assertFileResourcesMatchExactly("files");
		assertFileResourcesMatchExactly("directories");
		assertFileResourcesMatchExactly("scratch");
	}
	
	public void test_PublishDirectory_DataDrivenDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("PublishDirectory", _dataDrivenDirector());
		assertEquals(_getExpectedTrace(), _runner.getTraceReport());
		assertStringsEqualWhenLineEndingsNormalized(_getExpectedStdout(), _runner.getStdoutRecording());		
		assertFileResourcesMatchExactly("files");
		assertFileResourcesMatchExactly("directories");
		assertFileResourcesMatchExactly("scratch");
	}
	
	public void test_BashFiles_DataDrivenDirector() throws Exception {
		_useWorkingDirectory();
		_loadAndRunWorkflow("BashFiles", _dataDrivenDirector());
		assertEquals(_getExpectedTrace(), _runner.getTraceReport());		
		assertEquals(_getExpectedStdout(), _runner.getStdoutRecording());		
		assertFileResourcesMatchExactly("messages");
		assertFileResourcesMatchExactly("scratch");
	}
}
