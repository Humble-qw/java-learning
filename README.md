# Java 学习代码仓库

> 配合 `2026-Java零基础学习路线` 使用 · 每周 20–25 小时 · 30 周

## 这个文件夹是干什么的

**只放你自己敲的代码。** 视频课件的源码单独放，不要混进来——
这个仓库的价值在于它记录的**是你写出来的东西**，日后就是你 GitHub 上的绿色格子和面试时的作品集。

## 目录结构

```
01-Java基础/          W1–W6   语言基础（当前阶段）
02-进阶核心/          W7–W10  并发 / JVM / 网络 / 工程工具
03-数据库/            W11–W13 MySQL / 索引 / JDBC
04-Web与Spring/       W14–W18 Spring 全家桶
05-项目实战/          两个里程碑项目
06-工程化与中间件/     W21–W24 Redis / MQ / Docker / 可观测
07-微服务与云原生/     W25–W27 微服务 / K8s
08-算法练习/          力扣 / 牛客
09-学习笔记/          每周复盘
```

## 三条硬规矩

1. **看一集就敲一遍**，不要连看 5 集再练。
2. **每天至少提交一次**，commit message 用 `feat: xxx` / `fix: xxx` / `docs: xxx`。
3. **每个阶段结束时把成果写进 `09-学习笔记`**，300 字以上：学了什么 / 卡在哪 / 怎么解决 / 下周调整。

## 环境要求

- JDK **25 LTS**（不是 26、27——那两个是非 LTS 特性版）
- IntelliJ IDEA（社区版够用）
- Maven（W10 开始用）

检查环境：

```powershell
java -version      # 应输出 25.x
javac -version
```

## 怎么用 Git

```powershell
cd "D:\Java学习"
git init
git add .
git commit -m "chore: 初始化 Java 学习仓库"
```

之后每完成一个小练习就：

```powershell
git add .
git commit -m "feat(W1): 完成 BMI 计算器与单位换算器"
```

## 命名约定

- 每周一个文件夹，练习按 `练习01-描述` 命名，例如 `练习01-BMI计算器`
- 类名用大驼峰 `BmiCalculator`，包名全小写 `w1.grammar`
- 一个练习一个文件，别把所有代码堆进一个 `Main.java`