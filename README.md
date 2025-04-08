------

# 1. **数组与字符串**

## 常见题型：

- 数组遍历与操作（求最大/最小值、前缀和、滑动窗口）
- 排序与去重
- 双指针问题
- 子数组或子字符串问题

## 解题策略：

- **双指针法**：处理有序数组的合并、去重、寻找目标值等。
- **滑动窗口**：处理子数组或子字符串 的最大/最小长度问题。
- **哈希表**：用于快速查找是否存在某元素。
- **分治法**：如求最大子数组和等问题。

## 题目实例

### 滑动窗口 - **LeetCode 209 - Minimum Size Subarray Sum** 

给定一个正整数数组 `nums` 和一个正整数 `target`，请找出该数组中满足其和 **大于等于 `target` 的最小子数组的长度**。如果不存在符合条件的子数组，返回 `0`。

**示例**

输入：
`target = 7, nums = [2,3,1,2,4,3]`
输出：
`2`
解释：子数组 `[4,3]` 是该条件下的最小长度。

滑动窗口是一种用于解决子数组、子字符串等问题的经典方法。它通过维护一个动态窗口（数组的一部分）来找到符合条件的解。

**步骤：**

1. 使用两个指针 `left` 和 `right` 定义窗口的左右边界。
2. `right` 指针不断向右扩展窗口，同时累积子数组的和。
3. 当子数组的和 **大于等于 `target`** 时，记录当前子数组的长度，并尝试缩小窗口（移动 `left` 指针）以寻找更小的解。
4. 重复上述过程，直到 `right` 遍历完整个数组。
5. 如果未找到符合条件的子数组，返回 `0`。

## 问题集合

###滑动窗口和双指针的区别是什么？

**相同点**

1. **核心思想**：
   - 都通过两个指针操作，通常指针从一侧向另一侧移动。
   - 用于高效处理需要扫描数组或字符串的子数组、子字符串问题。
2. **时间复杂度**：
   - 两者一般都能将时间复杂度优化到 O(n)O(n)O(n)，因为每个指针最多移动一遍。
3. **主要目标**：
   - 在遍历数组的过程中动态调整指针的范围，寻找满足条件的解。





------

# 2. **链表**

## 常见题型：

- 链表的翻转（单链表、双链表）
- 链表的合并与分割
- 环形链表检测
- K个一组翻转链表

| 类型          | 关键词                     | 示例题目               |
| ------------- | -------------------------- | ---------------------- |
| ✅ 遍历类      | 单次遍历、双指针、快慢指针 | Leetcode 141、876      |
| ✅ 修改结构类  | 插入、删除、反转、合并     | Leetcode 21、92、25    |
| ✅ 检测结构类  | 环检测、交点、是否回文     | Leetcode 141、160、234 |
| ✅ 构造/复制类 | 深拷贝、加法、链表转树     | Leetcode 2、138、109   |
| ✅ 分段处理    | 分组反转、分区、拆分       | Leetcode 86、25、725   |
| ✅ 进阶结构    | 双向链表、随机指针、LRU    | Leetcode 146、138      |

## 解题策略：

- **快慢指针**：检测链表中是否有环或寻找中间节点。
- **递归**：解决链表翻转和合并。
- **哑结点技巧**：简化链表操作的边界情况处理。

| 策略                 | 说明                    | 适用场景                   |
| -------------------- | ----------------------- | -------------------------- |
| **虚拟头节点 dummy** | 避免头节点为空/特殊处理 | 插入、删除、合并类         |
| **快慢指针**         | 用于找中点/判断环       | 环检测、回文、找中点       |
| **双指针/滑动窗口**  | 控制节点间的相对关系    | 删除倒数第 N 个节点        |
| **递归反转**         | 借助递归栈处理反转      | 局部反转                   |
| **栈辅助**           | 倒序、回文判断          | 判断回文链表               |
| **HashSet / Map**    | 判环、去重、复制        | HashSet 判环，Map 复制指针 |
| **三指针移动**       | 当前、前驱、后继        | 链表反转、删除             |
| **分段计数**         | 分组反转/多链表拆分     | k 个一组反转、拆分链表     |

## 速查手册

| 题号 | 题目名称               | 难度 | 策略关键词              |
| ---- | ---------------------- | ---- | ----------------------- |
| 21   | 合并两个有序链表       | 简单 | 双指针 + dummy          |
| 2    | 两数相加               | 中等 | 进位模拟 + dummy        |
| 206  | 反转链表               | 简单 | 三指针/递归             |
| 92   | 反转部分链表           | 中等 | 前驱定位 + 局部反转     |
| 25   | K 个一组反转链表       | 困难 | 分组递归 + 原地反转     |
| 876  | 找中间节点             | 简单 | 快慢指针                |
| 141  | 判断链表是否有环       | 简单 | 快慢指针                |
| 142  | 找环的起点             | 中等 | Floyd 判圈定律          |
| 160  | 相交链表               | 简单 | 双指针（走两次）        |
| 234  | 判断回文链表           | 中等 | 快慢指针 + 反转后半部分 |
| 82   | 删除重复元素 II        | 中等 | 虚拟头节点 + 跳过重复段 |
| 138  | 复制带随机指针的链表   | 中等 | 哈希映射 / 原地交叉     |
| 147  | 对链表进行插入排序     | 中等 | 插入模拟 + dummy        |
| 109  | 有序链表转换二叉搜索树 | 中等 | 快慢指针 + 分治构树     |

## 有用的套路

### 反转链表

```
ListNode prev = null, current = start;
while(current !=null && current != stop){
   ListNode next = current.next;
   current.next = prev;
   prev = current;
   current = next;
}
```

Example:

| Step    | List               | Prev | Current |
| ------- | ------------------ | ---- | ------- |
| Initial | null -> a- >b->c   |      |         |
| 1       | Null <-a     b ->c |      |         |
| 2       | null <-a<-b c      |      |         |
| 3       | Null <- a <-b->c   |      |         |

### 每次找K个节点

```
for (int i=0;i<k && end !=null;i++){
   end = end.next;
}
```

### 跳过重复段

```
      boolean duplicated = false;
            // 跳过重复段
            // 如果x个节点具有相同的值，将指针移动其中最后一个节点，打开重复标志
            // 如果当前节点和下一节点相同，则current指针后移至下一节点
            while (current.next !=null && current.val == current.next.val) {
                current = current.next;
                duplicated=true;
            }
```



------

# 3. **栈与队列**

## 常见题型：

- 括号匹配
- 单调栈问题（如下一个更大元素）
- 用栈实现队列或用队列实现栈

## 解题策略：

- **栈**：擅长处理具有“最近相关性”的问题。
- **单调栈**：适用于处理区间范围最大/最小值问题。
- **双端队列**：用于滑动窗口最大值问题。

------

# 4. **哈希表**

## 常见题型：

- 两数之和
- 子数组和为K的问题
- 字符串的异位词问题

## 解题策略：

- 利用哈希表的快速查找特性。
- 结合前缀和或计数法优化时间复杂度。

------

# 5. **二叉树**

## 常见题型

- 二叉树的遍历（前序、中序、后序、层序）
- 最小/最大深度计算
- 二叉搜索树的操作（插入、删除、查找）
- 图的最短路径（BFS/DFS）
- 拓扑排序

| 类别             | 关键词                            | 示例题            |
| ---------------- | --------------------------------- | ----------------- |
| ✅ 遍历类         | 前序、中序、后序、层序、递归/迭代 | 94, 144, 145, 102 |
| ✅ 属性计算       | 高度、深度、节点数、直径          | 104, 111, 543     |
| ✅ 判断结构       | 是否平衡/对称/相同                | 100, 101, 110     |
| ✅ 路径类         | 路径和、最大路径、所有路径        | 112, 113, 124     |
| ✅ 转换类         | 构建树、扁平化、链表化            | 105, 106, 114     |
| ✅ 查找类         | 最近公共祖先、搜索路径            | 235, 236, 98      |
| ✅ 二叉搜索树专属 | 中序性质、大小关系                | 98, 700, 701, 230 |
| ✅ 变种结构       | 多叉树、完全/满/平衡树            | 222, 116, 117     |



| 类别       | 关键词                            | 示例题            | 推荐策略 / 套路                                              |
| ---------- | --------------------------------- | ----------------- | ------------------------------------------------------------ |
| ✅ 遍历类   | 前序、中序、后序、层序、递归/迭代 | 94, 144, 145, 102 | ✦ 递归三模板 ✦ 迭代用栈模拟 ✦ 层序用队列（BFS）              |
| ✅ 属性计算 | 高度、深度、节点数、直径          | 104, 111, 543     | ✦ 后序遍历计算 ✦ 分治返回局部属性（高度、最大值）            |
| ✅ 判断结构 | 是否平衡/对称/相同                | 100, 101, 110     | ✦ 同时遍历比较节点值 ✦ 镜像结构比较（对称） ✦ 后序返回高度 + early stop |
| ✅ 路径类   | 路径和、最大路径、所有路径        | 112, 113, 124     | ✦ DFS + 回溯 ✦ 累加和 + 叶子判断 ✦ 返回路径集合              |
| ✅ 转换类   | 构建树、扁平化、链表化            | 105, 106, 114     | ✦ 前/中/后序结合切片 ✦ 分治递归构造结构 ✦ Morris技巧或后序调整结构 |
| ✅ 查找类   | 最近公共祖先、搜索路径            | 235, 236, 98      | ✦ 分治法：左右递归 + 判断是否命中 ✦ 中序判 BST 路径          |
| ✅ BST 专属 | 中序性质、大小关系                | 98, 700, 701, 230 | ✦ 利用中序递增特性 ✦ 上下界剪枝 ✦ 二分查找型递归             |
| ✅ 变种结构 | 多叉树、完全/满/平衡树            | 222, 116, 117     | ✦ 层序遍历处理指针 ✦ 完全二叉树性质剪枝 ✦ 多子节点统一处理   |

## 解题策略：

- **递归**：解决树的遍历和属性计算问题。
- **BFS**：求最短路径、层序遍历等问题。
- **DFS**：路径总和、全排列生成等问题。
- **动态规划**：树上的动态规划（如最大路径和）。

## 常见遍历方式和用法

| 遍历方式          | 顺序                             | 应用场景                         |
| ----------------- | -------------------------------- | -------------------------------- |
| 前序（根左右）    | `root → left → right`            | `构建树`、序列化、复制结构       |
| 中序（左根右）    | `left → root → right`            | **二叉搜索树 BST 排序**          |
| 后序（左右根）    | `left → right → root`            | `删除节点`、`结构计算`（如高度） |
| 层序遍历（BFS）   | 从上往下逐层扫描                 | 求深度、宽度、右视图             |
| 深度优先遍历(DFS) | 从上往下探索遍历（root -> leaf） | 路径和                           |

## 应对策略和模版套路

### 递归分治模板

> 左右子树递归求解

```
Result left = helper(root.left);
Result right = helper(root.right);
//合并左右子树结果，返回
return merge(left,right,root);
```

**典型题：**

- 543 二叉树的直径
- 124 最大路径和
- 236 最近公共祖先
- 110 判断平衡树

### 遍历模板

#### 后序遍历模板套路

> 后续遍历： 左子树 ->右子树->根

