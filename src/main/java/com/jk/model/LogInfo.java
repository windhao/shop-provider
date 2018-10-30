package com.jk.model;





import java.io.Serializable;


public class LogInfo implements Serializable {

    private static final long serialVersionUID = -2688681999245052780L;

    //private String _id;

    private String methodname;//方法名

    private String classname;//类名

    private String invokeDate;//调用时间

    private String paramVal;//参数值

    private String y;

    private String name;

    @Override
    public String toString() {
        return "LogInfo{" +
                "methodname='" + methodname + '\'' +
                ", classname='" + classname + '\'' +
                ", invokeDate='" + invokeDate + '\'' +
                ", paramVal='" + paramVal + '\'' +
                ", y='" + y + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//private String _class;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getInvokeDate() {
        return invokeDate;
    }

    public void setInvokeDate(String invokeDate) {
        this.invokeDate = invokeDate;
    }

    public String getParamVal() {
        return paramVal;
    }

    public void setParamVal(String paramVal) {
        this.paramVal = paramVal;
    }

}
