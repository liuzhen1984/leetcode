**1249. Minimum Remove to Make Valid Parentheses**

```python
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        removing = set()
        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            if char == ')':
                if not stack:
                    removing.add(i)
                else:
                    stack.pop()

        while stack:
            removing.add(stack.pop())

        result = ''
        for i, char in enumerate(s):
            if i not in removing:
                result += char

        return result
```

**680. Valid Palindrome II (T: O(n), S: O(1))**

```python
class Solution:
    def validPalindrome(self, s: str) -> bool:
        def validWithoutDelete(start, end) -> bool:
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True

        start, end = 0, len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return validWithoutDelete(start + 1, end) or validWithoutDelete(start, end - 1)
            start += 1
            end -= 1

        return True
```

**314. Binary Tree Vertical Order Traversal**

```python
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        col2value = defaultdict(list)
				# THREE array level
        queue = [[[root, 0]]]

        while queue:
            currLevel = queue.pop(0)
            nextLevel = []
            for nodeCol in currLevel:
                node = nodeCol[0]
                col = nodeCol[1]
                col2value[col].append(node.val)

                if node.left:
                    nextLevel.append([node.left, col - 1])
                if node.right:
                    nextLevel.append([node.right, col + 1])
            if nextLevel:
                queue.append(nextLevel)

        result = []
        for key in sorted(col2value.keys()):
            result.append(col2value[key])

        return result
```

**1762. Buildings With an Ocean View**

```python
class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        stack = []

        for i, h in enumerate(heights):
						# check stack!
            while stack and h >= heights[stack[-1]]:
                stack.pop()
            stack.append(i)

        return stack
```

**1570. Dot Product of Two Sparse Vectors**

*** https://leetcode.com/problems/dot-product-of-two-sparse-vectors/ ***

```python
class SparseVector:
    def __init__(self, nums: List[int]):
        self.index2value = defaultdict(int)
        for i, n in enumerate(nums):
            if n:
                self.index2value[i] = n

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        result = 0
        for k in self.index2value.keys():
            if self.index2value[k] and vec.index2value[k]:
                result += self.index2value[k] * vec.index2value[k]
        return result
```

**1650. Lowest Common Ancestor of a Binary Tree III**

```python
class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        pParent = set()
        while p:
            pParent.add(p)
            p = p.parent

        while q:
            if q in pParent:
                return q
            q = q.parent

        return None
```

**938. Range Sum of BST**

```python
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def dfs(node, result):
            if low <= node.val <= high:
                result += node.val

            if node.val >= low and node.left:
                result = dfs(node.left, result)
            if node.val <= high and node.right:
                result = dfs(node.right, result)
            return result

        return dfs(root, 0)
```

😬

**528. Random Pick with Weight**

```python
class Solution:

    def __init__(self, w: List[int]):
        self.weight_sum_array = []
        weight_sum = 0
        for curr_w in w:
            weight_sum += curr_w
            self.weight_sum_array.append(weight_sum)
        self.total_sum = weight_sum


    def pickIndex(self) -> int:
        target = self.total_sum * random.random()

        start, end = 0, len(self.weight_sum_array)
        while start <= end:
            mid = start + (end - start) // 2 # mid = 0
            if self.weighted_array[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        return start
```

**339. Nested List Weight Sum**

```python
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        def dfs(ele, level, result) -> int:
            if ele.isInteger():
                result += ele.getInteger() * level
            else:
                for e in ele.getList():
                    result = dfs(e, level + 1, result)
            return result

        result = 0
        for ele in nestedList:
            result += dfs(ele, 1, 0)
        return result
```

**408. Valid Word Abbreviation**

