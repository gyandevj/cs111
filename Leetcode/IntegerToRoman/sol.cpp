#include <string>
class Solution {
    public:
        string intToRoman(int num) {
        static const pair<int, string> roman_numerals[] = {
            {1000, "M"},
            {900, "CM"},
            {500, "D"},
            {400, "CD"},
            {100, "C"},
            {90, "XC"},
            {50, "L"},
            {40, "XL"},
            {10, "X"},
            {9, "IX"},
            {5, "V"},
            {4, "IV"},
            {1, "I"}
        };
        string result;
        for (const auto& p : roman_numerals) {
            while (num >= p.first) {
                result += p.second;
                num -= p.first;
            }
        }
        return result;
        }
    };