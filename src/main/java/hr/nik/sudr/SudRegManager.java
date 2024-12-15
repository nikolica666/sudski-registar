package hr.nik.sudr;

import hr.nik.sudr.web.client.SudRegClient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SudRegManager {

    private List<String> resources = Arrays.asList("/postupci");
    private List<String> resources2 = Arrays.asList(
            "/postupci",
            "/tvrtke",
            "/skracene_tvrtke",
            "/prijevodi_tvrtki",
            "/prijevodi_skracenih_tvrtki",
            "/inozemni_registri",
            "/sjedista",
            "/email_adrese",
            "/pravni_oblici",
            "/pretezite_djelatnosti",
            "/predmeti_poslovanja",
            "/evidencijske_djelatnosti",
            "/temeljni_kapitali",
            "/nazivi_podruznica",
            "/skraceni_nazivi_podruznica",
            "/sjedista_podruznica",
            "/email_adrese_podruznica",
            "/djelatnosti_podruznica",
            "/objave_priopcenja",
            "/gfi",
            "/promjene",
            "/subjekti",
            "/counts",
            "/snapshots",
            "/bris_pravni_oblici",
            "/bris_registri",
            "/drzave",
            "/jezici",
            "/nacionalna_klasifikacija_djelatnosti",
            "/statusi",
            "/sudovi",
            "/valute",
            "/vrste_gfi_dokumenata",
            "/vrste_postupaka",
            "/vrste_pravnih_oblika",
            "/detalji_subjekta");

    private final SudRegClient sudRegClient;

    public SudRegManager(SudRegClient sudrClient) {
        this.sudRegClient = sudrClient;
    }

    public void downloadAndInsertAll() {
        long mili = System.currentTimeMillis();
        for (String resource : resources) {
            downloadAndInsert(resource);
        }
        System.out.println("downloaded resources in " + (System.currentTimeMillis() - mili) + "ms");
    }

    public void downloadAndInsert(String resource) {
        long mili = System.currentTimeMillis();
        String responseEntity = sudRegClient.callOAuthService(resource);
        System.out.println("downloaded " + resource + " in " + (System.currentTimeMillis() - mili) + "ms");
        System.out.println(responseEntity);
    }
}