```python
class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        # corner cases:
        # 1. all num (and larger than total length)
        # 2. end with num
        # 3. leading 0
        # 4. num + letter > total_len

        wordIdx, abbrIdx = 0, 0
        digitCnt = 0
        # su bst i t u ti on
        # 01 234 5 6 7 89 1011

        while abbrIdx < len(abbr):
            if abbr[abbrIdx].isdigit():
                digitCnt = digitCnt * 10 + int(abbr[abbrIdx])
                if digitCnt == 0:
                    return False
            else:
                wordIdx += digitCnt
                # remember to clear it
                digitCnt = 0
                # check digit and length
                if wordIdx < len(word) and word[wordIdx] != abbr[abbrIdx]:
                    return False
                wordIdx += 1
            abbrIdx += 1

        return wordIdx + digitCnt == len(word)
```

**921. Minimum Add to Make Parentheses Valid**

```python
class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        count = 0
        stack = []

        for c in s:
            if c == '(':
                stack.append(c)
            else:
                if not stack:
                    count += 1
                else:
                    stack.pop()

        return count + len(stack)

class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        cnt = 0
        add = 0
        for char in s:
            if char == '(':
                cnt += 1
            if char == ')':
                if cnt <= 0:
                    add += 1
                else:
                    cnt -= 1

        return add + cnt
```

**236. Lowest Common Ancestor of a Binary Tree**

```python
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.result = None

        def dfs(node) -> int:
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)
            isSelf = node is p or node is q

            if left + right + isSelf == 2:
                self.result = node

            # return true if any of three is true
            return left or right or isSelf

        dfs(root)
        return self.result
```

😬

**227. Basic Calculator II**

```python
class Solution:
    def calculate(self, s: str) -> int:
        # corner cases:
        # 1. " 3/2 " => (c != ' ' and not c.isdigit()) or i == len(s) - 1
		    # negative division: Floor division!!

        curr_num = 0
        curr_operator = '+'
        stack = []

        for i, c in enumerate(s):
            if c.isdigit():
                curr_num = curr_num * 10 + int(c)
            if (c != ' ' and not c.isdigit()) or i == len(s) - 1:
                if curr_operator == '+':
                    stack.append(curr_num)
                elif curr_operator == '-':
                    stack.append(-curr_num)
                elif curr_operator == '/':
                    last_num = stack.pop()
                    if last_num > 0:
                        stack.append(last_num // curr_num)
                    else:
                        stack.append(-(-last_num // curr_num))
                elif curr_operator == '*':
                    last_num = stack.pop()
                    stack.append(last_num * curr_num)
                curr_operator = c
                curr_num = 0

        result = 0
        while stack:
            result += stack.pop()

        return result
```

😬

**CaesarEncoding**

```python
class Solution:
    def encrypt(self, text, s):
        result = ""
        for i in range(len(text)):
						char = text[i]
            if (char.isupper()):
                result += chr((ord(char) + s - ord('A')) % 26 + ord('A'))
            else:
                result += chr((ord(char) + s - ord('a')) % 26 + ord('a'))
        return result
```

**415. Add Strings**

```python
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        idx1, idx2 = len(num1) - 1, len(num2) - 1
        carry = 0

        result = ''
        while idx1 >= 0 or idx2 >= 0 or carry > 0:
            n1, n2 = 0, 0
            if idx1 >= 0:
                n1 = int(num1[idx1])
            if idx2 >= 0:
                n2 = int(num2[idx2])

            currSum = n1 + n2 + carry
            carry = currSum // 10
            currSum = currSum % 10

            result += str(currSum)

            idx1 -= 1
            idx2 -= 1

				# reverse!!!
        return result[::-1]
```

😬

**1891. Cutting Ribbons**

```python
class Solution:
    def maxLength(self, ribbons: List[int], k: int) -> int:
        total_length = sum(ribbons)
        max_length = total_length // k
        min_length = 1

        result = 0
        while min_length <= max_length:
            mid = min_length + (max_length - min_length) // 2
            curr_pieces = 0
            for r in ribbons:
                curr_pieces += r // mid
            if curr_pieces >= k:
                result = mid
                min_length = mid + 1
            else:
                max_length = mid - 1

        return result
```

**636. Exclusive Time of Functions**

