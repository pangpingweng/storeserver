//package com.platform.framework.web;
//
//
//import org.n52.matlab.control.MatlabInvocationException;
//import org.n52.matlab.control.MatlabProxy;
//import org.n52.matlab.control.extensions.MatlabNumericArray;
//import org.n52.matlab.control.extensions.MatlabTypeConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MatlabService {
//
//    @Autowired
//    private MatlabProxy matlabProxy;
//
//    public void task() throws MatlabInvocationException {
//
////        // 调用Matlab程序
////        matlabProxy.eval("[out]=main(in)");
//        // 构造矩阵入参
////        double[][] in = createMockInputDataArray();
////        // 注意传递二维以上数组型入参，需要同MatlabNumericArray包装后传递，否则会报错
////        MatlabNumericArray input = new MatlabNumericArray(in, null);
//        MatlabTypeConverter converter = new MatlabTypeConverter(matlabProxy);
//        converter.setNumericArray("path1", new int[]{1});
//        converter.setNumericArray("path2", new int[]{1});
//
//        // 调用matlab程序
//        matlabProxy.eval("[label,prob]=recogRock(path1,path2)");
//        // 获取返回值
//        String[][] out = converter.getNumericArray("label").get();
//        double[][] out2 = converter.getNumericArray("prob").getRealArray2D();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(">>>>>>>>>>>>>>>>>>>>> java invoke matlab success");
//        // 断开连接
//        matlabProxy.exit();
//    }
//}