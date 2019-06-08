#include <bits/stdc++.h>

using namespace std;

long long dp[10001];
long long discount[] = {1, 2, 4, 4, 4, 4};
vector<long long> duration(10001), cost(10001);

long long getMinCost(int index) {
  if (index >= int(duration.size())) return 0;

  if (dp[index] != -1) return dp[index];

  long long minCost = LLONG_MAX;
  long long partialCost = 0;
  long long partialDuration = 0;

  for (int i = 0; partialDuration < 120 && i < 6 &&
                  (index + i) < int(duration.size())
                ; i++) {
    partialCost += cost[index + i]*100/discount[i];
    minCost = min(minCost, partialCost + getMinCost(index + i + 1));

    partialDuration += duration[index + i];
  }
  dp[index] = minCost;
  return minCost;
}

int main() {

  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> duration[i] >> cost[i];
  }

  memset(dp, -1, sizeof dp);
  long long minCost = getMinCost(0);
  double resp = (double) minCost/100;
  cout << std::fixed;
  cout << std::setprecision(2);
  cout << resp << endl;
  return 0;
}
