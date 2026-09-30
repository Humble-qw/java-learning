/* ================================================================
 * 7-1 企鹅类的封装实现 —— 全文注释版
 * ================================================================
 *
 * 【这道题到底在考什么？】
 * 考"封装"：把数据藏起来，只留一个受控制的入口去改它。
 *
 * 【先记住这个类比】
 * 把 Penguin 想成一台自动售货机：
 *   1. 里面的货你伸手拿不到          → 属性用 private
 *   2. 只能通过投币口和按钮操作       → 提供 public 的 get/set 方法
 *   3. 你投假币，机器不收            → 校验逻辑写在 setter 里
 *
 * 【程序的整体流程】
 *   读输入 → 创建企鹅对象 → 把数据塞给它（过程中自动校验）→ 打印结果
 * ================================================================ */

// import：导入。Scanner 是 Java 自带的"键盘读取工具"。
// 不写这一行，后面就没法用 Scanner。
import java.util.Scanner;

/**
 * 企鹅类。
 * "类"是图纸、是模板，不是某一只具体的企鹅。
 * 用这张图纸 new 出来的，才是真实存在的一只企鹅（叫"对象"）。
 */
class Penguin {

    /* ========== 第一步：属性私有化 ==========
     * private = 私有的，只有 Penguin 内部能碰，外面一律访问不到。
     *
     * 如果写成 public，别人可以这样干：
     *      penguin.health = 99999;   // 校验形同虚设
     * 所以必须私有，这是"封装"的第一步：把数据藏起来。
     */

    private String name;   // 名字。String = 字符串类型，可以存 "qwe"
    private int health;    // 健康值。int = 整数类型
    private int close;     // 亲密度。（close 在 Java 里不是关键字，可以当变量名用）
    private String sex;    // 性别，存 "雌" 或 "雄"

    /* ========== 第二步：无参构造方法 ==========
     * 构造方法：new 的时候自动执行，用来初始化对象。
     * 三个硬性规则：
     *   1. 名字必须和类名完全一样
     *   2. 没有返回值类型（连 void 都不写）
     *   3. 不能手动调用，只能被 new 触发
     *
     * 这里写成空的，意思是"先造一只空壳企鹅，属性待会儿再塞"。
     *
     * 补充知识：如果你一个构造方法都不写，Java 会自动白送你一个空的。
     *          但只要你写了带参数的构造方法，白送的这个就没了，所以这里显式写出来。
     */
    public Penguin() {
    }

    /* ========== 第三步：getter / setter ==========
     * 属性私有了，外面怎么读写？靠这两类方法。
     *   getter：读（get + 属性名，首字母大写）
     *   setter：写（set + 属性名，首字母大写）
     * 这是 Java 的命名惯例（叫 JavaBean 规范），名字必须这么写。
     */

    /** 读取名字 */
    public String getName() {
        return name;        // return：把值交回给调用者
    }

    /** 设置名字 */
    public void setName(String name) {
        // this.name 指"这个对象自己的 name 属性"
        // 后面那个 name 指"传进来的参数"
        // 两者同名，必须用 this 区分。
        // 如果只写 name = name，那就是参数给自己赋值，等于什么都没做！
        this.name = name;
    }

    /** 读取健康值 */
    public int getHealth() {
        return health;
    }

    /**
     * 设置健康值 —— 这是本题最重要的一个方法，10 分里的大头在这里。
     *
     * 规则：合法范围 0~100（0 和 100 都算合法），超出范围一律按 60。
     *
     * 【为什么校验写在这里，而不是写在 main 里？】
     *   写在 main 里：只能保护那一次调用，别的地方照样能乱改。
     *   写在 setter 里：以后任何地方想改 health，都必须经过这个方法，绕不过去。
     *   —— 这就是"封装"的真正价值。
     */
    public void setHealth(int health) {
        // 这一行用的是"三元运算符"，格式是：  条件 ? 条件成立时的值 : 条件不成立时的值
        // 上面这行完全等价于下面这段 if-else：
        //
        //     if (health >= 0 && health <= 100) {
        //         this.health = health;
        //     } else {
        //         this.health = 60;
        //     }
        //
        // && 是"并且"，两个条件都为真才算真。
        this.health = (health >= 0 && health <= 100) ? health : 60;
    }

    /** 读取亲密度 */
    public int getClose() {
        return close;
    }

    /** 设置亲密度，校验规则和健康值完全一样 */
    public void setClose(int close) {
        this.close = (close >= 0 && close <= 100) ? close : 60;
    }

    /** 读取性别 */
    public String getSex() {
        return sex;
    }

    /** 设置性别 */
    public void setSex(String sex) {
        this.sex = sex;
    }
}

