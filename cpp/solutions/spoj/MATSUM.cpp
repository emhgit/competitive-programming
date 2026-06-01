#include <bits/stdc++.h>
using namespace std;

// https://www.spoj.com/problems/MATSUM/

struct FenwickTree2DSum
{
    vector<vector<int>> bit;
    int N;

    FenwickTree2DSum(int N)
    {
        this->N = N;
        bit.assign(N + 1, vector<int>(N + 1, 0));
    }

    void buildBIT(vector<vector<int>> a)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                bit[i][j] = a[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                int nextj = j + (j & -j);
                if (nextj <= N)
                {
                    bit[i][nextj] += bit[i][j];
                }
            }
        }

        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                int nexti = i + (i & -i);
                if (nexti <= N)
                {
                    bit[nexti][j] += bit[i][j];
                }
            }
        }
    }

    void update(int i, int j, int delta)
    {
        for (; i <= N; i += (i & -i))
        {
            for (int k = j; k <= N; k += (k & -k))
            {
                bit[i][k] += delta;
            }
        }
    }

    int getSum(int i, int j)
    {
        int sum = 0;
        for (; i > 0; i -= (i & -(i)))
        {
            for (int k = j; k > 0; k -= (k & -k))
            {
                sum += bit[i][k];
            }
        }
        return sum;
    }

    void printBIT()
    {
        for (vector<int> row : bit)
        {
            for (int i = 0; i < row.size(); i++)
            {
                cout << row[i] << " ";
            }
            cout << "\n";
        }
    }
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    while (T--)
    {
        int N;
        cin >> N;
        vector<vector<int>> matrix(N, vector(N, 0));
        FenwickTree2DSum BIT(N);
        string type;
        cin >> type;
        while (type != "END")
        {
            if (type == "SET")
            {
                int x, y, val;
                cin >> x >> y >> val;
                BIT.update(x + 1, y + 1, val - matrix[x][y]);
                matrix[x][y] = val;
            }
            else
            {
                int x1, y1, x2, y2;
                cin >> x1 >> y1 >> x2 >> y2;
                int sum = BIT.getSum(x2 + 1, y2 + 1) - BIT.getSum(x1 + 1 - 1, y2 + 1) - BIT.getSum(x2 + 1, y1 + 1 - 1) + BIT.getSum(x1 + 1 - 1, y1 + 1 - 1);
                cout << sum << "\n";
            }
            cin >> type;
        }
        cout << "\n";
    }
}
