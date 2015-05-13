package com.sydads.tools;

/**
 * Used to identify a class that implements the GoF Visitor pattern
 * User: neilmao
 * Date: 17/04/15
 */
public interface AcceptsVisitor<T extends Visitor> {

    public void accept(T visitor);
}
