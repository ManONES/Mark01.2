package com.manycode.app.service;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manycode.app.model.SaldosMovto;
import com.manycode.app.repository.SaldosMovtoRepository;

//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class SaldosMovtoServiceImpl implements  SaldosMovtoService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(SaldosMovtoServiceImpl.class);
	
	@Autowired
	private  SaldosMovtoRepository saldosmovtoRepository;
	
	public SaldosMovtoServiceImpl(final SaldosMovtoRepository saldosmovtoRepository) {
		this.saldosmovtoRepository = saldosmovtoRepository;
	}

	@Override
	public SaldosMovto createSaldosMovto(final SaldosMovto saldosmovto) {
		LOGGER.info("....createSaldosMovto ");	
		saldosmovto.setStatus("CREATED");
		saldosmovto.setCreateAt(new Date());
		return saldosmovtoRepository.save(saldosmovto);		
	}
	
	@Override
	public SaldosMovto getSaldosMovto(final Long id) {
		LOGGER.info("....getSaldosMovto ");
		return saldosmovtoRepository.findById(id).orElse(null);
	}
	
	@Override
	public SaldosMovto updateSaldosMovto(final SaldosMovto saldosmovto, Long saldomovto) {
		// TODO Auto-generated method stub
		SaldosMovto saldosmovtoDB = getSaldosMovto(saldosmovto.getId());
		if (null == saldosmovtoDB) {
			LOGGER.info("....updateSaldosMovto>>NULL ");
			return null;
		}
		LOGGER.info("....updateSaldosMovto ID:"+saldosmovtoDB.getId() + "....saldoanterior:"+saldosmovto.getImporte_saldo_movto() + "....saldomovto:"+saldomovto);
		saldosmovtoDB.setImporte_saldo_movto(saldosmovto.getImporte_saldo_movto()+saldomovto);
		
		return saldosmovtoRepository.save(saldosmovtoDB);
	}
	
	@Override
	public List<SaldosMovto> listAllSaldosMovto(){
		LOGGER.info("....listAllSaldosMovto ");
		return saldosmovtoRepository.findAll();
	}	

}
