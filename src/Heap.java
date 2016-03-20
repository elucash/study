
// peek: O(1)
// size: O(1)
// insert: O(log(n))
// poll: O(log(n))
// find, remove: O(n)

class Heap {

  public static void main(String[] args) {
    Hp hp = new Hp();
    hp.randomize();
    hp.verify();
  }

  static class Hp {
    long[] q = new long[1 << 6];
    int size;

    void randomize() {
      java.util.Random r = new java.util.Random();
      long prev = Integer.MAX_VALUE;
      for (int i = 0; i < 10; i++) {
        add(r.nextInt(20));
        if (prev < q[0]) {
          throw new IllegalStateException("&&" + prev + "\n\t" + java.util.Arrays.toString(java.util.Arrays.copyOf(q, size)));
        }
        prev = q[0];
        System.out.println(java.util.Arrays.toString(java.util.Arrays.copyOf(q, size)));
      }
    }

    void verify() {
      long prev = -1;
      int ok = 0;
      while(size > 0) {
        long v = remove();
        if (prev > v) {
          throw new IllegalStateException("!!" + ok);
        }
        ok++;
        prev = v;
      }
    }

    void add(long v) {
      int p = size++;
      q[p] = v;
      bubbleUp(p);
    }

    long remove() {
      long v = q[0];
      q[0] = q[--size];
      bubbleDown(0);
      return v;
    }

    void bubbleDown(int p) {
      for (;;) {
        int c = smallestChild(p);
        if (c < 0) return;
        swap(p, c);
        p = c;
      }
    }

    int smallestChild(int p) {
      int lc = leftChildAt(p);
      int rc = rightChildAt(p);

      if (rc > 0) {
        if (q[rc] < q[p] && q[rc] < q[lc]) {
          return rc;
        }
      }
      if (lc > 0) {
        if (q[lc] < q[p]) {
          return lc;
        }
      }
      return -1;
    }

    void bubbleUp(int p) {
      for(;;) {
        int pr = parentAt(p);
        if (pr < 0 || q[pr] <= q[p]) {
          return;
        }
        swap(pr, p);
        p = pr;
      }
    }

    void swap(int a, int b) {
      long t = q[a];
      q[a] = q[b];
      q[b] = t;
    }

    int parentAt(int p) {
      if (p == 0) return -1;
      return (p - 1) / 2;
    }

    int leftChildAt(int p) {
      int c = 2 * p + 1;
      if (c > size - 1) return -1;
      return c;
    }

    int rightChildAt(int p) {
      int c = 2 * p + 2;
      if (c > size - 1) return -1;
      return c;
    }
  }
}
