#include <bits/stdc++.h>
using namespace std;

// https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3238

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

    void set(int prev, int i, int delta)
    {
        for (; i <= N; i += (i & -(i)))
        {
            bit[i] += delta - prev;
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
    int N;
    cin >> N;
    int idx = 1;
    while (N != 0)
    {
        vector<int> potmeters(N);
        for (int i = 0; i < N; i++)
        {
            cin >> potmeters[i];
        }
        FenwickTreeSum BIT(N);
        BIT.buildBIT(potmeters);
        string type;
        cin >> type;
        cout << "Case " << idx++ << ":\n";
        while (type != "END")
        {
            if (type == "S")
            {
                int potmeter;
                cin >> potmeter;
                int resistance;
                cin >> resistance;
                BIT.set(potmeters[potmeter - 1], potmeter, resistance);
                potmeters[potmeter - 1] = resistance;
            }
            else
            {
                int leftPotmeter, rightPotmeter;
                cin >> leftPotmeter >> rightPotmeter;
                cout << BIT.getSum(rightPotmeter) - BIT.getSum(leftPotmeter - 1) << "\n";
            }
            cin >> type;
        }
        cin >> N;
        if (N != 0)
            cout << "\n";
    }
}