```
public List<Integer> postOrderTraverse(TreeNode root){
   List<Integer> result = new ArrayList<>();
   
}

private void postorder(TreeNode node, List<Integer> result){
   // Base condition
   if (node == null) return;
   
   //递归逻辑
   //处理左子树
   postorder(node.left,result);
   //处理右子树
   postorder(node.right,result);
   //处理逻辑
   result.add(node.val);
   
}
```

#### 中序遍历模板套路

> 中序遍历：左子树->右子树->根

```
public void inorder(TreeNode node,List<Integer> path){
   //Base condition
   if (node == null) return;
   //处理左子树
   inorder(node.left, path);
   //处理当前节点
   path.add(node.val);
   //处理右子树
   inorder(node.left, path);
}
```



**典型题：**

- 94 中序遍历
- 101 是否对称（前序 + 镜像）
- 112 路径和（前序 + 回溯）

#### BFS遍历模板（队列实现）

```
Queue(TreeNode) queue = new LinkedQueue<>();
queue.offer(root);

while (!queue.isEmpty()){
   int size = queue.size();
   for (int i=0;i<size;i++){
      TreeNode node = queue.poll();
      //todo: 处理当前节点
      if(node.left != null) queue.offer(node.left);
      if(node.right !=null) queue.offer(node.right);
   }
}
```

**典型题：**

- 102 层序遍历
- 107 自底向上遍历
- 103 之字形层序
- 111 最小深度

#### DFS遍历模板（回溯+路径类）

##### DFS High Level 理解

深度优先搜索是一种 `递归式`的`探索` 每一条可能路径的方式，它的本质是`沿着一条路径走到底，在回退尝试其他可能`

- DFS过程是`递归`的
- DFS过程可能是`探索`式的
- 每一次过程都是沿着一个`路径到leaf`走到底的过程
- 沿着路径走到底之后，DFS回进行`回退` 至至上一个节点

##### DFS 就像是`爬山探路`

- 你站在树根，每次往左或者往右，就像爬山的一步
- 一旦走到底(叶子)，你回头(回溯)换一条路，注意这里的回头是至`回到上一个节点`，而不是回到跟节点
- 一整条路径，就是你`从根走到叶子的完整旅程`

##### DFS就像`系统自动展开一颗可能空间树`

- 每个节点代表一个决策点
- 在当前节点决定往左走还是往右走，每次递归都是做决策
- 递归返回就是`走到底或者发现走错路`
- 整个搜索树的遍历，就是DFS

##### DFS就是系统调用战在压栈弹栈

- 每次调用dfs()就是在压栈，深入一步
- 每次函数返回，就是弹栈，回退一层
- 你可以通过观察 **递归函数的参数变化 + 返回值**，理解「走进去 → 回出来」的过程。

##### 递归DFS过程详解

- Base condition

  ```
  node == null;
  ```

- 处理当前节点

  ```
  process (node){
  	if (node.isLeaf() && ....){
  	  // process node
  	}
  }
  ```

- 递归处理左子树

  ```
  dfs(node.left,List<Integer> path);
  ```

-  递归处理右子树

  ```java
  dfs(node.right,List<Integer> path);
  ```

  

```
void dfs(TreeNode node, List<Integer> path){
   //   Base condition
   if (node == null) return;
   //  处理当前节点
   path.add(node.val);
   
   
   if (node.isLeaf &&(other conditions){
     res.add(new ArrayList<>(path));
   }
   // 遍历左子树
   dfs(node.left,path);
   // 遍历右子树
   dfs(node.right,path);
   //..merge
}
```

**典型题：**

- 113 路径和 II
- 257 所有根到叶路径

### 构建二叉树（分治）

```
TreeNode build(int[] preoder, int[] inorder){
  //找出根节点
  //分割左右子树
  //递归构建左右子树
}
```

**典型题：**

- 105 前序 + 中序 → 构建树
- 106 中序 + 后序 → 构建树

## Morris 遍历解决问题

### 普通的方法

- 递归遍历（前序/中序/后序/BFS/DFS）- o(h) 空间
- 栈 (手动模拟系统栈)

Morris方法通过**修改树的结构**，在遍历时临时建立`索引`，从而实现`O(1)` 空间

### Morris 中序遍历的核心原理

对于当前节点 `curr`：

1. 如果没有左子树：

   → 处理该节点（current节点）

   → 进入下一轮（处理右子树） `curr = curr.right`

2. 如果有左子树：

   → 找到它`左子树中最右节点（prev）`

   - 创建`左子树最右节点`的`right`连接

     - 如果`左子树最右节点` 没有`right`连接（`prev.right == null`）
        → 建立`right`连接，将`当前节点` 设置为`左子树最右节点 `的 `right`节点：`prev.right = current`
        → 进入下一轮（处理左子树）：`curr = curr.left`

     - 如果 `左子树最右节点` 已经有`right`连接(prev.right !=null)，说明是第二次访问
        → 删除`左子树最右节点`的`right`连接：`prev= null`
        → 处理当前节点

       → 进入下一轮（处理右子树）， `curr = curr.right`

![image-20250404181655125](/Users/tommy/Library/Application Support/typora-user-images/image-20250404181655125.png)

### 代码实现

```
public morrisInOrder(TreeNode root){
	TreeNote current = root;
	
	while (current !=null){
	  // 如果左子树为空，前往右子树
		if(current.left == null){
		  //处理当前节点
			System.out.println(current.val+" ");
			current = current.right;
		} else {
			// 寻找左子树最右节点
			TreeNode pre = current.left;
			while(pre.right !=null && pre.right !=current){
				pre = pre.right;
			}
			
			if (pre.right == null){
				// 第一次到达，建立线索
				pre.right = current;
				current = current.left;
			} else {
				// 第二次到达，断开线索 + 访问
        pre.right = null;
        System.out.print(curr.val + " ");
        curr = curr.right;
			}
		}
	}
}
```



## 典型题目汇总

| 题号 | 名称            | 技巧类型          |
| ---- | --------------- | ----------------- |
| 94   | 中序遍历        | 递归/栈           |
| 104  | 最大深度        | 后序递归          |
| 101  | 判断对称        | 镜像递归          |
| 543  | 二叉树直径      | 后序+返回子树高度 |
| 124  | 最大路径和      | 分治+维护最大值   |
| 236  | 最近公共祖先    | 分治+回溯         |
| 112  | 路径和          | DFS               |
| 113  | 路径和 II       | DFS + 回溯        |
| 98   | 验证 BST        | 中序/上下限判断   |
| 105  | 前序+中序构建树 | 递归分治          |

## 通用判断技巧

| 题型         | 策略                 |
| ------------ | -------------------- |
| 是否对称     | 镜像比较             |
| 是否相同     | 同时遍历对比         |
| 是否是 BST   | 中序递增 or 限界判断 |
| 最近公共祖先 | 分治返回是否命中     |

## 题目演示

### Leetcode 117 : 连接每一层中的节点

```
给定一个二叉树：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。

初始状态下，所有 next 指针都被设置为 NULL 。
```

非BFS方法实现过程(第一轮)

Round 1

| current | Prev        | Process                   |      |      |
| ------- | ----------- | ------------------------- | ---- | ---- |
| 1       | Dummy->2->3 | - 2.next = 3, 3.next=null |      |      |
| Null    |             |                           |      |      |

current = 2

Round 2

| Current | Prev        |      |      |      |
| ------- | ----------- | ---- | ---- | ---- |
| 2       | Dummy->4->5 |      |      |      |
| 3       | 5->7        |      |      |      |
| null    |             |      |      |      |
|         |             |      |      |      |

current =4

Round 3

### Leetcode 236：最近公共祖先

##  题目描述

给定一棵**二叉树**，以及树中的两个节点 `p` 和 `q`，请你返回它们的**最近公共祖先（Lowest Common Ancestor, LCA）**。

> 「最近公共祖先」是指在树中同时拥有 `p` 和 `q` 作为子孙节点（自己也可以是）的最深节点。

## 示例描述

```
        3
       / \
      5   1
     / \ / \
    6  2 0  8
      / \
     7   4

输入：p = 5, q = 1  
输出：3

输入：p = 5, q = 4  
输出：5
```

##  解题思路：后序遍历 + 分治



我们可以使用`递归后序` 遍历的方式：

后续遍历模板套路:

```
public void postorder(TreeNode node, List<Integer> path){
   if (node == null) return;
   
   postorder(node.left, path);
   postorder(node.right, path);
   
   path.add(node.val);
}
```

其核心思想大约是

1. 如果当前节点为 null，直接返回 null；
2. 如果当前节点等于 `p` 或 `q`，返回当前节点；
3. 递归地在左右子树寻找 `p` 和 `q`：
   - 如果左右子树都返回非空 → 当前节点是最近公共祖先；
   - 如果只有一边返回非空 → 向上传递该结果；
   - 如果都为空 → 返回 null。

### Leeched 530:[二叉搜索树的最小绝对差](https://leetcode.cn/problems/minimum-absolute-difference-in-bst/)

给你一棵 **二叉搜索树（BST）** 的根节点 `root`，请返回 **任意两棵不同节点值之间的最小绝对差值**。

## 输入示例

```
输入：
    4
   / \
  2   6
 / \
1   3

输出：1 （节点 2 和 3 或节点 3 和 4 差值都是 1）
```

## 解题思路：BST + `中序遍历`模板

- 中序遍历模板

  ```
  public void inorder(TreeNode node,List<Integer> path){
     //Base condition
     if (node == null) return;
     //处理左子树
     inorder(node.left, path);
     //处理当前节点
     path.add(node.val);
     //处理右子树
     inorder(node.left, path);
  }
  ```

- 实现的要点

  - BST的特点

    按照`中序遍历`将会得到一个`升序`的数组，最小差值即从相邻节点的差值中寻找即可

  - 定义两个`全局变量`: **_全局变量是需要定义多个函数写作的时候的很好的手段，需要注意应用_**

    - Prev: 记录上一个节点值（初始值）, 用来和当前节点进行计算差值使用
    - minDiff: 当前的最小差值（默认值为`MAX_VALUE`），使用遍历比较法计算的时候
      - 如果求最大值，则最大值的初始值为`MIN_VALUE`, 比较后续值，如果后续值小于最大值，则更新最大值
      - 如果求最小值，则最小值的初始值为`MIN_VALUE`，如果后续值大于最小值，则更新最小值
  
  - 计算当前几点和prev的差值，如果差值小于minDiff, 则minDiff = 差值
  
- 代码实现

  ```java
  class Solution {
      Integer prev = null;
      int minDiff = Integer.MAX_VALUE;
  
      public int getMinimumDifference(TreeNode root) {
          inOrder(root);
          return minDiff;
      }
  		
    	//中序遍历套路，结合prev全局变量使用
      private void inOrder(TreeNode node) {
          if (node == null) return;
  
          inOrder(node.left);
  
          if (prev != null) {
              minDiff = Math.min(minDiff, node.val - prev);
          }
          prev = node.val;
  
          inOrder(node.right);
      }
  }
  ```

### Leetcode 112 路径总和（DFS）

## 题目描述

给定一棵二叉树的根节点 `root` 和一个整数 `targetSum`，**判断是否存在一条从根节点到叶子节点的路径，其节点值之和等于 targetSum。**

## 示例

