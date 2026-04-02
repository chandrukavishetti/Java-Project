package com.chandru.OCP.Education_LMS.test;

import com.chandru.OCP.Education_LMS.model.*;

public class LMSTest {

    public static void main(String[] args) {

        InputHandler input = new InputHandler();
        ContentRenderer renderer = new ContentRenderer();

        while (true) {
            System.out.println("\n1. Video");
            System.out.println("2. Article");
            System.out.println("3. Quiz");
            System.out.println("4. Exit");

            int choice = input.getInt("Enter choice: ");

            Content content = null;

            switch (choice) {

                case 1:
                    String vTitle = input.getString("Enter video title: ");
                    int duration = input.getInt("Enter duration (mins): ");
                    content = new VideoContent(vTitle, duration);
                    break;

                case 2:
                    String aTitle = input.getString("Enter article title: ");
                    String author = input.getString("Enter author name: ");
                    content = new ArticleContent(aTitle, author);
                    break;

                case 3:
                    String qTitle = input.getString("Enter quiz title: ");
                    int questions = input.getInt("Enter number of questions: ");
                    content = new QuizContent(qTitle, questions);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }

            if (content != null) {
                renderer.renderContent(content);
            }
        }
    }
}