由于路径的方向只能是向下或向右，因此网格的第一行的每个元素只能从左上角元素开始向右移动到达，网格的第一列的每个元素只能从左上角元素开始向下移动到达，此时的路径是唯一的，因此每个元素对应的最小路径和即为对应的路径上的数字总和。
对于不在第一行和第一列的元素，可以从其上方相邻元素向下移动一步到达，或者从其左方相邻元素向右移动一步到达，元素对应的最小路径和等于其上方相邻元素与其左方相邻元素两者对应的最小路径和中的最小值加上当前元素的值。由于每个元素对应的最小路径和与其相邻元素对应的最小路径和有关，因此可以使用动态规划求解。
创建二维数组 \textit{dp}dp，与原始网格的大小相同，\textit{dp}[i][j]dp[i][j] 表示从左上角出发到 (i,j)(i,j) 位置的最小路径和。显然，\textit{dp}[0][0]=\textit{grid}[0][0]dp[0][0]=grid[0][0]。对于 \textit{dp}dp 中的其余元素，通过以下状态转移方程计算元素值。
当 i>0i>0 且 j=0j=0 时，\textit{dp}[i][0]=\textit{dp}[i-1][0]+\textit{grid}[i][0]dp[i][0]=dp[i−1][0]+grid[i][0]。
当 i=0i=0 且 j>0j>0 时，\textit{dp}[0][j]=\textit{dp}[0][j-1]+\textit{grid}[0][j]dp[0][j]=dp[0][j−1]+grid[0][j]。
当 i>0i>0 且 j>0j>0 时，\textit{dp}[i][j]=\min(\textit{dp}[i-1][j],\textit{dp}[i][j-1])+\textit{grid}[i][j]dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
最后得到 \textit{dp}[m-1][n-1]dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和



最大正方形:
想了五分钟,没有想出解决办法来，直接看题解
只包含1，是一个重要的关键词
--要是自己想，真是不容易能想出来
如果该位置的值是 0，则{dp}(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；
如果该位置的值是 1，则{dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的{dp}dp
值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
该位置的值是 0的情况，dp值不累计，直接写
这个题难就难在写转移方程

621. 任务调度器  -- 看不懂题目
--这个公式不好推
一共占用的方格即为完成所有任务需要的时间：(maxTimes−1)∗(n+1)+maxCount
maxTimes为出现次数最多的那个任务出现的次数。maxCount为一共有多少个任务
和出现最多的那个任务出现次数一样
        //将出现的字符数字化，这样就可以进行计数了
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i] - 'A']++;
        }
        //进行排序后得出maxTime，太巧妙了
        Arrays.sort(buckets);
        int maxTimes = buckets[25];

--回文子串 视频讲解还有点模糊的印象
--如果s[i] == s[j]s[i]==s[j]那么说明只要dp[i+1][j-1]dp[i+1][j−1]是回文子串，那么是dp[i][j]dp[i][j]也就是回文子串
 dp[i][j] = dp[i+1][j-1]

 Manacher 算法 在线性时间内求解最长回文子串
 在所有的相邻字符中间插入 \##，比如 abaaabaa
 会被处理成 \#a\#b\#a\#a\##a#b#a#a#
 用  f(i) 来表示以 s 的第 i位为回文中心
 这个方法太复杂了，还是动态规划简单，但是动态规划是
 O（n^2）的时间复杂度
 而Manacher是O（n）的时间复杂度
 --这句话不好理解
  if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {

  首先这一题可以使用动态规划来进行解决：

  状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
  状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
  这个状态转移方程是什么意思呢？

  当只有一个字符时，比如 a 自然是一个回文串。
  当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
  当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，也就是 bab 记作串 2，可以看出只要串2是一个回文串，那么左右各多了一个 a 的串 1 必定也是回文串。所以当 s[i]==s[j] 时，自然要看 dp[i+1][j-1] 是不是一个回文串。
  

//这段代码比想象中要简洁
     public int countSubstrings(String s) {
         boolean[][] dp =new boolean[s.length()][s.length()];
         int ans = 0;
         for (int i = 0; i < s.length(); i++) {
             for (int j = 0; j <= i ; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    ans ++;
                }
             }
         }
         return ans;
     }

--最长有效括号   这个题难道不是用栈来解决吗
用动态规划的方法确实很难，难在状态转移方程 
（）（）
字符串最后一个字符i是"("，则去掉最后一个字符，字符串长度减一
字符串最后一个字符i是）
--第i-1个字符是（，则字符串减2，有效括号长度count += 2
--第i-1个字符是），则去掉最后两个字符，字符串长度减二
状态转移方程 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度
没有想到这个：dp[i]=dp[i−2]+2
--最后一位是'('则不考虑
if (s.charAt(i) == ')') {

--后四位是（）））的情况
 } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {


        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }




