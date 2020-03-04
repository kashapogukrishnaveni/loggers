package com.xworkz.loggers.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
@RequestMapping("/")
public class Log4jController {
	
	private static Logger logger = Logger.getLogger(Log4jController.class);
	//DispatcherServlet

	@RequestMapping("/message.do")
	public String getMessage() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
		
		logger.trace("trace message --> inside getMessage()....");
		logger.debug("debug message --> inside getMessage()....");
		
		logger.warn("warn message --> inside getMessage()....");
		logger.error("error message --> inside getMessage()....");
		logger.fatal("fatal message --> inside getMessage()....");
		
		try {
			Integer.parseInt("2314mk32");
			
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured",e);
		}
		System.out.println("inside getMessage()....");
		return "/message.jsp";
	}

}

