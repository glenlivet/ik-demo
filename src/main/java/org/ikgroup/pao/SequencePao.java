package org.ikgroup.pao;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * {@code Long}型序列号生成器。
 * 
 * @author glenlivet
 *
 */
public class SequencePao extends StoredProcedure {
	
	private static final String PROC_NAME = "get_sequence";
	
	public SequencePao(DataSource ds) {
		super(ds, PROC_NAME);
		declareParameter(new SqlParameter("seqname", Types.VARCHAR));
		declareParameter(new SqlOutParameter("seqvalue", Types.INTEGER));
		compile();
	}
	
	/**
	 * 获取序列号。
	 * 
	 * @param name 序列号名称。	
	 * @return
	 */
	public Long getSequenceByName(String name) {
		Long num = -1L;
		do {
			Map<String, Object> results = super.execute(name);
			num = Long.parseLong(results.get("seqvalue").toString());
		}while(num == -1L);
		return num;
	}
	
}
