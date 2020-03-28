type Pair struct {
	c   rune
	num int
}
type pairList []Pair

func (p pairList) Swap(i, j int) { p[i], p[j] = p[j], p[i] }
func (p pairList) Len() int      { return len(p) }
func (p pairList) Less(i, j int) bool {
	return p[i].num > p[j].num
}

func frequencySort(s string) string {
	cs := make([]rune, len(s))
	ps := make(pairList, 0)
	var m = make(map[rune]int)
	for _, v := range s {
		if _, ok := m[v]; ok {
			m[v]++
		} else {
			m[v] = 1
		}
	}
	for k, v := range m {
		ps = append(ps, Pair{k, v})
	}
	sort.Sort(ps)
	index := 0
	for _, p := range ps {
		for j := 0; j < p.num; j++ {
			cs[index] = p.c
			index++
		}
	}
	return string(cs)
}
