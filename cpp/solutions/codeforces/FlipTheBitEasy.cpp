#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    while (T--)
    {
        int N, K;
        cin >> N >> K;
        vector<int> a(N);
        for (int i = 0; i < N; i++)
        {
            cin >> a[i];
        }
        int P;
        cin >> P;
        int target = a[P - 1];
        int leftCount = 0;
        for (int i = P - 2; i >= 0; i--)
        {
            if (a[i] != target && a[i + 1] == target)
            {
                leftCount++;
            }
        }
        int rightCount = 0;
        for (int i = P; i < N; i++)
        {
            if (a[i] != target && a[i - 1] == target)
            {
                rightCount++;
            }
        }
        cout << max(leftCount * 2, rightCount * 2) << "\n";
    }
}
