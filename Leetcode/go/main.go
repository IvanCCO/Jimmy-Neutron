package main

import (
	"fmt"
)

func longestCommonPrefix(strs []string) string {

	if len(strs) == 0 {
		return ""
	}

	// pega palavra referencia
	word := strs[0]

	for _, s := range strs {

		i := 0

		for ; i < len(word) && i < len(s) && s[i] == word[i]; i++ {
		}

		word = word[:i]
	}

	return word
}

func main() {

	strs :=
		[]string{"flower", "", "flight"}

	fmt.Println(longestCommonPrefix(strs))
}
