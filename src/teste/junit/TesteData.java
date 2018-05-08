package teste.junit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import br.com.project.report.util.DateUtils;

public class TesteData {

	@Test
	public void test() {
		try {
		assertEquals("26042018", DateUtils.getDateAtualReportName());
		
		assertEquals("'2018-04-26", DateUtils.formatDateSql(Calendar.getInstance().getTime()));

		}
		catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	
	}

}
