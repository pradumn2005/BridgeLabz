class Course {
    String courseName;
    int duration;
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
}

class PaidOnlineCourse extends OnlineCourse {
    int fee;
    int discount;
}

public class Main7 {
    public static void main(String[] args) {
        PaidOnlineCourse p=new PaidOnlineCourse();
        p.courseName="Java"; p.duration=30; p.platform="Udemy"; p.isRecorded=true; p.fee=2000; p.discount=10;
        System.out.println(p.courseName+" "+p.platform+" "+p.fee);
    }
}
