package com.yang.others;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class DefinedClassLoaderTest extends ClassLoader{

    private String classPath;

    public DefinedClassLoaderTest(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 重写findClass方法
     *
     * 如果不会写, 可以参考URLClassLoader中是如何加载AppClassLoader和ExtClassLoader的
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadBytes(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private byte[] loadBytes(String name) throws Exception {
        // 我们需要读取类的路径
        String path = name.replace('.', '/').concat(".class");
        //String path = "";
        // 去路径下查找这个类
        FileInputStream fileInputStream = new FileInputStream(classPath + "/"  + path);
        int len = fileInputStream.available();

        byte[] data = new byte[len];
        fileInputStream.read(data);
        fileInputStream.close();

        return data;
    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                /**
                 * 直接执行findClass()...什么意思呢? 首先会使用自定义类加载器加载类, 不在向上委托, 直接由
                 * 自己执行
                 *
                 * jvm自带的类还是需要由引导类加载器自动加载
                 */
                if (!name.startsWith("com.yang.others")) {
                    c = this.getParent().loadClass(name);
                } else {
                    c = findClass(name);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    public static void main(String[] args) throws Exception {
        DefinedClassLoaderTest classLoader = new DefinedClassLoaderTest("/LeetCode/fall/src/");
        Class<?> clazz = classLoader.loadClass("com.yang.others");
        Object obj = clazz.newInstance();
        Method sout = clazz.getDeclaredMethod("sout", null);
        sout.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