```
输入：
    5
   / \
  4   8
 /   / \
11  13  4
/ \
7  2

targetSum = 22

输出：true

解释：5 → 4 → 11 → 2 的路径和为 22。
```

## 解题思路： 深度优先遍历（DFS）

深度优先遍历套路

```Java
List<Integer> currentPath = new ArrayList<>();
public void dfs(TreeNode node, List<List<Integer>> paths){
  if (node==null) return;
  //如果当前节点是叶子节点
  if (node.left == null && node.right == null){
    currentPath.add(node.val);
    paths.add(currentPath);
    currentPath = new ArrayList<>();
  }
  
  //处理左子树
  dfs(node.left, paths);
  dfs(node.right,paths);
}
```



这题属于「**路径类 - 判断型**」题目。思路非常直接：

1. 从根开始遍历，每经过一个节点，把当前路径和 `sum` 减去这个节点的值；
2. 一旦到达**叶子节点**，判断当前路径和是否等于目标值；
3. 任意一条路径满足，即可返回 `true`。

### 代码实现

```java
 // 深度优先搜索的套路
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum1(root, targetSum);
    }

    // Dfs 递归套路
    private boolean hasPathSum1 (TreeNode node, int targetSum){
        // Base condition
        if (node==null) return false;
        //处理当前节点
        if (node.left==null && node.right == null){
            if (node.val == targetSum){ return true;}
        }
        // 递归处理做节点和右节点
        int newTargetSum=targetSum-node.val;
        return hasPathSum1(node.left, newTargetSum)||hasPathSum1(node.right, newTargetSum);
    }
```



# 图

## 图的分类

| 类型                  | 子类            | 说明                          |
| --------------------- | --------------- | ----------------------------- |
| **有向图**            | ——              | 边有方向 `(u → v)`            |
| **无向图**            | ——              | 边无方向 `(u ↔ v)`            |
| **带权图**            | 有向/无向都可以 | 每条边有权值                  |
| **无权图**            | ——              | 常用于 BFS 最短路径           |
| **稀疏图 / 稠密图**   | ——              | 边远少于点的平方 / 接近完全图 |
| **连通图 / 非连通图** | ——              | 所有点都能互达 / 不能互达     |
| **DAG（有向无环图）** | ——              | 用于拓扑排序、任务依赖建模    |
| **树 / 森林**         | ——              | 无环连通图（树） / 多棵树     |

## 图的表示

### 邻接表

```java
List<List<Integer>> graph = new ArrayList<>();
for (int i=0;i<n;i++){
  //对于每一个节点，都添加一个list，保存与其相邻的节点
	graph.add(new ArrayList<>());
}
// 边是使用数组表示 int[i][j] 
// i表示edge的index, 
// j=int[2], 表示起点和终点
for (int[] edge: edges){
	int u = edge[0], v=edge[1];
	graph.get(u).add(v);
	// graph.get(v).add(u);//如果是无向图的话，两个数组都要添加

}
```

### 邻接矩阵

> 邻接矩阵适合稠密图

```java
//邻接矩阵是一个二维数组graph[u][v]
// graph[u][v]=1表示存在一条从u到v的边
int[][] graph = new int[][];

for (int[] edge: edges){
  int u=edge[0],v=edge[1];
  graph[u][v]=1;
  // graph[v][u]=1 //如果是无向图
}
```

### 边列表（适合并查集、Kruskal）

```java
List<int[]> edges = new ArrayList<>();
edges.add(new int{u,v,weight});
```

## 常见图类型题的算法 + Java 模板

| 算法 / 技术           | 典型场景                       | Java 模板说明                 |
| --------------------- | ------------------------------ | ----------------------------- |
| **BFS（广度优先）**   | 无权图最短路径、岛屿扩展问题   | `Queue + visited Set`         |
| **DFS（深度优先）**   | 遍历图、连通块、图染色、检测环 | `递归 DFS + visited`          |
| **Union-Find 并查集** | 判断连通性、合并集合、检测环   | `parent[] + find + union`     |
| **Dijkstra**          | 加权图中最短路径               | `PriorityQueue + dist[]`      |
| **Bellman-Ford**      | 有负权边的最短路径（较少用）   | `O(VE)`，代码略长             |
| **拓扑排序**          | DAG 拓扑结构判断或任务调度问题 | `Queue + 入度数组 indegree[]` |
| **Kruskal**           | 最小生成树                     | `边排序 + Union-Find`         |
| **Prim**              | 最小生成树（稠密图更优）       | `PriorityQueue + visited`     |

### 相关算法在面试题中的占比排名

在大厂/互联网公司（如 Google、Amazon、Meta、字节、阿里、腾讯）中，图论题目的出题频率大概占**中高级算法题目的 15% 左右**，其中：

**最常考的图算法** 排名一般是：

1. **BFS/DFS**（包括拓扑排序）
2. **Union-Find（并查集）**
3. **Dijkstra（最短路径）**
4. **Kruskal / Prim（最小生成树）**
5. **A\* / Bellman-Ford（罕见）**

### BFS 模板：一层一层地`向外扩展`的搜索方式。

>  根二叉树的BFS遍历类似

#### 核心思想

> BFS 是一层一层地`向外扩展`的搜索方式。

- 从起点开始，先访问所有距离为1的节点，再访问所有距离为2的节点....
- 类似于`波浪` 一样，一圈一圈扩散出去
- 通常用于找`最短路径`，`层级遍历`, `范围扩散/感染`

> 找最短路径用 BFS！用 DFS 无法保证走到终点时就是最短路径。

#### 原理

1. 使用队列实现先进先出

   > 确保`先被访问的节点，线扩展`

2. 记录访问状态（`visited`或者`grid原地修改`）

   > 防止重复访问

3. 从起点出发，循环以下过程

   - 拉出队列头部的节点(node)
   - 遍历它的邻居(`上下左右的邻居`)
   - 如果邻居满足以下条件，就入对并且标记访问
     - 未访问
     - 合法
     - 满足条件

#### 代码实现模板

```java
Queue<int[]> queue = new LinkedList<>();
int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

// 从某个起点开始
queue.offer(new int[]{x, y});
while (!queue.isEmpty()) {
    int[] cur = queue.poll();
    for (int[] d : dirs) {
        int nx = cur[0] + d[0];
        int ny = cur[1] + d[1];
        if (合法 && 没访问过 && 满足条件) {
            queue.offer(new int[]{nx, ny});
           // 标记为已访问;
        }
    }
}
```

#### 记录遍历层次数的做法

- 定义一个`steps`

- 在遍历`Queue` 的时候保证每次while循环会访问一整层的节点，这样下一次while循环开始的时候queue里面也正好是一整层节点

  ```java
  while (!queue.isEmpty()) {
      int size = queue.size();//
      for (int k=0;k<size;k++){//保证一次拿出k个节点
        int[] cur = queue.poll();
      	for (int[] d : dirs) {
          int nx = cur[0] + d[0];
          int ny = cur[1] + d[1];
          if (合法 && 没访问过 && 满足条件) {
              queue.offer(new int[]{nx, ny});
             // 标记为已访问;
          }
      }
      }
  }
  ```

  

#### Leetcode 909: 蛇梯棋-BFS实现

> 你玩的是一个蛇梯棋游戏，有一个大小为 `n x n` 的棋盘（`n` 是偶数），编号从 1 到 n²，编号方式是 **“蛇形”** 编号，如下：
>
> ```
> CopyEdit
> 示例：n = 6，编号方式如下（蛇形，从左往右再右往左交替）：
> 
> 36 35 34 33 32 31
> 25 26 27 28 29 30
> 24 23 22 21 20 19
> 13 14 15 16 17 18
> 12 11 10  9  8  7
>  1  2  3  4  5  6
> ```
>
> 棋盘中可能出现蛇或梯子，棋盘用一个二维数组 `board` 表示，`board[i][j]`：
>
> - `-1` 表示该格子是普通格；
> - 否则是某个数字 `x`，表示当你到达这个格子时，会直接移动到编号为 `x` 的格子（蛇或梯子）。
>
> 你每次投骰子，可以掷出 1 到 6 的点数，代表可以从当前格子往后走 1~6 步。
>
> 你从编号 1 的格子出发，目标是走到编号 `n*n` 的格子，返回最少需要的步数。
>
> 如果无法到达终点，返回 -1。

##### 核心思想

将题目中的棋盘以及蛇和梯子转化为一个图,然后使用`bfs`来寻找节点1～n*n最短路径。

###### 怎么将棋盘和梯子和蛇转化为图？

- 每一个二维数组中的元素可以转化为图中的一个节点
- 投骰子，可以有两种情形转化为一个边
  - 投骰子投到了一个普通节点`-1`,那就存在一个边`current-selectedNode`
  - 投骰子投到了一个特殊节点`x`,那就存在另外一个边 `current-x`

##### 算法原理

该算法的实现核心有两个非常需要注意的地方

- 图的构建过程，在生成边的需要需要考虑投骰子的情况
  - 骰子投到一般节点
  - 骰子投到跳跃节点
- 投骰子次数也就相当于是图的遍历层数，需要注意怎么计算遍历的层数

###### 从二维数组构建图

注意跳跃节点和一般节点的处理逻辑。

```java
    public Map<Integer,List<Integer>> getGraph(int[][] board){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int n = board.length;
        for (int s=1;s<=n*n;s++){
            List<Integer> neighbors = new ArrayList<>();
            for (int dice =1;dice<=6;dice++){
                int next = s+dice;
                if (next > n * n) break;
                int[] position = getPosition(next, n);
                int i = position[0],j=position[1];
                int target = board[i][j];
                if (target == -1){
                    neighbors.add(next);
                }else{
                    neighbors.add(target);
                }
            graph.put(s, neighbors);
            }
        }
        return graph;
    }
```

###### 使用BFS遍历图求得最小遍历层数

求当前的遍历层数的最佳实践也在如下的代码中：

```java
    // 其实就相当于是图，蛇或者梯子表示图的边，b[i][j]=x, 表示b[i][j](id=?需要计算出来，i为偶数的情况下id=)和id=x之间的节点存在一条边
    public int snakesAndLadders(int[][] board) {
        Map<Integer,List<Integer>> graph = getGraph(board);
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        int steps =0;
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            //加上如下for循环，可保证每次while循环访问的是一整个层次的节点
            int size = queue.size();
            for (int k=0;k<size;k++){
            int node = queue.poll();
            if (node == n*n) return steps;
            List<Integer> nextNodes = graph.getOrDefault(node,new ArrayList<>());
            for (Integer next: nextNodes){
                if (!visited.contains(next)){
                    visited.add(next);
                    queue.offer(next);
                }
            }
            }
            steps++;
        }
        return steps;
    }
```



#### 算法最佳实践

##### 明确建模方式是关键第一步

**原则**：**先建模，再写代码。**抽象出图结构后问题就变得清晰易解。



##### **最短步数问题优先考虑 BFS**

如果题目问“最少投骰子次数”、“最短路径”这类问题，优先考虑 **BFS（Breadth-First Search）** 而不是 DFS。

BFS 会一层层地扩展路径，保证第一次到达目标节点的路径就是最短路径。

**原则**：**最短路径 → BFS；全部路径 → DFS；最短加带权 → Dijkstra。**



#####  **图建完以后，能用 BFS 不要自己加 visited size 累加器**

一层层扩展 queue，每一轮 +1 步数，不要在 `for` 循环里对步数乱加。