```python
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        result = [0] * n
        last_time_point = 0

        for log in logs:
            log_list = log.split(':')
            # change to int!!!
            func_id = int(log_list[0])
            operator = log_list[1]
            time_point = int(log_list[2])

            if operator == 'start':
                if stack:
                    last_func_id = stack[-1]
                    result[last_func_id] += time_point - last_time_point
                stack.append(func_id)
                last_time_point = time_point
            else:
                last_func_id = stack.pop()
                result[last_func_id] += time_point - last_time_point + 1
                last_time_point = time_point + 1
        return result
```

**721. Accounts Merge**

```python
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        self.visited_accounts = [False] * len(accounts)

        email_to_index = {}
        for index, account in enumerate(accounts):
            i = 1
            while i < len(account):
                if account[i] in email_to_index:
                    email_to_index[account[i]].append(index)
                else:
                    email_to_index[account[i]] = [index]
                i += 1

        def dfs(index, emails):
            if not self.visited_accounts[index]:
                self.visited_accounts[index] = True
                account = accounts[index]
                i = 1
                while i < len(account):
                    email = account[i]
                    emails.add(email)
                    for index in email_to_index[email]:
                        emails = dfs(index, emails)
                    i += 1
            return emails

        result = []
        for i, account in enumerate(accounts):
            if self.visited_accounts[i]:
                continue
            name = account[0]
            emails = set()
            emails = dfs(i, emails)
            curr_account = [name]
            for email in sorted(emails):
                curr_account.append(email)
            result.append(curr_account)
        return result
```

**560. Subarray Sum Equals K**

```python
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        diff_to_count = {
            0: 1
        }

        result = 0
        total_sum = 0
        for n in nums:
            total_sum += n
            diff = total_sum - k
            if diff in diff_to_count:
                result += diff_to_count[diff]
            if total_sum in diff_to_count:
                diff_to_count[total_sum] += 1
            else:
                diff_to_count[total_sum] = 1

        return result
```

**23. Merge k Sorted Lists**

```python
from queue import PriorityQueue

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        sorted_queue = PriorityQueue()
        for list_index, l in enumerate(lists):
            if l:
                # if first item is the same, it will compare the second item!
                sorted_queue.put((l.val, list_index, l))

        dummy_head = ListNode()
        curr_node = dummy_head
        # need to use empty()!
        while not sorted_queue.empty():
            val, list_index, node = sorted_queue.get()
            curr_node.next = node
            curr_node = node
            next_node = node.next
            if next_node:
                sorted_queue.put((next_node.val, list_index, next_node))

        return dummy_head.next
```

**301. Remove Invalid Parentheses (T = 2 ^ (l+r), S = n ^ 2)**

```python
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.result = []

        def is_valid(s):
            count = 0
            for c in s:
                if c == '(':
                    count += 1
                elif c == ')':
                    count -= 1
                if count < 0:
                    return False
            return count == 0

        def remove_element(s, i):
            return s[:i] + s[i + 1:]

        def dfs_helper(s, start, left, right):
            if left == 0 and right == 0 and is_valid(s):
                self.result.append(s)
                return
            i = start
            while i < len(s):
                if i > start and s[i] == s[i - 1]:
                    # otherwise loooop!!
                    i += 1
                    continue
								if s[i] == '(' and left > 0:
                    # don't overwrite s!!!
                    dfs_helper(remove_element(s, i), i, left - 1, right)
                elif s[i] == ')' and right > 0:
                    # don't overwrite s!!!
                    dfs_helper(remove_element(s, i), i, left, right - 1)
                i += 1

        left = 0
        right = 0
        for c in s:
            if c == '(':
                left += 1
            elif c == ')':
                if left == 0:
                    right += 1
                else:
                    left -= 1

        dfs_helper(s, 0, left, right)
        return self.result
```

**246. Strobogrammatic Number**

```python
class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        # In Python, we use a list as a string builder.
        rotated_string_builder = []

        # Remember that we want to loop backward through the string.
        for c in reversed(num):
            if c in {'0', '1', '8'}:
                rotated_string_builder.append(c)
            elif c == '6':
                rotated_string_builder.append('9')
            elif c == '9':
                rotated_string_builder.append('6')
            else: # This must be an invalid digit.
                return False

        # In Python, we convert a list of characters to
        # a string using join.
        rotated_string = "".join(rotated_string_builder)
        return rotated_string == num
```

