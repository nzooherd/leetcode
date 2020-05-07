class Solution:
    def toHexspeak(self, num: str) -> str:
        hex_num_str = hex(int(num))[2:].upper().replace('1', 'I').replace('0', 'O')
        for c in hex_num_str:
            if c >= '1' and c <= '9':
                return "ERROR"
        return hex_num_str
    