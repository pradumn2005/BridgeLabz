import java.util.List;
import java.util.Arrays;

public class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public static void processResumes(List<? extends JobRole> pipeline) {
        System.out.println("--- Starting AI Resume Screening Pipeline ---");
        for (JobRole role : pipeline) {
            System.out.println("Processing resume for role: " + role.getRoleName());
        }
        System.out.println("--- Screening Complete ---");
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager());

        List<SoftwareEngineer> sePipeline = Arrays.asList(new SoftwareEngineer(), new SoftwareEngineer());
        List<DataScientist> dsPipeline = Arrays.asList(new DataScientist());

        List<JobRole> mixedPipeline = Arrays.asList(
            new SoftwareEngineer(), 
            new DataScientist(), 
            new ProductManager()
        );

        System.out.println("Screening SE Resumes:");
        processResumes(sePipeline);

        System.out.println("\nScreening DS Resumes:");
        processResumes(dsPipeline);

        System.out.println("\nScreening Mixed Resumes:");
        processResumes(mixedPipeline);
    }
}
