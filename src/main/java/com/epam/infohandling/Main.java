package com.epam.infohandling;

public class Main {
    public static void main(String[] args) {
        String test = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.        \n" +
                "            It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English.\n" +
                "            It is a established fact that a reader will be of a page when looking at its layout.\n" +
                "            Bye.\n";
        String[] paragraphs = test.split("\n");
        for (int i = 0; i < paragraphs.length; i++) {
            String s = paragraphs[i];
            paragraphs[i] = s.trim();
        }
        String second = paragraphs[1];
        System.out.println(second);
        String[] sentences = second.split("\\. ");
        for (String s : sentences) {
            System.out.println(s);
        }
        String secondSentence = sentences[1];
        String[] words = secondSentence.split(" ");
        for (String s : words) {
            System.out.println(s);
        }
    }
}
