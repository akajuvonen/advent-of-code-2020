(ns advent-of-code.core
  (:require [advent-of-code.day01]
            [advent-of-code.day02]
            [advent-of-code.day04]
            [advent-of-code.day05]
            [advent-of-code.day06]
            [advent-of-code.day07]
            [advent-of-code.day13])
  (:gen-class))

(def input-day1 "inputs/day01.txt")
(def input-day2 "inputs/day02.txt")
(def input-day4 "inputs/day04.txt")
(def input-day5 "inputs/day05.txt")
(def input-day6 "inputs/day06.txt")
(def input-day7 "inputs/day07.txt")
(def input-day13 "inputs/day13.txt")

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
  (println (advent-of-code.day06/part2 input-day6))
  (println "Day 7")
  (println "Part 1")
  (println (advent-of-code.day07/part1 input-day7))
  (println "Day 13")
  (println "Part 1")
  (println (advent-of-code.day13/part1 input-day13))
  (println "Part 2")
  (println (advent-of-code.day13/part2 input-day13)))
  