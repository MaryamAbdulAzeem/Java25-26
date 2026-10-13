# Lab 10 – JavaFX Basics: Text & Shapes

Two JavaFX GUI programs practicing scenes, layouts, text styling and drawing basic shapes.

## 1. Five Random Texts
Displays five texts stacked vertically, each in Times New Roman (bold, italic, 27px) with a **random colour and opacity** that changes every time the program runs.

![Five texts](five-texts.png)

## 2. UAE Flag
Draws the United Arab Emirates flag using JavaFX `Rectangle` and `Color` classes, following the official flag guidelines for proportions and colours. All rectangle positions and sizes are calculated from the chosen flag height, so the flag scales correctly (e.g. heights of 90 and 180).

![UAE flag](uae-flag.png)

**Concepts:** JavaFX `Application`, `Stage` and `Scene`, `VBox` and `Pane` layouts, `Text` and `Font`, `Rectangle`, `Color`, random colour generation

## Running
Requires the JavaFX SDK. If you're using a modular JavaFX project (for example, IntelliJ's JavaFX template), add your project's package declaration as the first line of each file, e.g.:

`package com.example.demo;`

