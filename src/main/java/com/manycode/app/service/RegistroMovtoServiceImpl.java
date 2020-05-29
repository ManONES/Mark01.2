package com.manycode.app.service;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manycode.app.model.RegistroMovto;
import com.manycode.app.model.SaldosMovto;
import com.manycode.app.repository.RegistroMovtoRepository;

//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class RegistroMovtoServiceImpl implements RegistroMovtoService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RegistroMovtoServiceImpl.class);

	@Autowired
	private RegistroMovtoRepository registromovtoRepository;
	
	@Autowired
	private SaldosMovtoService saldosMovtoService;
	
	public RegistroMovtoServiceImpl(final RegistroMovtoRepository registromovtoRepository) {
		this.registromovtoRepository = registromovtoRepository;
	}

	@Override
	public RegistroMovto createRegistroMovto(RegistroMovto registromovto) {
		LOGGER.info("....createRegistroMovto ");
		
		registromovto.setStatus("CREATED");
		registromovto.setCreateAt(new Date());
		
		SaldosMovto saldosmovto = saldosMovtoService.getSaldosMovto(Long.parseLong(registromovto.getrString4()));
		SaldosMovto saldosmovtoFin = saldosMovtoService.updateSaldosMovto(saldosmovto, registromovto.getImporte_movto());
		
		try {
			registromovto.setImporte_acumulado(saldosmovtoFin.getImporte_saldo_movto());
		} catch (RuntimeException exception) {
			LOGGER.info("....:::::::RuntimeException exception::::::  " + exception.getMessage());
		}
						
		LOGGER.info("....MarkMessage registromovto:::getRString4():"+ registromovto.getrString4()+"....getImporte_movto():"+registromovto.getImporte_movto()+".....getImporte_acumulado():"+registromovto.getImporte_acumulado());
		
		//actualizaSaldoAcumulado(registromovtoFin.getId(),saldosmovtoFin.getImporte_saldo_movto());
		
		return registromovtoRepository.save(registromovto);		
	}
	
	@Override
	public RegistroMovto getRegistroMovto(Long id) {
		LOGGER.info("....getRegistroMovto ");
		return registromovtoRepository.findById(id).orElse(null);		
	}
	
	@Override
	public List<RegistroMovto> listAllRegistroMovto(){
		LOGGER.info("....listAllRegistroMovto ");
		return registromovtoRepository.findAll();		
	}
	

	
	
	
}