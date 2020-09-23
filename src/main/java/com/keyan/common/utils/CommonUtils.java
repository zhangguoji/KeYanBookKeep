package com.keyan.common.utils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CommonUtils {
    /**
     * @param filterBean 用于赋值的实体类
     * @param targetBean 需要待赋值的实体类
     * 描述：反射实体类赋值target
     */
    public static void toBean(Object filterBean,Object targetBean) throws Exception{
        Class filterClass = Class.forName(filterBean.getClass().getName());
        Class targetClass = Class.forName(targetBean.getClass().getName());
        Field[] fields1 = filterClass.getDeclaredFields();
        Field[] fields2 = targetClass.getDeclaredFields();
        CommonUtils commonUtils = new CommonUtils();
        for (Field f1 : fields1) {
            Object value = commonUtils.invokeGetMethod(filterBean ,f1.getName(),null);
            for (Field f2 : fields2) {
                if(f1.getName().equals(f2.getName())){
                    Object[] obj = new Object[1];
                    obj[0] = value;
                    commonUtils.invokeSetMethod(targetBean, f2.getName(), obj);
                }
            }
        }

    }

    /**
     * 执行某个Field的getField方法
     * @param filterBean 类
     * @param fieldName 类的属性名称
     * @param args 参数，默认为null
     * @return
     */
    private Object invokeGetMethod(Object filterBean, String fieldName, Object[] args)
    {
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
        Method method = null;
        try
        {
            method = Class.forName(filterBean.getClass().getName()).getDeclaredMethod("get" + methodName);
            return method.invoke(filterBean);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 执行某个Field的setField方法
     * @param targetBean 类
     * @param fieldName 类的属性名称
     * @param args 参数，默认为null
     * @return
     */
    private Object invokeSetMethod(Object targetBean, String fieldName, Object[] args)
    {
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
        Method method = null;
        try
        {
            Class[] parameterTypes = new Class[1];
            Class targetClass = Class.forName(targetBean.getClass().getName());
            Field field = targetClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            method = targetClass.getDeclaredMethod("set" + methodName,parameterTypes);
            return method.invoke(targetBean,args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

}