**426. Convert Binary Search Tree to Sorted Doubly Linked List**

```python
class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        self.head = None
        self.lastNode = None

        # in-order traverse
        def dfs(node):
            if node.left:
                dfs(node.left)
            if not self.head:
                self.head = node
                self.lastNode = node
            else:
                # don't give it right node for now
                self.lastNode.right = node
                node.left = self.lastNode
                self.lastNode = node

            if node.right:
                dfs(node.right)

        dfs(root)
        self.head.left = self.lastNode
        self.lastNode.right = self.head

        return self.head
```

**766. Toeplitz Matrix**

```python
class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        diff_to_val = {}

        for r, row in enumerate(matrix):
            for c, val in enumerate(row):
                if r-c in diff_to_val:
                    if val != diff_to_val[r-c]:
                        return False
                else:
                    diff_to_val[r-c] = val
        return True
```

**71. Simplify Path**

```python
class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []

        path_list = path.split('/')
        for path in path_list:
            if path == '' or path == '.':
                continue
            if path == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(path)

				#important!!!
        return "/" + "/".join(stack)
```

**50. Pow(x, n)**

```python
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(num, n):
            if n == 0:
                return 1
            if n == 1:
                return num
            else:
                # could be odd!!!
                odd = n % 2
                half_pow = helper(num, n // 2)
                if odd:
                    return half_pow * half_pow * num
                else:
                    return half_pow * half_pow

        if n == 0:
            return 1.0
        cnt = abs(n)
        return helper(x, cnt) if n > 0 else 1/helper(x, cnt)
```

**987. Vertical Order Traversal of a Binary Tree (T = n log n, S = n)**

```python
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        col_to_val = {}

        def dfs(node, col, row):
            if not node:
                return
            if col in col_to_val:
                value = col_to_val[col]
                if row in value:
                    value[row].append(node.val)
                else:
                    value[row] = [node.val]
            else:
                col_to_val[col] = {}
                col_to_val[col][row] = [node.val]
            dfs(node.left, col - 1, row + 1)
            dfs(node.right, col + 1, row + 1)

        dfs(root, 0, 0)

        result = []
        for col in sorted(col_to_val.keys()):
            curr_col = []
            for row in sorted(col_to_val[col].keys()):
                if len(col_to_val[col][row]) > 1:
                    col_to_val[col][row] = sorted(col_to_val[col][row])
                for n in col_to_val[col][row]:
                    curr_col.append(n)
            result.append(curr_col)

        return result
```

```python
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        col_to_val = {}

        def dfs(node, col, row):
            if not node:
                return
            if col in col_to_val:
                value = col_to_val[col]
                if row in value:
                    value[row].append(node.val)
                else:
                    value[row] = [node.val]
            else:
                col_to_val[col] = {}
                col_to_val[col][row] = [node.val]
            dfs(node.left, col - 1, row + 1)
            dfs(node.right, col + 1, row + 1)

        dfs(root, 0, 0)

        result = []
        for col in sorted(col_to_val.keys()):
            curr_col = []
            for row in sorted(col_to_val[col].keys()):
                if len(col_to_val[col][row]) > 1:
                    col_to_val[col][row] = sorted(col_to_val[col][row])
                for n in col_to_val[col][row]:
                    curr_col.append(n)
            result.append(curr_col)

        return result
```

**199. Binary Tree Right Side View (T = n, S = d)**

```python
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        queue = [[root]]
        result = []

        while queue:
            curr_level = queue.pop()
            result.append(curr_level[-1].val)
            next_level = []
            for i, node in enumerate(curr_level):
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            if next_level:
                queue.append(next_level)

        return result
```

**215. Kth Largest Element in an Array**

```python
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heappush(heap, -n)

        result = 0
        while k > 0:
            result = heappop(heap)
            k -= 1

        return -result

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return heapq.nlargest(k, nums)[-1]
```

