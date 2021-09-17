import random

class Node:

    def __init__(self, val, right=None, down=None):
        self.val = val
        self.right = right
        self.down = down

    def __str__(self):
        res_str = []
        cur_node = self
        while(cur_node):
            res_str.append(str(cur_node.val))
            cur_node = cur_node.right
        return ",".join(res_str)

class Skiplist:

    def __init__(self):
        self.head = Node(0)
        self.rand_boundars = [1, 2]

    def search(self, target: int) -> bool:
        cur_node = self.head
        while(cur_node):
            while(cur_node.right is not None and cur_node.right.val  < target):
                cur_node = cur_node.right

            if cur_node.right and cur_node.right.val == target:
                return True

            cur_node = cur_node.down

        return False


    def add(self, num: int) -> None:
        path_nodes = []
        cur_node = self.head
        while(cur_node):
            while(cur_node.right is not None and cur_node.right.val < num):
                cur_node = cur_node.right

            path_nodes.append(cur_node)
            cur_node = cur_node.down

        down_node = None
        while(path_nodes):
            pre_node = path_nodes.pop()
            cur_node = Node(num, right=pre_node.right, down=down_node)
            pre_node.right = cur_node
            down_node = cur_node

            insert = (random.randint(*self.rand_boundars) % 2 == 1)
            if not insert:
                break

        if(insert):
            self.head = Node(self.head.val, down=self.head, right=Node(num, down=down_node))

    def erase(self, num: int) -> bool:
        cur_node = self.head
        exists = False
        while(cur_node):
            while(cur_node.right is not None and cur_node.right.val < num):
                cur_node = cur_node.right

            if cur_node.right and cur_node.right.val == num:
                exists = True
                cur_node.right = cur_node.right.right

            cur_node = cur_node.down

        return exists

    def ptstr(self):
        cur_node = self.head
        while(cur_node):
            print(cur_node)
            cur_node = cur_node.down