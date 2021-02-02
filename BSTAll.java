public static Node root;
public static Node root1;

private static class Node {
    Node left;
    Node right;
    int data;

    Node(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}

public static void build123a() {
    root = new Node(2);
    Node lChild = new Node(1);
    Node rChild = new Node(3);
    root.left = lChild;
    root.right = rChild;
}

/**
 * Build 123 using only one pointer variable.
 */
public static void build123b() {
    root = new Node(2);
    root.left = new Node(1);
    root.right = new Node(3);
}

/**
 * Build 123 by calling insert() three times. Note that the '2' must be
 * inserted first.
 */
public static void build123c() {
    root = null;
    root = insert(root, 2);
    root = insert(root, 1);
    root = insert(root, 3);
    root = insert(root, 4);
    root = insert(root, 5);
    root = insert(root, 6);
    root = insert(root, 7);
    root = insert(root, 8);
    root = insert(root, 9);
    root = insert(root, 10);
}

public static void build123d() {
    root1 = null;
    root1 = insert(root1, 2);
    root1 = insert(root1, 1);
    root1 = insert(root1, 3);
    root1 = insert(root1, 4);
    root1 = insert(root1, 5);
    root1 = insert(root1, 6);
    root1 = insert(root1, 7);
    root1 = insert(root1, 8);
    root1 = insert(root1, 9);
    // root1 = insert(root1, 10);
}

private static Node insert(Node node, int data) {
    if (node == null) {
        node = new Node(data);
    } else {
        if (data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
    }

    return (node); // in any case, return the new pointer to the caller
}

private static int size(Node node) {
    if (node == null)
        return 0;
    else {
        return size(node.left) + size(node.right) + 1;
    }
}

public static void main(String[] args) {
    build123c();
    build123d();
    System.out.println("size: " + size(root));
    System.out.println("maxdepth: " + maxdepth(root));
    System.out.println("minvalue: " + minvalue(root));
    // inorder(root);
    preorder(root);
    // postorder(root);
    System.out.println("hasPathSum: " + hasPathSum(root, 6));

    System.out.println("sameTree: " + sameTree(root, root1));

    System.out.println("isBst: " + isBST(root));
}

private static int maxdepth(Node node) {
    if (node == null)
        return 0;
    else {
        int ldepth = maxdepth(node.left);
        int rdepth = maxdepth(node.right);
        return (Math.max(ldepth, rdepth)) + 1;
    }
}

public int minDepth(Node root) {
    if (root == null)
        return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

}

private static int minvalue(Node node) {
    Node cur = node;
    while (cur.left != null) {
        cur = node.left;
    }
    return cur.data;
}

private static int maxvalue(Node node) {
    Node cur = node;
    while (cur.right != null) {
        cur = node.right;
    }
    return cur.data;
}

private static void inorder(Node node) {
    if (node == null)
        return;

    inorder(node.left);
    System.out.println("x: " + node.data);
    inorder(node.right);
}

private static void postorder(Node node) {
    if (node == null)
        return;

    inorder(node.left);
    inorder(node.right);
    System.out.println("x: " + node.data);
}

private static void preorder(Node node) {
    if (node == null)
        return;

    System.out.println("x: " + node.data);
    inorder(node.left);
    inorder(node.right);
}

public static boolean hasPathSum(Node node, int sum) {
    if (node == null)
        return (sum == 0);
    else {
        int subnum = sum - node.data;
        return (hasPathSum(node.left, subnum) || hasPathSum(node.right, subnum));
    }
}

static void mirror(Node node) {
    if (node != null) {
        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

private static boolean sameTree(Node a, Node b) {
    if (a == null && b == null)
        return true;
    else if (a != null && b != null) {
        return ((a.data == b.data) && sameTree(a.left, b.left) && sameTree(a.right, b.right));
    } else {
        return false;
    }
}

private static boolean isBST(Node node) {
    if (node == null)
        return true;

    if (node.left != null && maxvalue(node.left) > node.data)
        return false;
    if (node.right != null && minvalue(node.right) <= node.data)
        return false;
    return (isBST(node.left) && isBST(node.right));
}

void inorder() {
    if (root == null) {
        return;
    }

    // keep the nodes in the path that are waiting to be visited
    Stack<Node> stack = new Stack<Node>();
    Node node = root;

    // first node to be visited will be the left one
    while (node != null) {
        stack.push(node);
        node = node.left;
    }

    // traverse the tree
    while (stack.size() > 0) {

        // visit the top node
        node = stack.pop();
        System.out.print(node.data + " ");
        if (node.right != null) {
            node = node.right;

            // the next node to be visited is the leftmost
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}

// An iterative process to print preorder traversal of Binary tree
void iterativePreorder(Node node) {

    // Base Case
    if (node == null) {
        return;
    }

    // Create an empty stack and push root to it
    Stack<Node> nodeStack = new Stack<Node>();
    nodeStack.push(root);

    /*
     * Pop all items one by one. Do following for every popped item a) print
     * it b) push its right child c) push its left child Note that right
     * child is pushed first so that left is processed first
     */
    while (nodeStack.empty() == false) {

        // Pop the top item from stack and print it
        Node mynode = nodeStack.peek();
        System.out.print(mynode.data + " ");
        nodeStack.pop();

        // Push right and left children of the popped node to stack
        if (mynode.right != null) {
            nodeStack.push(mynode.right);
        }
        if (mynode.left != null) {
            nodeStack.push(mynode.left);
        }
    }
}

static void postOrderIterative(Node root) {
    Stack<Node> s1, s2;
    // Create two stacks
    s1 = new Stack<>();
    s2 = new Stack<>();

    if (root == null)
        return;

    // push root to first stack
    s1.push(root);

    // Run while first stack is not empty
    while (!s1.isEmpty()) {
        // Pop an item from s1 and push it to s2
        Node temp = s1.pop();
        s2.push(temp);

        // Push left and right children of
        // removed item to s1
        if (temp.left != null)
            s1.push(temp.left);
        if (temp.right != null)
            s1.push(temp.right);
    }

    // Print all elements of second stack
    while (!s2.isEmpty()) {
        Node temp = s2.pop();
        System.out.print(temp.data + " ");
    }
}

public static void leftSum(Node root, Node parent) {
    if (root != null) {
        leftSum(root.left, root);
        if (root.left == null && root.right == null && parent.left == root) {
            leftLeavesSum += root.data;
        }
        leftSum(root.right, root);
    }
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while (cur != null || !stack.empty()) {
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}

public List<Integer> preorderTraversal(TreeNode node) {
    List<Integer> list = new LinkedList<Integer>();
    Stack<TreeNode> rights = new Stack<TreeNode>();
    while (node != null) {
        list.add(node.val);
        if (node.right != null) {
            rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
            node = rights.pop();
        }
    }
    return list;
}
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();

    if(root == null )
    return result;

    stack.add(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pollcast();
        result.addFirstNode(node.val);
        for(TreeNode child: node.children()) {
            stack.add(child);
        }
    }
    return result;
}

public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (!stack.isEmpty() || p != null) {
        if (p != null) {
            stack.push(p);
            result.addFirst(p.val); // Reverse the process of preorder
            p = p.right; // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left; // Reverse the process of preorder
        }
    }
    return result;
}

public boolean isValidBST(TreeNode root) {
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    return isValidBSTUtil(root, min, max);
}

public boolean isValidBSTUtil(TreeNode root, long min, long max) {
    if (root == null)
        return true;
    return (root.val > min && root.val < max && isValidBSTUtil(root.left, min, root.val)
            && isValidBSTUtil(root.right, root.val, max));
}

/*
 * Given a binary tree, check whether it is a mirror of itself (ie,
 * symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following [1,2,2,null,3,null,3] is not:
 * 1 / \ 2 2 \ \ 3 3
 */

public boolean isSymmetric(TreeNode root) {
    if (root == null)
        return true;
    return isMirror(root.left, root.right);
}

public boolean isMirror(TreeNode p, TreeNode q) {
    if (p == null && q == null)
        return true;
    if (p == null || q == null)
        return false;
    return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
}

public boolean isPowerOfThree(int n) {
    if (n > 1)
        while (n % 3 == 0)
            n /= 3;
    return n == 1;
}

public boolean isPerfectSquare(int num) {
    int i = 1;
    while (num > 0) {
        num -= i;
        i += 2;
    }
    return num == 0;
}

public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
        return 0;
    int ans = 0;
    if (root.left != null) {
        if (root.left.left == null && root.left.right == null)
            ans += root.left.val;
        else
            ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);

    return ans;
}

public ListNode swapPairs(ListNode head) {
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode current = dummy;
while (current.next != null && current.next.next != null) {
    ListNode first = current.next;
    ListNode second = current.next.next;
    first.next = second.next;
    current.next = second;
    current.next.next = first;
    current = current.next.next;
}
return dummy.next;
} }