**最佳实践**：用 `queue.size()` 控制 BFS 层级，一轮投一次骰子。

##### visited 控制访问

✅ 加入 queue 前先 visited.add



#### 实现细节注意事项

##### 编号和棋盘坐标的映射很常见

这个题的编号是蛇形递增的，映射过程是：

- 编号 → 坐标：用于判断跳跃；
- 坐标 → 编号：用于构图或调试。

##### 注意边界条件

//TBD

### DFS 模板（图遍历+连通块）

#### 核心思想

沿着一条路径一直往下走（递归/栈模拟），直到不能再走为止，然后`回退`并探索其他路径。

#### DFS能够解决什么样子的问题？

| 应用场景                         | 描述                             |
| -------------------------------- | -------------------------------- |
| 图遍历                           | 访问图中所有节点（连通块）       |
| 拓扑排序                         | 有向无环图（DAG）中的排序问题    |
| 连通分量（Connected Components） | 统计图中联通区域数量             |
| 检测环路（Cycle Detection）      | 判断图中是否存在环（有向或无向） |
| 二分图判定                       | 染色法判断是否可以分为两组       |
| 岛屿数量 / 迷宫路径搜索          | 网格类图问题的通用解法           |
| 剪枝搜索 / 状态空间图探索        | 回溯、排列组合等问题             |

#### DFS的工作原理

本质上是一种递归（栈）模拟的图的遍历方式

##### 关键要素

- `访问标记`: 防止重复访问
- `递归/栈结构`：控制访问顺序
- `回溯机制`： 深入一个分支到底，然后退回再探索别的路径

##### 算法流程

1. 从一个起始节点v开始访问
2. 标记v为`已访问`
3. 遍历v的所有邻居u:
   - 如果u未被访问，递归调用dfs(u)
4. 所有邻居访问后返回

#### 代码实现

##### 基于邻接表

需要注意这里没有给出递归的base condition

```java
void dfs(int node,Set<Integer> visited, List<List<Integer>> graph){
  visited.add(node);
  // Base condition-tobe customized
  for(int neigbor: graph.get(node)){
    if (!visited.contains(neigbor)){
      dfs(neigbor,visited,graph);
    }
  }
}
```

#### Leetcode 133:克隆图-基于DFS实现

##### 核心思想

- 遍历图中所有的节点，构建它们的副本
- 图中可能存在环或者重复访问的节点，需要用一个`HashMap`来记录已经克隆的节点，避免死循环和重复克隆

##### 回顾DFS套路

###### DFS：沿着一条路径走下去，直到不能走的时候回退

- 将当前节点标记为visted
- 对于当前节点的每一个邻居节点
  - 如果邻居节点没有被标记为visited, 递归调用DFS

```java
void dfs(int node,Set<Integer> visited, List<List<Integer>> graph){
  visited.add(node);
  for(int neigbor: graph.get(node)){
    if (!visited.contains(neigbor)){
      dfs(neigbor,visited,graph);
    }
  }
}
```

##### 代码实现

###### 检查Node是否已经cloned

- 如果已经`cloned`,直接返回clone节点

```
Node cloneNode = visited.get(Node);
if (cloneNode != null) return cloneNode;
```

- 如果没有clone，则

  - 创建clone node并加入`visited`

  ```
  cloneNode = new Node(node.val);
  visited.put(node, cloneNode);
  ```

  - 遍历node的邻居节点，递归调用dfs过程

    ```java
    List<Node> neigbors = node.neigbors;
    for(Node neighbor: neigbors){
      Node cloneNeigbor = cloneGraph(neighbor);
      cloneNode.neighbors.add(cloneNeibor);
    }
    ```

  - 返回创建的cloneNode;

##### 关键数据结构

| 数据结构    | 类型                       | 作用                                                         |
| ----------- | -------------------------- | ------------------------------------------------------------ |
| HashMap     | `Map<Node, Node>`          | 用来记录每个原节点对应的克隆节点，防止重复克隆、用于构建邻接关系 |
| Stack/Queue | DFS 用 Stack，BFS 用 Queue | 控制遍历流程                                                 |
| Node        | 自定义图节点类             | 每个节点包含一个值和一个邻接节点列表 `List<Node>`            |

##### 算法原理

题目给定的是一个图的`某个节点的引用`, 我们需要返回一个`完全克隆的新图的该节点的引用`, 保持结构不变。

基于DFS来实现：

- 从给定点开始遍历
- 没遇到一个新节点：
  - 创建它的克隆节点
  - 放进visited哈希表中，记录`原来的节点`和`克隆的节点`的`映射关系`
  - 然后对它的所有邻居节点递归处理
- 如果遇到的节点已经在`visited`中，则直接返回对应的克隆节点， 防止重复构建和死循环

```java
private Map<Node,Node> visited = new HashMap<>();

public Node cloneGraph(Node node){
  Node cloneNode = visited.get(node);
  // Base condition
	if (cloneNode !=null) return cloneNode;
  // Recursive logic
  cloneNode = new Node(node.val);
  visited.put(node,cloneNode);
  //Recursive call
  List<Node> neighbors = node.neighbors;
  for (Node neihgbor: neighbors){
    if (! visited.containsKey(neigbor)){
      Node cloneNeighbor = cloneGraph(neighbor);
      visited.put(neighbor,cloneNeighbor);
    }
  }
 
  return cloneNode;
}
```

##### 最佳实践

- 使用`Map<Node,Node>`来保存对应的克隆记录

#### Leetcode 399: 除法求值

给你一个变量对数组 `equations` 和一个实数值数组 `values` 作为已知条件，其中 `equations[i] = [Ai, Bi]` 和 `values[i]` 共同表示等式 `Ai / Bi = values[i]` 。每个 `Ai` 或 `Bi` 是一个表示单个变量的字符串。

另有一些以数组 `queries` 表示的问题，其中 `queries[j] = [Cj, Dj]` 表示第 `j` 个问题，请你根据已知条件找出 `Cj / Dj = ?` 的结果作为答案。

##### 题目分析

- `equations[i] = [Ai, Bi]`
- `values[i]` = `equation[i][0]/equation[i][1]`
- 可以将equations和values 转化为一个`有向图`（注意每一条边都是双向的，并且权重互为倒数）
  - equations是图的边集合
  - values是边的权重集合
  - 加入某个边是`[a,b]`, 对应的value是`c`,那么边`[b,a]`对应的value就是`1/c`;

##### 核心思想

###### 将equations 和 values转化为`有向图Map<num1,Map<num2,value>>`

- equations是图的边集合
- values是边的权重集合

###### 采用dfs的方式从计算每一个query[DFS 套路]

- 找到起始节点和结束节点
- 如果如果起始节点和输入节点是同一个节点，返回1.0
- 如果起始节点不是输入节点
  - 如果起始节点不能够达到结束节点，返回-1.0
  - 如果起始节点能够到达结束节点，返回中途所有边的乘积

##### 关键数据结构

###### 构建图（邻接表）`Map<String,Map<String, Double>>`

DSF标配数据结构

```java
  public Map<String,Map<String, Double>>  getGraph(List<List<String>> equations,double[] values){
           Map<String,Map<String,Double>> graph = new HashMap<>();
            for (int i=0;i<equations.size();i++){
               //对于每一个equation和value， 生成两个边
             
               List<String> equation = equations.get(i);
               String num1 = equation.get(0);
               String num2 = equation.get(1);
               Double value = values[i];
               // Edge 1 = [num1,num2], weight1 = value
               Map<String, Double> neighbors1 = graph.get(num1);
               if (neighbors1 == null){
                neighbors1 = new HashMap<>();
                graph.put(num1, neighbors1);
               }
               neighbors1.put(num2, value);
								
							 // Edge2=[num2,num1],Weight2 = 1/value
               Map<String,Double> neighbors2 = graph.get(num2);
               if (neighbors2 == null){
                neighbors2 = new HashMap<>();
                graph.put(num2, neighbors2);
               }
               neighbors2.put(num1, 1.0d/value);
            }
            return graph;
    }
```

###### Visited Set

用来在dfs过程中记录已经计算过的节点，dfs标配数据结构

##### 算法实现原理

###### 定义dfs套路

- `dfs 标准参数`：

  - `Graph邻接表`：`Map<String,Map<String,Double>>`
  - `已访问的节点列表`：`Set<String> visited`

- 业务场景定制参数
  - 起始节点（`query[i][0]`）
  - 结束节点(`query[i][1]`)
  - 初始的结果因为是求除数结果的，默认为1


```java
public int dfs(Map<String,Map<String,Double>> graph, Set<String> visited, String current,String target,double accProduct){
	// 添加当前节点到visited
  visited.add(current);
  // Base condition,找到了target节点
  if (current == target) return accProduct;
  // 没找到target节点，继续往下找
  // 逻辑处理
  Map<String,Double> neighbors = graph.get(current);
  for (Map.Entry<String,Double> neighbor: neighbors){
    // DFS套路，如果邻居节点没有visited
    if (!visited.contains(neighbor)){
      double currentAccProduct = accProduct*neighbor.value;
      double product = dfs(graph,visited,neighbor.key,target,currentAccProduct)
      if (product !=-1.0){
        return product;
      }
    }
  }
  return -1.0d;
}
```







### 并查集模板

#### 理解并查集究竟是什么东西

##### 数据的存放

有一堆元素，属于不同的集合，每一个集合有一个老大，或者是代表

`parent[i]` 表示元素i的老大

一般来说初始状态之下每个元素就是自己的老大，用一个数组来表示就是：

```
 for (int i=0; i<n;i++) parent[i]=i;
```

##### Find(x):找出元素x的老大

比如想知道4属于哪一个集合，就是找4的老大，那么寻找的过程就是

- 先看看4是不是自己的老大：parent[4]==4;
- 如果4不是自己大老大：
  - 找到4的老大
  - 如果4的老大还有老大， 则继续寻找
  - 一直找到那个老大是自己的老大，返回这个终极大Boss



##### Union(x,y) 合并 x和y所在的两个集合

- 首先，找出x和y各自的老大`find(x)`和`find(y)`
- 如果两个老大不一样，则把其中一个老大挂到另外一个老大下面
- 如果两个老大相同：说明他们本来就在一个集合，不用动

#### 并查集代码实现模板

```java
class UnionFind {
  int[] parent;
  UnionFind(int n){
    parent = new int[n];
    for (int i=0; i<n;i++) parent[i]=i;
  }
  
  int find(int x){
    if (x!=parent[x]) parent[x]=find[parent[x]];
    return parent[x];
  }
  
  boolean union(int x, int y){
    int rootX = find(x);
    int rootY=find(y);
    parent[rootX]=rootY;
    return true;
  }
}
```

#### 并查集的应用场景

| 场景                 | 问题                                   | 应用                                                       | 示例                                              |
| -------------------- | -------------------------------------- | ---------------------------------------------------------- | ------------------------------------------------- |
| 连接问题             | 判断两个节点是否属于同一个`连通块`     | 动态连通性问题、计算连通分量个数                           | Leetcode 547. 省份数量（等价于图中连通块数量）    |
| **判断图中是否有环** | **判断图中是否有环**                   | 对图的边进行遍历，如果两个端点已经在同一集合，则形成了环。 | 最小生成树 Kruskal 算法。                         |
| 动态朋友关系问题     | 朋友圈查询                             | 一系列「连接 a 和 b」的操作，判断两人是否在同一个朋友圈。  | 朋友圈查询（如 Leetcode 1319、Leetcode 399 等）。 |
| 图中岛屿数量         | 图中岛屿数量                           | 将二维网格视为图，对 1 相邻的格子进行合并。                |                                                   |
| **冗余连接**         | 给定一组边，找出多余的一条，构成了环。 |                                                            | Leetcode 684、685                                 |

