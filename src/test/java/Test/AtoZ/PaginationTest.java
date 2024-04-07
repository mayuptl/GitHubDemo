package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.PaginationPOM;
import TestComponentsAZ.BaseTestAZ;

public class PaginationTest extends BaseTestAZ {
	@Test
	public void Pagination1()
	{
		PaginationPOM Pagination=PaginationObj();
		Pagination.Pg();
	}

}