**791. Custom Sort String**

```python
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        order_mapping = {}
        for c in order:
            order_mapping[c] = 0

        rest = ''
        for c in s:
            if c in order_mapping:
                order_mapping[c] += 1
            else:
                rest += c

        result = ''
        for c in order:
            cnt = order_mapping[c]
            while cnt > 0:
                result += c
                cnt -= 1
        return result + rest
```

**1091. Shortest Path in Binary Matrix (T = n, S = n)**

###### by zliu, This algorithm needs to be relearned, My algorithm is so slow
```python
class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        MAX_ROW = len(grid) - 1
        MAX_COL = len(grid[0]) - 1

        if not grid or not grid[0]:
            return -1
        if grid[0][0] == 1 or grid[MAX_ROW][MAX_COL] == 1:
            return -1

        queue = [[[0, 0]]]
        steps = 1

        def helper(x, y):
            next_level = []
            for i in (x - 1, x, x + 1):
                for j in (y - 1, y, y + 1):
                    if i == x and j == y:
                        continue
                    elif i < 0 or i > MAX_ROW or j < 0 or j > MAX_COL:
                        continue
                    elif grid[i][j] == 0:
                        next_level.append([i, j])
            return next_level

        while queue:
            curr_level = queue.pop(0)
            new_level = []
            for pair in curr_level:
                if pair == [MAX_ROW, MAX_COL]:
                    return steps
                else:
                    x = pair[0]
                    y = pair[1]
                    if grid[x][y] != 2:
                        grid[x][y] = 2
                        next_level = helper(x, y)
                        for l in next_level:
                            new_level.append(l)
            if new_level:
                queue.append(new_level)
            steps += 1

        return -1
```

**543. Diameter of Binary Tree**

```python
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.result = 0

        def dfs(node) -> int:
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            self.result = max(self.result, left + right)
            return max(left, right) + 1

        dfs(root)
        return self.result
```

**523. Continuous Subarray Sum**

###### by zliu, This algorithm needs to be relearned
```python
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        total_sum = 0
        sum_to_index = {}

        for i, n in enumerate(nums):
            total_sum += n
            mod = total_sum % k

            if mod == 0 and i > 0:
                return True
            # consider [1, 0]!!!
            if mod in sum_to_index and i - sum_to_index[mod] > 1:
                return True
            if mod not in sum_to_index:
                sum_to_index[mod] = i

        return False
```

**249. Group Shifted Strings**

```python
class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        index_diff_to_array = {}

        for s in strings:
            index_diff = ''
            standard = ord(s[0])
            for c in s:
                curr_diff = ord(c) - standard
                if curr_diff < 0:
                    curr_diff = curr_diff + 26
                # if only one digit, we add zero
                if curr_diff <= 9:
                    curr_diff = '0' + str(curr_diff)
                index_diff += str(curr_diff)

            if index_diff in index_diff_to_array:
                index_diff_to_array[index_diff].append(s)
            else:
                index_diff_to_array[index_diff] = [s]

        result = []
        for key in index_diff_to_array.keys():
            result.append(index_diff_to_array[key])

        return result
```

**138. Copy List with Random Pointer**

```python
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        old_node_to_new_node = {}

        new_head = Node(0)

        curr_old_node = head
        curr_new_node = new_head

        while curr_old_node:
            val = curr_old_node.val
            new_node = Node(val)

            old_node_to_new_node[curr_old_node] = new_node
            curr_new_node.next = new_node
            curr_new_node = new_node
            curr_old_node = curr_old_node.next

        curr_old_node = head
        curr_new_node = new_head.next
        while curr_old_node:
            if curr_old_node.random:
                curr_new_node.random = old_node_to_new_node[curr_old_node.random]
            curr_new_node = curr_new_node.next
            curr_old_node = curr_old_node.next

        return new_head.next
```

**133. Clone Graph (T = m + n, S = n) (S: h < n, so O(n))**