#### Leetcode 684: 冗余连接（检测图中的环）

> 树可以看成是一个连通且 **无环** 的 **无向** 图。
>
> 给定往一棵 `n` 个节点 (节点值 `1～n`) 的树中添加一条边后的图。添加的边的两个顶点包含在 `1` 到 `n` 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 `n` 的二维数组 `edges` ，`edges[i] = [ai, bi]` 表示图中在 `ai` 和 `bi` 之间存在一条边。
>
> 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 `n` 个节点的树。如果有多个答案，则返回数组 `edges` 中最后出现的那个。

需要记住一点，树额外加入一个边之后，就形成了一个`带环的图` , 所以题目就变成了`寻找图中的环`。

注意可能会存在`多条`冗余的边，题目要求返回`最后出现`的`冗余边`。

##### 核心思想

这是一个`图`中找环的问题，可以通过`并查集`方式来判断一条边是否沟通环。

从无到有的构建图，`每次加入一条边时，判断是否构成环`.

- 每条边连接两个点，我们需要模拟构建图的过程
- 每连接一条边，我们就检查边的`两个点是否已经在图中连通了`
  - 如果没有连通：这条边不会构成环，可以添加
  - 如果已经连通：这条边会形成环，我们已经找到了答案

###### 并查集中的元素是什么？

图中所有的节点

###### 并查集的中的集合是什么？老大是谁？

一个集合意味着一组可以相互连通的节点

###### 并查集中的查找是什么意思？

用来查找两个节点是否有共同的老大（是否同属一个集合）

###### 并查集中的合并操作是什么？

添加边的时候，如果两个节点不在同一个集合，将两个节点所属于的集合合并。



##### 算法原理

1. 初始化每个节点各自为一个集合。
2. 遍历每一条边 `[u, v]`：
   - 如果 `u` 和 `v` 已连通（属于同一集合）：**说明这条边构成环，返回它。**
   - 否则，把它们“连接”起来（合并集合）。
3. 遍历完成后返回构成环的那条边。

##### 代码实现

###### 并查集的定义

```java
public class UnionFind{
	int[] parent;
	
	public UnionFind(int n){
    for (int i=1;i<=n;i++){
      parent[i]=i;
    }
	}
  
  public find(int x){
    if (parent[x]!=x){
      parent[x] = find[parent[x]];
    }
    return parent[x];
  }
  
  public union(int x, int y){
    int parentX = find(x);
    int parentY = find(y);
    if (parentX != parentY){
      parent[parentX] = parentY;//注意是将x的parent的parent修改为Y的parent
    }
  }
}
```



###### 在图的构建过程发现环

```
public int[] findRedundantConnection(int[][] edges){
  UnionFind uf = new UnionFind(n);
  int[] lastRedundantCollection = new int[2];
  for (int[] edge: edges){
  	int node1 = edge[0];
  	int node2 = edge[1];
  	int parent1 = find(node1);
  	int parent2 = find(node2);
  	if (parent1 == parent2){
  		lastRedundantCollection = edge;
  	}else{
  		uf.union(node1, node2);
  	}
  	return lastRedundantCollection;
  }
}
```







### Dijkstra 最短路径模板（适用于加权图）

>  LeetCode 图论题中，约 6%~10% 属于典型 Dijkstra 题
>
> 图论题中排第 3，属于“需要掌握”的高频算法

| 方面            | 说明                                     |
| --------------- | ---------------------------------------- |
| 面试频率        | 图论题中排第 3，属于“需要掌握”的高频算法 |
| LeetCode 覆盖度 | 图论题中约 6~10% 是典型 Dijkstra 题      |
| 特征关键词      | **最短路径** + **权重** + **非负边权**   |
| 能力要求        | 对优先队列（heap）、邻接表、松弛操作熟练 |

#### 理解Dijkstra算法究竟是解决什么问题的

给定一个加权图G(V,E)和一个起点start, 求从start到其他所有节点的最短路径（路径上的权重和最小）

#### 一句话Dijkstra算法的核心思想

> 每次从`当前未处理的节点`中选择距离起点start`最近`的节点，确定它的最短路径，并用它来更新`它的邻接点的距离`

##### 什么是`未处理的节点`？

| 状态                 | 解释                                                     |
| -------------------- | -------------------------------------------------------- |
| 已处理节点           | 它的最短路径值已确定，再也不会被更短路径更新             |
| 未处理节点           | 虽然当前知道它到起点的距离，但我们不确定这是否是最短路径 |
| 未访问节点（不可达） | 当前甚至都不知道怎么到达它（距离仍是无穷大）             |

#### 算法流程

##### 定义初始最短距离数组dist[]

###### 内容和保存结构

- `dist[node] `表示从start到节点node的最短距离

###### 初始化状态

- 初始化start到每一个节点的最小距离

  - start到start的距离为0

  - start到其他节点的距离为`MAX_VALUE`

    > - 求最大值的时候，初始值一般设置为`MIN_VALUE`
    > - 求最小值的时候，初始值一般设置为`MAX_VALUE`

##### 维护`未确定最短路径`的所有节点

###### 内容和保存结构

定义一个小顶堆（优先队列`PriorityQueue`）维护`还没有确定最短路径`的节点，小顶堆的顶部存放当前`距离start最近`的节点。

- 优先队列存放的元素为`start到每一个节点的距离`:
  - Node: 表示终点节点
  - Distance：表示start到终点node的距离
- 优先队列的排序顺序为按照距离distance从小到大排序，堆顶的元素始终为距离start节点最近的节点

###### 初始化状态

- 将start节点放入优先队列中（node=start, distance=0）

##### 计算流程

###### 从优先队列堆顶取出`距离start最小的节点`（u）

按照小顶堆的属性，堆顶的节点是距离start最小的节点，直接取出该节点。

###### 重新计算start到u的所有的邻接节点(v)的距离

- 如果当前`v的最小距离`（`dist[v]`）大于`通过start通过u到达v的最小距离`(`dist[u]+w(u,v`)), 那么

  - 将v的最小距离更新为start通过u到达v的最小距离

    ```java
    dist[v]=dist[u]+w(u,v)
    ```

  - 将v加入邻接队列（因为v的邻接点还没有处理）(node=v,distance=dist[v])

###### 重复上述两个流程，直至优先队列为空



```java
//这个类用来表示什么？
//表示start到每一个节点（node）的距离(dist[ance])
class Pair{
  int node,dist;
  Pair(int n, int d) { node = n; dist = d; }
}

public void dijkstra(List<int[]> graph, int start){
// 建立一个小顶堆，按照每一个节点距离start的距离从小到大排序
PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
// start到每一个节点的距离 dist[i]表示start到节点i的距离
// 这是最终输出的结果，表示start到每一个节点的最小距离
int[] dist = new int [n];
//start 到每一个节点的默认距离都被设置为MAX_VALUE
Arrays.fill(dist, Integer.MAX_VALUE);
dist[start] = 0;
//将start Pair 加入队列
pq.offer(new Pair(start, 0));

while (!pq.isEmpty()){
  Pair currentPair = pq.poll();
  //如果当前Pair中的距离大于dist中的距离，什么也不做
  if(currentPair.dist > dist[currentPair.node]){
    continue;
  }
  // 如果当前Pair中的距离小于dist[node]中的距离
  // 找到与node相连的每一条边
  for(int[] edge: graph.get(currentPair.node)){
    int neigbor=edge[0],weight = edge[1];
    // 如果说start到node的距离+node到neigbor的距离 小于 start到neigbor的距离，则更新dist[neigbor]的距离
    // 将neigbor信息加入到队列当中
    if (dist[currentPair.node]+weight < dist[neigbor]){
      dist[neighbor] = dist[currentPair.node] + weight;
      pq.offer(new Pair(neighbor, dist[neighbor]));
    }
  }
}
}

```

#### Leetcode 743 网络延迟时间

##### 核心思想

>该题的本质是 **单源最短路径问题**，即从一个节点（`K`）出发，计算到所有其他节点的最短时间。

要解决这个问题，有以下关键要求：

- 有向图；
- 每条边有权重（时间）；
- 要求最短路径；
- 如果有节点无法到达，返回 `-1`。

##### 关键数据结构

###### 邻接表

```Java
Map<Integer,List<int[]>> graph;
```

存储图结构，每个节点对应一个列表，列表里面是[neighbor, time]

```
List<int[]> times = graph.get(node1) //获取所有于node1邻接的节点以及距离
int time = time.get(node2)//获取从node1到node2的time
```

###### 最小堆/优先队列

```
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
```

- 保存未处理的节点，堆顶是`距离原点距离最小`的节点

- 每次选择当前距离原点最近的节点进行扩展

###### 最短路径数组（或Map）

```
Map<Integer,Integer> dist;
```

- 记录从原点出发到每个节点的距离

##### 原理说明

###### 将图转化为邻接表表示方法

```java
Map<Integer,List<int[]>> graph = new HashMap<>();
for (int[] edge: times){
  int u = eadge[0],v=edge[1],w=edge[2];
  graph.computeIfAbsent(u,x-> new ArrayList<>().add(new int[]{v,w}));
}

```

###### 初始化最短距离数组

```
Map<Integer, Integer> dist = new HashMap<>();
```



###### 初始化优先队列

```
//优先队列中存放的元素同样是一个数组a[i]=x, 表示从k到i的距离是x（不一定是最小距离，没有经过确认）
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

//将起点元素本人添加至队列头
pq.offer(new int[]{k,0})
```



###### 遍历和操作优先队列

```java
//会进行不断的出队和入队的操作，一直到所有的元素都经历过队列
//每个过程其实都是取出队列头部的node, 然后更新其next nodes的值
 while (!pq.isEmpty()) {
            Distance distance = pq.poll();
            int node = distance.end;
   					// 为了减少重复访问，做个检查
            if (distance.distance > dist[distance.end]){
                continue;
            }

            List<int[]> nextNodes = graph.get(node);
            // 在有向图中，可能会存在一个node没有next 的情况，也可能会存在一个node有多个next的情况
            if (nextNodes ==null) continue;
						//
            for (int[] nextNode:nextNodes){
                int next = nextNodes[0];
                int time = nextNodes[1];
                if (dist[node]+time < dist[next]){
                    dist[next] = dist[node]+time;
                    pq.offer(new Distance(k, next, dist[next]));
                }
            }
        }
```

###### 查找最大时间值

```
for (int distance: dist){
            if (distance>maxDistance && distance != Integer.MAX_VALUE){
                maxDistance=distance;
            }
        }
        return maxDistance == 0 ?-1:maxDistance;
```



##### 规律和实践总结

###### Dijkstra有两种存储dist的方法：dist[node]=min distance和Map<node,min distance >

