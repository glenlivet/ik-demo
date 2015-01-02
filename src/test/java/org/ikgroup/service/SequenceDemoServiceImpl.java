package org.ikgroup.service;

import org.ikgroup.domain.SequenceDemo;
import org.ikgroup.persistence.SequenceDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("sequenceDemoService")
@Repository
@Transactional
public class SequenceDemoServiceImpl implements SequenceDemoService {
	
	@Autowired
	private SequenceDemoMapper seqMapper;

	@Override
	public SequenceDemo save(SequenceDemo c) {
		//get sequence
		Long seq = getSequence("demo");
		String id = formatId(seq);
		SequenceDemo demo = new SequenceDemo();
		demo.setId(id);
		seqMapper.insert(demo);
		return demo;
	}

	private String formatId(Long seq) {
		String raw = "00000" + seq.toString();
		return raw.substring(raw.length()-4);
	}

	/**
	 * 根据 key 拿到最新的sequence
	 * 
	 * @param string
	 * @return
	 */
	private Long getSequence(String string) {
		
		return null;
	}
	
}
