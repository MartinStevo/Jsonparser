import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<User> users = new ArrayList<>();

        try {

            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Hawkeye\\Desktop\\ortoped.json"));

            // convert JSON array to list of users
            users = new Gson().fromJson(reader, new TypeToken<List<User>>() {
            }.getType());

            // print map entries
            users.forEach(user -> {

                int temp = 0;
                int temp2 = 0;
                String temp_titul = "";
                String temp_meno = "";
                String temp_surname = "";

                String whole_name = "";
                whole_name = user.getMeno().split(" -")[0];
                user.setMeno(whole_name);

                String[] names = user.Meno.split("\\s+");
                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                    if (i == 0) {
                        temp_titul = temp_titul.concat(name);
                    } else if (i == 1 && (name.contains("Prof") || name.contains("MUDr") || name.contains("Mgr"))) {
                        temp_titul = temp_titul.concat(" " + name);
                    } else {
                        if (temp == 0) {
                            temp++;
                            temp_meno = temp_meno.concat(name);
                        } else {
                            if (temp2 == 0) {
                                temp2++;
                                temp_surname = temp_surname.concat(name);
                            } else {
                                temp_surname = temp_surname.concat(" " + name);
                            }
                        }
                    }
                }
                user.setMeno(temp_titul + " " + temp_meno);
                user.setPriezvisko(temp_surname);
                System.out.println("-" + temp_titul + "-");

                String temp_adresa = "";
                temp_adresa = user.getAdresa() + ", " + user.getPSC() + " " + user.getMesto();
                user.setAdresa(temp_adresa);

                switch (user.getRegion()) {
                    case "Bratislavský kraj":
                        user.setRegion("BA");
                        break;
                    case "Trnavský kraj":
                        user.setRegion("TT");
                        break;
                    case "Trenčiansky kraj":
                        user.setRegion("TN");
                        break;
                    case "Nitriansky kraj":
                        user.setRegion("NR");
                        break;
                    case "Žilinský kraj":
                        user.setRegion("ZA");
                        break;
                    case "Banskobystrický kraj":
                        user.setRegion("BB");
                        break;
                    case "Prešovský kraj":
                        user.setRegion("PO");
                        break;
                    case "Košický kraj":
                        user.setRegion("KE");
                        break;
                }

                if (user.getMobil() != null) {
                    String temp_mobil = "";
                    temp_mobil = user.getMobil().split("\n")[0];
                    user.setMobil(temp_mobil);
                }

                if (user.getTel() != null) {
                    String temp_tel = "";
                    temp_tel = user.getTel().split("\n")[0];
                    user.setTel(temp_tel);
                }

            });

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        //gson.toJson(users, new FileWriter("C:\\Users\\Hawkeye\\Desktop\\temp.json"));
        String s = gson.toJson(users);

        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Hawkeye\\Desktop\\output.json");
            myWriter.write(s);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
