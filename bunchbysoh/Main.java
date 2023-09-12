package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
   // Rated capacity of a new battery
        int ratedCapacity = 120;

        // Iterate through present capacities
        for (int presentCapacity : presentCapacities) {
            // Calculate SoH
            double soh = (presentCapacity / (double) ratedCapacity) * 100;

            // Classify batteries
            if (soh > 80) {
                counts.healthy++;
            } else if (soh >= 63 && soh <= 80) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 72};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
