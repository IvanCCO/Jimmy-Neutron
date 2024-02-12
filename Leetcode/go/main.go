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

func canConstruct(ransomNote string, magazine string) bool {

	if len(ransomNote) > len(magazine) {
		return false
	}

	magazineBytes := []byte(magazine)

	for i, s := range ransomNote {

		found := false
		for j := i; j < len(magazine); j++ {
			if s == rune(magazineBytes[j]) {
				magazineBytes[i], magazineBytes[j] = magazineBytes[j], magazineBytes[i]
				found = true
			}
		}

		if !found {
			return false
		} else if found && i == len(ransomNote)-1 {
			return true
		}

	}

	return false
}

func main() {

	fmt.Println(canConstruct("aa", "b"))
}
