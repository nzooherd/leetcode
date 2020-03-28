func hasAlternatingBits(n int) bool {
    return (n + (n >> 1) ) & ((n + (n >> 1)) + 1) == 0;
}