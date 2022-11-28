## 队列1:
### 题目：
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效.<br/>
有效字符串需满足：
* 左括号必须用相同类型的右括号闭合。
* 左括号必须以正确的顺序闭合。
* 注意空字符串可被认为是有效字符串。
***
#### Java代码：
```java
    Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char aChar : chars) {
            if(aChar == '('){
                deque.push(')');
            }
            else if(aChar == '{'){
                deque.push('}');
            }
            else if(aChar == '['){
                deque.push(']');
            }
            else if(deque.isEmpty() || deque.peek() != aChar){
                System.out.println("false");
                return;
            }
            else{
                deque.pop();
            }
        }
        if(deque.isEmpty()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
```
***
## 队列2
### 题目
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
<br/>
#### 示例： ####
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
<br/>
#### 提示： ####
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
***
#### Java代码
````java
        String next = scanner.next();
        char[] chars = next.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char aChar : chars) {
            if(deque.isEmpty()){
                deque.push(aChar);
            }else if(deque.peek() != aChar){
                deque.push(aChar);
            }
            else{
                deque.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while(!deque.isEmpty()){
            str.insert(0, deque.pop());
        }
        System.out.println(str);
````
***
## 回溯1
#### Java代码
```` java
    static ArrayList<List<Integer>> resList = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        back(n,k,1);
        System.out.println(resList);
    }

    public static void back(int n,int k ,int i){
        if(list.size() == k){
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n - (k - list.size()) + 1; j++) {
            list.add(j);
            back(n,k,j+1);
            list.removeLast();
        }
    }
````
***
## 贪心1
#### Java代码
```java
 Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int pre = 0;
        int dan = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            dan = nums[i-1] - nums[i];
            if(dan < 0 && pre >= 0 || dan > 0 && pre <= 0){
                count++;
            }
            pre = dan;
        }
        System.out.println(count);
```
