package com.yang.project;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int l = n*(n-1)/2;
        List<List<Integer>> inp = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(in.nextInt());
            list.add(in.nextInt());
            list.add(in.nextInt());
            inp.add(list);
        }
        Collections.sort(inp, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });
        System.out.println(inp);
        System.out.println(solution(inp, n, c));
    }
    public static int solution(List<List<Integer>> inp, int n, int c){
        int ans = 0;
        int[] par = new int[n+1];
        for (int i = 0; i <= n; i++) {
            par[i] = i;
        }
        for(List<Integer> x : inp){
            int fr = x.get(0);
            int to = x.get(1);
            int par_fr = find(fr, par);
            int par_to = find(to, par);
            if(par_fr != par_to){
                ans += x.get(2);
                par[par_fr] = par_to;
            }
        }
        return ans * c;
    }
    public static int find(int x, int[] par){
        return par[x] == x ? x : (par[x] = find(par[x], par));
    }
}
