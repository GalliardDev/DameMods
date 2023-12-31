package dev.galliard.damemods.ui;

import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import dev.galliard.damemods.DameMods;

public class DownloaderThread implements Runnable {
    @Override
    public void run() {
        download();
        unzip(DameMods.DOWNLOADS_FOLDER + "/modpack.zip", DameMods.DOWNLOADS_FOLDER);
        copyFoldersAndFiles(DameMods.DOWNLOADS_FOLDER + "/modpack/replace", DameMods.MINECRAFT_FOLDER);
        installForge(DameMods.DOWNLOADS_FOLDER + "/modpack/" + DameMods.FORGE_FOLDER_NAME);

        // Mostrar el diálogo de descarga completada
        JOptionPane.showMessageDialog(UIDameMods.getInstance(), "¡Descarga completada!", "DameMods", JOptionPane.INFORMATION_MESSAGE);

        // Cerrar la aplicación después de cerrar el diálogo
        SwingUtilities.invokeLater(() -> {
            UIDameMods.progressBar1.setValue(0);
            System.exit(0);
        });
    }

    private void download() {
        try {
            URL url = new URI(DameMods.MODPACK).toURL();
            URLConnection connection = url.openConnection();

            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                 FileOutputStream out = new FileOutputStream(DameMods.DOWNLOADS_FOLDER + "/modpack.zip")) {

                byte[] dataBuffer = new byte[1024];
                int totalBytesRead = 0;
                int bytesRead;

                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    out.write(dataBuffer, 0, bytesRead);
                    totalBytesRead += bytesRead;

                    final int progress = (int) (totalBytesRead * 100.0 / connection.getContentLength());
                    SwingUtilities.invokeLater(() -> UIDameMods.progressBar1.setValue(progress));
                }
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void unzip(String zipFilePath, String destDir) {
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zis.getNextEntry();
            long totalBytes = 0;
            long bytesRead = 0;

            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                File newFile = new File(destDir + File.separator + fileName);

                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    File parentDir = new File(newFile.getParent());
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                            bytesRead += len;
                            final int progress = (int) (bytesRead * 100.0 / zipEntry.getSize());
                            SwingUtilities.invokeLater(() -> UIDameMods.progressBar1.setValue(progress));
                        }
                    }
                }

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void copyFoldersAndFiles(String source, String target) {
        try {
            Path sourcePath = Paths.get(source);
            Path targetPath = Paths.get(target);
            long totalBytes = Files.walk(sourcePath).mapToLong(p -> p.toFile().length()).sum();
            long bytesRead = 0;

            for (Path path : Files.walk(sourcePath).toArray(Path[]::new)) {
                Path relativePath = sourcePath.relativize(path);
                Path destination = targetPath.resolve(relativePath);

                if (Files.isDirectory(path)) {
                    Files.createDirectories(destination);
                } else {
                    Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);
                    bytesRead += Files.size(path);
                    final int progress = (int) (bytesRead * 100.0 / totalBytes);
                    SwingUtilities.invokeLater(() -> UIDameMods.progressBar1.setValue(progress));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void installForge(String source) {
        try {
            Path versionsPath = Paths.get(DameMods.MINECRAFT_FOLDER, "versions", DameMods.FORGE_FOLDER_NAME);
            long totalBytes = Files.walk(Path.of(source)).mapToLong(p -> p.toFile().length()).sum();
            long bytesRead = 0;

            if (!Files.exists(versionsPath)) {
                Files.createDirectories(versionsPath);
            }

            for (Path path : Files.walk(Path.of(source)).toArray(Path[]::new)) {
                Path relativePath = Paths.get(source).relativize(path);
                Path destination = versionsPath.resolve(relativePath);

                if (Files.isDirectory(path)) {
                    Files.createDirectories(destination);
                } else {
                    Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);
                    bytesRead += Files.size(path);
                    final int progress = (int) (bytesRead * 100.0 / totalBytes);
                    SwingUtilities.invokeLater(() -> UIDameMods.progressBar1.setValue(progress));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
