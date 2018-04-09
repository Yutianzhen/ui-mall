package cn.okay.tools;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by yutz on 2018/4/8.
 */
public class Log {
    //clazz.getCanonicalName() 获取类名字，为将来case执行获取case名和page名和action名
    private final Class<?> clazz;
    private Logger logger;

    public Log(Class<?> clazz) {
        this.clazz = clazz;
        this.logger= LogManager.getLogger(this.clazz);
    }

    public void info(String message){
        logger.info(message);
    }

    public void debug(String message){
        logger.debug(message);
    }

    public void error(String message){
        logger.error(message);
    }
}
