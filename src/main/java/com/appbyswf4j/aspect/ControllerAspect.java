/**
 * created by Zheng Jiateng on 2019/5/25.
 */
package com.appbyswf4j.aspect;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;
import com.swf4j.framework.proxy.AspectProxy; //增强的抽象类
import com.swf4j.framework.annotation.Aspect; // 切面注解
import com.swf4j.framework.annotation.Controller; //控制器注解

/**
 * 拦截Controller所有方法
 */
@Aspect(Controller.class) // 切点
public class ControllerAspect extends AspectProxy{ // ControllerAspect切面 AspectProxy增强
    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("------ begin ------");
        logger.debug(String.format("class: %s", cls.getName()));
        logger.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.debug(String.format("run time: %dms", System.currentTimeMillis() - begin));
        logger.debug("------ end ------");
    }
}
