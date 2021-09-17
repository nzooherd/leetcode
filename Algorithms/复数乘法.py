class Solution:
    def complexNumberMultiply(self, a: str, b: str) -> str:
        def str2complex(complex_str):
            complex_str = complex_str[:-1]
            a_str, b_str = complex_str.split("+")
            return int(a_str), int(b_str)
        
        a1, b1 = str2complex(a)
        a2, b2 = str2complex(b)

        resa = a1 * a2 - b1 * b2
        resb = a1 * b2 + a2 * b1
        return str(resa) + "+" + str(resb) + "i"

            
