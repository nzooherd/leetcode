import queue
class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue1 = queue.Queue()
        self.queue2 = queue.Queue()


    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.queue1.put(x)


    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        while not self.queue1.empty():
            val = self.queue1.get()
            if self.queue1.empty():
                self.queue1, self.queue2 = self.queue2, self.queue1
                return val
            self.queue2.put(val)

        self.queue1, self.queue2 = self.queue2, self.queue1

    def top(self) -> int:
        """
        Get the top element.
        """
        result = None
        while not self.queue1.empty():
            val = self.queue1.get()
            if self.queue1.empty():
                result = val
            self.queue2.put(val)

        self.queue1, self.queue2 = self.queue2, self.queue1
        return result

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return self.queue1.empty()


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()