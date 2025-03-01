class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        if not pre:
            return None
        root = TreeNode(post.pop())
        if len(pre) == 1:
            return root
        rightIndex = pre.index(post[-1])
        root.right = self.constructFromPrePost(pre[rightIndex:], post)
        root.left = self.constructFromPrePost(pre[1:rightIndex], post)
        return root