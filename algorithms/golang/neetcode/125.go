package solution

func isPalindrome(s string) bool {
	if len(s) < 2 {
		return true
	}

	var b byte
	asciiMap := make(map[byte]int)
	for b = '0'; b <= '9'; b++ {
		asciiMap[b] = 1
	}
	for b = 'A'; b <= 'Z'; b++ {
		asciiMap[b] = 2
	}
	for b = 'a'; b <= 'z'; b++ {
		asciiMap[b] = 3
	}

	i := 0
	j := len(s) - 1
	sb := []byte(s)

	for i < j {
		// fmt.Printf("%d, %d\n", i, j)
		// if one of them is not alphanumeric, move idx
		if asciiMap[sb[i]] == 0 {
			i++
			continue
		}
		if asciiMap[sb[j]] == 0 {
			j--
			continue
		}

		// if one of them is number, the other one must be the same number
		if asciiMap[sb[i]] == 1 || asciiMap[sb[j]] == 1 {
			if sb[i] != sb[j] {
				return false
			}

			goto PROCEED
		}

		// make it lowercase
		if asciiMap[sb[i]] == 3 {
			sb[i] -= 'a' - 'A'
		}
		if asciiMap[sb[j]] == 3 {
			sb[j] -= 'a' - 'A'
		}

		if sb[i] != sb[j] {
			return false
		}

	PROCEED:
		i++
		j--
	}

	return true
}
