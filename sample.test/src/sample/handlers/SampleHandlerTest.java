package sample.handlers;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.commands.ExecutionException;
import org.junit.Test;

public class SampleHandlerTest {

	@Test
	public void testGetMessage() throws ExecutionException {
		assertEquals("Hello, Eclipse world", new SampleHandler().getMessage());
	}

}
