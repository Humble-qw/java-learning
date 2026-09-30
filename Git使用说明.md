# Git 使用说明（零基础版）

> 仓库位置：`D:\Java学习` ｜ 你的 Git 版本：2.55.0（装在 `D:\Git`）
> 这份文档解决一个问题：**怎么让你的代码变成面试时能拿出手的证据。**

---

## 1. Git 是什么

**Git = 代码的存档系统**，跟游戏存进度一个道理。

- 写完一个练习 → **存档一次**（叫一次 commit）
- 写崩了想回到昨天能跑的状态 → **读档**
- 三个月后想知道"这功能我什么时候写的" → **翻存档记录**

每个存档点会记住：**改了什么、什么时候改的、你写的说明**。这就是它比"文件夹复制粘贴备份"强的地方。

---

## 2. 一次性配置（只做一次，做完永久生效）

打开 PowerShell，复制粘贴执行：

```powershell
git config --global user.name "你的名字"
git config --global user.email "你的邮箱@example.com"
git config --global init.defaultBranch main
git config --global core.quotepath false
```

- 前两行：每次存档都会盖上你的名字，**必须和 GitHub 账号一致**
- 第三行：新仓库默认分支叫 `main`（GitHub 现在都用这个）
- 第四行：让中文文件名正常显示，不然会显示成 `\344\270\255\346\226\207`

检查是否配好：

```powershell
git config --global --list
```

---

## 3. 日常三步曲（90% 的时间只用这三条）

```powershell
cd D:\Java学习
git add .
git commit -m "feat(W1): 完成 BMI 计算器"
git push
```

逐条解释：

| 命令 | 干什么 | 打比方 |
|---|---|---|
| `git add .` | 把改动的**所有文件**放进"待存档篮子" | 把要保存的东西挑进箱子 |
| `git commit -m "..."` | 把这一箱打成**一个存档点** | 封箱、贴标签、存进本地仓库 |
| `git push` | 把本地存档**上传到 GitHub** | 把箱子寄到云端 |

> ⚠️ **只 commit 不 push，东西只在你自己电脑上。** 想看 GitHub 的绿色格子、想给面试官链接，就必须 push。

**为什么中间要分 `add` 和 `commit` 两步？** 因为 Git 允许挑着存——你同时改了 3 个文件，但只有 2 个写完了，可以先把这 2 个存起来。入门阶段你总是一起存，记住连用就行。

---

## 4. 提交信息怎么写（面试官真的会看）

格式：`类型(范围): 做了什么`

**类型**（记住前 4 个就够）：

| 类型 | 什么时候用 |
|---|---|
| `feat` | 新增功能 / 完成一个练习 |
| `fix` | 修好了一个 bug |
| `docs` | 只改了文档、笔记、注释 |
| `refactor` | 重构，功能没变但代码变好了 |
| `chore` | 杂事，比如初始化仓库、改配置 |

**范围**就是第几周，写 `W1`～`W30`。

**✅ 好的例子：**

```
feat(W1): 完成 BMI 计算器
feat(W1): 单位换算器（长度/温度/重量）
fix(W1): 修正 BMI 计算的小数点精度问题
docs(W1): 补充 W1 学习笔记与踩坑记录
refactor(W5): 用 Stream 重写词频统计
```

**❌ 坏的例子：**

```
更新          ← 更新了什么？
提交          ← 等于没说
aaa           ← 三周后你自己都看不懂
完成作业       ← 哪个作业？做了什么？
```

**判断标准**：半年后你翻记录，能不能只看这一行就想起当时做了什么。能，就是好信息。

`fix` 那一条特别值钱——它证明你**真的动手写了并且真的 debug 过**，这是面试官最想看到的证据。

---

## 5. 命令速查表

```powershell
# 看当前状态（最常用，随时可以敲）
git status

# 看改动了哪几行
git diff

# 看历史记录（一行一条，清爽）
git log --oneline

# 看历史记录（带图形，能看出分支）
git log --oneline --graph --all

# 看某个存档点具体改了什么
git show a3f9c21

# 把某个文件从"待存档篮子"里拿出来（不想提交它）
git restore --staged 文件名

# 撤销对某个文件的修改（危险！改动会没）
git restore 文件名

# 查看所有分支
git branch
```

---

## 6. 写崩了怎么救（重点）

### 情况 1：还没 commit，想扔掉所有改动

```powershell
git restore .
```

⚠️ 改动**永久消失**，谨慎用。

