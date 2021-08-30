    package com.yang.project;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;

    public class Main3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            int n = Integer.parseInt(s.substring(2));

            char[][] c = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = '.';
                }
            }
            solution(c);
            System.out.println(Arrays.toString(res.toArray()));
        }
        static List<List<String>> res = new ArrayList<>();
        public static void solution(char[][] c){
            dfs(c, 0);
        }
        public static void dfs(char[][] c, int r){
            if(r == c.length){
                List<String> list = new ArrayList<>();
                for (int i = 0; i < c.length; i++) {
                    list.add(new String(c[i]));
                }
                res.add(list);
            }
            for (int i = 0; i < c[0].length; i++) {
                if(isvalid(c, r, i)){
                    c[r][i] = 'Q';
                    dfs(c, r+1);
                    c[r][i] = '.';
                }
            }
        }

        public static boolean isvalid(char[][] c, int x, int y){
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    if(c[i][j] == 'Q' && (j==y||Math.abs(x-i) == Math.abs(y-j))){
                        return false;
                    }
                }
            }
            return true;
        }
    }