关键点：
       动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
       共性：找到重复子问题
       差异性：最优子结构、中途可以淘汰次优解
斐波拉契：记忆化搜索，增加一个缓存
          if (memo[0] = 0) {
               memo[n] = fib (n - 1) + fib (n - 2);
          }
          return memo[0];
养成习惯，不用人肉递归，要用归纳法的思想

动态规划关键点
1.最优子结构 opt[n]=best_of(opt[n-1],opt[n-2],...)
2.储存中间状态：opt[i]
3.递推公式（状态转移方程或DP方程）
Fib:opt[i] = opt[n-1] + opt[n-2]
二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1](且判断a[i,j]是否为空地)

动态规划小结：
    1.打破自己的思维习惯，形成机器思维
        机器思维就是找重复性
    2.理解复杂逻辑的关键
    3.也是职业进阶的要点要领
 
 人肉递归的思维方式，纯凭感觉得出结果，这种方式的危险就在于从数学上不严谨，
而且在逻辑上，很难找到它的自相似性（有重复性），给出最后正确的解决方法，类似于拿捏火候看
经验等方法，在用计算机解决问题的话是要杜绝的，在写的时候，一定要转换成机器思维,
进行化繁为简，同时逻辑上是简洁的，且能够严谨来证明。

能让人拔高的一定不是大路货的知识















在第四周学习前，先把常用的IDEA快捷键练熟了，这些键太多了，每天练一点
--Alt+Up/Down，在方法间快速移动定位。(非常好用，怎么就想不到这么去做呢
开发的时候，只是固定思维去使用哪些最基本的简单方法)
--Ctrl+E，最近的文件
--Shift+Enter，向下插入新行。（不省去把光标移动到行尾的步骤）
--Ctrl+Shift+U，大小写转化。（常用且实用）
--Ctrl+Alt+Shift+S，打开当前项目/模块属性。（实用，常用，打开project structure） 
--Ctrl+Alt+S，打开设置对话框。（常用，实用）
--F12，把焦点从编辑器移到最近使用的工具窗口。(实用，还不够理解)
--Ctrl+W，可以选择单词继而语句继而行继而函数。(不错，很强大)
--Ctrl+[ OR ]，可以跑到大括号的开头与结尾。
--Ctrl+F12，可以显示当前文件的结构。(用的较少，和outline是一回事吧)
--Ctrl+F7，可以查询当前元素在当前文件中的引用，然后按 F3 可以选择。
（省去了双击选择，和Ctrl + F）
--Ctrl+N，可以快速打开类。(常用，有点忘了)
--Ctrl+Shift+N，可以快速打开文件 （和上一个差不多）
--Ctrl+Shift+C，复制路径。（非常实用，非常常用）                 
--Ctrl+Alt+Shift+C，复制引用，必须选择类名。(和上面相比，复制的内容短了点) 
--Alt+Q，可以看到当前方法的声明。 (感觉很鸡肋，这个作用是什么，在方法长的时候能
看到第一行是什么？，不知道用在什么地方)
--Ctrl+Shift+Insert，可以选择剪贴板内容并插入。(这个应该会有用的)
和Ctrl+Shift+V 是一个效果
--Alt+Insert，可以生成构造器/Getter/Setter等。(不限于此)
--这个最常用
--Ctrl+Alt+V，可以引入变量。例如：new String(); 自动导入变量定义。（这个常用）
--Ctrl+Alt+T，可以把代码包在一个块内，例如：try/catch。 （太节约时间了，自动生成真快）
--Alt+Enter，导入包，自动修正。（有红线时常提示）
--Ctrl+R，替换文本。(这个常用，和eclipse有点不一样 R:replace)
--Ctrl+Shift+Space，自动补全代码。(这是设置快捷代码的，和Oracle开发工具差不多。好像有点用,不知道什么情况下使用)
--Ctrl+Shift+Alt+N，查找类中的方法或变量。（更大范围内的Ctrl + F）
--Alt+Shift+Up/Down，上/下移一行。（这个不错，要练熟练）
--Ctrl+D，复制行。(非常便捷，相当于复制和粘贴加一起，少去了复制+ enter)
--Ctrl+X，删除行。
--Ctrl+Alt+J，用动态模板环绕。
--Ctrl+Backspace，按单词删除。    
--Ctrl+H，显示类结构图（类的继承层次）。
--Alt+F11 查找代码所在位置。(无效，不知道具体的用处是什么,把project对话框弄出来了)
--Alt+1，快速打开或隐藏工程面板。(这个不错，经常找不到project)
--Alt+left/right，切换代码视图。(不错，可以省去使用鼠标的时间)

