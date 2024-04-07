package Test.AtoZ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POMAZ.Suggession;
import TestComponentsAZ.BaseTestAZ;

public class suggessionDrpDwnTest extends BaseTestAZ {

	@Test (dataProvider="getDataCountry")
	public void SelectCountry(String NameChar,String CountryName) 
	{
		Suggession Sug=SuggessionObj();
		Sug.SelectGivenCountry(NameChar,CountryName);
	}
	@DataProvider // if we want provide multiple data one time only
	public Iterator<String[]> getDataCountry()
	{
		List<String[]> list=new ArrayList<String[]>();
		list.add(new String[] {"tan","Tajikistan"});
		return list.iterator();
	}
	
	/* if we want to pass only one data one time
	@DataProvider
	public Object[] getDataCountry()
	{
		 Object[] data= {"tan"};
		 return data;
	} */
}
