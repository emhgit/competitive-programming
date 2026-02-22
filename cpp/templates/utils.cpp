#include <bits/stdc++.h>
using namespace std;

/**
 * Performs a Caesar Cipher on the argument s, shifting each char in s by a specified number of times
 * @param s The string to perform a Caesar Cipher on
 * @param shift An int indicating the amount of places to shift each char in s
 */
string caesarCipher(string s, int shift) {
    for (int i = 0; i < s.length(); i++) {
        if (isupper(s[i])) {
            s[i] = (char) (((s[i] + shift) - 'A') % 26 + 'A');
        } else {
            s[i] = (char) (((s[i] + shift) - 'a') % 26 + 'a');
        }
    }
    return s;
}