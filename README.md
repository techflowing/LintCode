
主要内容为学习算法，刷 [LintCode](http://lintcode.com/) 过程的记录，很大程度上参考了 [九章算法](http://www.jiuzhang.com/solution/) 的代码和讲稿，非常感谢，同时也参考了一些其他教材和优质博客，尽量找出通俗易懂较为优质的AC代码。本人非专业ACMer，代码中如有不足，欢迎批评指正。当前仅有部分题解，持续更新中...

#### 项目地址
[GitHub](https://github.com/techflowing/LintCode)， 欢迎`Fork` or `Star`

#### 项目说明
为区分题目，类名称 `未遵循` Java 大驼峰命名规范，统一采用 `题目难度_编号_题目名称` 方式，如 `E_001_APlusB`

题目难度说明：

* N：入门    
* E：简单    
* M：中等    
* H：困难    
* S：超难

注释说明：

* 类注释：描述题目信息
* 方法注释：描述解题思路

代码示例：

```
/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 */
public class E_001_APlusB {

    public static void main(String[] args) {
        System.out.println(new E_001_APlusB().aplusb(10, 63));
    }

    /**
     * 异或运算又称为 不进位加法
     * a^b 表示为 a+b 后，该进位的地方不进位的结果
     * 然后考虑哪些地方需要进位，（a和b里都是1的位置）
     * a&b 表示a和b中都是1的位置，(a&b)<<1 既表示进位后的结果
     * 所以：a + b = (a ^ b) + (a & b << 1)
     * 在进位变为0的时候，表示运算结束
     */
    public int aplusb(int a, int b) {
        if (b == 0) {
            return a;
        }
        int noCarrySum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(noCarrySum, carry);
    }
}
```

