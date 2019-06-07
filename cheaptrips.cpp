#include <bits/stdc++.h>

using namespace std;

long long dp[11234];
long long discount[] = {1, 2, 4, 4, 4, 4};

long long getMinCost(vector<long long> &duration, vector<long long> &cost, int id) {
  if (id >= int(duration.size())) return 0;

  if (dp[id] != -1) return dp[id];

  long long minCost = LLONG_MAX;
  long long partialCost = 0;
  long long partialDuration = 0;

  for (int i = 0; partialDuration < 120 && i < 6 &&
                  (id + i) < int(duration.size())
                ; i++) {
    partialCost += cost[id + i]*100/discount[i];
    minCost = min(minCost, partialCost + getMinCost(duration, cost, id + i + 1));

    partialDuration += duration[id + i];
  }
  dp[id] = minCost;
  return minCost;
}

int main() {

  int n;
  cin >> n;
  vector<long long> duration(n), cost(n);
  for (int i = 0; i < n; i++) {
    cin >> duration[i] >> cost[i];
  }

  memset(dp, -1, sizeof dp);
  long long minCost = getMinCost(duration, cost, 0);
  double resp = (double) minCost/100;
  cout << std::fixed;
  cout << std::setprecision(2);
  cout << resp << endl;
  return 0;
}
