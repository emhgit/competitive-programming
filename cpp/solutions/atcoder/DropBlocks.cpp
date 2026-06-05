#include <bits/stdc++.h>
using namespace std;

// https://atcoder.jp/contests/abc459/tasks/abc459_c

struct FenwickTreeSum
{
    // 1-based indexed fenwick tree
    vector<int> bit;
    int N;

    FenwickTreeSum(int n)
    {
        this->N = n;
        bit.assign(this->N, 0);
    }

    void update(int i, int delta)
    {
        for (; i < N; i = ((i | (i + 1))))
        {
            bit[i] += delta;
        }
    }

    int getSum(int i)
    {
        int sum = 0;
        for (; i >= 0; i = ((i & (i + 1)) - 1))
        {
            sum += bit[i];
        }
        return sum;
    }
};

int main()
{
    int N, Q;
    cin >> N >> Q;
    const int MAX_SIZE = 300000;
    vector<int> blocks(N), freq(MAX_SIZE + 1);
    FenwickTreeSum BIT(MAX_SIZE + 1);
    freq[0] = N;
    BIT.update(0, N);
    int minHeight = 0;
    while (Q--)
    {
        int type, val;
        cin >> type >> val;
        if (type == 1)
        {
            int prevFreq = blocks[val - 1];
            int newFreq = prevFreq + 1;
            freq[prevFreq]--;
            freq[newFreq]++;
            blocks[val - 1]++;
            BIT.update(prevFreq, -1);
            BIT.update(newFreq, 1);
            while (!freq[minHeight])
            {
                minHeight++;
            }
        }
        else
        {
            int cellsWithAtLeastValBlocks = N - BIT.getSum(val - 1 + minHeight);
            cout << cellsWithAtLeastValBlocks << "\n";
        }
    }
}
