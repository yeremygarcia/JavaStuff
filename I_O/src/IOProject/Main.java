package IOProject;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.nio.file.attribute.FileTime;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory (For example C:\\Users\\yourComputerName\\Downloads)");
        String inputPath = scanner.nextLine();

        try {
            Path dirPath = Paths.get(inputPath);
            if (!Files.isDirectory(dirPath)) {
                System.out.println("Invalid, not a directory path.");
                return;
            }

            boolean exit = false;

            while (!exit) {
                System.out.println("File Manager Menu:");
                System.out.println("1. Display directory contents");
                System.out.println("2. Copy file");
                System.out.println("3. Move file");
                System.out.println("4. Delete file");
                System.out.println("5. Create directory");
                System.out.println("6. Delete directory");
                System.out.println("7. Search files by name or extension");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();


                switch (choice) {
                    case 1:
                        displayDirectoryContents(dirPath);
                        break;
                    case 2:
                        String sourceFilePath = getInput(scanner, "Enter source file path: ");
                        String targetFilePath = getInput(scanner, "Enter destination file path: ");
                        copyFile(sourceFilePath, targetFilePath);
                        break;
                    case 3:
                        String sourcePath = getInput(scanner, "Enter source file path: ");
                        String targetPath = getInput(scanner, "Enter destination file path: ");
                        moveFile(sourcePath, targetPath);
                        break;
                    case 4:
                        String filePathToDelete = getInput(scanner, "Enter file path to delete: ");
                        deleteFile(filePathToDelete);
                        break;
                    case 5:
                        String directoryPathToCreate = getInput(scanner, "Enter directory path to create: ");
                        createDirectory(directoryPathToCreate);
                        break;
                    case 6:
                        String directoryPathToDelete = getInput(scanner, "Enter directory path to delete: ");
                        deleteDirectory(directoryPathToDelete);
                        break;
                    case 7:
                        String searchQuery = getInput(scanner, "Enter search query (case sensitive on purpose!): ");
                        searchFilesByName(dirPath, searchQuery);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            System.out.println("Exiting File Manager. Goodbye!");
        } catch (InvalidPathException e) {
            System.out.println("Invalid directory path: " + inputPath);
        } finally {
            scanner.close();
        }
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void displayDirectoryContents(Path directoryPath) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                String fileName = path.getFileName().toString();
                long fileSize = attributes.size();
                FileTime creationTime = attributes.creationTime();
                long creationTimeMillis = creationTime.toInstant().toEpochMilli();
                String formattedCreationTime = creationTime.toString();
                System.out.println("File: " + fileName + " | Size: " + fileSize + " bytes | Last Modified: " + formattedCreationTime);
            }
        } catch (IOException e) {
            System.out.println("Error displaying the directory contents: " + e.getMessage());
        }
    }

    private static void copyFile(String sourceFilePath, String targetFilePath) {
        try {
            Path sourcePath = Paths.get(sourceFilePath);
            Path targetPath = Paths.get(targetFilePath);
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying the file: " + e.getMessage());
        }
    }

    private static void moveFile(String sourceFilePath, String targetFilePath) {
        try {
            Path sourcePath = Paths.get(sourceFilePath);
            Path targetPath = Paths.get(targetFilePath);
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully.");
        } catch (IOException e) {
            System.out.println("Error moving the file: " + e.getMessage());
        }
    }


    private static void deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.delete(path);
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error deleting the file: " + e.getMessage());
        }
    }

    private static void createDirectory(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            Files.createDirectory(path);
            System.out.println("Directory created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating the directory: " + e.getMessage());
        }
    }

    private static void deleteDirectory(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            Files.delete(path);
            System.out.println("The Directory has been deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error deleting the directory: " + e.getMessage());
        }
    }

    private static void searchFilesByName(Path directoryPath, String searchQuery) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            System.out.println("Search Results:");
            for (Path inside : stream) {
                String fileName = inside.getFileName().toString();
                if (fileName.contains(searchQuery)) {
                    System.out.println(inside);
                }
            }
        } catch (IOException e) {
            System.out.println("Error searching the files: " + e.getMessage());
        }
    }
}