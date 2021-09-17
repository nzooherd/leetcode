class BrowserHistory:

    def __init__(self, homepage: str):
        self.visit_url = [homepage]
        self.cur_index = 0
        self.end_index = 0


    def visit(self, url: str) -> None:
        if self.cur_index < len(self.visit_url) - 1:
            self.visit_url[self.cur_index + 1] = url
        else:
            self.visit_url.append(url)
        self.cur_index += 1
        self.end_index = self.cur_index


    def back(self, steps: int) -> str:
        self.cur_index -= steps
        self.cur_index = 0 if self.cur_index < 0 else self.cur_index
        return self.visit_url[self.cur_index]

    def forward(self, steps: int) -> str:
        self.cur_index += steps
        self.cur_index = self.end_index if self.cur_index > self.end_index else self.cur_index
        return self.visit_url[self.cur_index]



# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)