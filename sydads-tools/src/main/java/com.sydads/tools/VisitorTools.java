package com.sydads.tools;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 18/04/15
 */
public class VisitorTools {

    public static final Log LOG = LogFactory.getLog(VisitorTools.class);

    /**
     * If the Visitor has the method visit(aClass) then it's invoked
     *
     * aClass is the class of the object implementing AcceptsVisitor
     *
     * <p/>
     * This is useful for deproxying an object
     */
    public static void doVisit(Visitor visitor, AcceptsVisitor acceptsVisitor) {
        Method method;
        boolean found = false;

        Class clazz = visitor.getClass();
        Class parameterClass = acceptsVisitor.getClass();

        do {
            try
            {
                method = clazz.getMethod("visit", parameterClass);
                if (method != null) {
                    found = true;
                    method.setAccessible(true);
                    method.invoke(visitor, acceptsVisitor);
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                LOG.warn("Visit Class " + clazz.getName() + " failed", e);
            }
            // the visit() could be defined in its super class
            if (!found) {
                parameterClass = parameterClass.getSuperclass();
            }
        } while (!found || parameterClass != null);
    }
}
