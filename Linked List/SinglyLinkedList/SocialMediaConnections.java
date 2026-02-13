class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int id) {
        this.friendId = id;
    }
}

class UserNode {
    int userId;
    String name;
    FriendNode friendsHead;
    UserNode next;

    public UserNode(int id, String name) {
        this.userId = id;
        this.name = name;
    }

    public void addFriend(int friendId) {
        FriendNode newNode = new FriendNode(friendId);
        newNode.next = friendsHead;
        friendsHead = newNode;
    }
}

public class SocialMediaConnections {
    UserNode head;

    public void addUser(int id, String name) {
        UserNode newNode = new UserNode(id, name);
        newNode.next = head;
        head = newNode;
    }

    public void addConnection(int userId1, int userId2) {
        UserNode u1 = findUser(userId1);
        UserNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            u1.addFriend(userId2);
            u2.addFriend(userId1);
        }
    }

    public UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void displayFriends(int userId) {
        UserNode u = findUser(userId);
        if (u != null) {
            System.out.print("Friends of " + u.name + ": ");
            FriendNode f = u.friendsHead;
            while (f != null) {
                System.out.print(f.friendId + " ");
                f = f.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections sm = new SocialMediaConnections();
        sm.addUser(1, "Alice");
        sm.addUser(2, "Bob");
        sm.addUser(3, "Charlie");
        sm.addConnection(1, 2);
        sm.addConnection(1, 3);
        sm.displayFriends(1);
    }
}
