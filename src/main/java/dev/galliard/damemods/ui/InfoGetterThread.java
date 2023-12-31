package dev.galliard.damemods.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class InfoGetterThread implements Runnable {
    @Override
    public void run() {
        try {
            Document document = Jsoup.connect("https://galliard.dev/server.html").get();

            // Obtener el nombre del modpack
            Elements nameElements = document.select("p.name");
            String name = nameElements.isEmpty() ? "No disponible" : nameElements.first().text();
            UIDameMods.serverLabel.setText(UIDameMods.serverLabel.getText().replace("X", name));

            // Obtener la versión del modpack
            Elements versionElements = document.select("p.version");
            String version = versionElements.isEmpty() ? "null" : versionElements.first().text();

            UIDameMods.versionWeightLabel.setText(UIDameMods.versionWeightLabel.getText().replace("Y", version).replace("Z", new DecimalFormat("#.##").format(calcularPeso()) + " MB"));


        } catch (IOException e) {
            e.printStackTrace();
            // Manejar cualquier error de conexión o análisis HTML
            UIDameMods.serverLabel.setText("No disponible");
            UIDameMods.versionWeightLabel.setText(UIDameMods.versionWeightLabel.getText().replace("Y", "null").replace("Z", "null"));
        }
    }

    public static double calcularPeso() throws IOException {
        String apiUrl = "https://api.github.com/repos/GalliardDev/DameMods/releases/latest";
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            JsonElement root = JsonParser.parseReader(reader);
            JsonObject release = root.getAsJsonObject();
            JsonArray assets = release.getAsJsonArray("assets");

            if (assets != null && assets.size() > 0) {
                long totalSize = 0;

                for (JsonElement asset : assets) {
                    JsonObject assetObject = asset.getAsJsonObject();
                    JsonPrimitive sizePrimitive = assetObject.getAsJsonPrimitive("size");

                    if (sizePrimitive != null) {
                        totalSize += sizePrimitive.getAsLong();
                    }
                }

                return totalSize / (1024.0 * 1024.0);
            } else {
                throw new IOException("No hay activos disponibles en la release");
            }
        }
    }
}
