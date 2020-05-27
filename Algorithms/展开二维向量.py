class Vector2D:

    def __init__(self, v: List[List[int]]):
        self.v = v
        self.curValue = None
        self.v_iter = iter(v)
        self.i_iter = None

    def next(self) -> int:
        if self.curValue is not None:
            temp = self.curValue
            self.curValue = None
            return temp
        
        if self.i_iter:
            try:
                return next(self.i_iter)
            except StopIteration:
                self.i_iter = None
                pass
    
        value = None
        while(value is None):
            value = next(self.v_iter)
            if isinstance(value, list):
                    self.i_iter = iter(value)
                    try:
                        value = next(self.i_iter)
                    except StopIteration:
                        value = None
        return value

    def hasNext(self) -> bool:
        if self.curValue is not None:
            return True
        try:
            self.curValue = self.next()
        except StopIteration:
            return False
        return True



# Your Vector2D object will be instantiated and called as such:
# obj = Vector2D(v)
# param_1 = obj.next()
# param_2 = obj.hasNext()