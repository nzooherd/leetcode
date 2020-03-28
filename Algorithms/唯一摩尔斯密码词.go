func uniqueMorseRepresentations(words []string) int {
	var morseValues = [...]string{".-", "-...", "-.-.",
		"-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
		".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
		"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."}
	var morseMap map[rune]string
	var retMap map[string]int
	morseMap = make(map[rune]string)
	retMap = make(map[string]int)
	for i := 0; i < 26; i++ {
		morseMap[rune(i+'a')] = morseValues[i]
	}
	for _, s := range words {
		var str string
		for _, c := range s {
			str += morseMap[c]
		}
		retMap[str] = 1
	}
	return len(retMap)
}