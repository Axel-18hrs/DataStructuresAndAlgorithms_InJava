package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 \\\* @author Axel
 */
public class Stopwatch {
    private long startTime;
public void reset() {
            startTime = 0;
        }
        public void start() {
            startTime = System.currentTimeMillis();
        }

        public long stop() {
            return System.currentTimeMillis() - startTime;   
        }
}