--Ctrl+Shift+Up/Down，向上/下移动语句。（上面不是有了？）
--F2 或 Shift+F2，高亮错误或警告快速定位。（不错,找错误的时候会非常快）
--Ctrl+Shift+F7，高亮显示所有该文本，按 Esc 高亮消失。 （不实用，下行功能相同 ）
--Alt+F3，逐个往下查找相同文本，并高亮显示。（实用）
--Ctrl+Shift+Backspace，跳转到上次编辑的地方。(不错，会有用)
--Ctrl+Alt+Space，类名自动完成。(不知道是什么意思)
--Ctrl+Shift+J，整合两行。（J：join）
--Ctrl+Shift+V，可以将最近使用的剪贴板内容选择插入到文本。
--Windows: Ctrl + G  快速定位到某一行
    
--Ctrl+Shift+W，取消选择光标所在词。（可以和ctrl + shift + left or right 结合使用）    
Ctrl+J，查看更多。（查看更多什么？）
Alt+F1，1(定位文件)
--Ctrl+F，查找/Shift+F3，向上查找/F3，向下查找。（上面不是已经出现过了？）
--Alt+Home，跳转到导航栏。（一般想不到这么用）
--Ctrl+Enter，上插一行。（光标必须在行首才行）
Ctrl+”+/-”，当前方法展开、折叠。（不错）
Ctrl+Shift+”+/-”，全部展开、折叠。（不错，这么好的快捷键，居然刚发现，19年也只是
把所有的快捷键打印下来了，但是没有做任何行动，这次必须把所有的快捷键练熟悉）
--Ctrl+Alt+O，优化导入的类和包。(估计会有用)
--Ctrl+Alt+left/right，返回至上次浏览的位置。(常用且很熟悉)
--Alt+Shift+C，最近的更改。（这个功能不实用）
--Alt+F7，查找整个工程中使用地某一个类、方法或者变量的位置。(可以)
Ctrl+I，实现方法。（不确定怎么用）
--Ctrl+U，转到父类。（不错，实际应该用得少）
------------调试部分、编译---------

--Ctrl+F2，停止 （非常好用）。
--Alt+Shift+F9，选择 Debug。（高效）
--Alt+Shift+F10，选择 Run。（高效）
--Ctrl+Shift+F9，编译。（不错，可省事）
--Ctrl+Shift+F8，查看断点。（不过，可省事）
----遇到复杂的再试----------------------
--Shift+F7，智能步入。 一行代码里有好几个方法，怎么只选择某一个方法进入
很强大，没想到，还能这么用
--Shift+F8，步出。
--Alt+Shift+F8，强制步过。  
--Alt+Shift+F7，强制步入。 当调用了一个类库方法时候，强制进入会进入到该类库的方法里面
--------------------------
--Alt+F9，运行至光标处。（不错，不用一步步走了，直接定位）
--Ctrl+Alt+F9，强制运行至光标处。
--F9，恢复程序。
Alt+F10，定位到断点。 （不知道怎么使用）
Ctrl+F8，切换行断点。   （不知道怎么使用）
Ctrl+F9，生成项目。（和编译有什么区别？）
--Alt+1，项目。（隐藏左边框）
--Alt+2，收藏。（很少用）
--Alt+6，TODO。（查找TODO）
--Alt+7，结构。
Ctrl+Alt+Y，同步。 （这是同步什么?）
Ctrl+~，快速切换方案（界面外观、代码风格、快捷键映射等菜单）。(也比较实用)
Shift+F12，还原默认布局。（没什么用）
Ctrl+Shift+F12，隐藏/恢复所有窗口。（不知道有什么用）
Ctrl+F4，关闭。（不用鼠标了）
Ctrl+Shift+F4，关闭活动选项卡。（也不知道关闭的是什么）
Ctrl+Tab，转到下一个拆分器。
Ctrl+Shift+Tab，转到上一个拆分器。（这个不错，不怕找不到run的console了）

--------重构---------------

