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

(defn- pad-int-string
  "Pad string x if just one digit, e.g., 1 -> 01.
   Always return string."
  [x]
  (if (<= (count x) 1)
    (str 0 x)
    x))

(defn gen-func
  [day part]
  (str "advent-of-code.day" day "/part" part))

(defn gen-input
  [day]
  (str "inputs/day" day ".txt"))

(defn run-day-part
  "Run advent of code day `day` part `part` (1 or 2)."
  [day part]
  ((resolve (symbol (gen-func day part))) (gen-input day)))

(defn -main
  "Advent of code solutions."
  [day part]
  (println (str "Day " day ", part " part ":"))
  (println (run-day-part day part)))
  