- Map方式：每一个节点只会被更新一次

  ```java
          int maxTime = 0;
          for (int i = 1; i <= n; i++) {
              if (dist[i] == Integer.MAX_VALUE) return -1;
              maxTime = Math.max(maxTime, dist[i]);
          }
  
          return maxTime;
  ```

  - 一旦一个节点node被poll()出来，我们就立刻`dist.put(node,time)`;
  - 后续即便有更短路径，我们也不会再次更新了

这里需要注意的是和传统的Dijkstra算法不一样，dist中的`每一个节点的值只会被更新一次`.

- Dist[]方式：每一个节点可能会被更新多次

  ```java
  while (!pq.isEmpty()){
    int current = pq.poll();
    for(each neighbor v of current[0]){
      if(dist[v]>dist[u]+w){
        dist[v]=dist[u]+v;
        pq.offer(v, dist[v]);
      }
    }
  }
  ```

  

  - 不管某个节点是不是已经访问过了，都允许不断入堆；

  - 每次只要找到更短路径，就更新`dist[v]`;

  - 同一个节点可能会被更新多次，直到最终路径收敛；

  - 为了避免废路径访问，可以在`poll()`时加一个`剪枝`;

    ```java
    if (time >dist[u]) continue;
    ```

    



### 拓扑排序

#### 拓扑排序究竟是解决什么问题的？

> 在`有向无环图`中，将所有顶点排序，使得对于每条`有向边 (u → v)，u 排在 v 前面`。

这本质上是在解决**依赖关系排序问题**，即：当一个任务依赖另一个任务完成时，如何安排它们的顺序。

#### 拓扑排序的核心思想是什么？

找到所有`没有前驱`（即入度为0）的节点，依次输出，并将它们`移除`，同时更新其他节点的`入度`，重复直到`图为空或无法继续`。

#### 拓扑排序的实现方法

##### 方法一：Kahn算法（基于入度）

###### 算法原理

1. 计算每个节点的入度
2. 初始化一个队列，将所有入度为0的节点入对
3. 每次从队列中取出一个节点（node），加入结果序列
4. 遍历其所有邻接节点：
   1. 每个邻接节点入度减1；
   2. 如果某个邻接节点入度为0，加入队列
5. 重复，直到队列为空
6. 如果结果队列中的节点数量小于总节点数量，说明图中有环（无法拓扑排序）

###### 算法实现

```java
// 每一个节点的入度
int[] indegree = new int[n];
// 图的表示：边列表
//list.get(i) 表示i的邻接节点列表
List<List<Integer>> graph = new ArrayList<>();

//初始化边列表
for (int i=0;i<n;i++){
	graph.add(new ArrayList<>());
}
//利用edges填充边列表
for (int[] edge:edges){
	graph.get(edge[0]).add(edge[1]);
  indegree[edge[1]]++; //终点节点入度+1
}

//使用BFS进行遍历
Queue<Integer> queue = new LinkedList<>();
for (int i=0;i<n;i++){
	//入度为0的节点加入队列
	if (indegree[i]==0) queue.offer(i);
}

//处理队列中的数据
while (!queue.isEmpty()){
	int node = queue.poll();
	for (int neigbor: graph.get(node)){
		indegree[neigbor]--;
		if (indegree[neigbor]==0) queue.offer(neigbor);
	}
}

```

#### Leetcode 207 课程表

你这个学期必须选修 `numCourses` 门课程，记为 `0` 到 `numCourses - 1` 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 `prerequisites` 给出，其中 `prerequisites[i] = [ai, bi]` ，表示如果要学习课程 `ai` 则 **必须** 先学习课程 `bi` 。

- 例如，先修课程对 `[0, 1]` 表示：想要学习课程 `0` ，你需要先完成课程 `1` 。

请你判断是否可能完成所有课程的学习？如果可以，返回 `true` ；否则，返回 `false` 。

##### 核心思想

本题目的核心是`检测有向图中是否存在环`。

- 我们可以将课程和先修关系建成一张有向图
- 若途中存在环，则说明存在循环以来，课程无法全部修完
- 如果图是有向无环图，则可以修完所有课程

##### 原理：拓扑排序-基于BFS+入度表

###### 拓扑排序的关键数据结构

- **入度表**`indegree[node]=indegree`: 记录每一个节点的入度

- **图的邻接表** ：记录了每一个节点的邻接节点列表

  ```
   List<List<Integer>> graph = new ArrayList<>();
  ```

- **BFS遍历队列**：用来做拓扑排序时候使用的

本题几乎严格遵循了`拓扑排序`的套路模板

//Todo 拓扑排序适用于哪些场景？

###### 从Edges构建Graph，并记录入度表

```java
      for (int[] edge: prerequisites){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
```

###### 构建遍历队列，并将入度为0的节点加入队列

```
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }
```



###### 遍历和操作队列

- 拉出队列头部节点

- 查询节点所有的后继节点列表

- 对于每一个后继节点，执行如下操作

  - 入度-1: `indegree[next]--`

  - 如果入度变为0，则将其加入队列

    ```
     if (indegree[next]==0) queue.offer(next);
    ```

```
        // 遍历和操作队列
        while (!queue.isEmpty()) {
            // 拉出队头的节点
            int node = queue.poll();
            // 获得节点的邻居节点列表
            List<Integer> nextNodes = graph.get(node);
            //对于列表中的每一个邻居节点
            //入度-1，如果该邻居节点入度变为0，将该邻居节点加入队列
            for (int next: nextNodes){
                indegree[next]--;
                listif (indegree[next]==0) queue.offer(next);
            }
        }
```

###### 判断拓扑排序是否成功

在基于`入度`的拓扑排序中，检测拓扑排序是否成功的标准是是否还有`入度不为0的节点`

- 如果存在入度不为0节点，那么说明图中有`环`，拓扑排序失败
- 如果不存在入度不为0的节点，那么说明图中无环，拓扑排序成功





##### 方法二：DFS算法

- 对图做DFS
- 在每个节点DFS结束时，将其压入栈
- 所有节点处理完成后，栈中元素从栈顶到栈底即为拓扑排序的结果
- 同样也可以检测到环： 若访问到当前递归路径中已经存在的节点，说明存在环

#### Leetcode 210 课程表II: 基于拓扑排序的算法实现

##### 复习：拓扑排序的套路

###### 1. 将图转化为邻接表的方式`Map<Integer,List<Integer>>`

###### 2. 计算每一个节点的入度:`indegree[n]`

###### 3. 初始化一个队列，将入度为0的节点加入队列

###### 4. 遍历和操作队列

重复下列流程，直至`queue为空`为止：

- 取出队列头的节点
- 从`graph邻接表`中取出所有该节点的邻居节点
- 对于每一个邻居节点
  - 将邻居节点的入度-1`indegree[neighbor]--`
  - 如果该邻居节点的入度为0, 则加入队列`queue.off(neighbor)`

###### 5. 检查是否还有入度不为0的节点

- 如果有入度不为0的节点，则说明图中有环，不能拓扑排序
- 如果没有入度不为0的节点，则说明图中无环，可以拓扑排序

##### 算法核心思想

尝试使用`拓扑排序`对图中的所有节点进行排序，看是否能够拓扑排序成功，如果成功则返回排序后的列表。

##### 算法原理（拓扑排序套路）

###### 构造邻接表同时计算入度

>  邻接表和入度表是拓扑排序算法的两个重要的关键数据结构！

```java
    // 生成图同时计算每个节点的indegree;
    private List<List<Integer>> getGraph(int n,int[][] edges){
        indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i< n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        return graph;
    }
```

###### 基于邻接表和入度表进行拓扑排序

- 初始化队列, 并将入度为0的节点加入队列

  ```java
          // 生成一个队列，并且将所有入度为0的节点加入队列
          Queue<Integer> queue = new LinkedList<>();
          for(int i=0;i<numCourses;i++){
              if (indegree[i]==0){
                  queue.offer(i);
                  list.add(i);
              }
          }
  ```

- 遍历和操作`队列`、`入度表`、`排序表`

  ```java
  //遍历和操作队列
          while(!queue.isEmpty()){
              int node = queue.poll();
              List<Integer> neighbors = graph.get(node);
              for (int neighbor:neighbors){
                  indegree[neighbor]--;
                  if (indegree[neighbor]==0){
                      list.add(neighbor);
                      queue.offer(neighbor);
                  }
              }
          }
  ```

- 判断是否还有入度不为0的节点，并返回结果

  ```java
  for (int ind:indegree){
              if (ind !=0){
                  return new int[0];
              }
          }
          return list.stream().mapToInt(Integer::intValue).toArray();
  ```

  



### Kruskal 算法：最小生成树算法

#### Kruskal 解决了什么问题？

在一个 **无向连通图** 中，选出一些边构成一个**生成树**，使得：

- 覆盖所有的顶点；
- 总边权最小；
- 没有环。

**如果一个图有n个节点，那它的最小生成树有`n-1`** 条边。

#### Kruskal  用于哪些场景？

- 网络布线最小成本

- 公路/电缆/管道铺设最小代价

- 聚类分析

#### 核心思想：贪心

> 每次选择`当前权重最小`，`不会形成环`的一条边加入生成树，直到构成一颗生成树为止

这是一种贪心策略，关键在于避免环的生成

#### 算法原理：并查集+排序

##### 将所有边按照权重从大到小排序

注意和拓扑排序的区别：

- `拓扑排序`是先计算每个节点的入度，然后使用队列逐渐减少每个节点的入度
- `最小生成树`算法是将每个`边的权重`按照`从小到大`的顺序排序

##### 从最小边开始，判断当前边连接的两个点是否属于不同集合（不连通）

- 若不属于同一个集合，将它们加入生成树
- 若不是，说明加入这条边会生成环，则跳过

##### 重复上述步骤2，直到选择n-1条边（n是节点树）

#### 关键数据结构

##### 边列表: `List<Edge>`

存储所有的边，并且按照权重排序

##### 并查集

判断两个节点是否属于同一个集合（是否连通）

##### 生成树集合

收集最终选中的边（也可以直接统计总权重）

#### 代码实现

##### 并查集

```java
class UnionFind{
  int[] parent;
  
  public UnionFind(int n){
    for (int i=0;i<n;i++){
      parent[i]=i;
    }
  }
  
  public find(int x){
    if (parent[x]!=x){
      parent[x]=find(parent[x]);
    }
    return parent[x];
  }
  
  public union(int x, int y){
    int parentX = find(x);
    int parentY = find(y);
    if (parentX != parentY){
      parent[parentX]=parentY;
    }
  }
}
```

##### 边列表排序

```
Arrays.sort(edges->edge.weigt);
```

##### 初始化并查集

```
UnionFind uf = new UnionFind(n);
```

##### 贪心算法处理过程

```java
int selectedNodes = 0;
int minWeigt =0;
for(Edge edge: edges){
  int node1 = edge.getNode1();
  int node2 = edge.getNode2();
  int parent1 = uf.find(node1);
  int parent2 = uf.find(node2);
  if (parent1 != parent2){
    uf.union(node1,node2);
    selectedNodes++;
    minWeigt +=edge.weight;
    if (selectedNodes ==n-1) break;
  }
}
```

##### 返回最小生成树总权重

```java
if (selectedNodes == n-1) {
  return minWeight;
}else{
  return -1;
}
```

#### 总结

