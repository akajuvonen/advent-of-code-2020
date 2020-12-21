(ns advent-of-code.core
  (:require [advent-of-code.day01]
            [advent-of-code.day02]
            [advent-of-code.day04]
            [advent-of-code.day05]
            [advent-of-code.day06])
  (:gen-class))

(def input-day1 "inputs/day01.txt")
(def input-day2 "inputs/day02.txt")
(def input-day4 "inputs/day04.txt")
(def input-day5 "inputs/day05.txt")
(def input-day6 "inputs/day06.txt")

(defn -main
  "Advent of code solutions."
  []
  (println "Day 1")
  (println "Part 1")
  (println (advent-of-code.day01/part1 input-day1))
  (println "Part 2")
  (println (advent-of-code.day01/part2 input-day1))
  (println "Day 2")
  (println "Part 1")
  (println (advent-of-code.day02/part1 input-day2))
  (println "Part 2")
  (println (advent-of-code.day02/part2 input-day2))
  (println "Day 4")
  (println "Part 1")
  (println (advent-of-code.day04/part1 input-day4))
  (println "Part 2")
  (println (advent-of-code.day04/part2 input-day4))
  (println "Day 5")
  (println "Part 1")
  (println (advent-of-code.day05/part1 input-day5))
  (println "Part 2")
  (println (advent-of-code.day05/part2 input-day5))
  (println "Day 6")
  (println "Part 1")
  (println (advent-of-code.day06/part1 input-day6))
  (println "Part 2")
  (println (advent-of-code.day06/part2 input-day6)))
  