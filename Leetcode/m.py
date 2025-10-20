# leetcode longest palindromic substring
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        start, end = 0, 0
        for i in range(len(s)):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i+1)
            maxLen = max(len1, len2)
            if maxLen > end - start:
                start = i - (maxLen - 1) // 2
                end = i + maxLen // 2
        return s[start:end+1]