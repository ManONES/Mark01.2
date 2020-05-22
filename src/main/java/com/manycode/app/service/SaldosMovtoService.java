package com.manycode.app.service;

import java.util.List;

import com.manycode.app.model.SaldosMovto;

public interface SaldosMovtoService {
	
	public SaldosMovto createSaldosMovto(SaldosMovto saldosmovto);
	public SaldosMovto getSaldosMovto(Long id);
	public SaldosMovto updateSaldosMovto(SaldosMovto saldosmovto, Long saldomovto);
	public List<SaldosMovto> listAllSaldosMovto();	
}
