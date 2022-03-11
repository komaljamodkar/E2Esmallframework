package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//default points to config ,print log on console
//ref=console so printing on console , else use file..used error level else use trace print all logs
public class Demo {

	private static Logger log =LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {
		log.info("Successfully switched to frame");
		log.error("Cannot identify the frame"); 	// print only error and fatal msg with default config
		log.debug("print debug message"); 	
		log.fatal("print fatal message");
		log.warn("print warning message");


	}

}
