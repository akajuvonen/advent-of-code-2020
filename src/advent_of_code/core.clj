(ns advent-of-code.core
  (:require [advent-of-code.day01]
            [advent-of-code.day02]
            [advent-of-code.day03])
  (:gen-class))

(def input-day1 "inputs/day01.txt")
(def input-day2 "inputs/day02.txt")
(def input-day3 "inputs/day03.txt")

(defn -main
  "Advent of code solutions."
  []
  (println "Day 1")
  (println "Part 1")
  (println (advent-of-code.day01/part1 (slurp input-day1)))
  (println "Part 2")
  (println (advent-of-code.day01/part2 (slurp input-day1)))
  (println "Day 2")
  (println "Part 1")
  (println (advent-of-code.day02/part1 (slurp input-day2)))
  (println "Part 2")
  (println (advent-of-code.day02/part2 (slurp input-day2)))
  (println "Day 4")
  (println (advent-of-code.day03/part1 input-day3)))
