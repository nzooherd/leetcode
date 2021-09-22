class Solution(object):
    def expTree(self, s):
        """
        :type s: str
        :rtype: Node
        """
        order = {"*": 1, "/": 1, "+": 2, "-": 2}
        tokens = [_ for _ in s]

        node_stack = []
        operator_stack = []

        for token in tokens:
            if token not in order and token != "(" and token != ")":
                node_stack.append(Node(token))
                continue
            
            if token == "(":
                operator_stack.append("(")
            elif token == ")":
                while (operator_stack[-1] != "("):
                    operator = operator_stack.pop()
                    right = node_stack.pop()
                    left = node_stack.pop()
                    node_stack.append(Node(operator, left, right))
                operator_stack.pop() 
            else:
                while (len(operator_stack) > 0 and operator_stack[-1] in order and order[operator_stack[-1]] <= order[token]):
                    operator = operator_stack.pop()
                    right = node_stack.pop()
                    left = node_stack.pop()
                    node_stack.append(Node(operator, left, right))
                
                operator_stack.append(token)

        while (len(operator_stack) > 0):
            operator = operator_stack.pop()
            right = node_stack.pop()
            left = node_stack.pop()
            node_stack.append(Node(operator, left, right))
        
        return node_stack[0]
