package com.yang.others;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class test implements Externalizable{
    private transient String content = "陆影大笨蛋";

    public static void main(String[] args) throws Exception {
        test t = new test();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "test"));
        outputStream.writeObject(t);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test"));
        test o = (test) in.readObject();
        System.out.println(o.content);
        outputStream.close();
        in.close();
        ArrayList<Object> list = new ArrayList<>();
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList.indexOf(3));
        list.ensureCapacity(111);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Set<Map.Entry<Object, Object>> set = map.entrySet();
        for(Map.Entry<Object, Object> i:set){
            System.out.println(i.getKey() + "555" +  i.getValue());
        }
        int concurrencyLevel = 16;
        int sshift = 0;
        int ssize = 1;
        // 这个循环可以找到 concurrencyLevel 之上最近的 2的次方值
        new ConcurrentHashMap<>();
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
            System.out.println("shift:" + sshift);
            System.out.println("ssize:" + ssize);
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }
}
