#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T; cin >> T;
    while (T--) {
        string S; cin >> S;
        int N = S.length();
        vector<int> freq(26, 0);
        for (char c : S) {
            freq[c - 'a']++;
        }
        
        // Check impossibility
        bool possible = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > (N + 1) / 2) {
                possible = false;
                break;
            }
        }
        if (!possible) {
            cout << "No\n";
            continue;
        }
        // algo: place the highest freq char that is not immediately b4
        cout << "Yes\n";
        string output = "";
        while (output.size() < N) {
            // find largest
            int highest = 0, targetIdx = 0;
            for (int i = 0; i < 26; i++) {
                // if str is empty
                if (output.size() > 0 && output[output.size() - 1] == 'a' + i) {
                    continue;
                }
                if (freq[i] > highest) {
                    highest = freq[i];
                    targetIdx = i;
                }
            }
            output += targetIdx + 'a';
            freq[targetIdx]--;
        }
        cout << output << "\n";
    }
    return 0;
}