--Ctrl+Alt+Shift+T，弹出重构菜单。 (用过，忘了，这个可以提升效率)
--Shift+F6，重命名。（这个修改后应该是可以把引用的地方也改了，这样又省去很多时间）
--F6，移动。（不错，更快捷）
--F5，复制。（不错，更快捷）
Alt+Delete，安全删除。（意思是是没有删干净？什么情况下使用？）
--Ctrl+Alt+N，内联。（不知什么用处）
查找
--Ctrl+F，查找。
--Ctrl+R，替换。
--F3，查找下一个。
--Shift+F3，查找上一个。
--Ctrl+Shift+F，在路径中查找。
--Ctrl+Shift+R，在路径中替换。(已熟练掌握)
Ctrl+Shift+S，搜索结构。（无效）
Ctrl+Shift+M，替换结构。（无效）
--Alt+F7，查找用法。（无效）   
--Ctrl+Alt+F7，显示用法。（无效）   
--Ctrl+F7，在文件中查找用法.（无效）   
对于高级别的人来说，业务能力和管理能力都是创造价值的核心能力。
如果你不懂业务和管理，职场天花板就会很低，很难晋升到比较高的级别。

Remember these Shortcuts

Smart code completion Ctrl + Shift + Space
Search everywhere Double Shift 
Show intention actions and quick-fixes Alt + Enter 
Generate code Alt + Ins
Parameter info Ctrl + P
Extend selection Ctrl + W
Shrink selection Ctrl + Shift + W
Recent files popup Ctrl + E
Rename Shift + F6Remember these Shortcuts
 Smart code completion Ctrl + Shift + Space
 Search everywhere Double Shift 
 Show intention actions and quick-fixes Alt + Enter 
 Generate code Alt + Ins
 Parameter info Ctrl + P
 Extend selection Ctrl + W
 Shrink selection Ctrl + Shift + W
 Recent files popup Ctrl + E
 Rename Shift + F6
 
 General
 Open corresponding tool window Alt + #[0-9]
 Save all Ctrl + S
 Synchronize Ctrl + Alt + Y
 Toggle maximizing editor Ctrl + Shift + F12
 Inspect current file with current profile Alt + Shift + I
 Quick switch current scheme Ctrl + BackQuote (`)
 Open Settings dialog Ctrl + Alt + S
 Open Project Structure dialog Ctrl + Alt + Shift + S
 Find Action Ctrl + Shift + A
 Debugging
 Step over / into F8 / F7
 Smart step into/Step out Shift + F7 / Shift + 
 F8
 Run to cursor Alt + F9
 Evaluate expression Alt + F8
 Resume program F9
 Toggle breakpoint Ctrl + F8
 View breakpoints Ctrl + Shift + F8
 Search / Replace
 Search everywhere Double Shift 
 Find Ctrl + F
 Find next /previous F3 / Shift + F3
 Replace Ctrl + R
 Find in path Ctrl + Shift + F
 Replace in path Ctrl + Shift + R
 Select next occurrence Alt + J
 Select all occurrences Ctrl + Alt + Shift + J
 Unselect occurrence Alt + Shift + J
 
 Editing
 Basic code completion Ctrl + Space
 Smart code completion Ctrl + Shift + Space
 Complete statement Ctrl + Shift + Enter
 Parameter info (within method call arguments) Ctrl + P
 Quick documentation lookup Ctrl + Q
 External Doc Shift + F1
 Brief Info Ctrl + mouse 
 Show descriptions of error at caret Ctrl + F1
 Generate code... Alt + Insert
 Override methods Ctrl + O 
 Implement methods Ctrl + I 
 Surround with…  Ctrl + Alt + T
 Comment /uncomment with line comment Ctrl + /
 Comment /uncomment with block comment Ctrl + Shift + /
 Extend selection Ctrl + W
 Shrink selection Ctrl + Shift + W
 Context info Alt + Q
 Show intention actions and quick-fixes Alt + Enter
 Reformat code Ctrl + Alt + L
 Optimize imports Ctrl + Alt + O
 Auto-indent line(s) Ctrl + Alt + I
 Indent /unindent selected lines Tab / Shift + Tab
 Cut current line to clipboard Ctrl + X , Shift + Delete
 Copy current line to clipboard Ctrl + C , Ctrl + Insert 
 Paste from clipboard Ctrl + V , Shift + Insert 
 Paste from recent buffers... Ctrl + Shift + V 
 Duplicate current line Ctrl + D
 Delete line at caret Ctrl + Y
 Smart line join Ctrl + Shift + J 
 Smart line split Ctrl + Enter
 Start new line Shift + Enter
 Toggle case for word at caret or selected block Ctrl + Shift + U
 Select till code block end / start Ctrl + Shift + ] / [
 Delete to word end Ctrl + Delete
 Delete to word start Ctrl + Backspace
 Expand/collapse code block Ctrl + NumPad+ / -
 Expand all Ctrl +  Shift + NumPad+
 Collapse all Ctrl + Shift + NumPadClose active editor tab Ctrl + F4
 Refactoring
 Copy F5
 Move F6
 Safe Delete Alt + Delete
 Rename Shift + F6
 Refactor this Ctrl + Alt + Shift + T
 Change Signature Ctrl + F6
 Inline Ctrl + Alt + N
 Extract Method Ctrl + Alt + M
 Extract Variable Ctrl + Alt + V
 Extract Field Ctrl + Alt + F
 Extract Constant Ctrl + Alt + C
 Extract Parameter Ctrl + Alt + P
 
 Navigation
 Go to class Ctrl + N
 Go to file Ctrl + Shift + N
 Go to symbol Ctrl + Alt + Shift + N
 Go to next /previous editor tab Alt + Right/Left
 Go back to previous tool window F12
 Go to editor (from tool window) Esc
 Hide active or last active window Shift + Esc
 Go to line Ctrl + G
 Recent files popup Ctrl + E
 Navigate back/ forward Ctrl + Alt + Left/Right
 Navigate to last edit location Ctrl + Shift + Backspace
 Select current file or symbol in any view Alt + F1
 Go to declaration Ctrl + B , Ctrl + Click
 Go to implementation(s) Ctrl + Alt + B
 Open quick definition lookup Ctrl + Shift + I
 Go to type declaration Ctrl + Shift + B
 Go to super-method/ super-class Ctrl + U
 Go to previous /next method Alt + Up/Down
 Move to code block end/ start Ctrl + ]/[
 File structure popup Ctrl + F12
 Type hierarchy Ctrl + H
 Method hierarchy Ctrl + Shift + H
 Call hierarchy Ctrl + Alt + H
 Next /previous highlighted error F2 / Shift + F2
 Edit source/View source F4 / Ctrl + Enter
 Show navigation bar Alt + Home
 Toggle bookmark F11
 Toggle bookmark with mnemonic Ctrl + F11
 Go to numbered bookmark Ctrl + #[0-9]
 Show bookmarks Shift + F11
 Compile and Run
 Make project Ctrl + F9
 Compile selected file, package or module Ctrl + Shift + F9
 Select configuration and run/debug Alt + Shift + F10/F9
 Run/Debug Shift + F10 / F9
 Run context configuration from editor Ctrl + Shift + F10
 Usage Search
 Find usages /Find usages in file Alt + F7 / Ctrl + F7
 Highlight usages in file Ctrl + Shift + F7
 Show usages Ctrl + Alt + F7
 VCS / Local History
 Commit project to VCS Ctrl + K
 Update project from VCS Ctrl + T
 Push commits Ctrl + Shift + K
 ‘VCS’ quick popup Alt + BackQuote (`)
 Live Templates
 Surround with Live Template Ctrl + Alt + J
 Insert Live Template Ctrl + J
 Remember these Shortcuts
 Smart code completion Ctrl + Shift + Space
 Search everywhere Double Shift 
 Show intention actions and quick-fixes Alt + Enter 
 Generate code Alt + Ins
 Parameter info Ctrl + P
 Extend selection Ctrl + W
 Shrink selection Ctrl + Shift + W
 Recent files popup Ctrl + E
 Rename Shift + F6
 DEFAULT KEYMAP
 —Productivity Boosters
 Remember these Shortcuts
 Navigation
 Go to class O
 Go to file O
 Go to symbol O
 Go to next /previous editor tab /
 Go back to previous tool window F12
 Go to editor (from tool window) 
 Hide active or last active window 
 Go to line L
 Recent files popup E
 Navigate back/ forward / 
 Navigate to last edit location 
 Select current file or symbol in any view F1
 Go to declaration B, Click
 Go to implementation(s) B
 Open quick definition lookup Space, Y
 Go to type declaration B
 Go to super-method/ super-class U
 Go to previous /next method / 
 Move to code block end/ start ] / [
 File structure popup F12
 Type hierarchy H
 Method hierarchy H
 Call hierarchy H
 Next /previous highlighted error F2 / F2
 Edit source/View source F4 / 
 Show navigation bar Home
 Toggle bookmark F3
 Toggle bookmark with mnemonic F3
 Go to numbered bookmark 0 ... 9
 Show bookmarks F3
 Compile and Run
 Make project F9
 Compile selected file, package or module F9
 Select configuration and run/debug R / D
 Run/Debug R / D
 Run context configuration from editor R, D
 Usage Search
 Find usages /Find usages in file F7 / F7
 Highlight usages in file F7
 Show usages F7
 VCS / Local History
 Commit project to VCS K
 Update project from VCS T
 Push commits K
 ‘VCS’ quick popup V
 Live Templates
 Surround with Live Template J
 Insert Live Template J

