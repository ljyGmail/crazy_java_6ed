package org.crazy.ch06_oop_2.sec04_final_modifier;

class P_CacheImmutable {
    private static int MAX_SIZE = 10;

    // 使用数组来缓存已有的实例
    private static P_CacheImmutable[] cache
        = new P_CacheImmutable[MAX_SIZE];
    // 记录缓存的实例在缓存池中的位置，cache[pos-1]是最新缓存的实例
    private static int pos = 0;

    private final String name;

    private P_CacheImmutable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static P_CacheImmutable valueOf(String name) {
        // 遍历已缓存的对象
        for (var i = 0; i < MAX_SIZE; i++) {
            // 如果已有相同的实例，则直接返回该缓存的实例
            if (cache[i] != null
                    && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }

        // 如果缓存池已满
        if (pos == MAX_SIZE) {
            // 把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始位置
            cache[0] = new P_CacheImmutable(name);
            // 把pos设为1
            pos = 1;
        } else {
            // 把新创建的对象缓存起来，pos加1
            cache[pos++] = new P_CacheImmutable(name);
        }
        return cache[pos - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == P_CacheImmutable.class) {
            var ci = (P_CacheImmutable) obj;
            return name.equals(ci.getName());
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }
}

public class P_CacheImmutableTest {
    public static void main(String[] args) {
        var c1 = P_CacheImmutable.valueOf("hello");
        var c2 = P_CacheImmutable.valueOf("hello");
        // 下面的代码将输出true
        System.out.println(c1 == c2);
    }
}
