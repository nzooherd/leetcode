func longestPalindrome(s string) string {
	var ss []byte
	ss = make([]byte, 2*len(s)+2)
	var p []int
	p = make([]int, 2*len(ss)+2)
	ss[0] = '$'
	ss[1] = '#'
	for i, _ := range s {
		ss[2*i+2] = s[i]
		ss[2*i+3] = '#'
	}
	var mx, id, resLen, resCenter int = 0, 0, 0, 0
	for i := 1; i < len(p); i++ {
		if mx > i {
			if p[2*id-i] < mx-i {
				p[i] = p[2*id-i]
			} else {
				p[i] = mx - i
			}
		} else {
			p[i] = 1
		}
		for i+p[i] < len(ss) && ss[i+p[i]] == ss[i-p[i]] {
			p[i] += 1
		}
		if mx < i+p[i] {
			mx = i + p[i]
			id = i
		}
		if resLen < p[i] {
			resLen = p[i]
			resCenter = i
		}
	}

	return s[(resCenter-resLen)/2 : (resCenter+resLen)/2-1]   
}