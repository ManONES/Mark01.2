package com.manycode.app.service;

import java.util.List;

import com.manycode.app.model.RegistroMovto;

public interface RegistroMovtoService {
	
	public RegistroMovto createRegistroMovto(RegistroMovto registromovto);
	public RegistroMovto getRegistroMovto(Long id);
	public List<RegistroMovto> listAllRegistroMovto();	
	
}
