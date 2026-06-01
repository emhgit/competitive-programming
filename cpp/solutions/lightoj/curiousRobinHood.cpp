#include <bits/stdc++.h>
using namespace std;

// https://lightoj.com/problem/curious-robin-hood

struct FenwickTreeSum
{
    vector<int> bit;
    int N;

    FenwickTreeSum(int N)
    {
        this->N = N;
        bit.assign(N + 1, 0);
    }

    void buildBIT(vector<int> a)
    {
        for (int i = 1; i <= N; i++)
        {
            bit[i] += a[i - 1];
            int next = i + (i & -(i));
            if (next <= N)
            {
                bit[next] += bit[i];
            }
        }
    }

    void update(int i, int delta)
    {
        for (; i <= N; i += (i & -(i)))
        {
            bit[i] += delta;
        }
    }

    int getSum(int i)
    {
        int sum = 0;
        for (; i > 0; i -= (i & -(i)))
        {
            sum += bit[i];
        }
        return sum;
    }
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    int idx = 1;
    while (T--)
    {
        int N, Q;
        cin >> N >> Q;
        vector<int> sacks(N);
        for (int i = 0; i < N; i++)
        {
            cin >> sacks[i];
        }
        FenwickTreeSum BIT(N);
        BIT.buildBIT(sacks);
        cout << "Case " << idx++ << ":\n";
        while (Q--)
        {
            int type;
            cin >> type;
            if (type == 1)
            {
                int i;
                cin >> i;
                cout << sacks[i] << "\n";
                BIT.update(i + 1, -sacks[i]);
                sacks[i] = 0;
            }
            else if (type == 2)
            {
                int i, v;
                cin >> i >> v;
                sacks[i] += v;
                BIT.update(i + 1, v);
            }
            else
            {
                int i, j;
                cin >> i >> j;
                cout << BIT.getSum(j + 1) - BIT.getSum(i + 1 - 1) << "\n";
            }
        }
    }
}