```python
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        old_node_to_new_node = {}

        def dfs(old_node):
            if old_node in old_node_to_new_node:
                return old_node_to_new_node[old_node]
            else:
                # when copy one node, copy all the neighbors
                new_node = Node(old_node.val, [])
                old_node_to_new_node[old_node] = new_node
                for n in old_node.neighbors:
                    new_n = dfs(n)
                    new_node.neighbors.append(new_n)
                return new_node

        dfs(node)
        return old_node_to_new_node[node]
```

**129. Sum Root to Leaf Numbers**

```python
class Solution:
    def __init__(self):
        self.result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(root, current_sum):
            current_sum = current_sum * 10 + root.val
            if not root.left and not root.right:
                self.result += current_sum
            else:
                if root.left:
                    dfs(root.left, current_sum)
                if root.right:
                    dfs(root.right, current_sum)

        dfs(root, 0)
        return self.result
```

**1868. Product of Two Run-Length Encoded Arrays**

```python
class Solution:
    def findRLEArray(self, encoded1: List[List[int]], encoded2: List[List[int]]) -> List[List[int]]:
        curr_array_index1, curr_array_index2 = 0, 0
        result = []

        while curr_array_index1 < len(encoded1) or curr_array_index2 < len(encoded2):
            curr_num1 = encoded1[curr_array_index1][0]
            curr_cnt_left1 = encoded1[curr_array_index1][1]

            curr_num2 = encoded2[curr_array_index2][0]
            curr_cnt_left2 = encoded2[curr_array_index2][1]

            curr_product = curr_num1 * curr_num2
            curr_cnt = min(curr_cnt_left1, curr_cnt_left2)

            if result and curr_product == result[-1][0]:
                # don't update curr_cnt!!
                result[-1][1] += curr_cnt
            else:
                result.append([curr_product, curr_cnt])

            encoded1[curr_array_index1][1] -= curr_cnt
            if encoded1[curr_array_index1][1] == 0:
                curr_array_index1 += 1

            encoded2[curr_array_index2][1] -= curr_cnt
            if encoded2[curr_array_index2][1] == 0:
                curr_array_index2 += 1

        return result
```

**515. Find Largest Value in Each Tree Row**

```python
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        queue = [[root]]
        result = []

        while queue:
            curr_row = queue.pop(0)
            max_in_curr_row = curr_row[0].val
            next_level = []
            for node in curr_row:
                max_in_curr_row = max(max_in_curr_row, node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            result.append(max_in_curr_row)
            # check if [] or not!!!!!
            if next_level:
                queue.append(next_level)
        return result
```

**986. Interval List Intersections**

```python
class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        result = []
        first_index, second_index = 0, 0
        while first_index < len(firstList) and second_index < len(secondList):
            first_part = firstList[first_index]
            second_part = secondList[second_index]

            lo = max(first_part[0], second_part[0])
            hi = min(first_part[1], second_part[1])

            # less and equal!!
            if lo <= hi:
                result.append([lo, hi])

            if first_part[1] < second_part[1]:
                first_index += 1
            else:
                second_index += 1

        return result
```

**670. Maximum Swap**

```python
class Solution:
    def maximumSwap(self, num: int) -> int:
        num = list(str(num))
        max_index = len(num) - 1
        swap_1, swap_2 = 0, 0

        i = len(num) - 1
        while i >= 0:
            if num[i] > num[max_index]:
                max_index = i
            elif num[i] < num[max_index]:
                swap_1 = i
                swap_2 = max_index
            i -= 1

        num[swap_1], num[swap_2] = num[swap_2], num[swap_1]
        return int(''.join(num))
```

**1011. Capacity To Ship Packages Within D Days**

```python
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        min_capacity, max_capacity = max(weights), sum(weights)

        while min_capacity < max_capacity:
            mid = min_capacity + (max_capacity - min_capacity) // 2

            cnt = 1
            curr_sum = 0
            for w in weights:
                if curr_sum + w > mid:
                    cnt += 1
                    curr_sum = 0
                curr_sum += w

            if cnt <= days:
                max_capacity = mid
            else:
                min_capacity = mid + 1

        return max_capacity
```

