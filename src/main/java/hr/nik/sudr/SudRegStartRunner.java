package hr.nik.sudr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SudRegStartRunner implements CommandLineRunner {

    private final SudRegManager sudRegManager;

    public SudRegStartRunner(SudRegManager sudRegManager) {
        this.sudRegManager = sudRegManager;
    }

    @Override
    public void run(String... args) throws Exception {
        sudRegManager.downloadAndInsertAll();
    }
}
