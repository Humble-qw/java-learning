import java.util.Scanner;

/**
 * 7-1 企鹅类的封装实现
 *
 * 封装三要素：
 *   1. 属性全部 private
 *   2. 提供 public getter / setter 作为唯一入口
 *   3. 校验逻辑写进 setter —— 这才是封装的精髓
 */
class Penguin {

    private String name;    // 宠物名字
    private int health;     // 健康值，0~100，超出按 60
    private int close;      // 亲密度，0~100，超出按 60
    private String sex;     // 性别，"雌" 或 "雄"

    public Penguin() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    /** 合法就存，不合法一律按 60 —— 任何地方改 health 都绕不过这里 */
    public void setHealth(int health) {
        this.health = (health >= 0 && health <= 100) ? health : 60;
    }

    public int getClose() {
        return close;
    }

    /** 规则同 health */
    public void setClose(int close) {
        this.close = (close >= 0 && close <= 100) ? close : 60;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("欢迎您来到宠物医院！");

        // 1. 名字
        System.out.print("请输入要领养宠物的名字：");
        String name = sc.next();
        System.out.println(name);

        // 2. 类型：1 = 企鹅，2 = 狗狗
        System.out.print("请选择要领养宠物的类型：");
        int type = sc.nextInt();
        System.out.println(type == 1 ? "企鹅" : "狗狗");

        // 3. 性别：1 = 雌性，2 = 雄性
        System.out.print("请选择宠物的性别：");
        int sexCode = sc.nextInt();
        String sex = (sexCode == 1) ? "雌" : "雄";
        System.out.println(sex);

        // 4. 健康值：交给 setter 校验，再回显校验后的值
        System.out.print("请输入宠物的健康值（0~100之间）：");
        Penguin penguin = new Penguin();
        penguin.setName(name);
        penguin.setSex(sex);
        penguin.setHealth(sc.nextInt());
        System.out.println(penguin.getHealth());

        // 5. 亲密度：同样交给 setter 校验
        System.out.print("请输入与宠物的亲密度（0~100之间）：");
        penguin.setClose(sc.nextInt());
        System.out.println(penguin.getClose());

        sc.close();
    }
}