### 情况 2：已经 commit 了，想撤销这次提交但保留代码

```powershell
git reset --soft HEAD~1
```

代码还在，"存档点"退回去了，可以重新提交。**这是最安全的撤销方式。**

### 情况 3：想看昨天那个能跑的版本长什么样

```powershell
git log --oneline          # 找到那个版本的编号，比如 7b2e4d8
git show 7b2e4d8           # 看它改了什么
git checkout 7b2e4d8       # 切到那个版本看代码
git checkout main          # 看完切回来
```

### 情况 4：改乱了想整个回到最后一次提交的状态

```powershell
git reset --hard HEAD
```

⚠️ **所有未提交的改动全没**，只在"我彻底搞砸了、什么都不要了"时用。

---

## 7. 关联 GitHub（首次，只做一次）

1. 注册 https://github.com/
2. 网页右上角 **+** → **New repository**
3. 仓库名填 `java-learning`，**选 Public**（私有仓库面试官看不到，绿色格子也不算数）
4. **不要**勾选 "Add a README file"（你本地已经有了，勾了会冲突）
5. 创建后，在本地执行（把 `你的用户名` 换成实际的）：

```powershell
cd D:\Java学习
git init
git add .
git commit -m "chore: 初始化 Java 学习仓库"
git branch -M main
git remote add origin https://github.com/你的用户名/java-learning.git
git push -u origin main
```

第一次 push 会弹出浏览器让你登录 GitHub 授权，按提示走完就行。

之后每天只要 `git add . && git commit -m "..." && git push` 三条。

---

## 8. 每天的学习工作流

```powershell
# 1. 开始学习前，先拉一下（如果你在多台电脑上写）
git pull

# 2. 学完一个练习，存一次档
git add .
git commit -m "feat(W3): 完成静态变量计数器练习"
git push

# 3. 一天结束时看一眼今天的成果
git log --oneline --since="1 day ago"
```

**节奏建议**：不用攒到晚上。**做完一个练习就提交一次**，一天提交 3–5 次很正常。

---

## 9. 常见错误与解决

| 报错 | 原因 | 解决 |
|---|---|---|
| `not a git repository` | 当前目录不是仓库 | 先 `cd D:\Java学习` |
| `please tell me who you are` | 没配用户名邮箱 | 回到第 2 节配置 |
| `failed to push some refs` | GitHub 上有你本地没有的提交 | 先 `git pull --rebase` 再 push |
| `src refspec main does not match any` | 一次都没 commit 过 | 先 `git add . && git commit -m "..."` |
| `Authentication failed` | GitHub 不再支持密码 | 用浏览器授权，或配 SSH key |
| 中文文件名显示成 `\344\270\255` | 没开 quotepath | `git config --global core.quotepath false` |

### ⚠️ 不小心把密码/密钥提交上去了怎么办

**第一件事：立刻去把那个密码改掉**——GitHub 上公开仓库几分钟内就会被爬虫扫到，改密码比删记录重要得多。

然后：

```powershell
git rm --cached 泄露的文件名
# 把该文件加进 .gitignore
git commit -m "fix: 移除误提交的敏感配置"
git push
```

注意 `--cached` 只从 Git 里移除，**本地文件还在**。

---

## 10. ⚠️ 千万别提交的东西

仓库里已经有 `.gitignore` 帮你挡掉大部分了，你要做的是**别强行加进去**：

| 不要提交 | 为什么 |
|---|---|
| `.idea/`、`*.iml` | 你自己电脑的 IDE 配置，别人用不上（**已经有例外**：如果某个项目你想保留配置，单独处理） |
| `target/`、`out/`、`*.class` | 编译产物，每次重新生成，提交了纯占地方 |
| `application-local.yml` | 通常含数据库密码 |
| `*.env`、密钥文件 | 同上，最危险 |
| 几十 MB 的视频/资料 | GitHub 单文件超 100MB 会被拒，仓库也会变得很卡 |

---

## 11. 这份说明最该记住的一句话

> **到 W30，`git log --oneline` 拉出来的那几百行，就是你自学 7 个月最硬的证据。**

面试官问"你怎么证明你会写代码"，你直接把 GitHub 链接发过去。
他能看到你从 `feat(W1): HelloWorld` 一路写到 `feat(W27): 微服务拆分与网关鉴权`，时间戳连续 7 个月，从没断过。

**这个东西，学历证明不了，证书证明不了，嘴也证明不了。**