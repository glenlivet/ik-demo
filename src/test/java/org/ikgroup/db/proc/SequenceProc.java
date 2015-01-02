package org.ikgroup.db.proc;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SequenceProc extends StoredProcedure {
	
	private static final String PROC_NAME = "get_sequence";
	
	public SequenceProc(DataSource ds){
		super(ds, PROC_NAME);
		declareParameter(new SqlParameter("seqname", Types.VARCHAR));
		declareParameter(new SqlOutParameter("seqvalue", Types.INTEGER));
		compile();
	}
	
	public Long execute(String name){
		Map<String,Object> results = super.execute(name);
		return Long.parseLong(results.get("seqvalue").toString());
	}

}
