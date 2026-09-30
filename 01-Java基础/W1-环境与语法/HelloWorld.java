/**
 * W1 环境自检 —— 跑通它，说明你的 JDK + 命令行环境已经就绪。
 *
 * 编译运行：
 *   javac HelloWorld.java
 *   java HelloWorld
 *
 * 或者直接在 IDEA 里点绿色三角。
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, Java 25!");

        // 打印当前 JDK 版本，确认不是 JDK 8 的老环境
        System.out.println("JDK 版本: " + System.getProperty("java.version"));
        System.out.println("JVM 名称: " + System.getProperty("java.vm.name"));
        System.out.println("操作系统: " + System.getProperty("os.name"));
        System.out.println("默认字符集: " + java.nio.charset.Charset.defaultCharset());

        System.out.println();
        System.out.println("环境就绪，开始 W1 吧。");
    }
}