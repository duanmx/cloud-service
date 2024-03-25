//package com.duan.commmon.core.utils;
//
//import com.sun.istack.internal.NotNull;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * String流的一些案例
// */
//public class StreamEx {
//
//    /**
//     * 【Stream方式】
//     * 从给定句子中返回单词长度大于5的单词列表，按长度倒序输出，最多返回3个
//     *
//     * @param sentence 给定的句子，约定非空，且单词之间仅由一个空格分隔
//     * @return 倒序输出符合条件的单词列表
//     */
//    public List<String> sortGetTop3LongWordsByStream(@NotNull String sentence) {
//
//
//        return Arrays.stream(sentence.split(" "))
//                .filter(word -> word.length() > 5)
//                .sorted((o1, o2) -> o2.length() - o1.length())
//                .limit(3)
//                .collect(Collectors.toList());
//    }
//
//
//    /**
//     * 演示map的用途：一对一转换
//     */
//    public void stringToIntMap() {
//        List<String> ids = Arrays.asList("205", "105", "308", "469", "627", "193", "111");
//        // 使用流操作
//        List<UserE> results = ids.stream()
//                .map(id -> {
//                    UserE user = new UserE();
//                    user.setId(id);
//                    return user;
//                })
//                .collect(Collectors.toList());
//
////        Map<String,UserE> map = ids.stream().map(Collectors.toMap(
////                s -> UserE::getId, s -> s,(k1,K2)->k1));\
//        Map<String, String> map = results.stream().collect(Collectors.toMap(UserE::getId, UserE::getName));
//
//        Map<String, UserE> appleMap = results.stream().
//                collect(Collectors.toMap(UserE::getId, a -> a,(k1, k2)->k1));
//
//        System.out.println(results);
//    }
//
//
//
//
//    public static void sort(){
//        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
//        //实际上，除了Lambda表达式，我们还可以直接传入方法引用。例如：
//        Arrays.sort(array, StreamEx::cmp);
//        System.out.println(String.join(", ", array));
//    }
//
//    /**
//     * 数组排序
//     * @param s1 s1
//     * @param s2 s2
//     * @return xxx
//     */
//    static int cmp(String s1, String s2) {
//        return s1.compareTo(s2);
//    }
//
//
//}
