import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculTest {

	Calcul cl ;
	CalculService cls = mock(CalculService.class);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		cl=new Calcul(cls);
	}

	@AfterEach
	void tearDown() throws Exception {
		cl = null;
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void TestCalculNote()
	{
		assertEquals(2, cl.calculNote(2, 2) ,"Not correct");
	}
	
	@Test
	public void TestCompare() 
	{
		if(cl.compare(2, 2) !=2)
		{
			fail("Problem sont egaux");
		}
		
		if(cl.compare(2, 0) !=1)
		{
			fail("Problem non egaux");
		}
		
		Throwable e = null;
		
		try {
			cl.compare(0, 2);
			
			
		}catch (Throwable ex) {
				e = ex;
			}
		assertTrue(e instanceof ArithmeticException);
		e = null;
	}
	
	
	@Test
	public void TestCalculSomme()
	{
		when(cls.method(1, 0)).thenReturn(3);
		when(cls.method(2, 0)).thenReturn(1);
		
		assertEquals(2.0, cl.calculSomme(1,2),"Moyen correct");
	}
	

}
