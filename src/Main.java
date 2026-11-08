import service.MedicalTestSerive;
import domain.MedicalTest;
import domain.Status;
import repository.MedicalTestRepository;
import service.MedicalTestSerive;
import ui.UI;

public class Main{
    public static void main(String[] args) {
        MedicalTestRepository<MedicalTest> repo = new MedicalTestRepository<>();
        MedicalTestSerive service = new MedicalTestSerive(repo);

        if (service.isEmpty()) {
            service.addBMI("2026.03.15", Status.DONE, 23.5);
            service.addBP("2026.01.09", Status.DONE, 120, 80);
            service.addBP("2026.01.08", Status.IN_PROGRESS, 130, 80);
        }


        new UI(service).run();
    }
}