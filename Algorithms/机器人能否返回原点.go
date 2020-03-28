func judgeCircle(moves string) bool {
    var x int = 0;
    var y int = 0;
    for i := 0; i < len(moves); i++ {
        if moves[i] == 'R' {
            x++;
        } else if moves[i] == 'L' {
            x--;
        } else if moves[i] == 'U' {
            y++;
        } else if moves[i] == 'D' {
            y--;
        } 

    }
    if x == 0 && y == 0 {
        return true;
    }
    return false;
}