| 项目           | Kruskal 算法说明                     |
| -------------- | ------------------------------------ |
| 适用图类型     | 无向图，边稀疏图效果更好             |
| 算法思想       | 贪心，按权重从小到大选边             |
| 是否需要连通图 | 是（才能得到一棵生成树）             |
| 是否需要防环   | 是，使用并查集避免环                 |
| 时间复杂度     | `O(ElogE)`，E为边数（排序 + 并查集） |

#### Leetcode 1584: 连接所有点的最小费用

给你一个`points` 数组，表示 2D 平面上的一些点，其中 `points[i] = [xi, yi]` 。

连接点 `[xi, yi]` 和点 `[xj, yj]` 的费用为它们之间的 **曼哈顿距离** ：`|xi - xj| + |yi - yj|` ，其中 `|val|` 表示 `val` 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 **有且仅有** 一条简单路径时，才认为所有点都已连接。

##### 核心思想

生成一个`最小生成树`，`最小生成树`具有的特征：

- 覆盖所有的节点
- 边的总权重最小
- 没有环

如果一个图中有n个节点，那么它的最小生成树具有`n-1`个边。

##### 关键数据结构

###### 节点列表`List<Node>`

###### 边列表`List<Edge>`

###### 并查集`UnionFind`

##### 算法原理

- 将二维数组转变成一组节点`List<Node>`，注意二维数组的定义是`points[i]={xi,yi}`

  ```java
  class Node {
    int id;// 节点在二维数组中的index
    int x;//节点的x坐标
    int y;//节点的y坐标
    
    public (int id, int x,int y){
      this.x=x;
      this.y=y;
      this.id = id
    }
  }
  
  public List<Node> getNodes(int[][] points){
    List<Node> nodes = new ArrayList<>();
    int n = points.length;
    for (int i=0;i<n;i++){
      int[] point = points[i];
      nodes.add(new Node(i,point[0],point[1]));
    }
    return nodes;
  }
  ```

- 将图视为一个`强连通图`，从节点中生成所有的`边`,并且按照距离的`从小到大`排序

  ```java
  class Edge{
    int id1;
    int x1;
    int y1;
    int id2;
    int x2;
    int y2;
    public Edge(int id1,int x1,int y1,int id2,int x2,int y2){
      this.id1 =id1;
      this.x1=x1;
      this.y1=y1;
      this.id2 = id2;
      this.x2=x2;
      this.y2=y2;
    }
    
    public int distance(){
      return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
  }
  
  public List<Edge> getEdges(List<Node> nodes){
    List<Edge> edges = new ArrayList<>();
    for (Node node1: nodes){
      for (Node node2:nodes){
        if (node1 !=node2){
          edges.add(new Edge(node1.id,node1.x, node1.y, node2.id,node2.x,node2.y));
        }
      }
    }
    //按照距离进行排序
    edges.sort(Comparaor.comparingInt(edge->edge.getDistance()))；
    return edges;
  }
  ```

- 定义并查集

  ```java
  class UnionFind{
    int[] parent;//每一个节点的老大
    
    //n是节点的数量
    public UnionFind(List<Node> nodes){
      int n = nodes.sizes();
      for (int i=0;i<n;i++){
        parent[i]=i;
      }
    }
    
    public find(int x){
      if (parent[x]!=x){
        parent[x]=find(parent[x]);
      }
      return parent[x];
    }
    
    public union(int x, int y){
      int parentX = find(x);
      int parentY = find(y);
      if (parentX != parentY){
        parent[parentX]=parentY;
      }
    }
  }
  
  public UnionFind getUnionFind(List<Node> nodes){
    return new UnionFind(nodes);
  }
  ```

  

- [最小生成树算法] 初始化关键数据结构

  ```java
  List<Node> nodes = getNodes(points);
  List<Edge> edges = getEdges(nodes);
  UnionFind uf = getUnionFind(nodes);
  //加入最小生成树的边，一棵最小生成树需要正好n-1个边
  int usedEdges =0;
  //最小生成树的权重总和
  int minTotalDistance=0;
  ```

- [最小生成树] 遍历已经排序的edges:

  - 检查每一条边的两个端点是否连通(有同一个老大)
    - 如果已经连通，跳过
    - 如果没有连通：
      - 在并查集中合并两个端点；
      - 增加边的数量 `usedEdges +=1`
      - 增加总权重 `minTotalDistance += edge.getDistance()`
  -  检查最小生成树中的边的数量是否已经达到n-1
    - 如果已经达到，则终止遍历
    - 如果没有达到则继续遍历

```java
for (Edge edge:edges){
	int node1 = edge.id1;
  int node2 = edge.id2;
  int parent1=uf.find(node1);
  int parent2 = uf.find(node2);
  if (parent1!=parent2){
    uf.union(node1,node2);
    usedEdges +=1;
    minTotalDistance += edge.getDistance();
    if (usedEdges == n-1){
      break;
    }
  }
}
```

- 判断是否可以生成最小生成树（`UdedEdges==n-1`）
  - 如果是，则返回totalMinDistance;
  - 如果不是，则返回`-1`;





## 典型题目汇总

| 类别        | 题目                                                         |
| ----------- | ------------------------------------------------------------ |
| BFS         | 200. Number of Islands, 994. Rotting Oranges                 |
| DFS         | 695. Max Area of Island, 417. Pacific Atlantic Water Flow    |
| Union-Find  | 684. Redundant Connection, 1319. Number of Operations to Make Network Connected |
| Dijkstra    | 743. Network Delay Time, 1631. Path With Minimum Effort      |
| 拓扑排序    | 207. Course Schedule, 210. Course Schedule II                |
| Kruskal MST | 1584. Min Cost to Connect All Points, 1135. Connecting Cities With Minimum Cost |

### Leet 200L 岛屿数量

给定一个二维网络`grid` ，由`1` （陆地）和`0` （岛屿）组成，求有多少个岛屿。岛屿与被水平或者垂直方向相邻的`1` 组成，周围被水包围。

#### BFS解法

##### 核心思想

遍历整个网络，遇到`1`则说明发现了新岛屿，同时从这个点出发使用`BFS`将这个岛屿的所有`1` 标记为0，防止重复计数。

##### 实现原理

###### 遍历grid每个点

- 如果是`1`, 将岛屿数量+1
- 从该点出发，使用BFS，编辑所有与之连接的`1`为0

###### 利用BFS标记岛屿

- 使用Queue
- 起点入队
- 当队列不为空是，不断取出当前节点(x,y)
- 扩展它的上下左右节点，如有还是`1` ，就标记为`0`并加入队列

```java
public int numsOfIslands(char[][] grid){
	if (grid == null || grid.length==0) return 0;
  
  int rows = grid.length;
  int cols = grid[0].length;
  int islandCount=0;
  
  //遍历每个格子
  for (int i=0;i<rows; i++){
    	for (int j=0;j<cols;j++){
        if(grid[i][j]=='1'){
          islandCount++;
          bfs[grid,i,j];
        }
      }
  }
}

// 淹没[i,j]所在岛屿中除了[i,j]之外所有的点
// 采用bfs的方式，注意图的bfs的套路
public void bfs (char[][] grid, int i,int j){
	int rows = grid.length;
	int cols = grid[0].length;
	
	// BFS的辅助队列，用来存储`未确认`的节点
	Queue<int> queue = new LinkedList<>();
	queue.offer(new int[]{i,j});
	grid[i][j]='0';
	
	//用来检查上下左右节点的工具
	int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
	
	while (!queue.isEmpty){
		int[] current = queue.poll;
		for (int[] d: directions){
			int newX = current[0]+d[0];
			int newY = current[1]+d[1];
			// 标记
			if (newX >=0 && newX<rows && newY < cols && newY>=0 && grid[newX][newY]==1){
				queue.offer(new int[]{newX,newY});
				grid[newX][newY]='0';
			}
		}
	}
}
```



#### 并查集解法

##### 核心思想：将相邻的岛屿合并为一个岛屿群，计算岛屿群的数量

- 把二维网格中的每个`1` 看作一个独立的点
- 如果某个`1`和它上下左右的`1` 连通，就把它们合并成为一个集合（同一个岛屿）
- 最后统计有多少个独立的集合

##### 定制一个并查集

> 注意到我们多数情况下无法直接将算法模板的代码直接使用，需要做定制
>
> 原本的并查集定义是一个面向一维数组的，无法直接应用到二维数组，需要做变种

###### 并查集的元素数组怎么获得？

- 将二维数组grid[][]转为一个一维数组
  - `grid[i][j]` 对应的一维数组为`nodes[i*cols+j]`

###### 并查集的构造函数干了什么？

- 将二维数组`grid`转为一个一维数组(元素数组)

- 初始化每个node的老大（parent/root）: parent[i]=i;

```java
class UnionFind{
  // parent[i]表示岛屿i的老大
	int[] parent;
  //
  int count;
  
  public UnionFind(char[][] grid){
    int rows = grid.length;
    int cols = grid[0].length;
    count =0;
    
    for (int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        if (grid[i][j]=='1'){
          int id = i*cols+j;//注意这个id生成公式
          //将每一个node的parent默认设置为自己
          parent[id]=id;
          //计算总节点的数量
          count++;
        }
      }
    }
  }
  
  public int find(int x){
    if (parent[x] !=x){
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
  
  public void union(int x, int y){
    int rootX = find[x];
    int rootY = find(y);
    if (rootX !=rootY){
      parent[rootX]=rootY;
      count --;
    }
  }
}
```

##### 在并查集中合并相邻节点

```java
public int numIslands(char[][] grid){
	if (grid == null || grid.length ==0) return 0;
  
  int rows = grid.length;
  int cols = grid[0].length;
  UnionFind uf = new UnionFind(grid);
  
  //注意只向下和向右查询，为了避免重复合并
  int directions = {{0,1},{1,0}}
  
  for(int i=0;i<rows;i++){
    for(int j=0;j<cols;j++){
     if (grid[i][j]=='1'){
       for (int[] d: directions){
         int ni = i+d[0];
         int nj = j+d[1];
         if (ni < rows && nj < cols && grid[ni][nj]=='1'){
           int id1 = i+cols+j;
           int id2 = ni*cols+nj;
           uf.union(id1,id2);
         }
       }
     }
    }
    return uf.getCount();
  }
}
```



### Leetcode 695 岛屿最大面积

给定一个二维网格 `grid`，由 `0`（水）和 `1`（陆地）组成。我们要找出网格中**最大的岛屿面积**，岛屿是指由**上下左右相邻的1组成的连通区域**。

#### DFS解法

##### 使用双重循环来遍历grid

- 每当遇到1，递归调用DFS来计算该岛屿的面积

  ```java
  int rows = grid.length;
  int cols = grid[0].length;
  int maxArea = Integer.MIN_VALUE;
  for (int i=0;i<rows;i++){
    for (int j=0;j<cols;j++){
      if (grid[i][j]=='1'){
        int area = dfs(grid,i,j);
        if (area > maxArea){
          maxArea = area;
        }
      }
    }
  }
  
  return maxArea;
  ```

  

