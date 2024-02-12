package main

import "testing"

func Test_longestCommonPrefix(t *testing.T) {
	tests := []struct {
		name   string
		strs   []string
		prefix string
	}{
		{
			name:   "Example 1",
			strs:   []string{"flower", "flow", "flight"},
			prefix: "fl",
		},
		{
			name:   "No common prefix",
			strs:   []string{"dog", "racecar", "car"},
			prefix: "",
		},
		{
			name:   "Empty input",
			strs:   []string{},
			prefix: "",
		},
		{
			name:   "Single string",
			strs:   []string{"hello"},
			prefix: "hello",
		},
		{
			name:   "All empty strings",
			strs:   []string{"", "", ""},
			prefix: "",
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := longestCommonPrefix(tt.strs)
			if result != tt.prefix {
				t.Errorf("Expected prefix: %s, got: %s", tt.prefix, result)
			}
		})
	}
}
