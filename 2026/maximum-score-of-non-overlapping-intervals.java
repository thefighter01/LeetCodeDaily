class Solution {

      private int j = 0;

      private void compress(List<List<Integer>> intervals) {
          int n = intervals.size();
          int[] list = new int[2 * n];
          j = 0;
          for (List<Integer> interval : intervals) {
              list[j++] = interval.get(0);
              list[j++] = interval.get(1);
          }
          Arrays.sort(list);
          Map<Integer, Integer> mp = new HashMap<>();
          j = 0;
          for (int v : list) {
              if (!mp.containsKey(v)) mp.put(v, ++j);
          }
          for (List<Integer> interval : intervals) {
              interval.set(0, mp.get(interval.get(0)));
              interval.set(1, mp.get(interval.get(1)));
          }
      }

      public int[] maximumWeight(List<List<Integer>> intervals) {
          int n = intervals.size();
          compress(intervals);
          int C = j;

          // val[sz][pos] + picks[sz][pos]: best chain of exactly sz intervals
          // whose first interval starts at coordinate >= pos.
          // picks == null means "no such chain".
          long[][] val = new long[5][C + 2];
          int[][][] picks = new int[5][C + 2][];

       
          for (int i = 0; i < n; i++) {
              int L = intervals.get(i).get(0);
              long w = intervals.get(i).get(2);
              int[] cand = {i};
              if (picks[1][L] == null || w > val[1][L]
                     ) {
                  val[1][L] = w;
                  picks[1][L] = cand;
              }
          }
          suffixSweep(val[1], picks[1], C);

          // layers 2..4
          for (int sz = 2; sz <= 4; sz++) {
              for (int i = 0; i < n; i++) {
                  int L = intervals.get(i).get(0);
                  int R = intervals.get(i).get(1);
                  long w = intervals.get(i).get(2);

                  if (picks[sz - 1][R + 1] == null) continue;   // no (sz-1)-chain after R

                  long v = w + val[sz - 1][R + 1];
                  int[] p = insertSorted(picks[sz - 1][R + 1], i);

                  if (picks[sz][L] == null || v > val[sz][L]
                          || (v == val[sz][L] && lexLess(p, picks[sz][L]))) {
                      val[sz][L] = v;
                      picks[sz][L] = p;
                  }
              }
              suffixSweep(val[sz], picks[sz], C);
          }

          // best over sz = 1..4 (fewer intervals may beat more)
          long bestV = -1;
          int[] bestP = new int[0];
          for (int sz = 1; sz <= 4; sz++) {
              if (picks[sz][1] == null) continue;
              if (val[sz][1] > bestV
                      || (val[sz][1] == bestV && lexLess(picks[sz][1], bestP))) {
                  bestV = val[sz][1];
                  bestP = picks[sz][1];
              }
          }
          return bestP;
      }

     private void suffixSweep(long[] val, int[][] picks, int C) {
          for (int k = C; k >= 1; k--) {
              if (picks[k + 1] == null) continue;
              if (picks[k] == null || val[k + 1] > val[k]
                || (val[k + 1] == val[k] && lexLess(picks[k + 1], picks[k]))) {

                  val[k] = val[k + 1];
                  picks[k] = picks[k + 1];
              }
          }
      }

      
      private int[] insertSorted(int[] a, int x) {
          int[] res = new int[a.length + 1];
          int i = 0;
          while (i < a.length && a[i] < x) { res[i] = a[i]; i++; }
          res[i] = x;
          for (; i < a.length; i++) res[i + 1] = a[i];
          return res;
      }

      private boolean lexLess(int[] a, int[] b) {
          int m = Math.min(a.length, b.length);
          for (int i = 0; i < m; i++) {
              if (a[i] != b[i]) return a[i] < b[i];
          }
          return a.length < b.length;
      }
    } 