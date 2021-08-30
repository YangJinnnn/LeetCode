package com.yang.project;

import java.util.*;

public class Main2_HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int X = in.nextInt();
        System.out.println(Arrays.toString(num));
        System.out.println(X);
        int people = 0;
        while (true){
            solution(num, X);
            if(res==0){
                break;
            }
            people++;
            HashMap<Integer, Integer> map = project.get(0);
            for(int i:map.keySet()){
                System.out.print(i + ":" + map.get(i) + " ");
                int j;
                for (j = 0; j < money.length; j++) {
                    if(i==money[j]){
                        break;
                    }
                }
                num[j] -= map.get(i);
            }
            System.out.println();
            int cnt = 0;
            for (int i = 0; i < num.length; i++) {
                cnt += num[i]*money[i];
            }
            if(cnt<X){
                break;
            }
            res = 0;
            project.remove(project.size()-1);
        }
        System.out.println(people);
    }
    static int res = 0;
    static List<HashMap<Integer, Integer>> project = new ArrayList<>();
    static int[] money = {1, 3, 7, 11, 13};
    public static void solution(int[] num, int X){
        HashMap<Integer, Integer> tmp= new HashMap<>();
        dfs(num, X, tmp);
    }
    public static void dfs(int[] num, int target, HashMap<Integer, Integer> tmp){
        if(target == 0 && res==0){
            res++;
            project.add(new HashMap<>(tmp));
            return;
        }
        for (int i = num.length-1; i>=0; i--) {
            if(num[i]>0&&target-money[i]>=0){
                num[i]--;
                int count = tmp.getOrDefault(money[i], 0);
                tmp.put(money[i], count+1);
                dfs(num, target-money[i], tmp);
                num[i]++;
                if(count==0){
                    tmp.remove(money[i]);
                }else {
                    tmp.put(money[i], count);
                }
            }
        }
    }
}
