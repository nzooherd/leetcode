func convert(s string, numRows int) string {
    if(numRows == 1) {
        return s
    }
       var css [][]rune
       css = make([][]rune, numRows)
       for i, _ := range css {
           css[i] = make([]rune, 0)
      }
      mod := 2 * numRows - 2
      for i := 0; i < len(s); i++ {
          index := i % mod
          if index >= numRows {
              index = numRows - (index - numRows) - 2
          }
          css[index] = append(css[index], rune(s[i]))
      }
      var ret []rune
      ret = make([]rune, len(s))
      index := 0
      for i := 0; i < len(css); i++ {
          for j := 0; j < len(css[i]); j++ {
              ret[index] = css[i][j]
              index++
          }
      }
      return string(ret)
  }