- 使用DFS来计算每个岛屿的面积

  - DFS 套路模板

    ```
    //Base condition
    //检查当前节点是否满足条件
    
    //处理当前节点
    
    //将当前节点标记为已处理
    
    //递归处理邻居节点
    
    //返回结果
    ```

    

  - DFS 是一个`递归过程`

  - 递归的Base Condition

    - i <0;
    - i>=rows;
    - j<0;
    - j>=cols;
    - `Grid[i][j]` ==0;

  - 需要将当前的位置修改为0: `grid[i][j]=0`,防止`重复计算`

  - [最佳实践] 定义一个上下左右移动的方向 `directions = {{0,1},{1,0},{0,-1},{-1,0}}`

  ```java
  public int dfs(grid[][], int i, int j){
  	//Base conditions
    int rows = grid.length;
    int cols = grid[0].length;
    
    if (i<0 || i >= rows || j<0 || j>= cols || grid[i][j]==0){
      return 0;
    }
    
    //处理逻辑
    grid[i][j]=0;
    int area =1;
    
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}
    
    for (int[] d: directions){
      int ni = i+d[0];
      int nj = j+d[1];
      area+ = dfs(grid,ni,nj);
    }
    return area;
  }
  ```

  

------

# 6. **动态规划**

## 常见题型：

- 背包问题
- 最长递增子序列
- 最长公共子序列/子串
- 矩阵路径问题（如最小路径和）

| 题型                        | 关键词                             | 常见题目举例                         |
| --------------------------- | ---------------------------------- | ------------------------------------ |
| **图遍历**                  | DFS, BFS                           | 岛屿数量, 朋友圈                     |
| **最短路径**                | Dijkstra, BFS, Bellman-Ford        | 网络延迟时间, [地铁最少换乘次数]     |
| **连通性判断**              | Union-Find, DFS                    | 省份数量, [冗余连接]                 |
| **拓扑排序**                | DAG, 入度数组                      | 课程表                               |
| **环检测**                  | DFS + visited 状态记录，Union-Find | [课程表], [冗余连接 II]              |
| **最小生成树**              | Kruskal, Prim                      | [连接所有点的最小费用], [水管工项目] |
| **强连通分量**              | Tarjan, Kosaraju                   | 高难度，不常见                       |
| **双向 BFS / 状态压缩 BFS** | 双端搜索、状态图                   | [单词接龙], [滑动谜题]               |
| **图建模题**                | 抽象出图模型                       | [钥匙和房间], [飞地的数量]           |

## 解题策略：

- **状态定义**：明确dp数组或矩阵的含义。
- **状态转移方程**：找出状态之间的关系。
- **初始状态**：确定边界值。
- **优化空间复杂度**：如果状态仅依赖于前几个值，可以使用滚动数组优化空间。

------

# 7. **贪心算法**

## 常见题型：

- 区间调度问题
- 跳跃游戏
- 分配问题（如任务分配、糖果分配）

## 解题策略：

- **局部最优解的选择**：通过排序或优先队列找到当前最优解。
- **证明贪心策略的正确性**：适合能够通过局部最优推导出全局最优的题目。

------

# 8. **回溯与递归**

## 递归

> 递归 = 把“大问题”拆成“结构相同但规模更小”的子问题，直到最小情况可以直接解决，再一点点拼回去。

### 理解递归最重要的三件套

| 套件               | 你需要问自己：                                       |
| ------------------ | ---------------------------------------------------- |
| **递归函数的含义** | 这个函数到底在“干什么”？它的**输入输出含义是什么？** |
| **终止条件**       | 什么情况下，我**不再继续递归**？（避免死循环）       |
| **递归关系式**     | 当前的结果要如何**依赖子问题的结果**？               |

### 掌握递归的三类题型（常见套路）

| 类型     | 特征                         | 示例题                | 通用模板                       |
| -------- | ---------------------------- | --------------------- | ------------------------------ |
| ✅ 分治型 | 返回值由左右子问题合并       | 236 LCA、104 maxDepth | `return combine(left, right)`  |
| ✅ 判断型 | 判断是否存在某种情况         | 112 路径和            | `return left`                  |
| ✅ 枚举型 | 所有路径、组合、排列（回溯） | 113、22、46           | `path.add → dfs → path.remove` |

### 实战中如何掌控递归？（五步法）

#### 明确「你这个递归函数的定义」

要一上来就写代码，先用中文描述：

> “我这个函数 `dfs(node, sum)` 的意思是 —— 从当前节点出发，判断是否存在一条路径到叶子节点，路径和为 sum。”

🌟 如果你能清楚描述出这个含义，基本就成功一半了！

#### 明确终止条件：何时该停？

- 最常见的：`if (node == null) return ...;`
- 或：`if (isLeaf(node)) return 当前值`
- 回溯中常见：`if (满足条件) res.add(...)`

#### 写出递归调用语句（左右 / 下一级）

- dfs(node.left, ...)
- dfs(index+1, path, sum...)
- 多叉树：`for (child : node.children) dfs(child)`

####  返回值或中间处理（是否有组合 / 加总）

- 有时候你要把左右子树结果合并 `return left + right`
- 有时候只判断是否成立 `return left || right`
- 有时候收集路径，需要在 path 中加入再移除

#### 你要牢记的几句“递归口头禅”

- **不要想着从上往下解决问题**，你要相信 `子问题会帮你解决`

- **递归函数只干一件事，别贪心**，把其余任务交给子问题

- **明确定义 + base case + 推导递归逻辑** → 成功三要素

- **把递归看作一棵树在展开，return 是从底向上拼的结果**

#### 推荐的训练路线

| 难度  | 类型      | 例子                           |
| ----- | --------- | ------------------------------ |
| 🌱入门 | 树递归    | 104 最大深度、112 路径和       |
| 🍃进阶 | 分治      | 236 最近公共祖先、124 最大路径 |
| 🌳高阶 | 回溯+剪枝 | 46 全排列、39 组合总和         |
| 🎯综合 | 图DFS     | 200 岛屿数量、797 所有路径     |

## 常见题型：

- 全排列与组合
- 子集生成
- N皇后问题
- 数独求解

## 解题策略：

- **剪枝**：在递归过程中提前排除不合法的分支。
- **递归模板**：明确递归的结束条件和递归参数的变化。
- **路径记录**：利用栈或数组记录当前路径。

------

# 区间类问题

## 常见题型

| 类型          | 常见题目                       | 典型算法             |
| ------------- | ------------------------------ | -------------------- |
| 区间合并      | 合并区间/插入区间              | 排序+合并            |
| 区间交集/覆盖 | 区间交集、区间覆盖             | 双指针、排序         |
| 覆盖判断      | 是否能够完全覆盖目标区间       | 贪心、排序、`扫描线` |
| 最小区间数    | 涂色、最少会议室               | 贪心、堆             |
| 覆盖/覆盖次数 | 会议室使用数、线段最多重叠次数 | 扫描线/差分数组      |
| 区间动态修改  | 动态区间加减、查值             | 线段树 / 树状数组    |
| 区间贪心      | 覆盖问题、最多不重叠区间       | 按右端点贪心选取     |
|               |                                |                      |



## 算法学习

### 贪心算法

### 扫描线算法

### 差分数组

## 解题策略

### **按区间起点 / 终点排序** —— 几乎是必备步骤！

```
Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 按起点排
Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // 按终点排（贪心）
```

### 合并区间技巧（经典模板）

```
// Interval的表示方法？
// Interval[m][n], m表示每一个interval的下表，n=[1,0], 表示start和end的位置（index）
List<int[]> res = new ArrayList<>();
Arrays.sort(intervals,(a,b) -> a[0]-b[0]); //区间排序

int[] current = intervals[0];// 获得第一个interval作为开始
for (int i=1; i< intervals.length;i++){
//如果current interval的结束位置在 intervel i的start之后，说明两个interval有重叠，将interval i合并入interval current中
  if (current[1]>=intervals[i][0]){
  //合并interval
  //如果current interval的end在interval i的end之后，设置current interval的终点为新的终点
  //如果current interval的终点在interval i的终点之前，设置 interval i的终点为新的重点
    current[1] = Math.max(current[1],intervals[i][1])
  } else {
  //否则则将当前的current加入到合并之后的interval list当中
  res.add(current);
  //进行下一轮的处理
  current = intervals[i];
  }
}

```

### 最多不重叠区间数（贪心算法）

- 按照右端点生序排序
- 每次选择最早结束且不冲突的区间

```
//按照终点值对区间进行排序
Arrays.sort(intervals,(a,b)->a[1]-b[1]);

int count=0, end = Integer.MIN_VALUE;
//对于每一个interval, 如果说起点大于上一个interval的终点，则说明该interval和上一个interval没有重叠
// 如果有重叠呢？重叠的两个interval算做一个interval(或者更多？)
for (int[] interval : interbals){
  if (interval[0] >= end) {
     count++;
     end = interval[1];
  }
}

```

### 最小会议室个数（扫描线/堆）

- 所有区间拆成[start,+1],[end,-1]事件；
- 扫描时维护当前活跃会议数

或者用`小顶堆` 保存每一个会议的结束时间：

```
// 保存每一个会议的结束时间，按照时间顺序排序，小顶堆，每次弹出最小只
PriorityQueue<Integer> heap = new PriorityQueue<>();
//将会议按照开始时间排序
Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

// 安排会议
for (int[] interval: intervals){
  if (!heap.isEmpty() && interval[0] >= heap.peak()){
     heap.poll();
  }
  heap.offer(interval[1]);
  return heap.size();
}
```



### 覆盖型问题（是否能够全部覆盖/覆盖次数）

比如 跳跃游戏II, 贴海报问题、覆盖区域等：

- 排序区间后，用 `贪心算法`找出 **当前能覆盖最远**的
- 遇到端点即失效

## 总结区间题思维套路

| 问题类型            | 思考套路                   |
| ------------------- | -------------------------- |
| 需要合并            | 按起点排序，维护当前区间   |
| 要选最多            | 按终点排序，贪心选择不冲突 |
| 要找交集            | 双指针遍历两个区间列表     |
| 最少资源 / 最大重叠 | 扫描线 or 小顶堆           |
| 区间加减 / 修改     | 差分数组、线段树           |



# 9. **排序与搜索**

## 常见题型：

- 快速排序、归并排序实现
- 二分查找
- 寻找第K大元素

## 解题策略：

- **二分查找**：适用于单调性问题，如查找目标值或区间范围。
- **快速选择**：用于求第K大/小的元素。

------

# 10. **数学问题**

## 常见题型：

- 质数判定
- 最大公约数和最小公倍数
- 数组中的逆序对
- 幂运算与模运算

## 解题策略：

- **埃氏筛法**：高效寻找质数。
- **欧几里得算法**：计算最大公约数。
- **快速幂**：处理大数幂运算。

------

# 11. **字符串处理**

## 常见题型：

- 最长回文子串
- 字符串匹配（KMP算法、Rabin-Karp算法）
- 字符串的压缩与解压

## 解题策略：

- **动态规划**：求解字符串的子问题，如回文子串问题。
- **双指针**：解决左右对称或翻转问题。
- **哈希表**：快速统计字符频率或子串匹配。

------

# 通用解题步骤：

1. **明确问题**：读题时提取关键条件，理解问题的本质。
2. **确定解法**：选择适合题目的算法（贪心、动态规划、回溯等）。
3. **优化代码**：考虑时间和空间复杂度，尝试简化逻辑。
4. **测试边界条件**：确保代码在特殊情况下也能正常运行。

希望这些解题策略能帮助你在算法面试中取得好成绩！如果有具体题目需要探讨，可以随时提出！
