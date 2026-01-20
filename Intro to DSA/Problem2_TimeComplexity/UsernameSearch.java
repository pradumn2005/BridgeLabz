import java.util.Arrays;
import java.util.HashSet;

public class UsernameSearch {
    public static void main(String[] args) {
        String[] users = {"alice", "bob", "charlie", "david", "eve"};
        String target = "david";

        System.out.println("Linear Search Found: " + findUsernameLinear(users, target));
        
        // Data must be sorted for Binary Search
        Arrays.sort(users);
        System.out.println("Binary Search Found: " + findUsernameBinary(users, target));
        
        // Hash Search
        HashSet<String> userSet = new HashSet<>(Arrays.asList(users));
        System.out.println("Hash Search Found: " + findUsernameHash(userSet, target));
    }

    // Algorithm A: Linear Search
    public static boolean findUsernameLinear(String[] userList, String targetUsername) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].equals(targetUsername)) {
                return true;
            }
        }
        return false;
    }

    // Algorithm B: Binary Search
    public static boolean findUsernameBinary(String[] sortedUserList, String targetUsername) {
        int left = 0;
        int right = sortedUserList.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = sortedUserList[mid].compareTo(targetUsername);
            
            if (res == 0) {
                return true;
            } else if (res < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Algorithm C: Hash Table Lookup
    public static boolean findUsernameHash(HashSet<String> hashTable, String targetUsername) {
        return hashTable.contains(targetUsername);
    }
}
