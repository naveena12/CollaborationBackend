package com.niit.colloboration.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.colloboration.model.Message;
import com.niit.colloboration.model.OutputMessage;

@Controller
@RequestMapping("/")
public class ChatController {
	/*@Autowired
	private SimpleMessagingTemplate simpleMessagingTemplate;
	*/
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String viewApplication(){
		return "index";
	}
	@MessageMapping("/chat")
    @SendTo("/topic/message")
	public OutputMessage sendMessage(Message message){
		return new OutputMessage(message,new Date());
		
	}
}
