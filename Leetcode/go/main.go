package main

import (
	"fmt"
	"reflect"
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

// Esse solucao consiste em armazenar dentro de uma array que representa as letras do alfabeto a quantidade
// de vezes que a letra aparece depois ir vendo se tem ainda a letra, se tiver continue se não tiver retorna false
// Como sei que o input são letras minusculas consigo usar a tabela ascii que vai de 97 até 122
// O Ox61 é a representação em hexadecimal do 97 que é a primeira posícão da tabela ascci das letras minuscalas
// ou seja o "a"
func canConstructV2(ransomNote string, magazine string) bool {

	if len(ransomNote) > len(magazine) {
		return false
	}

	alphabet := make([]int, 26)

	for _, s := range magazine {
		alphabet[s-0x61]++
	}

	for _, s := range ransomNote {
		if alphabet[s-'a'] <= 0 {
			return false
		}
		alphabet[s-0x61]--
	}
	fmt.Println(reflect.TypeOf(alphabet))
	return true
}

// Does not work lol 🤣
func isIsomorphic(s string, t string) bool {

	hashS := make(map[byte]bool)
	hashT := make(map[byte]bool)

	for j, i := range s {
		hashS[byte(i)] = true
		hashT[byte(t[j])] = true
	}

	fmt.Println(len(hashT))

	return len(hashS) == len(hashT)
}

func main() {

	fmt.Println(isIsomorphic("pop", "lil"))
}