/**
 * 主类。程序从这里开始跑。
 * 注意：Java 规定，一个 .java 文件里最多只能有一个 public 类，
 *      而且文件名必须和这个 public 类的名字一样。
 *      所以这个文件必须叫 Main.java，叫 Penguin.java 会编译报错。
 */
public class Main {

    /**
     * main 方法：程序的唯一入口。JVM 从这里开始执行。
     *
     * 这一串修饰符逐个拆开看：
     *   public    —— 公开的，JVM 要能从外面调用它
     *   static    —— 静态的。JVM 调用它的时候，还没创建 Main 对象，
     *                所以它必须是静态的，否则 JVM 找不到它
     *   void      —— 不返回任何值
     *   String[] args —— 命令行参数，本题用不到，但格式必须这么写
     */
    public static void main(String[] args) {

        // 创建一个 Scanner 对象。
        // System.in 表示"标准输入"，也就是键盘（判题系统里则是测试数据）。
        // 简单说：造一个能读键盘的工具，起名叫 sc。
        Scanner sc = new Scanner(System.in);

        // println = print line，打印完自动换行
        System.out.println("欢迎您来到宠物医院！");

        /* ---------------- 第 1 步：读名字 ----------------
         * 关键区别：
         *   System.out.print   —— 打印完【不换行】，光标停在冒号后面
         *   System.out.println —— 打印完【自动换行】
         *
         * 这里用 print，是为了让紧接着打印的值出现在同一行：
         *   请输入要领养宠物的名字：qwe
         */
        System.out.print("请输入要领养宠物的名字：");

        // sc.next() ：读取一个"不含空格的字符串"
        String name = sc.next();

        // 把读到的名字打印出来 + 换行
        System.out.println(name);

        /* ---------------- 第 2 步：读类型 ----------------
         * 输入的是数字 1 或 2，但要求输出中文"企鹅"或"狗狗"，
         * 所以要做一次"翻译"（映射）。
         */
        System.out.print("请选择要领养宠物的类型：");

        // sc.nextInt() ：读取一个整数
        int type = sc.nextInt();

        // 三元运算符：type 等于 1 就输出"企鹅"，否则输出"狗狗"
        System.out.println(type == 1 ? "企鹅" : "狗狗");

        /* ---------------- 第 3 步：读性别 ----------------
         * 【本题最容易出错的地方，重点看】
         *
         * 输入是数字 1/2，但 setSex() 要的是 String（字符串）。
         * 所以要分两步走：
         *   先读成 int，再翻译成 String
         *
         * ❌ 错误写法（会报"不兼容的类型: int 无法转换为 String"）：
         *        int sex = sc.nextInt();
         *        penguin.setSex(sex);
         */
        System.out.print("请选择宠物的性别：");
        int sexCode = sc.nextInt();                    // 第一步：读成整数
        String sex = (sexCode == 1) ? "雌" : "雄";      // 第二步：翻译成字符串
        System.out.println(sex);

        /* ---------------- 第 4 步：读健康值 ----------------
         * 【本题第二容易出错的地方，重点看】
         *
         * 样例输入的健康值是 23，输出也是 23 —— 看起来像"原样打印"。
         * 但样例输入的最后一行是 567，输出却是 60！
         *
         * 这说明：这个值【不是键盘回显，而是程序打印出来的校验后的结果】。
         * 所以流程必须是：
         *   打印提示（不换行） → 读入 → 交给 setter 校验 → 打印校验后的值
         */
        System.out.print("请输入宠物的健康值（0~100之间）：");

        // new Penguin() ：按图纸造一只真实的企鹅（对象），起名叫 penguin
        // 注意顺序：必须先 new 出来，才能调用它的方法。
        // 如果先写 penguin.setSex(...) 再 new，会报"找不到符号"。
        Penguin penguin = new Penguin();

        penguin.setName(name);          // 把名字塞进去
        penguin.setSex(sex);            // 把性别塞进去（String 对 String，类型匹配）

        // 读入健康值并【直接交给 setter】。
        // 注意：这里没有先用变量接住，而是把 sc.nextInt() 的结果直接当参数传进去，
        //      校验全在 setter 内部完成。
        penguin.setHealth(sc.nextInt());

        // 打印【校验后】的值。567 在这里会变成 60。
        // 注意是 getHealth()，不是直接读 health —— 因为属性是 private，外面读不到。
        System.out.println(penguin.getHealth());

        /* ---------------- 第 5 步：读亲密度 ----------------
         * 逻辑和第 4 步完全一样：读入 → setter 校验 → 打印校验后的值。
         */
        System.out.print("请输入与宠物的亲密度（0~100之间）：");
        penguin.setClose(sc.nextInt());
        System.out.println(penguin.getClose());

        // 关闭 Scanner，释放它占用的输入流资源。
        // 本题不写也能过，但养成好习惯。
        sc.close();
    }
}