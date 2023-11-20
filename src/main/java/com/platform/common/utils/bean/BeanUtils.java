//package com.platform.common.utils.bean;
//
//import com.alibaba.fastjson.JSON;
//import org.n52.matlab.control.*;
//import org.n52.matlab.control.extensions.MatlabNumericArray;
//import org.n52.matlab.control.extensions.MatlabTypeConverter;
//import org.springframework.util.ResourceUtils;
//
//import java.io.*;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Bean 工具类
// *
// */
//public class BeanUtils extends org.springframework.beans.BeanUtils
//{
//    /** Bean方法名中属性名开始的下标 */
//    private static final int BEAN_METHOD_PROP_INDEX = 3;
//
//    /** * 匹配getter方法的正则表达式 */
//    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");
//
//    /** * 匹配setter方法的正则表达式 */
//    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");
//
//    /**
//     * Bean属性复制工具方法。
//     *
//     * @param dest 目标对象
//     * @param src 源对象
//     */
//    public static void copyBeanProp(Object dest, Object src)
//    {
//        try
//        {
//            copyProperties(src, dest);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取对象的setter方法。
//     *
//     * @param obj 对象
//     * @return 对象的setter方法列表
//     */
//    public static List<Method> getSetterMethods(Object obj)
//    {
//        // setter方法列表
//        List<Method> setterMethods = new ArrayList<Method>();
//
//        // 获取所有方法
//        Method[] methods = obj.getClass().getMethods();
//
//        // 查找setter方法
//
//        for (Method method : methods)
//        {
//            Matcher m = SET_PATTERN.matcher(method.getName());
//            if (m.matches() && (method.getParameterTypes().length == 1))
//            {
//                setterMethods.add(method);
//            }
//        }
//        // 返回setter方法列表
//        return setterMethods;
//    }
//
//    /**
//     * 获取对象的getter方法。
//     *
//     * @param obj 对象
//     * @return 对象的getter方法列表
//     */
//
//    public static List<Method> getGetterMethods(Object obj)
//    {
//        // getter方法列表
//        List<Method> getterMethods = new ArrayList<Method>();
//        // 获取所有方法
//        Method[] methods = obj.getClass().getMethods();
//        // 查找getter方法
//        for (Method method : methods)
//        {
//            Matcher m = GET_PATTERN.matcher(method.getName());
//            if (m.matches() && (method.getParameterTypes().length == 0))
//            {
//                getterMethods.add(method);
//            }
//        }
//        // 返回getter方法列表
//        return getterMethods;
//    }
//
//    /**
//     * 检查Bean方法名中的属性名是否相等。<br>
//     * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
//     *
//     * @param m1 方法名1
//     * @param m2 方法名2
//     * @return 属性名一样返回true，否则返回false
//     */
//
//    public static boolean isMethodPropEquals(String m1, String m2)
//    {
//        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
//    }
//    /***
//     * 指定matlab程序所处的位置,注意是文件夹形式
//     */
//    private static final String matlabFile = "H:\\Desktop\\dfn";
//    /***
//     * matlab启动程序的路径，因为后续通过这个路径来拉起matlab应用程序
//     */
//    private static final String matlabExe = "E:\\IDE\\matlab2022a\\bin\\matlab.exe";
//
//    public static void main(String[] args){
//        File file = null;
//        try {
//            System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab文件获取开始...");
//            file = ResourceUtils.getFile(matlabFile);
//        } catch (FileNotFoundException e) {
//            System.out.println("Mtalab文件获取失败!");
//        }
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab文件获取成功！");
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> Mtalab建立连接...");
//        MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
//                .setProxyTimeout(3000000L)
//                .setMatlabStartingDirectory(file)
//                .setHidden(false)
//                .setMatlabLocation(matlabExe)
//                .build();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> 开始拉起MATLAB程序...");
//        // 通过matlab代理工厂，创建matlab代理，后续通过代理操作matlab
//        MatlabProxyFactory factory = new MatlabProxyFactory(options);
//        MatlabProxy proxy = factory.getProxy();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> MATLAB连接成功!");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> JAVA 调用 MATLAB 程序...");
//        Object[] x ={1};
//        Object[] y={9};
//        Object[] input = {x,y};
//        Object[] result = proxy.returningFeval("recog", 2,1,9);//调用sumOne.m函数，传入input参数，
//        //	System.out.println(result);
//
//        //把result[OBJECT类型]转化成int数组
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(JSON.toJSONString(result[i]));
//        }
//
//
////        double[][] in = {{1,1},{2,2}};//第1个二维矩阵入参
////        double[][] in2 = {{2,2},{3,3}};//第2个二维矩阵入参
////        MatlabNumericArray input = new MatlabNumericArray(in,null);
////        MatlabNumericArray input2 = new MatlabNumericArray(in2,null);
////        MatlabTypeConverter mtc = new MatlabTypeConverter(proxy);
////        mtc.setNumericArray("path1", input2);
////        mtc.setNumericArray("path2", input);
//
//        proxy.eval("[label,prob]=recog(path1,path2)");
//        //计算结果
//        double[][] out=mtc.getNumericArray("label").getRealArray2D();
//        double[] out2=mtc.getNumericArray("prob").getRealArray2D();
//
//        System.out.println(">>>>>>>"+ JSON.toJSONString(out));
//        System.out.println(">>>>>>>"+JSON.toJSONString(out2));
//
//        Object[] result = proxy.returningFeval("recog", 2,"111","222");//调用sumOne.m函数，传入input参数，
//        System.out.println(">>>>>>>"+JSON.toJSONString(result));
//
//
//        double[][] in = {{1,1},{2,2}};//第1个二维矩阵入参
//        double[][] in2 = {{2,2},{3,3}};//第2个二维矩阵入参
//        MatlabNumericArray input = new MatlabNumericArray(in,null);
//        MatlabNumericArray input2 = new MatlabNumericArray(in2,null);
//        MatlabTypeConverter mtc = new MatlabTypeConverter(proxy);
//        mtc.setNumericArray("path1", input2);
//        mtc.setNumericArray("path2", input);
//        proxy.eval("[label,prob]=DFN_generator(path1,path2)");
//        //计算结果
//        double[] out = mtc.getNumericArray("label");
//        //double[] out2=mtc.getNumericArray("prob").getRealArray2D();
//
//        proxy.exit();//断开与matlab的连接
//
//
//
//    }
//}
