func numJewelsInStones(J string, S string) int {
    var ret int = 0;
    var num [128] int;
    for i := 0; i < len(J); i++ {
        num[J[i]] = 1;
    }
    for j := 0; j < len(S); j++ {
        if num[S[j]] == 1 {
            ret++;
        }
    }
    return ret;

}