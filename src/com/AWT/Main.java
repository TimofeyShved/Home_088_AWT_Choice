package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main() { // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args) {
        Main myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showChoiceDemo(); // и вызываемый метод showListDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Choice");  // инициализация фрэйма
        mainFrame.setSize(400, 400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent) { // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350, 100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в Choice
    private void showChoiceDemo() {

        headerLabel.setText("Контрол в действии: Choice");
        final Choice fruitChoice = new Choice();

        fruitChoice.add("Яблоко"); // добавление объектов в Choice
        fruitChoice.add("Курага");
        fruitChoice.add("Манго");
        fruitChoice.add("Банан");

        Button showButton = new Button("Показать"); // конпка

        showButton.addActionListener(new ActionListener() { // действие
            public void actionPerformed(ActionEvent e) {
                String data = "Выбранный фрукт: "
                        + fruitChoice.getItem(fruitChoice.getSelectedIndex());
                statusLabel.setText(data); // метка статуса
            }
        });

        // добавление объектов на форму
        controlPanel.add(fruitChoice);
        controlPanel.add(showButton);

        // видимость формы true
        mainFrame.setVisible(true);
    }
}