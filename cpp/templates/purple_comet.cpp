#include <bits/stdc++.h>
using namespace std;
#include <complex>
using cd = complex<double>;

struct Point
{
    double x, y;
};

// Computes the area of a polygon using the Shoelace Theorem
double shoelaceArea(const vector<Point> &points)
{
    double area = 0.0;
    int n = points.size();
    for (int i = 0; i < n; i++)
    {
        int j = (i + 1) % n; // The next vertex (wraps around)
        area += points[i].x * points[j].y;
        area -= points[j].x * points[i].y;
    }
    return abs(area) / 2.0;
}
vector<long long> getPrimeFactors(long long n)
{
    vector<long long> factors;
    for (long long i = 2; i * i <= n; i++)
    {
        while (n % i == 0)
        {
            factors.push_back(i);
            n /= i;
        }
    }
    if (n > 1)
        factors.push_back(n);
    return factors;
}

// Euclidean Algorithm for GCD
long long gcd(long long a, long long b)
{
    while (b)
    {
        a %= b;
        std::swap(a, b);
    }
    return a;
}

// Two numbers are coprime if their GCD is 1
bool areCoprime(long long a, long long b)
{
    return gcd(a, b) == 1;
}

// Returns all divisors (not just prime)
vector<long long> getAllDivisors(long long n)
{
    vector<long long> divisors;
    for (long long i = 1; i * i <= n; i++)
    {
        if (n % i == 0)
        {
            divisors.push_back(i);
            if (i * i != n)
                divisors.push_back(n / i);
        }
    }
    return divisors;
}

// combinations
long long nCr(int n, int r)
{
    if (r > n)
        return 0;
    if (r == 0 || r == n)
        return 1;
    if (r > n / 2)
        r = n - r; // Symmetry
    long long res = 1;
    for (int i = 1; i <= r; ++i)
    {
        res = res * (n - i + 1) / i;
    }
    return res;
}

double dist(Point a, Point b)
{
    return hypot(a.x - b.x, a.y - b.y);
}

double triangleArea(Point a, Point b, Point c)
{
    return abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
}

double inradius(Point a, Point b, Point c)
{
    double A = triangleArea(a, b, c);
    double p = dist(a, b) + dist(b, c) + dist(c, a);
    return 2 * A / p;
}

// distance from point p to line ab
double pointLineDist(Point a, Point b, Point p)
{
    double num = abs((b.x - a.x) * (a.y - p.y) - (a.x - p.x) * (b.y - a.y));
    double den = dist(a, b);
    return num / den;
}

long double probability(long long favorable, long long total)
{
    return (long double)favorable / total;
}

// quadratic formula
pair<double, double> quadratic(double a, double b, double c)
{
    double d = sqrt(b * b - 4 * a * c);
    return {(-b + d) / (2 * a), (-b - d) / (2 * a)};
}

int main()
{
    /**
    long long sum = 0;
    for (long long i = 1; i <= 199; i++) {
        if (i % 3 == 0) {
            sum -= i * i;;
        } else {
            sum += i * i;
        }
    }
    vector<bool> isPrime = sieve(199 * 199);
    int primeSum = 0;
    for (int i = 2; i <= ceil(sqrt(sum)); i++) {
        if (isPrime[i] && sum % i == 0) {
            primeSum += i;
        }
    }
    cout << primeSum;
    */

    double val = (M_PI) / (double)(M_PI / (double)5 + 3 * M_PI / (double)5 + M_PI);
    cout << M_PI / (double)5 + 3 * M_PI / (double)5 + M_PI << "\n";
    double n = 1;
    while (val * n != round(val * n))
    {
        n++;
    }
    double m = val * n;
    cout << n << " " << m << "\n";
    cout << "m / n = " << m / n;
}