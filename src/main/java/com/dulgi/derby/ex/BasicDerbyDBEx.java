package com.dulgi.derby.ex;

public class BasicDerbyDBEx {
    static final public String DRIVER_CLASS_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
    static final public String PROTOCOL = "jdbc:derby:";
    static final public String DB = "derbyDB";
    static final public String CONNECTION_STRING = PROTOCOL + DB;

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}