**1047. Remove All Adjacent Duplicates In String**

```python
class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []
        i = 0
        while i < len(s):
            if stack and stack[-1] == s[i]:
                stack.pop()
            else:
                stack.append(s[i])
            i += 1
        return ''.join(stack)
```

**662. Maximum Width of Binary Tree**

```python
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        queue = [[[root, 0]]]
        result = 0

        while queue:
            curr_level = queue.pop()
            result = max(result, curr_level[-1][1] - curr_level[0][1] + 1)
            next_level = []
            for node_col in curr_level:
                node = node_col[0]
                col = node_col[1]
                if node.left:
                    next_level.append([node.left, 2 * col])
                if node.right:
                    next_level.append([node.right, 2 * col + 1])
            if next_level:
                queue.append(next_level)

        return result
```

**1167. Minimum Cost to Connect Sticks**

```python
class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        result = 0
        heapify(sticks)

        while len(sticks) > 1:
            min1 = heappop(sticks)
            min2 = heappop(sticks)
            result += min1 + min2
            heappush(sticks, min1 + min2)

        return result
```

**270. Closest Binary Search Tree Value**

```python
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        node = root
        curr_diff = abs(target - root.val)
        curr_val = root.val

        while node:
            if node.val == target:
                return node.val
            if abs(target - node.val) < curr_diff:
                curr_val = node.val
                curr_diff = abs(target - node.val)
            if node.val < target:
                node = node.right
            else:
                node = node.left

        return curr_val
```

**463. Island Perimeter**

```python
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0

        MAX_ROW = len(grid)
        MAX_COL = len(grid[0])

        result = 0
        for i in range(MAX_ROW):
            for j in range(MAX_COL):
                if grid[i][j] == 1:
                    result += 4
                    if i > 0 and grid[i - 1][j] == 1:
                        result -= 2
                    if j > 0 and grid[i][j - 1] == 1:
                        result -= 2
        return result
```

**31. Next Permutation (T = n, S = 1)**

```python
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 1

        while i >= 0:
            if i > 0 and nums[i - 1] < nums[i]:
                if i == len(nums) - 1:
                    nums[-1], nums[-2] = nums[-2], nums[-1]
                    return
                else:
                    j = len(nums) - 1
                    while j > i - 1:
                        if nums[j] > nums[i - 1]:
                            nums[j], nums[i - 1] = nums[i - 1], nums[j]
                            nums[i:] = nums[i:][::-1]
                            return
                        j -= 1
            i -= 1

        nums.reverse()
        return
```

```python
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        # num = [1, 2, 6, 5, 4, 3]
        # num = [1, 3, 2, 4, 5, 6]

        # find the smaller num
        i = len(nums) - 1
        while i > 0:
            if nums[i] <= nums[i - 1]:
                i -= 1
            else:
                break
        if i == 0:
            nums.reverse()
            return

        # find its position
        j = len(nums) - 1
        while j > 0:
            if nums[j] <= nums[i - 1]:
                j -= 1
            else:
                break
        # swap
        nums[i - 1], nums[j] = nums[j], nums[i - 1]
        # reverse
        nums[i:] = nums[i:][::-1]
        return
```

**166. Fraction to Recurring Decimal**

```python
class Solution:
    def fractionToDecimal(self, numerator, denominator):
        sign = ''
        if numerator * denominator < 0:
            sign = '-'

        n, remainder = divmod(abs(numerator), abs(denominator))
        if remainder == 0:
            return sign + str(n)

        result = [sign + str(n), '.']
        remainder_to_pos = {}

        while remainder > 0 and remainder not in remainder_to_pos:
            remainder_to_pos[remainder] = len(result)
            n, remainder = divmod(remainder*10, abs(denominator))
            result.append(str(n))

        if remainder in remainder_to_pos:
            idx = remainder_to_pos[remainder]
            result.insert(idx, '(')
            result.append(')')

        return ''.join(result)
```

**708. Insert into a Sorted Circular Linked List**

