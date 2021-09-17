class ProductOfNumbers:

    def __init__(self):
        self.products = []


    def add(self, num: int) -> None:
        if(num == 0):
            self.products.clear()
            return

        if not self.products:
            self.products.append(num)
        else:
            self.products.append(self.products[-1] * num)

    def getProduct(self, k: int) -> int:
        if k > len(self.products):
            return 0

        return (self.products[-1] // ((self.products[len(self.products) - k - 1]) if len(self.products) > k else 1))

