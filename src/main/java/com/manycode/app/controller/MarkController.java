package com.manycode.app.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.manycode.app.model.MarkMessage;
import com.manycode.app.model.RegistroMovto;
import com.manycode.app.service.RegistroMovtoService;


@Controller
public class MarkController {
		
	private static final Logger LOGGER=LoggerFactory.getLogger(MarkController.class);
	
	@Autowired
	private RegistroMovtoService registroMovtoService;
	

	 
		
	@MessageMapping("/mark.register")
	@SendTo("/topic/public")
	public MarkMessage register(@Payload MarkMessage markMessage, SimpMessageHeaderAccessor headerAccesor) {
		LOGGER.info("....MarkMessage register > chatMessage.getSender: " + markMessage.getSender());		
		LOGGER.info("....MarkMessage register > chatMessage.getContent: " + markMessage.getContent());		
		LOGGER.info("....MarkMessage register > chatMessage.getType: " + markMessage.getType());
			
		headerAccesor.getSessionAttributes().put("username",markMessage.getSender());
								
		return markMessage;
	}
		
	@MessageMapping("/mark.send")
	@SendTo("/topic/public")
	public MarkMessage sendMessage(@Payload MarkMessage markMessage) {
		LOGGER.info("....MarkMessage sendMessage > MarkMessage.getSender: " + markMessage.getSender());		
		LOGGER.info("....MarkMessage sendMessage > MarkMessage.getContent: " + markMessage.getContent());		
		LOGGER.info("....MarkMessage sendMessage > MarkMessage.getType: " + markMessage.getType());
					
		return markMessage;
	}	

	@MessageMapping("/mark.received")
	@Transactional
	public MarkMessage receivedMessage(@Payload MarkMessage markMessage) {
		LOGGER.info("....MarkMessage receivedMessage > MarkMessage.getSender: " + markMessage.getSender());		
		LOGGER.info("....MarkMessage receivedMessage > MarkMessage.getContent: " + markMessage.getContent());	
		LOGGER.info("....MarkMessage receivedMessage > dameRegistroCadena1,MarkMessage.getContent: " + dameRegistroCadena(0,markMessage.getContent()));  
		LOGGER.info("....MarkMessage receivedMessage > dameRegistroCadena2,MarkMessage.getContent: " + dameRegistroCadena(1,markMessage.getContent()));
		LOGGER.info("....MarkMessage receivedMessage > dameRegistroCadena3,MarkMessage.getContent: " + dameRegistroCadena(2,markMessage.getContent()));
		LOGGER.info("....MarkMessage receivedMessage > dameRegistroCadena4,MarkMessage.getContent: " + dameRegistroCadena(3,markMessage.getContent()));
		LOGGER.info("....MarkMessage receivedMessage > dameRegistroCadenaa5,MarkMessage.getContent: " + dameRegistroCadena(4,markMessage.getContent()));
		LOGGER.info("....MarkMessage receivedMessage > MarkMessage.getType: " + markMessage.getType());
		
		RegistroMovto registromovto = new RegistroMovto();
		
		registromovto.setMessagesender(markMessage.getSender());
		registromovto.setrString1(dameRegistroCadena(0,markMessage.getContent()));
		registromovto.setrString2(dameRegistroCadena(1,markMessage.getContent()));
		registromovto.setrString3(dameRegistroCadena(2,markMessage.getContent()));
		registromovto.setrString4(dameRegistroCadena(3,markMessage.getContent()));
		registromovto.setImporte_movto(Long.parseLong(dameRegistroCadena(4,markMessage.getContent())));
		registromovto.setImporte_acumulado((long) 0);
		registromovto.setMessagetype("" +markMessage.getType());
		
		registroMovtoService.createRegistroMovto(registromovto);
							
		return markMessage;
	}	
	
	
	@GetMapping("/listar/movtos")
	public String movimientos(Model model) {
		LOGGER.info("....Lista TODO mensaje en  BD.");		
		model.addAttribute("mensajes", registroMovtoService.listAllRegistroMovto());
		LOGGER.info("....Fin Lista TODO mensaje en  BD.");
		
		model.addAttribute("error","No hay error!");
		return "movimientos";
	}

	
	
	public String dameRegistroCadena (Integer id, String cadena) {	
		
		String[] arrayColores = cadena.split(",");
		String registroRetorno = null;
		
		for (int i = 0; i < arrayColores.length; i++) {
			if (i == id) {
				registroRetorno = arrayColores[i];
			}
		}
		return registroRetorno;
	}

	
	
}