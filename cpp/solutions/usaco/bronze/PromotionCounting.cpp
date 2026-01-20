#include <bits/stdc++.h>
using namespace std;

int main() {
    int og[4], final[4], adv[4];
    int ogSum = 0, finalSum = 0; 
    for (int i = 0; i < 4; i++) {
        cin >> og[i];
        cin >> final[i];
        ogSum += og[i];
        finalSum += final[i];
    }
    og[0] += finalSum - ogSum;
    for (int i = 3; i > 0; i--) {
        if (og[i] == final[i]) {
            continue;
        }
        for (int j = i - 1; j >= 0; j--) {
            int amt = min(final[i] - og[i], og[j]);
            og[i] += amt;
            og[j] -= amt;
            for (int k = j + 1; k <= i; k++) {
                adv[k] += amt;
            }
            if (og[i] == final[i]) {
                break;
            }
        }
    }
    for (int i = 1; i < 4; i++) {
        cout << adv[i] << "\n";
    }
}