```python
class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        if not head:
            new = Node(insertVal)
            new.next = new
            return new

        first_round = head
        min_value = head.val
        max_value = head.val

        while first_round.next.val != head.val:
            first_round = first_round.next
            min_value = min(min_value, first_round.val)
            max_value = max(max_value, first_round.val)

        curr = head
        while not (curr.val <= insertVal and curr.next.val >= insertVal):
            curr = curr.next
            if curr.next.val == head.val:
                break
        if insertVal <= min_value:
            while curr.next.val is not min_value:
                curr = curr.next
        if insertVal >= max_value:
            while curr.val is not max_value:
                curr = curr.next

        inserted = Node(insertVal, curr.next)
        curr.next = inserted

        return head
```

**827. Making A Large Island**

```python
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        color = 1
				# in case no ONE
        color_to_area = {
            0: 0
        }
        MAX_ROW = len(grid) - 1
        MAX_COL = len(grid[0]) - 1

        def dfs(row, col, color):
            if row < 0 or row > MAX_ROW or col < 0 or col > MAX_COL or grid[row][col] != 1:
                return 0

            grid[row][col] = color

            up = dfs(row - 1, col, color)
            down = dfs(row + 1, col, color)
            left = dfs(row, col - 1, color)
            right = dfs(row, col + 1, color)

            return up + down + left + right + 1

        for r, row in enumerate(grid):
            for c, num in enumerate(row):
                if num == 1:
                    color += 1
                    area = dfs(r, c, color)
                    color_to_area[color] = area

        def get_color(row, col):
            if row < 0 or row > MAX_ROW or col < 0 or col > MAX_COL or grid[row][col] == 0:
                return -1
            return grid[row][col]

        result = 0
        for r, row in enumerate(grid):
            for c, num in enumerate(row):
                if num == 0:
                    color_set = set()
                    color_set.add(get_color(r + 1, c))
                    color_set.add(get_color(r - 1, c))
                    color_set.add(get_color(r, c + 1))
                    color_set.add(get_color(r, c - 1))
                    curr_area = 0
                    for color in color_set:
                        if color > 0:
                            curr_area += color_to_area[color]
                    result = max(result, curr_area + 1)

				# in case no ZERO
        result = max(result, color_to_area[grid[0][0]])

        return result
```

**1120. Maximum Average Subtree**

```python
class Solution:
    def maximumAverageSubtree(self, root: Optional[TreeNode]) -> float:
        self.max_average = 0

        def dfs(node: Optional[TreeNode]) -> List[int]:
            if not node:
                return [0, 0]

            left = dfs(node.left)
            left_sum = left[0]
            left_cnt = left[1]

            right = dfs(node.right)
            right_sum = right[0]
            right_cnt = right[1]

            curr_sum = node.val + left_sum + right_sum
            curr_cnt = left_cnt + right_cnt + 1
            average = curr_sum / curr_cnt
            self.max_average = max(self.max_average, average)

            return [curr_sum, curr_cnt]

        dfs(root)
        return self.max_average
```

**525. Contiguous Array**

```python
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        index_to_count = {}

        count = 0
        result = 0
        for i, n in enumerate(nums):
            if n == 0:
                count -= 1
            else:
                count += 1

            if count == 0:
                result = max(result, i + 1)
            elif count in index_to_count:
                result = max(result, i - index_to_count[count])
            else:
                index_to_count[count] = i

        return result
```

**295. Find Median from Data Stream**

```python
import heapq

class MedianFinder:

    def __init__(self):
        self.left_heap = []
        self.right_heap = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.left_heap, -num)
        heapq.heappush(self.right_heap, -heapq.heappop(self.left_heap))
        if len(self.left_heap) < len(self.right_heap):
            heapq.heappush(self.left_heap, -heapq.heappop(self.right_heap))

    def findMedian(self) -> float:
        if len(self.left_heap) > len(self.right_heap):
            return -self.left_heap[0]
        else:
            return (-self.left_heap[0] + self.right_heap[0]) / 2
```

**206. Reverse Linked List**